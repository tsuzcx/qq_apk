package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor
{
  private static final boolean ALLOW_BINARY = false;
  public static final int ANY_GROUP = 2147483647;
  public static final int APPLY_GROUP_RESULTS = -2;
  public static final int AUTO_CONSTRAINT_CREATOR = 2;
  public static final int SCOUT_CREATOR = 1;
  private static final int UNSET_GONE_MARGIN = -1;
  public static final int USER_CREATOR = 0;
  public static final boolean USE_CENTER_ANCHOR = false;
  private int mConnectionCreator = 0;
  private ConstraintAnchor.ConnectionType mConnectionType = ConstraintAnchor.ConnectionType.RELAXED;
  int mGoneMargin = -1;
  int mGroup = 2147483647;
  public int mMargin = 0;
  final ConstraintWidget mOwner;
  SolverVariable mSolverVariable;
  private ConstraintAnchor.Strength mStrength = ConstraintAnchor.Strength.NONE;
  ConstraintAnchor mTarget;
  final ConstraintAnchor.Type mType;
  
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
  
  private String toString(HashSet<ConstraintAnchor> paramHashSet)
  {
    if (paramHashSet.add(this))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.mOwner.getDebugName());
      localStringBuilder1.append(":");
      localStringBuilder1.append(this.mType.toString());
      if (this.mTarget != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" connected to ");
        localStringBuilder2.append(this.mTarget.toString(paramHashSet));
        paramHashSet = localStringBuilder2.toString();
      }
      else
      {
        paramHashSet = "";
      }
      localStringBuilder1.append(paramHashSet);
      return localStringBuilder1.toString();
    }
    return "<-";
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    return connect(paramConstraintAnchor, paramInt, -1, ConstraintAnchor.Strength.STRONG, 0, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, ConstraintAnchor.Strength.STRONG, paramInt2, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, ConstraintAnchor.Strength paramStrength, int paramInt3, boolean paramBoolean)
  {
    if (paramConstraintAnchor == null)
    {
      this.mTarget = null;
      this.mMargin = 0;
      this.mGoneMargin = -1;
      this.mStrength = ConstraintAnchor.Strength.NONE;
      this.mConnectionCreator = 2;
      return true;
    }
    if ((!paramBoolean) && (!isValidConnection(paramConstraintAnchor))) {
      return false;
    }
    this.mTarget = paramConstraintAnchor;
    if (paramInt1 > 0) {
      this.mMargin = paramInt1;
    } else {
      this.mMargin = 0;
    }
    this.mGoneMargin = paramInt2;
    this.mStrength = paramStrength;
    this.mConnectionCreator = paramInt3;
    return true;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, paramStrength, paramInt2, false);
  }
  
  public int getConnectionCreator()
  {
    return this.mConnectionCreator;
  }
  
  public ConstraintAnchor.ConnectionType getConnectionType()
  {
    return this.mConnectionType;
  }
  
  public int getGroup()
  {
    return this.mGroup;
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
    int i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()];
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5) {
            return null;
          }
          return this.mOwner.mTop;
        }
        return this.mOwner.mBottom;
      }
      return this.mOwner.mLeft;
    }
    return this.mOwner.mRight;
  }
  
  public ConstraintWidget getOwner()
  {
    return this.mOwner;
  }
  
  public int getPriorityLevel()
  {
    switch (ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      return 0;
    case 8: 
      return 1;
    case 6: 
    case 7: 
      return 0;
    }
    return 2;
  }
  
  public int getSnapPriorityLevel()
  {
    switch (ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      return 0;
    case 8: 
      return 2;
    case 7: 
      return 1;
    case 4: 
    case 5: 
    case 6: 
      return 0;
    case 2: 
    case 3: 
      return 1;
    }
    return 3;
  }
  
  public SolverVariable getSolverVariable()
  {
    return this.mSolverVariable;
  }
  
  public ConstraintAnchor.Strength getStrength()
  {
    return this.mStrength;
  }
  
  public ConstraintAnchor getTarget()
  {
    return this.mTarget;
  }
  
  public ConstraintAnchor.Type getType()
  {
    return this.mType;
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
    int i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()];
    return (i == 2) || (i == 3) || (i == 4) || (i == 5);
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
    switch (ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      return false;
    case 4: 
    case 5: 
    case 7: 
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
    case 6: 
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
  
  public boolean isSnapCompatibleWith(ConstraintAnchor paramConstraintAnchor)
  {
    if (this.mType == ConstraintAnchor.Type.CENTER) {
      return false;
    }
    if (this.mType == paramConstraintAnchor.getType()) {
      return true;
    }
    switch (ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      return false;
    case 7: 
      i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
      return (i == 4) || (i == 5);
    case 6: 
      i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
      return (i == 2) || (i == 3);
    case 5: 
      i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
      return (i == 4) || (i == 7);
    case 4: 
      i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
      return (i == 5) || (i == 7);
    case 3: 
      i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
      return (i == 2) || (i == 6);
    }
    int i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()];
    return (i == 3) || (i == 6);
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool2 = false;
    if (paramConstraintAnchor == null) {
      return false;
    }
    ConstraintAnchor.Type localType1 = paramConstraintAnchor.getType();
    ConstraintAnchor.Type localType2 = this.mType;
    if (localType1 == localType2)
    {
      if (localType2 == ConstraintAnchor.Type.CENTER) {
        return false;
      }
      return (this.mType != ConstraintAnchor.Type.BASELINE) || ((paramConstraintAnchor.getOwner().hasBaseline()) && (getOwner().hasBaseline()));
    }
    int i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 5)) {
          return false;
        }
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
      }
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
    int i = ConstraintAnchor.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()];
    return (i != 1) && (i != 2) && (i != 3) && (i != 6);
  }
  
  public void reset()
  {
    this.mTarget = null;
    this.mMargin = 0;
    this.mGoneMargin = -1;
    this.mStrength = ConstraintAnchor.Strength.STRONG;
    this.mConnectionCreator = 0;
    this.mConnectionType = ConstraintAnchor.ConnectionType.RELAXED;
  }
  
  public void resetSolverVariable(Cache paramCache)
  {
    paramCache = this.mSolverVariable;
    if (paramCache == null)
    {
      this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
      return;
    }
    paramCache.reset();
  }
  
  public void setConnectionCreator(int paramInt)
  {
    this.mConnectionCreator = paramInt;
  }
  
  public void setConnectionType(ConstraintAnchor.ConnectionType paramConnectionType)
  {
    this.mConnectionType = paramConnectionType;
  }
  
  public void setGoneMargin(int paramInt)
  {
    if (isConnected()) {
      this.mGoneMargin = paramInt;
    }
  }
  
  public void setGroup(int paramInt)
  {
    this.mGroup = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    if (isConnected()) {
      this.mMargin = paramInt;
    }
  }
  
  public void setStrength(ConstraintAnchor.Strength paramStrength)
  {
    if (isConnected()) {
      this.mStrength = paramStrength;
    }
  }
  
  public String toString()
  {
    Object localObject = new HashSet();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.mOwner.getDebugName());
    localStringBuilder1.append(":");
    localStringBuilder1.append(this.mType.toString());
    if (this.mTarget != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" connected to ");
      localStringBuilder2.append(this.mTarget.toString((HashSet)localObject));
      localObject = localStringBuilder2.toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder1.append((String)localObject);
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintAnchor
 * JD-Core Version:    0.7.0.1
 */