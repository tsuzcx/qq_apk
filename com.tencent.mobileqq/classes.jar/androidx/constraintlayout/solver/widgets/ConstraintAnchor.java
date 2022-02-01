package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable.Type;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor
{
  private static final boolean ALLOW_BINARY = false;
  private static final int UNSET_GONE_MARGIN = -1;
  private HashSet<ConstraintAnchor> mDependents = null;
  private int mFinalValue;
  int mGoneMargin = -1;
  private boolean mHasFinalValue;
  public int mMargin = 0;
  public final ConstraintWidget mOwner;
  SolverVariable mSolverVariable;
  public ConstraintAnchor mTarget;
  public final ConstraintAnchor.Type mType;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType)
  {
    this.mOwner = paramConstraintWidget;
    this.mType = paramType;
  }
  
  private boolean isConnectionToMe(ConstraintWidget paramConstraintWidget, HashSet<ConstraintWidget> paramHashSet)
  {
    if (paramHashSet.contains(paramConstraintWidget)) {
      return false;
    }
    paramHashSet.add(paramConstraintWidget);
    if (paramConstraintWidget == getOwner()) {
      return true;
    }
    paramConstraintWidget = paramConstraintWidget.getAnchors();
    int j = paramConstraintWidget.size();
    int i = 0;
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramConstraintWidget.get(i);
      if ((localConstraintAnchor.isSimilarDimensionConnection(this)) && (localConstraintAnchor.isConnected()) && (isConnectionToMe(localConstraintAnchor.getTarget().getOwner(), paramHashSet))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    return connect(paramConstraintAnchor, paramInt, -1, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramConstraintAnchor == null)
    {
      reset();
      return true;
    }
    if ((!paramBoolean) && (!isValidConnection(paramConstraintAnchor))) {
      return false;
    }
    this.mTarget = paramConstraintAnchor;
    paramConstraintAnchor = this.mTarget;
    if (paramConstraintAnchor.mDependents == null) {
      paramConstraintAnchor.mDependents = new HashSet();
    }
    paramConstraintAnchor = this.mTarget.mDependents;
    if (paramConstraintAnchor != null) {
      paramConstraintAnchor.add(this);
    }
    if (paramInt1 > 0) {
      this.mMargin = paramInt1;
    } else {
      this.mMargin = 0;
    }
    this.mGoneMargin = paramInt2;
    return true;
  }
  
  public void copyFrom(ConstraintAnchor paramConstraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> paramHashMap)
  {
    Object localObject = this.mTarget;
    if (localObject != null)
    {
      localObject = ((ConstraintAnchor)localObject).mDependents;
      if (localObject != null) {
        ((HashSet)localObject).remove(this);
      }
    }
    localObject = paramConstraintAnchor.mTarget;
    if (localObject != null)
    {
      localObject = ((ConstraintAnchor)localObject).getType();
      this.mTarget = ((ConstraintWidget)paramHashMap.get(paramConstraintAnchor.mTarget.mOwner)).getAnchor((ConstraintAnchor.Type)localObject);
    }
    else
    {
      this.mTarget = null;
    }
    paramHashMap = this.mTarget;
    if (paramHashMap != null)
    {
      if (paramHashMap.mDependents == null) {
        paramHashMap.mDependents = new HashSet();
      }
      this.mTarget.mDependents.add(this);
    }
    this.mMargin = paramConstraintAnchor.mMargin;
    this.mGoneMargin = paramConstraintAnchor.mGoneMargin;
  }
  
  public void findDependents(int paramInt, ArrayList<WidgetGroup> paramArrayList, WidgetGroup paramWidgetGroup)
  {
    Object localObject = this.mDependents;
    if (localObject != null)
    {
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        Grouping.findDependents(((ConstraintAnchor)((Iterator)localObject).next()).mOwner, paramInt, paramArrayList, paramWidgetGroup);
      }
    }
  }
  
  public HashSet<ConstraintAnchor> getDependents()
  {
    return this.mDependents;
  }
  
  public int getFinalValue()
  {
    if (!this.mHasFinalValue) {
      return 0;
    }
    return this.mFinalValue;
  }
  
  public int getMargin()
  {
    if (this.mOwner.getVisibility() == 8) {
      return 0;
    }
    if (this.mGoneMargin > -1)
    {
      ConstraintAnchor localConstraintAnchor = this.mTarget;
      if ((localConstraintAnchor != null) && (localConstraintAnchor.mOwner.getVisibility() == 8)) {
        return this.mGoneMargin;
      }
    }
    return this.mMargin;
  }
  
  public final ConstraintAnchor getOpposite()
  {
    switch (ConstraintAnchor.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 5: 
      return this.mOwner.mTop;
    case 4: 
      return this.mOwner.mBottom;
    case 3: 
      return this.mOwner.mLeft;
    case 2: 
      return this.mOwner.mRight;
    }
    return null;
  }
  
  public ConstraintWidget getOwner()
  {
    return this.mOwner;
  }
  
  public SolverVariable getSolverVariable()
  {
    return this.mSolverVariable;
  }
  
  public ConstraintAnchor getTarget()
  {
    return this.mTarget;
  }
  
  public ConstraintAnchor.Type getType()
  {
    return this.mType;
  }
  
  public boolean hasCenteredDependents()
  {
    Object localObject = this.mDependents;
    if (localObject == null) {
      return false;
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ConstraintAnchor)((Iterator)localObject).next()).getOpposite().isConnected()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasDependents()
  {
    HashSet localHashSet = this.mDependents;
    boolean bool = false;
    if (localHashSet == null) {
      return false;
    }
    if (localHashSet.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean hasFinalValue()
  {
    return this.mHasFinalValue;
  }
  
  public boolean isConnected()
  {
    return this.mTarget != null;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget)
  {
    if (isConnectionToMe(paramConstraintWidget, new HashSet())) {
      return false;
    }
    ConstraintWidget localConstraintWidget = getOwner().getParent();
    if (localConstraintWidget == paramConstraintWidget) {
      return true;
    }
    return paramConstraintWidget.getParent() == localConstraintWidget;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget, ConstraintAnchor paramConstraintAnchor)
  {
    return isConnectionAllowed(paramConstraintWidget);
  }
  
  public boolean isSideAnchor()
  {
    switch (ConstraintAnchor.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return true;
    }
    return false;
  }
  
  public boolean isSimilarDimensionConnection(ConstraintAnchor paramConstraintAnchor)
  {
    paramConstraintAnchor = paramConstraintAnchor.getType();
    ConstraintAnchor.Type localType = this.mType;
    boolean bool3 = true;
    boolean bool2 = true;
    if (paramConstraintAnchor == localType) {
      return true;
    }
    boolean bool1;
    switch (ConstraintAnchor.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 9: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 8: 
      bool1 = bool2;
      if (paramConstraintAnchor != ConstraintAnchor.Type.TOP)
      {
        bool1 = bool2;
        if (paramConstraintAnchor != ConstraintAnchor.Type.BOTTOM)
        {
          bool1 = bool2;
          if (paramConstraintAnchor != ConstraintAnchor.Type.CENTER_Y)
          {
            if (paramConstraintAnchor == ConstraintAnchor.Type.BASELINE) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    case 2: 
    case 3: 
    case 7: 
      bool1 = bool3;
      if (paramConstraintAnchor != ConstraintAnchor.Type.LEFT)
      {
        bool1 = bool3;
        if (paramConstraintAnchor != ConstraintAnchor.Type.RIGHT)
        {
          if (paramConstraintAnchor == ConstraintAnchor.Type.CENTER_X) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    return paramConstraintAnchor != ConstraintAnchor.Type.BASELINE;
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool2 = false;
    if (paramConstraintAnchor == null) {
      return false;
    }
    ConstraintAnchor.Type localType1 = paramConstraintAnchor.getType();
    ConstraintAnchor.Type localType2 = this.mType;
    if (localType1 == localType2) {
      return (localType2 != ConstraintAnchor.Type.BASELINE) || ((paramConstraintAnchor.getOwner().hasBaseline()) && (getOwner().hasBaseline()));
    }
    switch (ConstraintAnchor.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return false;
    case 4: 
    case 5: 
      if ((localType1 != ConstraintAnchor.Type.TOP) && (localType1 != ConstraintAnchor.Type.BOTTOM)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if ((paramConstraintAnchor.getOwner() instanceof Guideline))
      {
        if ((!bool1) && (localType1 != ConstraintAnchor.Type.CENTER_Y)) {
          return false;
        }
        bool2 = true;
      }
      return bool2;
    case 2: 
    case 3: 
      if ((localType1 != ConstraintAnchor.Type.LEFT) && (localType1 != ConstraintAnchor.Type.RIGHT)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if ((paramConstraintAnchor.getOwner() instanceof Guideline))
      {
        if ((!bool1) && (localType1 != ConstraintAnchor.Type.CENTER_X)) {
          return false;
        }
        bool2 = true;
      }
      return bool2;
    }
    boolean bool1 = bool2;
    if (localType1 != ConstraintAnchor.Type.BASELINE)
    {
      bool1 = bool2;
      if (localType1 != ConstraintAnchor.Type.CENTER_X)
      {
        bool1 = bool2;
        if (localType1 != ConstraintAnchor.Type.CENTER_Y) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isVerticalAnchor()
  {
    switch (ConstraintAnchor.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    Object localObject = this.mTarget;
    if (localObject != null)
    {
      localObject = ((ConstraintAnchor)localObject).mDependents;
      if (localObject != null)
      {
        ((HashSet)localObject).remove(this);
        if (this.mTarget.mDependents.size() == 0) {
          this.mTarget.mDependents = null;
        }
      }
    }
    this.mDependents = null;
    this.mTarget = null;
    this.mMargin = 0;
    this.mGoneMargin = -1;
    this.mHasFinalValue = false;
    this.mFinalValue = 0;
  }
  
  public void resetFinalResolution()
  {
    this.mHasFinalValue = false;
    this.mFinalValue = 0;
  }
  
  public void resetSolverVariable(Cache paramCache)
  {
    paramCache = this.mSolverVariable;
    if (paramCache == null)
    {
      this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
      return;
    }
    paramCache.reset();
  }
  
  public void setFinalValue(int paramInt)
  {
    this.mFinalValue = paramInt;
    this.mHasFinalValue = true;
  }
  
  public void setGoneMargin(int paramInt)
  {
    if (isConnected()) {
      this.mGoneMargin = paramInt;
    }
  }
  
  public void setMargin(int paramInt)
  {
    if (isConnected()) {
      this.mMargin = paramInt;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mOwner.getDebugName());
    localStringBuilder.append(":");
    localStringBuilder.append(this.mType.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.ConstraintAnchor
 * JD-Core Version:    0.7.0.1
 */