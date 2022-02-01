package com.tencent.hippy.qq.module.gamecenter;

import com.tencent.qphone.base.util.QLog;

class QQWadlModule$1
  extends QQWadlModule.WadlListener
{
  QQWadlModule$1(QQWadlModule paramQQWadlModule)
  {
    super(null);
  }
  
  protected void onCallback(String paramString, Object paramObject)
  {
    QQWadlModule.access$100(this.this$0, paramString, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, new Object[] { "WadlListener.onCallback, eventName=", paramString, ", data=", paramObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQWadlModule.1
 * JD-Core Version:    0.7.0.1
 */