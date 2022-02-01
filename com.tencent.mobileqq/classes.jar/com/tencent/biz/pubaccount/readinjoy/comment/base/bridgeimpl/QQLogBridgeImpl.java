package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLogBridge;

public class QQLogBridgeImpl
  implements QQLogBridge
{
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 2, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 2, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQLogBridgeImpl
 * JD-Core Version:    0.7.0.1
 */