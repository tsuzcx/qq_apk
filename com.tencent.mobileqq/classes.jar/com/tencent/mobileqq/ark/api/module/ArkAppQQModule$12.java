package com.tencent.mobileqq.ark.api.module;

import androidx.fragment.app.FragmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

class ArkAppQQModule$12
  implements Runnable
{
  ArkAppQQModule$12(ArkAppQQModule paramArkAppQQModule, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject2 = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ArkAppQQModuleBase.a();
    if ((localObject1 instanceof BaseActivity))
    {
      localObject1 = ((BaseActivity)localObject1).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if ((localObject1 instanceof ChatFragment))
      {
        Object localObject3 = ((ChatFragment)localObject1).a();
        if (localObject3 != null)
        {
          localObject1 = ((BaseChatPie)localObject3).a();
          if (localObject1 != null)
          {
            localObject2 = ArkAppContainer.a((ark.Container)localObject2);
            if (localObject2 != null)
            {
              localObject2 = (ArkAppContainer)((WeakReference)localObject2).get();
              localObject3 = this.this$0.a(((BaseChatPie)localObject3).b(), (ArkAppContainer)localObject2);
              if (localObject3 != null)
              {
                ArkTipsManager.a().a(((MessageForArkApp)localObject3).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject3, this.jdField_a_of_type_JavaLangString, ArkAppQQModuleBase.a());
                return;
              }
              if ((ArkTipsManager.a().a()) && (localObject2 != null)) {
                ArkTipsManager.a().a((ArkAppContainer)localObject2, (SessionInfo)localObject1, this.jdField_a_of_type_JavaLangString);
              }
            }
          }
        }
        else
        {
          localObject1 = ArkAppContainer.a((ark.Container)localObject2);
          if (localObject1 != null) {
            ArkTipsManager.a().a((ArkAppContainer)((WeakReference)localObject1).get(), null, this.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.12
 * JD-Core Version:    0.7.0.1
 */