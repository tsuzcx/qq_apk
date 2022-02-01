package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class EllipsizeLayout
  extends LinearLayout
{
  private final boolean a;
  
  public EllipsizeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EllipsizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EllipsizeLayout).getBoolean(R.styleable.EllipsizeLayout_center_ellipsize_textview, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      int i3 = getChildCount();
      int i2 = View.MeasureSpec.getSize(paramInt1) - (getPaddingLeft() + getPaddingRight());
      int i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
      Object localObject1 = null;
      int i = 0;
      int m = 0;
      int n;
      int j;
      for (int k = 0;; k = n)
      {
        n = 1;
        int i1 = 1;
        if ((m >= i3) || (i != 0)) {
          break;
        }
        View localView = getChildAt(m);
        j = i;
        Object localObject2 = localObject1;
        n = k;
        if (localView != null)
        {
          j = i;
          localObject2 = localObject1;
          n = k;
          if (localView.getVisibility() != 8)
          {
            if ((localView instanceof TextView))
            {
              localObject2 = (TextView)localView;
              if (((TextView)localObject2).getEllipsize() != null) {
                if (localObject1 == null)
                {
                  ((TextView)localObject2).setMaxWidth(2147483647);
                  if (this.a) {
                    ((LinearLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).leftMargin = 0;
                  }
                  localObject1 = localObject2;
                }
                else
                {
                  i = 1;
                }
              }
            }
            measureChildWithMargins(localView, i4, 0, paramInt2, 0);
            localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            if (localObject2 != null)
            {
              if (((LinearLayout.LayoutParams)localObject2).weight > 0.0F) {
                j = i1;
              } else {
                j = 0;
              }
              n = k + (localView.getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((LinearLayout.LayoutParams)localObject2).rightMargin);
              j = i | j;
              localObject2 = localObject1;
            }
            else
            {
              j = 1;
              n = k;
              localObject2 = localObject1;
            }
          }
        }
        m += 1;
        i = j;
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        if (k != 0) {
          n = 0;
        }
        m = localObject1.getMeasuredWidth() - (k - i2);
        j = m;
        if ((i | n) == 0)
        {
          j = m;
          if (k > i2)
          {
            i = m;
            if (m < 0) {
              i = 0;
            }
            localObject1.setMaxWidth(i);
            j = i;
          }
        }
        if ((this.a) && (localObject1.getMeasuredWidth() > 0))
        {
          if (k > i2) {
            i = k - localObject1.getMeasuredWidth();
          } else {
            i = (i2 - localObject1.getMeasuredWidth()) / 2;
          }
          ((LinearLayout.LayoutParams)localObject1.getLayoutParams()).leftMargin = i;
          localObject1.setMaxWidth(j - i);
        }
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.EllipsizeLayout
 * JD-Core Version:    0.7.0.1
 */