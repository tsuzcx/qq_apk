package com.tencent.mobileqq.apollo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloGameManager$GameEventReceiver
  extends BroadcastReceiver
{
  protected WeakReference<QQAppInterface> a;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("ApolloGameManager", 1, "[onReceive] intent null");
    }
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, new Object[] { "[onReceive] action=", paramContext + ", app: " + this.a.get() });
      }
    } while (((QQAppInterface)this.a.get() == null) || (!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
    paramContext = paramIntent.getStringExtra("data");
    ApolloUtilImpl.getCmdChannel().handleWebEvent(paramContext, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameManager.GameEventReceiver
 * JD-Core Version:    0.7.0.1
 */