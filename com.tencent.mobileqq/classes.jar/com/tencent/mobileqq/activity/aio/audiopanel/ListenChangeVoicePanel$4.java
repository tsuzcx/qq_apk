package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class ListenChangeVoicePanel$4
  implements Runnable
{
  ListenChangeVoicePanel$4(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void run()
  {
    if (ListenChangeVoicePanel.a(this.this$0).get() != null)
    {
      if (this.this$0.d.get() == null) {
        return;
      }
      Object localObject = (FriendsManager)((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!((BaseChatPie)this.this$0.d.get()).aJ())
      {
        localObject = ((FriendsManager)localObject).b(((BaseChatPie)this.this$0.d.get()).ah.b, ((BaseChatPie)this.this$0.d.get()).ah.a, true);
        if (localObject != null)
        {
          i = ((NoC2CExtensionInfo)localObject).pttChangeVoiceType;
          break label164;
        }
      }
      else
      {
        localObject = ((FriendsManager)localObject).d(((BaseChatPie)this.this$0.d.get()).ah.b, true);
        if (localObject != null)
        {
          i = ((ExtensionInfo)localObject).pttChangeVoiceType;
          break label164;
        }
      }
      int i = -1;
      label164:
      if ((i != -1) && (i >= 0) && (ListenChangeVoicePanel.i(this.this$0).length > i))
      {
        ListenChangeVoicePanel.a(this.this$0, i);
        ListenChangeVoicePanel.i(this.this$0)[i] = 1;
      }
      if (ListenChangeVoicePanel.l == null) {
        ListenChangeVoicePanel.l = ((IPttUtils)QRoute.api(IPttUtils.class)).createPttVoiceChangePreSender((AppRuntime)ListenChangeVoicePanel.a(this.this$0).get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.4
 * JD-Core Version:    0.7.0.1
 */