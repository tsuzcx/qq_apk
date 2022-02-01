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
  private boolean f;
  
  public AbsWSVerticalChoiceVideoPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
    a(a().a());
  }
  
  private IWSEpisodeChoiceView a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (IWSEpisodeChoiceView)localWeakReference.get();
  }
  
  private void k()
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataRefreshFromServer]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = a();
    if (localIWSEpisodeChoiceView == null) {
      return;
    }
    localIWSEpisodeChoiceView.c();
  }
  
  private void l()
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnLoadGridDataMoreFromServer]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = a();
    if (localIWSEpisodeChoiceView == null) {
      return;
    }
    localIWSEpisodeChoiceView.b(e() ^ true);
  }
  
  public abstract String a();
  
  public Map<String, String> a(WSVerticalItemData paramWSVerticalItemData)
  {
    return new HashMap();
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = a();
    if (paramString == null) {
      return;
    }
    paramString.d();
    paramString.b(e() ^ true);
    paramString.c();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.f = paramBundle.getBoolean("auto_show_panel", true);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][onPageSelected]");
    paramViewHolder = a();
    if (paramViewHolder != null)
    {
      if (!paramViewHolder.isShowing()) {
        return;
      }
      paramViewHolder.e();
    }
  }
  
  public void a(IWSEpisodeChoiceView paramIWSEpisodeChoiceView)
  {
    if (paramIWSEpisodeChoiceView == null) {
      return;
    }
    paramIWSEpisodeChoiceView.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIWSEpisodeChoiceView);
    paramIWSEpisodeChoiceView.a(this);
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
  }
  
  protected void a(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.a(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][fillData]");
    paramView = a();
    if (paramView == null) {
      return;
    }
    paramView.a(paramList);
  }
  
  protected void a(boolean paramBoolean, IWSEpisodeChoiceView paramIWSEpisodeChoiceView)
  {
    List localList = a().a();
    if ((paramIWSEpisodeChoiceView != null) && (paramBoolean) && (localList != null) && (localList.size() > 0))
    {
      ((WSVerticalItemData)localList.get(0)).a(true);
      paramIWSEpisodeChoiceView.a(localList);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramString);
    if (this.jdField_a_of_type_Boolean) {
      l();
    }
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.b(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][setData]");
    paramView = a();
    if (paramView == null) {
      return;
    }
    paramView.b(paramList);
  }
  
  protected void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][handleOnSuccess]");
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = a();
    if ((paramBoolean2) || (paramBoolean1)) {
      k();
    }
    a(paramBoolean2, localIWSEpisodeChoiceView);
    super.b(paramList, paramBoolean1, paramBoolean2, paramObject);
    if ((paramBoolean2) || (!paramBoolean1)) {
      l();
    }
    if ((paramBoolean2) && (localIWSEpisodeChoiceView != null))
    {
      if (!this.f) {
        return;
      }
      localIWSEpisodeChoiceView.b();
    }
  }
  
  protected void c(@NonNull List<WSVerticalItemData> paramList, WSVerticalPageContract.View paramView)
  {
    super.c(paramList, paramView);
    WSLog.e("AbsWSVerticalChoiceVideoPresenter", "[AbsWSVerticalChoiceVideoPresenter.java][insertDataToTop]");
    paramView = a();
    if (paramView == null) {
      return;
    }
    paramView.c(paramList);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public void h()
  {
    super.h();
    IWSEpisodeChoiceView localIWSEpisodeChoiceView = a();
    if (localIWSEpisodeChoiceView != null)
    {
      if (!localIWSEpisodeChoiceView.isShowing()) {
        return;
      }
      localIWSEpisodeChoiceView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalChoiceVideoPresenter
 * JD-Core Version:    0.7.0.1
 */