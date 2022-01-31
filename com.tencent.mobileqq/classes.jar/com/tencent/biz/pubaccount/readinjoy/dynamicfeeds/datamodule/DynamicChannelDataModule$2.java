package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Handler;
import awbw;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.List;
import ovz;

public class DynamicChannelDataModule$2
  implements Runnable
{
  public DynamicChannelDataModule$2(ovz paramovz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = ovz.a(this.this$0);
    int i = this.a;
    int j = this.b;
    localObject = ((awbw)localObject).a(DynamicChannelDataModel.class, true, "channelID = ?", new String[] { String.valueOf(i) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ovz.a(this.this$0, this.a, 2);
      return;
    }
    localObject = ovz.a(this.this$0, this.a, (List)localObject, false);
    ovz.a(this.this$0).post(new DynamicChannelDataModule.2.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.2
 * JD-Core Version:    0.7.0.1
 */