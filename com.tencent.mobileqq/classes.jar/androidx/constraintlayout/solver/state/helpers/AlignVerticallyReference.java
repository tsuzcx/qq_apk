package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Helper;
import java.util.ArrayList;
import java.util.Iterator;

public class AlignVerticallyReference
  extends HelperReference
{
  private float mBias = 0.5F;
  private Object mBottomToBottom;
  private Object mBottomToTop;
  private Object mTopToBottom;
  private Object mTopToTop;
  
  public AlignVerticallyReference(State paramState)
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
      ((ConstraintReference)localObject1).clearVertical();
      Object localObject2 = this.mTopToTop;
      if (localObject2 != null)
      {
        ((ConstraintReference)localObject1).topToTop(localObject2);
      }
      else
      {
        localObject2 = this.mTopToBottom;
        if (localObject2 != null) {
          ((ConstraintReference)localObject1).topToBottom(localObject2);
        } else {
          ((ConstraintReference)localObject1).topToTop(State.PARENT);
        }
      }
      localObject2 = this.mBottomToTop;
      if (localObject2 != null)
      {
        ((ConstraintReference)localObject1).bottomToTop(localObject2);
      }
      else
      {
        localObject2 = this.mBottomToBottom;
        if (localObject2 != null) {
          ((ConstraintReference)localObject1).bottomToBottom(localObject2);
        } else {
          ((ConstraintReference)localObject1).bottomToBottom(State.PARENT);
        }
      }
      float f = this.mBias;
      if (f != 0.5F) {
        ((ConstraintReference)localObject1).verticalBias(f);
      }
    }
  }
  
  public void bias(float paramFloat)
  {
    this.mBias = paramFloat;
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
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference
 * JD-Core Version:    0.7.0.1
 */