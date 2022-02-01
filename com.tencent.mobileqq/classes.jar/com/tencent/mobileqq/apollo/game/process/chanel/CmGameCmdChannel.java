package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderRunner;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CmGameCmdChannel
{
  private static CmGameCmdChannel b;
  final List<CmGameCmdChannel.IRequestHandler> a;
  private ApolloRenderRunner c;
  private WeakReferenceHandler d;
  private CmGameAccountHandler e;
  private WeakReference<AppInterface> f;
  
  private CmGameCmdChannel(AppInterface paramAppInterface)
  {
    this.f = new WeakReference(paramAppInterface);
    this.a = new ArrayList();
    this.c = new ApolloRenderRunner();
    this.e = new CmGameAccountHandler(paramAppInterface);
    b();
  }
  
  public static CmGameCmdChannel a(AppInterface paramAppInterface)
  {
    try
    {
      if (b == null)
      {
        b = new CmGameCmdChannel(paramAppInterface);
      }
      else
      {
        Object localObject = (AppRuntime)b.f.get();
        if (localObject != paramAppInterface)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("old App:");
          localStringBuilder.append(localObject);
          QLog.i("apollochannel_ApolloDataChannel", 1, localStringBuilder.toString());
          b.a();
          b = new CmGameCmdChannel(paramAppInterface);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("create new cmdChannel App:");
          ((StringBuilder)localObject).append(paramAppInterface);
          QLog.d("apollochannel_ApolloDataChannel", 1, ((StringBuilder)localObject).toString());
        }
      }
      paramAppInterface = b;
      return paramAppInterface;
    }
    finally {}
  }
  
  private void b()
  {
    if (ApolloEngine.isEngineReady())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel nativeSetDataChannelObj");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel ApolloEngine.isEngineReady() false");
    }
    this.d = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.a)
    {
      Collections.sort(this.a, new CmGameCmdChannel.1(this));
      return;
    }
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[requestData], ,cmd:");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(",reqData:");
      ((StringBuilder)???).append(paramString2);
      ((StringBuilder)???).append(",async:");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
    }
    ??? = paramString1.trim();
    Object localObject2 = new CmGameCmdChannel.RequestRunnable(this, (String)???, paramString2, paramInt1, paramInt2);
    if ((!"cs.close_room.local".equals(???)) && (!"cs.first_frame_drawn.local".equals(paramString1)) && (!"cs.qta_notify_test_result.local".equals(paramString1)))
    {
      if (paramBoolean) {
        this.d.post((Runnable)localObject2);
      } else {
        synchronized (this.a)
        {
          localObject2 = this.a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HandleResult localHandleResult = ((CmGameCmdChannel.IRequestHandler)((Iterator)localObject2).next()).a(paramString1, paramString2, paramInt1, paramInt2);
            if (localHandleResult != null)
            {
              if (localHandleResult.b) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localHandleResult.a;
              return paramString1;
            }
          }
        }
      }
    }
    else {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    return "{}";
  }
  
  public void a()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onDestroy app:");
    ((StringBuilder)???).append(this.f.get());
    QLog.i("apollochannel_ApolloDataChannel", 1, ((StringBuilder)???).toString());
    this.c.b();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CmGameCmdChannel.IRequestHandler)localIterator.next()).b();
      }
      this.a.clear();
      this.d.removeCallbacksAndMessages(null);
      ??? = this.e;
      if (??? != null)
      {
        ((CmGameAccountHandler)???).a();
        this.e = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[callbackFromRequest], errCode:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",cmd:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",reqData:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("cmd", paramString1);
    ((Bundle)localObject).putString("respData", paramString2);
    paramString1 = EIPCResult.createResult(paramInt1, (Bundle)localObject);
    CmGameServerQIPCModule.b().callbackResult(paramInt2, paramString1);
  }
  
  public void a(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    synchronized (this.a)
    {
      this.a.remove(paramIRequestHandler);
      this.a.add(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("addCmdHandler class:");
        ((StringBuilder)???).append(paramIRequestHandler.getClass().getName());
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.a.size());
        QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void b(CmGameCmdChannel.IRequestHandler paramIRequestHandler)
  {
    if (paramIRequestHandler == null) {
      return;
    }
    synchronized (this.a)
    {
      this.a.remove(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeCmdHandler class:");
        ((StringBuilder)???).append(paramIRequestHandler.getClass().getName());
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.a.size());
        QLog.d("apollochannel_ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel
 * JD-Core Version:    0.7.0.1
 */