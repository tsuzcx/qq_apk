package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

class NetInfoHandler$10
  implements Runnable
{
  NetInfoHandler$10(NetInfoHandler paramNetInfoHandler) {}
  
  public void run()
  {
    NetInfoHandler.a(this.this$0).notifyDataSetChanged();
    VideoPlayManager localVideoPlayManager = NetInfoHandler.a(this.this$0).a();
    if ((!localVideoPlayManager.b()) && (!localVideoPlayManager.d())) {
      NetInfoHandler.a(this.this$0).b(NetInfoHandler.a(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.10
 * JD-Core Version:    0.7.0.1
 */