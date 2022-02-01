package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/WSBottomBarHolderFactory;", "", "()V", "createBarHolder", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/AbsWSBottomBarHolder;", "adapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "parent", "Landroid/view/ViewGroup;", "type", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarHolderFactory
{
  public static final WSBottomBarHolderFactory a = new WSBottomBarHolderFactory();
  
  @NotNull
  public final AbsWSBottomBarHolder a(@NotNull WSBottomBarAdapter paramWSBottomBarAdapter, @NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSBottomBarAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return (AbsWSBottomBarHolder)new WSBottomBarNormalHolder(paramWSBottomBarAdapter, paramViewGroup);
      }
      return (AbsWSBottomBarHolder)new WSBottomBarImageHolder(paramWSBottomBarAdapter, paramViewGroup);
    }
    return (AbsWSBottomBarHolder)new WSBottomBarNormalHolder(paramWSBottomBarAdapter, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.WSBottomBarHolderFactory
 * JD-Core Version:    0.7.0.1
 */