package com.tencent.mobileqq.activity.springfestival.entry.model;

import android.os.Bundle;

public class RedPacketResultData
{
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g;
  public String h;
  public int i;
  public String j;
  public String k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  
  public RedPacketResultData() {}
  
  public RedPacketResultData(Bundle paramBundle)
  {
    this.b = paramBundle.getInt("k_state", -1);
    this.c = paramBundle.getInt("key_award_type", -1);
    this.d = paramBundle.getInt("k_c_time", -1);
    this.e = paramBundle.getInt("k_money", -1);
    this.f = paramBundle.getInt("key_business_id", -1);
    this.l = paramBundle.getInt("key_promotion_id", -1);
    this.i = paramBundle.getInt("key_mtime", -1);
    this.a = paramBundle.getString("k_pack_id");
    this.m = paramBundle.getString("key_req_id");
    this.g = paramBundle.getString("key_signature");
    this.j = paramBundle.getString("key_order");
    this.h = paramBundle.getString("key_url");
    this.k = paramBundle.getString("key_wishing");
    this.n = paramBundle.getString("key_business_name");
    this.o = paramBundle.getString("key_business_logo");
    this.p = paramBundle.getString("key_business_video");
    this.r = paramBundle.getString("key_business_video_cover");
    this.q = paramBundle.getString("key_business_cover");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.RedPacketResultData
 * JD-Core Version:    0.7.0.1
 */