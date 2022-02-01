package android.support.constraint.solver.widgets;

import java.util.ArrayList;

public class Snapshot
{
  private ArrayList<Snapshot.Connection> mConnections = new ArrayList();
  private int mHeight;
  private int mWidth;
  private int mX;
  private int mY;
  
  public Snapshot(ConstraintWidget paramConstraintWidget)
  {
    this.mX = paramConstraintWidget.getX();
    this.mY = paramConstraintWidget.getY();
    this.mWidth = paramConstraintWidget.getWidth();
    this.mHeight = paramConstraintWidget.getHeight();
    paramConstraintWidget = paramConstraintWidget.getAnchors();
    int j = paramConstraintWidget.size();
    int i = 0;
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramConstraintWidget.get(i);
      this.mConnections.add(new Snapshot.Connection(localConstraintAnchor));
      i += 1;
    }
  }
  
  public void applyTo(ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.setX(this.mX);
    paramConstraintWidget.setY(this.mY);
    paramConstraintWidget.setWidth(this.mWidth);
    paramConstraintWidget.setHeight(this.mHeight);
    int j = this.mConnections.size();
    int i = 0;
    while (i < j)
    {
      ((Snapshot.Connection)this.mConnections.get(i)).applyTo(paramConstraintWidget);
      i += 1;
    }
  }
  
  public void updateFrom(ConstraintWidget paramConstraintWidget)
  {
    this.mX = paramConstraintWidget.getX();
    this.mY = paramConstraintWidget.getY();
    this.mWidth = paramConstraintWidget.getWidth();
    this.mHeight = paramConstraintWidget.getHeight();
    int j = this.mConnections.size();
    int i = 0;
    while (i < j)
    {
      ((Snapshot.Connection)this.mConnections.get(i)).updateFrom(paramConstraintWidget);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.Snapshot
 * JD-Core Version:    0.7.0.1
 */