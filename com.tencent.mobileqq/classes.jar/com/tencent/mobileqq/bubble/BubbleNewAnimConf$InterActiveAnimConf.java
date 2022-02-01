package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class BubbleNewAnimConf$InterActiveAnimConf
  extends BubbleNewAnimConf
{
  public int m = -1;
  public boolean n = false;
  public String o = "";
  public String p = "";
  public Rect q = null;
  public Rect r = null;
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      super.a(paramInt, paramString, paramJSONObject);
      paramString = BaseApplicationImpl.getContext();
      this.m = paramJSONObject.optInt("passive_type", -1);
      this.n = paramJSONObject.optBoolean("passive_rotate", false);
      this.o = paramJSONObject.optString("start_align", this.h);
      this.h = this.o;
      this.p = paramJSONObject.optString("end_align", "");
      if (paramJSONObject.has("start_rect"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("start_rect");
        this.q = new Rect();
        this.q.left = AIOUtils.b(localJSONArray.getInt(0) / 2, paramString.getResources());
        this.q.top = AIOUtils.b(localJSONArray.getInt(1) / 2, paramString.getResources());
        this.q.right = AIOUtils.b(localJSONArray.getInt(2) / 2, paramString.getResources());
        this.q.bottom = AIOUtils.b(localJSONArray.getInt(3) / 2, paramString.getResources());
        this.i = this.q;
      }
      if (paramJSONObject.has("end_rect"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("end_rect");
        this.r = new Rect();
        this.r.left = AIOUtils.b(paramJSONObject.getInt(0) / 2, paramString.getResources());
        this.r.top = AIOUtils.b(paramJSONObject.getInt(1) / 2, paramString.getResources());
        this.r.right = AIOUtils.b(paramJSONObject.getInt(2) / 2, paramString.getResources());
        this.r.bottom = AIOUtils.b(paramJSONObject.getInt(3) / 2, paramString.getResources());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAnimConf.InterActiveAnimConf
 * JD-Core Version:    0.7.0.1
 */