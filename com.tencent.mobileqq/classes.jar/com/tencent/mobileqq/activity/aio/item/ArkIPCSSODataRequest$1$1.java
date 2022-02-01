package com.tencent.mobileqq.activity.aio.item;

import agpu;
import agpv;
import java.lang.ref.WeakReference;

public class ArkIPCSSODataRequest$1$1
  implements Runnable
{
  public ArkIPCSSODataRequest$1$1(agpv paramagpv, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    agpu localagpu = (agpu)this.jdField_a_of_type_Agpv.a.get();
    if (localagpu == null) {
      return;
    }
    localagpu.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1.1
 * JD-Core Version:    0.7.0.1
 */