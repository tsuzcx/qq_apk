package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.ILogAdapter;

public class ViolaLogAdapter
  implements ILogAdapter
{
  public void callLog(String paramString1, int paramInt, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      break;
    }
    do
    {
      do
      {
        return;
        QLog.e(paramString1, 2, paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.i(paramString1, 2, paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.w(paramString1, 2, paramString2);
  }
  
  public void onJSError(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaLogAdapter
 * JD-Core Version:    0.7.0.1
 */