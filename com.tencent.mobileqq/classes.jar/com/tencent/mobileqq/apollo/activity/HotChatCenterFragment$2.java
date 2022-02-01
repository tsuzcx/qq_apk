package com.tencent.mobileqq.apollo.activity;

import android.os.Message;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

class HotChatCenterFragment$2
  extends TransProcessorHandler
{
  HotChatCenterFragment$2(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.2
 * JD-Core Version:    0.7.0.1
 */