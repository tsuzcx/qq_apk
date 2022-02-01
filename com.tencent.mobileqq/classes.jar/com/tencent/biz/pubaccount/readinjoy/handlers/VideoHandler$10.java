package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.QIMShortVideoUtils;

class VideoHandler$10
  implements Runnable
{
  VideoHandler$10(VideoHandler paramVideoHandler) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId != 9) {
      QIMShortVideoUtils.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.10
 * JD-Core Version:    0.7.0.1
 */