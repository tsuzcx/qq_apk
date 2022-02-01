package com.tencent.biz.pubaccount.weishi_new.combo;

import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/IWSBaseView;", "getFragments", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "scrollToLeftFragment", "", "scrollToRightFragment", "setViewPagerScrollHorizontally", "scrollable", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSComboMainContainerContract$View
  extends IWSBaseView
{
  public abstract void aG_();
  
  public abstract void b_(boolean paramBoolean);
  
  @Nullable
  public abstract List<QBaseFragment> c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainContainerContract.View
 * JD-Core Version:    0.7.0.1
 */