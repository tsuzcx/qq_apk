package com.tencent.mobileqq.ark.API;

import agyw;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import apvx;
import apwn;
import aqcz;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$12
  implements Runnable
{
  public ArkAppQQModule$12(apwn paramapwn, long paramLong, String paramString) {}
  
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
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = apvx.a();
              } while (!(localObject1 instanceof FragmentActivity));
              localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            } while (!(localObject1 instanceof ChatFragment));
            localObject3 = ((ChatFragment)localObject1).a();
            if (localObject3 == null) {
              break;
            }
            localObject1 = ((BaseChatPie)localObject3).a();
          } while (localObject1 == null);
          localObject2 = agyw.a((ark.Container)localObject2);
        } while (localObject2 == null);
        localObject2 = (agyw)((WeakReference)localObject2).get();
        Object localObject3 = ((BaseChatPie)localObject3).a((agyw)localObject2);
        if (localObject3 != null)
        {
          aqcz.a().a(((MessageForArkApp)localObject3).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject3, this.jdField_a_of_type_JavaLangString, apvx.a());
          return;
        }
      } while ((!aqcz.a().a()) || (localObject2 == null));
      aqcz.a().a((agyw)localObject2, (SessionInfo)localObject1, this.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = agyw.a((ark.Container)localObject2);
    } while (localObject1 == null);
    aqcz.a().a((agyw)((WeakReference)localObject1).get(), null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.12
 * JD-Core Version:    0.7.0.1
 */