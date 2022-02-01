package com.tencent.biz.pubaccount.weishi_new.view.bottomnav;

import android.support.annotation.IdRes;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;", "", "barView", "Landroid/view/View;", "(Landroid/view/View;)V", "barType", "", "getBarType", "()I", "setBarType", "(I)V", "getBarView", "()Landroid/view/View;", "setBarView", "position", "getPosition", "setPosition", "findViewById", "T", "id", "(I)Landroid/view/View;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class WSBottomNavigationBar$BarHolder
{
  private int a;
  private int b;
  @NotNull
  private View c;
  
  public WSBottomNavigationBar$BarHolder(@NotNull View paramView)
  {
    this.c = paramView;
    this.b = -1;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public final View c()
  {
    return this.c;
  }
  
  @Nullable
  public final <T extends View> T c(@IdRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    return this.c.findViewById(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.BarHolder
 * JD-Core Version:    0.7.0.1
 */