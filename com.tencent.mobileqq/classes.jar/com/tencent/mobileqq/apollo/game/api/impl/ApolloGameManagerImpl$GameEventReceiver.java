package com.tencent.mobileqq.apollo.game.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloGameManagerImpl$GameEventReceiver
  extends BroadcastReceiver
{
  protected WeakReference<QQAppInterface> a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("ApolloGameManager", 1, "[onReceive] intent null");
      return;
    }
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", app: ");
      localStringBuilder.append(this.a.get());
      QLog.d("ApolloGameManager", 2, new Object[] { "[onReceive] action=", localStringBuilder.toString() });
    }
    if ((QQAppInterface)this.a.get() == null) {
      return;
    }
    if (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) {
      return;
    }
    if ("apolloGameWebMessage".equals(paramIntent.getStringExtra("event")))
    {
      paramContext = paramIntent.getStringExtra("data");
      ApolloCmdChannel.getInstance().handleWebEvent(paramContext, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl.GameEventReceiver
 * JD-Core Version:    0.7.0.1
 */