package com.tencent.biz.qqcircle.richframework.sender.iml;

import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSPreloadReqInterceptor;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleSenderReqInterceptor;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.chain.BaseSenderChain.BaseSenderChainBuilder;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleRequestCall
  extends BaseCall<QCircleBaseRequest>
{
  private int g = 2;
  private boolean h = true;
  private boolean i = true;
  private WeakReference<QFSUIStateBaseManager> j;
  private QFSPreloadReqInterceptor k;
  
  private void a(List<ReqInterceptor> paramList)
  {
    WeakReference localWeakReference = this.j;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      paramList.add(this.j.get());
    }
  }
  
  private void b(List<RspInterceptor> paramList)
  {
    WeakReference localWeakReference = this.j;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      paramList.add(this.j.get());
    }
  }
  
  private void c(List<ReqInterceptor> paramList)
  {
    QFSPreloadReqInterceptor localQFSPreloadReqInterceptor = this.k;
    if (localQFSPreloadReqInterceptor != null) {
      paramList.add(localQFSPreloadReqInterceptor);
    }
  }
  
  public QCircleRequestCall a(QFSUIStateBaseManager paramQFSUIStateBaseManager)
  {
    if (paramQFSUIStateBaseManager != null) {
      this.j = new WeakReference(paramQFSUIStateBaseManager);
    }
    return this;
  }
  
  public QCircleRequestCall a(String paramString)
  {
    this.k = new QFSPreloadReqInterceptor(paramString, false);
    return this;
  }
  
  public QCircleRequestCall a(String paramString, QCircleBaseRequest paramQCircleBaseRequest)
  {
    this.k = new QFSPreloadReqInterceptor(paramString, true);
    a(paramQCircleBaseRequest);
    return this;
  }
  
  public QCircleRequestCall a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public void a()
  {
    Object localObject1 = new QCircleOutboxInterceptor();
    ((QCircleOutboxInterceptor)localObject1).a(this.i);
    Object localObject2 = new ArrayList();
    a((List)localObject2);
    ((List)localObject2).addAll(this.a);
    if (this.h)
    {
      localObject3 = this.e.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((QCircleBaseRequest)((Iterator)localObject3).next()).setRetryCount(this.g);
      }
      ((List)localObject2).add(localObject1);
    }
    c((List)localObject2);
    ((List)localObject2).add(new QCircleSenderReqInterceptor());
    Object localObject3 = new ArrayList();
    if (this.h) {
      ((List)localObject3).add(localObject1);
    }
    ((List)localObject3).addAll(this.b);
    b((List)localObject3);
    localObject1 = BaseSenderChain.BaseSenderChainBuilder.a().a((List)localObject2).b((List)localObject3).a(new WeakReference(this.c)).a(0).b(0).a(this.d).c(this.f).b();
    localObject2 = this.e.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((BaseSenderChain)localObject1).a((QCircleBaseRequest)((Iterator)localObject2).next());
    }
  }
  
  public QCircleRequestCall b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public QCircleRequestCall c(boolean paramBoolean)
  {
    this.d.putBoolean("qfs_extra_data_key_is_load_more", paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall
 * JD-Core Version:    0.7.0.1
 */