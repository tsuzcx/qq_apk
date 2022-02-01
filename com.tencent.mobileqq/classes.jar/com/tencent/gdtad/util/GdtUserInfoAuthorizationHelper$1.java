package com.tencent.gdtad.util;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.List;
import mqq.os.MqqHandler;

class GdtUserInfoAuthorizationHelper$1
  implements TroopMemberApiClient.Callback
{
  public void callback(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("city");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "getUserInfo : name -> " + str1 + ", phone -> " + str2 + ", city -> " + paramBundle);
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.a))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(str1)) {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.b))
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(str2)) {
        bool2 = false;
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList.contains(AuthorizationItem.c)) && (TextUtils.isEmpty(paramBundle))) {}
    for (bool1 = false;; bool1 = bool2)
    {
      paramBundle = GdtUserInfoAuthorizationHelper.a(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper, str1, str2, paramBundle, this.jdField_a_of_type_JavaUtilList);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        GdtUserInfoAuthorizationHelper.a(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper, this.jdField_a_of_type_AndroidAppActivity, bool1, paramBundle, this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      ThreadManager.getUIHandler().post(new GdtUserInfoAuthorizationHelper.1.1(this, bool1, paramBundle));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1
 * JD-Core Version:    0.7.0.1
 */