package com.tencent.av.business.servlet;

import android.os.Looper;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.business.servlet.coder.BaseJCECoder;
import com.tencent.av.business.servlet.coder.EffectMaterialJCECoder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;

public class EffectMaterialService
{
  private AppInterface a;
  private int b = 0;
  private boolean c = false;
  private HashSet<BaseJCECoder> d = new HashSet();
  
  public EffectMaterialService(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  private BaseJCECoder a(String paramString)
  {
    try
    {
      if (!this.c) {
        a();
      }
      Object localObject2 = null;
      Iterator localIterator = this.d.iterator();
      Object localObject1;
      boolean bool;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (BaseJCECoder)localIterator.next();
        bool = ((BaseJCECoder)localObject1).a(paramString);
      } while (!bool);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a()
  {
    if (this.c) {
      return;
    }
    this.d.add(new EffectMaterialJCECoder());
    this.c = true;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ((EffectMaterialHandler)this.a.getBusinessHandler(EffectMaterialHandler.class.getName())).onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new EffectMaterialService.1(this, paramToServiceMsg);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(paramToServiceMsg, 16, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject2 = a(paramFromServiceMsg.getServiceCmd());
      if (localObject2 != null)
      {
        localObject1 = ((BaseJCECoder)localObject2).a(paramToServiceMsg, paramFromServiceMsg);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onReceive ");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getServiceCmd());
        ((StringBuilder)localObject2).append(", coder is null");
        QLog.i("EffectMaterialService", 1, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive ");
      ((StringBuilder)localObject2).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject2).append(", response is fail");
      QLog.i("EffectMaterialService", 1, ((StringBuilder)localObject2).toString());
    }
    a(paramToServiceMsg, paramFromServiceMsg, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.servlet.EffectMaterialService
 * JD-Core Version:    0.7.0.1
 */