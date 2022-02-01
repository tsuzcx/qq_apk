package com.etrump.mixlayout;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mobileqq.vas.font.api.IETextView;
import com.tencent.qphone.base.util.QLog;

class ETTextSelection
{
  private IETextView a;
  private ETLayout b;
  private SparseArray<Rect> c = new SparseArray();
  private int[] d = new int[2];
  
  public ETTextSelection(IETextView paramIETextView, ETLayout paramETLayout)
  {
    this.a = paramIETextView;
    this.b = paramETLayout;
  }
  
  void a()
  {
    SparseArray localSparseArray = this.c;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    this.a.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      Object localObject = this.b.b(paramInt1);
      ETTextRange localETTextRange = this.b.b(paramInt2);
      if ((localObject != null) && (localETTextRange != null))
      {
        this.c.clear();
        Rect localRect1;
        if (((ETTextRange)localObject).b == localETTextRange.b)
        {
          localRect1 = new Rect();
          if (localETTextRange.c.left >= ((ETTextRange)localObject).c.left) {
            localRect1.set(((ETTextRange)localObject).c.left, ((ETTextRange)localObject).c.top, localETTextRange.c.right, localETTextRange.c.bottom);
          } else {
            localRect1.set(localETTextRange.c.left, localETTextRange.c.top, ((ETTextRange)localObject).c.left, ((ETTextRange)localObject).c.bottom);
          }
          localRect1.offset(this.a.getPaddingLeft(), this.a.getPaddingTop());
          this.c.append(localETTextRange.b, localRect1);
        }
        else
        {
          int i = ((ETTextRange)localObject).b;
          int j = localETTextRange.b;
          paramInt1 = i;
          paramInt2 = j;
          if (i > j)
          {
            paramInt1 = localETTextRange.b;
            paramInt2 = ((ETTextRange)localObject).b;
          }
          i = paramInt1;
          while (i <= paramInt2)
          {
            localRect1 = new Rect();
            Rect localRect2 = this.b.c(i);
            if (localRect2 == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("no lineBound: ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(this.b.a());
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramInt1);
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramInt2);
              QLog.e("ETTextSelection", 1, ((StringBuilder)localObject).toString());
              return;
            }
            if (localETTextRange.b > ((ETTextRange)localObject).b)
            {
              if (i == paramInt1) {
                localRect1.set(((ETTextRange)localObject).c.left, ((ETTextRange)localObject).c.top, localRect2.right, localRect2.bottom);
              } else if (i == paramInt2) {
                localRect1.set(localRect2.left, localRect2.top, localETTextRange.c.right, localETTextRange.c.bottom);
              } else {
                localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
              }
            }
            else if (i == paramInt1) {
              localRect1.set(localETTextRange.c.left, localETTextRange.c.top, localRect2.right, localRect2.bottom);
            } else if (i == paramInt2) {
              localRect1.set(localRect2.left, localRect2.top, ((ETTextRange)localObject).c.left, ((ETTextRange)localObject).c.bottom);
            } else {
              localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
            }
            localRect1.offset(this.a.getPaddingLeft(), this.a.getPaddingTop());
            this.c.append(i, localRect1);
            i += 1;
          }
        }
        this.a.invalidate();
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    ETTextRange localETTextRange = this.b.b(i);
    if (localETTextRange == null) {
      return;
    }
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length < 2) {
        return;
      }
      this.a.getLocationInWindow(paramArrayOfInt);
      if (paramBoolean)
      {
        paramArrayOfInt[0] += this.a.getPaddingLeft() + localETTextRange.c.left;
        paramArrayOfInt[1] += this.a.getPaddingTop() + localETTextRange.c.bottom;
        return;
      }
      paramArrayOfInt[0] += this.a.getPaddingLeft() + localETTextRange.c.right;
      paramArrayOfInt[1] += this.a.getPaddingTop() + localETTextRange.c.bottom;
    }
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    this.a.getLocationInWindow(this.d);
    return this.b.a(paramInt1 - this.d[0] - this.a.getPaddingLeft(), paramInt2 - this.d[1] - this.a.getPaddingTop());
  }
  
  SparseArray<Rect> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextSelection
 * JD-Core Version:    0.7.0.1
 */