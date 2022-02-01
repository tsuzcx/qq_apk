package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.Guideline;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

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
  public float horizontalBias = 0.5F;
  public int horizontalChainStyle = 0;
  boolean horizontalDimensionFixed = true;
  public float horizontalWeight = 0.0F;
  boolean isGuideline = false;
  public int leftToLeft = -1;
  public int leftToRight = -1;
  public int matchConstraintDefaultHeight = 0;
  public int matchConstraintDefaultWidth = 0;
  public int matchConstraintMaxHeight = 0;
  public int matchConstraintMaxWidth = 0;
  public int matchConstraintMinHeight = 0;
  public int matchConstraintMinWidth = 0;
  boolean needsBaseline = false;
  public int orientation = -1;
  int resolveGoneLeftMargin = -1;
  int resolveGoneRightMargin = -1;
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
  public float verticalWeight = 0.0F;
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
      if (j == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf)
      {
        this.leftToLeft = paramContext.getResourceId(j, this.leftToLeft);
        if (this.leftToLeft == -1) {
          this.leftToLeft = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf)
      {
        this.leftToRight = paramContext.getResourceId(j, this.leftToRight);
        if (this.leftToRight == -1) {
          this.leftToRight = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf)
      {
        this.rightToLeft = paramContext.getResourceId(j, this.rightToLeft);
        if (this.rightToLeft == -1) {
          this.rightToLeft = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf)
      {
        this.rightToRight = paramContext.getResourceId(j, this.rightToRight);
        if (this.rightToRight == -1) {
          this.rightToRight = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf)
      {
        this.topToTop = paramContext.getResourceId(j, this.topToTop);
        if (this.topToTop == -1) {
          this.topToTop = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf)
      {
        this.topToBottom = paramContext.getResourceId(j, this.topToBottom);
        if (this.topToBottom == -1) {
          this.topToBottom = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf)
      {
        this.bottomToTop = paramContext.getResourceId(j, this.bottomToTop);
        if (this.bottomToTop == -1) {
          this.bottomToTop = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf)
      {
        this.bottomToBottom = paramContext.getResourceId(j, this.bottomToBottom);
        if (this.bottomToBottom == -1) {
          this.bottomToBottom = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf)
      {
        this.baselineToBaseline = paramContext.getResourceId(j, this.baselineToBaseline);
        if (this.baselineToBaseline == -1) {
          this.baselineToBaseline = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX)
      {
        this.editorAbsoluteX = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteX);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY)
      {
        this.editorAbsoluteY = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteY);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin)
      {
        this.guideBegin = paramContext.getDimensionPixelOffset(j, this.guideBegin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end)
      {
        this.guideEnd = paramContext.getDimensionPixelOffset(j, this.guideEnd);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent)
      {
        this.guidePercent = paramContext.getFloat(j, this.guidePercent);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_android_orientation)
      {
        this.orientation = paramContext.getInt(j, this.orientation);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf)
      {
        this.startToEnd = paramContext.getResourceId(j, this.startToEnd);
        if (this.startToEnd == -1) {
          this.startToEnd = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf)
      {
        this.startToStart = paramContext.getResourceId(j, this.startToStart);
        if (this.startToStart == -1) {
          this.startToStart = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf)
      {
        this.endToStart = paramContext.getResourceId(j, this.endToStart);
        if (this.endToStart == -1) {
          this.endToStart = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf)
      {
        this.endToEnd = paramContext.getResourceId(j, this.endToEnd);
        if (this.endToEnd == -1) {
          this.endToEnd = paramContext.getInt(j, -1);
        }
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft)
      {
        this.goneLeftMargin = paramContext.getDimensionPixelSize(j, this.goneLeftMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop)
      {
        this.goneTopMargin = paramContext.getDimensionPixelSize(j, this.goneTopMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight)
      {
        this.goneRightMargin = paramContext.getDimensionPixelSize(j, this.goneRightMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom)
      {
        this.goneBottomMargin = paramContext.getDimensionPixelSize(j, this.goneBottomMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart)
      {
        this.goneStartMargin = paramContext.getDimensionPixelSize(j, this.goneStartMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd)
      {
        this.goneEndMargin = paramContext.getDimensionPixelSize(j, this.goneEndMargin);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias)
      {
        this.horizontalBias = paramContext.getFloat(j, this.horizontalBias);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias)
      {
        this.verticalBias = paramContext.getFloat(j, this.verticalBias);
      }
      else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio)
      {
        this.dimensionRatio = paramContext.getString(j);
        this.dimensionRatioValue = (0.0F / 0.0F);
        this.dimensionRatioSide = -1;
        paramAttributeSet = this.dimensionRatio;
        if (paramAttributeSet == null) {
          break label1792;
        }
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
            break label1792;
          }
        }
      }
      try
      {
        float f1 = Float.parseFloat(paramAttributeSet);
        float f2 = Float.parseFloat(str);
        if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label1792;
        }
        if (this.dimensionRatioSide == 1) {
          this.dimensionRatioValue = Math.abs(f2 / f1);
        } else {
          this.dimensionRatioValue = Math.abs(f1 / f2);
        }
      }
      catch (NumberFormatException paramAttributeSet)
      {
        label1792:
        break label1792;
      }
      paramAttributeSet = this.dimensionRatio.substring(j);
      if (paramAttributeSet.length() > 0)
      {
        this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
        break label1792;
        if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
          this.horizontalWeight = paramContext.getFloat(j, 0.0F);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight) {
          this.verticalWeight = paramContext.getFloat(j, 0.0F);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
          this.horizontalChainStyle = paramContext.getInt(j, 0);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
          this.verticalChainStyle = paramContext.getInt(j, 0);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default) {
          this.matchConstraintDefaultWidth = paramContext.getInt(j, 0);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default) {
          this.matchConstraintDefaultHeight = paramContext.getInt(j, 0);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min) {
          this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMinWidth);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max) {
          this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxWidth);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min) {
          this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMinHeight);
        } else if (j == R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max) {
          this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxHeight);
        } else if ((j != R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator) && (j != R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator) && (j != R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator) && (j != R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator)) {
          j = R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator;
        }
      }
      i += 1;
    }
    paramContext.recycle();
    validate();
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
    this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
    this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
    this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
    this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
    this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
    this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
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
    this.widget = paramLayoutParams.widget;
  }
  
  public ConstraintLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  @TargetApi(17)
  public void resolveLayoutDirection(int paramInt)
  {
    super.resolveLayoutDirection(paramInt);
    this.resolvedRightToLeft = -1;
    this.resolvedRightToRight = -1;
    this.resolvedLeftToLeft = -1;
    this.resolvedLeftToRight = -1;
    this.resolveGoneLeftMargin = -1;
    this.resolveGoneRightMargin = -1;
    this.resolveGoneLeftMargin = this.goneLeftMargin;
    this.resolveGoneRightMargin = this.goneRightMargin;
    this.resolvedHorizontalBias = this.horizontalBias;
    int i = getLayoutDirection();
    paramInt = 1;
    if (1 != i) {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      paramInt = this.startToEnd;
      if (paramInt != -1)
      {
        this.resolvedRightToLeft = paramInt;
      }
      else
      {
        paramInt = this.startToStart;
        if (paramInt != -1) {
          this.resolvedRightToRight = paramInt;
        }
      }
      paramInt = this.endToStart;
      if (paramInt != -1) {
        this.resolvedLeftToRight = paramInt;
      }
      paramInt = this.endToEnd;
      if (paramInt != -1) {
        this.resolvedLeftToLeft = paramInt;
      }
      paramInt = this.goneStartMargin;
      if (paramInt != -1) {
        this.resolveGoneRightMargin = paramInt;
      }
      paramInt = this.goneEndMargin;
      if (paramInt != -1) {
        this.resolveGoneLeftMargin = paramInt;
      }
      this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
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
    if ((this.endToStart == -1) && (this.endToEnd == -1))
    {
      paramInt = this.rightToLeft;
      if (paramInt != -1)
      {
        this.resolvedRightToLeft = paramInt;
      }
      else
      {
        paramInt = this.rightToRight;
        if (paramInt != -1) {
          this.resolvedRightToRight = paramInt;
        }
      }
    }
    if ((this.startToStart == -1) && (this.startToEnd == -1))
    {
      paramInt = this.leftToLeft;
      if (paramInt != -1)
      {
        this.resolvedLeftToLeft = paramInt;
        return;
      }
      paramInt = this.leftToRight;
      if (paramInt != -1) {
        this.resolvedLeftToRight = paramInt;
      }
    }
  }
  
  public void validate()
  {
    this.isGuideline = false;
    this.horizontalDimensionFixed = true;
    this.verticalDimensionFixed = true;
    if ((this.width == 0) || (this.width == -1)) {
      this.horizontalDimensionFixed = false;
    }
    if ((this.height == 0) || (this.height == -1)) {
      this.verticalDimensionFixed = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */