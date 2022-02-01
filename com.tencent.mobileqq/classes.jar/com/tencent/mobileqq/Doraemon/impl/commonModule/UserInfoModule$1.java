package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.Callback;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

class UserInfoModule$1
  extends Callback
{
  UserInfoModule$1(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, APIParam.a(paramBundle));
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 1, "get user info error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule.1
 * JD-Core Version:    0.7.0.1
 */