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
    Intent localIntent = AVCallCompactHelper.a(this.this$0, AVCallCompactHelper.a());
    boolean bool = this.a.isResume();
    Object localObject1 = null;
    Object localObject2;
    int i;
    SessionInfo localSessionInfo1;
    if ((bool) && (localIntent != null))
    {
      int j = SessionMgr.a().c();
      localObject2 = AVCallCompactHelper.b(AVCallCompactHelper.a(), localIntent);
      SessionInfo localSessionInfo2 = SessionMgr.a().d((String)localObject2);
      i = j;
      localObject1 = localObject2;
      localSessionInfo1 = localSessionInfo2;
      if (j >= 2)
      {
        i = j;
        localObject1 = localObject2;
        localSessionInfo1 = localSessionInfo2;
        if (localSessionInfo2 != null)
        {
          i = j;
          localObject1 = localObject2;
          localSessionInfo1 = localSessionInfo2;
          if (localSessionInfo2.h())
          {
            this.a.startActivity(localIntent);
            i = j;
            localObject1 = localObject2;
            localSessionInfo1 = localSessionInfo2;
          }
        }
      }
    }
    else
    {
      i = 0;
      localSessionInfo1 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkThirdCallIntent, isResume[");
      ((StringBuilder)localObject2).append(this.a.isResume());
      ((StringBuilder)localObject2).append("], count[");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("], session[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("], info[");
      ((StringBuilder)localObject2).append(localSessionInfo1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("CompatModeTag", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */