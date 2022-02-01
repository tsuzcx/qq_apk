package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

class f$a
  extends ListView
{
  private boolean a;
  private boolean b;
  
  private f$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2131034798);
    this.b = paramBoolean;
    setCacheColorHint(0);
  }
  
  final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt2 + paramInt3;
    }
    if ((j <= 0) || (localObject == null)) {
      j = 0;
    }
    int i1 = localListAdapter.getCount();
    paramInt2 += paramInt3;
    localObject = null;
    int k = 0;
    int i = 0;
    int n;
    for (paramInt3 = 0; k < i1; paramInt3 = n)
    {
      n = localListAdapter.getItemViewType(k);
      int m = i;
      if (n != i)
      {
        localObject = null;
        m = n;
      }
      localObject = localListAdapter.getView(k, (View)localObject, this);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((View)localObject).getLayoutParams().height;
      }
      if (i > 0) {
        i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      } else {
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      if (localObject != null) {
        ((View)localObject).measure(paramInt1, i);
      }
      i = paramInt2;
      if (k > 0) {
        i = paramInt2 + j;
      }
      paramInt2 = i;
      if (localObject != null) {
        paramInt2 = i + ((View)localObject).getMeasuredHeight();
      }
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (k > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt3 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt2 != paramInt4) {
                paramInt1 = paramInt3;
              }
            }
          }
        }
        return paramInt1;
      }
      n = paramInt3;
      if (paramInt5 >= 0)
      {
        n = paramInt3;
        if (k >= paramInt5) {
          n = paramInt2;
        }
      }
      k += 1;
      i = m;
    }
    return paramInt2;
  }
  
  public boolean hasFocus()
  {
    return (this.b) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.b) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.b) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.b) && (this.a)) || (super.isInTouchMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.f.a
 * JD-Core Version:    0.7.0.1
 */