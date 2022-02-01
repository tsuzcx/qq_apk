package com.tencent.mobileqq.ark.API;

import agnx;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import apsl;
import aptb;
import apzo;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

public class ArkAppQQModule$12
  implements Runnable
{
  public ArkAppQQModule$12(aptb paramaptb, long paramLong, String paramString) {}
  
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
                localObject1 = apsl.a();
              } while (!(localObject1 instanceof FragmentActivity));
              localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            } while (!(localObject1 instanceof ChatFragment));
            localObject3 = ((ChatFragment)localObject1).a();
            if (localObject3 == null) {
              break;
            }
            localObject1 = ((BaseChatPie)localObject3).getSessionInfo();
          } while (localObject1 == null);
          localObject2 = agnx.a((ark.Container)localObject2);
        } while (localObject2 == null);
        localObject2 = (agnx)((WeakReference)localObject2).get();
        Object localObject3 = ((BaseChatPie)localObject3).findCurrentArkMsg((agnx)localObject2);
        if (localObject3 != null)
        {
          apzo.a().a(((MessageForArkApp)localObject3).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject3, this.jdField_a_of_type_JavaLangString, apsl.a());
          return;
        }
      } while ((!apzo.a().a()) || (localObject2 == null));
      apzo.a().a((agnx)localObject2, (SessionInfo)localObject1, this.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = agnx.a((ark.Container)localObject2);
    } while (localObject1 == null);
    apzo.a().a((agnx)((WeakReference)localObject1).get(), null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.12
 * JD-Core Version:    0.7.0.1
 */