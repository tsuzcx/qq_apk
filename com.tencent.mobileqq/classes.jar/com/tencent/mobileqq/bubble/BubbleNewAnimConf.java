package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class BubbleNewAnimConf
{
  public String a = "";
  public long b = 0L;
  public int c = 1;
  public int d = 0;
  public String e = "";
  public boolean f;
  public int g = 0;
  public String h = "";
  public Rect i;
  public Rect j;
  public String k;
  public int l = 0;
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = paramString;
    this.l = paramInt;
    paramString = BaseApplicationImpl.getContext();
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      this.i = new Rect();
      this.i.left = AIOUtils.b(localJSONArray.getInt(0) / 2, paramString.getResources());
      this.i.top = AIOUtils.b(localJSONArray.getInt(1) / 2, paramString.getResources());
      this.i.right = AIOUtils.b(localJSONArray.getInt(2) / 2, paramString.getResources());
      this.i.bottom = AIOUtils.b(localJSONArray.getInt(3) / 2, paramString.getResources());
    }
    this.b = paramJSONObject.optInt("time", 0);
    this.c = paramJSONObject.optInt("cycle_count", 1);
    this.d = paramJSONObject.optInt("count", 0);
    this.e = paramJSONObject.optString("img_prefix", "");
    this.g = paramJSONObject.optInt("alpha", 0);
    this.h = paramJSONObject.optString("align", "");
    this.k = paramJSONObject.optString("zip_name", "");
    this.f = paramJSONObject.optBoolean("img_reverse", true);
    paramJSONObject = paramJSONObject.optJSONArray("padding");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.j = new Rect();
      this.j.left = AIOUtils.b(paramJSONObject.getInt(0) / 2, paramString.getResources());
      this.j.top = AIOUtils.b(paramJSONObject.getInt(1) / 2, paramString.getResources());
      this.j.right = AIOUtils.b(paramJSONObject.getInt(2) / 2, paramString.getResources());
      this.j.bottom = AIOUtils.b(paramJSONObject.getInt(3) / 2, paramString.getResources());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAnimConf
 * JD-Core Version:    0.7.0.1
 */