package com.tencent.biz.pubaccount.readinjoy.handlers;

import bmux;
import com.tencent.common.app.BaseApplicationImpl;
import qdc;

public class VideoHandler$11
  implements Runnable
{
  public VideoHandler$11(qdc paramqdc) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId != 9) {
      bmux.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.11
 * JD-Core Version:    0.7.0.1
 */