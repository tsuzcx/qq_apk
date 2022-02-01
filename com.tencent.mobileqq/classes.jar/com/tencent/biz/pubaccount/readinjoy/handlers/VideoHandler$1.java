package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import qcn;
import qdc;

public class VideoHandler$1
  implements Runnable
{
  public VideoHandler$1(qdc paramqdc) {}
  
  public void run()
  {
    if ((qdc.a(this.this$0) != null) && (!((ReadInJoyXListView)qdc.a(this.this$0)).a())) {
      qcn.a(qdc.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.1
 * JD-Core Version:    0.7.0.1
 */