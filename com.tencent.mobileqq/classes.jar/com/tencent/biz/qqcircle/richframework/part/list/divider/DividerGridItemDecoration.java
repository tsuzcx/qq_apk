package com.tencent.biz.qqcircle.richframework.part.list.divider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class DividerGridItemDecoration
  extends RecyclerView.ItemDecoration
{
  private static final int[] a = { 16843284 };
  private Drawable b;
  private Paint c;
  private int d = 2;
  
  public DividerGridItemDecoration(Context paramContext, int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.c = new Paint(1);
    this.c.setColor(paramContext.getResources().getColor(paramInt2));
    this.c.setStyle(Paint.Style.FILL);
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      return ((GridLayoutManager)paramRecyclerView).getSpanCount();
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      return ((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount();
    }
    return -1;
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool4 = paramRecyclerView instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4)
    {
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool3;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        bool1 = bool2;
        if ((paramInt1 + 1) % paramInt2 == 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    boolean bool4 = paramRecyclerView instanceof GridLayoutManager;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4)
    {
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool3;
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        bool1 = bool2;
        if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if ((paramInt1 + 1) % paramInt2 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getLeft() - localLayoutParams.leftMargin;
      int m = ((View)localObject).getRight() + localLayoutParams.rightMargin + this.d;
      int n = ((View)localObject).getBottom() + localLayoutParams.bottomMargin;
      int i1 = this.d + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(k, n, m, i1);
        this.b.draw(paramCanvas);
      }
      localObject = this.c;
      if (localObject != null) {
        paramCanvas.drawRect(k, n, m, i1, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getTop() - localLayoutParams.topMargin;
      int m = ((View)localObject).getBottom() + localLayoutParams.bottomMargin;
      int n = ((View)localObject).getRight() + localLayoutParams.rightMargin;
      int i1 = this.d + n;
      localObject = this.b;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(n, k, i1, m);
        this.b.draw(paramCanvas);
      }
      localObject = this.c;
      if (localObject != null) {
        paramCanvas.drawRect(n, k, i1, m, (Paint)localObject);
      }
      i += 1;
    }
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = a(paramRecyclerView);
    int j = paramRecyclerView.getAdapter().getItemCount();
    if (b(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, this.d, 0);
      return;
    }
    if (a(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, 0, this.d);
      return;
    }
    paramInt = this.d;
    paramRect.set(0, 0, paramInt, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    a(paramCanvas, paramRecyclerView);
    b(paramCanvas, paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.divider.DividerGridItemDecoration
 * JD-Core Version:    0.7.0.1
 */