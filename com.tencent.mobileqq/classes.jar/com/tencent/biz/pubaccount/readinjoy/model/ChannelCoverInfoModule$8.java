package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ChannelCoverInfoModule$8
  implements Runnable
{
  ChannelCoverInfoModule$8(ChannelCoverInfoModule paramChannelCoverInfoModule, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if (this.a) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyHasMoreChannelRedPoint, success = ", Integer.valueOf(i) });
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.8
 * JD-Core Version:    0.7.0.1
 */