package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class AEDashboardUtil$NetInfo
{
  public String a;
  public String b = "null";
  public String c = "null";
  
  public AEDashboardUtil$NetInfo(@NonNull String paramString)
  {
    this.a = paramString;
  }
  
  public AEDashboardUtil$NetInfo(@NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.NetInfo
 * JD-Core Version:    0.7.0.1
 */