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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowTips, isDialog[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], tip[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.ObserverImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      this.jdField_a_of_type_AndroidOsHandler.post(new DavWTogetherObserver.3(this, paramBoolean, (Activity)localObject, paramString));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.b();
    int i;
    if (AVUtil.c(j))
    {
      if (paramBoolean1) {
        i = 4;
      } else {
        i = 2;
      }
    }
    else if (paramBoolean1) {
      i = 3;
    } else {
      i = 1;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeUIMode, start[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], isAdmin[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], uiMode[");
      localStringBuilder.append(j);
      localStringBuilder.append("-->");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.i("WTogether.ObserverImpl", 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new DavWTogetherObserver.1(this, i, paramBoolean2, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver
 * JD-Core Version:    0.7.0.1
 */