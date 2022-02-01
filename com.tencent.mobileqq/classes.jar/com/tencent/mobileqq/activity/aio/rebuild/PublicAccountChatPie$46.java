package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class PublicAccountChatPie$46
  extends SosoInterfaceOnLocationListener
{
  PublicAccountChatPie$46(PublicAccountChatPie paramPublicAccountChatPie, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (paramSosoLbsInfo.mLocation.address != null))
    {
      str = paramSosoLbsInfo.mLocation.address;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.mLocation == null)) {
        break label212;
      }
    }
    label212:
    for (double d1 = paramSosoLbsInfo.mLocation.mLat02;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.mLocation != null) {
          d2 = paramSosoLbsInfo.mLocation.mLon02;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2 + ", address=" + str);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, d1, d2, str);
      }
      return;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.46
 * JD-Core Version:    0.7.0.1
 */