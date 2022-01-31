package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import aukn;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.qphone.base.util.QLog;
import ork;

public class DynamicChannelDataModule$10
  implements Runnable
{
  public DynamicChannelDataModule$10(ork paramork, int paramInt) {}
  
  public void run()
  {
    boolean bool = ork.a(this.this$0).b("DELETE FROM " + DynamicChannelDataModel.class.getSimpleName() + " WHERE channelID = " + this.a);
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "clear dataModel from db, channelID = ", Integer.valueOf(this.a), ", res = ", Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.10
 * JD-Core Version:    0.7.0.1
 */