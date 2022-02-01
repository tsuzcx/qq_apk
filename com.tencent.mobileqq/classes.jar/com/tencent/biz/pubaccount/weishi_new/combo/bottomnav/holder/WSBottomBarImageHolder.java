package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/WSBottomBarImageHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/AbsWSBottomBarHolder;", "adapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "parent", "Landroid/view/ViewGroup;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;Landroid/view/ViewGroup;)V", "ivBarIcon", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "onBindData", "", "info", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "position", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarImageHolder
  extends AbsWSBottomBarHolder
{
  private KandianUrlImageView c = (KandianUrlImageView)c(1929707539);
  
  public WSBottomBarImageHolder(@NotNull WSBottomBarAdapter paramWSBottomBarAdapter, @NotNull ViewGroup paramViewGroup)
  {
    super(paramWSBottomBarAdapter, paramViewGroup, 1929773056);
  }
  
  public void a(@NotNull WSBottomBarInfo paramWSBottomBarInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSBottomBarInfo, "info");
    WSPicLoader.a().a(this.c, paramWSBottomBarInfo.c(), WSFeedUtils.f(1929641997));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.WSBottomBarImageHolder
 * JD-Core Version:    0.7.0.1
 */