package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow
  extends VirtualLayout
{
  public static final int HORIZONTAL_ALIGN_CENTER = 2;
  public static final int HORIZONTAL_ALIGN_END = 1;
  public static final int HORIZONTAL_ALIGN_START = 0;
  public static final int VERTICAL_ALIGN_BASELINE = 3;
  public static final int VERTICAL_ALIGN_BOTTOM = 1;
  public static final int VERTICAL_ALIGN_CENTER = 2;
  public static final int VERTICAL_ALIGN_TOP = 0;
  public static final int WRAP_ALIGNED = 2;
  public static final int WRAP_CHAIN = 1;
  public static final int WRAP_NONE = 0;
  private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
  private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
  private int[] mAlignedDimensions = null;
  private ArrayList<Flow.WidgetsList> mChainList = new ArrayList();
  private ConstraintWidget[] mDisplayedWidgets;
  private int mDisplayedWidgetsCount = 0;
  private float mFirstHorizontalBias = 0.5F;
  private int mFirstHorizontalStyle = -1;
  private float mFirstVerticalBias = 0.5F;
  private int mFirstVerticalStyle = -1;
  private int mHorizontalAlign = 2;
  private float mHorizontalBias = 0.5F;
  private int mHorizontalGap = 0;
  private int mHorizontalStyle = -1;
  private float mLastHorizontalBias = 0.5F;
  private int mLastHorizontalStyle = -1;
  private float mLastVerticalBias = 0.5F;
  private int mLastVerticalStyle = -1;
  private int mMaxElementsWrap = -1;
  private int mOrientation = 0;
  private int mVerticalAlign = 2;
  private float mVerticalBias = 0.5F;
  private int mVerticalGap = 0;
  private int mVerticalStyle = -1;
  private int mWrapMode = 0;
  
  private void createAlignedConstraints(boolean paramBoolean)
  {
    if ((this.mAlignedDimensions != null) && (this.mAlignedBiggestElementsInCols != null))
    {
      if (this.mAlignedBiggestElementsInRows == null) {
        return;
      }
      int i = 0;
      while (i < this.mDisplayedWidgetsCount)
      {
        this.mDisplayedWidgets[i].resetAnchors();
        i += 1;
      }
      Object localObject1 = this.mAlignedDimensions;
      int m = localObject1[0];
      int n = localObject1[1];
      localObject1 = null;
      i = 0;
      int j;
      ConstraintWidget localConstraintWidget;
      Object localObject2;
      while (i < m)
      {
        if (paramBoolean) {
          j = m - i - 1;
        } else {
          j = i;
        }
        localConstraintWidget = this.mAlignedBiggestElementsInCols[j];
        localObject2 = localObject1;
        if (localConstraintWidget != null) {
          if (localConstraintWidget.getVisibility() == 8)
          {
            localObject2 = localObject1;
          }
          else
          {
            if (i == 0)
            {
              localConstraintWidget.connect(localConstraintWidget.mLeft, this.mLeft, getPaddingLeft());
              localConstraintWidget.setHorizontalChainStyle(this.mHorizontalStyle);
              localConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
            }
            if (i == m - 1) {
              localConstraintWidget.connect(localConstraintWidget.mRight, this.mRight, getPaddingRight());
            }
            if (i > 0)
            {
              localConstraintWidget.connect(localConstraintWidget.mLeft, ((ConstraintWidget)localObject1).mRight, this.mHorizontalGap);
              ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mRight, localConstraintWidget.mLeft, 0);
            }
            localObject2 = localConstraintWidget;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      i = 0;
      while (i < n)
      {
        localConstraintWidget = this.mAlignedBiggestElementsInRows[i];
        localObject2 = localObject1;
        if (localConstraintWidget != null) {
          if (localConstraintWidget.getVisibility() == 8)
          {
            localObject2 = localObject1;
          }
          else
          {
            if (i == 0)
            {
              localConstraintWidget.connect(localConstraintWidget.mTop, this.mTop, getPaddingTop());
              localConstraintWidget.setVerticalChainStyle(this.mVerticalStyle);
              localConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
            }
            if (i == n - 1) {
              localConstraintWidget.connect(localConstraintWidget.mBottom, this.mBottom, getPaddingBottom());
            }
            if (i > 0)
            {
              localConstraintWidget.connect(localConstraintWidget.mTop, ((ConstraintWidget)localObject1).mBottom, this.mVerticalGap);
              ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mBottom, localConstraintWidget.mTop, 0);
            }
            localObject2 = localConstraintWidget;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      i = 0;
      while (i < m)
      {
        j = 0;
        while (j < n)
        {
          int k = j * m + i;
          if (this.mOrientation == 1) {
            k = i * n + j;
          }
          localObject1 = this.mDisplayedWidgets;
          if (k < localObject1.length)
          {
            localObject1 = localObject1[k];
            if ((localObject1 != null) && (((ConstraintWidget)localObject1).getVisibility() != 8))
            {
              localObject2 = this.mAlignedBiggestElementsInCols[i];
              localConstraintWidget = this.mAlignedBiggestElementsInRows[j];
              if (localObject1 != localObject2)
              {
                ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mLeft, ((ConstraintWidget)localObject2).mLeft, 0);
                ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mRight, ((ConstraintWidget)localObject2).mRight, 0);
              }
              if (localObject1 != localConstraintWidget)
              {
                ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mTop, localConstraintWidget.mTop, 0);
                ((ConstraintWidget)localObject1).connect(((ConstraintWidget)localObject1).mBottom, localConstraintWidget.mBottom, 0);
              }
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private final int getWidgetHeight(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramConstraintWidget == null) {
      return 0;
    }
    if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (paramConstraintWidget.mMatchConstraintDefaultHeight == 0) {
        return 0;
      }
      if (paramConstraintWidget.mMatchConstraintDefaultHeight == 2)
      {
        paramInt = (int)(paramConstraintWidget.mMatchConstraintPercentHeight * paramInt);
        if (paramInt != paramConstraintWidget.getHeight())
        {
          paramConstraintWidget.setMeasureRequested(true);
          measure(paramConstraintWidget, paramConstraintWidget.getHorizontalDimensionBehaviour(), paramConstraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, paramInt);
        }
        return paramInt;
      }
      if (paramConstraintWidget.mMatchConstraintDefaultHeight == 1) {
        return paramConstraintWidget.getHeight();
      }
      if (paramConstraintWidget.mMatchConstraintDefaultHeight == 3) {
        return (int)(paramConstraintWidget.getWidth() * paramConstraintWidget.mDimensionRatio + 0.5F);
      }
    }
    return paramConstraintWidget.getHeight();
  }
  
  private final int getWidgetWidth(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramConstraintWidget == null) {
      return 0;
    }
    if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (paramConstraintWidget.mMatchConstraintDefaultWidth == 0) {
        return 0;
      }
      if (paramConstraintWidget.mMatchConstraintDefaultWidth == 2)
      {
        paramInt = (int)(paramConstraintWidget.mMatchConstraintPercentWidth * paramInt);
        if (paramInt != paramConstraintWidget.getWidth())
        {
          paramConstraintWidget.setMeasureRequested(true);
          measure(paramConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, paramInt, paramConstraintWidget.getVerticalDimensionBehaviour(), paramConstraintWidget.getHeight());
        }
        return paramInt;
      }
      if (paramConstraintWidget.mMatchConstraintDefaultWidth == 1) {
        return paramConstraintWidget.getWidth();
      }
      if (paramConstraintWidget.mMatchConstraintDefaultWidth == 3) {
        return (int)(paramConstraintWidget.getHeight() * paramConstraintWidget.mDimensionRatio + 0.5F);
      }
    }
    return paramConstraintWidget.getWidth();
  }
  
  private void measureAligned(ConstraintWidget[] paramArrayOfConstraintWidget, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int k;
    int m;
    int j;
    int i;
    Object localObject;
    if (paramInt2 == 0)
    {
      k = this.mMaxElementsWrap;
      if (k <= 0)
      {
        m = 0;
        j = 0;
        i = 0;
        for (;;)
        {
          k = i;
          if (m >= paramInt1) {
            break;
          }
          k = j;
          if (m > 0) {
            k = j + this.mHorizontalGap;
          }
          localObject = paramArrayOfConstraintWidget[m];
          if (localObject == null)
          {
            j = k;
          }
          else
          {
            j = k + getWidgetWidth((ConstraintWidget)localObject, paramInt3);
            if (j > paramInt3)
            {
              k = i;
              break;
            }
            i += 1;
          }
          m += 1;
        }
      }
      j = 0;
      i = k;
    }
    else
    {
      i = this.mMaxElementsWrap;
      j = i;
      if (i <= 0)
      {
        m = 0;
        j = 0;
        i = 0;
        while (m < paramInt1)
        {
          k = j;
          if (m > 0) {
            k = j + this.mVerticalGap;
          }
          localObject = paramArrayOfConstraintWidget[m];
          if (localObject == null)
          {
            j = k;
          }
          else
          {
            j = k + getWidgetHeight((ConstraintWidget)localObject, paramInt3);
            if (j > paramInt3) {
              break;
            }
            i += 1;
          }
          m += 1;
        }
        j = i;
      }
      i = 0;
    }
    if (this.mAlignedDimensions == null) {
      this.mAlignedDimensions = new int[2];
    }
    int n;
    int i1;
    int i2;
    if (((j == 0) && (paramInt2 == 1)) || ((i == 0) && (paramInt2 == 0)))
    {
      n = j;
      i1 = i;
      i2 = 1;
      i = i1;
      j = n;
    }
    else
    {
      i2 = 0;
    }
    for (;;)
    {
      if (i2 != 0) {
        break label830;
      }
      if (paramInt2 == 0) {
        j = (int)Math.ceil(paramInt1 / i);
      } else {
        i = (int)Math.ceil(paramInt1 / j);
      }
      localObject = this.mAlignedBiggestElementsInCols;
      if ((localObject != null) && (localObject.length >= i)) {
        Arrays.fill((Object[])localObject, null);
      } else {
        this.mAlignedBiggestElementsInCols = new ConstraintWidget[i];
      }
      localObject = this.mAlignedBiggestElementsInRows;
      if ((localObject != null) && (localObject.length >= j)) {
        Arrays.fill((Object[])localObject, null);
      } else {
        this.mAlignedBiggestElementsInRows = new ConstraintWidget[j];
      }
      k = 0;
      while (k < i)
      {
        m = 0;
        while (m < j)
        {
          n = m * i + k;
          if (paramInt2 == 1) {
            n = k * j + m;
          }
          if (n < paramArrayOfConstraintWidget.length)
          {
            localObject = paramArrayOfConstraintWidget[n];
            if (localObject != null)
            {
              n = getWidgetWidth((ConstraintWidget)localObject, paramInt3);
              ConstraintWidget[] arrayOfConstraintWidget = this.mAlignedBiggestElementsInCols;
              if ((arrayOfConstraintWidget[k] == null) || (arrayOfConstraintWidget[k].getWidth() < n)) {
                this.mAlignedBiggestElementsInCols[k] = localObject;
              }
              n = getWidgetHeight((ConstraintWidget)localObject, paramInt3);
              arrayOfConstraintWidget = this.mAlignedBiggestElementsInRows;
              if ((arrayOfConstraintWidget[m] == null) || (arrayOfConstraintWidget[m].getHeight() < n)) {
                this.mAlignedBiggestElementsInRows[m] = localObject;
              }
            }
          }
          m += 1;
        }
        k += 1;
      }
      m = 0;
      for (k = 0; m < i; k = n)
      {
        localObject = this.mAlignedBiggestElementsInCols[m];
        n = k;
        if (localObject != null)
        {
          n = k;
          if (m > 0) {
            n = k + this.mHorizontalGap;
          }
          n += getWidgetWidth((ConstraintWidget)localObject, paramInt3);
        }
        m += 1;
      }
      n = 0;
      for (m = 0; n < j; m = i1)
      {
        localObject = this.mAlignedBiggestElementsInRows[n];
        i1 = m;
        if (localObject != null)
        {
          i1 = m;
          if (n > 0) {
            i1 = m + this.mVerticalGap;
          }
          i1 += getWidgetHeight((ConstraintWidget)localObject, paramInt3);
        }
        n += 1;
      }
      paramArrayOfInt[0] = k;
      paramArrayOfInt[1] = m;
      if (paramInt2 == 0)
      {
        i1 = i;
        n = j;
        if (k <= paramInt3) {
          break;
        }
        i1 = i;
        n = j;
        if (i <= 1) {
          break;
        }
        i -= 1;
        continue;
      }
      i1 = i;
      n = j;
      if (m <= paramInt3) {
        break;
      }
      i1 = i;
      n = j;
      if (j <= 1) {
        break;
      }
      j -= 1;
    }
    label830:
    paramArrayOfConstraintWidget = this.mAlignedDimensions;
    paramArrayOfConstraintWidget[0] = i;
    paramArrayOfConstraintWidget[1] = j;
  }
  
  private void measureChainWrap(ConstraintWidget[] paramArrayOfConstraintWidget, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 == 0) {
      return;
    }
    this.mChainList.clear();
    Object localObject1 = new Flow.WidgetsList(this, paramInt2, this.mLeft, this.mTop, this.mRight, this.mBottom, paramInt3);
    this.mChainList.add(localObject1);
    if (paramInt2 == 0)
    {
      i = 0;
      j = 0;
      m = 0;
      for (;;)
      {
        k = i;
        if (m >= paramInt1) {
          break;
        }
        localObject2 = paramArrayOfConstraintWidget[m];
        n = getWidgetWidth((ConstraintWidget)localObject2, paramInt3);
        k = i;
        if (((ConstraintWidget)localObject2).getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          k = i + 1;
        }
        if (((j == paramInt3) || (this.mHorizontalGap + j + n > paramInt3)) && (Flow.WidgetsList.access$2000((Flow.WidgetsList)localObject1) != null)) {
          i = 1;
        } else {
          i = 0;
        }
        i1 = i;
        if (i == 0)
        {
          i1 = i;
          if (m > 0)
          {
            i2 = this.mMaxElementsWrap;
            i1 = i;
            if (i2 > 0)
            {
              i1 = i;
              if (m % i2 == 0) {
                i1 = 1;
              }
            }
          }
        }
        if (i1 != 0)
        {
          localObject1 = new Flow.WidgetsList(this, paramInt2, this.mLeft, this.mTop, this.mRight, this.mBottom, paramInt3);
          ((Flow.WidgetsList)localObject1).setStartIndex(m);
          this.mChainList.add(localObject1);
          j = n;
        }
        else if (m > 0)
        {
          j += this.mHorizontalGap + n;
        }
        else
        {
          j = n;
        }
        ((Flow.WidgetsList)localObject1).add((ConstraintWidget)localObject2);
        m += 1;
        i = k;
      }
    }
    int i = 0;
    int j = 0;
    int m = 0;
    for (;;)
    {
      k = i;
      if (m >= paramInt1) {
        break;
      }
      localObject2 = paramArrayOfConstraintWidget[m];
      n = getWidgetHeight((ConstraintWidget)localObject2, paramInt3);
      k = i;
      if (((ConstraintWidget)localObject2).getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        k = i + 1;
      }
      if (((j == paramInt3) || (this.mVerticalGap + j + n > paramInt3)) && (Flow.WidgetsList.access$2000((Flow.WidgetsList)localObject1) != null)) {
        i = 1;
      } else {
        i = 0;
      }
      i1 = i;
      if (i == 0)
      {
        i1 = i;
        if (m > 0)
        {
          i2 = this.mMaxElementsWrap;
          i1 = i;
          if (i2 > 0)
          {
            i1 = i;
            if (m % i2 == 0) {
              i1 = 1;
            }
          }
        }
      }
      if (i1 != 0)
      {
        localObject1 = new Flow.WidgetsList(this, paramInt2, this.mLeft, this.mTop, this.mRight, this.mBottom, paramInt3);
        ((Flow.WidgetsList)localObject1).setStartIndex(m);
        this.mChainList.add(localObject1);
        j = n;
      }
      else if (m > 0)
      {
        j += this.mVerticalGap + n;
      }
      else
      {
        j = n;
      }
      ((Flow.WidgetsList)localObject1).add((ConstraintWidget)localObject2);
      m += 1;
      i = k;
    }
    int i5 = this.mChainList.size();
    localObject1 = this.mLeft;
    Object localObject2 = this.mTop;
    Object localObject3 = this.mRight;
    Object localObject4 = this.mBottom;
    m = getPaddingLeft();
    j = getPaddingTop();
    int n = getPaddingRight();
    int i2 = getPaddingBottom();
    if ((getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if ((k > 0) && (paramInt1 != 0))
    {
      paramInt1 = 0;
      while (paramInt1 < i5)
      {
        paramArrayOfConstraintWidget = (Flow.WidgetsList)this.mChainList.get(paramInt1);
        if (paramInt2 == 0) {
          paramArrayOfConstraintWidget.measureMatchConstraints(paramInt3 - paramArrayOfConstraintWidget.getWidth());
        } else {
          paramArrayOfConstraintWidget.measureMatchConstraints(paramInt3 - paramArrayOfConstraintWidget.getHeight());
        }
        paramInt1 += 1;
      }
    }
    int k = 0;
    int i3 = 0;
    int i1 = 0;
    while (k < i5)
    {
      Flow.WidgetsList localWidgetsList = (Flow.WidgetsList)this.mChainList.get(k);
      int i4;
      if (paramInt2 == 0)
      {
        if (k < i5 - 1)
        {
          paramArrayOfConstraintWidget = Flow.WidgetsList.access$2000((Flow.WidgetsList)this.mChainList.get(k + 1)).mTop;
          paramInt1 = 0;
        }
        else
        {
          paramArrayOfConstraintWidget = this.mBottom;
          paramInt1 = getPaddingBottom();
        }
        localObject4 = Flow.WidgetsList.access$2000(localWidgetsList).mBottom;
        localWidgetsList.setup(paramInt2, (ConstraintAnchor)localObject1, (ConstraintAnchor)localObject2, (ConstraintAnchor)localObject3, paramArrayOfConstraintWidget, m, j, n, paramInt1, paramInt3);
        j = Math.max(i3, localWidgetsList.getWidth());
        i1 += localWidgetsList.getHeight();
        i = i1;
        if (k > 0) {
          i = i1 + this.mVerticalGap;
        }
        i2 = 0;
        localObject2 = localObject4;
        i4 = paramInt1;
      }
      else
      {
        if (k < i5 - 1)
        {
          paramArrayOfConstraintWidget = Flow.WidgetsList.access$2000((Flow.WidgetsList)this.mChainList.get(k + 1)).mLeft;
          i = 0;
        }
        else
        {
          paramArrayOfConstraintWidget = this.mRight;
          i = getPaddingRight();
        }
        ConstraintAnchor localConstraintAnchor = Flow.WidgetsList.access$2000(localWidgetsList).mRight;
        localWidgetsList.setup(paramInt2, (ConstraintAnchor)localObject1, (ConstraintAnchor)localObject2, paramArrayOfConstraintWidget, (ConstraintAnchor)localObject4, m, j, i, i2, paramInt3);
        m = i3 + localWidgetsList.getWidth();
        i1 = Math.max(i1, localWidgetsList.getHeight());
        paramInt1 = m;
        if (k > 0) {
          paramInt1 = m + this.mHorizontalGap;
        }
        m = 0;
        n = i;
        localObject3 = paramArrayOfConstraintWidget;
        i4 = i2;
        i2 = j;
        paramArrayOfConstraintWidget = (ConstraintWidget[])localObject4;
        localObject1 = localConstraintAnchor;
        i = i1;
        j = paramInt1;
      }
      k += 1;
      i3 = j;
      i1 = i;
      localObject4 = paramArrayOfConstraintWidget;
      j = i2;
      i2 = i4;
    }
    paramArrayOfInt[0] = i3;
    paramArrayOfInt[1] = i1;
  }
  
  private void measureNoWrap(ConstraintWidget[] paramArrayOfConstraintWidget, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 == 0) {
      return;
    }
    Flow.WidgetsList localWidgetsList;
    if (this.mChainList.size() == 0)
    {
      localWidgetsList = new Flow.WidgetsList(this, paramInt2, this.mLeft, this.mTop, this.mRight, this.mBottom, paramInt3);
      this.mChainList.add(localWidgetsList);
    }
    else
    {
      localWidgetsList = (Flow.WidgetsList)this.mChainList.get(0);
      localWidgetsList.clear();
      ConstraintAnchor localConstraintAnchor1 = this.mLeft;
      ConstraintAnchor localConstraintAnchor2 = this.mTop;
      ConstraintAnchor localConstraintAnchor3 = this.mRight;
      ConstraintAnchor localConstraintAnchor4 = this.mBottom;
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getPaddingRight();
      int m = getPaddingBottom();
      localWidgetsList.setup(paramInt2, localConstraintAnchor1, localConstraintAnchor2, localConstraintAnchor3, localConstraintAnchor4, i, j, k, m, paramInt3);
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      localWidgetsList.add(paramArrayOfConstraintWidget[paramInt2]);
      paramInt2 += 1;
    }
    paramArrayOfInt[0] = localWidgetsList.getWidth();
    paramArrayOfInt[1] = localWidgetsList.getHeight();
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, boolean paramBoolean)
  {
    super.addToSolver(paramLinearSystem, paramBoolean);
    if (getParent() != null) {
      paramBoolean = ((ConstraintWidgetContainer)getParent()).isRtl();
    } else {
      paramBoolean = false;
    }
    int i = this.mWrapMode;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          createAlignedConstraints(paramBoolean);
        }
      }
      else
      {
        int j = this.mChainList.size();
        i = 0;
        while (i < j)
        {
          paramLinearSystem = (Flow.WidgetsList)this.mChainList.get(i);
          boolean bool;
          if (i == j - 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramLinearSystem.createConstraints(paramBoolean, i, bool);
          i += 1;
        }
      }
    }
    else if (this.mChainList.size() > 0) {
      ((Flow.WidgetsList)this.mChainList.get(0)).createConstraints(paramBoolean, 0, true);
    }
    needsCallbackFromSolver(false);
  }
  
  public void copy(ConstraintWidget paramConstraintWidget, HashMap<ConstraintWidget, ConstraintWidget> paramHashMap)
  {
    super.copy(paramConstraintWidget, paramHashMap);
    paramConstraintWidget = (Flow)paramConstraintWidget;
    this.mHorizontalStyle = paramConstraintWidget.mHorizontalStyle;
    this.mVerticalStyle = paramConstraintWidget.mVerticalStyle;
    this.mFirstHorizontalStyle = paramConstraintWidget.mFirstHorizontalStyle;
    this.mFirstVerticalStyle = paramConstraintWidget.mFirstVerticalStyle;
    this.mLastHorizontalStyle = paramConstraintWidget.mLastHorizontalStyle;
    this.mLastVerticalStyle = paramConstraintWidget.mLastVerticalStyle;
    this.mHorizontalBias = paramConstraintWidget.mHorizontalBias;
    this.mVerticalBias = paramConstraintWidget.mVerticalBias;
    this.mFirstHorizontalBias = paramConstraintWidget.mFirstHorizontalBias;
    this.mFirstVerticalBias = paramConstraintWidget.mFirstVerticalBias;
    this.mLastHorizontalBias = paramConstraintWidget.mLastHorizontalBias;
    this.mLastVerticalBias = paramConstraintWidget.mLastVerticalBias;
    this.mHorizontalGap = paramConstraintWidget.mHorizontalGap;
    this.mVerticalGap = paramConstraintWidget.mVerticalGap;
    this.mHorizontalAlign = paramConstraintWidget.mHorizontalAlign;
    this.mVerticalAlign = paramConstraintWidget.mVerticalAlign;
    this.mWrapMode = paramConstraintWidget.mWrapMode;
    this.mMaxElementsWrap = paramConstraintWidget.mMaxElementsWrap;
    this.mOrientation = paramConstraintWidget.mOrientation;
  }
  
  public void measure(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mWidgetsCount > 0) && (!measureChildren()))
    {
      setMeasure(0, 0);
      needsCallbackFromSolver(false);
      return;
    }
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    int[] arrayOfInt = new int[2];
    int j = paramInt2 - i2 - i3;
    if (this.mOrientation == 1) {
      j = paramInt4 - n - i1;
    }
    if (this.mOrientation == 0)
    {
      if (this.mHorizontalStyle == -1) {
        this.mHorizontalStyle = 0;
      }
      if (this.mVerticalStyle == -1) {
        this.mVerticalStyle = 0;
      }
    }
    else
    {
      if (this.mHorizontalStyle == -1) {
        this.mHorizontalStyle = 0;
      }
      if (this.mVerticalStyle == -1) {
        this.mVerticalStyle = 0;
      }
    }
    ConstraintWidget[] arrayOfConstraintWidget = this.mWidgets;
    int k = 0;
    int m;
    for (int i = 0; k < this.mWidgetsCount; i = m)
    {
      m = i;
      if (this.mWidgets[k].getVisibility() == 8) {
        m = i + 1;
      }
      k += 1;
    }
    k = this.mWidgetsCount;
    if (i > 0)
    {
      arrayOfConstraintWidget = new ConstraintWidget[this.mWidgetsCount - i];
      k = 0;
      for (i = 0; k < this.mWidgetsCount; i = m)
      {
        ConstraintWidget localConstraintWidget = this.mWidgets[k];
        m = i;
        if (localConstraintWidget.getVisibility() != 8)
        {
          arrayOfConstraintWidget[i] = localConstraintWidget;
          m = i + 1;
        }
        k += 1;
      }
      k = i;
    }
    this.mDisplayedWidgets = arrayOfConstraintWidget;
    this.mDisplayedWidgetsCount = k;
    i = this.mWrapMode;
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {}
      }
    }
    boolean bool;
    for (;;)
    {
      bool = true;
      break;
      measureAligned(arrayOfConstraintWidget, k, this.mOrientation, j, arrayOfInt);
      continue;
      measureChainWrap(arrayOfConstraintWidget, k, this.mOrientation, j, arrayOfInt);
      continue;
      measureNoWrap(arrayOfConstraintWidget, k, this.mOrientation, j, arrayOfInt);
    }
    j = arrayOfInt[0] + i2 + i3;
    i = arrayOfInt[1] + n + i1;
    if (paramInt1 == 1073741824) {
      paramInt1 = paramInt2;
    } else if (paramInt1 == -2147483648) {
      paramInt1 = Math.min(j, paramInt2);
    } else if (paramInt1 == 0) {
      paramInt1 = j;
    } else {
      paramInt1 = 0;
    }
    if (paramInt3 == 1073741824) {
      paramInt2 = paramInt4;
    } else if (paramInt3 == -2147483648) {
      paramInt2 = Math.min(i, paramInt4);
    } else if (paramInt3 == 0) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    }
    setMeasure(paramInt1, paramInt2);
    setWidth(paramInt1);
    setHeight(paramInt2);
    if (this.mWidgetsCount <= 0) {
      bool = false;
    }
    needsCallbackFromSolver(bool);
  }
  
  public void setFirstHorizontalBias(float paramFloat)
  {
    this.mFirstHorizontalBias = paramFloat;
  }
  
  public void setFirstHorizontalStyle(int paramInt)
  {
    this.mFirstHorizontalStyle = paramInt;
  }
  
  public void setFirstVerticalBias(float paramFloat)
  {
    this.mFirstVerticalBias = paramFloat;
  }
  
  public void setFirstVerticalStyle(int paramInt)
  {
    this.mFirstVerticalStyle = paramInt;
  }
  
  public void setHorizontalAlign(int paramInt)
  {
    this.mHorizontalAlign = paramInt;
  }
  
  public void setHorizontalBias(float paramFloat)
  {
    this.mHorizontalBias = paramFloat;
  }
  
  public void setHorizontalGap(int paramInt)
  {
    this.mHorizontalGap = paramInt;
  }
  
  public void setHorizontalStyle(int paramInt)
  {
    this.mHorizontalStyle = paramInt;
  }
  
  public void setLastHorizontalBias(float paramFloat)
  {
    this.mLastHorizontalBias = paramFloat;
  }
  
  public void setLastHorizontalStyle(int paramInt)
  {
    this.mLastHorizontalStyle = paramInt;
  }
  
  public void setLastVerticalBias(float paramFloat)
  {
    this.mLastVerticalBias = paramFloat;
  }
  
  public void setLastVerticalStyle(int paramInt)
  {
    this.mLastVerticalStyle = paramInt;
  }
  
  public void setMaxElementsWrap(int paramInt)
  {
    this.mMaxElementsWrap = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setVerticalAlign(int paramInt)
  {
    this.mVerticalAlign = paramInt;
  }
  
  public void setVerticalBias(float paramFloat)
  {
    this.mVerticalBias = paramFloat;
  }
  
  public void setVerticalGap(int paramInt)
  {
    this.mVerticalGap = paramInt;
  }
  
  public void setVerticalStyle(int paramInt)
  {
    this.mVerticalStyle = paramInt;
  }
  
  public void setWrapMode(int paramInt)
  {
    this.mWrapMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.Flow
 * JD-Core Version:    0.7.0.1
 */