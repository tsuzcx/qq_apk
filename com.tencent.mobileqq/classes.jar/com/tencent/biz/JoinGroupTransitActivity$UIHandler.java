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
    if ((paramMessage == null) || (localJoinGroupTransitActivity == null) || (localJoinGroupTransitActivity.isFinishing())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      JoinGroupTransitActivity.a(localJoinGroupTransitActivity).a(JoinGroupTransitActivity.a(localJoinGroupTransitActivity));
      return;
    }
    localJoinGroupTransitActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity.UIHandler
 * JD-Core Version:    0.7.0.1
 */