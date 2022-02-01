package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
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
  
  private boolean isSimilarSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2) {
      return true;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    return (paramInt1 == 1073741824) && ((i == -2147483648) || (i == 0)) && (paramInt3 == paramInt2);
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
    k = ConstraintLayout.access$100(this.layout).size();
    if (k > 0)
    {
      i = j;
      while (i < k)
      {
        ((ConstraintHelper)ConstraintLayout.access$100(this.layout).get(i)).updatePostMeasure(this.layout);
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
    if (paramConstraintWidget.getParent() == null) {
      return;
    }
    Object localObject1 = paramMeasure.horizontalBehavior;
    Object localObject2 = paramMeasure.verticalBehavior;
    int i = paramMeasure.horizontalDimension;
    int m = paramMeasure.verticalDimension;
    int n = this.paddingTop + this.paddingBottom;
    int j = this.paddingWidth;
    View localView = (View)paramConstraintWidget.getCompanionWidget();
    int k = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[localObject1.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            i = 0;
          }
          else
          {
            k = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, j, -2);
            if (paramConstraintWidget.mMatchConstraintDefaultWidth == 1) {
              j = 1;
            } else {
              j = 0;
            }
            if (paramMeasure.measureStrategy != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS)
            {
              i = k;
              if (paramMeasure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {}
            }
            else
            {
              if (localView.getMeasuredHeight() == paramConstraintWidget.getHeight()) {
                i = 1;
              } else {
                i = 0;
              }
              if ((paramMeasure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (j != 0) && ((j == 0) || (i == 0)) && (!(localView instanceof Placeholder)) && (!paramConstraintWidget.isResolvedHorizontally())) {
                j = 0;
              } else {
                j = 1;
              }
              i = k;
              if (j != 0) {
                i = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.getWidth(), 1073741824);
              }
            }
          }
        }
        else {
          i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, j + paramConstraintWidget.getHorizontalMargin(), -1);
        }
      }
      else {
        i = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, j, -2);
      }
    }
    else {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }
    j = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[localObject2.ordinal()];
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            j = 0;
          }
          else
          {
            m = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, n, -2);
            if (paramConstraintWidget.mMatchConstraintDefaultHeight == 1) {
              k = 1;
            } else {
              k = 0;
            }
            if (paramMeasure.measureStrategy != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS)
            {
              j = m;
              if (paramMeasure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {}
            }
            else
            {
              if (localView.getMeasuredWidth() == paramConstraintWidget.getWidth()) {
                j = 1;
              } else {
                j = 0;
              }
              if ((paramMeasure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (k != 0) && ((k == 0) || (j == 0)) && (!(localView instanceof Placeholder)) && (!paramConstraintWidget.isResolvedVertically())) {
                k = 0;
              } else {
                k = 1;
              }
              j = m;
              if (k != 0) {
                j = View.MeasureSpec.makeMeasureSpec(paramConstraintWidget.getHeight(), 1073741824);
              }
            }
          }
        }
        else {
          j = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, n + paramConstraintWidget.getVerticalMargin(), -1);
        }
      }
      else {
        j = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, n, -2);
      }
    }
    else {
      j = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    }
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
    if ((localConstraintWidgetContainer != null) && (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256)) && (localView.getMeasuredWidth() == paramConstraintWidget.getWidth()) && (localView.getMeasuredWidth() < localConstraintWidgetContainer.getWidth()) && (localView.getMeasuredHeight() == paramConstraintWidget.getHeight()) && (localView.getMeasuredHeight() < localConstraintWidgetContainer.getHeight()) && (localView.getBaseline() == paramConstraintWidget.getBaselineDistance()) && (!paramConstraintWidget.isMeasureRequested()))
    {
      if ((isSimilarSpec(paramConstraintWidget.getLastHorizontalMeasureSpec(), i, paramConstraintWidget.getWidth())) && (isSimilarSpec(paramConstraintWidget.getLastVerticalMeasureSpec(), j, paramConstraintWidget.getHeight()))) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        paramMeasure.measuredWidth = paramConstraintWidget.getWidth();
        paramMeasure.measuredHeight = paramConstraintWidget.getHeight();
        paramMeasure.measuredBaseline = paramConstraintWidget.getBaselineDistance();
        return;
      }
    }
    if (localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      k = 1;
    } else {
      k = 0;
    }
    if (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      m = 1;
    } else {
      m = 0;
    }
    int i1;
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
    if ((k != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if ((m != 0) && (paramConstraintWidget.mDimensionRatio > 0.0F)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    if (localView == null) {
      return;
    }
    localObject1 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
    if ((paramMeasure.measureStrategy != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) && (paramMeasure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (k != 0) && (paramConstraintWidget.mMatchConstraintDefaultWidth == 0) && (m != 0) && (paramConstraintWidget.mMatchConstraintDefaultHeight == 0))
    {
      m = 0;
      i1 = 0;
      i2 = 0;
    }
    else
    {
      if (((localView instanceof VirtualLayout)) && ((paramConstraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)))
      {
        localObject2 = (androidx.constraintlayout.solver.widgets.VirtualLayout)paramConstraintWidget;
        ((VirtualLayout)localView).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout)localObject2, i, j);
      }
      else
      {
        localView.measure(i, j);
      }
      paramConstraintWidget.setLastMeasureSpec(i, j);
      int i6 = localView.getMeasuredWidth();
      int i5 = localView.getMeasuredHeight();
      int i7 = localView.getBaseline();
      if (paramConstraintWidget.mMatchConstraintMinWidth > 0) {
        k = Math.max(paramConstraintWidget.mMatchConstraintMinWidth, i6);
      } else {
        k = i6;
      }
      m = k;
      if (paramConstraintWidget.mMatchConstraintMaxWidth > 0) {
        m = Math.min(paramConstraintWidget.mMatchConstraintMaxWidth, k);
      }
      if (paramConstraintWidget.mMatchConstraintMinHeight > 0) {
        n = Math.max(paramConstraintWidget.mMatchConstraintMinHeight, i5);
      } else {
        n = i5;
      }
      k = n;
      if (paramConstraintWidget.mMatchConstraintMaxHeight > 0) {
        k = Math.min(paramConstraintWidget.mMatchConstraintMaxHeight, n);
      }
      n = k;
      if (!Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1))
      {
        float f;
        if ((i3 != 0) && (i1 != 0))
        {
          f = paramConstraintWidget.mDimensionRatio;
          n = (int)(k * f + 0.5F);
          break label1211;
        }
        n = k;
        if (i4 != 0)
        {
          n = k;
          if (i2 != 0)
          {
            f = paramConstraintWidget.mDimensionRatio;
            n = (int)(m / f + 0.5F);
          }
        }
      }
      k = n;
      n = m;
      label1211:
      if (i6 == n)
      {
        m = n;
        i1 = i7;
        i2 = k;
        if (i5 != k) {}
      }
      for (;;)
      {
        break;
        if (i6 != n) {
          i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
        }
        if (i5 != k) {
          j = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        }
        localView.measure(i, j);
        paramConstraintWidget.setLastMeasureSpec(i, j);
        m = localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight();
        i1 = localView.getBaseline();
      }
    }
    boolean bool1;
    if (i1 != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((m == paramMeasure.horizontalDimension) && (i2 == paramMeasure.verticalDimension)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    paramMeasure.measuredNeedsSolverPass = bool2;
    if (((ConstraintLayout.LayoutParams)localObject1).needsBaseline) {
      bool1 = true;
    }
    if ((bool1) && (i1 != -1) && (paramConstraintWidget.getBaselineDistance() != i1)) {
      paramMeasure.measuredNeedsSolverPass = true;
    }
    paramMeasure.measuredWidth = m;
    paramMeasure.measuredHeight = i2;
    paramMeasure.measuredHasBaseline = bool1;
    paramMeasure.measuredBaseline = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout.Measurer
 * JD-Core Version:    0.7.0.1
 */