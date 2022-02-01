package androidx.constraintlayout.solver.widgets;

class Flow$WidgetsList
{
  private ConstraintWidget biggest = null;
  int biggestDimension = 0;
  private ConstraintAnchor mBottom;
  private int mCount = 0;
  private int mHeight = 0;
  private ConstraintAnchor mLeft;
  private int mMax = 0;
  private int mNbMatchConstraintsWidgets = 0;
  private int mOrientation = 0;
  private int mPaddingBottom = 0;
  private int mPaddingLeft = 0;
  private int mPaddingRight = 0;
  private int mPaddingTop = 0;
  private ConstraintAnchor mRight;
  private int mStartIndex = 0;
  private ConstraintAnchor mTop;
  private int mWidth = 0;
  
  public Flow$WidgetsList(Flow paramFlow, int paramInt1, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, ConstraintAnchor paramConstraintAnchor3, ConstraintAnchor paramConstraintAnchor4, int paramInt2)
  {
    this.mOrientation = paramInt1;
    this.mLeft = paramConstraintAnchor1;
    this.mTop = paramConstraintAnchor2;
    this.mRight = paramConstraintAnchor3;
    this.mBottom = paramConstraintAnchor4;
    this.mPaddingLeft = paramFlow.getPaddingLeft();
    this.mPaddingTop = paramFlow.getPaddingTop();
    this.mPaddingRight = paramFlow.getPaddingRight();
    this.mPaddingBottom = paramFlow.getPaddingBottom();
    this.mMax = paramInt2;
  }
  
  private void recomputeDimensions()
  {
    this.mWidth = 0;
    this.mHeight = 0;
    this.biggest = null;
    this.biggestDimension = 0;
    int k = this.mCount;
    int i = 0;
    while (i < k)
    {
      if (this.mStartIndex + i >= Flow.access$400(this.this$0)) {
        return;
      }
      ConstraintWidget localConstraintWidget = Flow.access$500(this.this$0)[(this.mStartIndex + i)];
      int m;
      int j;
      if (this.mOrientation == 0)
      {
        m = localConstraintWidget.getWidth();
        j = Flow.access$000(this.this$0);
        if (localConstraintWidget.getVisibility() == 8) {
          j = 0;
        }
        this.mWidth += m + j;
        j = Flow.access$300(this.this$0, localConstraintWidget, this.mMax);
        if ((this.biggest == null) || (this.biggestDimension < j))
        {
          this.biggest = localConstraintWidget;
          this.biggestDimension = j;
          this.mHeight = j;
        }
      }
      else
      {
        m = Flow.access$200(this.this$0, localConstraintWidget, this.mMax);
        int n = Flow.access$300(this.this$0, localConstraintWidget, this.mMax);
        j = Flow.access$100(this.this$0);
        if (localConstraintWidget.getVisibility() == 8) {
          j = 0;
        }
        this.mHeight += n + j;
        if ((this.biggest == null) || (this.biggestDimension < m))
        {
          this.biggest = localConstraintWidget;
          this.biggestDimension = m;
          this.mWidth = m;
        }
      }
      i += 1;
    }
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    int i = this.mOrientation;
    int j = 0;
    int k = 0;
    if (i == 0)
    {
      i = Flow.access$200(this.this$0, paramConstraintWidget, this.mMax);
      if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        this.mNbMatchConstraintsWidgets += 1;
        i = 0;
      }
      j = Flow.access$000(this.this$0);
      if (paramConstraintWidget.getVisibility() == 8) {
        j = k;
      }
      this.mWidth += i + j;
      i = Flow.access$300(this.this$0, paramConstraintWidget, this.mMax);
      if ((this.biggest == null) || (this.biggestDimension < i))
      {
        this.biggest = paramConstraintWidget;
        this.biggestDimension = i;
        this.mHeight = i;
      }
    }
    else
    {
      int m = Flow.access$200(this.this$0, paramConstraintWidget, this.mMax);
      i = Flow.access$300(this.this$0, paramConstraintWidget, this.mMax);
      if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        this.mNbMatchConstraintsWidgets += 1;
        i = 0;
      }
      k = Flow.access$100(this.this$0);
      if (paramConstraintWidget.getVisibility() != 8) {
        j = k;
      }
      this.mHeight += i + j;
      if ((this.biggest == null) || (this.biggestDimension < m))
      {
        this.biggest = paramConstraintWidget;
        this.biggestDimension = m;
        this.mWidth = m;
      }
    }
    this.mCount += 1;
  }
  
  public void clear()
  {
    this.biggestDimension = 0;
    this.biggest = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mStartIndex = 0;
    this.mCount = 0;
    this.mNbMatchConstraintsWidgets = 0;
  }
  
  public void createConstraints(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i3 = this.mCount;
    int i = 0;
    Object localObject1;
    while ((i < i3) && (this.mStartIndex + i < Flow.access$400(this.this$0)))
    {
      localObject1 = Flow.access$500(this.this$0)[(this.mStartIndex + i)];
      if (localObject1 != null) {
        ((ConstraintWidget)localObject1).resetAnchors();
      }
      i += 1;
    }
    if (i3 != 0)
    {
      if (this.biggest == null) {
        return;
      }
      int m;
      if ((paramBoolean2) && (paramInt == 0)) {
        m = 1;
      } else {
        m = 0;
      }
      i = 0;
      int j = -1;
      int i1;
      for (int k = -1; i < i3; k = i1)
      {
        int i2;
        if (paramBoolean1) {
          i2 = i3 - 1 - i;
        } else {
          i2 = i;
        }
        if (this.mStartIndex + i2 >= Flow.access$400(this.this$0)) {
          break;
        }
        n = j;
        i1 = k;
        if (Flow.access$500(this.this$0)[(this.mStartIndex + i2)].getVisibility() == 0)
        {
          k = j;
          if (j == -1) {
            k = i;
          }
          i1 = i;
          n = k;
        }
        i += 1;
        j = n;
      }
      label441:
      Object localObject2;
      float f2;
      float f1;
      if (this.mOrientation == 0)
      {
        localConstraintWidget1 = this.biggest;
        localConstraintWidget1.setVerticalChainStyle(Flow.access$600(this.this$0));
        n = this.mPaddingTop;
        i = n;
        if (paramInt > 0) {
          i = n + Flow.access$100(this.this$0);
        }
        localConstraintWidget1.mTop.connect(this.mTop, i);
        if (paramBoolean2) {
          localConstraintWidget1.mBottom.connect(this.mBottom, this.mPaddingBottom);
        }
        if (paramInt > 0) {
          this.mTop.mOwner.mBottom.connect(localConstraintWidget1.mTop, 0);
        }
        if ((Flow.access$700(this.this$0) == 3) && (!localConstraintWidget1.hasBaseline()))
        {
          paramInt = 0;
          while (paramInt < i3)
          {
            if (paramBoolean1) {
              i = i3 - 1 - paramInt;
            } else {
              i = paramInt;
            }
            if (this.mStartIndex + i >= Flow.access$400(this.this$0)) {
              break;
            }
            localObject1 = Flow.access$500(this.this$0)[(this.mStartIndex + i)];
            if (((ConstraintWidget)localObject1).hasBaseline()) {
              break label441;
            }
            paramInt += 1;
          }
        }
        localObject1 = localConstraintWidget1;
        localObject2 = null;
        paramInt = 0;
        while (paramInt < i3)
        {
          if (paramBoolean1) {
            i = i3 - 1 - paramInt;
          } else {
            i = paramInt;
          }
          if (this.mStartIndex + i >= Flow.access$400(this.this$0)) {
            return;
          }
          ConstraintWidget localConstraintWidget2 = Flow.access$500(this.this$0)[(this.mStartIndex + i)];
          if (paramInt == 0) {
            localConstraintWidget2.connect(localConstraintWidget2.mLeft, this.mLeft, this.mPaddingLeft);
          }
          if (i == 0)
          {
            n = Flow.access$800(this.this$0);
            f2 = Flow.access$900(this.this$0);
            if ((this.mStartIndex == 0) && (Flow.access$1000(this.this$0) != -1))
            {
              i = Flow.access$1000(this.this$0);
              f1 = Flow.access$1100(this.this$0);
            }
            else
            {
              i = n;
              f1 = f2;
              if (paramBoolean2)
              {
                i = n;
                f1 = f2;
                if (Flow.access$1200(this.this$0) != -1)
                {
                  i = Flow.access$1200(this.this$0);
                  f1 = Flow.access$1300(this.this$0);
                }
              }
            }
            localConstraintWidget2.setHorizontalChainStyle(i);
            localConstraintWidget2.setHorizontalBiasPercent(f1);
          }
          if (paramInt == i3 - 1) {
            localConstraintWidget2.connect(localConstraintWidget2.mRight, this.mRight, this.mPaddingRight);
          }
          if (localObject2 != null)
          {
            localConstraintWidget2.mLeft.connect(((ConstraintWidget)localObject2).mRight, Flow.access$000(this.this$0));
            if (paramInt == j) {
              localConstraintWidget2.mLeft.setGoneMargin(this.mPaddingLeft);
            }
            ((ConstraintWidget)localObject2).mRight.connect(localConstraintWidget2.mLeft, 0);
            if (paramInt == k + 1) {
              ((ConstraintWidget)localObject2).mRight.setGoneMargin(this.mPaddingRight);
            }
          }
          if (localConstraintWidget2 != localConstraintWidget1) {
            if ((Flow.access$700(this.this$0) == 3) && (((ConstraintWidget)localObject1).hasBaseline()) && (localConstraintWidget2 != localObject1) && (localConstraintWidget2.hasBaseline()))
            {
              localConstraintWidget2.mBaseline.connect(((ConstraintWidget)localObject1).mBaseline, 0);
            }
            else
            {
              i = Flow.access$700(this.this$0);
              if (i != 0)
              {
                if (i != 1)
                {
                  if (m != 0)
                  {
                    localConstraintWidget2.mTop.connect(this.mTop, this.mPaddingTop);
                    localConstraintWidget2.mBottom.connect(this.mBottom, this.mPaddingBottom);
                  }
                  else
                  {
                    localConstraintWidget2.mTop.connect(localConstraintWidget1.mTop, 0);
                    localConstraintWidget2.mBottom.connect(localConstraintWidget1.mBottom, 0);
                  }
                }
                else {
                  localConstraintWidget2.mBottom.connect(localConstraintWidget1.mBottom, 0);
                }
              }
              else {
                localConstraintWidget2.mTop.connect(localConstraintWidget1.mTop, 0);
              }
            }
          }
          paramInt += 1;
          localObject2 = localConstraintWidget2;
        }
      }
      ConstraintWidget localConstraintWidget1 = this.biggest;
      localConstraintWidget1.setHorizontalChainStyle(Flow.access$800(this.this$0));
      int n = this.mPaddingLeft;
      i = n;
      if (paramInt > 0) {
        i = n + Flow.access$000(this.this$0);
      }
      if (paramBoolean1)
      {
        localConstraintWidget1.mRight.connect(this.mRight, i);
        if (paramBoolean2) {
          localConstraintWidget1.mLeft.connect(this.mLeft, this.mPaddingRight);
        }
        if (paramInt > 0) {
          this.mRight.mOwner.mLeft.connect(localConstraintWidget1.mRight, 0);
        }
      }
      else
      {
        localConstraintWidget1.mLeft.connect(this.mLeft, i);
        if (paramBoolean2) {
          localConstraintWidget1.mRight.connect(this.mRight, this.mPaddingRight);
        }
        if (paramInt > 0) {
          this.mLeft.mOwner.mRight.connect(localConstraintWidget1.mLeft, 0);
        }
      }
      localObject1 = null;
      i = 0;
      while (i < i3)
      {
        if (this.mStartIndex + i >= Flow.access$400(this.this$0)) {
          return;
        }
        localObject2 = Flow.access$500(this.this$0)[(this.mStartIndex + i)];
        if (i == 0)
        {
          ((ConstraintWidget)localObject2).connect(((ConstraintWidget)localObject2).mTop, this.mTop, this.mPaddingTop);
          n = Flow.access$600(this.this$0);
          f2 = Flow.access$1400(this.this$0);
          if ((this.mStartIndex == 0) && (Flow.access$1500(this.this$0) != -1))
          {
            paramInt = Flow.access$1500(this.this$0);
            f1 = Flow.access$1600(this.this$0);
          }
          else
          {
            paramInt = n;
            f1 = f2;
            if (paramBoolean2)
            {
              paramInt = n;
              f1 = f2;
              if (Flow.access$1700(this.this$0) != -1)
              {
                paramInt = Flow.access$1700(this.this$0);
                f1 = Flow.access$1800(this.this$0);
              }
            }
          }
          ((ConstraintWidget)localObject2).setVerticalChainStyle(paramInt);
          ((ConstraintWidget)localObject2).setVerticalBiasPercent(f1);
        }
        if (i == i3 - 1) {
          ((ConstraintWidget)localObject2).connect(((ConstraintWidget)localObject2).mBottom, this.mBottom, this.mPaddingBottom);
        }
        if (localObject1 != null)
        {
          ((ConstraintWidget)localObject2).mTop.connect(((ConstraintWidget)localObject1).mBottom, Flow.access$100(this.this$0));
          if (i == j) {
            ((ConstraintWidget)localObject2).mTop.setGoneMargin(this.mPaddingTop);
          }
          ((ConstraintWidget)localObject1).mBottom.connect(((ConstraintWidget)localObject2).mTop, 0);
          if (i == k + 1) {
            ((ConstraintWidget)localObject1).mBottom.setGoneMargin(this.mPaddingBottom);
          }
        }
        if (localObject2 != localConstraintWidget1) {
          if (paramBoolean1)
          {
            paramInt = Flow.access$1900(this.this$0);
            if (paramInt != 0)
            {
              if (paramInt != 1)
              {
                if (paramInt == 2)
                {
                  ((ConstraintWidget)localObject2).mLeft.connect(localConstraintWidget1.mLeft, 0);
                  ((ConstraintWidget)localObject2).mRight.connect(localConstraintWidget1.mRight, 0);
                }
              }
              else {
                ((ConstraintWidget)localObject2).mLeft.connect(localConstraintWidget1.mLeft, 0);
              }
            }
            else {
              ((ConstraintWidget)localObject2).mRight.connect(localConstraintWidget1.mRight, 0);
            }
          }
          else
          {
            paramInt = Flow.access$1900(this.this$0);
            if (paramInt != 0)
            {
              if (paramInt != 1)
              {
                if (paramInt == 2) {
                  if (m != 0)
                  {
                    ((ConstraintWidget)localObject2).mLeft.connect(this.mLeft, this.mPaddingLeft);
                    ((ConstraintWidget)localObject2).mRight.connect(this.mRight, this.mPaddingRight);
                  }
                  else
                  {
                    ((ConstraintWidget)localObject2).mLeft.connect(localConstraintWidget1.mLeft, 0);
                    ((ConstraintWidget)localObject2).mRight.connect(localConstraintWidget1.mRight, 0);
                  }
                }
              }
              else {
                ((ConstraintWidget)localObject2).mRight.connect(localConstraintWidget1.mRight, 0);
              }
            }
            else {
              ((ConstraintWidget)localObject2).mLeft.connect(localConstraintWidget1.mLeft, 0);
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
  }
  
  public int getHeight()
  {
    if (this.mOrientation == 1) {
      return this.mHeight - Flow.access$100(this.this$0);
    }
    return this.mHeight;
  }
  
  public int getWidth()
  {
    if (this.mOrientation == 0) {
      return this.mWidth - Flow.access$000(this.this$0);
    }
    return this.mWidth;
  }
  
  public void measureMatchConstraints(int paramInt)
  {
    int j = this.mNbMatchConstraintsWidgets;
    if (j == 0) {
      return;
    }
    int i = this.mCount;
    j = paramInt / j;
    paramInt = 0;
    while ((paramInt < i) && (this.mStartIndex + paramInt < Flow.access$400(this.this$0)))
    {
      ConstraintWidget localConstraintWidget = Flow.access$500(this.this$0)[(this.mStartIndex + paramInt)];
      if (this.mOrientation == 0)
      {
        if ((localConstraintWidget != null) && (localConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mMatchConstraintDefaultWidth == 0)) {
          this.this$0.measure(localConstraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, j, localConstraintWidget.getVerticalDimensionBehaviour(), localConstraintWidget.getHeight());
        }
      }
      else if ((localConstraintWidget != null) && (localConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.mMatchConstraintDefaultHeight == 0)) {
        this.this$0.measure(localConstraintWidget, localConstraintWidget.getHorizontalDimensionBehaviour(), localConstraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, j);
      }
      paramInt += 1;
    }
    recomputeDimensions();
  }
  
  public void setStartIndex(int paramInt)
  {
    this.mStartIndex = paramInt;
  }
  
  public void setup(int paramInt1, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, ConstraintAnchor paramConstraintAnchor3, ConstraintAnchor paramConstraintAnchor4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mOrientation = paramInt1;
    this.mLeft = paramConstraintAnchor1;
    this.mTop = paramConstraintAnchor2;
    this.mRight = paramConstraintAnchor3;
    this.mBottom = paramConstraintAnchor4;
    this.mPaddingLeft = paramInt2;
    this.mPaddingTop = paramInt3;
    this.mPaddingRight = paramInt4;
    this.mPaddingBottom = paramInt5;
    this.mMax = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.Flow.WidgetsList
 * JD-Core Version:    0.7.0.1
 */