package com.tencent.biz.pubaccount.weishi_new.profile.presenter;

import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.Presenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/WSProfilePresenterFactory;", "", "()V", "createPresenter", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$Presenter;", "pageType", "", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfilePresenterFactory
{
  public static final WSProfilePresenterFactory.Companion a = new WSProfilePresenterFactory.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final WSProfilePresenterFactory a()
  {
    return a.a();
  }
  
  @NotNull
  public final WSProfileContract.Presenter a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return (WSProfileContract.Presenter)new WSRightPageProfilePresenter();
        }
        throw ((Throwable)new Exception("profile type is wrong."));
      }
      return (WSProfileContract.Presenter)new WSSecondLevelProfilePresenter();
    }
    return (WSProfileContract.Presenter)new WSMainHostProfilePresenter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.presenter.WSProfilePresenterFactory
 * JD-Core Version:    0.7.0.1
 */