package com.tencent.mobileqq.activity.photo;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;

public class VideoPlayMedioInfo
{
  public int a;
  public long a;
  public Bundle a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public String[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d = false;
  public long e = 0L;
  public boolean e;
  
  public VideoPlayMedioInfo()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsBundle = null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo
 * JD-Core Version:    0.7.0.1
 */