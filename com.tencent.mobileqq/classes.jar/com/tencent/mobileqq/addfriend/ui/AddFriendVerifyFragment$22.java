package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qidian.controller.QidianBusinessObserverExpose;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class AddFriendVerifyFragment$22
  extends QidianBusinessObserverExpose
{
  AddFriendVerifyFragment$22(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).hasQidianExternal(paramHashMap)))
    {
      paramHashMap = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQidianExternal(paramHashMap);
      if ((paramHashMap != null) && (AddFriendVerifyFragment.a(this.a).equals(paramHashMap.get("qidian_uin"))))
      {
        if (AddFriendVerifyFragment.a(this.a) != null)
        {
          String str = AddFriendVerifyFragment.a(this.a).getText().toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(AddFriendVerifyFragment.a(this.a)))) {
            AddFriendVerifyFragment.a(this.a).setText((CharSequence)paramHashMap.get("qidian_nickname"));
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "onGetQidianMasterInfo not current uin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("IphoneTitleBarFragment", 2, "onGetQidianMasterInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.22
 * JD-Core Version:    0.7.0.1
 */