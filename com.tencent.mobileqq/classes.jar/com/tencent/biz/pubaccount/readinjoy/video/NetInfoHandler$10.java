package com.tencent.biz.pubaccount.readinjoy.video;

import qdc;
import sfj;
import spg;
import szd;

public class NetInfoHandler$10
  implements Runnable
{
  public NetInfoHandler$10(sfj paramsfj) {}
  
  public void run()
  {
    sfj.a(this.this$0).notifyDataSetChanged();
    spg localspg = sfj.a(this.this$0).a();
    if ((!localspg.b()) && (!localspg.d())) {
      sfj.a(this.this$0).b(sfj.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.10
 * JD-Core Version:    0.7.0.1
 */