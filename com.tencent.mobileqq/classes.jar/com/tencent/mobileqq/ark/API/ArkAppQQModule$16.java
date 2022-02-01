package com.tencent.mobileqq.ark.API;

import agpq;
import apih;
import apix;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$16
  implements Runnable
{
  public ArkAppQQModule$16(apix paramapix, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = ark.arkGetContainer(this.a);
    if (localObject2 == null) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = apih.a();
        } while (!(localObject1 instanceof ArkFullScreenAppActivity));
        localObject1 = (ArkFullScreenAppActivity)localObject1;
        localObject2 = agpq.a((ark.Container)localObject2);
      } while (localObject2 == null);
      localObject2 = (agpq)((WeakReference)localObject2).get();
    } while (localObject2 == null);
    ((ArkFullScreenAppActivity)localObject1).a((agpq)localObject2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.16
 * JD-Core Version:    0.7.0.1
 */