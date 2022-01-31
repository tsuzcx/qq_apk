package com.tencent.mobileqq.ark.API;

import afii;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import anjy;
import anke;
import anpd;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

public class ArkAppModuleReg$ModuleQQ$12
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$12(anke paramanke, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject3 = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject3 == null) {}
    label12:
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
              break label12;
              break label12;
              break label12;
              do
              {
                return;
              } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
              localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            } while (localObject1 == null);
            localObject2 = ((ChatFragment)localObject1).a();
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((BaseChatPie)localObject2).a();
          } while (localObject1 == null);
          localObject3 = afii.a((ark.Container)localObject3);
        } while (localObject3 == null);
        localObject3 = (afii)((WeakReference)localObject3).get();
        Object localObject2 = ((BaseChatPie)localObject2).a((afii)localObject3);
        if (localObject2 != null)
        {
          anpd.a().a(((MessageForArkApp)localObject2).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject2, this.jdField_a_of_type_JavaLangString, anjy.a());
          return;
        }
      } while ((!anpd.a().a()) || (localObject3 == null));
      anpd.a().a((afii)localObject3, (SessionInfo)localObject1, this.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = afii.a((ark.Container)localObject3);
    } while (localObject1 == null);
    anpd.a().a((afii)((WeakReference)localObject1).get(), null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.12
 * JD-Core Version:    0.7.0.1
 */