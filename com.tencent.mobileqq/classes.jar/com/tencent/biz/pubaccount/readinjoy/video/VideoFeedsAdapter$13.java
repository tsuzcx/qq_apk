package com.tencent.biz.pubaccount.readinjoy.video;

import sfc;
import shl;
import six;
import slr;
import swm;

public class VideoFeedsAdapter$13
  implements Runnable
{
  public VideoFeedsAdapter$13(shl paramshl, boolean paramBoolean) {}
  
  public void run()
  {
    if ((shl.a(this.this$0) != null) && (shl.a(this.this$0).a != null)) {
      shl.a(this.this$0).a.h(this.a);
    }
    if ((this.a) && (!shl.a(this.this$0).d()) && (shl.a(this.this$0) != null)) {
      shl.a(this.this$0).b();
    }
    while ((this.a) || (!six.b())) {
      return;
    }
    shl.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.13
 * JD-Core Version:    0.7.0.1
 */