package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

public class HelperReference
{
  private HelperWidget mHelperWidget;
  protected ArrayList<Object> mReferences = new ArrayList();
  protected final State mState;
  final State.Helper mType;
  
  public HelperReference(State paramState, State.Helper paramHelper)
  {
    this.mState = paramState;
    this.mType = paramHelper;
  }
  
  public HelperReference add(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      this.mReferences.add(localObject);
      i += 1;
    }
    return this;
  }
  
  public void apply() {}
  
  public HelperWidget getHelperWidget()
  {
    return this.mHelperWidget;
  }
  
  public State.Helper getType()
  {
    return this.mType;
  }
  
  public void setHelperWidget(HelperWidget paramHelperWidget)
  {
    this.mHelperWidget = paramHelperWidget;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.HelperReference
 * JD-Core Version:    0.7.0.1
 */