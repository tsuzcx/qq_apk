package com.tencent.biz.pubaccount.weishi_new.combo.main;

import com.tencent.biz.pubaccount.weishi_new.IWSPresenter;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$Presenter;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$View;", "checkIfNeedClearAioListRedDot", "", "createBottomBarInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "bottomBarInfoList", "getMsgRedDot", "getOffscreenPageLimit", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSComboMainContract$Presenter
  extends IWSPresenter<WSComboMainContract.View>
{
  @NotNull
  public abstract IWSFragmentFactory a(@NotNull List<WSBottomBarInfo> paramList);
  
  @NotNull
  public abstract List<WSBottomBarInfo> a();
  
  public abstract int b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainContract.Presenter
 * JD-Core Version:    0.7.0.1
 */