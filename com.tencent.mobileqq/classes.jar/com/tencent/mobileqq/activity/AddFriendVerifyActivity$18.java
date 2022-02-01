package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AddFriendVerifyActivity$18
  extends QidianBusinessObserver
{
  AddFriendVerifyActivity$18(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (AddFriendVerifyActivity.d(this.a).equals(paramHashMap.uin))
      {
        if (AddFriendVerifyActivity.f(this.a) != null)
        {
          String str = AddFriendVerifyActivity.f(this.a).getText().toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(AddFriendVerifyActivity.d(this.a)))) {
            AddFriendVerifyActivity.f(this.a).setText(paramHashMap.nickname);
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo not current uin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.18
 * JD-Core Version:    0.7.0.1
 */