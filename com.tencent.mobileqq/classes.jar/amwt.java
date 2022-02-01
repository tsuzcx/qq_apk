import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amwt
{
  private List<WeakReference<amwx>> a = new ArrayList();
  
  public amwx a()
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      amwx localamwx;
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
          localamwx = (amwx)localWeakReference.get();
          if (localamwx == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localamwx instanceof View)) && (((View)localamwx).getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localamwx);
        }
        Object localObject2 = localamwx;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localamwx;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localamwx;; localObject2 = null)
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
  
  public amwx a(int paramInt)
  {
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      amwx localamwx;
      try
      {
        i = this.a.size();
        localArrayList = new ArrayList();
        i -= 1;
        if (i < 0) {
          break label235;
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
          localamwx = (amwx)localWeakReference.get();
          if (localamwx == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            localArrayList.add(localWeakReference);
          }
        }
      }
      finally {}
      if (((localamwx instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localamwx).getGameId() == paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner find renderTask:" + localamwx);
        }
        Object localObject2 = localamwx;
        if (!localArrayList.isEmpty())
        {
          this.a.removeAll(localArrayList);
          localObject2 = localamwx;
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
          }
        }
        for (localObject2 = localamwx;; localObject2 = null)
        {
          return localObject2;
          label235:
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
  
  public amwx a(long paramLong)
  {
    ArrayList localArrayList;
    amwx localamwx;
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
        localamwx = (amwx)localWeakReference.get();
      }
      finally {}
      if (localamwx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localamwx.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext getRuntimeState:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext find getRuntimeState:" + l);
          }
          localObject2 = localamwx;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localamwx;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localamwx;; localObject2 = null)
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
  
  public void a(amwx paramamwx)
  {
    if (paramamwx == null) {}
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
            if ((localWeakReference != null) && (paramamwx == localWeakReference.get()))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "addRunner has add the same iRenderRunner:" + paramamwx);
              break;
            }
          }
        }
      }
      finally {}
      this.a.add(new WeakReference(paramamwx));
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "addRunner iRenderRunner:" + paramamwx + ", size: " + this.a);
      }
    }
  }
  
  public void a(amwx paramamwx, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_JsRenderRunner", 2, "exeJsOnEngine, renderRunner:" + paramamwx + ",jsStr:" + paramString);
    }
    if ((paramamwx != null) && (!TextUtils.isEmpty(paramString))) {
      paramamwx.exeJsOnEngine(paramString);
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
        localamwx = (amwx)localWeakReference.get();
      }
      finally {}
      amwx localamwx;
      if (localamwx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localamwx.getRuntimeState();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine getRuntimeState runtimeState:" + l);
        }
        if (paramLong == localamwx.getRuntimeState())
        {
          localamwx.runRenderTask(new ApolloRenderRunner.1(this, localamwx, paramLong, paramApolloCmdChannel, paramInt, paramString1, paramString2));
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
          QLog.d("apollochannel_JsRenderRunner", 2, "lState != apolloSurfaceView.getRuntimeState(), renderThreadId:" + localamwx.getRuntimeState());
        }
      }
    }
  }
  
  public amwx b(long paramLong)
  {
    ArrayList localArrayList;
    amwx localamwx;
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
        localamwx = (amwx)localWeakReference.get();
      }
      finally {}
      if (localamwx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloSurfaceView is null");
        }
        localArrayList.add(localWeakReference);
      }
      else
      {
        long l = localamwx.getRenderThreadId();
        if (QLog.isColorLevel()) {
          QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId getRenderThreadId:" + l);
        }
        if (paramLong == l)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId find getRenderThreadId:" + l);
          }
          localObject2 = localamwx;
          if (!localArrayList.isEmpty())
          {
            this.a.removeAll(localArrayList);
            localObject2 = localamwx;
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "mRenderRunners.removeAll(invalidRunners):" + this.a.size());
            }
          }
        }
      }
    }
    for (Object localObject2 = localamwx;; localObject2 = null)
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
  
  public void b(amwx paramamwx)
  {
    if (paramamwx == null) {}
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
            if ((localWeakReference != null) && (paramamwx == localWeakReference.get()))
            {
              localIterator.remove();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner find it:" + paramamwx);
              break;
            }
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "removeRunner not find it:" + paramamwx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwt
 * JD-Core Version:    0.7.0.1
 */