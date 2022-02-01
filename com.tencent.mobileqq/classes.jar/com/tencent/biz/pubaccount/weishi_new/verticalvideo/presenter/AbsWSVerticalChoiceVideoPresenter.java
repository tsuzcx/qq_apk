package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public abstract class AbsWSVerticalChoiceVideoPresenter
  extends AbsWSVerticalPagePresenter
{
  private WeakReference<IWSEpisodeChoiceView> a;
  private boolean b;
  
  public AbsWSVerticalChoiceVideoPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
    a(z().v());
  }
  
  private void O()
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataRefreshFromServer]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = y();
    if (localIWSEpisodeChoiceView == null) {
      return;
    }
    localIWSEpisodeChoiceView.d();
  }
  
  private void P()
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataMoreFromServer]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = y();
    if (localIWSEpisodeChoiceView == null) {
      return;
    }
    localIWSEpisodeChoiceView.b(u() ^ true);
  }
  
  private IWSEpisodeChoiceView y()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (IWSEpisodeChoiceView)localWeakReference.get();
  }
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    return new HashMap();
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = y();
    if (paramString == null) {
      return;
    }
    paramString.e();
    paramString.b(u() ^ true);
    paramString.d();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.b = paramBundle.getBoolean("auto_show_panel", true);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][onPageSelected]");
    paramViewHolder = y();
    if (paramViewHolder != null)
    {
      if (!paramViewHolder.isShowing()) {
        return;
      }
      paramViewHolder.f();
    }
  }
  
  public void a(IWSEpisodeChoiceView paramIWSEpisodeChoiceView)
  {
    if (paramIWSEpisodeChoiceView == null) {
      return;
    }
    paramIWSEpisodeChoiceView.a(this);
    this.a = new WeakReference(paramIWSEpisodeChoiceView);
    paramIWSEpisodeChoiceView.a(this);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.c) {
      O();
    }
  }
  
  protected void a(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.a(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][fillData]");
    paramView = y();
    if (paramView == null) {
      return;
    }
    paramView.a(paramList);
  }
  
  protected void a(boolean paramBoolean, IWSEpisodeChoiceView paramIWSEpisodeChoiceView)
  {
    Object localObject = z();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).g();
    if ((paramIWSEpisodeChoiceView != null) && (paramBoolean) && (localObject != null) && (((List)localObject).size() > 0))
    {
      ((WSVerticalItemData)((List)localObject).get(0)).a(true);
      paramIWSEpisodeChoiceView.a((List)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramString);
    if (this.c) {
      P();
    }
  }
  
  protected void b(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.b(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][setData]");
    paramView = y();
    if (paramView == null) {
      return;
    }
    paramView.b(paramList);
  }
  
  protected void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnSuccess]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = y();
    if ((paramBoolean2) || (paramBoolean1)) {
      O();
    }
    a(paramBoolean2, localIWSEpisodeChoiceView);
    super.b(paramList, paramBoolean1, paramBoolean2, paramObject);
    if ((paramBoolean2) || (!paramBoolean1)) {
      P();
    }
    if ((paramBoolean2) && (localIWSEpisodeChoiceView != null))
    {
      if (!this.b) {
        return;
      }
      localIWSEpisodeChoiceView.c();
    }
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.c(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][insertDataToTop]");
    paramView = y();
    if (paramView == null) {
      return;
    }
    paramView.c(paramList);
  }
  
  public void h()
  {
    super.h();
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = y();
    if (localIWSEpisodeChoiceView != null)
    {
      if (!localIWSEpisodeChoiceView.isShowing()) {
        return;
      }
      localIWSEpisodeChoiceView.dismiss();
    }
  }
  
  public boolean u()
  {
    return true;
  }
  
  public boolean v()
  {
    return true;
  }
  
  public abstract String w();
  
  public String x()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalChoiceVideoPresenter
 * JD-Core Version:    0.7.0.1
 */