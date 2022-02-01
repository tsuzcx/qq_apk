package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract interface Reference
{
  public abstract void apply();
  
  public abstract ConstraintWidget getConstraintWidget();
  
  public abstract Object getKey();
  
  public abstract void setConstraintWidget(ConstraintWidget paramConstraintWidget);
  
  public abstract void setKey(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.Reference
 * JD-Core Version:    0.7.0.1
 */