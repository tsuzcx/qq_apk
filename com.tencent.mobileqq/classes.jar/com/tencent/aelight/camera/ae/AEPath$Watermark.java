package com.tencent.aelight.camera.ae;

import java.io.File;

public final class AEPath$Watermark
{
  public static final String a;
  public static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.Watermark.FILES.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("camera_watermark_current_template.json");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.Watermark.FILES.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("camera_watermark_updated_template.json");
    b = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPath.Watermark
 * JD-Core Version:    0.7.0.1
 */