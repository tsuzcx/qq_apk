package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;

class DataLineMsgProxy$3
  implements Runnable
{
  DataLineMsgProxy$3(DataLineMsgProxy paramDataLineMsgProxy, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener) {}
  
  public void run()
  {
    this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContentValues, this.b, this.jdField_a_of_type_ArrayOfJavaLangString, 1, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.3
 * JD-Core Version:    0.7.0.1
 */