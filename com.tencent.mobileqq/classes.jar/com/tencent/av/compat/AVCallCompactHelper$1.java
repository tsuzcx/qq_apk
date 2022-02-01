package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

class AVCallCompactHelper$1
  implements Runnable
{
  AVCallCompactHelper$1(AVCallCompactHelper paramAVCallCompactHelper, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = AVCallCompactHelper.a(this.this$0, AVCallCompactHelper.a());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = SessionMgr.a().a();
      String str2 = AVCallCompactHelper.a(AVCallCompactHelper.a(), localIntent);
      SessionInfo localSessionInfo = SessionMgr.a().c(str2);
      localObject = localSessionInfo;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = localSessionInfo;
        str1 = str2;
        i = j;
        if (localSessionInfo != null)
        {
          localObject = localSessionInfo;
          str1 = str2;
          i = j;
          if (localSessionInfo.j())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = localSessionInfo;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "checkThirdCallIntent, isResume[" + this.a.isResume() + "], count[" + i + "], session[" + str1 + "], info[" + localObject + "]");
      }
      return;
      i = 0;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */