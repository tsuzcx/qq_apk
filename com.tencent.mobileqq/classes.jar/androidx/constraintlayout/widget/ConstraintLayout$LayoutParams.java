package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

public class ConstraintLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public static final int BASELINE = 5;
  public static final int BOTTOM = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static final int END = 7;
  public static final int HORIZONTAL = 0;
  public static final int LEFT = 1;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_PERCENT = 2;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  public static final int START = 6;
  public static final int TOP = 3;
  public static final int UNSET = -1;
  public static final int VERTICAL = 1;
  public int baselineToBaseline = -1;
  public int bottomToBottom = -1;
  public int bottomToTop = -1;
  public float circleAngle = 0.0F;
  public int circleConstraint = -1;
  public int circleRadius = 0;
  public boolean constrainedHeight = false;
  public boolean constrainedWidth = false;
  public String constraintTag = null;
  public String dimensionRatio = null;
  int dimensionRatioSide = 1;
  float dimensionRatioValue = 0.0F;
  public int editorAbsoluteX = -1;
  public int editorAbsoluteY = -1;
  public int endToEnd = -1;
  public int endToStart = -1;
  public int goneBottomMargin = -1;
  public int goneEndMargin = -1;
  public int goneLeftMargin = -1;
  public int goneRightMargin = -1;
  public int goneStartMargin = -1;
  public int goneTopMargin = -1;
  public int guideBegin = -1;
  public int guideEnd = -1;
  public float guidePercent = -1.0F;
  public boolean helped = false;
  public float horizontalBias = 0.5F;
  public int horizontalChainStyle = 0;
  boolean horizontalDimensionFixed = true;
  public float horizontalWeight = -1.0F;
  boolean isGuideline = false;
  boolean isHelper = false;
  boolean isInPlaceholder = false;
  boolean isVirtualGroup = false;
  public int leftToLeft = -1;
  public int leftToRight = -1;
  public int matchConstraintDefaultHeight = 0;
  public int matchConstraintDefaultWidth = 0;
  public int matchConstraintMaxHeight = 0;
  public int matchConstraintMaxWidth = 0;
  public int matchConstraintMinHeight = 0;
  public int matchConstraintMinWidth = 0;
  public float matchConstraintPercentHeight = 1.0F;
  public float matchConstraintPercentWidth = 1.0F;
  boolean needsBaseline = false;
  public int orientation = -1;
  int resolveGoneLeftMargin = -1;
  int resolveGoneRightMargin = -1;
  int resolvedGuideBegin;
  int resolvedGuideEnd;
  float resolvedGuidePercent;
  float resolvedHorizontalBias = 0.5F;
  int resolvedLeftToLeft = -1;
  int resolvedLeftToRight = -1;
  int resolvedRightToLeft = -1;
  int resolvedRightToRight = -1;
  public int rightToLeft = -1;
  public int rightToRight = -1;
  public int startToEnd = -1;
  public int startToStart = -1;
  public int topToBottom = -1;
  public int topToTop = -1;
  public float verticalBias = 0.5F;
  public int verticalChainStyle = 0;
  boolean verticalDimensionFixed = true;
  public float verticalWeight = -1.0F;
  ConstraintWidget widget = new ConstraintWidget();
  
  public ConstraintLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
    int k = paramContext.getIndexCount();
    int i = 0;
    while (i < k)
    {
      int j = paramContext.getIndex(i);
      String str;
      switch (ConstraintLayout.LayoutParams.Table.map.get(j))
      {
      case 43: 
      default: 
        break;
      case 51: 
        this.constraintTag = paramContext.getString(j);
        break;
      case 50: 
        this.editorAbsoluteY = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteY);
        break;
      case 49: 
        this.editorAbsoluteX = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteX);
        break;
      case 48: 
        this.verticalChainStyle = paramContext.getInt(j, 0);
        break;
      case 47: 
        this.horizontalChainStyle = paramContext.getInt(j, 0);
        break;
      case 46: 
        this.verticalWeight = paramContext.getFloat(j, this.verticalWeight);
        break;
      case 45: 
        this.horizontalWeight = paramContext.getFloat(j, this.horizontalWeight);
        break;
      case 44: 
        this.dimensionRatio = paramContext.getString(j);
        this.dimensionRatioValue = (0.0F / 0.0F);
        this.dimensionRatioSide = -1;
        paramAttributeSet = this.dimensionRatio;
        if (paramAttributeSet != null)
        {
          int m = paramAttributeSet.length();
          j = this.dimensionRatio.indexOf(',');
          if ((j > 0) && (j < m - 1))
          {
            paramAttributeSet = this.dimensionRatio.substring(0, j);
            if (paramAttributeSet.equalsIgnoreCase("W")) {
              this.dimensionRatioSide = 0;
            } else if (paramAttributeSet.equalsIgnoreCase("H")) {
              this.dimensionRatioSide = 1;
            }
            j += 1;
          }
          else
          {
            j = 0;
          }
          int n = this.dimensionRatio.indexOf(':');
          if ((n >= 0) && (n < m - 1))
          {
            paramAttributeSet = this.dimensionRatio.substring(j, n);
            str = this.dimensionRatio.substring(n + 1);
            if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
              break label2065;
            }
          }
        }
        break;
      }
      try
      {
        f1 = Float.parseFloat(paramAttributeSet);
        float f2 = Float.parseFloat(str);
        if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label2065;
        }
        if (this.dimensionRatioSide == 1) {
          this.dimensionRatioValue = Math.abs(f2 / f1);
        } else {
          this.dimensionRatioValue = Math.abs(f1 / f2);
        }
      }
      catch (NumberFormatException paramAttributeSet)
      {
        float f1;
        label1027:
        break label2065;
      }
      paramAttributeSet = this.dimensionRatio.substring(j);
      if (paramAttributeSet.length() > 0)
      {
        this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
        break label2065;
        this.matchConstraintPercentHeight = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentHeight));
        this.matchConstraintDefaultHeight = 2;
      }
      try
      {
        this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxHeight);
      }
      catch (Exception paramAttributeSet)
      {
        break label1027;
      }
      if (paramContext.getInt(j, this.matchConstraintMaxHeight) == -2) {
        this.matchConstraintMaxHeight = -2;
      }
      try
      {
        this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMinHeight);
      }
      catch (Exception paramAttributeSet)
      {
        label1068:
        break label1068;
      }
      if (paramContext.getInt(j, this.matchConstraintMinHeight) == -2)
      {
        this.matchConstraintMinHeight = -2;
        break label2065;
        this.matchConstraintPercentWidth = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentWidth));
        this.matchConstraintDefaultWidth = 2;
      }
      try
      {
        this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxWidth);
      }
      catch (Exception paramAttributeSet)
      {
        label1135:
        break label1135;
      }
      if (paramContext.getInt(j, this.matchConstraintMaxWidth) == -2) {
        this.matchConstraintMaxWidth = -2;
      }
      try
      {
        this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMinWidth);
      }
      catch (Exception paramAttributeSet)
      {
        label1176:
        break label1176;
      }
      if (paramContext.getInt(j, this.matchConstraintMinWidth) == -2)
      {
        this.matchConstraintMinWidth = -2;
        break label2065;
        this.matchConstraintDefaultHeight = paramContext.getInt(j, 0);
        if (this.matchConstraintDefaultHeight == 1)
        {
          Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
          break label2065;
          this.matchConstraintDefaultWidth = paramContext.getInt(j, 0);
          if (this.matchConstraintDefaultWidth == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            break label2065;
            this.verticalBias = paramContext.getFloat(j, this.verticalBias);
            break label2065;
            this.horizontalBias = paramContext.getFloat(j, this.horizontalBias);
            break label2065;
            this.constrainedHeight = paramContext.getBoolean(j, this.constrainedHeight);
            break label2065;
            this.constrainedWidth = paramContext.getBoolean(j, this.constrainedWidth);
            break label2065;
            this.goneEndMargin = paramContext.getDimensionPixelSize(j, this.goneEndMargin);
            break label2065;
            this.goneStartMargin = paramContext.getDimensionPixelSize(j, this.goneStartMargin);
            break label2065;
            this.goneBottomMargin = paramContext.getDimensionPixelSize(j, this.goneBottomMargin);
            break label2065;
            this.goneRightMargin = paramContext.getDimensionPixelSize(j, this.goneRightMargin);
            break label2065;
            this.goneTopMargin = paramContext.getDimensionPixelSize(j, this.goneTopMargin);
            break label2065;
            this.goneLeftMargin = paramContext.getDimensionPixelSize(j, this.goneLeftMargin);
            break label2065;
            this.endToEnd = paramContext.getResourceId(j, this.endToEnd);
            if (this.endToEnd == -1)
            {
              this.endToEnd = paramContext.getInt(j, -1);
              break label2065;
              this.endToStart = paramContext.getResourceId(j, this.endToStart);
              if (this.endToStart == -1)
              {
                this.endToStart = paramContext.getInt(j, -1);
                break label2065;
                this.startToStart = paramContext.getResourceId(j, this.startToStart);
                if (this.startToStart == -1)
                {
                  this.startToStart = paramContext.getInt(j, -1);
                  break label2065;
                  this.startToEnd = paramContext.getResourceId(j, this.startToEnd);
                  if (this.startToEnd == -1)
                  {
                    this.startToEnd = paramContext.getInt(j, -1);
                    break label2065;
                    this.baselineToBaseline = paramContext.getResourceId(j, this.baselineToBaseline);
                    if (this.baselineToBaseline == -1)
                    {
                      this.baselineToBaseline = paramContext.getInt(j, -1);
                      break label2065;
                      this.bottomToBottom = paramContext.getResourceId(j, this.bottomToBottom);
                      if (this.bottomToBottom == -1)
                      {
                        this.bottomToBottom = paramContext.getInt(j, -1);
                        break label2065;
                        this.bottomToTop = paramContext.getResourceId(j, this.bottomToTop);
                        if (this.bottomToTop == -1)
                        {
                          this.bottomToTop = paramContext.getInt(j, -1);
                          break label2065;
                          this.topToBottom = paramContext.getResourceId(j, this.topToBottom);
                          if (this.topToBottom == -1)
                          {
                            this.topToBottom = paramContext.getInt(j, -1);
                            break label2065;
                            this.topToTop = paramContext.getResourceId(j, this.topToTop);
                            if (this.topToTop == -1)
                            {
                              this.topToTop = paramContext.getInt(j, -1);
                              break label2065;
                              this.rightToRight = paramContext.getResourceId(j, this.rightToRight);
                              if (this.rightToRight == -1)
                              {
                                this.rightToRight = paramContext.getInt(j, -1);
                                break label2065;
                                this.rightToLeft = paramContext.getResourceId(j, this.rightToLeft);
                                if (this.rightToLeft == -1)
                                {
                                  this.rightToLeft = paramContext.getInt(j, -1);
                                  break label2065;
                                  this.leftToRight = paramContext.getResourceId(j, this.leftToRight);
                                  if (this.leftToRight == -1)
                                  {
                                    this.leftToRight = paramContext.getInt(j, -1);
                                    break label2065;
                                    this.leftToLeft = paramContext.getResourceId(j, this.leftToLeft);
                                    if (this.leftToLeft == -1)
                                    {
                                      this.leftToLeft = paramContext.getInt(j, -1);
                                      break label2065;
                                      this.guidePercent = paramContext.getFloat(j, this.guidePercent);
                                      break label2065;
                                      this.guideEnd = paramContext.getDimensionPixelOffset(j, this.guideEnd);
                                      break label2065;
                                      this.guideBegin = paramContext.getDimensionPixelOffset(j, this.guideBegin);
                                      break label2065;
                                      this.circleAngle = (paramContext.getFloat(j, this.circleAngle) % 360.0F);
                                      f1 = this.circleAngle;
                                      if (f1 < 0.0F)
                                      {
                                        this.circleAngle = ((360.0F - f1) % 360.0F);
                                        break label2065;
                                        this.circleRadius = paramContext.getDimensionPixelSize(j, this.circleRadius);
                                        break label2065;
                                        this.circleConstraint = paramContext.getResourceId(j, this.circleConstraint);
                                        if (this.circleConstraint == -1)
                                        {
                                          this.circleConstraint = paramContext.getInt(j, -1);
                                          break label2065;
                                          this.orientation = paramContext.getInt(j, this.orientation);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label2065:
      i += 1;
    }
    paramContext.recycle();
    validate();
  }
  
  public ConstraintLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public ConstraintLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.guideBegin = paramLayoutParams.guideBegin;
    this.guideEnd = paramLayoutParams.guideEnd;
    this.guidePercent = paramLayoutParams.guidePercent;
    this.leftToLeft = paramLayoutParams.leftToLeft;
    this.leftToRight = paramLayoutParams.leftToRight;
    this.rightToLeft = paramLayoutParams.rightToLeft;
    this.rightToRight = paramLayoutParams.rightToRight;
    this.topToTop = paramLayoutParams.topToTop;
    this.topToBottom = paramLayoutParams.topToBottom;
    this.bottomToTop = paramLayoutParams.bottomToTop;
    this.bottomToBottom = paramLayoutParams.bottomToBottom;
    this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
    this.circleConstraint = paramLayoutParams.circleConstraint;
    this.circleRadius = paramLayoutParams.circleRadius;
    this.circleAngle = paramLayoutParams.circleAngle;
    this.startToEnd = paramLayoutParams.startToEnd;
    this.startToStart = paramLayoutParams.startToStart;
    this.endToStart = paramLayoutParams.endToStart;
    this.endToEnd = paramLayoutParams.endToEnd;
    this.goneLeftMargin = paramLayoutParams.goneLeftMargin;
    this.goneTopMargin = paramLayoutParams.goneTopMargin;
    this.goneRightMargin = paramLayoutParams.goneRightMargin;
    this.goneBottomMargin = paramLayoutParams.goneBottomMargin;
    this.goneStartMargin = paramLayoutParams.goneStartMargin;
    this.goneEndMargin = paramLayoutParams.goneEndMargin;
    this.horizontalBias = paramLayoutParams.horizontalBias;
    this.verticalBias = paramLayoutParams.verticalBias;
    this.dimensionRatio = paramLayoutParams.dimensionRatio;
    this.dimensionRatioValue = paramLayoutParams.dimensionRatioValue;
    this.dimensionRatioSide = paramLayoutParams.dimensionRatioSide;
    this.horizontalWeight = paramLayoutParams.horizontalWeight;
    this.verticalWeight = paramLayoutParams.verticalWeight;
    this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
    this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
    this.constrainedWidth = paramLayoutParams.constrainedWidth;
    this.constrainedHeight = paramLayoutParams.constrainedHeight;
    this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
    this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
    this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
    this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
    this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
    this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
    this.matchConstraintPercentWidth = paramLayoutParams.matchConstraintPercentWidth;
    this.matchConstraintPercentHeight = paramLayoutParams.matchConstraintPercentHeight;
    this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
    this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
    this.orientation = paramLayoutParams.orientation;
    this.horizontalDimensionFixed = paramLayoutParams.horizontalDimensionFixed;
    this.verticalDimensionFixed = paramLayoutParams.verticalDimensionFixed;
    this.needsBaseline = paramLayoutParams.needsBaseline;
    this.isGuideline = paramLayoutParams.isGuideline;
    this.resolvedLeftToLeft = paramLayoutParams.resolvedLeftToLeft;
    this.resolvedLeftToRight = paramLayoutParams.resolvedLeftToRight;
    this.resolvedRightToLeft = paramLayoutParams.resolvedRightToLeft;
    this.resolvedRightToRight = paramLayoutParams.resolvedRightToRight;
    this.resolveGoneLeftMargin = paramLayoutParams.resolveGoneLeftMargin;
    this.resolveGoneRightMargin = paramLayoutParams.resolveGoneRightMargin;
    this.resolvedHorizontalBias = paramLayoutParams.resolvedHorizontalBias;
    this.constraintTag = paramLayoutParams.constraintTag;
    this.widget = paramLayoutParams.widget;
  }
  
  public String getConstraintTag()
  {
    return this.constraintTag;
  }
  
  public ConstraintWidget getConstraintWidget()
  {
    return this.widget;
  }
  
  public void reset()
  {
    ConstraintWidget localConstraintWidget = this.widget;
    if (localConstraintWidget != null) {
      localConstraintWidget.reset();
    }
  }
  
  @TargetApi(17)
  public void resolveLayoutDirection(int paramInt)
  {
    int j = this.leftMargin;
    int k = this.rightMargin;
    int m = Build.VERSION.SDK_INT;
    int i = 0;
    if (m >= 17)
    {
      super.resolveLayoutDirection(paramInt);
      if (1 == getLayoutDirection())
      {
        paramInt = 1;
        break label46;
      }
    }
    paramInt = 0;
    label46:
    this.resolvedRightToLeft = -1;
    this.resolvedRightToRight = -1;
    this.resolvedLeftToLeft = -1;
    this.resolvedLeftToRight = -1;
    this.resolveGoneLeftMargin = -1;
    this.resolveGoneRightMargin = -1;
    this.resolveGoneLeftMargin = this.goneLeftMargin;
    this.resolveGoneRightMargin = this.goneRightMargin;
    this.resolvedHorizontalBias = this.horizontalBias;
    this.resolvedGuideBegin = this.guideBegin;
    this.resolvedGuideEnd = this.guideEnd;
    this.resolvedGuidePercent = this.guidePercent;
    if (paramInt != 0)
    {
      paramInt = this.startToEnd;
      if (paramInt != -1) {
        this.resolvedRightToLeft = paramInt;
      }
      for (;;)
      {
        paramInt = 1;
        break;
        m = this.startToStart;
        paramInt = i;
        if (m == -1) {
          break;
        }
        this.resolvedRightToRight = m;
      }
      i = this.endToStart;
      if (i != -1)
      {
        this.resolvedLeftToRight = i;
        paramInt = 1;
      }
      i = this.endToEnd;
      if (i != -1)
      {
        this.resolvedLeftToLeft = i;
        paramInt = 1;
      }
      i = this.goneStartMargin;
      if (i != -1) {
        this.resolveGoneRightMargin = i;
      }
      i = this.goneEndMargin;
      if (i != -1) {
        this.resolveGoneLeftMargin = i;
      }
      if (paramInt != 0) {
        this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
      }
      if ((this.isGuideline) && (this.orientation == 1))
      {
        float f = this.guidePercent;
        if (f != -1.0F)
        {
          this.resolvedGuidePercent = (1.0F - f);
          this.resolvedGuideBegin = -1;
          this.resolvedGuideEnd = -1;
        }
        else
        {
          paramInt = this.guideBegin;
          if (paramInt != -1)
          {
            this.resolvedGuideEnd = paramInt;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0F;
          }
          else
          {
            paramInt = this.guideEnd;
            if (paramInt != -1)
            {
              this.resolvedGuideBegin = paramInt;
              this.resolvedGuideEnd = -1;
              this.resolvedGuidePercent = -1.0F;
            }
          }
        }
      }
    }
    else
    {
      paramInt = this.startToEnd;
      if (paramInt != -1) {
        this.resolvedLeftToRight = paramInt;
      }
      paramInt = this.startToStart;
      if (paramInt != -1) {
        this.resolvedLeftToLeft = paramInt;
      }
      paramInt = this.endToStart;
      if (paramInt != -1) {
        this.resolvedRightToLeft = paramInt;
      }
      paramInt = this.endToEnd;
      if (paramInt != -1) {
        this.resolvedRightToRight = paramInt;
      }
      paramInt = this.goneStartMargin;
      if (paramInt != -1) {
        this.resolveGoneLeftMargin = paramInt;
      }
      paramInt = this.goneEndMargin;
      if (paramInt != -1) {
        this.resolveGoneRightMargin = paramInt;
      }
    }
    if ((this.endToStart == -1) && (this.endToEnd == -1) && (this.startToStart == -1) && (this.startToEnd == -1))
    {
      paramInt = this.rightToLeft;
      if (paramInt != -1)
      {
        this.resolvedRightToLeft = paramInt;
        if ((this.rightMargin <= 0) && (k > 0)) {
          this.rightMargin = k;
        }
      }
      else
      {
        paramInt = this.rightToRight;
        if (paramInt != -1)
        {
          this.resolvedRightToRight = paramInt;
          if ((this.rightMargin <= 0) && (k > 0)) {
            this.rightMargin = k;
          }
        }
      }
      paramInt = this.leftToLeft;
      if (paramInt != -1)
      {
        this.resolvedLeftToLeft = paramInt;
        if ((this.leftMargin <= 0) && (j > 0)) {
          this.leftMargin = j;
        }
      }
      else
      {
        paramInt = this.leftToRight;
        if (paramInt != -1)
        {
          this.resolvedLeftToRight = paramInt;
          if ((this.leftMargin <= 0) && (j > 0)) {
            this.leftMargin = j;
          }
        }
      }
    }
  }
  
  public void setWidgetDebugName(String paramString)
  {
    this.widget.setDebugName(paramString);
  }
  
  public void validate()
  {
    this.isGuideline = false;
    this.horizontalDimensionFixed = true;
    this.verticalDimensionFixed = true;
    if ((this.width == -2) && (this.constrainedWidth))
    {
      this.horizontalDimensionFixed = false;
      if (this.matchConstraintDefaultWidth == 0) {
        this.matchConstraintDefaultWidth = 1;
      }
    }
    if ((this.height == -2) && (this.constrainedHeight))
    {
      this.verticalDimensionFixed = false;
      if (this.matchConstraintDefaultHeight == 0) {
        this.matchConstraintDefaultHeight = 1;
      }
    }
    if ((this.width == 0) || (this.width == -1))
    {
      this.horizontalDimensionFixed = false;
      if ((this.width == 0) && (this.matchConstraintDefaultWidth == 1))
      {
        this.width = -2;
        this.constrainedWidth = true;
      }
    }
    if ((this.height == 0) || (this.height == -1))
    {
      this.verticalDimensionFixed = false;
      if ((this.height == 0) && (this.matchConstraintDefaultHeight == 1))
      {
        this.height = -2;
        this.constrainedHeight = true;
      }
    }
    if ((this.guidePercent != -1.0F) || (this.guideBegin != -1) || (this.guideEnd != -1))
    {
      this.isGuideline = true;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if (!(this.widget instanceof Guideline)) {
        this.widget = new Guideline();
      }
      ((Guideline)this.widget).setOrientation(this.orientation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */