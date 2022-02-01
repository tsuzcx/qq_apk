package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import mqq.os.MqqHandler;

public class TipsManager
  implements Handler.Callback, TipsConstants
{
  TipsBarTask b;
  protected final MqqHandler c = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private final AIOContext d;
  private QQAppInterface e;
  private BaseSessionInfo f;
  private AIOTipsController g;
  private XPanelContainer h;
  private ArrayList<TipsTask> i;
  private Observer j;
  
  public TipsManager(AIOContext paramAIOContext, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, AIOTipsController paramAIOTipsController, XPanelContainer paramXPanelContainer)
  {
    this.e = paramQQAppInterface;
    this.f = paramBaseSessionInfo;
    this.g = paramAIOTipsController;
    this.h = paramXPanelContainer;
    this.d = paramAIOContext;
  }
  
  public TipsBarTask a()
  {
    return this.b;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TipsTask)((Iterator)localObject).next()).a(paramInt, paramVarArgs);
      }
    }
  }
  
  public boolean a(GrayTipsTask paramGrayTipsTask, Object... paramVarArgs)
  {
    if (paramGrayTipsTask != null)
    {
      if (!a(paramGrayTipsTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showGrayTips() failure: mTipsMgr not allow");
        }
        return false;
      }
      paramVarArgs = paramGrayTipsTask.a_(paramVarArgs);
      if (paramVarArgs != null)
      {
        this.e.getMessageFacade().a(paramVarArgs, paramVarArgs.selfuin);
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("showGrayTips() success: from ");
          paramVarArgs.append(paramGrayTipsTask.b());
          QLog.d("TipsManager", 2, paramVarArgs.toString());
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("showGrayTips() failure: MessageRecord null, from ");
        paramVarArgs.append(paramGrayTipsTask.b());
        QLog.d("TipsManager", 2, paramVarArgs.toString());
      }
    }
    return false;
  }
  
  public boolean a(TipsBarTask paramTipsBarTask, Object... paramVarArgs)
  {
    if (AIOUtils.m) {
      return false;
    }
    if (paramTipsBarTask != null)
    {
      if (!a(paramTipsBarTask))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TipsManager", 2, "showTipsBar() failure: mTipsMgr not allow");
        }
        return false;
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        paramVarArgs = paramTipsBarTask.a(paramVarArgs);
        this.g.a(paramVarArgs, this.b, paramTipsBarTask);
        this.b = paramTipsBarTask;
      }
      else
      {
        paramVarArgs = new TipsManager.1(this, paramTipsBarTask, paramVarArgs);
        this.c.post(paramVarArgs);
      }
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("showTipsBar() success: from ");
        paramVarArgs.append(paramTipsBarTask.b());
        QLog.d("TipsManager", 2, paramVarArgs.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "showTipsBar() failure: tipsBar == null");
    }
    return false;
  }
  
  boolean a(TipsTask paramTipsTask)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramTipsTask.b());
    ((StringBuilder)localObject1).append("");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    Object localObject3 = paramTipsTask.c();
    boolean bool1 = true;
    boolean bool2 = true;
    int k = -1;
    localObject1 = localObject2;
    int m = k;
    if (localObject3 != null)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        k = ((TipsBarTask)localObject1).b();
      }
      localObject1 = localObject2;
      m = 0;
      bool1 = bool2;
      while (m < localObject3.length)
      {
        localObject2 = localObject1;
        if (k == localObject3[m])
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", not allowed by excludeType: ");
          ((StringBuilder)localObject2).append(localObject3[m]);
          ((StringBuilder)localObject2).append(" ");
          localObject2 = ((StringBuilder)localObject2).toString();
          bool1 = false;
        }
        m += 1;
        localObject1 = localObject2;
      }
      m = k;
    }
    localObject2 = localObject1;
    bool2 = bool1;
    if (bool1)
    {
      localObject2 = localObject1;
      bool2 = bool1;
      if ((paramTipsTask instanceof TipsBarTask))
      {
        localObject3 = this.b;
        localObject2 = localObject1;
        bool2 = bool1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (((TipsBarTask)localObject3).a() > ((TipsBarTask)paramTipsTask).a())
          {
            paramTipsTask = new StringBuilder();
            paramTipsTask.append((String)localObject1);
            paramTipsTask.append(", not allowed: priority is low ");
            localObject2 = paramTipsTask.toString();
            bool2 = false;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramTipsTask = new StringBuilder();
      paramTipsTask.append("allowShow(): result = ");
      paramTipsTask.append(bool2);
      paramTipsTask.append(" | ");
      paramTipsTask.append((String)localObject2);
      paramTipsTask.append("|curTipsBarType");
      paramTipsTask.append(m);
      QLog.d("TipsManager", 2, paramTipsTask.toString());
    }
    return bool2;
  }
  
  public int b()
  {
    TipsBarTask localTipsBarTask = this.b;
    if (localTipsBarTask != null) {
      return localTipsBarTask.b();
    }
    return -1;
  }
  
  public void b(TipsTask paramTipsTask)
  {
    if (paramTipsTask == null) {
      return;
    }
    if (this.i == null) {
      this.i = new ArrayList();
    }
    if (!this.i.contains(paramTipsTask)) {
      this.i.add(paramTipsTask);
    }
  }
  
  public void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      localObject = this.g;
      if (localObject != null) {
        ((AIOTipsController)localObject).a(this.b);
      }
      this.b = null;
      a(2000, new Object[0]);
      return;
    }
    Object localObject = new TipsManager.2(this);
    this.c.post((Runnable)localObject);
  }
  
  public void d()
  {
    a(1004, new Object[0]);
    Object localObject = this.i;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    c();
    localObject = this.g;
    if (localObject != null) {
      ((AIOTipsController)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */