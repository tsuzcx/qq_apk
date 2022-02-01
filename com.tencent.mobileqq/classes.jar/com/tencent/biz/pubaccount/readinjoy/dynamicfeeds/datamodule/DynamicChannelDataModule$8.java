package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.Comparator;

class DynamicChannelDataModule$8
  implements Comparator<DynamicChannelDataModel>
{
  DynamicChannelDataModule$8(DynamicChannelDataModule paramDynamicChannelDataModule) {}
  
  public int a(DynamicChannelDataModel paramDynamicChannelDataModel1, DynamicChannelDataModel paramDynamicChannelDataModel2)
  {
    if (paramDynamicChannelDataModel1.recommendSeq == paramDynamicChannelDataModel2.recommendSeq) {
      return 0;
    }
    if (paramDynamicChannelDataModel1.recommendSeq < paramDynamicChannelDataModel2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.8
 * JD-Core Version:    0.7.0.1
 */