package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ShopWebViewFragment$5
  extends SosoInterfaceOnLocationListener
{
  ShopWebViewFragment$5(ShopWebViewFragment paramShopWebViewFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (this.a.getAppRuntime() != null)
    {
      if (this.a.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      if ((paramInt == 0) && (paramSosoLbsInfo != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          RecentShopParcel localRecentShopParcel = (RecentShopParcel)localIterator.next();
          if (localRecentShopParcel.c != 1) {}
          try
          {
            localArrayList.add(Long.valueOf(Long.valueOf(localRecentShopParcel.a).longValue()));
          }
          catch (Exception localException)
          {
            label111:
            double d1;
            double d2;
            break label111;
          }
        }
        d1 = paramSosoLbsInfo.mLocation.mLat02;
        d2 = paramSosoLbsInfo.mLocation.mLon02;
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool != null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(this.a.getAppRuntime(), localArrayList, d2, d1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.5
 * JD-Core Version:    0.7.0.1
 */