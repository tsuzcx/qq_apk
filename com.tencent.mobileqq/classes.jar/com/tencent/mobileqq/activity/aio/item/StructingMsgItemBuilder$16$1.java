package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.observer.BusinessObserver;

class StructingMsgItemBuilder$16$1
  implements BusinessObserver
{
  StructingMsgItemBuilder$16$1(StructingMsgItemBuilder.16 param16, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramBoolean) {
      paramInt = j;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        paramInt = j;
        localObject = new mobileqq_mp.SubscribeResponse();
        paramInt = j;
        ((mobileqq_mp.SubscribeResponse)localObject).mergeFrom(paramBundle);
        paramInt = j;
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.SubscribeResponse)localObject).ret_info.get()).ret_code.get() == 0)
        {
          paramInt = 1;
          i = 1;
          StructingMsgItemBuilder.a(this.b.d, this.b.b);
          paramInt = i;
        }
        else
        {
          paramInt = j;
          StructingMsgItemBuilder.b(this.b.d, this.b.b);
          paramInt = i;
        }
      }
      else
      {
        paramInt = j;
        StructingMsgItemBuilder.b(this.b.d, this.b.b);
        paramInt = i;
      }
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      break label175;
    }
    paramInt = j;
    StructingMsgItemBuilder.b(this.b.d, this.b.b);
    paramInt = i;
    break label192;
    label175:
    StructingMsgItemBuilder.b(this.b.d, this.b.b);
    label192:
    paramBundle = this.b.d.d;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    ReportController.b(paramBundle, "dc00899", "Pb_account_lifeservice", "", "0X8006513", "0X8006513", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.16.1
 * JD-Core Version:    0.7.0.1
 */