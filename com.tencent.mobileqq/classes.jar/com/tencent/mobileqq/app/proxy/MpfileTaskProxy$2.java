package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;

class MpfileTaskProxy$2
  implements Runnable
{
  MpfileTaskProxy$2(MpfileTaskProxy paramMpfileTaskProxy, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener) {}
  
  public void run()
  {
    this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContentValues, this.b, this.jdField_a_of_type_ArrayOfJavaLangString, 1, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.2
 * JD-Core Version:    0.7.0.1
 */