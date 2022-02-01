package com.tencent.biz.pubaccount.readinjoy.video;

import psf;
import rsu;
import sdc;
import slt;

public class NetInfoHandler$10
  implements Runnable
{
  public NetInfoHandler$10(rsu paramrsu) {}
  
  public void run()
  {
    rsu.a(this.this$0).notifyDataSetChanged();
    sdc localsdc = rsu.a(this.this$0).a();
    if ((!localsdc.b()) && (!localsdc.d())) {
      rsu.a(this.this$0).b(rsu.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.10
 * JD-Core Version:    0.7.0.1
 */