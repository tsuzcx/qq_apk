package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Dimension
{
  public static final Object FIXED_DIMENSION = new Object();
  public static final Object PARENT_DIMENSION = new Object();
  public static final Object PERCENT_DIMENSION = new Object();
  public static final Object SPREAD_DIMENSION;
  public static final Object WRAP_DIMENSION = new Object();
  private final int WRAP_CONTENT = -2;
  Object mInitialValue = WRAP_DIMENSION;
  boolean mIsSuggested = false;
  int mMax = 2147483647;
  int mMin = 0;
  float mPercent = 1.0F;
  float mRatio = 1.0F;
  int mValue = 0;
  
  static
  {
    SPREAD_DIMENSION = new Object();
  }
  
  private Dimension() {}
  
  private Dimension(Object paramObject)
  {
    this.mInitialValue = paramObject;
  }
  
  public static Dimension Fixed(int paramInt)
  {
    Dimension localDimension = new Dimension(FIXED_DIMENSION);
    localDimension.fixed(paramInt);
    return localDimension;
  }
  
  public static Dimension Fixed(Object paramObject)
  {
    Dimension localDimension = new Dimension(FIXED_DIMENSION);
    localDimension.fixed(paramObject);
    return localDimension;
  }
  
  public static Dimension Parent()
  {
    return new Dimension(PARENT_DIMENSION);
  }
  
  public static Dimension Percent(Object paramObject, float paramFloat)
  {
    Dimension localDimension = new Dimension(PERCENT_DIMENSION);
    localDimension.percent(paramObject, paramFloat);
    return localDimension;
  }
  
  public static Dimension Spread()
  {
    return new Dimension(SPREAD_DIMENSION);
  }
  
  public static Dimension Suggested(int paramInt)
  {
    Dimension localDimension = new Dimension();
    localDimension.suggested(paramInt);
    return localDimension;
  }
  
  public static Dimension Suggested(Object paramObject)
  {
    Dimension localDimension = new Dimension();
    localDimension.suggested(paramObject);
    return localDimension;
  }
  
  public static Dimension Wrap()
  {
    return new Dimension(WRAP_DIMENSION);
  }
  
  public void apply(State paramState, ConstraintWidget paramConstraintWidget, int paramInt)
  {
    int i = 2;
    if (paramInt == 0)
    {
      if (this.mIsSuggested)
      {
        paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        paramState = this.mInitialValue;
        if (paramState == WRAP_DIMENSION) {
          paramInt = 1;
        } else if (paramState == PERCENT_DIMENSION) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        paramConstraintWidget.setHorizontalMatchStyle(paramInt, this.mMin, this.mMax, this.mPercent);
        return;
      }
      paramInt = this.mMin;
      if (paramInt > 0) {
        paramConstraintWidget.setMinWidth(paramInt);
      }
      paramInt = this.mMax;
      if (paramInt < 2147483647) {
        paramConstraintWidget.setMaxWidth(paramInt);
      }
      paramState = this.mInitialValue;
      if (paramState == WRAP_DIMENSION)
      {
        paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
      }
      if (paramState == PARENT_DIMENSION)
      {
        paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
      }
      if (paramState == null)
      {
        paramConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidget.setWidth(this.mValue);
      }
    }
    else
    {
      if (this.mIsSuggested)
      {
        paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        paramState = this.mInitialValue;
        if (paramState == WRAP_DIMENSION) {
          paramInt = 1;
        } else if (paramState == PERCENT_DIMENSION) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        paramConstraintWidget.setVerticalMatchStyle(paramInt, this.mMin, this.mMax, this.mPercent);
        return;
      }
      paramInt = this.mMin;
      if (paramInt > 0) {
        paramConstraintWidget.setMinHeight(paramInt);
      }
      paramInt = this.mMax;
      if (paramInt < 2147483647) {
        paramConstraintWidget.setMaxHeight(paramInt);
      }
      paramState = this.mInitialValue;
      if (paramState == WRAP_DIMENSION)
      {
        paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
      }
      if (paramState == PARENT_DIMENSION)
      {
        paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
      }
      if (paramState == null)
      {
        paramConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        paramConstraintWidget.setHeight(this.mValue);
      }
    }
  }
  
  public Dimension fixed(int paramInt)
  {
    this.mInitialValue = null;
    this.mValue = paramInt;
    return this;
  }
  
  public Dimension fixed(Object paramObject)
  {
    this.mInitialValue = paramObject;
    if ((paramObject instanceof Integer))
    {
      this.mValue = ((Integer)paramObject).intValue();
      this.mInitialValue = null;
    }
    return this;
  }
  
  float getRatio()
  {
    return this.mRatio;
  }
  
  int getValue()
  {
    return this.mValue;
  }
  
  public Dimension max(int paramInt)
  {
    if (this.mMax >= 0) {
      this.mMax = paramInt;
    }
    return this;
  }
  
  public Dimension max(Object paramObject)
  {
    Object localObject = WRAP_DIMENSION;
    if ((paramObject == localObject) && (this.mIsSuggested))
    {
      this.mInitialValue = localObject;
      this.mMax = 2147483647;
    }
    return this;
  }
  
  public Dimension min(int paramInt)
  {
    if (paramInt >= 0) {
      this.mMin = paramInt;
    }
    return this;
  }
  
  public Dimension min(Object paramObject)
  {
    if (paramObject == WRAP_DIMENSION) {
      this.mMin = -2;
    }
    return this;
  }
  
  public Dimension percent(Object paramObject, float paramFloat)
  {
    this.mPercent = paramFloat;
    return this;
  }
  
  public Dimension ratio(float paramFloat)
  {
    return this;
  }
  
  void setRatio(float paramFloat)
  {
    this.mRatio = paramFloat;
  }
  
  void setValue(int paramInt)
  {
    this.mIsSuggested = false;
    this.mInitialValue = null;
    this.mValue = paramInt;
  }
  
  public Dimension suggested(int paramInt)
  {
    this.mIsSuggested = true;
    return this;
  }
  
  public Dimension suggested(Object paramObject)
  {
    this.mInitialValue = paramObject;
    this.mIsSuggested = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.Dimension
 * JD-Core Version:    0.7.0.1
 */