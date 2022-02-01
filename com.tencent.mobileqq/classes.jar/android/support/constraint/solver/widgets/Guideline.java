package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class Guideline
  extends ConstraintWidget
{
  public static final int HORIZONTAL = 0;
  public static final int RELATIVE_BEGIN = 1;
  public static final int RELATIVE_END = 2;
  public static final int RELATIVE_PERCENT = 0;
  public static final int RELATIVE_UNKNWON = -1;
  public static final int VERTICAL = 1;
  private ConstraintAnchor mAnchor = this.mTop;
  private Rectangle mHead = new Rectangle();
  private int mHeadSize = 8;
  private boolean mIsPositionRelaxed = false;
  private int mMinimumPosition = 0;
  private int mOrientation = 0;
  protected int mRelativeBegin = -1;
  protected int mRelativeEnd = -1;
  protected float mRelativePercent = -1.0F;
  
  public Guideline()
  {
    this.mAnchors.clear();
    this.mAnchors.add(this.mAnchor);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)getParent();
    if (localConstraintWidgetContainer == null) {
      return;
    }
    ConstraintAnchor localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
    if (this.mOrientation == 0)
    {
      localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
      localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
    }
    if (this.mRelativeBegin != -1)
    {
      paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), this.mRelativeBegin, false));
      return;
    }
    if (this.mRelativeEnd != -1)
    {
      paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor2), -this.mRelativeEnd, false));
      return;
    }
    if (this.mRelativePercent != -1.0F) {
      paramLinearSystem.addConstraint(LinearSystem.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(this.mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), paramLinearSystem.createObjectVariable(localConstraintAnchor2), this.mRelativePercent, this.mIsPositionRelaxed));
    }
  }
  
  public void cyclePosition()
  {
    if (this.mRelativeBegin != -1)
    {
      inferRelativePercentPosition();
      return;
    }
    if (this.mRelativePercent != -1.0F)
    {
      inferRelativeEndPosition();
      return;
    }
    if (this.mRelativeEnd != -1) {
      inferRelativeBeginPosition();
    }
  }
  
  public ConstraintAnchor getAnchor()
  {
    return this.mAnchor;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    int i = Guideline.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (((i == 3) || (i == 4)) && (this.mOrientation == 0)) {
        return this.mAnchor;
      }
    }
    else if (this.mOrientation == 1) {
      return this.mAnchor;
    }
    return null;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public Rectangle getHead()
  {
    Rectangle localRectangle = this.mHead;
    int i = getDrawX();
    int j = this.mHeadSize;
    int k = getDrawY();
    int m = this.mHeadSize;
    localRectangle.setBounds(i - j, k - m * 2, m * 2, m * 2);
    if (getOrientation() == 0)
    {
      localRectangle = this.mHead;
      i = getDrawX();
      j = this.mHeadSize;
      k = getDrawY();
      m = this.mHeadSize;
      localRectangle.setBounds(i - j * 2, k - m, m * 2, m * 2);
    }
    return this.mHead;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getRelativeBegin()
  {
    return this.mRelativeBegin;
  }
  
  public int getRelativeBehaviour()
  {
    if (this.mRelativePercent != -1.0F) {
      return 0;
    }
    if (this.mRelativeBegin != -1) {
      return 1;
    }
    if (this.mRelativeEnd != -1) {
      return 2;
    }
    return -1;
  }
  
  public int getRelativeEnd()
  {
    return this.mRelativeEnd;
  }
  
  public float getRelativePercent()
  {
    return this.mRelativePercent;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  void inferRelativeBeginPosition()
  {
    int i = getX();
    if (this.mOrientation == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void inferRelativeEndPosition()
  {
    int i = getParent().getWidth() - getX();
    if (this.mOrientation == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  void inferRelativePercentPosition()
  {
    float f = getX() / getParent().getWidth();
    if (this.mOrientation == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      paramInt1 -= this.mOffsetX;
      if (this.mRelativeBegin != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getWidth() - paramInt1);
        return;
      }
      if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getWidth());
      }
    }
    else
    {
      paramInt1 = paramInt2 - this.mOffsetY;
      if (this.mRelativeBegin != -1)
      {
        setGuideBegin(paramInt1);
        return;
      }
      if (this.mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getHeight() - paramInt1);
        return;
      }
      if (this.mRelativePercent != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getHeight());
      }
    }
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = paramInt;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      this.mRelativePercent = -1.0F;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.mRelativePercent = paramFloat;
      this.mRelativeBegin = -1;
      this.mRelativeEnd = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    this.mMinimumPosition = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation == paramInt) {
      return;
    }
    this.mOrientation = paramInt;
    this.mAnchors.clear();
    if (this.mOrientation == 1) {
      this.mAnchor = this.mLeft;
    } else {
      this.mAnchor = this.mTop;
    }
    this.mAnchors.add(this.mAnchor);
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (this.mIsPositionRelaxed == paramBoolean) {
      return;
    }
    this.mIsPositionRelaxed = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (getParent() == null) {
      return;
    }
    paramInt = paramLinearSystem.getObjectVariableValue(this.mAnchor);
    if (this.mOrientation == 1)
    {
      setX(paramInt);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    }
    setX(0);
    setY(paramInt);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Guideline
 * JD-Core Version:    0.7.0.1
 */