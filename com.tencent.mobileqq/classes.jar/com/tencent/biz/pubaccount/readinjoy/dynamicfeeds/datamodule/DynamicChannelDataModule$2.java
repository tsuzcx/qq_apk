package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Handler;
import aukp;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.List;
import orh;

public class DynamicChannelDataModule$2
  implements Runnable
{
  public DynamicChannelDataModule$2(orh paramorh, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = orh.a(this.this$0);
    int i = this.a;
    int j = this.b;
    localObject = ((aukp)localObject).a(DynamicChannelDataModel.class, true, "channelID = ?", new String[] { String.valueOf(i) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      orh.a(this.this$0, this.a, 2);
      return;
    }
    localObject = orh.a(this.this$0, this.a, (List)localObject, false);
    orh.a(this.this$0).post(new DynamicChannelDataModule.2.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.2
 * JD-Core Version:    0.7.0.1
 */