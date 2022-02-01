package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Helper;
import java.util.ArrayList;
import java.util.Iterator;

public class AlignHorizontallyReference
  extends HelperReference
{
  private float mBias = 0.5F;
  private Object mEndToEnd;
  private Object mEndToStart;
  private Object mStartToEnd;
  private Object mStartToStart;
  
  public AlignHorizontallyReference(State paramState)
  {
    super(paramState, State.Helper.ALIGN_VERTICALLY);
  }
  
  public void apply()
  {
    Iterator localIterator = this.mReferences.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      localObject1 = this.mState.constraints(localObject1);
      ((ConstraintReference)localObject1).clearHorizontal();
      Object localObject2 = this.mStartToStart;
      if (localObject2 != null)
      {
        ((ConstraintReference)localObject1).startToStart(localObject2);
      }
      else
      {
        localObject2 = this.mStartToEnd;
        if (localObject2 != null) {
          ((ConstraintReference)localObject1).startToEnd(localObject2);
        } else {
          ((ConstraintReference)localObject1).startToStart(State.PARENT);
        }
      }
      localObject2 = this.mEndToStart;
      if (localObject2 != null)
      {
        ((ConstraintReference)localObject1).endToStart(localObject2);
      }
      else
      {
        localObject2 = this.mEndToEnd;
        if (localObject2 != null) {
          ((ConstraintReference)localObject1).endToEnd(localObject2);
        } else {
          ((ConstraintReference)localObject1).endToEnd(State.PARENT);
        }
      }
      float f = this.mBias;
      if (f != 0.5F) {
        ((ConstraintReference)localObject1).horizontalBias(f);
      }
    }
  }
  
  public void bias(float paramFloat)
  {
    this.mBias = paramFloat;
  }
  
  public void endToEnd(Object paramObject)
  {
    this.mEndToEnd = paramObject;
  }
  
  public void endToStart(Object paramObject)
  {
    this.mEndToStart = paramObject;
  }
  
  public void startToEnd(Object paramObject)
  {
    this.mStartToEnd = paramObject;
  }
  
  public void startToStart(Object paramObject)
  {
    this.mStartToStart = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference
 * JD-Core Version:    0.7.0.1
 */