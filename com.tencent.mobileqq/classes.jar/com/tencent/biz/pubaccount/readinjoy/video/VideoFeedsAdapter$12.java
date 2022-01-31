package com.tencent.biz.pubaccount.readinjoy.video;

import qyv;
import raw;
import rbn;
import rgr;

public class VideoFeedsAdapter$12
  implements Runnable
{
  public VideoFeedsAdapter$12(raw paramraw, boolean paramBoolean) {}
  
  public void run()
  {
    if ((raw.a(this.this$0) != null) && (raw.a(this.this$0).a != null)) {
      raw.a(this.this$0).a.g(this.a);
    }
    if (!this.a)
    {
      raw.a(this.this$0).b();
      this.this$0.g();
    }
    while ((raw.a(this.this$0).d()) || (raw.a(this.this$0) == null)) {
      return;
    }
    raw.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12
 * JD-Core Version:    0.7.0.1
 */