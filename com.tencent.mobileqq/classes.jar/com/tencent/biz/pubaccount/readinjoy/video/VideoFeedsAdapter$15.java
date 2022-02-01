package com.tencent.biz.pubaccount.readinjoy.video;

import rln;
import rnu;
import rol;
import rpt;
import rsk;

public class VideoFeedsAdapter$15
  implements Runnable
{
  public VideoFeedsAdapter$15(rnu paramrnu, boolean paramBoolean) {}
  
  public void run()
  {
    if ((rnu.a(this.this$0) != null) && (rnu.a(this.this$0).a != null)) {
      rnu.a(this.this$0).a.h(this.a);
    }
    if ((this.a) && (!rnu.a(this.this$0).d()) && (rnu.a(this.this$0) != null)) {
      rnu.a(this.this$0).b();
    }
    while ((this.a) || (!rpt.b())) {
      return;
    }
    rnu.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.15
 * JD-Core Version:    0.7.0.1
 */