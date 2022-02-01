package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.common.app.BaseApplicationImpl;
import dov.com.qq.im.QIMShortVideoUtils;

class VideoHandler$7
  implements Runnable
{
  VideoHandler$7(VideoHandler paramVideoHandler) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId != 9) {
      QIMShortVideoUtils.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.7
 * JD-Core Version:    0.7.0.1
 */