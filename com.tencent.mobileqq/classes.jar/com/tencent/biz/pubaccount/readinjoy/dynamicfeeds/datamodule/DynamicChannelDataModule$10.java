package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import pea;

public class DynamicChannelDataModule$10
  implements Runnable
{
  public DynamicChannelDataModule$10(pea parampea, int paramInt) {}
  
  public void run()
  {
    boolean bool = pea.a(this.this$0).execSQL("DELETE FROM " + DynamicChannelDataModel.class.getSimpleName() + " WHERE channelID = " + this.a);
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "clear dataModel from db, channelID = ", Integer.valueOf(this.a), ", res = ", Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.10
 * JD-Core Version:    0.7.0.1
 */