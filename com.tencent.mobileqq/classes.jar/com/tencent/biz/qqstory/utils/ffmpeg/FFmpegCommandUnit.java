package com.tencent.biz.qqstory.utils.ffmpeg;

import android.text.TextUtils;
import java.util.ArrayList;

public class FFmpegCommandUnit
{
  public int a;
  public FFmpegExecuteResponseCallback a;
  public String a;
  public ArrayList a;
  public String[] a;
  
  public FFmpegCommandUnit() {}
  
  public FFmpegCommandUnit(String[] paramArrayOfString, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
  }
  
  public String toString()
  {
    String str1;
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      str1 = "null";
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label86;
      }
    }
    label86:
    for (String str2 = "null";; str2 = TextUtils.join(",", this.jdField_a_of_type_JavaUtilArrayList.toArray()))
    {
      return "FFmpegCommandUnit{ cmdType :" + this.jdField_a_of_type_Int + "\n cmd: " + str1 + "\n output: " + this.jdField_a_of_type_JavaLangString + "\n arguments: " + str2;
      str1 = TextUtils.join(" ", this.jdField_a_of_type_ArrayOfJavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit
 * JD-Core Version:    0.7.0.1
 */