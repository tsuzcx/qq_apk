package com.tencent.biz.pubaccount.readinjoy.video;

import qjr;
import qls;
import qmi;
import qrm;

public class VideoFeedsAdapter$11
  implements Runnable
{
  public VideoFeedsAdapter$11(qls paramqls, boolean paramBoolean) {}
  
  public void run()
  {
    if ((qls.a(this.this$0) != null) && (qls.a(this.this$0).a != null)) {
      qls.a(this.this$0).a.g(this.a);
    }
    if (!this.a)
    {
      qls.a(this.this$0).b();
      this.this$0.g();
    }
    while ((qls.a(this.this$0).d()) || (qls.a(this.this$0) == null)) {
      return;
    }
    qls.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.11
 * JD-Core Version:    0.7.0.1
 */