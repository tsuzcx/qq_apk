package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class SaveTrafficObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficObserver", 2, "onUpdate type:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SaveTrafficObserver
 * JD-Core Version:    0.7.0.1
 */