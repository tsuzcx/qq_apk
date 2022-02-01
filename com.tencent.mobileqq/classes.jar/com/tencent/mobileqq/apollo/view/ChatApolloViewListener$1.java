package com.tencent.mobileqq.apollo.view;

import amaz;
import amkr;
import amnm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ChatApolloViewListener$1
  implements Runnable
{
  public ChatApolloViewListener$1(amnm paramamnm) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady threadPriority:" + i);
    if (this.this$0.a == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.this$0.a.get();
    } while (localBaseChatPie == null);
    if ((localBaseChatPie.app != null) && (localBaseChatPie.sessionInfo != null)) {
      ((amaz)localBaseChatPie.app.getManager(249)).a(localBaseChatPie.sessionInfo.curFriendUin, localBaseChatPie.sessionInfo.curType);
    }
    amkr.b("TraceReport_initApolloSurfaceView_PreLoadJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */