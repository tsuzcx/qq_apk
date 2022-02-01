package com.tencent.biz;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class JoinGroupTransitActivity$UIHandler
  extends Handler
{
  private WeakReference<JoinGroupTransitActivity> a = null;
  
  public JoinGroupTransitActivity$UIHandler(JoinGroupTransitActivity paramJoinGroupTransitActivity)
  {
    this.a = new WeakReference(paramJoinGroupTransitActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    JoinGroupTransitActivity localJoinGroupTransitActivity = (JoinGroupTransitActivity)this.a.get();
    if ((paramMessage != null) && (localJoinGroupTransitActivity != null))
    {
      if (localJoinGroupTransitActivity.isFinishing()) {
        return;
      }
      int i = paramMessage.what;
      if (i != 0)
      {
        if ((i != 1) && (i != 2) && (i != 3)) {
          return;
        }
        localJoinGroupTransitActivity.finish();
        return;
      }
      JoinGroupTransitActivity.c(localJoinGroupTransitActivity).a(JoinGroupTransitActivity.b(localJoinGroupTransitActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity.UIHandler
 * JD-Core Version:    0.7.0.1
 */