package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class PublicAccountChatPie$47
  extends SosoInterfaceOnLocationListener
{
  PublicAccountChatPie$47(PublicAccountChatPie paramPublicAccountChatPie, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (paramSosoLbsInfo.mLocation.address != null)) {
      str = paramSosoLbsInfo.mLocation.address;
    } else {
      str = "";
    }
    double d1;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      d1 = paramSosoLbsInfo.mLocation.mLat02;
    } else {
      d1 = 0.0D;
    }
    double d2;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      d2 = paramSosoLbsInfo.mLocation.mLon02;
    } else {
      d2 = 0.0D;
    }
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationUpdate() latitude=");
      localStringBuilder.append(d1);
      localStringBuilder.append(" longitude=");
      localStringBuilder.append(d2);
      localStringBuilder.append(", address=");
      localStringBuilder.append(str);
      QLog.d(paramSosoLbsInfo, 2, localStringBuilder.toString());
    }
    if (this.a.bo == null)
    {
      paramSosoLbsInfo = this.a;
      paramSosoLbsInfo.bo = ((IPublicAccountHandler)paramSosoLbsInfo.d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
    }
    if (this.a.bo != null) {
      this.a.bo.sendLBSInfo(this.a.ah.b, d1, d2, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.47
 * JD-Core Version:    0.7.0.1
 */