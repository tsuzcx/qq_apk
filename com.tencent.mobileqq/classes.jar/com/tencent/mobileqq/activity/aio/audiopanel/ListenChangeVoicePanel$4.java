package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
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
    Object localObject = (FriendsManager)((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i;
    if (!((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).p())
    {
      localObject = ((FriendsManager)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, ((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int, true);
      if (localObject == null) {
        break label216;
      }
      i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
    }
    for (;;)
    {
      if ((i != -1) && (i >= 0) && (ListenChangeVoicePanel.a(this.this$0).length > i))
      {
        ListenChangeVoicePanel.a(this.this$0, i);
        ListenChangeVoicePanel.a(this.this$0)[i] = 1;
      }
      if (ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
        break;
      }
      ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender = new PttVoiceChangePreSender();
      return;
      localObject = ((FriendsManager)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label216:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */