package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import olh;
import pkh;
import pqf;

class ReadinjoyTabFrame$16
  implements Runnable
{
  ReadinjoyTabFrame$16(ReadinjoyTabFrame paramReadinjoyTabFrame, long paramLong) {}
  
  public void run()
  {
    olh.a((QQAppInterface)pkh.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", pqf.b(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.4tab", 2, "report ReadinjoyTabFrame use time: " + this.a / 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.16
 * JD-Core Version:    0.7.0.1
 */