package androidx.constraintlayout.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ConstraintProperties
{
  public static final int BASELINE = 5;
  public static final int BOTTOM = 4;
  public static final int END = 7;
  public static final int LEFT = 1;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  public static final int START = 6;
  public static final int TOP = 3;
  public static final int UNSET = -1;
  public static final int WRAP_CONTENT = -2;
  ConstraintLayout.LayoutParams mParams;
  View mView;
  
  public ConstraintProperties(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.LayoutParams))
    {
      this.mParams = ((ConstraintLayout.LayoutParams)localLayoutParams);
      this.mView = paramView;
      return;
    }
    throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
  }
  
  private String sideToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 7: 
      return "end";
    case 6: 
      return "start";
    case 5: 
      return "baseline";
    case 4: 
      return "bottom";
    case 3: 
      return "top";
    case 2: 
      return "right";
    }
    return "left";
  }
  
  public ConstraintProperties addToHorizontalChain(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0) {
      i = 1;
    } else {
      i = 2;
    }
    connect(1, paramInt1, i, 0);
    if (paramInt2 == 0) {
      i = 2;
    } else {
      i = 1;
    }
    connect(2, paramInt2, i, 0);
    if (paramInt1 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt1)).connect(2, this.mView.getId(), 1, 0);
    }
    if (paramInt2 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt2)).connect(1, this.mView.getId(), 2, 0);
    }
    return this;
  }
  
  public ConstraintProperties addToHorizontalChainRTL(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0) {
      i = 6;
    } else {
      i = 7;
    }
    connect(6, paramInt1, i, 0);
    if (paramInt2 == 0) {
      i = 7;
    } else {
      i = 6;
    }
    connect(7, paramInt2, i, 0);
    if (paramInt1 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt1)).connect(7, this.mView.getId(), 6, 0);
    }
    if (paramInt2 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt2)).connect(6, this.mView.getId(), 7, 0);
    }
    return this;
  }
  
  public ConstraintProperties addToVerticalChain(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == 0) {
      i = 3;
    } else {
      i = 4;
    }
    connect(3, paramInt1, i, 0);
    if (paramInt2 == 0) {
      i = 4;
    } else {
      i = 3;
    }
    connect(4, paramInt2, i, 0);
    if (paramInt1 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt1)).connect(4, this.mView.getId(), 3, 0);
    }
    if (paramInt2 != 0) {
      new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(paramInt2)).connect(3, this.mView.getId(), 4, 0);
    }
    return this;
  }
  
  public ConstraintProperties alpha(float paramFloat)
  {
    this.mView.setAlpha(paramFloat);
    return this;
  }
  
  public void apply() {}
  
  public ConstraintProperties center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    if (paramInt3 >= 0)
    {
      if (paramInt6 >= 0)
      {
        if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
        {
          if ((paramInt2 != 1) && (paramInt2 != 2))
          {
            if ((paramInt2 != 6) && (paramInt2 != 7))
            {
              connect(3, paramInt1, paramInt2, paramInt3);
              connect(4, paramInt4, paramInt5, paramInt6);
              this.mParams.verticalBias = paramFloat;
              return this;
            }
            connect(6, paramInt1, paramInt2, paramInt3);
            connect(7, paramInt4, paramInt5, paramInt6);
            this.mParams.horizontalBias = paramFloat;
            return this;
          }
          connect(1, paramInt1, paramInt2, paramInt3);
          connect(2, paramInt4, paramInt5, paramInt6);
          this.mParams.horizontalBias = paramFloat;
          return this;
        }
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
      }
      throw new IllegalArgumentException("margin must be > 0");
    }
    throw new IllegalArgumentException("margin must be > 0");
  }
  
  public ConstraintProperties centerHorizontally(int paramInt)
  {
    if (paramInt == 0)
    {
      center(0, 1, 0, 0, 2, 0, 0.5F);
      return this;
    }
    center(paramInt, 2, 0, paramInt, 1, 0, 0.5F);
    return this;
  }
  
  public ConstraintProperties centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    connect(1, paramInt1, paramInt2, paramInt3);
    connect(2, paramInt4, paramInt5, paramInt6);
    this.mParams.horizontalBias = paramFloat;
    return this;
  }
  
  public ConstraintProperties centerHorizontallyRtl(int paramInt)
  {
    if (paramInt == 0)
    {
      center(0, 6, 0, 0, 7, 0, 0.5F);
      return this;
    }
    center(paramInt, 7, 0, paramInt, 6, 0, 0.5F);
    return this;
  }
  
  public ConstraintProperties centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    connect(6, paramInt1, paramInt2, paramInt3);
    connect(7, paramInt4, paramInt5, paramInt6);
    this.mParams.horizontalBias = paramFloat;
    return this;
  }
  
  public ConstraintProperties centerVertically(int paramInt)
  {
    if (paramInt == 0)
    {
      center(0, 3, 0, 0, 4, 0, 0.5F);
      return this;
    }
    center(paramInt, 4, 0, paramInt, 3, 0, 0.5F);
    return this;
  }
  
  public ConstraintProperties centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    connect(3, paramInt1, paramInt2, paramInt3);
    connect(4, paramInt4, paramInt5, paramInt6);
    this.mParams.verticalBias = paramFloat;
    return this;
  }
  
  public ConstraintProperties connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sideToString(paramInt1));
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(sideToString(paramInt3));
      ((StringBuilder)localObject).append(" unknown");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 7: 
      if (paramInt3 == 7)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).endToEnd = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).endToStart = -1;
      }
      else
      {
        if (paramInt3 != 6) {
          break label174;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).endToStart = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).endToEnd = -1;
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.mParams.setMarginEnd(paramInt4);
        return this;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("right to ");
        ((StringBuilder)localObject).append(sideToString(paramInt3));
        ((StringBuilder)localObject).append(" undefined");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      break;
    case 6: 
      if (paramInt3 == 6)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).startToStart = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).startToEnd = -1;
      }
      else
      {
        if (paramInt3 != 7) {
          break label293;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).startToEnd = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).startToStart = -1;
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.mParams.setMarginStart(paramInt4);
        return this;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("right to ");
        ((StringBuilder)localObject).append(sideToString(paramInt3));
        ((StringBuilder)localObject).append(" undefined");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      break;
    case 5: 
      if (paramInt3 == 5)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).baselineToBaseline = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).bottomToBottom = -1;
        ((ConstraintLayout.LayoutParams)localObject).bottomToTop = -1;
        ((ConstraintLayout.LayoutParams)localObject).topToTop = -1;
        ((ConstraintLayout.LayoutParams)localObject).topToBottom = -1;
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt3));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 4: 
      if (paramInt3 == 4)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).bottomToBottom = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).bottomToTop = -1;
        ((ConstraintLayout.LayoutParams)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt3 != 3) {
          break label506;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).bottomToTop = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).bottomToBottom = -1;
        ((ConstraintLayout.LayoutParams)localObject).baselineToBaseline = -1;
      }
      this.mParams.bottomMargin = paramInt4;
      return this;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt3));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt3 == 3)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).topToTop = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).topToBottom = -1;
        ((ConstraintLayout.LayoutParams)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt3 != 4) {
          break label627;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).topToBottom = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).topToTop = -1;
        ((ConstraintLayout.LayoutParams)localObject).baselineToBaseline = -1;
      }
      this.mParams.topMargin = paramInt4;
      return this;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt3));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      if (paramInt3 == 1)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).rightToLeft = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).rightToRight = -1;
      }
      else
      {
        if (paramInt3 != 2) {
          break label736;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).rightToRight = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).rightToLeft = -1;
      }
      this.mParams.rightMargin = paramInt4;
      return this;
      label736:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt3));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 1: 
      label174:
      label506:
      if (paramInt3 == 1)
      {
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).leftToLeft = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).leftToRight = -1;
      }
      else
      {
        if (paramInt3 != 2) {
          break label845;
        }
        localObject = this.mParams;
        ((ConstraintLayout.LayoutParams)localObject).leftToRight = paramInt2;
        ((ConstraintLayout.LayoutParams)localObject).leftToLeft = -1;
      }
      label293:
      label627:
      this.mParams.leftMargin = paramInt4;
    }
    return this;
    label845:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt3));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public ConstraintProperties constrainDefaultHeight(int paramInt)
  {
    this.mParams.matchConstraintDefaultHeight = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainDefaultWidth(int paramInt)
  {
    this.mParams.matchConstraintDefaultWidth = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainHeight(int paramInt)
  {
    this.mParams.height = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainMaxHeight(int paramInt)
  {
    this.mParams.matchConstraintMaxHeight = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainMaxWidth(int paramInt)
  {
    this.mParams.matchConstraintMaxWidth = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainMinHeight(int paramInt)
  {
    this.mParams.matchConstraintMinHeight = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainMinWidth(int paramInt)
  {
    this.mParams.matchConstraintMinWidth = paramInt;
    return this;
  }
  
  public ConstraintProperties constrainWidth(int paramInt)
  {
    this.mParams.width = paramInt;
    return this;
  }
  
  public ConstraintProperties dimensionRatio(String paramString)
  {
    this.mParams.dimensionRatio = paramString;
    return this;
  }
  
  public ConstraintProperties elevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mView.setElevation(paramFloat);
    }
    return this;
  }
  
  public ConstraintProperties goneMargin(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      this.mParams.goneEndMargin = paramInt2;
      return this;
    case 6: 
      this.mParams.goneStartMargin = paramInt2;
      return this;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      this.mParams.goneBottomMargin = paramInt2;
      return this;
    case 3: 
      this.mParams.goneTopMargin = paramInt2;
      return this;
    case 2: 
      this.mParams.goneRightMargin = paramInt2;
      return this;
    }
    this.mParams.goneLeftMargin = paramInt2;
    return this;
  }
  
  public ConstraintProperties horizontalBias(float paramFloat)
  {
    this.mParams.horizontalBias = paramFloat;
    return this;
  }
  
  public ConstraintProperties horizontalChainStyle(int paramInt)
  {
    this.mParams.horizontalChainStyle = paramInt;
    return this;
  }
  
  public ConstraintProperties horizontalWeight(float paramFloat)
  {
    this.mParams.horizontalWeight = paramFloat;
    return this;
  }
  
  public ConstraintProperties margin(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      this.mParams.setMarginEnd(paramInt2);
      return this;
    case 6: 
      this.mParams.setMarginStart(paramInt2);
      return this;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      this.mParams.bottomMargin = paramInt2;
      return this;
    case 3: 
      this.mParams.topMargin = paramInt2;
      return this;
    case 2: 
      this.mParams.rightMargin = paramInt2;
      return this;
    }
    this.mParams.leftMargin = paramInt2;
    return this;
  }
  
  public ConstraintProperties removeConstraints(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localLayoutParams = this.mParams;
      localLayoutParams.endToStart = -1;
      localLayoutParams.endToEnd = -1;
      localLayoutParams.setMarginEnd(-1);
      this.mParams.goneEndMargin = -1;
      return this;
    case 6: 
      localLayoutParams = this.mParams;
      localLayoutParams.startToEnd = -1;
      localLayoutParams.startToStart = -1;
      localLayoutParams.setMarginStart(-1);
      this.mParams.goneStartMargin = -1;
      return this;
    case 5: 
      this.mParams.baselineToBaseline = -1;
      return this;
    case 4: 
      localLayoutParams = this.mParams;
      localLayoutParams.bottomToTop = -1;
      localLayoutParams.bottomToBottom = -1;
      localLayoutParams.bottomMargin = -1;
      localLayoutParams.goneBottomMargin = -1;
      return this;
    case 3: 
      localLayoutParams = this.mParams;
      localLayoutParams.topToBottom = -1;
      localLayoutParams.topToTop = -1;
      localLayoutParams.topMargin = -1;
      localLayoutParams.goneTopMargin = -1;
      return this;
    case 2: 
      localLayoutParams = this.mParams;
      localLayoutParams.rightToRight = -1;
      localLayoutParams.rightToLeft = -1;
      localLayoutParams.rightMargin = -1;
      localLayoutParams.goneRightMargin = -1;
      return this;
    }
    ConstraintLayout.LayoutParams localLayoutParams = this.mParams;
    localLayoutParams.leftToRight = -1;
    localLayoutParams.leftToLeft = -1;
    localLayoutParams.leftMargin = -1;
    localLayoutParams.goneLeftMargin = -1;
    return this;
  }
  
  public ConstraintProperties removeFromHorizontalChain()
  {
    int i = this.mParams.leftToRight;
    int j = this.mParams.rightToLeft;
    Object localObject1 = this.mParams;
    if ((i == -1) && (j == -1))
    {
      j = ((ConstraintLayout.LayoutParams)localObject1).startToEnd;
      int k = this.mParams.endToStart;
      localObject1 = this.mParams;
      if ((j != -1) || (k != -1))
      {
        localObject2 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(j));
        localObject1 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(k));
        localLayoutParams = this.mParams;
        if ((j != -1) && (k != -1))
        {
          ((ConstraintProperties)localObject2).connect(7, k, 6, 0);
          ((ConstraintProperties)localObject1).connect(6, i, 7, 0);
        }
        else
        {
          localLayoutParams = this.mParams;
          if ((i != -1) || (k != -1))
          {
            i = this.mParams.rightToRight;
            localLayoutParams = this.mParams;
            if (i != -1)
            {
              ((ConstraintProperties)localObject2).connect(7, localLayoutParams.rightToRight, 7, 0);
            }
            else
            {
              i = localLayoutParams.leftToLeft;
              localObject2 = this.mParams;
              if (i != -1) {
                ((ConstraintProperties)localObject1).connect(6, ((ConstraintLayout.LayoutParams)localObject2).leftToLeft, 6, 0);
              }
            }
          }
        }
      }
      removeConstraints(6);
      removeConstraints(7);
      return this;
    }
    Object localObject2 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(i));
    localObject1 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(j));
    ConstraintLayout.LayoutParams localLayoutParams = this.mParams;
    if ((i != -1) && (j != -1))
    {
      ((ConstraintProperties)localObject2).connect(2, j, 1, 0);
      ((ConstraintProperties)localObject1).connect(1, i, 2, 0);
    }
    else
    {
      localLayoutParams = this.mParams;
      if ((i != -1) || (j != -1))
      {
        i = this.mParams.rightToRight;
        localLayoutParams = this.mParams;
        if (i != -1)
        {
          ((ConstraintProperties)localObject2).connect(2, localLayoutParams.rightToRight, 2, 0);
        }
        else
        {
          i = localLayoutParams.leftToLeft;
          localObject2 = this.mParams;
          if (i != -1) {
            ((ConstraintProperties)localObject1).connect(1, ((ConstraintLayout.LayoutParams)localObject2).leftToLeft, 1, 0);
          }
        }
      }
    }
    removeConstraints(1);
    removeConstraints(2);
    return this;
  }
  
  public ConstraintProperties removeFromVerticalChain()
  {
    int i = this.mParams.topToBottom;
    int j = this.mParams.bottomToTop;
    Object localObject1 = this.mParams;
    if ((i != -1) || (j != -1))
    {
      Object localObject2 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(i));
      localObject1 = new ConstraintProperties(((ViewGroup)this.mView.getParent()).findViewById(j));
      ConstraintLayout.LayoutParams localLayoutParams = this.mParams;
      if ((i != -1) && (j != -1))
      {
        ((ConstraintProperties)localObject2).connect(4, j, 3, 0);
        ((ConstraintProperties)localObject1).connect(3, i, 4, 0);
      }
      else
      {
        localLayoutParams = this.mParams;
        if ((i != -1) || (j != -1))
        {
          i = this.mParams.bottomToBottom;
          localLayoutParams = this.mParams;
          if (i != -1)
          {
            ((ConstraintProperties)localObject2).connect(4, localLayoutParams.bottomToBottom, 4, 0);
          }
          else
          {
            i = localLayoutParams.topToTop;
            localObject2 = this.mParams;
            if (i != -1) {
              ((ConstraintProperties)localObject1).connect(3, ((ConstraintLayout.LayoutParams)localObject2).topToTop, 3, 0);
            }
          }
        }
      }
    }
    removeConstraints(3);
    removeConstraints(4);
    return this;
  }
  
  public ConstraintProperties rotation(float paramFloat)
  {
    this.mView.setRotation(paramFloat);
    return this;
  }
  
  public ConstraintProperties rotationX(float paramFloat)
  {
    this.mView.setRotationX(paramFloat);
    return this;
  }
  
  public ConstraintProperties rotationY(float paramFloat)
  {
    this.mView.setRotationY(paramFloat);
    return this;
  }
  
  public ConstraintProperties scaleX(float paramFloat)
  {
    this.mView.setScaleY(paramFloat);
    return this;
  }
  
  public ConstraintProperties scaleY(float paramFloat)
  {
    return this;
  }
  
  public ConstraintProperties transformPivot(float paramFloat1, float paramFloat2)
  {
    this.mView.setPivotX(paramFloat1);
    this.mView.setPivotY(paramFloat2);
    return this;
  }
  
  public ConstraintProperties transformPivotX(float paramFloat)
  {
    this.mView.setPivotX(paramFloat);
    return this;
  }
  
  public ConstraintProperties transformPivotY(float paramFloat)
  {
    this.mView.setPivotY(paramFloat);
    return this;
  }
  
  public ConstraintProperties translation(float paramFloat1, float paramFloat2)
  {
    this.mView.setTranslationX(paramFloat1);
    this.mView.setTranslationY(paramFloat2);
    return this;
  }
  
  public ConstraintProperties translationX(float paramFloat)
  {
    this.mView.setTranslationX(paramFloat);
    return this;
  }
  
  public ConstraintProperties translationY(float paramFloat)
  {
    this.mView.setTranslationY(paramFloat);
    return this;
  }
  
  public ConstraintProperties translationZ(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.mView.setTranslationZ(paramFloat);
    }
    return this;
  }
  
  public ConstraintProperties verticalBias(float paramFloat)
  {
    this.mParams.verticalBias = paramFloat;
    return this;
  }
  
  public ConstraintProperties verticalChainStyle(int paramInt)
  {
    this.mParams.verticalChainStyle = paramInt;
    return this;
  }
  
  public ConstraintProperties verticalWeight(float paramFloat)
  {
    this.mParams.verticalWeight = paramFloat;
    return this;
  }
  
  public ConstraintProperties visibility(int paramInt)
  {
    this.mView.setVisibility(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintProperties
 * JD-Core Version:    0.7.0.1
 */