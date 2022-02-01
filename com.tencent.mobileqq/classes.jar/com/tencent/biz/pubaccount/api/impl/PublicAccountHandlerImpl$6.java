package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountHandlerImpl$6
  extends LbsManagerServiceOnLocationChangeListener
{
  PublicAccountHandlerImpl$6(PublicAccountHandlerImpl paramPublicAccountHandlerImpl, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errCode ：");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" info is null ---> ");
      boolean bool;
      if (paramSosoLbsInfo == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("PublicAccountHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    int i = this.a;
    int j = this.b;
    int k = this.c;
    int m = this.d;
    if (paramInt != 0) {
      paramSosoLbsInfo = null;
    }
    PublicAccountHandlerImpl.access$500((PublicAccountHandlerImpl)localObject, i, j, k, m, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.6
 * JD-Core Version:    0.7.0.1
 */