package com.tencent.mobileqq.ark.API;

import agpq;
import apix;
import appj;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$13
  implements Runnable
{
  public ArkAppQQModule$13(apix paramapix, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = agpq.a((ark.Container)localObject);
    } while ((localObject == null) || ((agpq)((WeakReference)localObject).get() == null));
    appj.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.13
 * JD-Core Version:    0.7.0.1
 */