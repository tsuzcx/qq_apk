package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;

public class AEDashboardUtil$BinaryInfo
{
  public String a;
  public boolean a;
  public String b = "null";
  public String c = "null";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ready=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", extraInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", error=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.BinaryInfo
 * JD-Core Version:    0.7.0.1
 */