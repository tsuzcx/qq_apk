package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;

public class AEDashboardUtil$BinaryInfo
{
  public String a;
  public boolean b;
  public String c = "null";
  public String d = "null";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ready=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", extraInfo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", error=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.BinaryInfo
 * JD-Core Version:    0.7.0.1
 */