package com.tencent.biz.pubaccount.weishi_new.profile.presenter;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/WSSecondLevelProfilePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/AbsWSProfilePresenter;", "()V", "hasLoadData", "", "isNeedSetVisibleToUserWhenCreated", "isWorksDefaultSelected", "onFragmentVisibilityChanged", "", "fragmentVisible", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSSecondLevelProfilePresenter
  extends AbsWSProfilePresenter
{
  private boolean b;
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (!this.b)
    {
      if (!paramBoolean) {
        return;
      }
      this.b = true;
      a(c(), f());
      a();
    }
  }
  
  public boolean j()
  {
    return true;
  }
  
  public boolean k()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.presenter.WSSecondLevelProfilePresenter
 * JD-Core Version:    0.7.0.1
 */