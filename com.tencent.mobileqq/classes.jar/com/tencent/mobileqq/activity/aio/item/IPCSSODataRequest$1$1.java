package com.tencent.mobileqq.activity.aio.item;

import agwx;
import agwy;
import java.lang.ref.WeakReference;

public class IPCSSODataRequest$1$1
  implements Runnable
{
  public IPCSSODataRequest$1$1(agwy paramagwy, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    agwx localagwx = (agwx)this.jdField_a_of_type_Agwy.a.get();
    if (localagwx == null) {
      return;
    }
    localagwx.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.IPCSSODataRequest.1.1
 * JD-Core Version:    0.7.0.1
 */