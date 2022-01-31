package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import atmp;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.List;
import ofz;

public class DynamicChannelDataModule$5
  implements Runnable
{
  public DynamicChannelDataModule$5(ofz paramofz, int paramInt1, long paramLong, int paramInt2) {}
  
  public void run()
  {
    Object localObject = ofz.a(this.this$0);
    int i = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    int j = this.b;
    localObject = ((atmp)localObject).a(DynamicChannelDataModel.class, true, "channelID = ? and recommendSeq > ?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ofz.a(this.this$0, this.jdField_a_of_type_Int, 0);
      return;
    }
    localObject = ofz.a(this.this$0, this.jdField_a_of_type_Int, (List)localObject, false);
    ofz.a(this.this$0, false, this.jdField_a_of_type_Int, true, true, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.5
 * JD-Core Version:    0.7.0.1
 */