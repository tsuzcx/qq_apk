package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import nrt;
import ors;

class ReadinjoyTabFrame$18
  implements Runnable
{
  ReadinjoyTabFrame$18(ReadinjoyTabFrame paramReadinjoyTabFrame, long paramLong) {}
  
  public void run()
  {
    nrt.a((QQAppInterface)ors.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", ors.d(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.4tab", 2, "report ReadinjoyTabFrame use time: " + Long.toString(this.a / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.18
 * JD-Core Version:    0.7.0.1
 */