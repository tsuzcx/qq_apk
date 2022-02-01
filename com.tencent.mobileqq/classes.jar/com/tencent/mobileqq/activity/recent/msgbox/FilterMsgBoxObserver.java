package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class FilterMsgBoxObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate() called with: type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isSuccess = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], data = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("]");
      QLog.d("FilterMsgBoxObserver", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxObserver
 * JD-Core Version:    0.7.0.1
 */