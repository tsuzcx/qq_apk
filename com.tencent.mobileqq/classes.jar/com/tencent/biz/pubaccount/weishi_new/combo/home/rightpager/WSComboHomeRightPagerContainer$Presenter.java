package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager;

import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerContainer$Presenter;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerContainer$View;", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "getOffscreenPageLimit", "", "getSelectedPagerIndex", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSComboHomeRightPagerContainer$Presenter
  extends IWSPresenter<WSComboHomeRightPagerContainer.View>
{
  @NotNull
  public abstract IWSFragmentFactory a();
  
  public abstract int b();
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboHomeRightPagerContainer.Presenter
 * JD-Core Version:    0.7.0.1
 */