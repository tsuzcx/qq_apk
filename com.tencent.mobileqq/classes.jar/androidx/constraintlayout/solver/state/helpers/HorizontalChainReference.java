package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Helper;
import java.util.ArrayList;
import java.util.Iterator;

public class HorizontalChainReference
  extends ChainReference
{
  private Object mEndToEnd;
  private Object mEndToStart;
  private Object mStartToEnd;
  private Object mStartToStart;
  
  public HorizontalChainReference(State paramState)
  {
    super(paramState, State.Helper.HORIZONTAL_CHAIN);
  }
  
  public void apply()
  {
    Object localObject1 = this.mReferences.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      this.mState.constraints(localObject2).clearHorizontal();
    }
    Iterator localIterator = this.mReferences.iterator();
    localObject1 = null;
    Object localObject3;
    Object localObject4;
    for (Object localObject2 = null; localIterator.hasNext(); localObject2 = localObject4)
    {
      localObject3 = localIterator.next();
      localObject3 = this.mState.constraints(localObject3);
      localObject4 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.mStartToStart;
        if (localObject2 != null)
        {
          ((ConstraintReference)localObject3).startToStart(localObject2);
        }
        else
        {
          localObject2 = this.mStartToEnd;
          if (localObject2 != null) {
            ((ConstraintReference)localObject3).startToEnd(localObject2);
          } else {
            ((ConstraintReference)localObject3).startToStart(State.PARENT);
          }
        }
        localObject4 = localObject3;
      }
      if (localObject1 != null)
      {
        ((ConstraintReference)localObject1).endToStart(((ConstraintReference)localObject3).getKey());
        ((ConstraintReference)localObject3).startToEnd(((ConstraintReference)localObject1).getKey());
      }
      localObject1 = localObject3;
    }
    if (localObject1 != null)
    {
      localObject3 = this.mEndToStart;
      if (localObject3 != null)
      {
        ((ConstraintReference)localObject1).endToStart(localObject3);
      }
      else
      {
        localObject3 = this.mEndToEnd;
        if (localObject3 != null) {
          ((ConstraintReference)localObject1).endToEnd(localObject3);
        } else {
          ((ConstraintReference)localObject1).endToEnd(State.PARENT);
        }
      }
    }
    if ((localObject2 != null) && (this.mBias != 0.5F)) {
      localObject2.horizontalBias(this.mBias);
    }
    int i = HorizontalChainReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        localObject2.setHorizontalChainStyle(2);
        return;
      }
      localObject2.setHorizontalChainStyle(1);
      return;
    }
    localObject2.setHorizontalChainStyle(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.HorizontalChainReference
 * JD-Core Version:    0.7.0.1
 */