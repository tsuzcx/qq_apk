package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = null;
  
  MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    AVActivity localAVActivity = (AVActivity)this.this$0.a.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.this$0.d, 2, "onInviteUserNotice-->Can not get AVActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable
 * JD-Core Version:    0.7.0.1
 */