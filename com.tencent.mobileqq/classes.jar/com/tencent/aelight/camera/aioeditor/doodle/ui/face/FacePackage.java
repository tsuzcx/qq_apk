package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import org.json.JSONObject;

public abstract class FacePackage
{
  public String a;
  public String b;
  public String c;
  public String d;
  public Drawable e;
  public String f;
  public boolean g;
  public double h = 1.0D;
  @Deprecated
  public int i = 0;
  public int j = 0;
  private String k;
  private int l = 5;
  private float m = 0.05F;
  
  public FacePackage(@NonNull String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a = paramString;
      return;
    }
    throw new IllegalStateException("FacePackage'id can not be null.");
  }
  
  public int a()
  {
    return this.l;
  }
  
  public abstract String a(int paramInt);
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      SLog.e("FacePackage", "config json is empty.");
    }
    int n;
    for (;;)
    {
      n = 0;
      break;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        this.l = localJSONObject.getInt("amount");
        this.m = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
        this.h = localJSONObject.optDouble("scale", 1.0D);
        if ((this.l >= 1) && (this.m >= 0.0F) && (this.m < 0.5D))
        {
          this.k = paramString;
          n = 1;
          break;
        }
        SLog.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse config json error : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", exception : ");
        localStringBuilder.append(localException.toString());
        SLog.e("FacePackage", localStringBuilder.toString());
      }
    }
    if (n == 0)
    {
      SLog.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { c() });
      if ("NormalFacePackage".equals(c()))
      {
        if ("1".equals(this.a))
        {
          this.l = 5;
          this.m = 0.05F;
        }
        else
        {
          this.l = 5;
          this.m = 0.05F;
        }
      }
      else
      {
        if (!"LocationFacePackage".equals(c())) {
          break label284;
        }
        this.l = 4;
        this.m = 0.1F;
      }
      this.k = null;
      return;
      label284:
      paramString = new StringBuilder();
      paramString.append("unknown face package, type:");
      paramString.append(c());
      throw new IllegalStateException(paramString.toString());
    }
  }
  
  public float b()
  {
    return this.m;
  }
  
  public abstract String c();
  
  public abstract int d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage
 * JD-Core Version:    0.7.0.1
 */