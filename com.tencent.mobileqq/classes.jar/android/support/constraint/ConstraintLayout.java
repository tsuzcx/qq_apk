package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean SIMPLE_LAYOUT = true;
  private static final String TAG = "ConstraintLayout";
  public static final String VERSION = "ConstraintLayout-1.0.0";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ConstraintSet mConstraintSet = null;
  private boolean mDirtyHierarchy = true;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = 2147483647;
  private int mMaxWidth = 2147483647;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 2;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView = (View)this.mChildrenByIds.get(paramInt);
    if (localView == this) {
      return this.mLayoutWidget;
    }
    if (localView == null) {
      return null;
    }
    return ((ConstraintLayout.LayoutParams)localView.getLayoutParams()).widget;
  }
  
  private final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return ((ConstraintLayout.LayoutParams)paramView.getLayoutParams()).widget;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth)
        {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMinWidth);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight)
        {
          this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMinHeight);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth)
        {
          this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxWidth);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight)
        {
          this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxHeight);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          this.mOptimizationLevel = paramAttributeSet.getInt(k, this.mOptimizationLevel);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_constraintSet)
        {
          k = paramAttributeSet.getResourceId(k, 0);
          this.mConstraintSet = new ConstraintSet();
          this.mConstraintSet.load(getContext(), k);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i1 = getPaddingTop() + getPaddingBottom();
    int i2 = getPaddingLeft() + getPaddingRight();
    int i3 = getChildCount();
    int k = 0;
    while (k < i3)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() != 8)
      {
        ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
        ConstraintWidget localConstraintWidget = localLayoutParams.widget;
        if (!localLayoutParams.isGuideline)
        {
          int m = localLayoutParams.width;
          int n = localLayoutParams.height;
          boolean bool = localLayoutParams.horizontalDimensionFixed;
          int j = 1;
          int i;
          if ((!bool) && (!localLayoutParams.verticalDimensionFixed) && ((localLayoutParams.horizontalDimensionFixed) || (localLayoutParams.matchConstraintDefaultWidth != 1)) && (localLayoutParams.width != -1) && ((localLayoutParams.verticalDimensionFixed) || ((localLayoutParams.matchConstraintDefaultHeight != 1) && (localLayoutParams.height != -1)))) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            if ((m != 0) && (m != -1))
            {
              m = getChildMeasureSpec(paramInt1, i2, m);
              i = 0;
            }
            else
            {
              m = getChildMeasureSpec(paramInt1, i2, -2);
              i = 1;
            }
            if ((n != 0) && (n != -1))
            {
              n = getChildMeasureSpec(paramInt2, i1, n);
              j = 0;
            }
            else
            {
              n = getChildMeasureSpec(paramInt2, i1, -2);
            }
            localView.measure(m, n);
            m = localView.getMeasuredWidth();
            n = localView.getMeasuredHeight();
          }
          else
          {
            j = 0;
            i = 0;
          }
          localConstraintWidget.setWidth(m);
          localConstraintWidget.setHeight(n);
          if (i != 0) {
            localConstraintWidget.setWrapWidth(m);
          }
          if (j != 0) {
            localConstraintWidget.setWrapHeight(n);
          }
          if (localLayoutParams.needsBaseline)
          {
            i = localView.getBaseline();
            if (i != -1) {
              localConstraintWidget.setBaselineDistance(i);
            }
          }
        }
      }
      k += 1;
    }
  }
  
  private void setChildrenConstraints()
  {
    Object localObject1 = this.mConstraintSet;
    if (localObject1 != null) {
      ((ConstraintSet)localObject1).applyToInternal(this);
    }
    int i9 = getChildCount();
    this.mLayoutWidget.removeAllChildren();
    int n = 0;
    while (n < i9)
    {
      Object localObject3 = getChildAt(n);
      Object localObject2 = getViewWidget((View)localObject3);
      if (localObject2 != null)
      {
        do
        {
          for (;;)
          {
            localObject1 = (ConstraintLayout.LayoutParams)((View)localObject3).getLayoutParams();
            ((ConstraintWidget)localObject2).reset();
            ((ConstraintWidget)localObject2).setVisibility(((View)localObject3).getVisibility());
            ((ConstraintWidget)localObject2).setCompanionWidget(localObject3);
            this.mLayoutWidget.add((ConstraintWidget)localObject2);
            if ((!((ConstraintLayout.LayoutParams)localObject1).verticalDimensionFixed) || (!((ConstraintLayout.LayoutParams)localObject1).horizontalDimensionFixed)) {
              this.mVariableDimensionsWidgets.add(localObject2);
            }
            if (!((ConstraintLayout.LayoutParams)localObject1).isGuideline) {
              break;
            }
            localObject2 = (android.support.constraint.solver.widgets.Guideline)localObject2;
            if (((ConstraintLayout.LayoutParams)localObject1).guideBegin != -1) {
              ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuideBegin(((ConstraintLayout.LayoutParams)localObject1).guideBegin);
            }
            if (((ConstraintLayout.LayoutParams)localObject1).guideEnd != -1) {
              ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuideEnd(((ConstraintLayout.LayoutParams)localObject1).guideEnd);
            }
            if (((ConstraintLayout.LayoutParams)localObject1).guidePercent != -1.0F) {
              ((android.support.constraint.solver.widgets.Guideline)localObject2).setGuidePercent(((ConstraintLayout.LayoutParams)localObject1).guidePercent);
            }
          }
        } while ((((ConstraintLayout.LayoutParams)localObject1).resolvedLeftToLeft == -1) && (((ConstraintLayout.LayoutParams)localObject1).resolvedLeftToRight == -1) && (((ConstraintLayout.LayoutParams)localObject1).resolvedRightToLeft == -1) && (((ConstraintLayout.LayoutParams)localObject1).resolvedRightToRight == -1) && (((ConstraintLayout.LayoutParams)localObject1).topToTop == -1) && (((ConstraintLayout.LayoutParams)localObject1).topToBottom == -1) && (((ConstraintLayout.LayoutParams)localObject1).bottomToTop == -1) && (((ConstraintLayout.LayoutParams)localObject1).bottomToBottom == -1) && (((ConstraintLayout.LayoutParams)localObject1).baselineToBaseline == -1) && (((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteX == -1) && (((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteY == -1) && (((ConstraintLayout.LayoutParams)localObject1).width != -1) && (((ConstraintLayout.LayoutParams)localObject1).height != -1));
        int i1 = ((ConstraintLayout.LayoutParams)localObject1).resolvedLeftToLeft;
        int i2 = ((ConstraintLayout.LayoutParams)localObject1).resolvedLeftToRight;
        int k = ((ConstraintLayout.LayoutParams)localObject1).resolvedRightToLeft;
        int m = ((ConstraintLayout.LayoutParams)localObject1).resolvedRightToRight;
        int i3 = ((ConstraintLayout.LayoutParams)localObject1).resolveGoneLeftMargin;
        int i4 = ((ConstraintLayout.LayoutParams)localObject1).resolveGoneRightMargin;
        float f1 = ((ConstraintLayout.LayoutParams)localObject1).resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT < 17)
        {
          k = ((ConstraintLayout.LayoutParams)localObject1).leftToLeft;
          m = ((ConstraintLayout.LayoutParams)localObject1).leftToRight;
          int i7 = ((ConstraintLayout.LayoutParams)localObject1).rightToLeft;
          int i8 = ((ConstraintLayout.LayoutParams)localObject1).rightToRight;
          int i5 = ((ConstraintLayout.LayoutParams)localObject1).goneLeftMargin;
          int i6 = ((ConstraintLayout.LayoutParams)localObject1).goneRightMargin;
          float f2 = ((ConstraintLayout.LayoutParams)localObject1).horizontalBias;
          int i = k;
          int j = m;
          if (k == -1)
          {
            i = k;
            j = m;
            if (m == -1) {
              if (((ConstraintLayout.LayoutParams)localObject1).startToStart != -1)
              {
                i = ((ConstraintLayout.LayoutParams)localObject1).startToStart;
                j = m;
              }
              else
              {
                i = k;
                j = m;
                if (((ConstraintLayout.LayoutParams)localObject1).startToEnd != -1)
                {
                  j = ((ConstraintLayout.LayoutParams)localObject1).startToEnd;
                  i = k;
                }
              }
            }
          }
          i1 = i;
          i2 = j;
          k = i7;
          m = i8;
          i3 = i5;
          i4 = i6;
          f1 = f2;
          if (i7 == -1)
          {
            i1 = i;
            i2 = j;
            k = i7;
            m = i8;
            i3 = i5;
            i4 = i6;
            f1 = f2;
            if (i8 == -1) {
              if (((ConstraintLayout.LayoutParams)localObject1).endToStart != -1)
              {
                k = ((ConstraintLayout.LayoutParams)localObject1).endToStart;
                i1 = i;
                i2 = j;
                m = i8;
                i3 = i5;
                i4 = i6;
                f1 = f2;
              }
              else
              {
                i1 = i;
                i2 = j;
                k = i7;
                m = i8;
                i3 = i5;
                i4 = i6;
                f1 = f2;
                if (((ConstraintLayout.LayoutParams)localObject1).endToEnd != -1)
                {
                  m = ((ConstraintLayout.LayoutParams)localObject1).endToEnd;
                  f1 = f2;
                  i4 = i6;
                  i3 = i5;
                  k = i7;
                  i2 = j;
                  i1 = i;
                }
              }
            }
          }
        }
        if (i1 != -1)
        {
          localObject3 = getTargetWidget(i1);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.LEFT, ((ConstraintLayout.LayoutParams)localObject1).leftMargin, i3);
          }
        }
        else if (i2 != -1)
        {
          localObject3 = getTargetWidget(i2);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.RIGHT, ((ConstraintLayout.LayoutParams)localObject1).leftMargin, i3);
          }
        }
        if (k != -1)
        {
          localObject3 = getTargetWidget(k);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.LEFT, ((ConstraintLayout.LayoutParams)localObject1).rightMargin, i4);
          }
        }
        else if (m != -1)
        {
          localObject3 = getTargetWidget(m);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)localObject3, ConstraintAnchor.Type.RIGHT, ((ConstraintLayout.LayoutParams)localObject1).rightMargin, i4);
          }
        }
        if (((ConstraintLayout.LayoutParams)localObject1).topToTop != -1)
        {
          localObject3 = getTargetWidget(((ConstraintLayout.LayoutParams)localObject1).topToTop);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject3, ConstraintAnchor.Type.TOP, ((ConstraintLayout.LayoutParams)localObject1).topMargin, ((ConstraintLayout.LayoutParams)localObject1).goneTopMargin);
          }
        }
        else if (((ConstraintLayout.LayoutParams)localObject1).topToBottom != -1)
        {
          localObject3 = getTargetWidget(((ConstraintLayout.LayoutParams)localObject1).topToBottom);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)localObject3, ConstraintAnchor.Type.BOTTOM, ((ConstraintLayout.LayoutParams)localObject1).topMargin, ((ConstraintLayout.LayoutParams)localObject1).goneTopMargin);
          }
        }
        if (((ConstraintLayout.LayoutParams)localObject1).bottomToTop != -1)
        {
          localObject3 = getTargetWidget(((ConstraintLayout.LayoutParams)localObject1).bottomToTop);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject3, ConstraintAnchor.Type.TOP, ((ConstraintLayout.LayoutParams)localObject1).bottomMargin, ((ConstraintLayout.LayoutParams)localObject1).goneBottomMargin);
          }
        }
        else if (((ConstraintLayout.LayoutParams)localObject1).bottomToBottom != -1)
        {
          localObject3 = getTargetWidget(((ConstraintLayout.LayoutParams)localObject1).bottomToBottom);
          if (localObject3 != null) {
            ((ConstraintWidget)localObject2).immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)localObject3, ConstraintAnchor.Type.BOTTOM, ((ConstraintLayout.LayoutParams)localObject1).bottomMargin, ((ConstraintLayout.LayoutParams)localObject1).goneBottomMargin);
          }
        }
        if (((ConstraintLayout.LayoutParams)localObject1).baselineToBaseline != -1)
        {
          Object localObject4 = (View)this.mChildrenByIds.get(((ConstraintLayout.LayoutParams)localObject1).baselineToBaseline);
          localObject3 = getTargetWidget(((ConstraintLayout.LayoutParams)localObject1).baselineToBaseline);
          if ((localObject3 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof ConstraintLayout.LayoutParams)))
          {
            localObject4 = (ConstraintLayout.LayoutParams)((View)localObject4).getLayoutParams();
            ((ConstraintLayout.LayoutParams)localObject1).needsBaseline = true;
            ((ConstraintLayout.LayoutParams)localObject4).needsBaseline = true;
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BASELINE).connect(((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).reset();
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
          }
        }
        if ((f1 >= 0.0F) && (f1 != 0.5F)) {
          ((ConstraintWidget)localObject2).setHorizontalBiasPercent(f1);
        }
        if ((((ConstraintLayout.LayoutParams)localObject1).verticalBias >= 0.0F) && (((ConstraintLayout.LayoutParams)localObject1).verticalBias != 0.5F)) {
          ((ConstraintWidget)localObject2).setVerticalBiasPercent(((ConstraintLayout.LayoutParams)localObject1).verticalBias);
        }
        if ((isInEditMode()) && ((((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteX != -1) || (((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteY != -1))) {
          ((ConstraintWidget)localObject2).setOrigin(((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteX, ((ConstraintLayout.LayoutParams)localObject1).editorAbsoluteY);
        }
        if (!((ConstraintLayout.LayoutParams)localObject1).horizontalDimensionFixed)
        {
          if (((ConstraintLayout.LayoutParams)localObject1).width == -1)
          {
            ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ConstraintLayout.LayoutParams)localObject1).leftMargin;
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ConstraintLayout.LayoutParams)localObject1).rightMargin;
          }
          else
          {
            ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            ((ConstraintWidget)localObject2).setWidth(0);
          }
        }
        else
        {
          ((ConstraintWidget)localObject2).setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
          ((ConstraintWidget)localObject2).setWidth(((ConstraintLayout.LayoutParams)localObject1).width);
        }
        if (!((ConstraintLayout.LayoutParams)localObject1).verticalDimensionFixed)
        {
          if (((ConstraintLayout.LayoutParams)localObject1).height == -1)
          {
            ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ConstraintLayout.LayoutParams)localObject1).topMargin;
            ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ConstraintLayout.LayoutParams)localObject1).bottomMargin;
          }
          else
          {
            ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            ((ConstraintWidget)localObject2).setHeight(0);
          }
        }
        else
        {
          ((ConstraintWidget)localObject2).setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
          ((ConstraintWidget)localObject2).setHeight(((ConstraintLayout.LayoutParams)localObject1).height);
        }
        if (((ConstraintLayout.LayoutParams)localObject1).dimensionRatio != null) {
          ((ConstraintWidget)localObject2).setDimensionRatio(((ConstraintLayout.LayoutParams)localObject1).dimensionRatio);
        }
        ((ConstraintWidget)localObject2).setHorizontalWeight(((ConstraintLayout.LayoutParams)localObject1).horizontalWeight);
        ((ConstraintWidget)localObject2).setVerticalWeight(((ConstraintLayout.LayoutParams)localObject1).verticalWeight);
        ((ConstraintWidget)localObject2).setHorizontalChainStyle(((ConstraintLayout.LayoutParams)localObject1).horizontalChainStyle);
        ((ConstraintWidget)localObject2).setVerticalChainStyle(((ConstraintLayout.LayoutParams)localObject1).verticalChainStyle);
        ((ConstraintWidget)localObject2).setHorizontalMatchStyle(((ConstraintLayout.LayoutParams)localObject1).matchConstraintDefaultWidth, ((ConstraintLayout.LayoutParams)localObject1).matchConstraintMinWidth, ((ConstraintLayout.LayoutParams)localObject1).matchConstraintMaxWidth);
        ((ConstraintWidget)localObject2).setVerticalMatchStyle(((ConstraintLayout.LayoutParams)localObject1).matchConstraintDefaultHeight, ((ConstraintLayout.LayoutParams)localObject1).matchConstraintMinHeight, ((ConstraintLayout.LayoutParams)localObject1).matchConstraintMaxHeight);
      }
      n += 1;
    }
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    getLayoutParams();
    if (m != -2147483648)
    {
      if (m != 0) {
        if (m == 1073741824) {}
      }
      for (;;)
      {
        paramInt1 = 0;
        break;
        paramInt1 = Math.min(this.mMaxWidth, paramInt1) - (n + i1);
        break;
        localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      }
    }
    localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    if (i != -2147483648)
    {
      if (i != 0) {
        if (i == 1073741824) {}
      }
      for (;;)
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(this.mMaxHeight, paramInt2) - (j + k);
        break;
        localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      }
    }
    localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    this.mLayoutWidget.setMinWidth(0);
    this.mLayoutWidget.setMinHeight(0);
    this.mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
    this.mLayoutWidget.setWidth(paramInt1);
    this.mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
    this.mLayoutWidget.setHeight(paramInt2);
    this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
    this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
  }
  
  private void updateHierarchy()
  {
    int m = getChildCount();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (getChildAt(i).isLayoutRequested())
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0)
    {
      this.mVariableDimensionsWidgets.clear();
      setChildrenConstraints();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ConstraintLayout.LayoutParams;
  }
  
  protected ConstraintLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new ConstraintLayout.LayoutParams(-2, -2);
  }
  
  public ConstraintLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ConstraintLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      if ((localView.getVisibility() != 8) || (((ConstraintLayout.LayoutParams)localObject).isGuideline) || (paramBoolean))
      {
        localObject = ((ConstraintLayout.LayoutParams)localObject).widget;
        paramInt3 = ((ConstraintWidget)localObject).getDrawX();
        paramInt4 = ((ConstraintWidget)localObject).getDrawY();
        localView.layout(paramInt3, paramInt4, ((ConstraintWidget)localObject).getWidth() + paramInt3, ((ConstraintWidget)localObject).getHeight() + paramInt4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft();
    int k = getPaddingTop();
    this.mLayoutWidget.setX(j);
    this.mLayoutWidget.setY(k);
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    boolean bool = this.mDirtyHierarchy;
    int i = 0;
    int i2 = 0;
    if (bool)
    {
      this.mDirtyHierarchy = false;
      updateHierarchy();
    }
    internalMeasureChildren(paramInt1, paramInt2);
    if (getChildCount() > 0) {
      solveLinearSystem();
    }
    int i1 = this.mVariableDimensionsWidgets.size();
    int i4 = k + getPaddingBottom();
    int i5 = j + getPaddingRight();
    if (i1 > 0)
    {
      int m;
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        m = 1;
      } else {
        m = 0;
      }
      int n;
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        n = 1;
      } else {
        n = 0;
      }
      j = 0;
      for (i = 0; i2 < i1; i = k)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i2);
        View localView;
        if (!(localConstraintWidget instanceof android.support.constraint.solver.widgets.Guideline))
        {
          localView = (View)localConstraintWidget.getCompanionWidget();
          if ((localView != null) && (localView.getVisibility() != 8)) {}
        }
        else
        {
          i3 = j;
          k = i;
          break label585;
        }
        ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -2) {
          k = getChildMeasureSpec(paramInt1, i5, localLayoutParams.width);
        } else {
          k = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getWidth(), 1073741824);
        }
        if (localLayoutParams.height == -2) {
          i3 = getChildMeasureSpec(paramInt2, i4, localLayoutParams.height);
        } else {
          i3 = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getHeight(), 1073741824);
        }
        localView.measure(k, i3);
        k = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        if (k != localConstraintWidget.getWidth())
        {
          localConstraintWidget.setWidth(k);
          if ((m != 0) && (localConstraintWidget.getRight() > this.mLayoutWidget.getWidth()))
          {
            j = localConstraintWidget.getRight();
            k = localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
            this.mLayoutWidget.setWidth(Math.max(this.mMinWidth, j + k));
          }
          j = 1;
        }
        k = j;
        if (i3 != localConstraintWidget.getHeight())
        {
          localConstraintWidget.setHeight(i3);
          if ((n != 0) && (localConstraintWidget.getBottom() > this.mLayoutWidget.getHeight()))
          {
            j = localConstraintWidget.getBottom();
            k = localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
            this.mLayoutWidget.setHeight(Math.max(this.mMinHeight, j + k));
          }
          k = 1;
        }
        j = k;
        if (localLayoutParams.needsBaseline)
        {
          i3 = localView.getBaseline();
          j = k;
          if (i3 != -1)
          {
            j = k;
            if (i3 != localConstraintWidget.getBaselineDistance())
            {
              localConstraintWidget.setBaselineDistance(i3);
              j = 1;
            }
          }
        }
        i3 = j;
        k = i;
        if (Build.VERSION.SDK_INT >= 11)
        {
          k = combineMeasuredStates(i, localView.getMeasuredState());
          i3 = j;
        }
        label585:
        i2 += 1;
        j = i3;
      }
      if (j != 0) {
        solveLinearSystem();
      }
    }
    j = this.mLayoutWidget.getWidth() + i5;
    k = this.mLayoutWidget.getHeight() + i4;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(j, paramInt1, i);
      paramInt2 = resolveSizeAndState(k, paramInt2, i << 16);
      paramInt1 = Math.min(this.mMaxWidth, paramInt1);
      i = Math.min(this.mMaxHeight, paramInt2);
      paramInt2 = paramInt1 & 0xFFFFFF;
      i &= 0xFFFFFF;
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
        paramInt1 = paramInt2 | 0x1000000;
      }
      paramInt2 = i;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
        paramInt2 = i | 0x1000000;
      }
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(j, k);
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof android.support.constraint.solver.widgets.Guideline)))
    {
      localObject = (ConstraintLayout.LayoutParams)paramView.getLayoutParams();
      ((ConstraintLayout.LayoutParams)localObject).widget = new android.support.constraint.solver.widgets.Guideline();
      ((ConstraintLayout.LayoutParams)localObject).isGuideline = true;
      ((android.support.constraint.solver.widgets.Guideline)((ConstraintLayout.LayoutParams)localObject).widget).setOrientation(((ConstraintLayout.LayoutParams)localObject).orientation);
      localObject = ((ConstraintLayout.LayoutParams)localObject).widget;
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    this.mLayoutWidget.remove(getViewWidget(paramView));
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  protected void solveLinearSystem()
  {
    this.mLayoutWidget.layout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintLayout
 * JD-Core Version:    0.7.0.1
 */