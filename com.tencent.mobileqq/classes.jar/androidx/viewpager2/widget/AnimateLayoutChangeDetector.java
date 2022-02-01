package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;

final class AnimateLayoutChangeDetector
{
  private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS = new ViewGroup.MarginLayoutParams(-1, -1);
  private LinearLayoutManager mLayoutManager;
  
  static
  {
    ZERO_MARGIN_LAYOUT_PARAMS.setMargins(0, 0, 0, 0);
  }
  
  AnimateLayoutChangeDetector(@NonNull LinearLayoutManager paramLinearLayoutManager)
  {
    this.mLayoutManager = paramLinearLayoutManager;
  }
  
  private boolean arePagesLaidOutContiguously()
  {
    int n = this.mLayoutManager.getChildCount();
    if (n == 0) {
      return true;
    }
    if (this.mLayoutManager.getOrientation() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
    int j = 0;
    while (j < n)
    {
      View localView = this.mLayoutManager.getChildAt(j);
      if (localView != null)
      {
        Object localObject = localView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
        } else {
          localObject = ZERO_MARGIN_LAYOUT_PARAMS;
        }
        int[] arrayOfInt1 = arrayOfInt[j];
        int k;
        int m;
        if (i != 0)
        {
          k = localView.getLeft();
          m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        }
        else
        {
          k = localView.getTop();
          m = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
        }
        arrayOfInt1[0] = (k - m);
        arrayOfInt1 = arrayOfInt[j];
        if (i != 0)
        {
          k = localView.getRight();
          m = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        else
        {
          k = localView.getBottom();
          m = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        }
        arrayOfInt1[1] = (k + m);
        j += 1;
      }
      else
      {
        throw new IllegalStateException("null view contained in the view hierarchy");
      }
    }
    Arrays.sort(arrayOfInt, new AnimateLayoutChangeDetector.1(this));
    int i = 1;
    while (i < n)
    {
      if (arrayOfInt[(i - 1)][1] != arrayOfInt[i][0]) {
        return false;
      }
      i += 1;
    }
    i = arrayOfInt[0][1];
    j = arrayOfInt[0][0];
    if (arrayOfInt[0][0] <= 0) {
      return arrayOfInt[(n - 1)][1] >= i - j;
    }
    return false;
  }
  
  private boolean hasRunningChangingLayoutTransition()
  {
    int j = this.mLayoutManager.getChildCount();
    int i = 0;
    while (i < j)
    {
      if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean hasRunningChangingLayoutTransition(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      LayoutTransition localLayoutTransition = paramView.getLayoutTransition();
      if ((localLayoutTransition != null) && (localLayoutTransition.isChangingLayout())) {
        return true;
      }
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (hasRunningChangingLayoutTransition(paramView.getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  boolean mayHaveInterferingAnimations()
  {
    return ((!arePagesLaidOutContiguously()) || (this.mLayoutManager.getChildCount() <= 1)) && (hasRunningChangingLayoutTransition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.AnimateLayoutChangeDetector
 * JD-Core Version:    0.7.0.1
 */