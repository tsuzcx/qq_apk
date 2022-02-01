package com.tencent.biz.pubaccount.weishi_new.combo.home.topbar;

import com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboTopBarChangeForDiscovery;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/IWSTopBarChangeListener;", "topBarController", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;)V", "changeTextColorOnPagerScrolled", "", "positionOffset", "", "changeTextColorOnTabSelected", "tabIndex", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboTopBarChangeForDiscovery
  implements IWSTopBarChangeListener
{
  private final WSComboHomeTopBarController a;
  private final WSComboHomeFragment b;
  
  public WSComboTopBarChangeForDiscovery(@NotNull WSComboHomeTopBarController paramWSComboHomeTopBarController, @NotNull WSComboHomeFragment paramWSComboHomeFragment)
  {
    this.a = paramWSComboHomeTopBarController;
    this.b = paramWSComboHomeFragment;
  }
  
  public void a(float paramFloat)
  {
    WSTabItemViewHolder localWSTabItemViewHolder = this.a.a();
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.b(paramFloat);
    }
    localWSTabItemViewHolder = this.a.b();
    if (localWSTabItemViewHolder != null)
    {
      float f = 0.0F;
      if (WeishiUtils.a(paramFloat, 0.0F)) {
        paramFloat = f;
      } else {
        paramFloat = 1.0F - paramFloat;
      }
      localWSTabItemViewHolder.b(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.b.a(true);
    if (paramInt == 0)
    {
      localObject = this.a.a();
      if (localObject != null) {
        ((WSTabItemViewHolder)localObject).a(-16777216);
      }
      localObject = this.a.b();
      if (localObject != null) {
        ((WSTabItemViewHolder)localObject).a();
      }
      this.a.a(1, true);
      return;
    }
    Object localObject = this.a.a();
    if (localObject != null) {
      ((WSTabItemViewHolder)localObject).a();
    }
    localObject = this.a.b();
    if (localObject != null) {
      ((WSTabItemViewHolder)localObject).a(-16777216);
    }
    localObject = this.a;
    WSExpABTestManager localWSExpABTestManager = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSExpABTestManager, "WSExpABTestManager.getInstance()");
    ((WSComboHomeTopBarController)localObject).a(1, localWSExpABTestManager.m() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.topbar.WSComboTopBarChangeForDiscovery
 * JD-Core Version:    0.7.0.1
 */