package com.tencent.biz.pubaccount.readinjoy;

import android.text.TextUtils;
import org.json.JSONObject;

public class ReadInJoyMedalInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public ReadInJoyMedalInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Long > 0L) {
        localJSONObject.put("medalid", this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Int > 0) {
        localJSONObject.put("mMedalType", this.jdField_a_of_type_Int);
      }
      if (this.jdField_b_of_type_Int > 0) {
        localJSONObject.put("mIsJump", this.jdField_b_of_type_Int);
      }
      if (this.jdField_c_of_type_Int > 0) {
        localJSONObject.put("GRID_FEED_ITEM_SIZE", this.jdField_c_of_type_Int);
      }
      if (this.jdField_d_of_type_Int > 0) {
        localJSONObject.put("mPicHeight", this.jdField_d_of_type_Int);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localJSONObject.put("medal_name", this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("medal_url")) {
        localJSONObject.put("medal_url", this.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("mJumpUrl")) {
        localJSONObject.put("mJumpUrl", this.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("medal_scene")) {
        localJSONObject.put("medal_scene", this.e);
      }
      if (!TextUtils.isEmpty("medal_pos")) {
        localJSONObject.put("medal_pos", this.f);
      }
      if (!TextUtils.isEmpty("channelid")) {
        localJSONObject.put("channelid", this.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("feedsid")) {
        localJSONObject.put("feedsid", this.g);
      }
      if (!TextUtils.isEmpty("medal_uin")) {
        localJSONObject.put("medal_uin", this.h);
      }
    }
    catch (Exception localException)
    {
      label254:
      break label254;
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyMedalInfo
 * JD-Core Version:    0.7.0.1
 */