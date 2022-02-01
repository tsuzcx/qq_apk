package com.google.android.material.bottomappbar;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.google.android.material.R.dimen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import java.lang.ref.WeakReference;

class BottomAppBar$Behavior$1
  implements View.OnLayoutChangeListener
{
  BottomAppBar$Behavior$1(BottomAppBar.Behavior paramBehavior) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    BottomAppBar localBottomAppBar = (BottomAppBar)BottomAppBar.Behavior.a(this.a).get();
    if ((localBottomAppBar != null) && ((paramView instanceof FloatingActionButton)))
    {
      FloatingActionButton localFloatingActionButton = (FloatingActionButton)paramView;
      localFloatingActionButton.a(BottomAppBar.Behavior.a(this.a));
      paramInt1 = BottomAppBar.Behavior.a(this.a).height();
      localBottomAppBar.a(paramInt1);
      paramView = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      if (BottomAppBar.Behavior.a(this.a) == 0)
      {
        paramInt1 = (localFloatingActionButton.getMeasuredHeight() - paramInt1) / 2;
        paramInt2 = localBottomAppBar.getResources().getDimensionPixelOffset(R.dimen.O);
        paramView.bottomMargin = (BottomAppBar.e(localBottomAppBar) + (paramInt2 - paramInt1));
        paramView.leftMargin = BottomAppBar.f(localBottomAppBar);
        paramView.rightMargin = BottomAppBar.g(localBottomAppBar);
        if (ViewUtils.a(localFloatingActionButton))
        {
          paramView.leftMargin += BottomAppBar.h(localBottomAppBar);
          return;
        }
        paramView.rightMargin += BottomAppBar.h(localBottomAppBar);
      }
      return;
    }
    paramView.removeOnLayoutChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.Behavior.1
 * JD-Core Version:    0.7.0.1
 */