package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class UniversalItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final SparseArray<UniversalItemDecoration.Decoration> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public UniversalItemDecoration()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public static final UniversalItemDecoration.Decoration a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static final UniversalItemDecoration.Decoration a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    UniversalItemDecoration.Decoration localDecoration = new UniversalItemDecoration.Decoration();
    localDecoration.e = paramInt5;
    paramInt5 = (paramInt3 - 1) * paramInt4 / paramInt3;
    int i = paramInt4 - paramInt5;
    localDecoration.c = paramInt4;
    if (paramInt1 % paramInt3 == 0) {
      localDecoration.b = paramInt5;
    }
    while (paramInt1 / paramInt3 == paramInt2 / paramInt3)
    {
      localDecoration.d = paramInt4;
      return localDecoration;
      if ((paramInt1 + 1) % paramInt3 == 0)
      {
        localDecoration.a = paramInt5;
      }
      else
      {
        localDecoration.a = i;
        localDecoration.b = i;
      }
    }
    localDecoration.d = 0;
    return localDecoration;
  }
  
  @Nullable
  public abstract UniversalItemDecoration.Decoration a(int paramInt, @NotNull RecyclerView paramRecyclerView);
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    paramView.setTag(Integer.valueOf(i));
    paramView = a(i, paramRecyclerView);
    if (paramView != null) {
      paramRect.set(paramView.a, paramView.c, paramView.b, paramView.d);
    }
    for (paramRect = paramView;; paramRect = new UniversalItemDecoration.Decoration())
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramRect);
      return;
    }
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      int k = ((Integer)paramState.getTag()).intValue();
      UniversalItemDecoration.Decoration localDecoration = (UniversalItemDecoration.Decoration)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localDecoration.e);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      k = paramState.getBottom() + localLayoutParams.bottomMargin;
      int m = paramState.getLeft() - localLayoutParams.leftMargin;
      int n = paramState.getRight() + localLayoutParams.rightMargin;
      int i1 = paramState.getTop() - localLayoutParams.topMargin;
      paramCanvas.drawRect(m - localDecoration.a, k, localDecoration.b + n, localDecoration.d + k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localDecoration.a, i1 - localDecoration.c, localDecoration.b + n, i1, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(m - localDecoration.a, i1, m, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(n, i1, localDecoration.b + n, k, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.UniversalItemDecoration
 * JD-Core Version:    0.7.0.1
 */