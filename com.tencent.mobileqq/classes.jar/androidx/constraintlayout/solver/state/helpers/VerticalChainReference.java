package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Helper;
import java.util.ArrayList;
import java.util.Iterator;

public class VerticalChainReference
  extends ChainReference
{
  private Object mBottomToBottom;
  private Object mBottomToTop;
  private Object mTopToBottom;
  private Object mTopToTop;
  
  public VerticalChainReference(State paramState)
  {
    super(paramState, State.Helper.VERTICAL_CHAIN);
  }
  
  public void apply()
  {
    Object localObject1 = this.mReferences.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      this.mState.constraints(localObject2).clearVertical();
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
        localObject2 = this.mTopToTop;
        if (localObject2 != null)
        {
          ((ConstraintReference)localObject3).topToTop(localObject2);
        }
        else
        {
          localObject2 = this.mTopToBottom;
          if (localObject2 != null) {
            ((ConstraintReference)localObject3).topToBottom(localObject2);
          } else {
            ((ConstraintReference)localObject3).topToTop(State.PARENT);
          }
        }
        localObject4 = localObject3;
      }
      if (localObject1 != null)
      {
        ((ConstraintReference)localObject1).bottomToTop(((ConstraintReference)localObject3).getKey());
        ((ConstraintReference)localObject3).topToBottom(((ConstraintReference)localObject1).getKey());
      }
      localObject1 = localObject3;
    }
    if (localObject1 != null)
    {
      localObject3 = this.mBottomToTop;
      if (localObject3 != null)
      {
        ((ConstraintReference)localObject1).bottomToTop(localObject3);
      }
      else
      {
        localObject3 = this.mBottomToBottom;
        if (localObject3 != null) {
          ((ConstraintReference)localObject1).bottomToBottom(localObject3);
        } else {
          ((ConstraintReference)localObject1).bottomToBottom(State.PARENT);
        }
      }
    }
    if ((localObject2 != null) && (this.mBias != 0.5F)) {
      localObject2.verticalBias(this.mBias);
    }
    int i = VerticalChainReference.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        localObject2.setVerticalChainStyle(2);
        return;
      }
      localObject2.setVerticalChainStyle(1);
      return;
    }
    localObject2.setVerticalChainStyle(0);
  }
  
  public void bottomToBottom(Object paramObject)
  {
    this.mBottomToBottom = paramObject;
  }
  
  public void bottomToTop(Object paramObject)
  {
    this.mBottomToTop = paramObject;
  }
  
  public void topToBottom(Object paramObject)
  {
    this.mTopToBottom = paramObject;
  }
  
  public void topToTop(Object paramObject)
  {
    this.mTopToTop = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.VerticalChainReference
 * JD-Core Version:    0.7.0.1
 */