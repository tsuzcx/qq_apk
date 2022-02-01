package com.tencent.luggage.wxa.pq;

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
  
  public f$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2131034798);
    this.b = paramBoolean;
    setCacheColorHint(0);
  }
  
  final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    paramInt3 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int i = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt2 + paramInt3;
    }
    if ((i <= 0) || (localObject == null)) {
      i = 0;
    }
    int i1 = localListAdapter.getCount();
    paramInt3 = paramInt2 + paramInt3;
    localObject = null;
    int j = 0;
    int m = 0;
    int n;
    for (paramInt2 = 0; j < i1; paramInt2 = n)
    {
      n = localListAdapter.getItemViewType(j);
      int k = m;
      if (n != m)
      {
        localObject = null;
        k = n;
      }
      localObject = localListAdapter.getView(j, (View)localObject, this);
      m = ((View)localObject).getLayoutParams().height;
      if (m > 0) {
        m = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
      } else {
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      ((View)localObject).measure(paramInt1, m);
      m = paramInt3;
      if (j > 0) {
        m = paramInt3 + i;
      }
      paramInt3 = m + ((View)localObject).getMeasuredHeight();
      if (paramInt3 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (j > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt2 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt3 != paramInt4) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
        return paramInt1;
      }
      n = paramInt2;
      if (paramInt5 >= 0)
      {
        n = paramInt2;
        if (j >= paramInt5) {
          n = paramInt3;
        }
      }
      j += 1;
      m = k;
    }
    return paramInt3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.f.a
 * JD-Core Version:    0.7.0.1
 */