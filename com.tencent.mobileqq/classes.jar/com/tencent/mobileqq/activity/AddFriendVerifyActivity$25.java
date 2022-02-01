package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import org.json.JSONException;
import org.json.JSONObject;

class AddFriendVerifyActivity$25
  implements Runnable
{
  AddFriendVerifyActivity$25(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    int i = AddFriendVerifyActivity.y(this.this$0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("{\"m\":0,\"source\":\"joinTroop\", \"gc\":");
    ((StringBuilder)localObject1).append(this.this$0.o);
    ((StringBuilder)localObject1).append("}");
    localObject1 = ((StringBuilder)localObject1).toString();
    this.this$0.D.sendEmptyMessage(1);
    try
    {
      AddFriendVerifyActivity.c(this.this$0, true);
      AddFriendVerifyActivity.c(this.this$0, "");
      localObject2 = TroopNoticeJsHandler.a(this.this$0.app.getCurrentAccountUin(), "https://admin.qun.qq.com/cgi-bin/qun_admin/upload_msg_img", this.a, (String)localObject1, "", LoginHelper.a(this.this$0.app), TroopNoticeJsHandler.b);
      if (i != AddFriendVerifyActivity.z(this.this$0))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("AddFriendVerifyActivity", 2, "uploadImage task cancelled.");
        return;
      }
      AddFriendVerifyActivity.c(this.this$0, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = HttpUtil.unEscape((String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).optInt("ec", -1);
        if (i == 0)
        {
          AddFriendVerifyActivity.a(this.this$0, ((JSONObject)localObject1).optLong("gc"));
          AddFriendVerifyActivity.c(this.this$0, ((JSONObject)localObject1).optInt("fileid"));
          AddFriendVerifyActivity.d(this.this$0, ((JSONObject)localObject1).optString("md5"));
          AddFriendVerifyActivity.c(this.this$0, ((JSONObject)localObject1).optString("url"));
        }
        else
        {
          this.this$0.D.sendEmptyMessage(3);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uploadImage error. ec:");
            ((StringBuilder)localObject1).append(i);
            QLog.w("AddFriendVerifyActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      else
      {
        this.this$0.D.sendEmptyMessage(3);
        if (QLog.isColorLevel()) {
          QLog.w("AddFriendVerifyActivity", 2, "uploadImage error.");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uploadImage json exception:");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.w("AddFriendVerifyActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uploadImage exception:");
        ((StringBuilder)localObject2).append(localInterruptedException.getMessage());
        QLog.w("AddFriendVerifyActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.this$0.D.sendEmptyMessage(2);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.25
 * JD-Core Version:    0.7.0.1
 */