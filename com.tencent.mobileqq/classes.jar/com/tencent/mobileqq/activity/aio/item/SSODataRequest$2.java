package com.tencent.mobileqq.activity.aio.item;

import adnx;
import java.lang.ref.WeakReference;

public class SSODataRequest$2
  implements Runnable
{
  public SSODataRequest$2(adnx paramadnx, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    adnx localadnx = (adnx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localadnx == null) {
      return;
    }
    localadnx.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SSODataRequest.2
 * JD-Core Version:    0.7.0.1
 */