package com.tencent.biz.pubaccount.NativeAd.view;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import nas;
import ndn;

class ReadInJoyNativeAdAppVideoView$8
  implements Runnable
{
  ReadInJoyNativeAdAppVideoView$8(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    int i = 1;
    String str;
    if (!ReadInJoyNativeAdAppVideoView.b(this.this$0))
    {
      ReadInJoyNativeAdAppVideoView.b(this.this$0, true);
      boolean bool = this.this$0.a(ReadInJoyNativeAdAppVideoView.a(this.this$0).d, ReadInJoyNativeAdAppVideoView.a(this.this$0).d);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppVideoView", 2, "native ad preload cache state: " + bool);
      }
      str = "" + ReadInJoyNativeAdAppVideoView.a(this.this$0).mAdUin;
      if (!bool) {
        break label184;
      }
    }
    for (;;)
    {
      ndn.a(null, str, "0X80093B8", "0X80093B8", 0, i, ReadInJoyNativeAdAppVideoView.a(this.this$0).mAdTraceId, null, null, null);
      ReadInJoyNativeAdAppVideoView.a(this.this$0).start();
      ReadInJoyNativeAdAppVideoView.e(this.this$0, 4);
      ReadInJoyNativeAdAppVideoView.a(this.this$0);
      ReadInJoyNativeAdAppVideoView.a(this.this$0).post(this.this$0.a);
      return;
      label184:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.8
 * JD-Core Version:    0.7.0.1
 */