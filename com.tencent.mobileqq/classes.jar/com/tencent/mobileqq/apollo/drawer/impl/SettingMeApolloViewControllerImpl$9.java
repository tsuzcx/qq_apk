package com.tencent.mobileqq.apollo.drawer.impl;

import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import com.tencent.qphone.base.util.QLog;

class SettingMeApolloViewControllerImpl$9
  implements ApolloRspCallback
{
  SettingMeApolloViewControllerImpl$9(SettingMeApolloViewControllerImpl paramSettingMeApolloViewControllerImpl) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleCloseCmShow] callback success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errMsg = ");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl.9
 * JD-Core Version:    0.7.0.1
 */