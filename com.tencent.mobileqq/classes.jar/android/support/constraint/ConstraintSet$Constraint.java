package android.support.constraint;

import android.os.Build.VERSION;

class ConstraintSet$Constraint
{
  static final int UNSET = -1;
  public float alpha = 1.0F;
  public boolean applyElevation = false;
  public int baselineToBaseline = -1;
  public int bottomMargin = -1;
  public int bottomToBottom = -1;
  public int bottomToTop = -1;
  public String dimensionRatio = null;
  public int editorAbsoluteX = -1;
  public int editorAbsoluteY = -1;
  public float elevation = 0.0F;
  public int endMargin = -1;
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
  public int heightDefault = -1;
  public int heightMax = -1;
  public int heightMin = -1;
  public float horizontalBias = 0.5F;
  public int horizontalChainStyle = 0;
  public float horizontalWeight = 0.0F;
  public int leftMargin = -1;
  public int leftToLeft = -1;
  public int leftToRight = -1;
  public int mHeight;
  boolean mIsGuideline = false;
  int mViewId;
  public int mWidth;
  public int orientation = -1;
  public int rightMargin = -1;
  public int rightToLeft = -1;
  public int rightToRight = -1;
  public float rotationX = 0.0F;
  public float rotationY = 0.0F;
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
  public int startMargin = -1;
  public int startToEnd = -1;
  public int startToStart = -1;
  public int topMargin = -1;
  public int topToBottom = -1;
  public int topToTop = -1;
  public float transformPivotX = 0.0F;
  public float transformPivotY = 0.0F;
  public float translationX = 0.0F;
  public float translationY = 0.0F;
  public float translationZ = 0.0F;
  public float verticalBias = 0.5F;
  public int verticalChainStyle = 0;
  public float verticalWeight = 0.0F;
  public int visibility = 0;
  public int widthDefault = -1;
  public int widthMax = -1;
  public int widthMin = -1;
  
  private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    this.mViewId = paramInt;
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
    this.horizontalBias = paramLayoutParams.horizontalBias;
    this.verticalBias = paramLayoutParams.verticalBias;
    this.dimensionRatio = paramLayoutParams.dimensionRatio;
    this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
    this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
    this.orientation = paramLayoutParams.orientation;
    this.guidePercent = paramLayoutParams.guidePercent;
    this.guideBegin = paramLayoutParams.guideBegin;
    this.guideEnd = paramLayoutParams.guideEnd;
    this.mWidth = paramLayoutParams.width;
    this.mHeight = paramLayoutParams.height;
    this.leftMargin = paramLayoutParams.leftMargin;
    this.rightMargin = paramLayoutParams.rightMargin;
    this.topMargin = paramLayoutParams.topMargin;
    this.bottomMargin = paramLayoutParams.bottomMargin;
    this.verticalWeight = paramLayoutParams.verticalWeight;
    this.horizontalWeight = paramLayoutParams.horizontalWeight;
    this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
    this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
    this.widthDefault = paramLayoutParams.matchConstraintDefaultWidth;
    this.heightDefault = paramLayoutParams.matchConstraintDefaultHeight;
    this.widthMax = paramLayoutParams.matchConstraintMaxWidth;
    this.heightMax = paramLayoutParams.matchConstraintMaxHeight;
    this.widthMin = paramLayoutParams.matchConstraintMinWidth;
    this.heightMin = paramLayoutParams.matchConstraintMinHeight;
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.endMargin = paramLayoutParams.getMarginEnd();
      this.startMargin = paramLayoutParams.getMarginStart();
    }
  }
  
  public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.leftToLeft = this.leftToLeft;
    paramLayoutParams.leftToRight = this.leftToRight;
    paramLayoutParams.rightToLeft = this.rightToLeft;
    paramLayoutParams.rightToRight = this.rightToRight;
    paramLayoutParams.topToTop = this.topToTop;
    paramLayoutParams.topToBottom = this.topToBottom;
    paramLayoutParams.bottomToTop = this.bottomToTop;
    paramLayoutParams.bottomToBottom = this.bottomToBottom;
    paramLayoutParams.baselineToBaseline = this.baselineToBaseline;
    paramLayoutParams.startToEnd = this.startToEnd;
    paramLayoutParams.startToStart = this.startToStart;
    paramLayoutParams.endToStart = this.endToStart;
    paramLayoutParams.endToEnd = this.endToEnd;
    paramLayoutParams.leftMargin = this.leftMargin;
    paramLayoutParams.rightMargin = this.rightMargin;
    paramLayoutParams.topMargin = this.topMargin;
    paramLayoutParams.bottomMargin = this.bottomMargin;
    paramLayoutParams.goneStartMargin = this.goneStartMargin;
    paramLayoutParams.goneEndMargin = this.goneEndMargin;
    paramLayoutParams.horizontalBias = this.horizontalBias;
    paramLayoutParams.verticalBias = this.verticalBias;
    paramLayoutParams.dimensionRatio = this.dimensionRatio;
    paramLayoutParams.editorAbsoluteX = this.editorAbsoluteX;
    paramLayoutParams.editorAbsoluteY = this.editorAbsoluteY;
    paramLayoutParams.verticalWeight = this.verticalWeight;
    paramLayoutParams.horizontalWeight = this.horizontalWeight;
    paramLayoutParams.verticalChainStyle = this.verticalChainStyle;
    paramLayoutParams.horizontalChainStyle = this.horizontalChainStyle;
    paramLayoutParams.matchConstraintDefaultWidth = this.widthDefault;
    paramLayoutParams.matchConstraintDefaultHeight = this.heightDefault;
    paramLayoutParams.matchConstraintMaxWidth = this.widthMax;
    paramLayoutParams.matchConstraintMaxHeight = this.heightMax;
    paramLayoutParams.matchConstraintMinWidth = this.widthMin;
    paramLayoutParams.matchConstraintMinHeight = this.heightMin;
    paramLayoutParams.orientation = this.orientation;
    paramLayoutParams.guidePercent = this.guidePercent;
    paramLayoutParams.guideBegin = this.guideBegin;
    paramLayoutParams.guideEnd = this.guideEnd;
    paramLayoutParams.width = this.mWidth;
    paramLayoutParams.height = this.mHeight;
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.setMarginStart(this.startMargin);
      paramLayoutParams.setMarginEnd(this.endMargin);
    }
    paramLayoutParams.validate();
  }
  
  public Constraint clone()
  {
    Constraint localConstraint = new Constraint();
    localConstraint.mIsGuideline = this.mIsGuideline;
    localConstraint.mWidth = this.mWidth;
    localConstraint.mHeight = this.mHeight;
    localConstraint.guideBegin = this.guideBegin;
    localConstraint.guideEnd = this.guideEnd;
    localConstraint.guidePercent = this.guidePercent;
    localConstraint.leftToLeft = this.leftToLeft;
    localConstraint.leftToRight = this.leftToRight;
    localConstraint.rightToLeft = this.rightToLeft;
    localConstraint.rightToRight = this.rightToRight;
    localConstraint.topToTop = this.topToTop;
    localConstraint.topToBottom = this.topToBottom;
    localConstraint.bottomToTop = this.bottomToTop;
    localConstraint.bottomToBottom = this.bottomToBottom;
    localConstraint.baselineToBaseline = this.baselineToBaseline;
    localConstraint.startToEnd = this.startToEnd;
    localConstraint.startToStart = this.startToStart;
    localConstraint.endToStart = this.endToStart;
    localConstraint.endToEnd = this.endToEnd;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.verticalBias = this.verticalBias;
    localConstraint.dimensionRatio = this.dimensionRatio;
    localConstraint.editorAbsoluteX = this.editorAbsoluteX;
    localConstraint.editorAbsoluteY = this.editorAbsoluteY;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.horizontalBias = this.horizontalBias;
    localConstraint.orientation = this.orientation;
    localConstraint.leftMargin = this.leftMargin;
    localConstraint.rightMargin = this.rightMargin;
    localConstraint.topMargin = this.topMargin;
    localConstraint.bottomMargin = this.bottomMargin;
    localConstraint.endMargin = this.endMargin;
    localConstraint.startMargin = this.startMargin;
    localConstraint.visibility = this.visibility;
    localConstraint.goneLeftMargin = this.goneLeftMargin;
    localConstraint.goneTopMargin = this.goneTopMargin;
    localConstraint.goneRightMargin = this.goneRightMargin;
    localConstraint.goneBottomMargin = this.goneBottomMargin;
    localConstraint.goneEndMargin = this.goneEndMargin;
    localConstraint.goneStartMargin = this.goneStartMargin;
    localConstraint.verticalWeight = this.verticalWeight;
    localConstraint.horizontalWeight = this.horizontalWeight;
    localConstraint.horizontalChainStyle = this.horizontalChainStyle;
    localConstraint.verticalChainStyle = this.verticalChainStyle;
    localConstraint.alpha = this.alpha;
    localConstraint.applyElevation = this.applyElevation;
    localConstraint.elevation = this.elevation;
    localConstraint.rotationX = this.rotationX;
    localConstraint.rotationY = this.rotationY;
    localConstraint.scaleX = this.scaleX;
    localConstraint.scaleY = this.scaleY;
    localConstraint.transformPivotX = this.transformPivotX;
    localConstraint.transformPivotY = this.transformPivotY;
    localConstraint.translationX = this.translationX;
    localConstraint.translationY = this.translationY;
    localConstraint.translationZ = this.translationZ;
    localConstraint.widthDefault = this.widthDefault;
    localConstraint.heightDefault = this.heightDefault;
    localConstraint.widthMax = this.widthMax;
    localConstraint.heightMax = this.heightMax;
    localConstraint.widthMin = this.widthMin;
    localConstraint.heightMin = this.heightMin;
    return localConstraint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintSet.Constraint
 * JD-Core Version:    0.7.0.1
 */