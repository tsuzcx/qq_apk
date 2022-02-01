package com.tencent.mobileqq.app.identity.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.identity.IDevListView;

class SafeApiImpl$2
  extends SecSvcObserver
{
  SafeApiImpl$2(SafeApiImpl paramSafeApiImpl, IDevListView paramIDevListView) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityIDevListView.onRenameAuthDev(paramBoolean, paramInt, paramArrayOfByte, paramString);
  }
  
  protected void b(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityIDevListView.onWXSyncQQMsgOption(paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.impl.SafeApiImpl.2
 * JD-Core Version:    0.7.0.1
 */