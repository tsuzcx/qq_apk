package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ChatApolloViewListener$1
  implements Runnable
{
  ChatApolloViewListener$1(ChatApolloViewListener paramChatApolloViewListener) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TraceReport CmShowStatUtil onSurfaceReady threadPriority:");
    ((StringBuilder)localObject).append(i);
    QLog.i("[cmshow]ChatApolloViewListener", 1, ((StringBuilder)localObject).toString());
    if (ChatApolloViewListener.a(this.this$0) == null) {
      return;
    }
    localObject = (BaseChatPie)ChatApolloViewListener.a(this.this$0).get();
    if (localObject == null) {
      return;
    }
    if ((((BaseChatPie)localObject).d != null) && (((BaseChatPie)localObject).ah != null)) {
      ((SpriteScriptManagerImpl)((BaseChatPie)localObject).d.getRuntimeService(ISpriteScriptManager.class, "all")).onSurfaceReady(((BaseChatPie)localObject).ah.b, ((BaseChatPie)localObject).ah.a);
    }
    CmShowStatUtil.b("TraceReport_initApolloSurfaceView_PreLoadJS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatApolloViewListener.1
 * JD-Core Version:    0.7.0.1
 */