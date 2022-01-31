package com.tencent.mobileqq.apollo.aioChannel;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yow;

public class ApolloRenderRunner
{
  private List a = new ArrayList();
  
  public IRenderRunner a()
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      IRenderRunner localIRenderRunner;
      try
      {
        i = this.a.size();
        localArrayList = new ArrayList();
        i -= 1;
        if (i < 0) {
          break label226;
        }
        WeakReference localWeakReference = (WeakReference)this.a.get(i);
        if (localWeakReference == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloViewWeakReference is null");
          }
        }
        else
        {
          localIRenderRunner = (IRenderRunner)localWeakReference.get();
          if (localIRenderRunner == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localIRenderRunner instanceof View)) && (((View)localIRenderRunner).isShown()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localIRenderRunner);
        }
        Object localObject2 = localIRenderRunner;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localIRenderRunner;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localIRenderRunner;; localObject2 = null)
        {
          return localObject2;
          label226:
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner not find");
          }
        }
      }
      i -= 1;
    }
  }
  
  public IRenderRunner a(long paramLong)
  {
    ArrayList localArrayList;
    IRenderRunner localIRenderRunner;
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label269;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloViewWeakReference is null");
          continue;
        }
        localIRenderRunner = (IRenderRunner)localWeakReference.get();
      }
      finally {}
      if (localIRenderRunner == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localIRenderRunner.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext getRuntimeState:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext find getRuntimeState:" + l);
          }
          localObject2 = localIRenderRunner;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localIRenderRunner;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localIRenderRunner;; localObject2 = null)
    {
      return localObject2;
      label269:
      if (!localArrayList.isEmpty())
      {
        this.a.removeAll(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext not find");
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ApolloCmdChannel paramApolloCmdChannel, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      WeakReference localWeakReference;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine cmd:" + paramString1 + ",respData:" + paramString2);
        }
        if (paramApolloCmdChannel == null) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label280;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloViewWeakReference is null");
          continue;
        }
        localIRenderRunner = (IRenderRunner)localWeakReference.get();
      }
      finally {}
      IRenderRunner localIRenderRunner;
      if (localIRenderRunner == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localIRenderRunner.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRuntimeState runtimeState:" + l);
        }
        if (paramLong == localIRenderRunner.getRuntimeState())
        {
          localIRenderRunner.runRenderTask(new yow(this, localIRenderRunner, paramLong, paramApolloCmdChannel, paramInt, paramString1, paramString2));
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRenderRunner find runtimeState:" + l);
          }
          label280:
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "after mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("apollochannel_JsRenderRunner", 2, "lState != apolloSurfaceView.getRuntimeState(), renderThreadId:" + localIRenderRunner.getRuntimeState());
        }
      }
    }
  }
  
  public void a(IRenderRunner paramIRenderRunner)
  {
    if (paramIRenderRunner == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramIRenderRunner == localWeakReference.get()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "addRunner has add the same iRenderRunner:" + paramIRenderRunner);
              break;
            }
          }
        }
      }
      finally {}
      this.a.add(new WeakReference(paramIRenderRunner));
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "addRunner iRenderRunner:" + paramIRenderRunner + ", size: " + this.a);
      }
    }
  }
  
  public void a(IRenderRunner paramIRenderRunner, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_JsRenderRunner", 2, "exeJsOnEngine, renderRunner:" + paramIRenderRunner + ",jsStr:" + paramString);
    }
    if ((paramIRenderRunner != null) && (!TextUtils.isEmpty(paramString))) {
      paramIRenderRunner.exeJsOnEngine(paramString);
    }
  }
  
  public IRenderRunner b(long paramLong)
  {
    ArrayList localArrayList;
    IRenderRunner localIRenderRunner;
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break label269;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloViewWeakReference is null");
          continue;
        }
        localIRenderRunner = (IRenderRunner)localWeakReference.get();
      }
      finally {}
      if (localIRenderRunner == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localIRenderRunner.getRenderThreadId();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId getRenderThreadId:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId find getRenderThreadId:" + l);
          }
          localObject2 = localIRenderRunner;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localIRenderRunner;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localIRenderRunner;; localObject2 = null)
    {
      return localObject2;
      label269:
      if (!localArrayList.isEmpty())
      {
        this.a.removeAll(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId not find");
      }
    }
  }
  
  public void b(IRenderRunner paramIRenderRunner)
  {
    if (paramIRenderRunner == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.a.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramIRenderRunner == localWeakReference.get()))
            {
              localIterator.remove();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner find it:" + paramIRenderRunner);
              break;
            }
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner not find it:" + paramIRenderRunner);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner
 * JD-Core Version:    0.7.0.1
 */