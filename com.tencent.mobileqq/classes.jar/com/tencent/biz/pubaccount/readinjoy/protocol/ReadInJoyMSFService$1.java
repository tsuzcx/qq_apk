package com.tencent.biz.pubaccount.readinjoy.protocol;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import puz;

public class ReadInJoyMSFService$1
  implements Runnable
{
  public ReadInJoyMSFService$1(puz parampuz, ToServiceMsg paramToServiceMsg, WeakReference paramWeakReference) {}
  
  public void run()
  {
    int i = puz.a(this.this$0);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getAttributes().put("seq", Integer.valueOf(i));
    puz.a(this.this$0).put(Integer.valueOf(i), this.jdField_a_of_type_JavaLangRefWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.1
 * JD-Core Version:    0.7.0.1
 */