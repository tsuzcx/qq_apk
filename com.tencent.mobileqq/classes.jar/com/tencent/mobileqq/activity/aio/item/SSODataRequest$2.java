package com.tencent.mobileqq.activity.aio.item;

import afvi;
import java.lang.ref.WeakReference;

public class SSODataRequest$2
  implements Runnable
{
  public SSODataRequest$2(afvi paramafvi, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    afvi localafvi = (afvi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localafvi == null) {
      return;
    }
    localafvi.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SSODataRequest.2
 * JD-Core Version:    0.7.0.1
 */