package com.tencent.mobileqq.addfriend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class AddFriendVerifyFragment$14
  implements DialogInterface.OnClickListener
{
  AddFriendVerifyFragment$14(AddFriendVerifyFragment paramAddFriendVerifyFragment, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getContext(), this.jdField_a_of_type_JavaLangString, 4018, null);
        return;
      }
      if (!TextUtils.isEmpty(this.b))
      {
        paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
        paramDialogInterface.putExtra("url", this.b);
        RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqAddfriendUiAddFriendVerifyFragment.getContext(), paramDialogInterface, "/base/browser");
        return;
      }
      QLog.e("IphoneTitleBarFragment", 1, "showErrorTipsDialogWithHandleAbility, error: url is empty");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showErrorTipsDialogWithHandleAbility, jump H5/MiniApp error: ");
      localStringBuilder.append(paramDialogInterface.getMessage());
      QLog.e("IphoneTitleBarFragment", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.14
 * JD-Core Version:    0.7.0.1
 */