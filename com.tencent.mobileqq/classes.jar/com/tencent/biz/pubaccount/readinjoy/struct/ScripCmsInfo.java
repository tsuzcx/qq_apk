package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class ScripCmsInfo
  implements Cloneable
{
  public static int c;
  public static int d;
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  
  static
  {
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
  }
  
  public ScripCmsInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static ScripCmsInfo a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    ScripCmsInfo localScripCmsInfo = new ScripCmsInfo();
    localScripCmsInfo.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localScripCmsInfo.jdField_b_of_type_JavaLangString = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localScripCmsInfo.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localScripCmsInfo.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localScripCmsInfo.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localScripCmsInfo.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localScripCmsInfo.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localScripCmsInfo.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localScripCmsInfo.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localScripCmsInfo.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localScripCmsInfo.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localScripCmsInfo;
  }
  
  public ScripCmsInfo a()
  {
    try
    {
      super.clone();
      ScripCmsInfo localScripCmsInfo = new ScripCmsInfo();
      localScripCmsInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localScripCmsInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localScripCmsInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localScripCmsInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localScripCmsInfo.e = this.e;
      localScripCmsInfo.f = this.f;
      localScripCmsInfo.i = this.i;
      localScripCmsInfo.g = this.g;
      localScripCmsInfo.h = this.h;
      localScripCmsInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localScripCmsInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localScripCmsInfo.j = this.j;
      return localScripCmsInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScripCmsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo
 * JD-Core Version:    0.7.0.1
 */