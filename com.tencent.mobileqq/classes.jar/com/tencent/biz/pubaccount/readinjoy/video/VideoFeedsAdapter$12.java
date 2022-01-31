package com.tencent.biz.pubaccount.readinjoy.video;

import pxs;
import pzs;
import qag;
import qfo;

public class VideoFeedsAdapter$12
  implements Runnable
{
  public VideoFeedsAdapter$12(pzs parampzs, boolean paramBoolean) {}
  
  public void run()
  {
    if ((pzs.a(this.this$0) != null) && (pzs.a(this.this$0).a != null)) {
      pzs.a(this.this$0).a.g(this.a);
    }
    if (!this.a)
    {
      pzs.a(this.this$0).b();
      this.this$0.g();
    }
    while ((pzs.a(this.this$0).c()) || (pzs.a(this.this$0) == null)) {
      return;
    }
    pzs.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12
 * JD-Core Version:    0.7.0.1
 */