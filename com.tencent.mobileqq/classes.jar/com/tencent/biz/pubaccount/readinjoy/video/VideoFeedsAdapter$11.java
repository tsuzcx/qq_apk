package com.tencent.biz.pubaccount.readinjoy.video;

import qjo;
import qlp;
import qmf;
import qrj;

public class VideoFeedsAdapter$11
  implements Runnable
{
  public VideoFeedsAdapter$11(qlp paramqlp, boolean paramBoolean) {}
  
  public void run()
  {
    if ((qlp.a(this.this$0) != null) && (qlp.a(this.this$0).a != null)) {
      qlp.a(this.this$0).a.g(this.a);
    }
    if (!this.a)
    {
      qlp.a(this.this$0).b();
      this.this$0.g();
    }
    while ((qlp.a(this.this$0).d()) || (qlp.a(this.this$0) == null)) {
      return;
    }
    qlp.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.11
 * JD-Core Version:    0.7.0.1
 */