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
  
  public void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (AddFriendVerifyActivity.a(this.a).equals(paramHashMap.uin)) {
        if (AddFriendVerifyActivity.a(this.a) != null)
        {
          str = AddFriendVerifyActivity.a(this.a).getText().toString();
          if ((TextUtils.isEmpty(str)) || (str.equals(AddFriendVerifyActivity.a(this.a)))) {
            AddFriendVerifyActivity.a(this.a).setText(paramHashMap.nickname);
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("AddFriendVerifyActivity", 2, "onGetQidianMasterInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.18
 * JD-Core Version:    0.7.0.1
 */