package com.tencent.mobileqq.activity.aio.item;

import afxh;
import java.lang.ref.WeakReference;

public class ArkSSODataRequest$2
  implements Runnable
{
  public ArkSSODataRequest$2(afxh paramafxh, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    afxh localafxh = (afxh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localafxh == null) {
      return;
    }
    localafxh.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.2
 * JD-Core Version:    0.7.0.1
 */