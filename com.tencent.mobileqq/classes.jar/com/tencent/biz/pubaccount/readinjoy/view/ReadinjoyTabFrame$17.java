package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ndn;
import obz;

class ReadinjoyTabFrame$17
  implements Runnable
{
  ReadinjoyTabFrame$17(ReadinjoyTabFrame paramReadinjoyTabFrame, long paramLong) {}
  
  public void run()
  {
    ndn.a((QQAppInterface)obz.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", obz.d(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.4tab", 2, "report ReadinjoyTabFrame use time: " + Long.toString(this.a / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.17
 * JD-Core Version:    0.7.0.1
 */