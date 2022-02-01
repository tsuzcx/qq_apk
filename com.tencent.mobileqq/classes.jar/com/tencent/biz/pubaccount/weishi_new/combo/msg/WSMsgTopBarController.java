package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.AbsWSTopBarController;
import com.tencent.biz.pubaccount.weishi_new.view.topnav.WSTopNavigationBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgTopBarController;", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/AbsWSTopBarController;", "topNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment;)V", "setBackBtnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setDetailBtnClickListener", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgTopBarController
  extends AbsWSTopBarController
{
  private final WSTopNavigationBar a;
  private final WSMsgFragment b;
  
  public WSMsgTopBarController(@NotNull WSTopNavigationBar paramWSTopNavigationBar, @NotNull WSMsgFragment paramWSMsgFragment)
  {
    super(paramWSTopNavigationBar, 1929773083);
    this.a = paramWSTopNavigationBar;
    this.b = paramWSMsgFragment;
  }
  
  public final void a(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.a.setBackBtnClickListener(paramOnClickListener);
  }
  
  public final void b(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.a.setDetailBtnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgTopBarController
 * JD-Core Version:    0.7.0.1
 */