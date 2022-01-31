package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioItemData
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public TroopGiftAioItemData(JSONObject paramJSONObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("goodsWord");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("gifUrl");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("pngUrl");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("packageID");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("quantity");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("playRule");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("selectedWording");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("giftValue");
    this.e = paramJSONObject.optInt("giftID");
    this.f = paramJSONObject.optInt("giftPrice");
    this.jdField_c_of_type_Boolean = paramJSONObject.optBoolean("isFreeGift");
    this.h = paramJSONObject.optInt("addTime");
    this.i = paramJSONObject.optInt("freegiftlimit");
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioItemData
 * JD-Core Version:    0.7.0.1
 */