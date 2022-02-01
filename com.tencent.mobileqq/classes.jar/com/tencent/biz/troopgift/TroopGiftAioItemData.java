package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioItemData
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public int i;
  public int j;
  public boolean k = false;
  public int l;
  public boolean m = false;
  public boolean n = false;
  public int o = 0;
  public int p = 0;
  public boolean q = false;
  public int r = 0;
  public int s = 0;
  public String t = null;
  
  public TroopGiftAioItemData(JSONObject paramJSONObject, int paramInt)
  {
    this.a = paramJSONObject.optString("goodsWord");
    this.b = paramJSONObject.optString("gifUrl");
    this.c = paramJSONObject.optString("pngUrl");
    this.d = paramJSONObject.optInt("packageID");
    this.e = paramJSONObject.optInt("quantity");
    this.f = paramJSONObject.optInt("playRule");
    this.h = paramJSONObject.optString("selectedWording");
    this.g = paramJSONObject.optInt("giftValue");
    this.i = paramJSONObject.optInt("giftID");
    this.j = paramJSONObject.optInt("giftPrice");
    this.n = paramJSONObject.optBoolean("isFreeGift");
    this.o = paramJSONObject.optInt("addTime");
    this.p = paramJSONObject.optInt("freegiftlimit");
    this.l = paramInt;
    this.r = paramJSONObject.optInt("svip");
    this.s = paramJSONObject.optInt("year_svip");
    this.t = paramJSONObject.optString("svip_logo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioItemData
 * JD-Core Version:    0.7.0.1
 */