package com.tencent.biz.pubaccount.weishi_new.combo;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$Presenter;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$View;", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "doOnCreate", "", "doOnDestroy", "donOnDestroyView", "getOffscreenPageLimit", "", "initGdtManager", "context", "Landroid/content/Context;", "onRightLeftPageSelected", "position", "reqAioListOperationFeed", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSComboMainContainerContract$Presenter
  extends IWSPresenter<WSComboMainContainerContract.View>
{
  @NotNull
  public abstract IWSFragmentFactory createFragmentFactory();
  
  public abstract void doOnCreate();
  
  public abstract void doOnDestroy();
  
  public abstract void donOnDestroyView();
  
  public abstract void initGdtManager(@NotNull Context paramContext);
  
  public abstract void onRightLeftPageSelected(int paramInt);
  
  public abstract void reqAioListOperationFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainContainerContract.Presenter
 * JD-Core Version:    0.7.0.1
 */