package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

class NetInfoHandler$4
  implements Runnable
{
  NetInfoHandler$4(NetInfoHandler paramNetInfoHandler, VideoPlayManager paramVideoPlayManager) {}
  
  public void run()
  {
    NetInfoHandler.a(this.this$0).notifyDataSetChanged();
    if (this.a.b())
    {
      this.a.e(true);
      this.a.a().m();
    }
    while ((NetInfoHandler.a(this.this$0).b()) || (!this.a.d())) {
      return;
    }
    this.a.d(true);
    this.a.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.4
 * JD-Core Version:    0.7.0.1
 */