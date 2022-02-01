package com.tencent.biz.pubaccount.weishi_new.view.topnav;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.LayoutRes;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/AbsWSTopBarController;", "", "topNavigationBar", "Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "id", "", "(Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;I)V", "centerContentView", "Landroid/view/View;", "getCenterContentView", "()Landroid/view/View;", "setCenterContentView", "(Landroid/view/View;)V", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsWSTopBarController
{
  @NotNull
  private View a;
  private final WSTopNavigationBar b;
  
  public AbsWSTopBarController(@NotNull WSTopNavigationBar paramWSTopNavigationBar, @LayoutRes int paramInt)
  {
    this.b = paramWSTopNavigationBar;
    paramWSTopNavigationBar = this.b.getLayoutParams();
    if (paramWSTopNavigationBar != null)
    {
      paramWSTopNavigationBar = (RelativeLayout.LayoutParams)paramWSTopNavigationBar;
      paramWSTopNavigationBar.setMargins(0, ImmersiveUtils.getStatusBarHeight((Context)BaseApplicationImpl.getContext()), 0, 0);
      this.b.setLayoutParams((ViewGroup.LayoutParams)paramWSTopNavigationBar);
      this.a = this.b.a(paramInt);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  @NotNull
  public final View c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.topnav.AbsWSTopBarController
 * JD-Core Version:    0.7.0.1
 */