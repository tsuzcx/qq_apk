package com.tencent.mobileqq.activity.aio.audiopanel;

import anvk;
import bahr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

class ListenChangeVoicePanel$4
  implements Runnable
{
  ListenChangeVoicePanel$4(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    if ((ListenChangeVoicePanel.a(this.this$0).get() == null) || (this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    Object localObject = (anvk)((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i;
    if (!((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).isExtensionInfo())
    {
      localObject = ((anvk)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin, ((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curType, true);
      if (localObject == null) {
        break label200;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if (i != -1)
      {
        ListenChangeVoicePanel.a(this.this$0, i);
        ListenChangeVoicePanel.a(this.this$0)[i] = 1;
      }
      if (ListenChangeVoicePanel.jdField_a_of_type_Bahr != null) {
        break;
      }
      ListenChangeVoicePanel.jdField_a_of_type_Bahr = new bahr();
      return;
      localObject = ((anvk)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label200:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */