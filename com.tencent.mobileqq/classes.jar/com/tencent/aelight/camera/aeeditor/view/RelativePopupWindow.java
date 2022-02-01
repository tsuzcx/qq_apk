package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.widget.PopupWindowCompat;

public class RelativePopupWindow
  extends PopupWindow
{
  public RelativePopupWindow() {}
  
  public RelativePopupWindow(Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelativePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void a(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, 0, 0);
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
    int j = localRect.height();
    ((View)localObject).measure(a(getWidth(), i), a(getHeight(), j));
    i = ((View)localObject).getMeasuredWidth();
    int k = ((View)localObject).getMeasuredHeight();
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int m = localObject[1] + paramView.getHeight();
    if (!paramBoolean)
    {
      paramInt3 += localObject[0];
      paramInt4 += m;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            paramInt1 = paramInt4;
            break label195;
          }
          paramInt1 = paramInt4 - k;
          break label195;
        }
        paramInt1 = paramView.getHeight();
      }
      else
      {
        paramInt1 = paramView.getHeight() + k;
      }
    }
    else {
      paramInt1 = paramView.getHeight() / 2 + k / 2;
    }
    paramInt1 = paramInt4 - paramInt1;
    label195:
    if (paramInt2 != 0)
    {
      paramInt4 = i;
      if (paramInt2 != 1) {
        if (paramInt2 != 2)
        {
          paramInt4 = paramInt3;
          if (paramInt2 == 3) {
            break label282;
          }
          if (paramInt2 != 4)
          {
            paramInt4 = paramInt3;
            break label282;
          }
          paramInt4 = i - paramView.getWidth();
        }
        else
        {
          paramInt2 = paramView.getWidth();
          break label276;
        }
      }
      paramInt4 = paramInt3 - paramInt4;
      break label282;
    }
    else
    {
      paramInt2 = paramView.getWidth() / 2 - i / 2;
    }
    label276:
    paramInt4 = paramInt3 + paramInt2;
    label282:
    if (paramBoolean)
    {
      paramInt2 = paramInt1 + m;
      if (paramInt2 < 0) {
        paramInt1 = -m;
      } else if (paramInt2 + k > j) {
        paramInt1 = j - m - k;
      }
      PopupWindowCompat.showAsDropDown(this, paramView, paramInt4, paramInt1, 0);
      return;
    }
    showAtLocation(paramView, 0, paramInt4, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.RelativePopupWindow
 * JD-Core Version:    0.7.0.1
 */