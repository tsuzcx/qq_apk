package com.tencent.av.business.manager.magicface;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.util.JSONUtils;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.json.JSONException;
import org.json.JSONObject;

public class MagicFaceDataEntityMultiResult
  extends MagicFaceDataEntity
{
  protected MagicfaceDataMultiResultJason m;
  Rect n;
  int o;
  
  public MagicFaceDataEntityMultiResult(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramVideoAppInterface, paramString1, paramString2, paramString3, paramBoolean, paramInt);
    boolean bool2 = false;
    this.o = 0;
    try
    {
      paramVideoAppInterface = new JSONObject(paramString3);
      if (paramVideoAppInterface.has("multiresult")) {
        this.m = ((MagicfaceDataMultiResultJason)JSONUtils.a(paramVideoAppInterface.getJSONObject("multiresult"), MagicfaceDataMultiResultJason.class));
      }
    }
    catch (JSONException paramVideoAppInterface)
    {
      paramVideoAppInterface.printStackTrace();
    }
    if (this.m == null) {
      this.m = new MagicfaceDataMultiResultJason();
    }
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append("multi: ");
    paramVideoAppInterface.append(this.m.toString());
    AVLog.printErrorLog("MagicFaceDataEntityMultiResult", paramVideoAppInterface.toString());
    this.n = new Rect(this.m.divers_x, this.m.divers_y, this.m.divers_x + this.m.divers_wid, this.m.divers_y + this.m.divers_hei);
    boolean bool1;
    if ((!paramBoolean) || (!this.i.get(1)))
    {
      bool1 = bool2;
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (!this.i.get(0)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    this.g = bool1;
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", "MagicFaceDataEntityMultiResult constructor:");
  }
  
  private String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason, String paramString)
  {
    String str = paramString;
    if (paramMagicfaceDataPendantJason != null)
    {
      str = paramString;
      if (paramMagicfaceDataPendantJason.mirror)
      {
        str = paramString;
        if (!this.h)
        {
          paramMagicfaceDataPendantJason = new StringBuilder();
          paramMagicfaceDataPendantJason.append(paramString);
          paramMagicfaceDataPendantJason.append("_mirror");
          str = paramMagicfaceDataPendantJason.toString();
        }
      }
    }
    return str;
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 2;
    }
    int k = i * 64 * 2;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > k) && (this.n != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShot:");
      localStringBuilder.append(this.o);
      localStringBuilder.append("|");
      localStringBuilder.append(this.w);
      localStringBuilder.append("|");
      localStringBuilder.append(this.m.divers_ani_start);
      localStringBuilder.append("|");
      localStringBuilder.append(this.n.toString());
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayOfByte.length);
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
      if ((this.o == 0) && (this.w >= this.m.divers_ani_start - 2) && (this.w < this.m.divers_ani_start))
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        int j;
        if (paramBoolean) {
          j = paramArrayOfByte.getInt(k) / 1000000;
        } else {
          j = paramArrayOfByte.getShort(k);
        }
        float f1 = j;
        if (paramBoolean) {
          i = paramArrayOfByte.getInt(k + i) / 1000000;
        } else {
          i = paramArrayOfByte.getShort(k + i);
        }
        float f2 = i;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onReceiveFaceFeature Kill is:|");
        paramArrayOfByte.append(f1);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(f2);
        paramArrayOfByte.append("|");
        paramArrayOfByte.append(this.n.toString());
        AVLog.printColorLog("MagicFaceDataEntityMultiResult", paramArrayOfByte.toString());
        if (this.n.contains((int)f1, (int)f2)) {
          this.o = 1;
        }
      }
    }
    else
    {
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", "isShot ERROR");
    }
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getResultString:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(this.m.divers_ani_start);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return "";
      }
      return this.m.divers_ani_hit;
    }
    return this.m.divers_ani_miss;
  }
  
  private boolean l()
  {
    return (this.i.get(1)) && (!TextUtils.isEmpty(this.r.tips));
  }
  
  private int m()
  {
    int i = this.o;
    if (i != 0)
    {
      if (i != 1) {
        return 0;
      }
      return this.m.divers_ani_hit_frame;
    }
    return this.m.divers_ani_miss_frame;
  }
  
  private String n()
  {
    int i = this.o;
    if (i != 0)
    {
      if (i != 1) {
        return null;
      }
      return "hit";
    }
    return "miss";
  }
  
  public String a(int paramInt)
  {
    if (!TextUtils.isEmpty(this.r.common_id))
    {
      int i = d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getResPath:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(this.m.divers_ani_start);
      localStringBuilder.append("|");
      localStringBuilder.append(i);
      AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
      if ((paramInt >= this.m.divers_ani_start) && (paramInt < i))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.r.common_id);
        localStringBuilder.append("_");
        localStringBuilder.append(b(paramInt, this.o));
        localStringBuilder.append(h());
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.r.common_id);
      localStringBuilder.append(h());
      return localStringBuilder.toString();
    }
    return super.a(paramInt);
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    String str = super.a(paramMagicfaceDataPendantJason);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDecorateName :");
    ((StringBuilder)localObject).append(paramMagicfaceDataPendantJason.toString());
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", ((StringBuilder)localObject).toString());
    localObject = str;
    if (!TextUtils.isEmpty(str)) {
      if (!TextUtils.isEmpty(paramMagicfaceDataPendantJason.trigger))
      {
        localObject = n();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDecorateName 2:");
        localStringBuilder.append(paramMagicfaceDataPendantJason.trigger);
        localStringBuilder.append("|");
        localStringBuilder.append((String)localObject);
        AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
        if (paramMagicfaceDataPendantJason.trigger.equals(localObject)) {
          paramMagicfaceDataPendantJason = a(paramMagicfaceDataPendantJason, str);
        } else {
          paramMagicfaceDataPendantJason = null;
        }
        localObject = paramMagicfaceDataPendantJason;
      }
      else
      {
        localObject = a(paramMagicfaceDataPendantJason, str);
      }
    }
    paramMagicfaceDataPendantJason = new StringBuilder();
    paramMagicfaceDataPendantJason.append("getDecorateName 3:");
    paramMagicfaceDataPendantJason.append((String)localObject);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", paramMagicfaceDataPendantJason.toString());
    return localObject;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    super.a(paramString, paramArrayOfByte, paramShort1, paramShort2, paramShort3, paramShort4, paramBoolean);
    if (this.i.get(0))
    {
      if (!a(paramString)) {
        a(paramArrayOfByte, paramBoolean);
      }
    }
    else if (a(paramString)) {
      a(paramArrayOfByte, paramBoolean);
    }
  }
  
  protected int d()
  {
    return super.d() + m();
  }
  
  protected void e()
  {
    super.e();
    if (this.i.get(0)) {
      a(true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processStart:");
    localStringBuilder.append(this.i.get(2));
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
    if ((!this.i.get(2)) && (l())) {
      c(this.r.tips);
    }
  }
  
  protected void f()
  {
    super.f();
    if (this.i.get(0)) {
      a(false);
    }
    c(0);
    c(1);
    if (l()) {
      c(null);
    }
  }
  
  protected String h()
  {
    boolean bool = this.r.hasMirrorRes;
    Object localObject = "";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("_");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      if (this.g) {
        localObject = "mirror";
      } else {
        localObject = "normal";
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMirrorPath:");
    localStringBuilder.append(this.r.hasMirrorRes);
    localStringBuilder.append("|");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append((String)localObject);
    AVLog.printColorLog("MagicFaceDataEntityMultiResult", localStringBuilder.toString());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntityMultiResult
 * JD-Core Version:    0.7.0.1
 */