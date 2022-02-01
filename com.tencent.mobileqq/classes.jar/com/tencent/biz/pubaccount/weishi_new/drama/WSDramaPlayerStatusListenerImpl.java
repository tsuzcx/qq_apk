package com.tencent.biz.pubaccount.weishi_new.drama;

import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerStatusListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import mqq.util.WeakReference;

public class WSDramaPlayerStatusListenerImpl
  implements WSPlayerStatusListener
{
  private WeakReference<WSDramaPageContract.View> a;
  
  public void a(WSDramaPageContract.View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPlayerStatusListenerImpl.java][onVideoStop] title:");
    if (paramWSPlayerParam.c != null) {
      localObject = paramWSPlayerParam.c.g;
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    WSLog.e("WSDramaPlayerStatusListenerImpl", localStringBuilder.toString());
    Object localObject = (WSDramaPageContract.View)this.a.get();
    if (localObject != null)
    {
      WSDramaUtils.b((WSDramaPageContract.View)localObject, paramWSPlayerParam, paramBoolean);
      ((WSDramaPageContract.View)localObject).a(paramWSPlayerParam, paramBoolean);
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPlayerStatusListenerImpl.java][onVideoStart] title:");
    if (paramWSPlayerParam.c != null) {
      localObject = paramWSPlayerParam.c.g;
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    WSLog.e("WSDramaPlayerStatusListenerImpl", localStringBuilder.toString());
    Object localObject = (WSDramaPageContract.View)this.a.get();
    if (localObject != null)
    {
      WSDramaUtils.a((WSDramaPageContract.View)localObject, paramWSPlayerParam, ((WSDramaPageContract.View)localObject).aL_());
      ((WSDramaPageContract.View)localObject).a(paramWSPlayerParam);
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPlayerStatusListenerImpl.java][onCompletion] title:");
    if (paramWSPlayerParam.c != null) {
      localObject = paramWSPlayerParam.c.g;
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    WSLog.e("WSDramaPlayerStatusListenerImpl", localStringBuilder.toString());
    Object localObject = (WSDramaPageContract.View)this.a.get();
    if (localObject != null)
    {
      WSDramaUtils.b((WSDramaPageContract.View)localObject, paramWSPlayerParam, true);
      ((WSDramaPageContract.View)localObject).b(paramWSPlayerParam);
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam) {}
  
  public void e(WSPlayerParam paramWSPlayerParam) {}
  
  public void f(WSPlayerParam paramWSPlayerParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */