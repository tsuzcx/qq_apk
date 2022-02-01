package com.tencent.mobileqq.ark.API;

import agyw;
import apwn;
import aqcz;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$13
  implements Runnable
{
  public ArkAppQQModule$13(apwn paramapwn, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.a);
    if (localObject == null) {}
    do
    {
      return;
      localObject = agyw.a((ark.Container)localObject);
    } while ((localObject == null) || ((agyw)((WeakReference)localObject).get() == null));
    aqcz.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.13
 * JD-Core Version:    0.7.0.1
 */