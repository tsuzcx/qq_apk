package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForAioAtFriendPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForCLinkPresenter;", "view", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageContract$View;", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageContract$View;)V", "fetchFeedData", "", "isRefresh", "isFirst", "from", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVerticalForAioAtFriendPresenter
  extends WSVerticalForCLinkPresenter
{
  public WSVerticalForAioAtFriendPresenter(@NotNull WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString)
  {
    paramString = z();
    if (paramString != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "view ?: return false");
      ThreadManager.executeOnSubThread((Runnable)new WSVerticalForAioAtFriendPresenter.fetchFeedData.1(this, paramBoolean1, paramBoolean2, paramString));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioAtFriendPresenter
 * JD-Core Version:    0.7.0.1
 */