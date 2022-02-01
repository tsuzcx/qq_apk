package com.tencent.biz.pubaccount.weishi_new.drama;

import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import mqq.util.WeakReference;

public class WSDramaPlayerUIDelegate
  implements IWSPlayerUIDelegate
{
  private final WeakReference<WSDramaItemVideoAreaController> a;
  private final WeakReference<AbsWSDramaVideoHolder> b;
  
  public WSDramaPlayerUIDelegate(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    this.b = new WeakReference(paramAbsWSDramaVideoHolder);
    this.a = new WeakReference(a(paramAbsWSDramaVideoHolder));
  }
  
  private WSDramaItemVideoAreaController a(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    paramAbsWSDramaVideoHolder = b(paramAbsWSDramaVideoHolder);
    if (paramAbsWSDramaVideoHolder != null) {
      return paramAbsWSDramaVideoHolder.e();
    }
    return null;
  }
  
  private void a()
  {
    Object localObject = (AbsWSDramaVideoHolder)this.b.get();
    if (localObject != null)
    {
      localObject = ((AbsWSDramaVideoHolder)localObject).a();
      if (localObject != null) {
        ((WSDramaPageContract.View)localObject).r();
      }
    }
  }
  
  private AbsWSDramaVideoItemView b(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    if ((paramAbsWSDramaVideoHolder != null) && ((paramAbsWSDramaVideoHolder.b instanceof AbsWSDramaVideoItemView))) {
      return (AbsWSDramaVideoItemView)paramAbsWSDramaVideoHolder.b;
    }
    return null;
  }
  
  private void b()
  {
    Object localObject = (AbsWSDramaVideoHolder)this.b.get();
    if (localObject != null)
    {
      localObject = ((AbsWSDramaVideoHolder)localObject).a();
      if (localObject != null) {
        ((WSDramaPageContract.View)localObject).u();
      }
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.a(8, 400);
      paramWSPlayerParam.n();
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(paramString);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, long paramLong1, long paramLong2) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if ((paramWSPlayerParam != null) && (paramBoolean1) && (paramBoolean2)) {
      paramWSPlayerParam.a(8, 400);
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c(WSPlayerParam paramWSPlayerParam) {}
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.a(8, 400);
      paramWSPlayerParam.n();
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam) {}
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.n();
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(0, 100);
    }
  }
  
  public void h(WSPlayerParam paramWSPlayerParam)
  {
    a();
  }
  
  public void i(WSPlayerParam paramWSPlayerParam)
  {
    b();
  }
  
  public void j(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = (WSDramaItemVideoAreaController)this.a.get();
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(0, 100);
    }
  }
  
  public boolean k(WSPlayerParam paramWSPlayerParam)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPlayerUIDelegate
 * JD-Core Version:    0.7.0.1
 */