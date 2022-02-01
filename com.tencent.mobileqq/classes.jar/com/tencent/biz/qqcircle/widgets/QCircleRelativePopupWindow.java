package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.PopupWindowCompat;

public class QCircleRelativePopupWindow
  extends PopupWindow
{
  public QCircleRelativePopupWindow() {}
  
  public QCircleRelativePopupWindow(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleRelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleRelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static int a(int paramInt)
  {
    if (paramInt != -2) {
      return 1073741824;
    }
    return 0;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(b(paramInt1, paramInt2), a(paramInt1));
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      return View.MeasureSpec.getSize(paramInt1);
    }
    return paramInt2;
  }
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    setClippingEnabled(paramBoolean);
    Object localObject = getContentView();
    Rect localRect = new Rect();
    ((View)localObject).getWindowVisibleDisplayFrame(localRect);
    int i = localRect.width();
    int k = localRect.height();
    ((View)localObject).measure(a(getWidth(), i), a(getHeight(), k));
    int j = ((View)localObject).getMeasuredWidth();
    int m = ((View)localObject).getMeasuredHeight();
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int n = localObject[1] + paramView.getHeight();
    if (!paramBoolean)
    {
      paramInt3 += localObject[0];
      i = paramInt4 + n;
      paramInt4 = paramInt3;
    }
    else
    {
      i = paramInt4;
      paramInt4 = paramInt3;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        paramInt3 = i;
        if (paramInt1 == 2) {
          break label219;
        }
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            paramInt3 = i;
            break label219;
          }
          paramInt3 = i - m;
          break label219;
        }
        paramInt1 = paramView.getHeight();
      }
      else
      {
        paramInt1 = paramView.getHeight() + m;
      }
    }
    else {
      paramInt1 = paramView.getHeight() / 2 + m / 2;
    }
    paramInt3 = i - paramInt1;
    label219:
    if (paramInt2 != 0)
    {
      paramInt1 = j;
      if (paramInt2 != 1) {
        if (paramInt2 != 2)
        {
          paramInt1 = paramInt4;
          if (paramInt2 == 3) {
            break label299;
          }
          if (paramInt2 != 4)
          {
            paramInt1 = paramInt4;
            break label299;
          }
          paramInt1 = j - paramView.getWidth();
        }
        else
        {
          paramInt1 = paramView.getWidth();
          break label294;
        }
      }
      paramInt1 = paramInt4 - paramInt1;
      break label299;
    }
    else
    {
      paramInt1 = paramView.getWidth() / 2 - j / 2;
    }
    label294:
    paramInt1 = paramInt4 + paramInt1;
    label299:
    if (paramBoolean)
    {
      paramInt2 = paramInt3 + n;
      if (paramInt2 < 0) {
        paramInt3 = -n;
      } else if (paramInt2 + m > k) {
        paramInt3 = k - n - m;
      }
      PopupWindowCompat.showAsDropDown(this, paramView, paramInt1, paramInt3, 0);
      return;
    }
    showAtLocation(paramView, 0, paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */