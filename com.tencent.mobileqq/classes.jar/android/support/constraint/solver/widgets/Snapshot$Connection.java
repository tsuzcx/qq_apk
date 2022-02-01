package android.support.constraint.solver.widgets;

class Snapshot$Connection
{
  private ConstraintAnchor mAnchor;
  private int mCreator;
  private int mMargin;
  private ConstraintAnchor.Strength mStrengh;
  private ConstraintAnchor mTarget;
  
  public Snapshot$Connection(ConstraintAnchor paramConstraintAnchor)
  {
    this.mAnchor = paramConstraintAnchor;
    this.mTarget = paramConstraintAnchor.getTarget();
    this.mMargin = paramConstraintAnchor.getMargin();
    this.mStrengh = paramConstraintAnchor.getStrength();
    this.mCreator = paramConstraintAnchor.getConnectionCreator();
  }
  
  public void applyTo(ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.getAnchor(this.mAnchor.getType()).connect(this.mTarget, this.mMargin, this.mStrengh, this.mCreator);
  }
  
  public void updateFrom(ConstraintWidget paramConstraintWidget)
  {
    this.mAnchor = paramConstraintWidget.getAnchor(this.mAnchor.getType());
    paramConstraintWidget = this.mAnchor;
    if (paramConstraintWidget != null)
    {
      this.mTarget = paramConstraintWidget.getTarget();
      this.mMargin = this.mAnchor.getMargin();
      this.mStrengh = this.mAnchor.getStrength();
      this.mCreator = this.mAnchor.getConnectionCreator();
      return;
    }
    this.mTarget = null;
    this.mMargin = 0;
    this.mStrengh = ConstraintAnchor.Strength.STRONG;
    this.mCreator = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Snapshot.Connection
 * JD-Core Version:    0.7.0.1
 */