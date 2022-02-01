package com.tencent.mobileqq.ark.API;

import agyw;
import apvx;
import apwn;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$14
  implements Runnable
{
  public ArkAppQQModule$14(apwn paramapwn, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject2 == null) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = apvx.a();
        } while (!(localObject1 instanceof ArkFullScreenAppActivity));
        localObject1 = (ArkFullScreenAppActivity)localObject1;
        localObject2 = agyw.a((ark.Container)localObject2);
      } while (localObject2 == null);
      localObject2 = (agyw)((WeakReference)localObject2).get();
    } while (localObject2 == null);
    ((ArkFullScreenAppActivity)localObject1).a((agyw)localObject2, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.14
 * JD-Core Version:    0.7.0.1
 */