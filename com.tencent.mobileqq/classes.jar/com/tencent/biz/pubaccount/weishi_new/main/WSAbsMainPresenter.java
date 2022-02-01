package com.tencent.biz.pubaccount.weishi_new.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.QBaseFragment;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public abstract class WSAbsMainPresenter
  implements WSMainContract.Presenter, WSVideoPageChangeObserver
{
  public static final int PAGE_INDEX_LEFT = 0;
  public static final int PAGE_INDEX_RIGHT = 1;
  protected List<QBaseFragment> mFragments;
  private final WeakReference<WSMainContract.View> mViewWeakReference;
  
  public WSAbsMainPresenter(WSMainContract.View paramView)
  {
    this.mViewWeakReference = new WeakReference(paramView);
    this.mFragments = createFragments();
  }
  
  public void attachView(@NonNull WSMainContract.View paramView) {}
  
  protected abstract List<QBaseFragment> createFragments();
  
  public void destroy() {}
  
  public void detachView() {}
  
  public List<QBaseFragment> getFragments(Bundle paramBundle)
  {
    return this.mFragments;
  }
  
  @Nullable
  public stSimpleMetaFeed getIntentFeed()
  {
    return null;
  }
  
  @NonNull
  public String getIntentFeedId()
  {
    return "";
  }
  
  public WSMainContract.View getView()
  {
    return (WSMainContract.View)this.mViewWeakReference.get();
  }
  
  public void onVideoPageHeaderClick()
  {
    WSMainContract.View localView = getView();
    if (localView == null) {
      return;
    }
    WSLog.a("WSVerticalMainPresenter", "[WSVerticalMainPresenter.java][onVideoPageHeaderClick]");
    localView.r();
  }
  
  public void onVideoSelected(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    paramWSVerticalItemData = getView();
    if (paramWSVerticalItemData == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalMainPresenter.java][onVideoSelected] position");
    localStringBuilder.append(paramInt);
    WSLog.a("WSVerticalMainPresenter", localStringBuilder.toString());
    boolean bool = false;
    paramWSVerticalItemData.h(false);
    if (paramInt == 1) {
      bool = true;
    }
    paramWSVerticalItemData.g(bool);
  }
  
  public void onVideoSelectedIdle(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    WSMainContract.View localView = getView();
    if (localView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalMainPresenter.java][onVideoSelectedIdle] position");
    localStringBuilder.append(paramInt);
    WSLog.a("WSVerticalMainPresenter", localStringBuilder.toString());
    boolean bool;
    if (paramWSVerticalItemData.b().video_type != 2) {
      bool = true;
    } else {
      bool = false;
    }
    setCanScrollHorizontally(localView, paramWSVerticalItemData);
    ((WSRightContainerFragment)this.mFragments.get(1)).a(bool, paramWSVerticalItemData);
  }
  
  protected void reportAvatarClick(WSVerticalPageFragment paramWSVerticalPageFragment, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Object localObject = (WSVerticalPageContract.Presenter)paramWSVerticalPageFragment.aO_();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WSVerticalPageContract.Presenter)localObject).n();
    }
    WSVerticalBeaconReport.a(paramWSVerticalPageFragment.k(), paramWSVerticalPageFragment.l(), "left_slide", 1007007, paramstSimpleMetaFeed, (Map)localObject);
  }
  
  protected void setCanScrollHorizontally(WSMainContract.View paramView, WSVerticalItemData paramWSVerticalItemData)
  {
    boolean bool;
    if (paramWSVerticalItemData.b().video_type != 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramWSVerticalItemData = new StringBuilder();
    paramWSVerticalItemData.append("[WSVerticalMainPresenter.java][setCanScrollHorizontally] isNotAdType:");
    paramWSVerticalItemData.append(bool);
    WSLog.a("WSVerticalMainPresenter", paramWSVerticalItemData.toString());
    paramView.h(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSAbsMainPresenter
 * JD-Core Version:    0.7.0.1
 */