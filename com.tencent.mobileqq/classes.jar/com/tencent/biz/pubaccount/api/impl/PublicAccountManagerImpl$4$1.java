package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class PublicAccountManagerImpl$4$1
  extends SosoInterfaceOnLocationListener
{
  PublicAccountManagerImpl$4$1(PublicAccountManagerImpl.4 param4, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
      try
      {
        if (paramSosoLbsInfo.mLocation != null)
        {
          double d1 = paramSosoLbsInfo.mLocation.mLat02;
          double d2 = paramSosoLbsInfo.mLocation.mLon02;
          Object localObject1 = "";
          if (paramSosoLbsInfo.mLocation.address != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(paramSosoLbsInfo.mLocation.address);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          Object localObject2 = localObject1;
          if (paramSosoLbsInfo.mLocation.name != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(paramSosoLbsInfo.mLocation.name);
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          this.c.this$0.reportClickTypeMenuEvent(true, d1, d2, (String)localObject2, null, this.a, this.b);
          return;
        }
      }
      catch (Exception paramSosoLbsInfo)
      {
        paramSosoLbsInfo.printStackTrace();
        this.c.this$0.reportClickTypeMenuEvent(false, 0.0D, 0.0D, null, null, this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.4.1
 * JD-Core Version:    0.7.0.1
 */