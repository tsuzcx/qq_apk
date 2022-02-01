package com.tencent.aelight.camera.ae.download.old;

import android.support.annotation.NonNull;
import java.util.List;

public class AEOldPackageInfo
{
  public final String a;
  public final int b;
  public final String c;
  public final List<String> d;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{packageName:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", packageVersion:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", packageZipPath:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", packageContentList:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldPackageInfo
 * JD-Core Version:    0.7.0.1
 */