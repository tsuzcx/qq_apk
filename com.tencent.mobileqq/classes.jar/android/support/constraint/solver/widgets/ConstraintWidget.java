package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget
{
  private static final boolean AUTOTAG_CENTER = false;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static float DEFAULT_BIAS = 0.5F;
  protected static final int DIRECT = 2;
  public static final int GONE = 8;
  public static final int HORIZONTAL = 0;
  public static final int INVISIBLE = 4;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  protected static final int SOLVER = 1;
  public static final int UNKNOWN = -1;
  public static final int VERTICAL = 1;
  public static final int VISIBLE = 0;
  protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList();
  ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  int mBaselineDistance = 0;
  ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  boolean mBottomHasCentered;
  ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  private Object mCompanionWidget;
  private int mContainerItemSkip;
  private String mDebugName;
  protected float mDimensionRatio = 0.0F;
  protected int mDimensionRatioSide = -1;
  int mDistToBottom;
  int mDistToLeft;
  int mDistToRight;
  int mDistToTop;
  private int mDrawHeight = 0;
  private int mDrawWidth = 0;
  private int mDrawX = 0;
  private int mDrawY = 0;
  int mHeight = 0;
  float mHorizontalBiasPercent;
  boolean mHorizontalChainFixedPosition;
  int mHorizontalChainStyle;
  ConstraintWidget.DimensionBehaviour mHorizontalDimensionBehaviour;
  ConstraintWidget mHorizontalNextWidget;
  public int mHorizontalResolution = -1;
  float mHorizontalWeight;
  boolean mHorizontalWrapVisited;
  ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  boolean mLeftHasCentered;
  int mMatchConstraintDefaultHeight = 0;
  int mMatchConstraintDefaultWidth = 0;
  int mMatchConstraintMaxHeight = 0;
  int mMatchConstraintMaxWidth = 0;
  int mMatchConstraintMinHeight = 0;
  int mMatchConstraintMinWidth = 0;
  protected int mMinHeight;
  protected int mMinWidth;
  protected int mOffsetX = 0;
  protected int mOffsetY = 0;
  ConstraintWidget mParent = null;
  ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  boolean mRightHasCentered;
  private int mSolverBottom = 0;
  private int mSolverLeft = 0;
  private int mSolverRight = 0;
  private int mSolverTop = 0;
  ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  boolean mTopHasCentered;
  private String mType;
  float mVerticalBiasPercent;
  boolean mVerticalChainFixedPosition;
  int mVerticalChainStyle;
  ConstraintWidget.DimensionBehaviour mVerticalDimensionBehaviour;
  ConstraintWidget mVerticalNextWidget;
  public int mVerticalResolution = -1;
  float mVerticalWeight;
  boolean mVerticalWrapVisited;
  private int mVisibility;
  int mWidth = 0;
  private int mWrapHeight;
  private int mWrapWidth;
  protected int mX = 0;
  protected int mY = 0;
  
  public ConstraintWidget()
  {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalWeight = 0.0F;
    this.mVerticalWeight = 0.0F;
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    addAnchors();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2)
  {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalWeight = 0.0F;
    this.mVerticalWeight = 0.0F;
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    addAnchors();
    forceUpdateDrawPosition();
  }
  
  private void addAnchors()
  {
    this.mAnchors.add(this.mLeft);
    this.mAnchors.add(this.mTop);
    this.mAnchors.add(this.mRight);
    this.mAnchors.add(this.mBottom);
    this.mAnchors.add(this.mCenterX);
    this.mAnchors.add(this.mCenterY);
    this.mAnchors.add(this.mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7)
  {
    SolverVariable localSolverVariable3 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1);
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2);
    SolverVariable localSolverVariable4 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1.getTarget());
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2.getTarget());
    int i = paramConstraintAnchor1.getMargin();
    int j = paramConstraintAnchor2.getMargin();
    if (this.mVisibility == 8)
    {
      paramBoolean2 = true;
      paramInt3 = 0;
    }
    if ((localSolverVariable4 == null) && (localSolverVariable2 == null))
    {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable3, paramInt1));
      if (!paramBoolean3)
      {
        if (paramBoolean1)
        {
          paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, localSolverVariable1, localSolverVariable3, paramInt4, true));
          return;
        }
        if (paramBoolean2)
        {
          paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, localSolverVariable1, localSolverVariable3, paramInt3, false));
          return;
        }
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, paramInt2));
      }
    }
    else if ((localSolverVariable4 != null) && (localSolverVariable2 == null))
    {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable3, localSolverVariable4, i));
      if (paramBoolean1)
      {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, localSolverVariable1, localSolverVariable3, paramInt4, true));
        return;
      }
      if (!paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, paramInt3));
          return;
        }
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, paramInt2));
      }
    }
    else if ((localSolverVariable4 == null) && (localSolverVariable2 != null))
    {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable2, j * -1));
      if (paramBoolean1)
      {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, localSolverVariable1, localSolverVariable3, paramInt4, true));
        return;
      }
      if (!paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, paramInt3));
          return;
        }
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable3, paramInt1));
      }
    }
    else if (paramBoolean2)
    {
      if (paramBoolean1) {
        paramLinearSystem.addConstraint(LinearSystem.createRowEquals(paramLinearSystem, localSolverVariable1, localSolverVariable3, paramInt4, true));
      } else {
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, paramInt3));
      }
      if (paramConstraintAnchor1.getStrength() != paramConstraintAnchor2.getStrength())
      {
        if (paramConstraintAnchor1.getStrength() == ConstraintAnchor.Strength.STRONG)
        {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable3, localSolverVariable4, i));
          paramConstraintAnchor1 = paramLinearSystem.createSlackVariable();
          paramConstraintAnchor2 = paramLinearSystem.createRow();
          paramConstraintAnchor2.createRowLowerThan(localSolverVariable1, localSolverVariable2, paramConstraintAnchor1, j * -1);
          paramLinearSystem.addConstraint(paramConstraintAnchor2);
          return;
        }
        paramConstraintAnchor1 = paramLinearSystem.createSlackVariable();
        paramConstraintAnchor2 = paramLinearSystem.createRow();
        paramConstraintAnchor2.createRowGreaterThan(localSolverVariable3, localSolverVariable4, paramConstraintAnchor1, i);
        paramLinearSystem.addConstraint(paramConstraintAnchor2);
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable2, j * -1));
        return;
      }
      if (localSolverVariable4 == localSolverVariable2)
      {
        paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, localSolverVariable3, localSolverVariable4, 0, 0.5F, localSolverVariable2, localSolverVariable1, 0, true));
        return;
      }
      if (!paramBoolean4)
      {
        if (paramConstraintAnchor1.getConnectionType() != ConstraintAnchor.ConnectionType.STRICT) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        paramLinearSystem.addConstraint(LinearSystem.createRowGreaterThan(paramLinearSystem, localSolverVariable3, localSolverVariable4, i, paramBoolean1));
        if (paramConstraintAnchor2.getConnectionType() != ConstraintAnchor.ConnectionType.STRICT) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        paramLinearSystem.addConstraint(LinearSystem.createRowLowerThan(paramLinearSystem, localSolverVariable1, localSolverVariable2, j * -1, paramBoolean1));
        paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, localSolverVariable3, localSolverVariable4, i, paramFloat, localSolverVariable2, localSolverVariable1, j, false));
      }
    }
    else
    {
      if (paramBoolean3)
      {
        paramLinearSystem.addGreaterThan(localSolverVariable3, localSolverVariable4, i, 3);
        paramLinearSystem.addLowerThan(localSolverVariable1, localSolverVariable2, j * -1, 3);
        paramLinearSystem.addConstraint(LinearSystem.createRowCentering(paramLinearSystem, localSolverVariable3, localSolverVariable4, i, paramFloat, localSolverVariable2, localSolverVariable1, j, true));
        return;
      }
      if (!paramBoolean4)
      {
        if (paramInt5 == 1)
        {
          if (paramInt6 > paramInt3) {
            paramInt1 = paramInt6;
          } else {
            paramInt1 = paramInt3;
          }
          paramInt2 = paramInt1;
          if (paramInt7 > 0) {
            if (paramInt7 < paramInt1)
            {
              paramInt2 = paramInt7;
            }
            else
            {
              paramLinearSystem.addLowerThan(localSolverVariable1, localSolverVariable3, paramInt7, 3);
              paramInt2 = paramInt1;
            }
          }
          paramLinearSystem.addEquality(localSolverVariable1, localSolverVariable3, paramInt2, 3);
          paramLinearSystem.addGreaterThan(localSolverVariable3, localSolverVariable4, i, 2);
          paramLinearSystem.addLowerThan(localSolverVariable1, localSolverVariable2, -j, 2);
          paramLinearSystem.addCentering(localSolverVariable3, localSolverVariable4, i, paramFloat, localSolverVariable2, localSolverVariable1, j, 4);
          return;
        }
        if ((paramInt6 == 0) && (paramInt7 == 0))
        {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable3, localSolverVariable4, i));
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable2, j * -1));
          return;
        }
        if (paramInt7 > 0) {
          paramLinearSystem.addLowerThan(localSolverVariable1, localSolverVariable3, paramInt7, 3);
        }
        paramLinearSystem.addGreaterThan(localSolverVariable3, localSolverVariable4, i, 2);
        paramLinearSystem.addLowerThan(localSolverVariable1, localSolverVariable2, -j, 2);
        paramLinearSystem.addCentering(localSolverVariable3, localSolverVariable4, i, paramFloat, localSolverVariable2, localSolverVariable1, j, 4);
      }
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    addToSolver(paramLinearSystem, 2147483647);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    Object localObject5 = this;
    Object localObject6 = null;
    Object localObject1;
    if ((paramInt != 2147483647) && (((ConstraintWidget)localObject5).mLeft.mGroup != paramInt)) {
      localObject1 = null;
    } else {
      localObject1 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mLeft);
    }
    Object localObject3;
    if ((paramInt != 2147483647) && (((ConstraintWidget)localObject5).mRight.mGroup != paramInt)) {
      localObject3 = null;
    } else {
      localObject3 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mRight);
    }
    if ((paramInt != 2147483647) && (((ConstraintWidget)localObject5).mTop.mGroup != paramInt)) {
      localObject2 = null;
    } else {
      localObject2 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mTop);
    }
    if ((paramInt != 2147483647) && (((ConstraintWidget)localObject5).mBottom.mGroup != paramInt)) {
      localObject4 = null;
    } else {
      localObject4 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mBottom);
    }
    if ((paramInt == 2147483647) || (((ConstraintWidget)localObject5).mBaseline.mGroup == paramInt)) {
      localObject6 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mBaseline);
    }
    boolean bool5;
    boolean bool4;
    if (((ConstraintWidget)localObject5).mParent != null)
    {
      if (((((ConstraintWidget)localObject5).mLeft.mTarget != null) && (((ConstraintWidget)localObject5).mLeft.mTarget.mTarget == ((ConstraintWidget)localObject5).mLeft)) || ((((ConstraintWidget)localObject5).mRight.mTarget != null) && (((ConstraintWidget)localObject5).mRight.mTarget.mTarget == ((ConstraintWidget)localObject5).mRight)))
      {
        ((ConstraintWidgetContainer)((ConstraintWidget)localObject5).mParent).addChain((ConstraintWidget)localObject5, 0);
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (((((ConstraintWidget)localObject5).mTop.mTarget != null) && (((ConstraintWidget)localObject5).mTop.mTarget.mTarget == ((ConstraintWidget)localObject5).mTop)) || ((((ConstraintWidget)localObject5).mBottom.mTarget != null) && (((ConstraintWidget)localObject5).mBottom.mTarget.mTarget == ((ConstraintWidget)localObject5).mBottom)))
      {
        ((ConstraintWidgetContainer)((ConstraintWidget)localObject5).mParent).addChain((ConstraintWidget)localObject5, 1);
        bool2 = true;
      }
      else
      {
        bool2 = false;
      }
      if ((((ConstraintWidget)localObject5).mParent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (!bool1))
      {
        if ((((ConstraintWidget)localObject5).mLeft.mTarget != null) && (((ConstraintWidget)localObject5).mLeft.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent))
        {
          if ((((ConstraintWidget)localObject5).mLeft.mTarget != null) && (((ConstraintWidget)localObject5).mLeft.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent)) {
            ((ConstraintWidget)localObject5).mLeft.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
          }
        }
        else
        {
          localObject7 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mParent.mLeft);
          localObject8 = paramLinearSystem.createRow();
          ((ArrayRow)localObject8).createRowGreaterThan((SolverVariable)localObject1, (SolverVariable)localObject7, paramLinearSystem.createSlackVariable(), 0);
          paramLinearSystem.addConstraint((ArrayRow)localObject8);
        }
        if ((((ConstraintWidget)localObject5).mRight.mTarget != null) && (((ConstraintWidget)localObject5).mRight.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent))
        {
          if ((((ConstraintWidget)localObject5).mRight.mTarget != null) && (((ConstraintWidget)localObject5).mRight.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent)) {
            ((ConstraintWidget)localObject5).mRight.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
          }
        }
        else
        {
          localObject7 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mParent.mRight);
          localObject8 = paramLinearSystem.createRow();
          ((ArrayRow)localObject8).createRowGreaterThan((SolverVariable)localObject7, (SolverVariable)localObject3, paramLinearSystem.createSlackVariable(), 0);
          paramLinearSystem.addConstraint((ArrayRow)localObject8);
        }
      }
      if ((((ConstraintWidget)localObject5).mParent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (!bool2))
      {
        if ((((ConstraintWidget)localObject5).mTop.mTarget != null) && (((ConstraintWidget)localObject5).mTop.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent))
        {
          if ((((ConstraintWidget)localObject5).mTop.mTarget != null) && (((ConstraintWidget)localObject5).mTop.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent)) {
            ((ConstraintWidget)localObject5).mTop.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
          }
        }
        else
        {
          localObject7 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mParent.mTop);
          localObject8 = paramLinearSystem.createRow();
          ((ArrayRow)localObject8).createRowGreaterThan((SolverVariable)localObject2, (SolverVariable)localObject7, paramLinearSystem.createSlackVariable(), 0);
          paramLinearSystem.addConstraint((ArrayRow)localObject8);
        }
        if ((((ConstraintWidget)localObject5).mBottom.mTarget != null) && (((ConstraintWidget)localObject5).mBottom.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent))
        {
          if ((((ConstraintWidget)localObject5).mBottom.mTarget != null) && (((ConstraintWidget)localObject5).mBottom.mTarget.mOwner == ((ConstraintWidget)localObject5).mParent)) {
            ((ConstraintWidget)localObject5).mBottom.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
          }
        }
        else
        {
          localObject7 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mParent.mBottom);
          localObject8 = paramLinearSystem.createRow();
          ((ArrayRow)localObject8).createRowGreaterThan((SolverVariable)localObject7, (SolverVariable)localObject4, paramLinearSystem.createSlackVariable(), 0);
          paramLinearSystem.addConstraint((ArrayRow)localObject8);
        }
      }
      bool5 = bool1;
      bool4 = bool2;
    }
    else
    {
      bool5 = false;
      bool4 = false;
    }
    int j = ((ConstraintWidget)localObject5).mWidth;
    int k = ((ConstraintWidget)localObject5).mMinWidth;
    int i = j;
    if (j < k) {
      i = k;
    }
    k = ((ConstraintWidget)localObject5).mHeight;
    int m = ((ConstraintWidget)localObject5).mMinHeight;
    j = k;
    if (k < m) {
      j = m;
    }
    if (((ConstraintWidget)localObject5).mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (((ConstraintWidget)localObject5).mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      localObject7 = ((ConstraintWidget)localObject5).mLeft;
      bool1 = bool2;
      if (localObject7 != null)
      {
        bool1 = bool2;
        if (((ConstraintWidget)localObject5).mRight != null) {
          if (((ConstraintAnchor)localObject7).mTarget != null)
          {
            bool1 = bool2;
            if (((ConstraintWidget)localObject5).mRight.mTarget != null) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    boolean bool2 = bool3;
    if (!bool3)
    {
      localObject7 = ((ConstraintWidget)localObject5).mTop;
      bool2 = bool3;
      if (localObject7 != null)
      {
        bool2 = bool3;
        if (((ConstraintWidget)localObject5).mBottom != null) {
          if (((ConstraintAnchor)localObject7).mTarget != null)
          {
            bool2 = bool3;
            if (((ConstraintWidget)localObject5).mBottom.mTarget != null) {}
          }
          else
          {
            if (((ConstraintWidget)localObject5).mBaselineDistance != 0)
            {
              bool2 = bool3;
              if (((ConstraintWidget)localObject5).mBaseline == null) {
                break label1163;
              }
              if (((ConstraintWidget)localObject5).mTop.mTarget != null)
              {
                bool2 = bool3;
                if (((ConstraintWidget)localObject5).mBaseline.mTarget != null) {
                  break label1163;
                }
              }
            }
            bool2 = true;
          }
        }
      }
    }
    label1163:
    m = ((ConstraintWidget)localObject5).mDimensionRatioSide;
    float f1 = ((ConstraintWidget)localObject5).mDimensionRatio;
    float f2;
    if ((f1 > 0.0F) && (((ConstraintWidget)localObject5).mVisibility != 8))
    {
      if ((((ConstraintWidget)localObject5).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (((ConstraintWidget)localObject5).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        if ((bool1) && (!bool2))
        {
          k = 0;
        }
        else if ((!bool1) && (bool2))
        {
          if (((ConstraintWidget)localObject5).mDimensionRatioSide == -1) {
            f1 = 1.0F / f1;
          }
          k = 1;
        }
        else
        {
          k = m;
        }
        n = 1;
        m = k;
        k = n;
        break label1396;
      }
      if (((ConstraintWidget)localObject5).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        n = (int)(((ConstraintWidget)localObject5).mHeight * f1);
        i = j;
        bool1 = bool2;
        bool2 = true;
        j = 0;
        k = 0;
        break label1420;
      }
      if (((ConstraintWidget)localObject5).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        f2 = f1;
        if (((ConstraintWidget)localObject5).mDimensionRatioSide == -1) {
          f2 = 1.0F / f1;
        }
        j = (int)(((ConstraintWidget)localObject5).mWidth * f2);
        n = i;
        i = j;
        f1 = f2;
        j = 1;
        k = 0;
        bool3 = true;
        bool2 = bool1;
        bool1 = bool3;
        break label1420;
      }
    }
    k = 0;
    label1396:
    int n = i;
    i = j;
    boolean bool3 = bool1;
    bool1 = bool2;
    j = m;
    bool2 = bool3;
    label1420:
    if ((k != 0) && ((j == 0) || (j == -1))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool6;
    if ((((ConstraintWidget)localObject5).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localObject5 instanceof ConstraintWidgetContainer))) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    SolverVariable localSolverVariable1;
    SolverVariable localSolverVariable2;
    if (((ConstraintWidget)localObject5).mHorizontalResolution != 2)
    {
      if ((paramInt != 2147483647) && ((((ConstraintWidget)localObject5).mLeft.mGroup != paramInt) || (((ConstraintWidget)localObject5).mRight.mGroup != paramInt))) {
        break label1752;
      }
      if ((bool3) && (((ConstraintWidget)localObject5).mLeft.mTarget != null) && (((ConstraintWidget)localObject5).mRight.mTarget != null))
      {
        localObject7 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mLeft);
        localObject8 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mRight);
        localSolverVariable1 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mLeft.getTarget());
        localSolverVariable2 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mRight.getTarget());
        paramLinearSystem.addGreaterThan((SolverVariable)localObject7, localSolverVariable1, ((ConstraintWidget)localObject5).mLeft.getMargin(), 3);
        paramLinearSystem.addLowerThan((SolverVariable)localObject8, localSolverVariable2, ((ConstraintWidget)localObject5).mRight.getMargin() * -1, 3);
        if (!bool5) {
          paramLinearSystem.addCentering((SolverVariable)localObject7, localSolverVariable1, ((ConstraintWidget)localObject5).mLeft.getMargin(), ((ConstraintWidget)localObject5).mHorizontalBiasPercent, localSolverVariable2, (SolverVariable)localObject8, ((ConstraintWidget)localObject5).mRight.getMargin(), 4);
        }
      }
      else
      {
        localObject7 = ((ConstraintWidget)localObject5).mLeft;
        localObject8 = ((ConstraintWidget)localObject5).mRight;
        m = ((ConstraintWidget)localObject5).mX;
        applyConstraints(paramLinearSystem, bool6, bool2, (ConstraintAnchor)localObject7, (ConstraintAnchor)localObject8, m, m + n, n, ((ConstraintWidget)localObject5).mMinWidth, ((ConstraintWidget)localObject5).mHorizontalBiasPercent, bool3, bool5, ((ConstraintWidget)localObject5).mMatchConstraintDefaultWidth, ((ConstraintWidget)localObject5).mMatchConstraintMinWidth, ((ConstraintWidget)localObject5).mMatchConstraintMaxWidth);
      }
    }
    label1752:
    localObject5 = localObject2;
    Object localObject2 = localObject4;
    Object localObject4 = localObject3;
    Object localObject7 = localObject1;
    Object localObject8 = this;
    if (((ConstraintWidget)localObject8).mVerticalResolution == 2) {
      return;
    }
    if ((((ConstraintWidget)localObject8).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localObject8 instanceof ConstraintWidgetContainer))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (k != 0)
    {
      m = j;
      if (m != 1) {
        if (m != -1) {
          break label1839;
        }
      }
      bool3 = true;
      break label1842;
    }
    label1839:
    bool3 = false;
    label1842:
    if (((ConstraintWidget)localObject8).mBaselineDistance > 0)
    {
      localObject3 = ((ConstraintWidget)localObject8).mBottom;
      if ((paramInt != 2147483647) && ((((ConstraintAnchor)localObject3).mGroup != paramInt) || (((ConstraintWidget)localObject8).mBaseline.mGroup != paramInt))) {
        break label1905;
      }
      paramLinearSystem.addEquality((SolverVariable)localObject6, (SolverVariable)localObject5, getBaselineDistance(), 5);
      label1905:
      localObject6 = paramLinearSystem;
      localObject1 = localObject5;
      if (((ConstraintWidget)localObject8).mBaseline.mTarget != null)
      {
        m = ((ConstraintWidget)localObject8).mBaselineDistance;
        localObject3 = ((ConstraintWidget)localObject8).mBaseline;
      }
      else
      {
        m = i;
      }
      if ((paramInt != 2147483647) && ((((ConstraintWidget)localObject8).mTop.mGroup != paramInt) || (((ConstraintAnchor)localObject3).mGroup != paramInt))) {
        break label2271;
      }
      if ((bool3) && (((ConstraintWidget)localObject8).mTop.mTarget != null) && (((ConstraintWidget)localObject8).mBottom.mTarget != null))
      {
        localObject3 = ((LinearSystem)localObject6).createObjectVariable(((ConstraintWidget)localObject8).mTop);
        localObject5 = ((LinearSystem)localObject6).createObjectVariable(((ConstraintWidget)localObject8).mBottom);
        localSolverVariable1 = ((LinearSystem)localObject6).createObjectVariable(((ConstraintWidget)localObject8).mTop.getTarget());
        localSolverVariable2 = ((LinearSystem)localObject6).createObjectVariable(((ConstraintWidget)localObject8).mBottom.getTarget());
        ((LinearSystem)localObject6).addGreaterThan((SolverVariable)localObject3, localSolverVariable1, ((ConstraintWidget)localObject8).mTop.getMargin(), 3);
        ((LinearSystem)localObject6).addLowerThan((SolverVariable)localObject5, localSolverVariable2, ((ConstraintWidget)localObject8).mBottom.getMargin() * -1, 3);
        if (!bool4) {
          paramLinearSystem.addCentering((SolverVariable)localObject3, localSolverVariable1, ((ConstraintWidget)localObject8).mTop.getMargin(), ((ConstraintWidget)localObject8).mVerticalBiasPercent, localSolverVariable2, (SolverVariable)localObject5, ((ConstraintWidget)localObject8).mBottom.getMargin(), 4);
        }
      }
      else
      {
        localObject5 = ((ConstraintWidget)localObject8).mTop;
        n = ((ConstraintWidget)localObject8).mY;
        applyConstraints(paramLinearSystem, bool2, bool1, (ConstraintAnchor)localObject5, (ConstraintAnchor)localObject3, n, n + m, m, ((ConstraintWidget)localObject8).mMinHeight, ((ConstraintWidget)localObject8).mVerticalBiasPercent, bool3, bool4, ((ConstraintWidget)localObject8).mMatchConstraintDefaultHeight, ((ConstraintWidget)localObject8).mMatchConstraintMinHeight, ((ConstraintWidget)localObject8).mMatchConstraintMaxHeight);
        paramLinearSystem.addEquality((SolverVariable)localObject2, (SolverVariable)localObject1, i, 5);
      }
    }
    else
    {
      localObject3 = localObject5;
      if (paramInt == 2147483647) {
        break label2274;
      }
      localObject5 = this;
      localObject1 = localObject3;
      if (((ConstraintWidget)localObject5).mTop.mGroup == paramInt)
      {
        localObject1 = localObject3;
        if (((ConstraintWidget)localObject5).mBottom.mGroup == paramInt) {
          break label2274;
        }
      }
    }
    for (;;)
    {
      label2271:
      break;
      label2274:
      localObject5 = this;
      if ((bool3) && (((ConstraintWidget)localObject5).mTop.mTarget != null) && (((ConstraintWidget)localObject5).mBottom.mTarget != null))
      {
        localObject6 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mTop);
        localObject8 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mBottom);
        localSolverVariable1 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mTop.getTarget());
        localSolverVariable2 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject5).mBottom.getTarget());
        paramLinearSystem.addGreaterThan((SolverVariable)localObject6, localSolverVariable1, ((ConstraintWidget)localObject5).mTop.getMargin(), 3);
        paramLinearSystem.addLowerThan((SolverVariable)localObject8, localSolverVariable2, ((ConstraintWidget)localObject5).mBottom.getMargin() * -1, 3);
        localObject1 = localObject3;
        if (!bool4)
        {
          paramLinearSystem.addCentering((SolverVariable)localObject6, localSolverVariable1, ((ConstraintWidget)localObject5).mTop.getMargin(), ((ConstraintWidget)localObject5).mVerticalBiasPercent, localSolverVariable2, (SolverVariable)localObject8, ((ConstraintWidget)localObject5).mBottom.getMargin(), 4);
          localObject1 = localObject3;
        }
      }
      else
      {
        localObject6 = ((ConstraintWidget)localObject5).mTop;
        localObject8 = ((ConstraintWidget)localObject5).mBottom;
        m = ((ConstraintWidget)localObject5).mY;
        n = ((ConstraintWidget)localObject5).mMinHeight;
        f2 = ((ConstraintWidget)localObject5).mVerticalBiasPercent;
        int i1 = ((ConstraintWidget)localObject5).mMatchConstraintDefaultHeight;
        int i2 = ((ConstraintWidget)localObject5).mMatchConstraintMinHeight;
        int i3 = ((ConstraintWidget)localObject5).mMatchConstraintMaxHeight;
        localObject1 = localObject3;
        applyConstraints(paramLinearSystem, bool2, bool1, (ConstraintAnchor)localObject6, (ConstraintAnchor)localObject8, m, m + i, i, n, f2, bool3, bool4, i1, i2, i3);
      }
    }
    if (k != 0)
    {
      localObject5 = paramLinearSystem.createRow();
      if (paramInt != 2147483647)
      {
        localObject3 = this;
        if ((((ConstraintWidget)localObject3).mLeft.mGroup != paramInt) || (((ConstraintWidget)localObject3).mRight.mGroup != paramInt)) {
          return;
        }
      }
      localObject3 = this;
      if (j == 0)
      {
        paramLinearSystem.addConstraint(((ArrayRow)localObject5).createRowDimensionRatio((SolverVariable)localObject4, (SolverVariable)localObject7, (SolverVariable)localObject2, (SolverVariable)localObject1, f1));
        return;
      }
      if (j == 1)
      {
        paramLinearSystem.addConstraint(((ArrayRow)localObject5).createRowDimensionRatio((SolverVariable)localObject2, (SolverVariable)localObject1, (SolverVariable)localObject4, (SolverVariable)localObject7, f1));
        return;
      }
      paramInt = ((ConstraintWidget)localObject3).mMatchConstraintMinWidth;
      if (paramInt > 0) {
        paramLinearSystem.addGreaterThan((SolverVariable)localObject4, (SolverVariable)localObject7, paramInt, 3);
      }
      paramInt = ((ConstraintWidget)localObject3).mMatchConstraintMinHeight;
      if (paramInt > 0) {
        paramLinearSystem.addGreaterThan((SolverVariable)localObject2, (SolverVariable)localObject1, paramInt, 3);
      }
      ((ArrayRow)localObject5).createRowDimensionRatio((SolverVariable)localObject4, (SolverVariable)localObject7, (SolverVariable)localObject2, (SolverVariable)localObject1, f1);
      localObject1 = paramLinearSystem.createErrorVariable();
      localObject2 = paramLinearSystem.createErrorVariable();
      ((SolverVariable)localObject1).strength = 4;
      ((SolverVariable)localObject2).strength = 4;
      ((ArrayRow)localObject5).addError((SolverVariable)localObject1, (SolverVariable)localObject2);
      paramLinearSystem.addConstraint((ArrayRow)localObject5);
      return;
    }
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2)
  {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    Object localObject = ConstraintAnchor.Type.CENTER;
    int i = 0;
    if (paramType1 == localObject)
    {
      if (paramType2 == ConstraintAnchor.Type.CENTER)
      {
        paramType1 = getAnchor(ConstraintAnchor.Type.LEFT);
        paramType2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        localObject = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor localConstraintAnchor = getAnchor(ConstraintAnchor.Type.BOTTOM);
        i = 1;
        if (((paramType1 != null) && (paramType1.isConnected())) || ((paramType2 != null) && (paramType2.isConnected())))
        {
          paramInt1 = 0;
        }
        else
        {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, ConstraintAnchor.Type.LEFT, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, ConstraintAnchor.Type.RIGHT, 0, paramStrength, paramInt2);
          paramInt1 = 1;
        }
        if (((localObject != null) && (((ConstraintAnchor)localObject).isConnected())) || ((localConstraintAnchor != null) && (localConstraintAnchor.isConnected())))
        {
          i = 0;
        }
        else
        {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, ConstraintAnchor.Type.TOP, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, ConstraintAnchor.Type.BOTTOM, 0, paramStrength, paramInt2);
        }
        if ((paramInt1 != 0) && (i != 0))
        {
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, paramInt2);
          return;
        }
        if (paramInt1 != 0)
        {
          getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, paramInt2);
          return;
        }
        if (i == 0) {
          break label956;
        }
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, paramInt2);
        return;
      }
      if ((paramType2 != ConstraintAnchor.Type.LEFT) && (paramType2 != ConstraintAnchor.Type.RIGHT))
      {
        if ((paramType2 != ConstraintAnchor.Type.TOP) && (paramType2 != ConstraintAnchor.Type.BOTTOM)) {
          break label956;
        }
        connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
        connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
        return;
      }
      connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      paramType1 = ConstraintAnchor.Type.RIGHT;
    }
    try
    {
      connect(paramType1, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      return;
    }
    catch (Throwable paramType1) {}
    if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && ((paramType2 == ConstraintAnchor.Type.LEFT) || (paramType2 == ConstraintAnchor.Type.RIGHT)))
    {
      paramType1 = getAnchor(ConstraintAnchor.Type.LEFT);
      paramConstraintWidget = paramConstraintWidget.getAnchor(paramType2);
      paramType2 = getAnchor(ConstraintAnchor.Type.RIGHT);
      paramType1.connect(paramConstraintWidget, 0, paramInt2);
      paramType2.connect(paramConstraintWidget, 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget, 0, paramInt2);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && ((paramType2 == ConstraintAnchor.Type.TOP) || (paramType2 == ConstraintAnchor.Type.BOTTOM)))
    {
      paramType1 = paramConstraintWidget.getAnchor(paramType2);
      getAnchor(ConstraintAnchor.Type.TOP).connect(paramType1, 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramType1, 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramType1, 0, paramInt2);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && (paramType2 == ConstraintAnchor.Type.CENTER_X))
    {
      getAnchor(ConstraintAnchor.Type.LEFT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.RIGHT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && (paramType2 == ConstraintAnchor.Type.CENTER_Y))
    {
      getAnchor(ConstraintAnchor.Type.TOP).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      return;
    }
    localObject = getAnchor(paramType1);
    paramConstraintWidget = paramConstraintWidget.getAnchor(paramType2);
    if (((ConstraintAnchor)localObject).isValidConnection(paramConstraintWidget))
    {
      if (paramType1 == ConstraintAnchor.Type.BASELINE)
      {
        paramType1 = getAnchor(ConstraintAnchor.Type.TOP);
        paramType2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (paramType1 != null) {
          paramType1.reset();
        }
        paramInt1 = i;
        if (paramType2 != null)
        {
          paramType2.reset();
          paramInt1 = i;
        }
      }
      for (;;)
      {
        break;
        if ((paramType1 != ConstraintAnchor.Type.TOP) && (paramType1 != ConstraintAnchor.Type.BOTTOM))
        {
          if ((paramType1 == ConstraintAnchor.Type.LEFT) || (paramType1 == ConstraintAnchor.Type.RIGHT))
          {
            paramType2 = getAnchor(ConstraintAnchor.Type.CENTER);
            if (paramType2.getTarget() != paramConstraintWidget) {
              paramType2.reset();
            }
            paramType1 = getAnchor(paramType1).getOpposite();
            paramType2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            if (paramType2.isConnected())
            {
              paramType1.reset();
              paramType2.reset();
            }
          }
        }
        else
        {
          paramType2 = getAnchor(ConstraintAnchor.Type.BASELINE);
          if (paramType2 != null) {
            paramType2.reset();
          }
          paramType2 = getAnchor(ConstraintAnchor.Type.CENTER);
          if (paramType2.getTarget() != paramConstraintWidget) {
            paramType2.reset();
          }
          paramType1 = getAnchor(paramType1).getOpposite();
          paramType2 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
          if (paramType2.isConnected())
          {
            paramType1.reset();
            paramType2.reset();
          }
        }
      }
      ((ConstraintAnchor)localObject).connect(paramConstraintWidget, paramInt1, paramStrength, paramInt2);
      paramConstraintWidget.getOwner().connectedTo(((ConstraintAnchor)localObject).getOwner());
    }
    label956:
    return;
    for (;;)
    {
      throw paramType1;
    }
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    if (paramConstraintAnchor1.getOwner() == this) {
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2);
    }
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(i);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget) && (localConstraintAnchor.getConnectionCreator() == 2)) {
        localConstraintAnchor.reset();
      }
      i += 1;
    }
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(i);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget)) {
        localConstraintAnchor.reset();
      }
      i += 1;
    }
  }
  
  public void forceUpdateDrawPosition()
  {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = (k + i - i);
    this.mDrawHeight = (m + j - j);
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (ConstraintWidget.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      return null;
    case 8: 
      return this.mCenter;
    case 7: 
      return this.mCenterY;
    case 6: 
      return this.mCenterX;
    case 5: 
      return this.mBaseline;
    case 4: 
      return this.mBottom;
    case 3: 
      return this.mRight;
    case 2: 
      return this.mTop;
    }
    return this.mLeft;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return this.mAnchors;
  }
  
  public int getBaselineDistance()
  {
    return this.mBaselineDistance;
  }
  
  public int getBottom()
  {
    return getY() + this.mHeight;
  }
  
  public Object getCompanionWidget()
  {
    return this.mCompanionWidget;
  }
  
  public int getContainerItemSkip()
  {
    return this.mContainerItemSkip;
  }
  
  public String getDebugName()
  {
    return this.mDebugName;
  }
  
  public float getDimensionRatio()
  {
    return this.mDimensionRatio;
  }
  
  public int getDimensionRatioSide()
  {
    return this.mDimensionRatioSide;
  }
  
  public int getDrawBottom()
  {
    return getDrawY() + this.mDrawHeight;
  }
  
  public int getDrawHeight()
  {
    return this.mDrawHeight;
  }
  
  public int getDrawRight()
  {
    return getDrawX() + this.mDrawWidth;
  }
  
  public int getDrawWidth()
  {
    return this.mDrawWidth;
  }
  
  public int getDrawX()
  {
    return this.mDrawX + this.mOffsetX;
  }
  
  public int getDrawY()
  {
    return this.mDrawY + this.mOffsetY;
  }
  
  public int getHeight()
  {
    if (this.mVisibility == 8) {
      return 0;
    }
    return this.mHeight;
  }
  
  public float getHorizontalBiasPercent()
  {
    return this.mHorizontalBiasPercent;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget()
  {
    if (isInHorizontalChain())
    {
      Object localObject1 = this;
      Object localObject2 = null;
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject3 = localObject2;
        if (localObject1 == null) {
          break;
        }
        localObject3 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.LEFT);
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getTarget();
        }
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getOwner();
        }
        if (localObject3 == getParent()) {
          return localObject1;
        }
        ConstraintAnchor localConstraintAnchor;
        if (localObject3 == null) {
          localConstraintAnchor = null;
        } else {
          localConstraintAnchor = ((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        }
        if ((localConstraintAnchor != null) && (localConstraintAnchor.getOwner() != localObject1)) {
          localObject2 = localObject1;
        } else {
          localObject1 = localObject3;
        }
      }
    }
    Object localObject3 = null;
    return localObject3;
  }
  
  public int getHorizontalChainStyle()
  {
    return this.mHorizontalChainStyle;
  }
  
  public ConstraintWidget.DimensionBehaviour getHorizontalDimensionBehaviour()
  {
    return this.mHorizontalDimensionBehaviour;
  }
  
  public int getInternalDrawBottom()
  {
    return this.mDrawY + this.mDrawHeight;
  }
  
  public int getInternalDrawRight()
  {
    return this.mDrawX + this.mDrawWidth;
  }
  
  int getInternalDrawX()
  {
    return this.mDrawX;
  }
  
  int getInternalDrawY()
  {
    return this.mDrawY;
  }
  
  public int getLeft()
  {
    return getX();
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizerWrapHeight()
  {
    int i = this.mHeight;
    int j = i;
    if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (this.mMatchConstraintDefaultHeight == 1)
      {
        i = Math.max(this.mMatchConstraintMinHeight, i);
      }
      else
      {
        i = this.mMatchConstraintMinHeight;
        if (i > 0) {
          this.mHeight = i;
        } else {
          i = 0;
        }
      }
      int k = this.mMatchConstraintMaxHeight;
      j = i;
      if (k > 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
    }
    return j;
  }
  
  public int getOptimizerWrapWidth()
  {
    int i = this.mWidth;
    int j = i;
    if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (this.mMatchConstraintDefaultWidth == 1)
      {
        i = Math.max(this.mMatchConstraintMinWidth, i);
      }
      else
      {
        i = this.mMatchConstraintMinWidth;
        if (i > 0) {
          this.mWidth = i;
        } else {
          i = 0;
        }
      }
      int k = this.mMatchConstraintMaxWidth;
      j = i;
      if (k > 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
    }
    return j;
  }
  
  public ConstraintWidget getParent()
  {
    return this.mParent;
  }
  
  public int getRight()
  {
    return getX() + this.mWidth;
  }
  
  public WidgetContainer getRootWidgetContainer()
  {
    for (ConstraintWidget localConstraintWidget = this; localConstraintWidget.getParent() != null; localConstraintWidget = localConstraintWidget.getParent()) {}
    if ((localConstraintWidget instanceof WidgetContainer)) {
      return (WidgetContainer)localConstraintWidget;
    }
    return null;
  }
  
  protected int getRootX()
  {
    return this.mX + this.mOffsetX;
  }
  
  protected int getRootY()
  {
    return this.mY + this.mOffsetY;
  }
  
  public int getTop()
  {
    return getY();
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public float getVerticalBiasPercent()
  {
    return this.mVerticalBiasPercent;
  }
  
  public ConstraintWidget getVerticalChainControlWidget()
  {
    if (isInVerticalChain())
    {
      Object localObject1 = this;
      Object localObject2 = null;
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject3 = localObject2;
        if (localObject1 == null) {
          break;
        }
        localObject3 = ((ConstraintWidget)localObject1).getAnchor(ConstraintAnchor.Type.TOP);
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getTarget();
        }
        if (localObject3 == null) {
          localObject3 = null;
        } else {
          localObject3 = ((ConstraintAnchor)localObject3).getOwner();
        }
        if (localObject3 == getParent()) {
          return localObject1;
        }
        ConstraintAnchor localConstraintAnchor;
        if (localObject3 == null) {
          localConstraintAnchor = null;
        } else {
          localConstraintAnchor = ((ConstraintWidget)localObject3).getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        }
        if ((localConstraintAnchor != null) && (localConstraintAnchor.getOwner() != localObject1)) {
          localObject2 = localObject1;
        } else {
          localObject1 = localObject3;
        }
      }
    }
    Object localObject3 = null;
    return localObject3;
  }
  
  public int getVerticalChainStyle()
  {
    return this.mVerticalChainStyle;
  }
  
  public ConstraintWidget.DimensionBehaviour getVerticalDimensionBehaviour()
  {
    return this.mVerticalDimensionBehaviour;
  }
  
  public int getVisibility()
  {
    return this.mVisibility;
  }
  
  public int getWidth()
  {
    if (this.mVisibility == 8) {
      return 0;
    }
    return this.mWidth;
  }
  
  public int getWrapHeight()
  {
    return this.mWrapHeight;
  }
  
  public int getWrapWidth()
  {
    return this.mWrapWidth;
  }
  
  public int getX()
  {
    return this.mX;
  }
  
  public int getY()
  {
    return this.mY;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget localConstraintWidget2 = getParent();
    if (localConstraintWidget2 == paramConstraintWidget) {
      return true;
    }
    ConstraintWidget localConstraintWidget1 = localConstraintWidget2;
    if (localConstraintWidget2 == paramConstraintWidget.getParent()) {
      return false;
    }
    while (localConstraintWidget1 != null)
    {
      if (localConstraintWidget1 == paramConstraintWidget) {
        return true;
      }
      if (localConstraintWidget1 == paramConstraintWidget.getParent()) {
        return true;
      }
      localConstraintWidget1 = localConstraintWidget1.getParent();
    }
    return false;
  }
  
  public boolean hasBaseline()
  {
    return this.mBaselineDistance > 0;
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2)
  {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isInHorizontalChain()
  {
    return ((this.mLeft.mTarget != null) && (this.mLeft.mTarget.mTarget == this.mLeft)) || ((this.mRight.mTarget != null) && (this.mRight.mTarget.mTarget == this.mRight));
  }
  
  public boolean isInVerticalChain()
  {
    return ((this.mTop.mTarget != null) && (this.mTop.mTarget.mTarget == this.mTop)) || ((this.mBottom.mTarget != null) && (this.mBottom.mTarget.mTarget == this.mBottom));
  }
  
  public boolean isInsideConstraintLayout()
  {
    ConstraintWidget localConstraintWidget2 = getParent();
    ConstraintWidget localConstraintWidget1 = localConstraintWidget2;
    if (localConstraintWidget2 == null) {
      return false;
    }
    while (localConstraintWidget1 != null)
    {
      if ((localConstraintWidget1 instanceof ConstraintWidgetContainer)) {
        return true;
      }
      localConstraintWidget1 = localConstraintWidget1.getParent();
    }
    return false;
  }
  
  public boolean isRoot()
  {
    return this.mParent == null;
  }
  
  public boolean isRootContainer()
  {
    if ((this instanceof ConstraintWidgetContainer))
    {
      ConstraintWidget localConstraintWidget = this.mParent;
      if ((localConstraintWidget == null) || (!(localConstraintWidget instanceof ConstraintWidgetContainer))) {
        return true;
      }
    }
    return false;
  }
  
  public void reset()
  {
    this.mLeft.reset();
    this.mTop.reset();
    this.mRight.reset();
    this.mBottom.reset();
    this.mBaseline.reset();
    this.mCenterX.reset();
    this.mCenterY.reset();
    this.mCenter.reset();
    this.mParent = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mDrawX = 0;
    this.mDrawY = 0;
    this.mDrawWidth = 0;
    this.mDrawHeight = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.mWrapWidth = 0;
    this.mWrapHeight = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mCompanionWidget = null;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mHorizontalWrapVisited = false;
    this.mVerticalWrapVisited = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalChainFixedPosition = false;
    this.mVerticalChainFixedPosition = false;
    this.mHorizontalWeight = 0.0F;
    this.mVerticalWeight = 0.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
  }
  
  public void resetAllConstraints()
  {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if ((this instanceof ConstraintWidgetContainer)) {
      return;
    }
    if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      if (getWidth() == getWrapWidth()) {
        setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
      } else if (getWidth() > getMinWidth()) {
        setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
    }
    if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      if (getHeight() == getWrapHeight())
      {
        setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
      }
      if (getHeight() > getMinHeight()) {
        setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
    }
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor)
  {
    if ((getParent() != null) && ((getParent() instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    ConstraintAnchor localConstraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor localConstraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor localConstraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor localConstraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor localConstraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor localConstraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor localConstraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == localConstraintAnchor5)
    {
      if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget()))
      {
        localConstraintAnchor1.reset();
        localConstraintAnchor2.reset();
      }
      if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget()))
      {
        localConstraintAnchor3.reset();
        localConstraintAnchor4.reset();
      }
      this.mHorizontalBiasPercent = 0.5F;
      this.mVerticalBiasPercent = 0.5F;
    }
    else if (paramConstraintAnchor == localConstraintAnchor6)
    {
      if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget().getOwner() == localConstraintAnchor2.getTarget().getOwner()))
      {
        localConstraintAnchor1.reset();
        localConstraintAnchor2.reset();
      }
      this.mHorizontalBiasPercent = 0.5F;
    }
    else if (paramConstraintAnchor == localConstraintAnchor7)
    {
      if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget().getOwner() == localConstraintAnchor4.getTarget().getOwner()))
      {
        localConstraintAnchor3.reset();
        localConstraintAnchor4.reset();
      }
      this.mVerticalBiasPercent = 0.5F;
    }
    else if ((paramConstraintAnchor != localConstraintAnchor1) && (paramConstraintAnchor != localConstraintAnchor2))
    {
      if (((paramConstraintAnchor == localConstraintAnchor3) || (paramConstraintAnchor == localConstraintAnchor4)) && (localConstraintAnchor3.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget())) {
        localConstraintAnchor5.reset();
      }
    }
    else if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget()))
    {
      localConstraintAnchor5.reset();
    }
    paramConstraintAnchor.reset();
  }
  
  public void resetAnchors()
  {
    ConstraintWidget localConstraintWidget = getParent();
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i = 0;
    int j = this.mAnchors.size();
    while (i < j)
    {
      ((ConstraintAnchor)this.mAnchors.get(i)).reset();
      i += 1;
    }
  }
  
  public void resetAnchors(int paramInt)
  {
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i = 0;
    int j = this.mAnchors.size();
    while (i < j)
    {
      localObject = (ConstraintAnchor)this.mAnchors.get(i);
      if (paramInt == ((ConstraintAnchor)localObject).getConnectionCreator())
      {
        if (((ConstraintAnchor)localObject).isVerticalAnchor()) {
          setVerticalBiasPercent(DEFAULT_BIAS);
        } else {
          setHorizontalBiasPercent(DEFAULT_BIAS);
        }
        ((ConstraintAnchor)localObject).reset();
      }
      i += 1;
    }
  }
  
  public void resetGroups()
  {
    int j = this.mAnchors.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintAnchor)this.mAnchors.get(i)).mGroup = 2147483647;
      i += 1;
    }
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    this.mLeft.resetSolverVariable(paramCache);
    this.mTop.resetSolverVariable(paramCache);
    this.mRight.resetSolverVariable(paramCache);
    this.mBottom.resetSolverVariable(paramCache);
    this.mBaseline.resetSolverVariable(paramCache);
    this.mCenter.resetSolverVariable(paramCache);
    this.mCenterX.resetSolverVariable(paramCache);
    this.mCenterY.resetSolverVariable(paramCache);
  }
  
  public void setBaselineDistance(int paramInt)
  {
    this.mBaselineDistance = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject)
  {
    this.mCompanionWidget = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.mContainerItemSkip = paramInt;
      return;
    }
    this.mContainerItemSkip = 0;
  }
  
  public void setDebugName(String paramString)
  {
    this.mDebugName = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    this.mDebugName = paramString;
    Object localObject4 = paramLinearSystem.createObjectVariable(this.mLeft);
    Object localObject3 = paramLinearSystem.createObjectVariable(this.mTop);
    Object localObject2 = paramLinearSystem.createObjectVariable(this.mRight);
    Object localObject1 = paramLinearSystem.createObjectVariable(this.mBottom);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".left");
    ((SolverVariable)localObject4).setName(localStringBuilder.toString());
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(".top");
    ((SolverVariable)localObject3).setName(((StringBuilder)localObject4).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(".right");
    ((SolverVariable)localObject2).setName(((StringBuilder)localObject3).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".bottom");
    ((SolverVariable)localObject1).setName(((StringBuilder)localObject2).toString());
    if (this.mBaselineDistance > 0)
    {
      paramLinearSystem = paramLinearSystem.createObjectVariable(this.mBaseline);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(".baseline");
      paramLinearSystem.setName(((StringBuilder)localObject1).toString());
    }
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    paramInt1 = this.mWidth;
    int i = this.mMinWidth;
    if (paramInt1 < i) {
      this.mWidth = i;
    }
    this.mHeight = paramInt2;
    paramInt1 = this.mHeight;
    paramInt2 = this.mMinHeight;
    if (paramInt1 < paramInt2) {
      this.mHeight = paramInt2;
    }
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt)
  {
    this.mDimensionRatio = paramFloat;
    this.mDimensionRatioSide = paramInt;
  }
  
  public void setDimensionRatio(String paramString)
  {
    int i;
    int j;
    String str;
    if ((paramString != null) && (paramString.length() != 0))
    {
      int k = -1;
      int n = paramString.length();
      int i1 = paramString.indexOf(',');
      int m = 0;
      i = k;
      j = m;
      if (i1 > 0)
      {
        i = k;
        j = m;
        if (i1 < n - 1)
        {
          str = paramString.substring(0, i1);
          if (str.equalsIgnoreCase("W"))
          {
            i = 0;
          }
          else
          {
            i = k;
            if (str.equalsIgnoreCase("H")) {
              i = 1;
            }
          }
          j = i1 + 1;
        }
      }
      k = paramString.indexOf(':');
      if ((k >= 0) && (k < n - 1))
      {
        str = paramString.substring(j, k);
        paramString = paramString.substring(k + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {
          break label241;
        }
      }
    }
    try
    {
      f1 = Float.parseFloat(str);
      float f2 = Float.parseFloat(paramString);
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        break label241;
      }
      if (i == 1) {
        f1 = Math.abs(f2 / f1);
      } else {
        f1 = Math.abs(f1 / f2);
      }
    }
    catch (NumberFormatException paramString)
    {
      float f1;
      break label241;
    }
    paramString = paramString.substring(j);
    if (paramString.length() > 0) {
      f1 = Float.parseFloat(paramString);
    } else {
      label241:
      f1 = 0.0F;
    }
    if (f1 > 0.0F)
    {
      this.mDimensionRatio = f1;
      this.mDimensionRatioSide = i;
    }
    return;
    this.mDimensionRatio = 0.0F;
  }
  
  public void setDrawHeight(int paramInt)
  {
    this.mDrawHeight = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    this.mDrawX = (paramInt1 - this.mOffsetX);
    this.mDrawY = (paramInt2 - this.mOffsetY);
    this.mX = this.mDrawX;
    this.mY = this.mDrawY;
  }
  
  public void setDrawWidth(int paramInt)
  {
    this.mDrawWidth = paramInt;
  }
  
  public void setDrawX(int paramInt)
  {
    this.mDrawX = (paramInt - this.mOffsetX);
    this.mX = this.mDrawX;
  }
  
  public void setDrawY(int paramInt)
  {
    this.mDrawY = (paramInt - this.mOffsetY);
    this.mY = this.mDrawY;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    paramInt3 = paramInt4 - paramInt2;
    this.mX = paramInt1;
    this.mY = paramInt2;
    if (this.mVisibility == 8)
    {
      this.mWidth = 0;
      this.mHeight = 0;
      return;
    }
    if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)
    {
      paramInt1 = this.mWidth;
      if (i < paramInt1) {}
    }
    else
    {
      paramInt1 = i;
    }
    if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED)
    {
      paramInt2 = this.mHeight;
      if (paramInt3 < paramInt2) {}
    }
    else
    {
      paramInt2 = paramInt3;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    paramInt1 = this.mHeight;
    paramInt2 = this.mMinHeight;
    if (paramInt1 < paramInt2) {
      this.mHeight = paramInt2;
    }
    paramInt1 = this.mWidth;
    paramInt2 = this.mMinWidth;
    if (paramInt1 < paramInt2) {
      this.mWidth = paramInt2;
    }
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt)
  {
    int i = ConstraintWidget.1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.mBottom.mGoneMargin = paramInt;
          return;
        }
        this.mRight.mGoneMargin = paramInt;
        return;
      }
      this.mTop.mGoneMargin = paramInt;
      return;
    }
    this.mLeft.mGoneMargin = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
    paramInt = this.mHeight;
    int i = this.mMinHeight;
    if (paramInt < i) {
      this.mHeight = i;
    }
  }
  
  public void setHorizontalBiasPercent(float paramFloat)
  {
    this.mHorizontalBiasPercent = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt)
  {
    this.mHorizontalChainStyle = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2)
  {
    this.mX = paramInt1;
    this.mWidth = (paramInt2 - paramInt1);
    paramInt1 = this.mWidth;
    paramInt2 = this.mMinWidth;
    if (paramInt1 < paramInt2) {
      this.mWidth = paramInt2;
    }
  }
  
  public void setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour paramDimensionBehaviour)
  {
    this.mHorizontalDimensionBehaviour = paramDimensionBehaviour;
    if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      setWidth(this.mWrapWidth);
    }
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMatchConstraintDefaultWidth = paramInt1;
    this.mMatchConstraintMinWidth = paramInt2;
    this.mMatchConstraintMaxWidth = paramInt3;
  }
  
  public void setHorizontalWeight(float paramFloat)
  {
    this.mHorizontalWeight = paramFloat;
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt < 0)
    {
      this.mMinHeight = 0;
      return;
    }
    this.mMinHeight = paramInt;
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt < 0)
    {
      this.mMinWidth = 0;
      return;
    }
    this.mMinWidth = paramInt;
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    this.mOffsetX = paramInt1;
    this.mOffsetY = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2)
  {
    this.mX = paramInt1;
    this.mY = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget)
  {
    this.mParent = paramConstraintWidget;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat)
  {
    this.mVerticalBiasPercent = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt)
  {
    this.mVerticalChainStyle = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2)
  {
    this.mY = paramInt1;
    this.mHeight = (paramInt2 - paramInt1);
    paramInt1 = this.mHeight;
    paramInt2 = this.mMinHeight;
    if (paramInt1 < paramInt2) {
      this.mHeight = paramInt2;
    }
  }
  
  public void setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour paramDimensionBehaviour)
  {
    this.mVerticalDimensionBehaviour = paramDimensionBehaviour;
    if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      setHeight(this.mWrapHeight);
    }
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMatchConstraintDefaultHeight = paramInt1;
    this.mMatchConstraintMinHeight = paramInt2;
    this.mMatchConstraintMaxHeight = paramInt3;
  }
  
  public void setVerticalWeight(float paramFloat)
  {
    this.mVerticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    this.mVisibility = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    paramInt = this.mWidth;
    int i = this.mMinWidth;
    if (paramInt < i) {
      this.mWidth = i;
    }
  }
  
  public void setWrapHeight(int paramInt)
  {
    this.mWrapHeight = paramInt;
  }
  
  public void setWrapWidth(int paramInt)
  {
    this.mWrapWidth = paramInt;
  }
  
  public void setX(int paramInt)
  {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.mY = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.mType;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type: ");
      ((StringBuilder)localObject).append(this.mType);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (this.mDebugName != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id: ");
      ((StringBuilder)localObject).append(this.mDebugName);
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(this.mX);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mY);
    localStringBuilder.append(") - (");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append(" x ");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append(")");
    localStringBuilder.append(" wrap: (");
    localStringBuilder.append(this.mWrapWidth);
    localStringBuilder.append(" x ");
    localStringBuilder.append(this.mWrapHeight);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void updateDrawPosition()
  {
    int i = this.mX;
    int j = this.mY;
    int k = this.mWidth;
    int m = this.mHeight;
    this.mDrawX = i;
    this.mDrawY = j;
    this.mDrawWidth = (k + i - i);
    this.mDrawHeight = (m + j - j);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    updateFromSolver(paramLinearSystem, 2147483647);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (paramInt == 2147483647)
    {
      setFrame(paramLinearSystem.getObjectVariableValue(this.mLeft), paramLinearSystem.getObjectVariableValue(this.mTop), paramLinearSystem.getObjectVariableValue(this.mRight), paramLinearSystem.getObjectVariableValue(this.mBottom));
      return;
    }
    if (paramInt == -2)
    {
      setFrame(this.mSolverLeft, this.mSolverTop, this.mSolverRight, this.mSolverBottom);
      return;
    }
    if (this.mLeft.mGroup == paramInt) {
      this.mSolverLeft = paramLinearSystem.getObjectVariableValue(this.mLeft);
    }
    if (this.mTop.mGroup == paramInt) {
      this.mSolverTop = paramLinearSystem.getObjectVariableValue(this.mTop);
    }
    if (this.mRight.mGroup == paramInt) {
      this.mSolverRight = paramLinearSystem.getObjectVariableValue(this.mRight);
    }
    if (this.mBottom.mGroup == paramInt) {
      this.mSolverBottom = paramLinearSystem.getObjectVariableValue(this.mBottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintWidget
 * JD-Core Version:    0.7.0.1
 */