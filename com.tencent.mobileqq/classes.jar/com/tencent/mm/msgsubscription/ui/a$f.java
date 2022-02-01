package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$f
  extends RecyclerView.ItemDecoration
{
  private final int b = com.tencent.luggage.wxa.qx.a.a(r.a(), 0.5F);
  private final int c = com.tencent.luggage.wxa.qx.a.e(r.a(), 40);
  @NotNull
  private final Paint d = new Paint();
  
  a$f()
  {
    this.d.setColor(a.a(locala).getResources().getColor(2131165993));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setFlags(1);
    this.d.setStrokeWidth(this.b);
  }
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "outRect");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    if (paramRecyclerView.getChildAdapterPosition(paramView) == 0)
    {
      int i = this.b;
      paramRect.set(0, i, 0, i);
      return;
    }
    paramRect.set(0, 0, 0, this.b);
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "c");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    float f1 = paramRecyclerView.getPaddingLeft();
    float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(paramState, "child");
      Object localObject = paramState.getLayoutParams();
      if (localObject != null)
      {
        localObject = (RecyclerView.LayoutParams)localObject;
        float f3 = paramState.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.b;
        if (i == 0)
        {
          float f4 = paramState.getTop() + ((RecyclerView.LayoutParams)localObject).topMargin - this.b;
          if (paramCanvas != null) {
            paramCanvas.drawLine(f1, f4, f2, f4, this.d);
          }
        }
        if (i == paramRecyclerView.getChildCount() - 1)
        {
          if (paramCanvas != null) {
            paramCanvas.drawLine(f1, f3, f2, f3, this.d);
          }
        }
        else if (paramCanvas != null) {
          paramCanvas.drawLine(f1 + this.c, f3, f2, f3, this.d);
        }
        i += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.f
 * JD-Core Version:    0.7.0.1
 */