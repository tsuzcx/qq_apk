package com.tencent.av.wtogether;

import android.app.Activity;
import android.os.Handler;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;

public class DavWTogetherObserver
  extends WTogetherObserverImpl
{
  private final DoubleVideoCtrlUI a;
  
  public DavWTogetherObserver(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    super(paramDoubleVideoCtrlUI.a);
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI = paramDoubleVideoCtrlUI;
  }
  
  protected void a()
  {
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new DavWTogetherObserver.2(this, localAVActivity));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.ObserverImpl", 2, "onShowTips, isDialog[" + paramBoolean + "], tip[" + paramString + "]");
    }
    AVActivity localAVActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidOsHandler.post(new DavWTogetherObserver.3(this, paramBoolean, localAVActivity, paramString));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.b();
    int i;
    if (AVUtil.c(j)) {
      if (paramBoolean1) {
        i = 4;
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.ObserverImpl", 4, "changeUIMode, start[" + paramBoolean1 + "], isAdmin[" + paramBoolean2 + "], from[" + paramString + "], uiMode[" + j + "-->" + i + "]");
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new DavWTogetherObserver.1(this, i, paramBoolean2, paramBoolean1));
      return;
      i = 2;
      continue;
      if (paramBoolean1) {
        i = 3;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver
 * JD-Core Version:    0.7.0.1
 */