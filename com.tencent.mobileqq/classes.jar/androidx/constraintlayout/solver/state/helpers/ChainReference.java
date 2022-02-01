package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State.Chain;
import androidx.constraintlayout.solver.state.State.Helper;

public class ChainReference
  extends HelperReference
{
  protected float mBias = 0.5F;
  protected State.Chain mStyle = State.Chain.SPREAD;
  
  public ChainReference(State paramState, State.Helper paramHelper)
  {
    super(paramState, paramHelper);
  }
  
  public void bias(float paramFloat)
  {
    this.mBias = paramFloat;
  }
  
  public float getBias()
  {
    return this.mBias;
  }
  
  public State.Chain getStyle()
  {
    return State.Chain.SPREAD;
  }
  
  public void style(State.Chain paramChain)
  {
    this.mStyle = paramChain;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.helpers.ChainReference
 * JD-Core Version:    0.7.0.1
 */