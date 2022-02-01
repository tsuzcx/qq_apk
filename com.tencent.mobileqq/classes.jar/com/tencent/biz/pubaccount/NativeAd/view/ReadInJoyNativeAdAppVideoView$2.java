package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import obl;

public class ReadInJoyNativeAdAppVideoView$2
  implements Runnable
{
  ReadInJoyNativeAdAppVideoView$2(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Context paramContext) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.a, new obl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.2
 * JD-Core Version:    0.7.0.1
 */