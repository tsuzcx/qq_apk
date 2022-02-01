package com.tencent.biz.pubaccount.weishi_new.drama.presenter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;

public abstract class AbsWSDramaPagePresenter
  extends WSBasePresenter<WSDramaPageContract.View>
  implements IFetchDataRspListener<WSDramaItemData>, WSDramaPageContract.Presenter
{
  private boolean a;
  
  private String a()
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)a();
    if (localView != null) {
      return localView.a();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString)
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)a();
    if ((localView != null) && (localView.a() != null) && (localView.a().isEmpty())) {
      localView.a(paramInt, paramString);
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AbsWSDramaPagePresenter.java][handleOnFailed] errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errorMsg:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", isFirst:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.d("AbsWSDramaPagePresenterLog", ((StringBuilder)localObject).toString());
    localObject = (WSDramaPageContract.View)a();
    if (localObject == null) {
      return;
    }
    this.a = false;
    ((WSDramaPageContract.View)localObject).f();
    a(paramInt, paramString);
  }
  
  private void a(List<WSDramaItemData> paramList, boolean paramBoolean)
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)a();
    if (localView == null) {
      return;
    }
    if (paramBoolean)
    {
      localView.a(paramList);
      return;
    }
    localView.a(paramList);
  }
  
  private void b(List<WSDramaItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)a();
    if (localView == null) {
      return;
    }
    this.a = false;
    localView.f();
    if (paramList.size() > 0)
    {
      a(paramList, a(paramBoolean1, paramBoolean2, paramList, paramObject));
      return;
    }
    a(-1, "");
  }
  
  protected WSDramaPageAdapter a()
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)a();
    if (localView != null) {
      return localView.a();
    }
    return null;
  }
  
  protected AbsWSDramaVideoHolder a()
  {
    WSDramaPageAdapter localWSDramaPageAdapter = a();
    if (localWSDramaPageAdapter != null) {
      return localWSDramaPageAdapter.a();
    }
    return null;
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramString, paramBoolean1);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent) {}
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(List<WSDramaItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    b(paramList, paramBoolean1, paramBoolean2, paramObject);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a) {
      return;
    }
    this.a = a(paramBoolean1, paramBoolean2, a());
  }
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSDramaItemData> paramList, Object paramObject)
  {
    return paramBoolean2;
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c()
  {
    a(true, false);
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.presenter.AbsWSDramaPagePresenter
 * JD-Core Version:    0.7.0.1
 */