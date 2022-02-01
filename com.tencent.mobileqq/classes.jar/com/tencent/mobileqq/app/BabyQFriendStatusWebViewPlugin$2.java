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
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      boolean bool = paramEIPCResult.isSuccess();
      String str1 = paramEIPCResult.data.getString("key_method_action");
      String str2 = paramEIPCResult.data.getString("web_js_call_back_id");
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, new Object[] { "babyqWeb BabyQFriendStatusWebPlugin EIPCResultCallback : issuccess = ", Boolean.valueOf(bool), ",action = ", str1, ",jscallback = ", str2 });
      }
      if ("setFriendGrouping".equals(str1))
      {
        paramEIPCResult = paramEIPCResult.data.getString("key_handle_set_get_group");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{ \"ret\": 0, \"group\": \"");
        localStringBuilder.append(paramEIPCResult);
        localStringBuilder.append("\"}");
        paramEIPCResult = localStringBuilder.toString();
      }
      else
      {
        paramEIPCResult = "";
      }
      this.a.a(str2, paramEIPCResult, str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb BabyQFriendStatusWebPlugin EIPCResultCallback : result == null or data == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin.2
 * JD-Core Version:    0.7.0.1
 */