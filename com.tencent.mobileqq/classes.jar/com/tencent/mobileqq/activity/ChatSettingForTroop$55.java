package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$55
  extends OpenIdObserver
{
  ChatSettingForTroop$55(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.isFinishing()) || (this.a.n)) {}
    do
    {
      do
      {
        return;
        this.a.p();
        if (this.a.b != null) {
          this.a.b.removeCallbacksAndMessages(null);
        }
        if ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "openIdObserver success");
        }
      } while (paramOpenID.openID.equals(this.a.e));
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "-->onGetOpenId--openid doesn't equal current openid");
      }
      this.a.s();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.55
 * JD-Core Version:    0.7.0.1
 */