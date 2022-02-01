package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AdHandler$2
  implements Runnable
{
  AdHandler$2(AdHandler paramAdHandler) {}
  
  public void run()
  {
    try
    {
      if (AdHandler.a(this.this$0))
      {
        ((AdvertisementInfo)this.this$0.b().h().get(0)).isSmallCard = true;
        this.this$0.b().notifyDataSetChanged();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideAdExpandBigCard error ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("AdHandler", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.2
 * JD-Core Version:    0.7.0.1
 */