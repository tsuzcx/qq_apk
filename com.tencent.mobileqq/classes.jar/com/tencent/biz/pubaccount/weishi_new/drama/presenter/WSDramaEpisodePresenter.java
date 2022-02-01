package com.tencent.biz.pubaccount.weishi_new.drama.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeedsParams;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.View;
import mqq.util.WeakReference;

public class WSDramaEpisodePresenter
  implements WSDramaEpisodeContract.Presenter
{
  private final WeakReference<WSDramaEpisodeContract.View> a;
  
  public WSDramaEpisodePresenter(WSDramaEpisodeContract.View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void a()
  {
    WSDramaEpisodeContract.View localView = b();
    if (localView == null) {
      return;
    }
    WSDramaDataManager.a().a(localView.l(), new WSDramaEpisodePresenter.1(this, localView));
  }
  
  public void a(@NonNull WSDramaEpisodeContract.View paramView) {}
  
  public void a(String paramString, int paramInt)
  {
    WSDramaEpisodeContract.View localView = b();
    if (localView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = new WSDramaFeedsParams(localView.l(), paramString, paramInt, -1);
      WSDramaDataManager.a().a(paramString, new WSDramaEpisodePresenter.3(this, localView));
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    WSDramaEpisodeContract.View localView = b();
    if (localView == null) {
      return;
    }
    paramString = new WSDramaFeedsParams(localView.l(), paramString, paramInt, -1);
    paramString.b(true);
    WSDramaDataManager.a().a(paramString, new WSDramaEpisodePresenter.2(this, localView));
  }
  
  public WSDramaEpisodeContract.View b()
  {
    return (WSDramaEpisodeContract.View)this.a.get();
  }
  
  public void destroy() {}
  
  public void detachView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaEpisodePresenter
 * JD-Core Version:    0.7.0.1
 */