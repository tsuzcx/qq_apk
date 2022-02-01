package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ZhituManager$5
  extends Handler
{
  ZhituManager$5(ZhituManager paramZhituManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 5)
    {
      if (i != 6)
      {
        if (i != 11) {
          return;
        }
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("response is empty, errorMsg is ");
          localStringBuilder.append(paramMessage);
          QLog.d("ZhituManager", 2, localStringBuilder.toString());
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter.a(paramMessage);
        }
      }
      else
      {
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        if (!paramMessage.equals(this.a.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, ZhituManager.a(paramMessage, "main handler", "reqKey is outdated, skip"));
          }
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicAdapter.a(i, paramMessage);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$ZhituPanelAdapter.a(i, paramMessage);
        }
      }
    }
    else
    {
      paramMessage = (ZhituPicData)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, ZhituManager.a(paramMessage.d, "main handler", paramMessage.a, "all img process is finished, now is in main thread"));
      }
      this.a.e(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.5
 * JD-Core Version:    0.7.0.1
 */