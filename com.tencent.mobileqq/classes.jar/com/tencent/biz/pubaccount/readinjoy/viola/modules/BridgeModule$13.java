package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.app.QQAppInterface;

class BridgeModule$13
  implements Runnable
{
  BridgeModule$13(BridgeModule paramBridgeModule, int paramInt, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null) {
      BridgeModule.access$1400(this.this$0, localQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.13
 * JD-Core Version:    0.7.0.1
 */