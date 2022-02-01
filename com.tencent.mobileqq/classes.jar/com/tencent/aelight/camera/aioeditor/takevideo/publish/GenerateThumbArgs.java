package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class GenerateThumbArgs
{
  public final double a;
  public final float a;
  public final int a;
  public final String a;
  public final WeakReference<Activity> a;
  public final boolean a;
  public final double b;
  public final int b;
  public final String b;
  public final boolean b;
  public final int c;
  
  public GenerateThumbArgs(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, float paramFloat, boolean paramBoolean1, int paramInt3, double paramDouble1, double paramDouble2, String paramString2, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.c = paramInt3;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GenerateThumbArgs{mFileDir='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRatioWH=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", mShowLastFrameThumb=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mOrientation=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mLatitude=");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(", mLongitude=");
    localStringBuilder.append(this.jdField_b_of_type_Double);
    localStringBuilder.append(", mExistsThumbPath=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mThumbOk=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs
 * JD-Core Version:    0.7.0.1
 */