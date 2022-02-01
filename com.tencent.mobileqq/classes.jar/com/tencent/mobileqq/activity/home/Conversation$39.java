package com.tencent.mobileqq.activity.home;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

class Conversation$39
  extends ConfigObserver
{
  Conversation$39(Conversation paramConversation) {}
  
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if ((!paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue()) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      ReportController.b(this.a.aF, "dc00898", "", "", "0X8008272", "0X8008272", 0, 0, "", "", "", "");
      if (!this.a.F) {
        this.a.A.obtainMessage(1134068, new String[] { paramString1, paramString2, paramString3 }).sendToTarget();
      }
    }
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.39
 * JD-Core Version:    0.7.0.1
 */