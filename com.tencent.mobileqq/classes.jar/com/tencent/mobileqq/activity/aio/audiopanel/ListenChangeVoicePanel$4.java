package com.tencent.mobileqq.activity.aio.audiopanel;

import ajjj;
import aucu;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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
    Object localObject = (ajjj)((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getManager(51);
    int i;
    if (!((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).r())
    {
      localObject = ((ajjj)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, ((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int, true);
      if (localObject == null) {
        break label199;
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
      if (ListenChangeVoicePanel.jdField_a_of_type_Aucu != null) {
        break;
      }
      ListenChangeVoicePanel.jdField_a_of_type_Aucu = new aucu();
      return;
      localObject = ((ajjj)localObject).a(((BaseChatPie)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, true);
      if (localObject != null) {
        i = ((ExtensionInfo)localObject).pttChangeVoiceType;
      } else {
        label199:
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */