package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import prq;
import psf;

public class VideoHandler$1
  implements Runnable
{
  public VideoHandler$1(psf parampsf) {}
  
  public void run()
  {
    if ((psf.a(this.this$0) != null) && (!((ReadInJoyXListView)psf.a(this.this$0)).a())) {
      prq.a(psf.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.1
 * JD-Core Version:    0.7.0.1
 */