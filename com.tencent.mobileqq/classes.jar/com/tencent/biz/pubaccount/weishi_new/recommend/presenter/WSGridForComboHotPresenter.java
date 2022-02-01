package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/recommend/presenter/WSGridForComboHotPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/recommend/presenter/WSGridForHotPresenter;", "subTabId", "", "(Ljava/lang/String;)V", "getLastFeedId", "isCurrentImmersionBottomBar", "", "isIgnoreCacheDataOnPause", "isIgnoreFetchGridDataFromCache", "isNeedContinueAioListFeed", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSGridForComboHotPresenter
  extends WSGridForHotPresenter
{
  public WSGridForComboHotPresenter(@NotNull String paramString)
  {
    super(paramString);
  }
  
  private final boolean u()
  {
    return Intrinsics.areEqual(WSComboHelper.a.a(), "monofeed_tab");
  }
  
  protected boolean o()
  {
    return false;
  }
  
  protected boolean p()
  {
    if (u()) {
      return true;
    }
    return super.p();
  }
  
  @Nullable
  protected String s()
  {
    if (WSComboExpHelper.a.e()) {
      return super.s();
    }
    return "";
  }
  
  protected boolean t()
  {
    if (WSComboExpHelper.a.e()) {
      return super.t();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridForComboHotPresenter
 * JD-Core Version:    0.7.0.1
 */