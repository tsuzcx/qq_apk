package com.tencent.mobileqq.apollo.game;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CmGameSocketConnection$ConnectionHandler
  extends Handler
{
  private WeakReference<CmGameSocketConnection> a;
  
  public CmGameSocketConnection$ConnectionHandler(Looper paramLooper, CmGameSocketConnection paramCmGameSocketConnection)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCmGameSocketConnection);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleMessage] msg=");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("[cmshow]CmGameConnection.ConnectionHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      localObject = (CmGameSocketConnection)localWeakReference.get();
    }
    if (localObject == null)
    {
      QLog.e("[cmshow]CmGameConnection.ConnectionHandler", 1, "[handleMessage] no connection");
      return;
    }
    int i = paramMessage.what;
    boolean bool;
    if (i != 1)
    {
      long l = 120000L;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        bool = CmGameSocketConnection.c((CmGameSocketConnection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] send, result=", Boolean.valueOf(bool) });
        }
        if (bool)
        {
          super.removeMessages(2);
          if (ApolloConfigUtils.a > 0L) {
            l = ApolloConfigUtils.a;
          }
          super.sendEmptyMessageDelayed(2, l);
          if (CmGameSocketConnection.d((CmGameSocketConnection)localObject))
          {
            super.removeMessages(3);
            super.sendEmptyMessage(3);
          }
        }
      }
      else
      {
        bool = CmGameSocketConnection.b((CmGameSocketConnection)localObject);
        super.removeMessages(2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] heartbeat, result=", Boolean.valueOf(bool), ", flag=", paramMessage.obj });
        }
        if (bool)
        {
          if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue())) {
            ((CmGameSocketConnection)localObject).c();
          }
          if (ApolloConfigUtils.a > 0L) {
            l = ApolloConfigUtils.a;
          }
          super.sendEmptyMessageDelayed(2, l);
          return;
        }
        ((CmGameSocketConnection)localObject).a(true);
      }
    }
    else
    {
      bool = CmGameSocketConnection.a((CmGameSocketConnection)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]CmGameConnection.ConnectionHandler", 2, new Object[] { "[handleMessage] conn result=", Boolean.valueOf(bool), ", connected=", Boolean.valueOf(((CmGameSocketConnection)localObject).a()) });
      }
      if (!bool)
      {
        if (!((CmGameSocketConnection)localObject).a()) {
          ((CmGameSocketConnection)localObject).d();
        }
      }
      else
      {
        super.removeMessages(2);
        paramMessage = super.obtainMessage(2);
        paramMessage.obj = Boolean.valueOf(true);
        super.sendMessage(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameSocketConnection.ConnectionHandler
 * JD-Core Version:    0.7.0.1
 */