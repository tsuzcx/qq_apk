package com.tencent.aelight.camera.ae;

import java.io.File;

public class AEPathBase$BASE
{
  public static final String a;
  public static final String b;
  public static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.e);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ae");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ae");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPathBase.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ae");
    c = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPathBase.BASE
 * JD-Core Version:    0.7.0.1
 */