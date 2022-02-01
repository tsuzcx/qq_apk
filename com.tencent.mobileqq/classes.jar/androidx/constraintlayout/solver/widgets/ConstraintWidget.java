package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget
{
  public static final int ANCHOR_BASELINE = 4;
  public static final int ANCHOR_BOTTOM = 3;
  public static final int ANCHOR_LEFT = 0;
  public static final int ANCHOR_RIGHT = 1;
  public static final int ANCHOR_TOP = 2;
  private static final boolean AUTOTAG_CENTER = false;
  public static final int BOTH = 2;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static float DEFAULT_BIAS = 0.5F;
  static final int DIMENSION_HORIZONTAL = 0;
  static final int DIMENSION_VERTICAL = 1;
  protected static final int DIRECT = 2;
  public static final int GONE = 8;
  public static final int HORIZONTAL = 0;
  public static final int INVISIBLE = 4;
  public static final int MATCH_CONSTRAINT_PERCENT = 2;
  public static final int MATCH_CONSTRAINT_RATIO = 3;
  public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  protected static final int SOLVER = 1;
  public static final int UNKNOWN = -1;
  private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
  public static final int VERTICAL = 1;
  public static final int VISIBLE = 0;
  private static final int WRAP = -2;
  private boolean OPTIMIZE_WRAP = false;
  private boolean OPTIMIZE_WRAP_ON_RESOLVED = true;
  private boolean hasBaseline = false;
  public ChainRun horizontalChainRun;
  public int horizontalGroup;
  public HorizontalWidgetRun horizontalRun = null;
  private boolean inPlaceholder;
  public boolean[] isTerminalWidget = { 1, 1 };
  protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList();
  public ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  int mBaselineDistance = 0;
  public ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  boolean mBottomHasCentered;
  public ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  private float mCircleConstraintAngle = 0.0F;
  private Object mCompanionWidget;
  private int mContainerItemSkip;
  private String mDebugName;
  public float mDimensionRatio = 0.0F;
  protected int mDimensionRatioSide = -1;
  int mDistToBottom;
  int mDistToLeft;
  int mDistToRight;
  int mDistToTop;
  boolean mGroupsToSolver;
  int mHeight = 0;
  float mHorizontalBiasPercent;
  boolean mHorizontalChainFixedPosition;
  int mHorizontalChainStyle;
  ConstraintWidget mHorizontalNextWidget;
  public int mHorizontalResolution = -1;
  boolean mHorizontalWrapVisited;
  private boolean mInVirtuaLayout = false;
  public boolean mIsHeightWrapContent;
  private boolean[] mIsInBarrier = new boolean[2];
  public boolean mIsWidthWrapContent;
  private int mLastHorizontalMeasureSpec = 0;
  private int mLastVerticalMeasureSpec = 0;
  public ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  boolean mLeftHasCentered;
  public ConstraintAnchor[] mListAnchors = { this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter };
  public ConstraintWidget.DimensionBehaviour[] mListDimensionBehaviors = { ConstraintWidget.DimensionBehaviour.FIXED, ConstraintWidget.DimensionBehaviour.FIXED };
  protected ConstraintWidget[] mListNextMatchConstraintsWidget;
  public int mMatchConstraintDefaultHeight = 0;
  public int mMatchConstraintDefaultWidth = 0;
  public int mMatchConstraintMaxHeight = 0;
  public int mMatchConstraintMaxWidth = 0;
  public int mMatchConstraintMinHeight = 0;
  public int mMatchConstraintMinWidth = 0;
  public float mMatchConstraintPercentHeight = 1.0F;
  public float mMatchConstraintPercentWidth = 1.0F;
  private int[] mMaxDimension = { 2147483647, 2147483647 };
  private boolean mMeasureRequested = true;
  protected int mMinHeight;
  protected int mMinWidth;
  protected ConstraintWidget[] mNextChainWidget;
  protected int mOffsetX = 0;
  protected int mOffsetY = 0;
  public ConstraintWidget mParent = null;
  int mRelX = 0;
  int mRelY = 0;
  float mResolvedDimensionRatio = 1.0F;
  int mResolvedDimensionRatioSide = -1;
  boolean mResolvedHasRatio = false;
  public int[] mResolvedMatchConstraintDefault = new int[2];
  public ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  boolean mRightHasCentered;
  public ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  boolean mTopHasCentered;
  private String mType;
  float mVerticalBiasPercent;
  boolean mVerticalChainFixedPosition;
  int mVerticalChainStyle;
  ConstraintWidget mVerticalNextWidget;
  public int mVerticalResolution = -1;
  boolean mVerticalWrapVisited;
  private int mVisibility;
  public float[] mWeight;
  int mWidth = 0;
  protected int mX = 0;
  protected int mY = 0;
  public boolean measured = false;
  private boolean resolvedHorizontal = false;
  private boolean resolvedVertical = false;
  public WidgetRun[] run = new WidgetRun[2];
  public ChainRun verticalChainRun;
  public int verticalGroup;
  public VerticalWidgetRun verticalRun = null;
  
  public ConstraintWidget()
  {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mGroupsToSolver = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mNextChainWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.horizontalGroup = -1;
    this.verticalGroup = -1;
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
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mGroupsToSolver = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mNextChainWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.horizontalGroup = -1;
    this.verticalGroup = -1;
    this.mX = paramInt1;
    this.mY = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    addAnchors();
  }
  
  public ConstraintWidget(String paramString)
  {
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mDebugName = null;
    this.mType = null;
    this.mGroupsToSolver = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mWeight = new float[] { -1.0F, -1.0F };
    this.mListNextMatchConstraintsWidget = new ConstraintWidget[] { null, null };
    this.mNextChainWidget = new ConstraintWidget[] { null, null };
    this.mHorizontalNextWidget = null;
    this.mVerticalNextWidget = null;
    this.horizontalGroup = -1;
    this.verticalGroup = -1;
    addAnchors();
    setDebugName(paramString);
  }
  
  public ConstraintWidget(String paramString, int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2);
    setDebugName(paramString);
  }
  
  public ConstraintWidget(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4);
    setDebugName(paramString);
  }
  
  private void addAnchors()
  {
    this.mAnchors.add(this.mLeft);
    this.mAnchors.add(this.mTop);
    this.mAnchors.add(this.mRight);
    this.mAnchors.add(this.mBottom);
    this.mAnchors.add(this.mCenterX);
    this.mAnchors.add(this.mCenterY);
    this.mAnchors.add(this.mCenter);
    this.mAnchors.add(this.mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, ConstraintWidget.DimensionBehaviour paramDimensionBehaviour, boolean paramBoolean5, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float paramFloat2, boolean paramBoolean11)
  {
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1);
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2);
    Object localObject3 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1.getTarget());
    Object localObject1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2.getTarget());
    Object localObject2;
    if (LinearSystem.getMetrics() != null)
    {
      localObject2 = LinearSystem.getMetrics();
      ((Metrics)localObject2).nonresolvedWidgets += 1L;
    }
    boolean bool1 = paramConstraintAnchor1.isConnected();
    boolean bool2 = paramConstraintAnchor2.isConnected();
    boolean bool3 = this.mCenter.isConnected();
    if (bool1) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (bool2) {
      i = j + 1;
    }
    int k = i;
    if (bool3) {
      k = i + 1;
    }
    if (paramBoolean6) {
      paramInt5 = 3;
    }
    i = ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[paramDimensionBehaviour.ordinal()];
    if ((i == 1) || (i == 2) || (i == 3) || (i != 4)) {}
    while (paramInt5 == 4)
    {
      i = 0;
      break;
    }
    i = 1;
    int m = paramInt5;
    if (this.mVisibility == 8)
    {
      paramInt5 = 0;
      paramInt2 = 0;
    }
    else
    {
      paramInt5 = paramInt2;
      paramInt2 = i;
    }
    if (paramBoolean11) {
      if ((!bool1) && (!bool2) && (!bool3)) {
        paramLinearSystem.addEquality(localSolverVariable1, paramInt1);
      } else if ((bool1) && (!bool2)) {
        paramLinearSystem.addEquality(localSolverVariable1, (SolverVariable)localObject3, paramConstraintAnchor1.getMargin(), 8);
      }
    }
    paramDimensionBehaviour = (ConstraintWidget.DimensionBehaviour)localObject1;
    if (paramInt2 == 0)
    {
      if (paramBoolean5)
      {
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, 0, 3);
        if (paramInt3 > 0) {
          paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, paramInt3, 8);
        }
        if (paramInt4 < 2147483647) {
          paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt4, 8);
        }
      }
      else
      {
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt5, 8);
      }
      j = paramInt7;
    }
    for (paramInt1 = paramInt8;; paramInt1 = paramInt4)
    {
      i = paramInt2;
      break label836;
      if ((k != 2) && (!paramBoolean6) && ((m == 1) || (m == 0)))
      {
        paramInt2 = Math.max(paramInt7, paramInt5);
        paramInt1 = paramInt2;
        if (paramInt8 > 0) {
          paramInt1 = Math.min(paramInt8, paramInt2);
        }
        paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt1, 8);
        paramInt2 = 0;
        j = paramInt7;
      }
      for (paramInt1 = paramInt8;; paramInt1 = paramInt4)
      {
        i = paramInt2;
        break label836;
        paramInt1 = paramInt7;
        if (paramInt7 == -2) {
          paramInt1 = paramInt5;
        }
        if (paramInt8 == -2) {
          paramInt4 = paramInt5;
        } else {
          paramInt4 = paramInt8;
        }
        paramInt7 = paramInt5;
        if (paramInt5 > 0)
        {
          paramInt7 = paramInt5;
          if (m != 1) {
            paramInt7 = 0;
          }
        }
        paramInt5 = paramInt7;
        if (paramInt1 > 0)
        {
          paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, paramInt1, 8);
          paramInt5 = Math.max(paramInt7, paramInt1);
        }
        if (paramInt4 > 0)
        {
          if ((paramBoolean2) && (m == 1)) {
            paramInt7 = 0;
          } else {
            paramInt7 = 1;
          }
          if (paramInt7 != 0) {
            paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt4, 8);
          }
          paramInt5 = Math.min(paramInt5, paramInt4);
        }
        if (m != 1) {
          break;
        }
        if (paramBoolean2)
        {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt5, 8);
        }
        else if (paramBoolean8)
        {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt5, 5);
          paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt5, 8);
        }
        else
        {
          paramLinearSystem.addEquality(localSolverVariable2, localSolverVariable1, paramInt5, 5);
          paramLinearSystem.addLowerThan(localSolverVariable2, localSolverVariable1, paramInt5, 8);
        }
        j = paramInt1;
      }
      if (m != 2) {
        break;
      }
      if ((paramConstraintAnchor1.getType() != ConstraintAnchor.Type.TOP) && (paramConstraintAnchor1.getType() != ConstraintAnchor.Type.BOTTOM))
      {
        localObject1 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        localObject2 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
      }
      else
      {
        localObject1 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
        localObject2 = paramLinearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
      }
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowDimensionRatio(localSolverVariable2, localSolverVariable1, (SolverVariable)localObject2, (SolverVariable)localObject1, paramFloat2));
      j = paramInt1;
      paramInt2 = 0;
    }
    paramBoolean4 = true;
    int j = paramInt1;
    i = paramInt2;
    paramInt1 = paramInt4;
    label836:
    localObject1 = localObject3;
    if ((paramBoolean11) && (!paramBoolean8))
    {
      if (((bool1) || (bool2) || (bool3)) && ((!bool1) || (bool2))) {
        if ((!bool1) && (bool2))
        {
          paramLinearSystem.addEquality(localSolverVariable2, paramDimensionBehaviour, -paramConstraintAnchor2.getMargin(), 8);
          if (paramBoolean2)
          {
            if ((this.OPTIMIZE_WRAP) && (localSolverVariable1.isFinalValue))
            {
              localObject1 = this.mParent;
              if (localObject1 != null)
              {
                paramSolverVariable1 = (ConstraintWidgetContainer)localObject1;
                if (paramBoolean1)
                {
                  paramSolverVariable1.addHorizontalWrapMinVariable(paramConstraintAnchor1);
                  break label2166;
                }
                paramSolverVariable1.addVerticalWrapMinVariable(paramConstraintAnchor1);
                break label2166;
              }
            }
            paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, 0, 5);
          }
        }
        else if ((bool1) && (bool2))
        {
          ConstraintWidget localConstraintWidget = paramConstraintAnchor1.mTarget.mOwner;
          localObject2 = paramConstraintAnchor2;
          localObject3 = ((ConstraintAnchor)localObject2).mTarget.mOwner;
          Object localObject4 = getParent();
          k = 6;
          if (i != 0)
          {
            if (m == 0)
            {
              if ((paramInt1 == 0) && (j == 0))
              {
                if ((((SolverVariable)localObject1).isFinalValue) && (paramDimensionBehaviour.isFinalValue))
                {
                  paramLinearSystem.addEquality(localSolverVariable1, (SolverVariable)localObject1, paramConstraintAnchor1.getMargin(), 8);
                  paramLinearSystem.addEquality(localSolverVariable2, paramDimensionBehaviour, -paramConstraintAnchor2.getMargin(), 8);
                  return;
                }
                paramInt1 = 0;
                paramInt2 = 1;
                paramInt5 = 0;
                paramInt4 = 8;
                paramInt6 = 8;
              }
              else
              {
                paramInt1 = 1;
                paramInt2 = 0;
                paramInt5 = 1;
                paramInt4 = 5;
                paramInt6 = 5;
              }
              if ((!(localConstraintWidget instanceof Barrier)) && (!(localObject3 instanceof Barrier)))
              {
                paramInt8 = paramInt6;
                paramInt7 = paramInt1;
                paramInt6 = paramInt2;
                paramInt2 = paramInt8;
                paramInt1 = paramInt4;
              }
              else
              {
                paramInt6 = paramInt2;
                paramInt2 = 4;
                paramInt7 = paramInt1;
              }
            }
            for (paramInt1 = paramInt4;; paramInt1 = paramInt4)
            {
              paramInt4 = 6;
              break label1581;
              if (m == 1)
              {
                paramInt1 = 6;
                paramInt6 = 0;
              }
              for (paramInt2 = 4;; paramInt2 = 5)
              {
                paramInt7 = 1;
                paramInt5 = 1;
                paramInt8 = 8;
                paramInt4 = paramInt1;
                paramInt1 = paramInt8;
                break label1581;
                if (m != 3) {
                  break label1462;
                }
                if (this.mResolvedDimensionRatioSide != -1) {
                  break;
                }
                if (paramBoolean9)
                {
                  if (paramBoolean2) {
                    paramInt1 = 5;
                  } else {
                    paramInt1 = 4;
                  }
                }
                else {
                  paramInt1 = 8;
                }
                paramInt6 = 1;
              }
              if (!paramBoolean6) {
                break;
              }
              if ((paramInt6 != 2) && (paramInt6 != 1)) {
                paramInt1 = 0;
              } else {
                paramInt1 = 1;
              }
              if (paramInt1 == 0)
              {
                paramInt2 = 8;
                paramInt1 = 5;
              }
              else
              {
                paramInt2 = 5;
                paramInt1 = 4;
              }
              paramInt4 = paramInt2;
              paramInt5 = 1;
              paramInt7 = 1;
              paramInt6 = 1;
              paramInt2 = paramInt1;
            }
            if (paramInt1 > 0)
            {
              paramInt5 = 1;
              paramInt7 = 1;
              paramInt6 = 1;
              paramInt2 = 5;
              break label1574;
            }
            if ((paramInt1 == 0) && (j == 0))
            {
              if (!paramBoolean9)
              {
                paramInt5 = 1;
                paramInt7 = 1;
                paramInt6 = 1;
                paramInt2 = 8;
                break label1574;
              }
              if ((localConstraintWidget != localObject4) && (localObject3 != localObject4)) {
                paramInt1 = 4;
              } else {
                paramInt1 = 5;
              }
              paramInt5 = 1;
              paramInt7 = 1;
              paramInt4 = 6;
              paramInt6 = 1;
              paramInt2 = 4;
              break label1581;
            }
            paramInt5 = 1;
            paramInt7 = 1;
            paramInt6 = 1;
            break label1571;
            label1462:
            paramInt5 = 0;
            paramInt7 = 0;
          }
          else
          {
            if ((((SolverVariable)localObject1).isFinalValue) && (paramDimensionBehaviour.isFinalValue))
            {
              paramLinearSystem.addCentering(localSolverVariable1, (SolverVariable)localObject1, paramConstraintAnchor1.getMargin(), paramFloat1, paramDimensionBehaviour, localSolverVariable2, paramConstraintAnchor2.getMargin(), 8);
              if ((paramBoolean2) && (paramBoolean4))
              {
                if (((ConstraintAnchor)localObject2).mTarget != null) {
                  paramInt1 = paramConstraintAnchor2.getMargin();
                } else {
                  paramInt1 = 0;
                }
                if (paramDimensionBehaviour != paramSolverVariable2) {
                  paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, paramInt1, 5);
                }
              }
              return;
            }
            paramInt5 = 1;
            paramInt7 = 1;
          }
          paramInt6 = 0;
          label1571:
          paramInt2 = 4;
          label1574:
          paramInt4 = 6;
          paramInt1 = 5;
          label1581:
          if ((paramInt5 != 0) && (localObject1 == paramDimensionBehaviour) && (localConstraintWidget != localObject4))
          {
            paramInt5 = 0;
            paramInt8 = 0;
          }
          else
          {
            paramInt8 = 1;
          }
          if (paramInt7 != 0)
          {
            if ((i == 0) && (!paramBoolean7) && (!paramBoolean9) && (localObject1 == paramSolverVariable1) && (paramDimensionBehaviour == paramSolverVariable2))
            {
              paramBoolean2 = false;
              paramInt4 = 8;
              paramInt1 = 8;
              paramInt8 = 0;
            }
            paramLinearSystem.addCentering(localSolverVariable1, (SolverVariable)localObject1, paramConstraintAnchor1.getMargin(), paramFloat1, paramDimensionBehaviour, localSolverVariable2, paramConstraintAnchor2.getMargin(), paramInt4);
          }
          localObject2 = paramDimensionBehaviour;
          paramDimensionBehaviour = (ConstraintWidget.DimensionBehaviour)localObject4;
          if ((this.mVisibility == 8) && (!paramConstraintAnchor2.hasDependents())) {
            return;
          }
          if (paramInt5 != 0)
          {
            if ((paramBoolean2) && (localObject1 != localObject2) && (i == 0))
            {
              if (!(localConstraintWidget instanceof Barrier)) {
                if (!(localObject3 instanceof Barrier)) {
                  break label1764;
                }
              }
              paramInt1 = 6;
            }
            label1764:
            paramLinearSystem.addGreaterThan(localSolverVariable1, (SolverVariable)localObject1, paramConstraintAnchor1.getMargin(), paramInt1);
            paramLinearSystem.addLowerThan(localSolverVariable2, (SolverVariable)localObject2, -paramConstraintAnchor2.getMargin(), paramInt1);
          }
          if ((paramBoolean2) && (paramBoolean10) && (!(localConstraintWidget instanceof Barrier)) && (!(localObject3 instanceof Barrier)))
          {
            paramInt1 = 6;
            paramInt8 = 1;
            paramInt4 = 6;
          }
          else
          {
            paramInt4 = paramInt1;
            paramInt1 = paramInt2;
          }
          if (paramInt8 != 0)
          {
            if ((paramInt6 != 0) && ((!paramBoolean9) || (paramBoolean3)))
            {
              localObject4 = paramDimensionBehaviour;
              paramInt2 = k;
              if (localConstraintWidget != localObject4) {
                if (localObject3 == localObject4) {
                  paramInt2 = k;
                } else {
                  paramInt2 = paramInt1;
                }
              }
              if (((localConstraintWidget instanceof Guideline)) || ((localObject3 instanceof Guideline))) {
                paramInt2 = 5;
              }
              if (((localConstraintWidget instanceof Barrier)) || ((localObject3 instanceof Barrier))) {
                paramInt2 = 5;
              }
              if (paramBoolean9) {
                paramInt2 = 5;
              }
              paramInt2 = Math.max(paramInt2, paramInt1);
            }
            else
            {
              paramInt2 = paramInt1;
            }
            paramInt1 = paramInt2;
            if (paramBoolean2)
            {
              paramInt2 = Math.min(paramInt4, paramInt2);
              paramInt1 = paramInt2;
              if (paramBoolean6)
              {
                paramInt1 = paramInt2;
                if (!paramBoolean9) {
                  if (localConstraintWidget != paramDimensionBehaviour)
                  {
                    paramInt1 = paramInt2;
                    if (localObject3 != paramDimensionBehaviour) {}
                  }
                  else
                  {
                    paramInt1 = 4;
                  }
                }
              }
            }
            paramLinearSystem.addEquality(localSolverVariable1, (SolverVariable)localObject1, paramConstraintAnchor1.getMargin(), paramInt1);
            paramLinearSystem.addEquality(localSolverVariable2, (SolverVariable)localObject2, -paramConstraintAnchor2.getMargin(), paramInt1);
          }
          if (paramBoolean2)
          {
            if (paramSolverVariable1 == localObject1) {
              paramInt1 = paramConstraintAnchor1.getMargin();
            } else {
              paramInt1 = 0;
            }
            if (localObject1 != paramSolverVariable1) {
              paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, paramInt1, 5);
            }
          }
          if ((paramBoolean2) && (i != 0) && (paramInt3 == 0) && (j == 0))
          {
            if ((i != 0) && (m == 3))
            {
              paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, 0, 8);
              paramDimensionBehaviour = (ConstraintWidget.DimensionBehaviour)localObject2;
            }
            else
            {
              paramLinearSystem.addGreaterThan(localSolverVariable2, localSolverVariable1, 0, 5);
              paramDimensionBehaviour = (ConstraintWidget.DimensionBehaviour)localObject2;
            }
          }
          else {
            paramDimensionBehaviour = (ConstraintWidget.DimensionBehaviour)localObject2;
          }
        }
      }
      label2166:
      paramSolverVariable1 = paramConstraintAnchor2;
      if ((paramBoolean2) && (paramBoolean4))
      {
        if (paramSolverVariable1.mTarget != null) {
          paramInt1 = paramConstraintAnchor2.getMargin();
        } else {
          paramInt1 = 0;
        }
        if (paramDimensionBehaviour != paramSolverVariable2)
        {
          if ((this.OPTIMIZE_WRAP) && (localSolverVariable2.isFinalValue))
          {
            paramDimensionBehaviour = this.mParent;
            if (paramDimensionBehaviour != null)
            {
              paramLinearSystem = (ConstraintWidgetContainer)paramDimensionBehaviour;
              if (paramBoolean1)
              {
                paramLinearSystem.addHorizontalWrapMaxVariable(paramSolverVariable1);
                return;
              }
              paramLinearSystem.addVerticalWrapMaxVariable(paramSolverVariable1);
              return;
            }
          }
          paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, paramInt1, 5);
        }
      }
      return;
    }
    if ((k < 2) && (paramBoolean2) && (paramBoolean4))
    {
      paramLinearSystem.addGreaterThan(localSolverVariable1, paramSolverVariable1, 0, 8);
      if ((!paramBoolean1) && (this.mBaseline.mTarget != null)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      paramInt2 = paramInt1;
      if (!paramBoolean1)
      {
        paramInt2 = paramInt1;
        if (this.mBaseline.mTarget != null)
        {
          paramSolverVariable1 = this.mBaseline.mTarget.mOwner;
          if ((paramSolverVariable1.mDimensionRatio != 0.0F) && (paramSolverVariable1.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramSolverVariable1.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
        }
      }
      if (paramInt2 != 0) {
        paramLinearSystem.addGreaterThan(paramSolverVariable2, localSolverVariable2, 0, 8);
      }
    }
  }
  
  private boolean isChainHead(int paramInt)
  {
    paramInt *= 2;
    if (this.mListAnchors[paramInt].mTarget != null)
    {
      ConstraintAnchor localConstraintAnchor = this.mListAnchors[paramInt].mTarget.mTarget;
      ConstraintAnchor[] arrayOfConstraintAnchor = this.mListAnchors;
      if (localConstraintAnchor != arrayOfConstraintAnchor[paramInt])
      {
        paramInt += 1;
        if ((arrayOfConstraintAnchor[paramInt].mTarget != null) && (this.mListAnchors[paramInt].mTarget.mTarget == this.mListAnchors[paramInt])) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void addChildrenToSolverByDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, HashSet<ConstraintWidget> paramHashSet, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!paramHashSet.contains(this)) {
        return;
      }
      Optimizer.checkMatchParent(paramConstraintWidgetContainer, paramLinearSystem, this);
      paramHashSet.remove(this);
      addToSolver(paramLinearSystem, paramConstraintWidgetContainer.optimizeFor(64));
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.mLeft.getDependents();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ConstraintAnchor)((Iterator)localObject).next()).mOwner.addChildrenToSolverByDependency(paramConstraintWidgetContainer, paramLinearSystem, paramHashSet, paramInt, true);
        }
      }
      localObject = this.mRight.getDependents();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ConstraintAnchor)((Iterator)localObject).next()).mOwner.addChildrenToSolverByDependency(paramConstraintWidgetContainer, paramLinearSystem, paramHashSet, paramInt, true);
        }
      }
    }
    else
    {
      localObject = this.mTop.getDependents();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ConstraintAnchor)((Iterator)localObject).next()).mOwner.addChildrenToSolverByDependency(paramConstraintWidgetContainer, paramLinearSystem, paramHashSet, paramInt, true);
        }
      }
      localObject = this.mBottom.getDependents();
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ConstraintAnchor)((Iterator)localObject).next()).mOwner.addChildrenToSolverByDependency(paramConstraintWidgetContainer, paramLinearSystem, paramHashSet, paramInt, true);
        }
      }
      localObject = this.mBaseline.getDependents();
      if (localObject != null) {
        localObject = ((HashSet)localObject).iterator();
      }
    }
    for (;;)
    {
      ConstraintWidget localConstraintWidget;
      if (((Iterator)localObject).hasNext()) {
        localConstraintWidget = ((ConstraintAnchor)((Iterator)localObject).next()).mOwner;
      }
      try
      {
        localConstraintWidget.addChildrenToSolverByDependency(paramConstraintWidgetContainer, paramLinearSystem, paramHashSet, paramInt, true);
      }
      catch (Throwable paramConstraintWidgetContainer)
      {
        break label333;
      }
    }
    return;
    label333:
    for (;;)
    {
      throw paramConstraintWidgetContainer;
    }
  }
  
  boolean addFirst()
  {
    return ((this instanceof VirtualLayout)) || ((this instanceof Guideline));
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, boolean paramBoolean)
  {
    SolverVariable localSolverVariable = paramLinearSystem.createObjectVariable(this.mLeft);
    Object localObject4 = paramLinearSystem.createObjectVariable(this.mRight);
    Object localObject6 = paramLinearSystem.createObjectVariable(this.mTop);
    Object localObject5 = paramLinearSystem.createObjectVariable(this.mBottom);
    Object localObject3 = paramLinearSystem.createObjectVariable(this.mBaseline);
    Object localObject1 = this.mParent;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    if (localObject1 != null)
    {
      if ((localObject1 != null) && (localObject1.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = this.mParent;
      if ((localObject1 != null) && (localObject1.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool4 = bool1;
    }
    else
    {
      bool2 = false;
      bool4 = false;
    }
    if ((this.mVisibility == 8) && (!hasDependencies()))
    {
      localObject1 = this.mIsInBarrier;
      if ((localObject1[0] == 0) && (localObject1[1] == 0)) {
        return;
      }
    }
    if ((this.resolvedHorizontal) || (this.resolvedVertical))
    {
      if (this.resolvedHorizontal)
      {
        paramLinearSystem.addEquality(localSolverVariable, this.mX);
        paramLinearSystem.addEquality((SolverVariable)localObject4, this.mX + this.mWidth);
        if (bool4)
        {
          localObject1 = this.mParent;
          if (localObject1 != null) {
            if (this.OPTIMIZE_WRAP_ON_RESOLVED)
            {
              localObject1 = (ConstraintWidgetContainer)localObject1;
              ((ConstraintWidgetContainer)localObject1).addVerticalWrapMinVariable(this.mLeft);
              ((ConstraintWidgetContainer)localObject1).addHorizontalWrapMaxVariable(this.mRight);
            }
            else
            {
              paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject1).mRight), (SolverVariable)localObject4, 0, 5);
            }
          }
        }
      }
      if (this.resolvedVertical)
      {
        paramLinearSystem.addEquality((SolverVariable)localObject6, this.mY);
        paramLinearSystem.addEquality((SolverVariable)localObject5, this.mY + this.mHeight);
        if (this.mBaseline.hasDependents()) {
          paramLinearSystem.addEquality((SolverVariable)localObject3, this.mY + this.mBaselineDistance);
        }
        if (bool2)
        {
          localObject1 = this.mParent;
          if (localObject1 != null) {
            if (this.OPTIMIZE_WRAP_ON_RESOLVED)
            {
              localObject1 = (ConstraintWidgetContainer)localObject1;
              ((ConstraintWidgetContainer)localObject1).addVerticalWrapMinVariable(this.mTop);
              ((ConstraintWidgetContainer)localObject1).addVerticalWrapMaxVariable(this.mBottom);
            }
            else
            {
              paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject1).mBottom), (SolverVariable)localObject5, 0, 5);
            }
          }
        }
      }
      if ((this.resolvedHorizontal) && (this.resolvedVertical))
      {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        return;
      }
    }
    if (LinearSystem.sMetrics != null)
    {
      localObject1 = LinearSystem.sMetrics;
      ((Metrics)localObject1).widgets += 1L;
    }
    if (paramBoolean)
    {
      localObject1 = this.horizontalRun;
      if ((localObject1 != null) && (this.verticalRun != null) && (((HorizontalWidgetRun)localObject1).start.resolved) && (this.horizontalRun.end.resolved) && (this.verticalRun.start.resolved) && (this.verticalRun.end.resolved))
      {
        if (LinearSystem.sMetrics != null)
        {
          localObject1 = LinearSystem.sMetrics;
          ((Metrics)localObject1).graphSolved += 1L;
        }
        paramLinearSystem.addEquality(localSolverVariable, this.horizontalRun.start.value);
        paramLinearSystem.addEquality((SolverVariable)localObject4, this.horizontalRun.end.value);
        paramLinearSystem.addEquality((SolverVariable)localObject6, this.verticalRun.start.value);
        paramLinearSystem.addEquality((SolverVariable)localObject5, this.verticalRun.end.value);
        paramLinearSystem.addEquality((SolverVariable)localObject3, this.verticalRun.baseline.value);
        if (this.mParent != null)
        {
          if ((bool4) && (this.isTerminalWidget[0] != 0) && (!isInHorizontalChain())) {
            paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mRight), (SolverVariable)localObject4, 0, 8);
          }
          if ((bool2) && (this.isTerminalWidget[1] != 0) && (!isInVerticalChain())) {
            paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mBottom), (SolverVariable)localObject5, 0, 8);
          }
        }
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        return;
      }
    }
    if (LinearSystem.sMetrics != null)
    {
      localObject1 = LinearSystem.sMetrics;
      ((Metrics)localObject1).linearSolved += 1L;
    }
    boolean bool3;
    boolean bool5;
    if (this.mParent != null)
    {
      if (isChainHead(0))
      {
        ((ConstraintWidgetContainer)this.mParent).addChain(this, 0);
        bool1 = true;
      }
      else
      {
        bool1 = isInHorizontalChain();
      }
      if (isChainHead(1))
      {
        ((ConstraintWidgetContainer)this.mParent).addChain(this, 1);
        bool3 = true;
      }
      else
      {
        bool3 = isInVerticalChain();
      }
      if ((!bool1) && (bool4) && (this.mVisibility != 8) && (this.mLeft.mTarget == null) && (this.mRight.mTarget == null)) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mRight), (SolverVariable)localObject4, 0, 1);
      }
      if ((!bool3) && (bool2) && (this.mVisibility != 8) && (this.mTop.mTarget == null) && (this.mBottom.mTarget == null) && (this.mBaseline == null)) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mBottom), (SolverVariable)localObject5, 0, 1);
      }
      bool5 = bool3;
      bool3 = bool1;
    }
    else
    {
      bool3 = false;
      bool5 = false;
    }
    int i = this.mWidth;
    int j = this.mMinWidth;
    int m = i;
    if (i < j) {
      m = j;
    }
    j = this.mHeight;
    int k = this.mMinHeight;
    i = j;
    if (j < k) {
      i = k;
    }
    if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
    float f = this.mDimensionRatio;
    this.mResolvedDimensionRatio = f;
    k = this.mMatchConstraintDefaultWidth;
    int n = this.mMatchConstraintDefaultHeight;
    if ((f > 0.0F) && (this.mVisibility != 8))
    {
      j = k;
      if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        j = k;
        if (k == 0) {
          j = 3;
        }
      }
      k = n;
      if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        k = n;
        if (n == 0) {
          k = 3;
        }
      }
      if ((this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (j == 3) && (k == 3))
      {
        setupDimensionRatio(bool4, bool2, bool1, bool6);
        n = m;
      }
      else if ((this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (j == 3))
      {
        this.mResolvedDimensionRatioSide = 0;
        m = (int)(this.mResolvedDimensionRatio * this.mHeight);
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          bool1 = false;
          j = 4;
          break label1390;
        }
        n = m;
      }
      else
      {
        n = m;
        if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          n = m;
          if (k == 3)
          {
            this.mResolvedDimensionRatioSide = 1;
            if (this.mDimensionRatioSide == -1) {
              this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
            }
            i = (int)(this.mResolvedDimensionRatio * this.mWidth);
            if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              bool1 = false;
              k = 4;
              break label1390;
            }
            break label1373;
          }
        }
      }
      m = n;
      label1373:
      bool1 = true;
    }
    else
    {
      j = k;
      bool1 = false;
      k = n;
    }
    label1390:
    localObject1 = this.mResolvedMatchConstraintDefault;
    localObject1[0] = j;
    localObject1[1] = k;
    this.mResolvedHasRatio = bool1;
    if (bool1)
    {
      n = this.mResolvedDimensionRatioSide;
      if (n != 0) {
        if (n != -1) {
          break label1445;
        }
      }
      bool7 = true;
      break label1448;
    }
    label1445:
    boolean bool7 = false;
    label1448:
    if (bool1)
    {
      n = this.mResolvedDimensionRatioSide;
      if ((n == 1) || (n == -1))
      {
        bool6 = true;
        break label1480;
      }
    }
    boolean bool6 = false;
    label1480:
    if ((this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((this instanceof ConstraintWidgetContainer))) {
      bool8 = true;
    } else {
      bool8 = false;
    }
    if (bool8) {
      m = 0;
    }
    boolean bool10 = this.mCenter.isConnected() ^ true;
    localObject1 = this.mIsInBarrier;
    int i5 = localObject1[0];
    int i4 = localObject1[1];
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    int i1;
    if ((this.mHorizontalResolution != 2) && (!this.resolvedHorizontal))
    {
      if (paramBoolean)
      {
        localObject1 = this.horizontalRun;
        if ((localObject1 != null) && (((HorizontalWidgetRun)localObject1).start.resolved) && (this.horizontalRun.end.resolved))
        {
          if (!paramBoolean) {
            break label1885;
          }
          paramLinearSystem.addEquality(localSolverVariable, this.horizontalRun.start.value);
          paramLinearSystem.addEquality((SolverVariable)localObject4, this.horizontalRun.end.value);
          if ((this.mParent == null) || (!bool4) || (this.isTerminalWidget[0] == 0) || (isInHorizontalChain())) {
            break label1885;
          }
          paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(this.mParent.mRight), (SolverVariable)localObject4, 0, 8);
          break label1885;
        }
      }
      localObject1 = this.mParent;
      if (localObject1 != null) {
        localObject1 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject1).mRight);
      } else {
        localObject1 = null;
      }
      localObject2 = this.mParent;
      if (localObject2 != null) {
        localObject2 = paramLinearSystem.createObjectVariable(((ConstraintWidget)localObject2).mLeft);
      } else {
        localObject2 = null;
      }
      int i6 = this.isTerminalWidget[0];
      localObject7 = this.mListDimensionBehaviors;
      localObject8 = localObject7[0];
      localConstraintAnchor1 = this.mLeft;
      localConstraintAnchor2 = this.mRight;
      n = this.mX;
      i1 = this.mMinWidth;
      int i2 = this.mMaxDimension[0];
      f = this.mHorizontalBiasPercent;
      boolean bool9;
      if (localObject7[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        bool9 = true;
      } else {
        bool9 = false;
      }
      applyConstraints(paramLinearSystem, true, bool4, bool2, i6, (SolverVariable)localObject2, (SolverVariable)localObject1, (ConstraintWidget.DimensionBehaviour)localObject8, bool8, localConstraintAnchor1, localConstraintAnchor2, n, m, i1, i2, f, bool7, bool9, bool3, bool5, i5, j, k, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, bool10);
    }
    label1885:
    Object localObject2 = localObject6;
    localObject1 = localObject5;
    boolean bool8 = bool2;
    localObject5 = localObject4;
    if (paramBoolean)
    {
      localObject4 = this;
      localObject6 = ((ConstraintWidget)localObject4).verticalRun;
      if ((localObject6 != null) && (((VerticalWidgetRun)localObject6).start.resolved) && (((ConstraintWidget)localObject4).verticalRun.end.resolved))
      {
        m = ((ConstraintWidget)localObject4).verticalRun.start.value;
        localObject6 = paramLinearSystem;
        ((LinearSystem)localObject6).addEquality((SolverVariable)localObject2, m);
        m = ((ConstraintWidget)localObject4).verticalRun.end.value;
        localObject7 = localObject1;
        ((LinearSystem)localObject6).addEquality((SolverVariable)localObject7, m);
        ((LinearSystem)localObject6).addEquality((SolverVariable)localObject3, ((ConstraintWidget)localObject4).verticalRun.baseline.value);
        localObject8 = ((ConstraintWidget)localObject4).mParent;
        if ((localObject8 != null) && (!bool5) && (bool8)) {
          if (localObject4.isTerminalWidget[1] != 0) {
            ((LinearSystem)localObject6).addGreaterThan(((LinearSystem)localObject6).createObjectVariable(((ConstraintWidget)localObject8).mBottom), (SolverVariable)localObject7, 0, 8);
          } else {}
        }
        m = 0;
        break label2081;
      }
    }
    m = 1;
    label2081:
    localObject6 = this;
    Object localObject7 = paramLinearSystem;
    Object localObject8 = localObject3;
    if (((ConstraintWidget)localObject6).mVerticalResolution == 2) {
      m = 0;
    }
    if ((m != 0) && (!((ConstraintWidget)localObject6).resolvedVertical))
    {
      if ((localObject6.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && ((localObject6 instanceof ConstraintWidgetContainer))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (paramBoolean) {
        i = 0;
      }
      localObject3 = ((ConstraintWidget)localObject6).mParent;
      if (localObject3 != null) {
        localObject3 = ((LinearSystem)localObject7).createObjectVariable(((ConstraintWidget)localObject3).mBottom);
      } else {
        localObject3 = null;
      }
      localObject4 = ((ConstraintWidget)localObject6).mParent;
      if (localObject4 != null) {
        localObject4 = ((LinearSystem)localObject7).createObjectVariable(((ConstraintWidget)localObject4).mTop);
      } else {
        localObject4 = null;
      }
      if ((((ConstraintWidget)localObject6).mBaselineDistance > 0) || (((ConstraintWidget)localObject6).mVisibility == 8))
      {
        if (((ConstraintWidget)localObject6).mBaseline.mTarget != null)
        {
          ((LinearSystem)localObject7).addEquality((SolverVariable)localObject8, (SolverVariable)localObject2, getBaselineDistance(), 8);
          ((LinearSystem)localObject7).addEquality((SolverVariable)localObject8, ((LinearSystem)localObject7).createObjectVariable(((ConstraintWidget)localObject6).mBaseline.mTarget), 0, 8);
          if (bool8) {
            ((LinearSystem)localObject7).addGreaterThan((SolverVariable)localObject3, ((LinearSystem)localObject7).createObjectVariable(((ConstraintWidget)localObject6).mBottom), 0, 5);
          }
          bool2 = false;
          break label2356;
        }
        if (((ConstraintWidget)localObject6).mVisibility == 8) {
          ((LinearSystem)localObject7).addEquality((SolverVariable)localObject8, (SolverVariable)localObject2, 0, 8);
        } else {
          ((LinearSystem)localObject7).addEquality((SolverVariable)localObject8, (SolverVariable)localObject2, getBaselineDistance(), 8);
        }
      }
      bool2 = bool10;
      label2356:
      int i3 = localObject6.isTerminalWidget[1];
      localObject7 = ((ConstraintWidget)localObject6).mListDimensionBehaviors;
      localObject8 = localObject7[1];
      localConstraintAnchor1 = ((ConstraintWidget)localObject6).mTop;
      localConstraintAnchor2 = ((ConstraintWidget)localObject6).mBottom;
      m = ((ConstraintWidget)localObject6).mY;
      n = ((ConstraintWidget)localObject6).mMinHeight;
      i1 = localObject6.mMaxDimension[1];
      f = ((ConstraintWidget)localObject6).mVerticalBiasPercent;
      if (localObject7[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        bool7 = true;
      } else {
        bool7 = false;
      }
      applyConstraints(paramLinearSystem, false, bool8, bool4, i3, (SolverVariable)localObject4, (SolverVariable)localObject3, (ConstraintWidget.DimensionBehaviour)localObject8, paramBoolean, localConstraintAnchor1, localConstraintAnchor2, m, i, n, i1, f, bool6, bool7, bool5, bool3, i4, k, j, ((ConstraintWidget)localObject6).mMatchConstraintMinHeight, ((ConstraintWidget)localObject6).mMatchConstraintMaxHeight, ((ConstraintWidget)localObject6).mMatchConstraintPercentHeight, bool2);
    }
    if (bool1)
    {
      localObject3 = this;
      if (((ConstraintWidget)localObject3).mResolvedDimensionRatioSide == 1) {
        paramLinearSystem.addRatio((SolverVariable)localObject1, (SolverVariable)localObject2, (SolverVariable)localObject5, localSolverVariable, ((ConstraintWidget)localObject3).mResolvedDimensionRatio, 8);
      } else {
        paramLinearSystem.addRatio((SolverVariable)localObject5, localSolverVariable, (SolverVariable)localObject1, (SolverVariable)localObject2, ((ConstraintWidget)localObject3).mResolvedDimensionRatio, 8);
      }
    }
    localObject1 = this;
    if (((ConstraintWidget)localObject1).mCenter.isConnected()) {
      paramLinearSystem.addCenterPoint((ConstraintWidget)localObject1, ((ConstraintWidget)localObject1).mCenter.getTarget().getOwner(), (float)Math.toRadians(((ConstraintWidget)localObject1).mCircleConstraintAngle + 90.0F), ((ConstraintWidget)localObject1).mCenter.getMargin());
    }
    ((ConstraintWidget)localObject1).resolvedHorizontal = false;
    ((ConstraintWidget)localObject1).resolvedVertical = false;
  }
  
  public boolean allowedInBarrier()
  {
    return this.mVisibility != 8;
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2)
  {
    connect(paramType1, paramConstraintWidget, paramType2, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt)
  {
    int i;
    if (paramType1 == ConstraintAnchor.Type.CENTER)
    {
      if (paramType2 == ConstraintAnchor.Type.CENTER)
      {
        paramType1 = getAnchor(ConstraintAnchor.Type.LEFT);
        paramType2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        localConstraintAnchor1 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor localConstraintAnchor2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        i = 1;
        if (((paramType1 != null) && (paramType1.isConnected())) || ((paramType2 != null) && (paramType2.isConnected())))
        {
          paramInt = 0;
        }
        else
        {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, ConstraintAnchor.Type.LEFT, 0);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, ConstraintAnchor.Type.RIGHT, 0);
          paramInt = 1;
        }
        if (((localConstraintAnchor1 != null) && (localConstraintAnchor1.isConnected())) || ((localConstraintAnchor2 != null) && (localConstraintAnchor2.isConnected())))
        {
          i = 0;
        }
        else
        {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, ConstraintAnchor.Type.TOP, 0);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
        }
        if ((paramInt != 0) && (i != 0))
        {
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
          return;
        }
        if (paramInt != 0)
        {
          getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
          return;
        }
        if (i == 0) {
          break label879;
        }
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
        return;
      }
      if ((paramType2 != ConstraintAnchor.Type.LEFT) && (paramType2 != ConstraintAnchor.Type.RIGHT))
      {
        if ((paramType2 != ConstraintAnchor.Type.TOP) && (paramType2 != ConstraintAnchor.Type.BOTTOM)) {
          break label879;
        }
        connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, paramType2, 0);
        connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, paramType2, 0);
        getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0);
        return;
      }
      connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, paramType2, 0);
      paramType1 = ConstraintAnchor.Type.RIGHT;
    }
    try
    {
      connect(paramType1, paramConstraintWidget, paramType2, 0);
      getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0);
      return;
    }
    catch (Throwable paramType1)
    {
      throw paramType1;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && ((paramType2 == ConstraintAnchor.Type.LEFT) || (paramType2 == ConstraintAnchor.Type.RIGHT)))
    {
      paramType1 = getAnchor(ConstraintAnchor.Type.LEFT);
      paramConstraintWidget = paramConstraintWidget.getAnchor(paramType2);
      paramType2 = getAnchor(ConstraintAnchor.Type.RIGHT);
      paramType1.connect(paramConstraintWidget, 0);
      paramType2.connect(paramConstraintWidget, 0);
      getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget, 0);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && ((paramType2 == ConstraintAnchor.Type.TOP) || (paramType2 == ConstraintAnchor.Type.BOTTOM)))
    {
      paramType1 = paramConstraintWidget.getAnchor(paramType2);
      getAnchor(ConstraintAnchor.Type.TOP).connect(paramType1, 0);
      getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramType1, 0);
      getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramType1, 0);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && (paramType2 == ConstraintAnchor.Type.CENTER_X))
    {
      getAnchor(ConstraintAnchor.Type.LEFT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
      getAnchor(ConstraintAnchor.Type.RIGHT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
      getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(paramType2), 0);
      return;
    }
    if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && (paramType2 == ConstraintAnchor.Type.CENTER_Y))
    {
      getAnchor(ConstraintAnchor.Type.TOP).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
      getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
      getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(paramType2), 0);
      return;
    }
    ConstraintAnchor localConstraintAnchor1 = getAnchor(paramType1);
    paramConstraintWidget = paramConstraintWidget.getAnchor(paramType2);
    if (localConstraintAnchor1.isValidConnection(paramConstraintWidget))
    {
      if (paramType1 == ConstraintAnchor.Type.BASELINE)
      {
        paramType1 = getAnchor(ConstraintAnchor.Type.TOP);
        paramType2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (paramType1 != null) {
          paramType1.reset();
        }
        if (paramType2 != null) {
          paramType2.reset();
        }
        i = 0;
      }
      else if ((paramType1 != ConstraintAnchor.Type.TOP) && (paramType1 != ConstraintAnchor.Type.BOTTOM))
      {
        if (paramType1 != ConstraintAnchor.Type.LEFT)
        {
          i = paramInt;
          if (paramType1 != ConstraintAnchor.Type.RIGHT) {}
        }
        else
        {
          paramType2 = getAnchor(ConstraintAnchor.Type.CENTER);
          if (paramType2.getTarget() != paramConstraintWidget) {
            paramType2.reset();
          }
          paramType1 = getAnchor(paramType1).getOpposite();
          paramType2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
          i = paramInt;
          if (paramType2.isConnected())
          {
            paramType1.reset();
            paramType2.reset();
            i = paramInt;
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
        i = paramInt;
        if (paramType2.isConnected())
        {
          paramType1.reset();
          paramType2.reset();
          i = paramInt;
        }
      }
      localConstraintAnchor1.connect(paramConstraintWidget, i);
    }
    label879:
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    if (paramConstraintAnchor1.getOwner() == this) {
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt);
    }
  }
  
  public void connectCircularConstraint(ConstraintWidget paramConstraintWidget, float paramFloat, int paramInt)
  {
    immediateConnect(ConstraintAnchor.Type.CENTER, paramConstraintWidget, ConstraintAnchor.Type.CENTER, paramInt, 0);
    this.mCircleConstraintAngle = paramFloat;
  }
  
  public void copy(ConstraintWidget paramConstraintWidget, HashMap<ConstraintWidget, ConstraintWidget> paramHashMap)
  {
    this.mHorizontalResolution = paramConstraintWidget.mHorizontalResolution;
    this.mVerticalResolution = paramConstraintWidget.mVerticalResolution;
    this.mMatchConstraintDefaultWidth = paramConstraintWidget.mMatchConstraintDefaultWidth;
    this.mMatchConstraintDefaultHeight = paramConstraintWidget.mMatchConstraintDefaultHeight;
    Object localObject1 = this.mResolvedMatchConstraintDefault;
    int[] arrayOfInt = paramConstraintWidget.mResolvedMatchConstraintDefault;
    localObject1[0] = arrayOfInt[0];
    localObject1[1] = arrayOfInt[1];
    this.mMatchConstraintMinWidth = paramConstraintWidget.mMatchConstraintMinWidth;
    this.mMatchConstraintMaxWidth = paramConstraintWidget.mMatchConstraintMaxWidth;
    this.mMatchConstraintMinHeight = paramConstraintWidget.mMatchConstraintMinHeight;
    this.mMatchConstraintMaxHeight = paramConstraintWidget.mMatchConstraintMaxHeight;
    this.mMatchConstraintPercentHeight = paramConstraintWidget.mMatchConstraintPercentHeight;
    this.mIsWidthWrapContent = paramConstraintWidget.mIsWidthWrapContent;
    this.mIsHeightWrapContent = paramConstraintWidget.mIsHeightWrapContent;
    this.mResolvedDimensionRatioSide = paramConstraintWidget.mResolvedDimensionRatioSide;
    this.mResolvedDimensionRatio = paramConstraintWidget.mResolvedDimensionRatio;
    localObject1 = paramConstraintWidget.mMaxDimension;
    this.mMaxDimension = Arrays.copyOf((int[])localObject1, localObject1.length);
    this.mCircleConstraintAngle = paramConstraintWidget.mCircleConstraintAngle;
    this.hasBaseline = paramConstraintWidget.hasBaseline;
    this.inPlaceholder = paramConstraintWidget.inPlaceholder;
    this.mLeft.reset();
    this.mTop.reset();
    this.mRight.reset();
    this.mBottom.reset();
    this.mBaseline.reset();
    this.mCenterX.reset();
    this.mCenterY.reset();
    this.mCenter.reset();
    this.mListDimensionBehaviors = ((ConstraintWidget.DimensionBehaviour[])Arrays.copyOf(this.mListDimensionBehaviors, 2));
    localObject1 = this.mParent;
    arrayOfInt = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (ConstraintWidget)paramHashMap.get(paramConstraintWidget.mParent);
    }
    this.mParent = ((ConstraintWidget)localObject1);
    this.mWidth = paramConstraintWidget.mWidth;
    this.mHeight = paramConstraintWidget.mHeight;
    this.mDimensionRatio = paramConstraintWidget.mDimensionRatio;
    this.mDimensionRatioSide = paramConstraintWidget.mDimensionRatioSide;
    this.mX = paramConstraintWidget.mX;
    this.mY = paramConstraintWidget.mY;
    this.mRelX = paramConstraintWidget.mRelX;
    this.mRelY = paramConstraintWidget.mRelY;
    this.mOffsetX = paramConstraintWidget.mOffsetX;
    this.mOffsetY = paramConstraintWidget.mOffsetY;
    this.mBaselineDistance = paramConstraintWidget.mBaselineDistance;
    this.mMinWidth = paramConstraintWidget.mMinWidth;
    this.mMinHeight = paramConstraintWidget.mMinHeight;
    this.mHorizontalBiasPercent = paramConstraintWidget.mHorizontalBiasPercent;
    this.mVerticalBiasPercent = paramConstraintWidget.mVerticalBiasPercent;
    this.mCompanionWidget = paramConstraintWidget.mCompanionWidget;
    this.mContainerItemSkip = paramConstraintWidget.mContainerItemSkip;
    this.mVisibility = paramConstraintWidget.mVisibility;
    this.mDebugName = paramConstraintWidget.mDebugName;
    this.mType = paramConstraintWidget.mType;
    this.mDistToTop = paramConstraintWidget.mDistToTop;
    this.mDistToLeft = paramConstraintWidget.mDistToLeft;
    this.mDistToRight = paramConstraintWidget.mDistToRight;
    this.mDistToBottom = paramConstraintWidget.mDistToBottom;
    this.mLeftHasCentered = paramConstraintWidget.mLeftHasCentered;
    this.mRightHasCentered = paramConstraintWidget.mRightHasCentered;
    this.mTopHasCentered = paramConstraintWidget.mTopHasCentered;
    this.mBottomHasCentered = paramConstraintWidget.mBottomHasCentered;
    this.mHorizontalWrapVisited = paramConstraintWidget.mHorizontalWrapVisited;
    this.mVerticalWrapVisited = paramConstraintWidget.mVerticalWrapVisited;
    this.mHorizontalChainStyle = paramConstraintWidget.mHorizontalChainStyle;
    this.mVerticalChainStyle = paramConstraintWidget.mVerticalChainStyle;
    this.mHorizontalChainFixedPosition = paramConstraintWidget.mHorizontalChainFixedPosition;
    this.mVerticalChainFixedPosition = paramConstraintWidget.mVerticalChainFixedPosition;
    localObject1 = this.mWeight;
    Object localObject2 = paramConstraintWidget.mWeight;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = this.mListNextMatchConstraintsWidget;
    localObject2 = paramConstraintWidget.mListNextMatchConstraintsWidget;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = this.mNextChainWidget;
    localObject2 = paramConstraintWidget.mNextChainWidget;
    localObject1[0] = localObject2[0];
    localObject1[1] = localObject2[1];
    localObject1 = paramConstraintWidget.mHorizontalNextWidget;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (ConstraintWidget)paramHashMap.get(localObject1);
    }
    this.mHorizontalNextWidget = ((ConstraintWidget)localObject1);
    paramConstraintWidget = paramConstraintWidget.mVerticalNextWidget;
    if (paramConstraintWidget == null) {
      paramConstraintWidget = arrayOfInt;
    } else {
      paramConstraintWidget = (ConstraintWidget)paramHashMap.get(paramConstraintWidget);
    }
    this.mVerticalNextWidget = paramConstraintWidget;
  }
  
  public void createObjectVariables(LinearSystem paramLinearSystem)
  {
    paramLinearSystem.createObjectVariable(this.mLeft);
    paramLinearSystem.createObjectVariable(this.mTop);
    paramLinearSystem.createObjectVariable(this.mRight);
    paramLinearSystem.createObjectVariable(this.mBottom);
    if (this.mBaselineDistance > 0) {
      paramLinearSystem.createObjectVariable(this.mBaseline);
    }
  }
  
  public void ensureMeasureRequested()
  {
    this.mMeasureRequested = true;
  }
  
  public void ensureWidgetRuns()
  {
    if (this.horizontalRun == null) {
      this.horizontalRun = new HorizontalWidgetRun(this);
    }
    if (this.verticalRun == null) {
      this.verticalRun = new VerticalWidgetRun(this);
    }
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      throw new AssertionError(paramType.name());
    case 9: 
      return null;
    case 8: 
      return this.mCenterY;
    case 7: 
      return this.mCenterX;
    case 6: 
      return this.mCenter;
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
  
  public float getBiasPercent(int paramInt)
  {
    if (paramInt == 0) {
      return this.mHorizontalBiasPercent;
    }
    if (paramInt == 1) {
      return this.mVerticalBiasPercent;
    }
    return -1.0F;
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
  
  public ConstraintWidget.DimensionBehaviour getDimensionBehaviour(int paramInt)
  {
    if (paramInt == 0) {
      return getHorizontalDimensionBehaviour();
    }
    if (paramInt == 1) {
      return getVerticalDimensionBehaviour();
    }
    return null;
  }
  
  public float getDimensionRatio()
  {
    return this.mDimensionRatio;
  }
  
  public int getDimensionRatioSide()
  {
    return this.mDimensionRatioSide;
  }
  
  public boolean getHasBaseline()
  {
    return this.hasBaseline;
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
    return this.mListDimensionBehaviors[0];
  }
  
  public int getHorizontalMargin()
  {
    ConstraintAnchor localConstraintAnchor = this.mLeft;
    int i = 0;
    if (localConstraintAnchor != null) {
      i = 0 + localConstraintAnchor.mMargin;
    }
    localConstraintAnchor = this.mRight;
    int j = i;
    if (localConstraintAnchor != null) {
      j = i + localConstraintAnchor.mMargin;
    }
    return j;
  }
  
  public int getLastHorizontalMeasureSpec()
  {
    return this.mLastHorizontalMeasureSpec;
  }
  
  public int getLastVerticalMeasureSpec()
  {
    return this.mLastVerticalMeasureSpec;
  }
  
  public int getLeft()
  {
    return getX();
  }
  
  public int getLength(int paramInt)
  {
    if (paramInt == 0) {
      return getWidth();
    }
    if (paramInt == 1) {
      return getHeight();
    }
    return 0;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxDimension[1];
  }
  
  public int getMaxWidth()
  {
    return this.mMaxDimension[0];
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public ConstraintWidget getNextChainMember(int paramInt)
  {
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    if (paramInt == 0)
    {
      if (this.mRight.mTarget != null)
      {
        localConstraintAnchor1 = this.mRight.mTarget.mTarget;
        localConstraintAnchor2 = this.mRight;
        if (localConstraintAnchor1 == localConstraintAnchor2) {
          return localConstraintAnchor2.mTarget.mOwner;
        }
      }
    }
    else if ((paramInt == 1) && (this.mBottom.mTarget != null))
    {
      localConstraintAnchor1 = this.mBottom.mTarget.mTarget;
      localConstraintAnchor2 = this.mBottom;
      if (localConstraintAnchor1 == localConstraintAnchor2) {
        return localConstraintAnchor2.mTarget.mOwner;
      }
    }
    return null;
  }
  
  public int getOptimizerWrapHeight()
  {
    int i = this.mHeight;
    int j = i;
    if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
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
    if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
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
  
  public ConstraintWidget getPreviousChainMember(int paramInt)
  {
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    if (paramInt == 0)
    {
      if (this.mLeft.mTarget != null)
      {
        localConstraintAnchor1 = this.mLeft.mTarget.mTarget;
        localConstraintAnchor2 = this.mLeft;
        if (localConstraintAnchor1 == localConstraintAnchor2) {
          return localConstraintAnchor2.mTarget.mOwner;
        }
      }
    }
    else if ((paramInt == 1) && (this.mTop.mTarget != null))
    {
      localConstraintAnchor1 = this.mTop.mTarget.mTarget;
      localConstraintAnchor2 = this.mTop;
      if (localConstraintAnchor1 == localConstraintAnchor2) {
        return localConstraintAnchor2.mTarget.mOwner;
      }
    }
    return null;
  }
  
  int getRelativePositioning(int paramInt)
  {
    if (paramInt == 0) {
      return this.mRelX;
    }
    if (paramInt == 1) {
      return this.mRelY;
    }
    return 0;
  }
  
  public int getRight()
  {
    return getX() + this.mWidth;
  }
  
  protected int getRootX()
  {
    return this.mX + this.mOffsetX;
  }
  
  protected int getRootY()
  {
    return this.mY + this.mOffsetY;
  }
  
  public WidgetRun getRun(int paramInt)
  {
    if (paramInt == 0) {
      return this.horizontalRun;
    }
    if (paramInt == 1) {
      return this.verticalRun;
    }
    return null;
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
    return this.mListDimensionBehaviors[1];
  }
  
  public int getVerticalMargin()
  {
    ConstraintAnchor localConstraintAnchor = this.mLeft;
    int i = 0;
    if (localConstraintAnchor != null) {
      i = 0 + this.mTop.mMargin;
    }
    int j = i;
    if (this.mRight != null) {
      j = i + this.mBottom.mMargin;
    }
    return j;
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
  
  public int getX()
  {
    ConstraintWidget localConstraintWidget = this.mParent;
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer))) {
      return ((ConstraintWidgetContainer)localConstraintWidget).mPaddingLeft + this.mX;
    }
    return this.mX;
  }
  
  public int getY()
  {
    ConstraintWidget localConstraintWidget = this.mParent;
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer))) {
      return ((ConstraintWidgetContainer)localConstraintWidget).mPaddingTop + this.mY;
    }
    return this.mY;
  }
  
  public boolean hasBaseline()
  {
    return this.hasBaseline;
  }
  
  public boolean hasDanglingDimension(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      if (this.mLeft.mTarget != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (this.mRight.mTarget != null) {
        i = 1;
      } else {
        i = 0;
      }
      return paramInt + i < 2;
    }
    if (this.mTop.mTarget != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (this.mBottom.mTarget != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mBaseline.mTarget != null) {
      j = 1;
    } else {
      j = 0;
    }
    return paramInt + i + j < 2;
  }
  
  public boolean hasDependencies()
  {
    int j = this.mAnchors.size();
    int i = 0;
    while (i < j)
    {
      if (((ConstraintAnchor)this.mAnchors.get(i)).hasDependents()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2)
  {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, true);
  }
  
  public boolean isHeightWrapContent()
  {
    return this.mIsHeightWrapContent;
  }
  
  public boolean isInHorizontalChain()
  {
    return ((this.mLeft.mTarget != null) && (this.mLeft.mTarget.mTarget == this.mLeft)) || ((this.mRight.mTarget != null) && (this.mRight.mTarget.mTarget == this.mRight));
  }
  
  public boolean isInPlaceholder()
  {
    return this.inPlaceholder;
  }
  
  public boolean isInVerticalChain()
  {
    return ((this.mTop.mTarget != null) && (this.mTop.mTarget.mTarget == this.mTop)) || ((this.mBottom.mTarget != null) && (this.mBottom.mTarget.mTarget == this.mBottom));
  }
  
  public boolean isInVirtualLayout()
  {
    return this.mInVirtuaLayout;
  }
  
  public boolean isMeasureRequested()
  {
    return (this.mMeasureRequested) && (this.mVisibility != 8);
  }
  
  public boolean isResolvedHorizontally()
  {
    return (this.resolvedHorizontal) || ((this.mLeft.hasFinalValue()) && (this.mRight.hasFinalValue()));
  }
  
  public boolean isResolvedVertically()
  {
    return (this.resolvedVertical) || ((this.mTop.hasFinalValue()) && (this.mBottom.hasFinalValue()));
  }
  
  public boolean isRoot()
  {
    return this.mParent == null;
  }
  
  public boolean isSpreadHeight()
  {
    return (this.mMatchConstraintDefaultHeight == 0) && (this.mDimensionRatio == 0.0F) && (this.mMatchConstraintMinHeight == 0) && (this.mMatchConstraintMaxHeight == 0) && (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
  }
  
  public boolean isSpreadWidth()
  {
    int i = this.mMatchConstraintDefaultWidth;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (this.mDimensionRatio == 0.0F)
      {
        bool1 = bool2;
        if (this.mMatchConstraintMinWidth == 0)
        {
          bool1 = bool2;
          if (this.mMatchConstraintMaxWidth == 0)
          {
            bool1 = bool2;
            if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isWidthWrapContent()
  {
    return this.mIsWidthWrapContent;
  }
  
  public boolean oppositeDimensionDependsOn(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = this.mListDimensionBehaviors;
    Object localObject1 = localObject2[paramInt];
    localObject2 = localObject2[i];
    return (localObject1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localObject2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
  }
  
  public boolean oppositeDimensionsTied()
  {
    ConstraintWidget.DimensionBehaviour[] arrayOfDimensionBehaviour = this.mListDimensionBehaviors;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfDimensionBehaviour[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
    {
      bool1 = bool2;
      if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        bool1 = true;
      }
    }
    return bool1;
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
    this.mCircleConstraintAngle = 0.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mDimensionRatio = 0.0F;
    this.mDimensionRatioSide = -1;
    this.mX = 0;
    this.mY = 0;
    this.mOffsetX = 0;
    this.mOffsetY = 0;
    this.mBaselineDistance = 0;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    float f = DEFAULT_BIAS;
    this.mHorizontalBiasPercent = f;
    this.mVerticalBiasPercent = f;
    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
    this.mCompanionWidget = null;
    this.mContainerItemSkip = 0;
    this.mVisibility = 0;
    this.mType = null;
    this.mHorizontalWrapVisited = false;
    this.mVerticalWrapVisited = false;
    this.mHorizontalChainStyle = 0;
    this.mVerticalChainStyle = 0;
    this.mHorizontalChainFixedPosition = false;
    this.mVerticalChainFixedPosition = false;
    Object localObject = this.mWeight;
    localObject[0] = -1.0F;
    localObject[1] = -1.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
    localObject = this.mMaxDimension;
    localObject[0] = 2147483647;
    localObject[1] = 2147483647;
    this.mMatchConstraintDefaultWidth = 0;
    this.mMatchConstraintDefaultHeight = 0;
    this.mMatchConstraintPercentWidth = 1.0F;
    this.mMatchConstraintPercentHeight = 1.0F;
    this.mMatchConstraintMaxWidth = 2147483647;
    this.mMatchConstraintMaxHeight = 2147483647;
    this.mMatchConstraintMinWidth = 0;
    this.mMatchConstraintMinHeight = 0;
    this.mResolvedHasRatio = false;
    this.mResolvedDimensionRatioSide = -1;
    this.mResolvedDimensionRatio = 1.0F;
    this.mGroupsToSolver = false;
    localObject = this.isTerminalWidget;
    localObject[0] = 1;
    localObject[1] = 1;
    this.mInVirtuaLayout = false;
    localObject = this.mIsInBarrier;
    localObject[0] = 0;
    localObject[1] = 0;
    this.mMeasureRequested = true;
  }
  
  public void resetAllConstraints()
  {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
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
  
  public void resetFinalResolution()
  {
    int i = 0;
    this.resolvedHorizontal = false;
    this.resolvedVertical = false;
    int j = this.mAnchors.size();
    while (i < j)
    {
      ((ConstraintAnchor)this.mAnchors.get(i)).resetFinalResolution();
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
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasBaseline = bool;
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
    paramLinearSystem = paramLinearSystem.createObjectVariable(this.mBaseline);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".baseline");
    paramLinearSystem.setName(((StringBuilder)localObject1).toString());
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
  
  public void setFinalBaseline(int paramInt)
  {
    if (!this.hasBaseline) {
      return;
    }
    int i = paramInt - this.mBaselineDistance;
    int j = this.mHeight;
    this.mY = i;
    this.mTop.setFinalValue(i);
    this.mBottom.setFinalValue(j + i);
    this.mBaseline.setFinalValue(paramInt);
    this.resolvedVertical = true;
  }
  
  public void setFinalFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    setBaselineDistance(paramInt5);
    if (paramInt6 == 0)
    {
      this.resolvedHorizontal = true;
      this.resolvedVertical = false;
      return;
    }
    if (paramInt6 == 1)
    {
      this.resolvedHorizontal = false;
      this.resolvedVertical = true;
      return;
    }
    if (paramInt6 == 2)
    {
      this.resolvedHorizontal = true;
      this.resolvedVertical = true;
      return;
    }
    this.resolvedHorizontal = false;
    this.resolvedVertical = false;
  }
  
  public void setFinalHorizontal(int paramInt1, int paramInt2)
  {
    this.mLeft.setFinalValue(paramInt1);
    this.mRight.setFinalValue(paramInt2);
    this.mX = paramInt1;
    this.mWidth = (paramInt2 - paramInt1);
    this.resolvedHorizontal = true;
  }
  
  public void setFinalLeft(int paramInt)
  {
    this.mLeft.setFinalValue(paramInt);
    this.mX = paramInt;
  }
  
  public void setFinalTop(int paramInt)
  {
    this.mTop.setFinalValue(paramInt);
    this.mY = paramInt;
  }
  
  public void setFinalVertical(int paramInt1, int paramInt2)
  {
    this.mTop.setFinalValue(paramInt1);
    this.mBottom.setFinalValue(paramInt2);
    this.mY = paramInt1;
    this.mHeight = (paramInt2 - paramInt1);
    if (this.hasBaseline) {
      this.mBaseline.setFinalValue(paramInt1 + this.mBaselineDistance);
    }
    this.resolvedVertical = true;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      setHorizontalDimension(paramInt1, paramInt2);
      return;
    }
    if (paramInt3 == 1) {
      setVerticalDimension(paramInt1, paramInt2);
    }
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
    if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED)
    {
      paramInt1 = this.mWidth;
      if (i < paramInt1) {}
    }
    else
    {
      paramInt1 = i;
    }
    if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED)
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
    int i = ConstraintWidget.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()];
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
  
  public void setHasBaseline(boolean paramBoolean)
  {
    this.hasBaseline = paramBoolean;
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
  
  public void setHeightWrapContent(boolean paramBoolean)
  {
    this.mIsHeightWrapContent = paramBoolean;
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
    this.mListDimensionBehaviors[0] = paramDimensionBehaviour;
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.mMatchConstraintDefaultWidth = paramInt1;
    this.mMatchConstraintMinWidth = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 == 2147483647) {
      paramInt1 = 0;
    }
    this.mMatchConstraintMaxWidth = paramInt1;
    this.mMatchConstraintPercentWidth = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (this.mMatchConstraintDefaultWidth == 0)) {
      this.mMatchConstraintDefaultWidth = 2;
    }
  }
  
  public void setHorizontalWeight(float paramFloat)
  {
    this.mWeight[0] = paramFloat;
  }
  
  protected void setInBarrier(int paramInt, boolean paramBoolean)
  {
    this.mIsInBarrier[paramInt] = paramBoolean;
  }
  
  public void setInPlaceholder(boolean paramBoolean)
  {
    this.inPlaceholder = paramBoolean;
  }
  
  public void setInVirtualLayout(boolean paramBoolean)
  {
    this.mInVirtuaLayout = paramBoolean;
  }
  
  public void setLastMeasureSpec(int paramInt1, int paramInt2)
  {
    this.mLastHorizontalMeasureSpec = paramInt1;
    this.mLastVerticalMeasureSpec = paramInt2;
    setMeasureRequested(false);
  }
  
  public void setLength(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      setWidth(paramInt1);
      return;
    }
    if (paramInt2 == 1) {
      setHeight(paramInt1);
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxDimension[1] = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxDimension[0] = paramInt;
  }
  
  public void setMeasureRequested(boolean paramBoolean)
  {
    this.mMeasureRequested = paramBoolean;
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
  
  void setRelativePositioning(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.mRelX = paramInt1;
      return;
    }
    if (paramInt2 == 1) {
      this.mRelY = paramInt1;
    }
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
    this.mListDimensionBehaviors[1] = paramDimensionBehaviour;
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.mMatchConstraintDefaultHeight = paramInt1;
    this.mMatchConstraintMinHeight = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 == 2147483647) {
      paramInt1 = 0;
    }
    this.mMatchConstraintMaxHeight = paramInt1;
    this.mMatchConstraintPercentHeight = paramFloat;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F) && (this.mMatchConstraintDefaultHeight == 0)) {
      this.mMatchConstraintDefaultHeight = 2;
    }
  }
  
  public void setVerticalWeight(float paramFloat)
  {
    this.mWeight[1] = paramFloat;
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
  
  public void setWidthWrapContent(boolean paramBoolean)
  {
    this.mIsWidthWrapContent = paramBoolean;
  }
  
  public void setX(int paramInt)
  {
    this.mX = paramInt;
  }
  
  public void setY(int paramInt)
  {
    this.mY = paramInt;
  }
  
  public void setupDimensionRatio(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.mResolvedDimensionRatioSide == -1) {
      if ((paramBoolean3) && (!paramBoolean4))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((!paramBoolean3) && (paramBoolean4))
      {
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide == -1) {
          this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        }
      }
    }
    if ((this.mResolvedDimensionRatioSide == 0) && ((!this.mTop.isConnected()) || (!this.mBottom.isConnected()))) {
      this.mResolvedDimensionRatioSide = 1;
    } else if ((this.mResolvedDimensionRatioSide == 1) && ((!this.mLeft.isConnected()) || (!this.mRight.isConnected()))) {
      this.mResolvedDimensionRatioSide = 0;
    }
    if ((this.mResolvedDimensionRatioSide == -1) && ((!this.mTop.isConnected()) || (!this.mBottom.isConnected()) || (!this.mLeft.isConnected()) || (!this.mRight.isConnected()))) {
      if ((this.mTop.isConnected()) && (this.mBottom.isConnected()))
      {
        this.mResolvedDimensionRatioSide = 0;
      }
      else if ((this.mLeft.isConnected()) && (this.mRight.isConnected()))
      {
        this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        this.mResolvedDimensionRatioSide = 1;
      }
    }
    if (this.mResolvedDimensionRatioSide == -1)
    {
      if ((this.mMatchConstraintMinWidth > 0) && (this.mMatchConstraintMinHeight == 0))
      {
        this.mResolvedDimensionRatioSide = 0;
        return;
      }
      if ((this.mMatchConstraintMinWidth == 0) && (this.mMatchConstraintMinHeight > 0))
      {
        this.mResolvedDimensionRatio = (1.0F / this.mResolvedDimensionRatio);
        this.mResolvedDimensionRatioSide = 1;
      }
    }
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
    return localStringBuilder.toString();
  }
  
  public void updateFromRuns(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = paramBoolean1 & this.horizontalRun.isResolved();
    boolean bool1 = paramBoolean2 & this.verticalRun.isResolved();
    int i = this.horizontalRun.start.value;
    int j = this.verticalRun.start.value;
    int m = this.horizontalRun.end.value;
    int n = this.verticalRun.end.value;
    int k;
    if ((m - i >= 0) && (n - j >= 0) && (i != -2147483648) && (i != 2147483647) && (j != -2147483648) && (j != 2147483647) && (m != -2147483648) && (m != 2147483647) && (n != -2147483648))
    {
      k = n;
      if (n != 2147483647) {}
    }
    else
    {
      i = 0;
      j = 0;
      m = 0;
      k = 0;
    }
    m -= i;
    k -= j;
    if (bool2) {
      this.mX = i;
    }
    if (bool1) {
      this.mY = j;
    }
    if (this.mVisibility == 8)
    {
      this.mWidth = 0;
      this.mHeight = 0;
      return;
    }
    if (bool2)
    {
      if (this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED)
      {
        i = this.mWidth;
        if (m < i) {}
      }
      else
      {
        i = m;
      }
      this.mWidth = i;
      i = this.mWidth;
      j = this.mMinWidth;
      if (i < j) {
        this.mWidth = j;
      }
    }
    if (bool1)
    {
      if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED)
      {
        i = this.mHeight;
        if (k < i) {}
      }
      else
      {
        i = k;
      }
      this.mHeight = i;
      i = this.mHeight;
      j = this.mMinHeight;
      if (i < j) {
        this.mHeight = j;
      }
    }
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, boolean paramBoolean)
  {
    int j = paramLinearSystem.getObjectVariableValue(this.mLeft);
    int n = paramLinearSystem.getObjectVariableValue(this.mTop);
    int m = paramLinearSystem.getObjectVariableValue(this.mRight);
    int i1 = paramLinearSystem.getObjectVariableValue(this.mBottom);
    int k = j;
    int i = m;
    if (paramBoolean)
    {
      paramLinearSystem = this.horizontalRun;
      k = j;
      i = m;
      if (paramLinearSystem != null)
      {
        k = j;
        i = m;
        if (paramLinearSystem.start.resolved)
        {
          k = j;
          i = m;
          if (this.horizontalRun.end.resolved)
          {
            k = this.horizontalRun.start.value;
            i = this.horizontalRun.end.value;
          }
        }
      }
    }
    m = n;
    j = i1;
    if (paramBoolean)
    {
      paramLinearSystem = this.verticalRun;
      m = n;
      j = i1;
      if (paramLinearSystem != null)
      {
        m = n;
        j = i1;
        if (paramLinearSystem.start.resolved)
        {
          m = n;
          j = i1;
          if (this.verticalRun.end.resolved)
          {
            m = this.verticalRun.start.value;
            j = this.verticalRun.end.value;
          }
        }
      }
    }
    if ((i - k >= 0) && (j - m >= 0) && (k != -2147483648) && (k != 2147483647) && (m != -2147483648) && (m != 2147483647) && (i != -2147483648) && (i != 2147483647) && (j != -2147483648))
    {
      n = i;
      i = j;
      if (j != 2147483647) {}
    }
    else
    {
      i = 0;
      k = 0;
      m = 0;
      n = 0;
    }
    setFrame(k, m, n, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.ConstraintWidget
 * JD-Core Version:    0.7.0.1
 */