package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.BarHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/AbsWSBottomBarHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;", "adapter", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "parent", "Landroid/view/ViewGroup;", "layoutId", "", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;Landroid/view/ViewGroup;I)V", "getAdapter", "()Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "barInfo", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "getBarInfo", "()Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "setBarInfo", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;)V", "bindData", "", "info", "position", "onBarViewClick", "view", "Landroid/view/View;", "onBindData", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsWSBottomBarHolder
  extends WSBottomNavigationBar.BarHolder
{
  public static final AbsWSBottomBarHolder.Companion b = new AbsWSBottomBarHolder.Companion(null);
  @NotNull
  public WSBottomBarInfo a;
  @NotNull
  private final WSBottomBarAdapter c;
  
  public AbsWSBottomBarHolder(@NotNull WSBottomBarAdapter paramWSBottomBarAdapter, @NotNull ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup);
    this.c = paramWSBottomBarAdapter;
    c().setOnClickListener((View.OnClickListener)new AbsWSBottomBarHolder.1(this));
  }
  
  @NotNull
  public final WSBottomBarInfo a()
  {
    WSBottomBarInfo localWSBottomBarInfo = this.a;
    if (localWSBottomBarInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfo");
    }
    return localWSBottomBarInfo;
  }
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public abstract void a(@NotNull WSBottomBarInfo paramWSBottomBarInfo, int paramInt);
  
  @NotNull
  public final WSBottomBarAdapter b()
  {
    return this.c;
  }
  
  public final void b(@NotNull WSBottomBarInfo paramWSBottomBarInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSBottomBarInfo, "info");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AbsWSBottomBarHolder.java][bindData] position:");
    localStringBuilder.append(paramInt);
    WSLog.e("AbsWSBottomBarHolderLog", localStringBuilder.toString());
    this.a = paramWSBottomBarInfo;
    a(paramWSBottomBarInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.AbsWSBottomBarHolder
 * JD-Core Version:    0.7.0.1
 */