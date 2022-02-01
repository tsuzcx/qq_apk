package com.tencent.mobileqq.activity.springfestival.entry.model;

import android.os.Bundle;

public class RedPacketResultData
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public RedPacketResultData() {}
  
  public RedPacketResultData(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramBundle.getInt("k_state", -1);
    this.jdField_b_of_type_Int = paramBundle.getInt("key_award_type", -1);
    this.jdField_c_of_type_Int = paramBundle.getInt("k_c_time", -1);
    this.jdField_d_of_type_Int = paramBundle.getInt("k_money", -1);
    this.jdField_e_of_type_Int = paramBundle.getInt("key_business_id", -1);
    this.jdField_g_of_type_Int = paramBundle.getInt("key_promotion_id", -1);
    this.jdField_f_of_type_Int = paramBundle.getInt("key_mtime", -1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("k_pack_id");
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("key_req_id");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("key_signature");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("key_order");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("key_url");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("key_wishing");
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("key_business_name");
    this.h = paramBundle.getString("key_business_logo");
    this.i = paramBundle.getString("key_business_video");
    this.k = paramBundle.getString("key_business_video_cover");
    this.j = paramBundle.getString("key_business_cover");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.RedPacketResultData
 * JD-Core Version:    0.7.0.1
 */