package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import mqq.os.MqqHandler;

class PublicAccountHandlerImpl$5
  extends SosoInterfaceOnLocationListener
{
  PublicAccountHandlerImpl$5(PublicAccountHandlerImpl paramPublicAccountHandlerImpl, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramInt = (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
      int i = (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
      this.b.sendLocRequest(this.a, paramInt, i, 0);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PublicAccountHandlerImpl.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.5
 * JD-Core Version:    0.7.0.1
 */