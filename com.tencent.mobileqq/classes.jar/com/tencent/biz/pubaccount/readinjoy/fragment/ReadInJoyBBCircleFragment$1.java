package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import ocd;
import paa;
import pag;

class ReadInJoyBBCircleFragment$1
  implements Runnable
{
  ReadInJoyBBCircleFragment$1(ReadInJoyBBCircleFragment paramReadInJoyBBCircleFragment) {}
  
  public void run()
  {
    paa localpaa = new paa();
    localpaa.b("entry_time", "" + ReadInJoyBBCircleFragment.a(this.this$0).a() / 1000L);
    localpaa.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    ocd.a(null, null, "0X800978C", "0X800978C", 0, 0, "" + ReadInJoyBBCircleFragment.a(this.this$0).b() / 1000L, "", "", localpaa.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment.1
 * JD-Core Version:    0.7.0.1
 */