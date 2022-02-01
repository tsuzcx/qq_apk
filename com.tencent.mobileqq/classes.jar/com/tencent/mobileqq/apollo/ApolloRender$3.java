package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class ApolloRender$3
  implements Runnable
{
  ApolloRender$3(ApolloRender paramApolloRender) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    QLog.i("sava_ApolloRender", 1, "TraceReport CmShowStatUtil preLoadDirector threadPriority:" + i);
    CmShowStatUtil.b("preLoadEngine");
    CmShowStatUtil.a("sava_ApolloRender_preLoadTask");
    if ((WeakReference)ApolloRender.sLocalRender.get() == null) {
      ApolloRender.sLocalRender.set(new WeakReference(this.this$0));
    }
    CmShowStatUtil.a("sava_ApolloRender_preLoadDirector");
    synchronized (ApolloRender.access$200(this.this$0))
    {
      if (!ApolloRender.access$300(this.this$0).b()) {
        ApolloRender.access$300(this.this$0).a(0L, 0, 0, ApolloRender.access$400(this.this$0), 1, ApolloManagerServiceImpl.getOpenGLVersion());
      }
      CmShowStatUtil.b("sava_ApolloRender_preLoadDirector");
    }
    for (;;)
    {
      synchronized (ApolloRender.access$500(this.this$0))
      {
        if ((ApolloRender.access$000(this.this$0)) || (ApolloRender.access$600(this.this$0)) || (ApolloRender.access$700(this.this$0).isEmpty())) {
          break label551;
        }
        IApolloRunnableTask localIApolloRunnableTask = (IApolloRunnableTask)ApolloRender.access$700(this.this$0).remove(0);
        if (localIApolloRunnableTask == null) {
          break label454;
        }
        if (localIApolloRunnableTask.a() == 4) {
          ApolloRender.access$002(this.this$0, true);
        }
        CmShowStatUtil.a("sava_ApolloRender_preLoadDirector_" + localIApolloRunnableTask.a());
        if ((localIApolloRunnableTask.b()) && (ApolloRender.access$300(this.this$0).a(localIApolloRunnableTask.a())))
        {
          QLog.i("sava_ApolloRender", 1, "preLoadDirector continue script isLoaded:" + localIApolloRunnableTask.a());
          if (localIApolloRunnableTask.a() != 4) {
            break label454;
          }
          QLog.i("sava_ApolloRender", 1, "dispose preload director end, return!");
          return;
          localObject1 = finally;
          throw localObject1;
        }
        if (localIApolloRunnableTask.a() == 4) {
          synchronized (ApolloRender.access$200(this.this$0))
          {
            ApolloRender.access$300(this.this$0).a(localIApolloRunnableTask.a());
            localIApolloRunnableTask.run();
            CmShowStatUtil.b("sava_ApolloRender_preLoadDirector_" + localIApolloRunnableTask.a());
          }
        }
      }
      ApolloRender.access$300(this.this$0).a(localObject3.a());
      localObject3.run();
      CmShowStatUtil.b("sava_ApolloRender_preLoadDirector_" + localObject3.a());
      continue;
      label454:
      if ((!ApolloRender.access$000(this.this$0)) && (!ApolloRender.access$600(this.this$0)) && (ApolloRender.access$700(this.this$0).isEmpty())) {
        QLog.i("sava_ApolloRender", 1, "TraceReport_CmShowStatUtil preLoadDirector preLoadQueue is empty! wait");
      }
      try
      {
        ApolloRender.access$802(this.this$0, true);
        ApolloRender.access$500(this.this$0).wait(5000L);
        QLog.i("sava_ApolloRender", 1, "TraceReport_CmShowStatUtil preLoadDirector preLoadQueue is empty! wait end");
        ApolloRender.access$802(this.this$0, false);
      }
      catch (InterruptedException localInterruptedException)
      {
        QLog.e("sava_ApolloRender", 1, localInterruptedException, new Object[0]);
      }
    }
    label551:
    QLog.i("sava_ApolloRender", 1, "preLoadDirector mDestroyed:" + ApolloRender.access$000(this.this$0) + " mSurfaceReady:" + ApolloRender.access$600(this.this$0));
    CmShowStatUtil.b("sava_ApolloRender_preLoadTask");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.3
 * JD-Core Version:    0.7.0.1
 */