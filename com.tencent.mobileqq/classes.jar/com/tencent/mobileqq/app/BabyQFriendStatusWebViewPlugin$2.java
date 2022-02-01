package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class BabyQFriendStatusWebViewPlugin$2
  implements EIPCResultCallback
{
  BabyQFriendStatusWebViewPlugin$2(BabyQFriendStatusWebViewPlugin paramBabyQFriendStatusWebViewPlugin) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb BabyQFriendStatusWebPlugin EIPCResultCallback : result == null or data == null");
      }
      return;
    }
    boolean bool = paramEIPCResult.isSuccess();
    String str2 = paramEIPCResult.data.getString("key_method_action");
    String str3 = paramEIPCResult.data.getString("web_js_call_back_id");
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, new Object[] { "babyqWeb BabyQFriendStatusWebPlugin EIPCResultCallback : issuccess = ", Boolean.valueOf(bool), ",action = ", str2, ",jscallback = ", str3 });
    }
    String str1 = "";
    if ("setFriendGrouping".equals(str2))
    {
      paramEIPCResult = paramEIPCResult.data.getString("key_handle_set_get_group");
      str1 = "{ \"ret\": 0, \"group\": \"" + paramEIPCResult + "\"}";
    }
    this.a.a(str3, str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin.2
 * JD-Core Version:    0.7.0.1
 */