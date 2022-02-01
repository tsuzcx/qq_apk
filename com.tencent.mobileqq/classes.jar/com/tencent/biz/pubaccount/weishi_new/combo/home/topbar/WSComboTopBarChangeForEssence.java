package com.tencent.biz.pubaccount.weishi_new.combo.home.topbar;

import com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboTopBarChangeForEssence;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/IWSTopBarChangeListener;", "topBarController", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/home/topbar/WSComboHomeTopBarController;Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;)V", "changeTextColorOnPagerScrolled", "", "positionOffset", "", "changeTextColorOnTabSelected", "tabIndex", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboTopBarChangeForEssence
  implements IWSTopBarChangeListener
{
  private final WSComboHomeTopBarController a;
  private final WSComboHomeFragment b;
  
  public WSComboTopBarChangeForEssence(@NotNull WSComboHomeTopBarController paramWSComboHomeTopBarController, @NotNull WSComboHomeFragment paramWSComboHomeFragment)
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
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      localWSTabItemViewHolder = this.a.a();
      if (localWSTabItemViewHolder != null) {
        localWSTabItemViewHolder.a(-16777216);
      }
      localWSTabItemViewHolder = this.a.b();
      if (localWSTabItemViewHolder != null) {
        localWSTabItemViewHolder.a();
      }
      this.a.a(1, true);
      this.b.a(true);
      return;
    }
    WSTabItemViewHolder localWSTabItemViewHolder = this.a.a();
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.a();
    }
    localWSTabItemViewHolder = this.a.b();
    if (localWSTabItemViewHolder != null) {
      localWSTabItemViewHolder.a(-1);
    }
    this.a.a(3, false);
    this.b.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.topbar.WSComboTopBarChangeForEssence
 * JD-Core Version:    0.7.0.1
 */