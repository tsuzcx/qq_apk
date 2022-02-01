package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Direction;
import androidx.constraintlayout.solver.state.State.Helper;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

public class BarrierReference
  extends HelperReference
{
  private Barrier mBarrierWidget;
  private State.Direction mDirection;
  private int mMargin;
  
  public BarrierReference(State paramState)
  {
    super(paramState, State.Helper.BARRIER);
  }
  
  public void apply()
  {
    getHelperWidget();
    int k = BarrierReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()];
    int j = 0;
    int i = j;
    switch (k)
    {
    default: 
      i = j;
      break;
    case 6: 
      i = 3;
      break;
    case 5: 
      i = 2;
      break;
    case 3: 
    case 4: 
      i = 1;
    }
    this.mBarrierWidget.setBarrierType(i);
    this.mBarrierWidget.setMargin(this.mMargin);
  }
  
  public HelperWidget getHelperWidget()
  {
    if (this.mBarrierWidget == null) {
      this.mBarrierWidget = new Barrier();
    }
    return this.mBarrierWidget;
  }
  
  public void margin(int paramInt)
  {
    this.mMargin = paramInt;
  }
  
  public void margin(Object paramObject)
  {
    margin(this.mState.convertDimension(paramObject));
  }
  
  public void setBarrierDirection(State.Direction paramDirection)
  {
    this.mDirection = paramDirection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.BarrierReference
 * JD-Core Version:    0.7.0.1
 */