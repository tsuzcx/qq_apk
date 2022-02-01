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
    paramAppBarLayout.jdField_a_of_type_Int = paramInt;
    int i;
    if (paramAppBarLayout.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat != null) {
      i = this.a.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat.getSystemWindowInsetTop();
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
      int m = localLayoutParams.jdField_a_of_type_Int;
      if (m != 1)
      {
        if (m == 2) {
          localViewOffsetHelper.a(Math.round(-paramInt * localLayoutParams.jdField_a_of_type_Float));
        }
      }
      else {
        localViewOffsetHelper.a(MathUtils.clamp(-paramInt, 0, this.a.a(paramAppBarLayout)));
      }
      j += 1;
    }
    this.a.a();
    if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (i > 0)) {
      ViewCompat.postInvalidateOnAnimation(this.a);
    }
    j = this.a.getHeight();
    k = ViewCompat.getMinimumHeight(this.a);
    this.a.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(Math.abs(paramInt) / (j - k - i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout.OffsetUpdateListener
 * JD-Core Version:    0.7.0.1
 */