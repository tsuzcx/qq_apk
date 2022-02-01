package com.google.android.material.appbar;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.CollapsingTextHelper;

class CollapsingToolbarLayout$OffsetUpdateListener
  implements AppBarLayout.OnOffsetChangedListener
{
  CollapsingToolbarLayout$OffsetUpdateListener(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public void a(AppBarLayout paramAppBarLayout, int paramInt)
  {
    paramAppBarLayout = this.a;
    paramAppBarLayout.c = paramInt;
    int i;
    if (paramAppBarLayout.d != null) {
      i = this.a.d.getSystemWindowInsetTop();
    } else {
      i = 0;
    }
    int k = this.a.getChildCount();
    int j = 0;
    while (j < k)
    {
      paramAppBarLayout = this.a.getChildAt(j);
      CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
      ViewOffsetHelper localViewOffsetHelper = CollapsingToolbarLayout.a(paramAppBarLayout);
      int m = localLayoutParams.a;
      if (m != 1)
      {
        if (m == 2) {
          localViewOffsetHelper.a(Math.round(-paramInt * localLayoutParams.b));
        }
      }
      else {
        localViewOffsetHelper.a(MathUtils.clamp(-paramInt, 0, this.a.b(paramAppBarLayout)));
      }
      j += 1;
    }
    this.a.b();
    if ((this.a.b != null) && (i > 0)) {
      ViewCompat.postInvalidateOnAnimation(this.a);
    }
    j = this.a.getHeight();
    k = ViewCompat.getMinimumHeight(this.a);
    this.a.a.b(Math.abs(paramInt) / (j - k - i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout.OffsetUpdateListener
 * JD-Core Version:    0.7.0.1
 */