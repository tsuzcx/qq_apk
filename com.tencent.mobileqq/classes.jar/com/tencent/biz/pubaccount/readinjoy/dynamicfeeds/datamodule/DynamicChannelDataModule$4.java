package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.ugc.CollectionUtils.IPredicate;

class DynamicChannelDataModule$4
  implements CollectionUtils.IPredicate<DynamicChannelDataModel>
{
  DynamicChannelDataModule$4(DynamicChannelDataModule paramDynamicChannelDataModule, long paramLong) {}
  
  public boolean a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    return paramDynamicChannelDataModel.recommendSeq > this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.4
 * JD-Core Version:    0.7.0.1
 */