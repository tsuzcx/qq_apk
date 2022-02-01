package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class State
{
  static final int CONSTRAINT_RATIO = 2;
  static final int CONSTRAINT_SPREAD = 0;
  static final int CONSTRAINT_WRAP = 1;
  public static final Integer PARENT = Integer.valueOf(0);
  static final int UNKNOWN = -1;
  protected HashMap<Object, HelperReference> mHelperReferences = new HashMap();
  public final ConstraintReference mParent = new ConstraintReference(this);
  protected HashMap<Object, Reference> mReferences = new HashMap();
  private int numHelpers = 0;
  
  public State()
  {
    this.mReferences.put(PARENT, this.mParent);
  }
  
  private String createHelperKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__HELPER_KEY_");
    int i = this.numHelpers;
    this.numHelpers = (i + 1);
    localStringBuilder.append(i);
    localStringBuilder.append("__");
    return localStringBuilder.toString();
  }
  
  public void apply(ConstraintWidgetContainer paramConstraintWidgetContainer)
  {
    paramConstraintWidgetContainer.removeAllChildren();
    this.mParent.getWidth().apply(this, paramConstraintWidgetContainer, 0);
    this.mParent.getHeight().apply(this, paramConstraintWidgetContainer, 1);
    Object localObject3 = this.mHelperReferences.keySet().iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      HelperWidget localHelperWidget = ((HelperReference)this.mHelperReferences.get(localObject4)).getHelperWidget();
      if (localHelperWidget != null)
      {
        localObject2 = (Reference)this.mReferences.get(localObject4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = constraints(localObject4);
        }
        ((Reference)localObject1).setConstraintWidget(localHelperWidget);
      }
    }
    Object localObject1 = this.mReferences.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject2 = (Reference)this.mReferences.get(localObject2);
      if (localObject2 != this.mParent)
      {
        localObject3 = ((Reference)localObject2).getConstraintWidget();
        ((ConstraintWidget)localObject3).setParent(null);
        if ((localObject2 instanceof GuidelineReference)) {
          ((Reference)localObject2).apply();
        }
        paramConstraintWidgetContainer.add((ConstraintWidget)localObject3);
      }
      else
      {
        ((Reference)localObject2).setConstraintWidget(paramConstraintWidgetContainer);
      }
    }
    paramConstraintWidgetContainer = this.mHelperReferences.keySet().iterator();
    while (paramConstraintWidgetContainer.hasNext())
    {
      localObject1 = paramConstraintWidgetContainer.next();
      localObject1 = (HelperReference)this.mHelperReferences.get(localObject1);
      if (((HelperReference)localObject1).getHelperWidget() != null)
      {
        localObject2 = ((HelperReference)localObject1).mReferences.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          localObject3 = (Reference)this.mReferences.get(localObject3);
          ((HelperReference)localObject1).getHelperWidget().add(((Reference)localObject3).getConstraintWidget());
        }
        ((HelperReference)localObject1).apply();
      }
    }
    paramConstraintWidgetContainer = this.mReferences.keySet().iterator();
    while (paramConstraintWidgetContainer.hasNext())
    {
      localObject1 = paramConstraintWidgetContainer.next();
      ((Reference)this.mReferences.get(localObject1)).apply();
    }
  }
  
  public BarrierReference barrier(Object paramObject, State.Direction paramDirection)
  {
    paramObject = (BarrierReference)helper(paramObject, State.Helper.BARRIER);
    paramObject.setBarrierDirection(paramDirection);
    return paramObject;
  }
  
  public AlignHorizontallyReference centerHorizontally(Object... paramVarArgs)
  {
    AlignHorizontallyReference localAlignHorizontallyReference = (AlignHorizontallyReference)helper(null, State.Helper.ALIGN_HORIZONTALLY);
    localAlignHorizontallyReference.add(paramVarArgs);
    return localAlignHorizontallyReference;
  }
  
  public AlignVerticallyReference centerVertically(Object... paramVarArgs)
  {
    AlignVerticallyReference localAlignVerticallyReference = (AlignVerticallyReference)helper(null, State.Helper.ALIGN_VERTICALLY);
    localAlignVerticallyReference.add(paramVarArgs);
    return localAlignVerticallyReference;
  }
  
  public ConstraintReference constraints(Object paramObject)
  {
    Reference localReference = (Reference)this.mReferences.get(paramObject);
    Object localObject = localReference;
    if (localReference == null)
    {
      localObject = createConstraintReference(paramObject);
      this.mReferences.put(paramObject, localObject);
      ((Reference)localObject).setKey(paramObject);
    }
    if ((localObject instanceof ConstraintReference)) {
      return (ConstraintReference)localObject;
    }
    return null;
  }
  
  public int convertDimension(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).intValue();
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue();
    }
    return 0;
  }
  
  public ConstraintReference createConstraintReference(Object paramObject)
  {
    return new ConstraintReference(this);
  }
  
  public void directMapping()
  {
    Iterator localIterator = this.mReferences.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      constraints(localObject).setView(localObject);
    }
  }
  
  public GuidelineReference guideline(Object paramObject, int paramInt)
  {
    Reference localReference = (Reference)this.mReferences.get(paramObject);
    Object localObject = localReference;
    if (localReference == null)
    {
      localObject = new GuidelineReference(this);
      ((GuidelineReference)localObject).setOrientation(paramInt);
      ((GuidelineReference)localObject).setKey(paramObject);
      this.mReferences.put(paramObject, localObject);
    }
    return (GuidelineReference)localObject;
  }
  
  public State height(Dimension paramDimension)
  {
    return setHeight(paramDimension);
  }
  
  public HelperReference helper(Object paramObject, State.Helper paramHelper)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = createHelperKey();
    }
    HelperReference localHelperReference = (HelperReference)this.mHelperReferences.get(localObject);
    paramObject = localHelperReference;
    if (localHelperReference == null)
    {
      int i = State.1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[paramHelper.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                paramObject = new HelperReference(this, paramHelper);
              } else {
                paramObject = new BarrierReference(this);
              }
            }
            else {
              paramObject = new AlignVerticallyReference(this);
            }
          }
          else {
            paramObject = new AlignHorizontallyReference(this);
          }
        }
        else {
          paramObject = new VerticalChainReference(this);
        }
      }
      else {
        paramObject = new HorizontalChainReference(this);
      }
      this.mHelperReferences.put(localObject, paramObject);
    }
    return paramObject;
  }
  
  public HorizontalChainReference horizontalChain(Object... paramVarArgs)
  {
    HorizontalChainReference localHorizontalChainReference = (HorizontalChainReference)helper(null, State.Helper.HORIZONTAL_CHAIN);
    localHorizontalChainReference.add(paramVarArgs);
    return localHorizontalChainReference;
  }
  
  public GuidelineReference horizontalGuideline(Object paramObject)
  {
    return guideline(paramObject, 0);
  }
  
  public void map(Object paramObject1, Object paramObject2)
  {
    constraints(paramObject1).setView(paramObject2);
  }
  
  Reference reference(Object paramObject)
  {
    return (Reference)this.mReferences.get(paramObject);
  }
  
  public void reset()
  {
    this.mHelperReferences.clear();
  }
  
  public State setHeight(Dimension paramDimension)
  {
    this.mParent.setHeight(paramDimension);
    return this;
  }
  
  public State setWidth(Dimension paramDimension)
  {
    this.mParent.setWidth(paramDimension);
    return this;
  }
  
  public VerticalChainReference verticalChain(Object... paramVarArgs)
  {
    VerticalChainReference localVerticalChainReference = (VerticalChainReference)helper(null, State.Helper.VERTICAL_CHAIN);
    localVerticalChainReference.add(paramVarArgs);
    return localVerticalChainReference;
  }
  
  public GuidelineReference verticalGuideline(Object paramObject)
  {
    return guideline(paramObject, 1);
  }
  
  public State width(Dimension paramDimension)
  {
    return setWidth(paramDimension);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.state.State
 * JD-Core Version:    0.7.0.1
 */