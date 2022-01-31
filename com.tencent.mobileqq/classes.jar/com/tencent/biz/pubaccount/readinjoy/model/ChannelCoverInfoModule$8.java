package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import oxb;
import pfg;

public class ChannelCoverInfoModule$8
  implements Runnable
{
  public ChannelCoverInfoModule$8(pfg parampfg, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    if (this.a) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyHasMoreChannelRedPoint, success = ", Integer.valueOf(i) });
    oxb.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.8
 * JD-Core Version:    0.7.0.1
 */