package com.tencent.biz.pubaccount.readinjoy.video;

import psf;
import rsu;
import sdc;
import sdy;
import slt;

public class NetInfoHandler$4
  implements Runnable
{
  public NetInfoHandler$4(rsu paramrsu, sdc paramsdc) {}
  
  public void run()
  {
    rsu.a(this.this$0).notifyDataSetChanged();
    if (this.a.b())
    {
      this.a.e(true);
      this.a.a().m();
    }
    while ((rsu.a(this.this$0).b()) || (!this.a.d())) {
      return;
    }
    this.a.d(true);
    this.a.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.4
 * JD-Core Version:    0.7.0.1
 */