package com.tencent.mobileqq.arcard;

import android.os.Environment;
import java.io.File;

public class ARCardCameraRecordActivity$VideoRecordResult
{
  public static final String a;
  public int a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/";
  }
  
  public ARCardCameraRecordActivity$VideoRecordResult(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardCameraRecordActivity.VideoRecordResult
 * JD-Core Version:    0.7.0.1
 */