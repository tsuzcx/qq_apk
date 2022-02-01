package com.tencent.biz.pubaccount.NativeAd.view;

import android.database.ContentObserver;
import android.os.Handler;

class ReadInJoyNativeAdAppVideoView$VolumeChangedObserver
  extends ContentObserver
{
  public ReadInJoyNativeAdAppVideoView$VolumeChangedObserver(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (ReadInJoyNativeAdAppVideoView.d(this.a) != null) {
      ReadInJoyNativeAdAppVideoView.d(this.a).post(new ReadInJoyNativeAdAppVideoView.VolumeChangedObserver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.VolumeChangedObserver
 * JD-Core Version:    0.7.0.1
 */