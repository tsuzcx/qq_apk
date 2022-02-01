package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer;
import java.util.ArrayList;

class ConstraintLayout$Measurer
  implements BasicMeasure.Measurer
{
  ConstraintLayout layout;
  int layoutHeightSpec;
  int layoutWidthSpec;
  int paddingBottom;
  int paddingHeight;
  int paddingTop;
  int paddingWidth;
  
  public ConstraintLayout$Measurer(ConstraintLayout paramConstraintLayout1, ConstraintLayout paramConstraintLayout2)
  {
    this.layout = paramConstraintLayout2;
  }
  
  public void captureLayoutInfos(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.paddingTop = paramInt3;
    this.paddingBottom = paramInt4;
    this.paddingWidth = paramInt5;
    this.paddingHeight = paramInt6;
    this.layoutWidthSpec = paramInt1;
    this.layoutHeightSpec = paramInt2;
  }
  
  public final void didMeasures()
  {
    int k = this.layout.getChildCount();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      View localView = this.layout.getChildAt(i);
      if ((localView instanceof Placeholder)) {
        ((Placeholder)localView).updatePostMeasure(this.layout);
      }
      i += 1;
    }
    k = ConstraintLayout.access$000(this.layout).size();
    if (k > 0)
    {
      i = j;
      while (i < k)
      {
        ((ConstraintHelper)ConstraintLayout.access$000(this.layout).get(i)).updatePostMeasure(this.layout);
        i += 1;
      }
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final void measure(ConstraintWidget paramConstraintWidget, BasicMeasure.Measure paramMeasure)
  {
    if (paramConstraintWidget == null) {
      return;
    }
    if ((paramConstraintWidget.getVisibility() == 8) && (!paramConstraintWidget.isInPlaceholder()))
    {
      paramMeasure.measuredWidth = 0;
      paramMeasure.measuredHeight = 0;
      paramMeasure.measuredBaseline = 0;
      return;
    }
    Object localObject1 = paramMeasure.horizontalBehavior;
    Object localObject2 = paramMeasure.verticalBehavior;
    int j = paramMeasure.horizontalDimension;
    int n = paramMeasure.verticalDimension;
    int i1 = this.paddingTop + this.paddingBottom;
    int i = this.paddingWidth;
    View localView = (View)paramConstraintWidget.getCompanionWidget();
    int k = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[localObject1.ordinal()];
    if (k != 1) {
      if (k != 2) {
        if (k != 3) {
          if (k != 4) {
            i = 0;
          }
        }
      }
    }
    int m;
    for (;;)
    {
      m = 0;
      j = i;
      break;
      m = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i, -2);
      if (paramConstraintWidget.mMatchConstraintDefaultWidth == 1) {
        i = 1;
      } else {
        i = 0;
      }
      paramConstraintWidget.wrapMeasure[2] = 0;
      j = m;
      if (paramMeasure.useCurrentDimensions)
      {
        if (((i != 0) && (paramConstraintWidget.wrapMeasure[3] != 0) && (paramConstraintWidget.wrapMeasure[0] != paramConstraintWidget.getWidth())) || ((localView instanceof Placeholder))) {
          k = 1;
        } else {
          k = 0;
        }
        if (i != 0)
        {
          j = m;
          if (k == 0) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.getWidth(), 1073741824);
          continue;
          i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i + paramConstraintWidget.getHorizontalMargin(), -1);
          paramConstraintWidget.wrapMeasure[2] = -1;
          continue;
          j = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i, -2);
          paramConstraintWidget.wrapMeasure[2] = -2;
        }
      }
      m = 1;
      break;
      i = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      paramConstraintWidget.wrapMeasure[2] = j;
    }
    i = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[localObject2.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      n = 0;
      k = i;
      i = n;
      break;
      i1 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i1, -2);
      if (paramConstraintWidget.mMatchConstraintDefaultHeight == 1) {
        i = 1;
      } else {
        i = 0;
      }
      paramConstraintWidget.wrapMeasure[3] = 0;
      k = i1;
      if (paramMeasure.useCurrentDimensions)
      {
        if (((i != 0) && (paramConstraintWidget.wrapMeasure[2] != 0) && (paramConstraintWidget.wrapMeasure[1] != paramConstraintWidget.getHeight())) || ((localView instanceof Placeholder))) {
          n = 1;
        } else {
          n = 0;
        }
        if (i != 0)
        {
          k = i1;
          if (n == 0) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.getHeight(), 1073741824);
          continue;
          i = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i1 + paramConstraintWidget.getVerticalMargin(), -1);
          paramConstraintWidget.wrapMeasure[3] = -1;
          continue;
          k = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i1, -2);
          paramConstraintWidget.wrapMeasure[3] = -2;
        }
      }
      i = 1;
      break;
      i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
      paramConstraintWidget.wrapMeasure[3] = n;
    }
    if (localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      n = 1;
    } else {
      n = 0;
    }
    int i5;
    if (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    if ((localObject2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) && (localObject2 != ConstraintWidget.DimensionBehaviour.FIXED)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2;
    if ((localObject1 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) && (localObject1 != ConstraintWidget.DimensionBehaviour.FIXED)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    int i3;
    if ((n != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if ((i5 != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    localObject1 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
    if ((!paramMeasure.useCurrentDimensions) && (n != 0) && (paramConstraintWidget.mMatchConstraintDefaultWidth == 0) && (i5 != 0) && (paramConstraintWidget.mMatchConstraintDefaultHeight == 0))
    {
      j = 0;
      m = 0;
      i = 0;
    }
    else
    {
      if (((localView instanceof VirtualLayout)) && ((paramConstraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)))
      {
        localObject2 = (androidx.constraintlayout.solver.widgets.VirtualLayout)paramConstraintWidget;
        ((VirtualLayout)localView).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout)localObject2, j, k);
      }
      else
      {
        localView.measure(j, k);
      }
      int i7 = localView.getMeasuredWidth();
      i5 = localView.getMeasuredHeight();
      int i6 = localView.getBaseline();
      if (m != 0)
      {
        paramConstraintWidget.wrapMeasure[0] = i7;
        paramConstraintWidget.wrapMeasure[2] = i5;
      }
      else
      {
        paramConstraintWidget.wrapMeasure[0] = 0;
        paramConstraintWidget.wrapMeasure[2] = 0;
      }
      if (i != 0)
      {
        paramConstraintWidget.wrapMeasure[1] = i5;
        paramConstraintWidget.wrapMeasure[3] = i7;
      }
      else
      {
        paramConstraintWidget.wrapMeasure[1] = 0;
        paramConstraintWidget.wrapMeasure[3] = 0;
      }
      if (paramConstraintWidget.mMatchConstraintMinWidth > 0) {
        i = Math.max(paramConstraintWidget.mMatchConstraintMinWidth, i7);
      } else {
        i = i7;
      }
      m = i;
      if (paramConstraintWidget.mMatchConstraintMaxWidth > 0) {
        m = Math.min(paramConstraintWidget.mMatchConstraintMaxWidth, i);
      }
      if (paramConstraintWidget.mMatchConstraintMinHeight > 0) {
        n = Math.max(paramConstraintWidget.mMatchConstraintMinHeight, i5);
      } else {
        n = i5;
      }
      i = n;
      if (paramConstraintWidget.mMatchConstraintMaxHeight > 0) {
        i = Math.min(paramConstraintWidget.mMatchConstraintMaxHeight, n);
      }
      float f;
      if ((i3 != 0) && (i1 != 0))
      {
        f = paramConstraintWidget.mDimensionRatio;
        m = (int)(i * f + 0.5F);
      }
      else
      {
        n = i;
        if (i4 != 0)
        {
          n = i;
          if (i2 != 0)
          {
            f = paramConstraintWidget.mDimensionRatio;
            n = (int)(m / f + 0.5F);
          }
        }
        i = n;
      }
      if ((i7 == m) && (i5 == i)) {
        j = i;
      }
      for (i = i6;; i = localView.getBaseline())
      {
        break;
        if (i7 != m) {
          j = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
        }
        if (i5 != i) {
          k = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        localView.measure(j, k);
        m = localView.getMeasuredWidth();
        j = localView.getMeasuredHeight();
      }
    }
    boolean bool1;
    if (i != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((m == paramMeasure.horizontalDimension) && (j == paramMeasure.verticalDimension)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    paramMeasure.measuredNeedsSolverPass = bool2;
    if (((ConstraintLayout.LayoutParams)localObject1).needsBaseline) {
      bool1 = true;
    }
    if ((bool1) && (i != -1) && (paramConstraintWidget.getBaselineDistance() != i)) {
      paramMeasure.measuredNeedsSolverPass = true;
    }
    paramMeasure.measuredWidth = m;
    paramMeasure.measuredHeight = j;
    paramMeasure.measuredHasBaseline = bool1;
    paramMeasure.measuredBaseline = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout.Measurer
 * JD-Core Version:    0.7.0.1
 */