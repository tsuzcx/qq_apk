package androidx.constraintlayout.widget;

import android.os.Build.VERSION;
import java.util.HashMap;

public class ConstraintSet$Constraint
{
  public final ConstraintSet.Layout layout = new ConstraintSet.Layout();
  public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap();
  int mViewId;
  public final ConstraintSet.Motion motion = new ConstraintSet.Motion();
  public final ConstraintSet.PropertySet propertySet = new ConstraintSet.PropertySet();
  public final ConstraintSet.Transform transform = new ConstraintSet.Transform();
  
  private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    this.mViewId = paramInt;
    this.layout.leftToLeft = paramLayoutParams.leftToLeft;
    this.layout.leftToRight = paramLayoutParams.leftToRight;
    this.layout.rightToLeft = paramLayoutParams.rightToLeft;
    this.layout.rightToRight = paramLayoutParams.rightToRight;
    this.layout.topToTop = paramLayoutParams.topToTop;
    this.layout.topToBottom = paramLayoutParams.topToBottom;
    this.layout.bottomToTop = paramLayoutParams.bottomToTop;
    this.layout.bottomToBottom = paramLayoutParams.bottomToBottom;
    this.layout.baselineToBaseline = paramLayoutParams.baselineToBaseline;
    this.layout.startToEnd = paramLayoutParams.startToEnd;
    this.layout.startToStart = paramLayoutParams.startToStart;
    this.layout.endToStart = paramLayoutParams.endToStart;
    this.layout.endToEnd = paramLayoutParams.endToEnd;
    this.layout.horizontalBias = paramLayoutParams.horizontalBias;
    this.layout.verticalBias = paramLayoutParams.verticalBias;
    this.layout.dimensionRatio = paramLayoutParams.dimensionRatio;
    this.layout.circleConstraint = paramLayoutParams.circleConstraint;
    this.layout.circleRadius = paramLayoutParams.circleRadius;
    this.layout.circleAngle = paramLayoutParams.circleAngle;
    this.layout.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
    this.layout.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
    this.layout.orientation = paramLayoutParams.orientation;
    this.layout.guidePercent = paramLayoutParams.guidePercent;
    this.layout.guideBegin = paramLayoutParams.guideBegin;
    this.layout.guideEnd = paramLayoutParams.guideEnd;
    this.layout.mWidth = paramLayoutParams.width;
    this.layout.mHeight = paramLayoutParams.height;
    this.layout.leftMargin = paramLayoutParams.leftMargin;
    this.layout.rightMargin = paramLayoutParams.rightMargin;
    this.layout.topMargin = paramLayoutParams.topMargin;
    this.layout.bottomMargin = paramLayoutParams.bottomMargin;
    this.layout.verticalWeight = paramLayoutParams.verticalWeight;
    this.layout.horizontalWeight = paramLayoutParams.horizontalWeight;
    this.layout.verticalChainStyle = paramLayoutParams.verticalChainStyle;
    this.layout.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
    this.layout.constrainedWidth = paramLayoutParams.constrainedWidth;
    this.layout.constrainedHeight = paramLayoutParams.constrainedHeight;
    this.layout.widthDefault = paramLayoutParams.matchConstraintDefaultWidth;
    this.layout.heightDefault = paramLayoutParams.matchConstraintDefaultHeight;
    this.layout.widthMax = paramLayoutParams.matchConstraintMaxWidth;
    this.layout.heightMax = paramLayoutParams.matchConstraintMaxHeight;
    this.layout.widthMin = paramLayoutParams.matchConstraintMinWidth;
    this.layout.heightMin = paramLayoutParams.matchConstraintMinHeight;
    this.layout.widthPercent = paramLayoutParams.matchConstraintPercentWidth;
    this.layout.heightPercent = paramLayoutParams.matchConstraintPercentHeight;
    this.layout.mConstraintTag = paramLayoutParams.constraintTag;
    this.layout.goneTopMargin = paramLayoutParams.goneTopMargin;
    this.layout.goneBottomMargin = paramLayoutParams.goneBottomMargin;
    this.layout.goneLeftMargin = paramLayoutParams.goneLeftMargin;
    this.layout.goneRightMargin = paramLayoutParams.goneRightMargin;
    this.layout.goneStartMargin = paramLayoutParams.goneStartMargin;
    this.layout.goneEndMargin = paramLayoutParams.goneEndMargin;
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.layout.endMargin = paramLayoutParams.getMarginEnd();
      this.layout.startMargin = paramLayoutParams.getMarginStart();
    }
  }
  
  private void fillFromConstraints(int paramInt, Constraints.LayoutParams paramLayoutParams)
  {
    fillFrom(paramInt, paramLayoutParams);
    this.propertySet.alpha = paramLayoutParams.alpha;
    this.transform.rotation = paramLayoutParams.rotation;
    this.transform.rotationX = paramLayoutParams.rotationX;
    this.transform.rotationY = paramLayoutParams.rotationY;
    this.transform.scaleX = paramLayoutParams.scaleX;
    this.transform.scaleY = paramLayoutParams.scaleY;
    this.transform.transformPivotX = paramLayoutParams.transformPivotX;
    this.transform.transformPivotY = paramLayoutParams.transformPivotY;
    this.transform.translationX = paramLayoutParams.translationX;
    this.transform.translationY = paramLayoutParams.translationY;
    this.transform.translationZ = paramLayoutParams.translationZ;
    this.transform.elevation = paramLayoutParams.elevation;
    this.transform.applyElevation = paramLayoutParams.applyElevation;
  }
  
  private void fillFromConstraints(ConstraintHelper paramConstraintHelper, int paramInt, Constraints.LayoutParams paramLayoutParams)
  {
    fillFromConstraints(paramInt, paramLayoutParams);
    if ((paramConstraintHelper instanceof Barrier))
    {
      paramLayoutParams = this.layout;
      paramLayoutParams.mHelperType = 1;
      paramConstraintHelper = (Barrier)paramConstraintHelper;
      paramLayoutParams.mBarrierDirection = paramConstraintHelper.getType();
      this.layout.mReferenceIds = paramConstraintHelper.getReferencedIds();
      this.layout.mBarrierMargin = paramConstraintHelper.getMargin();
    }
  }
  
  private ConstraintAttribute get(String paramString, ConstraintAttribute.AttributeType paramAttributeType)
  {
    if (this.mCustomConstraints.containsKey(paramString))
    {
      paramString = (ConstraintAttribute)this.mCustomConstraints.get(paramString);
      if (paramString.getType() == paramAttributeType) {
        return paramString;
      }
      paramAttributeType = new StringBuilder();
      paramAttributeType.append("ConstraintAttribute is already a ");
      paramAttributeType.append(paramString.getType().name());
      throw new IllegalArgumentException(paramAttributeType.toString());
    }
    paramAttributeType = new ConstraintAttribute(paramString, paramAttributeType);
    this.mCustomConstraints.put(paramString, paramAttributeType);
    return paramAttributeType;
  }
  
  private void setColorValue(String paramString, int paramInt)
  {
    get(paramString, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(paramInt);
  }
  
  private void setFloatValue(String paramString, float paramFloat)
  {
    get(paramString, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(paramFloat);
  }
  
  private void setIntValue(String paramString, int paramInt)
  {
    get(paramString, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(paramInt);
  }
  
  private void setStringValue(String paramString1, String paramString2)
  {
    get(paramString1, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(paramString2);
  }
  
  public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.leftToLeft = this.layout.leftToLeft;
    paramLayoutParams.leftToRight = this.layout.leftToRight;
    paramLayoutParams.rightToLeft = this.layout.rightToLeft;
    paramLayoutParams.rightToRight = this.layout.rightToRight;
    paramLayoutParams.topToTop = this.layout.topToTop;
    paramLayoutParams.topToBottom = this.layout.topToBottom;
    paramLayoutParams.bottomToTop = this.layout.bottomToTop;
    paramLayoutParams.bottomToBottom = this.layout.bottomToBottom;
    paramLayoutParams.baselineToBaseline = this.layout.baselineToBaseline;
    paramLayoutParams.startToEnd = this.layout.startToEnd;
    paramLayoutParams.startToStart = this.layout.startToStart;
    paramLayoutParams.endToStart = this.layout.endToStart;
    paramLayoutParams.endToEnd = this.layout.endToEnd;
    paramLayoutParams.leftMargin = this.layout.leftMargin;
    paramLayoutParams.rightMargin = this.layout.rightMargin;
    paramLayoutParams.topMargin = this.layout.topMargin;
    paramLayoutParams.bottomMargin = this.layout.bottomMargin;
    paramLayoutParams.goneStartMargin = this.layout.goneStartMargin;
    paramLayoutParams.goneEndMargin = this.layout.goneEndMargin;
    paramLayoutParams.goneTopMargin = this.layout.goneTopMargin;
    paramLayoutParams.goneBottomMargin = this.layout.goneBottomMargin;
    paramLayoutParams.horizontalBias = this.layout.horizontalBias;
    paramLayoutParams.verticalBias = this.layout.verticalBias;
    paramLayoutParams.circleConstraint = this.layout.circleConstraint;
    paramLayoutParams.circleRadius = this.layout.circleRadius;
    paramLayoutParams.circleAngle = this.layout.circleAngle;
    paramLayoutParams.dimensionRatio = this.layout.dimensionRatio;
    paramLayoutParams.editorAbsoluteX = this.layout.editorAbsoluteX;
    paramLayoutParams.editorAbsoluteY = this.layout.editorAbsoluteY;
    paramLayoutParams.verticalWeight = this.layout.verticalWeight;
    paramLayoutParams.horizontalWeight = this.layout.horizontalWeight;
    paramLayoutParams.verticalChainStyle = this.layout.verticalChainStyle;
    paramLayoutParams.horizontalChainStyle = this.layout.horizontalChainStyle;
    paramLayoutParams.constrainedWidth = this.layout.constrainedWidth;
    paramLayoutParams.constrainedHeight = this.layout.constrainedHeight;
    paramLayoutParams.matchConstraintDefaultWidth = this.layout.widthDefault;
    paramLayoutParams.matchConstraintDefaultHeight = this.layout.heightDefault;
    paramLayoutParams.matchConstraintMaxWidth = this.layout.widthMax;
    paramLayoutParams.matchConstraintMaxHeight = this.layout.heightMax;
    paramLayoutParams.matchConstraintMinWidth = this.layout.widthMin;
    paramLayoutParams.matchConstraintMinHeight = this.layout.heightMin;
    paramLayoutParams.matchConstraintPercentWidth = this.layout.widthPercent;
    paramLayoutParams.matchConstraintPercentHeight = this.layout.heightPercent;
    paramLayoutParams.orientation = this.layout.orientation;
    paramLayoutParams.guidePercent = this.layout.guidePercent;
    paramLayoutParams.guideBegin = this.layout.guideBegin;
    paramLayoutParams.guideEnd = this.layout.guideEnd;
    paramLayoutParams.width = this.layout.mWidth;
    paramLayoutParams.height = this.layout.mHeight;
    if (this.layout.mConstraintTag != null) {
      paramLayoutParams.constraintTag = this.layout.mConstraintTag;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.setMarginStart(this.layout.startMargin);
      paramLayoutParams.setMarginEnd(this.layout.endMargin);
    }
    paramLayoutParams.validate();
  }
  
  public Constraint clone()
  {
    Constraint localConstraint = new Constraint();
    localConstraint.layout.copyFrom(this.layout);
    localConstraint.motion.copyFrom(this.motion);
    localConstraint.propertySet.copyFrom(this.propertySet);
    localConstraint.transform.copyFrom(this.transform);
    localConstraint.mViewId = this.mViewId;
    return localConstraint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet.Constraint
 * JD-Core Version:    0.7.0.1
 */