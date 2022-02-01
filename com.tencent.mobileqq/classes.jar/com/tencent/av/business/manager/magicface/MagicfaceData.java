package com.tencent.av.business.manager.magicface;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.util.JSONUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MagicfaceData
{
  protected String p;
  protected String q;
  protected MagicfaceDataVideoJason r;
  protected MagicfaceDataAudioJason s;
  protected Map<String, MagicfaceDataPendantJason> t;
  protected Rect u;
  protected int v;
  protected int w;
  
  public MagicfaceData(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init|config=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString1);
    AVLog.printColorLog("AVMagicfaceData", ((StringBuilder)localObject).toString());
    this.p = paramString2;
    this.q = paramString3;
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = paramString1.getJSONObject("video");
      this.r = ((MagicfaceDataVideoJason)JSONUtils.a(paramString2, MagicfaceDataVideoJason.class));
      localObject = this.r;
      int j = 0;
      int i;
      if (localObject != null)
      {
        if (!"voicesticker".equals(paramString3))
        {
          if (this.r.location_x > 0)
          {
            paramString3 = this.r;
            paramString3.location_x *= 2;
          }
          if (this.r.location_y > 0)
          {
            paramString3 = this.r;
            paramString3.location_y *= 2;
          }
          if (this.r.width > 0)
          {
            paramString3 = this.r;
            paramString3.width *= 2;
          }
          if (this.r.height > 0)
          {
            paramString3 = this.r;
            paramString3.height *= 2;
          }
        }
        paramString2 = paramString2.optJSONArray("locations");
        if (paramString2 != null)
        {
          i = 0;
          while (i < paramString2.length())
          {
            paramString3 = (JSONObject)paramString2.get(i);
            this.r.pointArrayList.add(new Point(paramString3.optInt("x"), paramString3.optInt("y")));
            i += 1;
          }
        }
        this.r.pointArrayList.add(new Point(this.r.location_x, this.r.location_y));
      }
      if (paramString1.has("audio")) {
        this.s = ((MagicfaceDataAudioJason)JSONUtils.a(paramString1.getJSONObject("audio"), MagicfaceDataAudioJason.class));
      }
      this.t = new HashMap();
      if (paramString1.has("pendant"))
      {
        paramString1 = paramString1.getJSONArray("pendant");
        i = j;
        while (i < paramString1.length())
        {
          paramString2 = (MagicfaceDataPendantJason)JSONUtils.a((JSONObject)paramString1.get(i), MagicfaceDataPendantJason.class);
          if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.name)))
          {
            paramString3 = new StringBuilder();
            paramString3.append("Pendant: ");
            paramString3.append(paramString2.toString());
            AVLog.printErrorLog("AVMagicfaceData", paramString3.toString());
            paramString2.duration *= 1000;
            this.t.put(paramString2.name, paramString2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      if (this.r == null)
      {
        AVLog.printErrorLog("AVMagicfaceData", "MagicfaceData error!");
        this.r = new MagicfaceDataVideoJason();
      }
      if (this.s == null) {
        this.s = new MagicfaceDataAudioJason();
      }
      if (this.r.persistent)
      {
        paramString1 = this.r;
        paramString1.repeat_count = 50000;
        if (paramString1.frame_count == 0) {
          this.r.frame_count = 3;
        }
        this.s.is_repeat = true;
      }
      paramString1 = new StringBuilder();
      paramString1.append("MagicfaceData:: ");
      paramString1.append(this.r.toString());
      AVLog.printErrorLog("AVMagicfaceData", paramString1.toString());
      this.v = this.r.frame_count;
      paramString1 = this.r.getLocation(-1);
      this.u = new Rect(paramString1.x, paramString1.y, paramString1.x + this.r.width, paramString1.y + this.r.height);
    }
  }
  
  abstract String a(int paramInt);
  
  protected abstract void a();
  
  protected abstract void a(int paramInt1, int paramInt2);
  
  public boolean a(MagicfaceData paramMagicfaceData)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMagicfaceData != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.q)) {
        if ((!TextUtils.isEmpty(paramMagicfaceData.q)) && (!paramMagicfaceData.q.equalsIgnoreCase("face")))
        {
          bool1 = bool2;
          if (!paramMagicfaceData.q.equalsIgnoreCase("voicesticker")) {}
        }
        else
        {
          bool1 = bool2;
          if (this.q.equalsIgnoreCase("pendant")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected abstract void b();
  
  protected abstract int d();
  
  int e(int paramInt)
  {
    Object localObject = this.r;
    if (localObject == null) {
      return paramInt;
    }
    localObject = ((MagicfaceDataVideoJason)localObject).getLocation(paramInt);
    this.u = new Rect(((Point)localObject).x, ((Point)localObject).y, ((Point)localObject).x + this.r.width, ((Point)localObject).y + this.r.height);
    return this.r.lastLocationIndex;
  }
  
  public String i()
  {
    return this.p;
  }
  
  public boolean j()
  {
    return (this.q.equalsIgnoreCase("face")) || (this.q.equalsIgnoreCase("voicesticker"));
  }
  
  public boolean k()
  {
    return this.q.equalsIgnoreCase("pendant");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.p);
    localStringBuilder.append("], type[");
    localStringBuilder.append(this.q);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceData
 * JD-Core Version:    0.7.0.1
 */