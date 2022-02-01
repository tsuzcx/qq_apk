package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MainAssistObserver$4
  extends MessageObserver
{
  MainAssistObserver$4(MainAssistObserver paramMainAssistObserver) {}
  
  public void onPushPCActiveNotice(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushPCActiveNotice.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MainAssistObserver_PCActiveNotice", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.a == null) {
      return;
    }
    if (!this.a.a.isResume()) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    Object localObject = new Intent("mqq.intent.action.PCACTIVE_TIPS");
    ((Intent)localObject).putExtra("uin", paramString1);
    ((Intent)localObject).putExtra("Message", paramString2);
    ((Intent)localObject).putExtra("lButton", paramString3);
    ((Intent)localObject).putExtra("rButton", paramString4);
    if (NotifyPCActiveActivity.a == null) {
      this.a.a.startActivity((Intent)localObject);
    }
  }
  
  public void onPushRecommandDevLock(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushRecommandDevLock.isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" canCancel=");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(" words=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.devlock.", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.a == null) {
      return;
    }
    if (!this.a.a.isResume()) {
      return;
    }
    if (!paramBoolean1) {
      return;
    }
    Object localObject = new Intent(this.a.a, DevlockPushActivity.class);
    ((Intent)localObject).putExtra("canCancel", paramBoolean2);
    ((Intent)localObject).putExtra("tipMsg", paramString1);
    ((Intent)localObject).putExtra("title", paramString2);
    ((Intent)localObject).putExtra("secondTitle", paramString3);
    ((Intent)localObject).putExtra("thirdTitle", paramString4);
    ((Intent)localObject).putStringArrayListExtra("wordsList", paramArrayList);
    this.a.a.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.4
 * JD-Core Version:    0.7.0.1
 */