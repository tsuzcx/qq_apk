package com.tencent.biz.pubaccount.weishi_new.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$HeaderBehavior$FlingRunnable;", "Ljava/lang/Runnable;", "behavior", "Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$HeaderBehavior;", "child", "Landroid/widget/LinearLayout;", "scroller", "Landroid/widget/OverScroller;", "(Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$HeaderBehavior;Landroid/widget/LinearLayout;Landroid/widget/OverScroller;)V", "lastScrollY", "", "run", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
final class WSBehaviorSuite$HeaderBehavior$FlingRunnable
  implements Runnable
{
  private int a;
  private final WSBehaviorSuite.HeaderBehavior b;
  private final LinearLayout c;
  private final OverScroller d;
  
  public WSBehaviorSuite$HeaderBehavior$FlingRunnable(@NotNull WSBehaviorSuite.HeaderBehavior paramHeaderBehavior, @NotNull LinearLayout paramLinearLayout, @NotNull OverScroller paramOverScroller)
  {
    this.b = paramHeaderBehavior;
    this.c = paramLinearLayout;
    this.d = paramOverScroller;
  }
  
  public void run()
  {
    if (!this.d.computeScrollOffset()) {
      return;
    }
    int i = WSBehaviorSuite.HeaderBehavior.a(this.b, this.c);
    if (this.a == 0)
    {
      this.a = this.d.getCurrY();
    }
    else
    {
      int j = this.d.getCurrY() - this.a;
      this.a = this.d.getCurrY();
      if (this.c.getTop() == -i)
      {
        int[] arrayOfInt = new int[2];
        NestedScrollingChildHelper localNestedScrollingChildHelper = WSBehaviorSuite.HeaderBehavior.a(this.b);
        if (localNestedScrollingChildHelper != null) {
          localNestedScrollingChildHelper.dispatchNestedScroll(0, 0, 0, j, null, 0, arrayOfInt);
        }
        if (arrayOfInt[1] == 0) {
          WSBehaviorSuite.HeaderBehavior.b(this.b);
        }
      }
      else
      {
        WSBehaviorSuite.HeaderBehavior.a(this.b, this.c, j);
      }
    }
    ViewCompat.postOnAnimation((View)this.c, (Runnable)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.HeaderBehavior.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */