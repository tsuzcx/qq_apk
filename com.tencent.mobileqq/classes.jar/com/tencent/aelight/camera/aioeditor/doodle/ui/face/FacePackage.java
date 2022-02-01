package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import org.json.JSONObject;

public abstract class FacePackage
{
  public double a;
  private float a;
  @Deprecated
  public int a;
  public Drawable a;
  public String a;
  public boolean a;
  public int b = 0;
  public String b;
  private int c = 5;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public FacePackage(@NonNull String paramString)
  {
    this.jdField_a_of_type_Float = 0.05F;
    this.jdField_a_of_type_Double = 1.0D;
    this.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    throw new IllegalStateException("FacePackage'id can not be null.");
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public abstract String a();
  
  public abstract String a(int paramInt);
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      SLog.e("FacePackage", "config json is empty.");
    }
    int i;
    for (;;)
    {
      i = 0;
      break;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        this.c = localJSONObject.getInt("amount");
        this.jdField_a_of_type_Float = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
        this.jdField_a_of_type_Double = localJSONObject.optDouble("scale", 1.0D);
        if ((this.c >= 1) && (this.jdField_a_of_type_Float >= 0.0F) && (this.jdField_a_of_type_Float < 0.5D))
        {
          this.f = paramString;
          i = 1;
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
    if (i == 0)
    {
      SLog.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { a() });
      if ("NormalFacePackage".equals(a()))
      {
        if ("1".equals(this.jdField_a_of_type_JavaLangString))
        {
          this.c = 5;
          this.jdField_a_of_type_Float = 0.05F;
        }
        else
        {
          this.c = 5;
          this.jdField_a_of_type_Float = 0.05F;
        }
      }
      else
      {
        if (!"LocationFacePackage".equals(a())) {
          break label284;
        }
        this.c = 4;
        this.jdField_a_of_type_Float = 0.1F;
      }
      this.f = null;
      return;
      label284:
      paramString = new StringBuilder();
      paramString.append("unknown face package, type:");
      paramString.append(a());
      throw new IllegalStateException(paramString.toString());
    }
  }
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage
 * JD-Core Version:    0.7.0.1
 */