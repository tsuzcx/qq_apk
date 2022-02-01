package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable
  implements Runnable
{
  int a = 0;
  String b = null;
  
  MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void run()
  {
    AVActivity localAVActivity = (AVActivity)this.this$0.ak.get();
    if (localAVActivity != null)
    {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.this$0.X, 2, "onInviteUserNotice-->Can not get AVActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable
 * JD-Core Version:    0.7.0.1
 */