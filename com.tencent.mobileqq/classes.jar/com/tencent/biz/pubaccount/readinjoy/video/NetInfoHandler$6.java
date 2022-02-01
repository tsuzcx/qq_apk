package com.tencent.biz.pubaccount.readinjoy.video;

import qdc;
import sfj;
import spg;
import sqd;
import szd;

public class NetInfoHandler$6
  implements Runnable
{
  public NetInfoHandler$6(sfj paramsfj, spg paramspg) {}
  
  public void run()
  {
    sfj.a(this.this$0).notifyDataSetChanged();
    if (this.a.b())
    {
      this.a.e(true);
      this.a.a().m();
    }
    while ((sfj.a(this.this$0).b()) || (!this.a.d())) {
      return;
    }
    this.a.d(true);
    this.a.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.6
 * JD-Core Version:    0.7.0.1
 */