package com.tencent.biz.pubaccount.readinjoy.video;

import rur;
import rwy;
import rxq;
import sbo;

public class VideoFeedsAdapter$16
  implements Runnable
{
  public VideoFeedsAdapter$16(rwy paramrwy, boolean paramBoolean) {}
  
  public void run()
  {
    if ((rwy.a(this.this$0) != null) && (rwy.a(this.this$0).a != null)) {
      rwy.a(this.this$0).a.h(this.a);
    }
    if (!this.a)
    {
      rwy.a(this.this$0).b();
      this.this$0.g();
    }
    while ((rwy.a(this.this$0).d()) || (rwy.a(this.this$0) == null)) {
      return;
    }
    rwy.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.16
 * JD-Core Version:    0.7.0.1
 */