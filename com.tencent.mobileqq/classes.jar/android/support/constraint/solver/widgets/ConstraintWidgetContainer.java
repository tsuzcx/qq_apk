package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  static boolean ALLOW_ROOT_GROUP = true;
  private static final int CHAIN_FIRST = 0;
  private static final int CHAIN_FIRST_VISIBLE = 2;
  private static final int CHAIN_LAST = 1;
  private static final int CHAIN_LAST_VISIBLE = 3;
  private static final boolean DEBUG = false;
  private static final boolean DEBUG_LAYOUT = false;
  private static final boolean DEBUG_OPTIMIZE = false;
  private static final int FLAG_CHAIN_DANGLING = 1;
  private static final int FLAG_CHAIN_OPTIMIZE = 0;
  private static final int FLAG_RECOMPUTE_BOUNDS = 2;
  private static final int MAX_ITERATIONS = 8;
  public static final int OPTIMIZATION_ALL = 2;
  public static final int OPTIMIZATION_BASIC = 4;
  public static final int OPTIMIZATION_CHAIN = 8;
  public static final int OPTIMIZATION_NONE = 1;
  private static final boolean USE_SNAPSHOT = true;
  private static final boolean USE_THREAD = false;
  private boolean[] flags = new boolean[3];
  protected LinearSystem mBackgroundSystem = null;
  private ConstraintWidget[] mChainEnds = new ConstraintWidget[4];
  private boolean mHeightMeasuredTooSmall = false;
  private ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
  private int mHorizontalChainsSize = 0;
  private ConstraintWidget[] mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
  private int mOptimizationLevel = 2;
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  private ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
  private int mVerticalChainsSize = 0;
  private boolean mWidthMeasuredTooSmall = false;
  int mWrapHeight;
  int mWrapWidth;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = this.mHorizontalChainsSize;
      if (i >= j) {
        break;
      }
      if (this.mHorizontalChainsArray[i] == paramConstraintWidget) {
        return;
      }
      i += 1;
    }
    ConstraintWidget[] arrayOfConstraintWidget = this.mHorizontalChainsArray;
    if (j + 1 >= arrayOfConstraintWidget.length) {
      this.mHorizontalChainsArray = ((ConstraintWidget[])Arrays.copyOf(arrayOfConstraintWidget, arrayOfConstraintWidget.length * 2));
    }
    arrayOfConstraintWidget = this.mHorizontalChainsArray;
    i = this.mHorizontalChainsSize;
    arrayOfConstraintWidget[i] = paramConstraintWidget;
    this.mHorizontalChainsSize = (i + 1);
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = this.mVerticalChainsSize;
      if (i >= j) {
        break;
      }
      if (this.mVerticalChainsArray[i] == paramConstraintWidget) {
        return;
      }
      i += 1;
    }
    ConstraintWidget[] arrayOfConstraintWidget = this.mVerticalChainsArray;
    if (j + 1 >= arrayOfConstraintWidget.length) {
      this.mVerticalChainsArray = ((ConstraintWidget[])Arrays.copyOf(arrayOfConstraintWidget, arrayOfConstraintWidget.length * 2));
    }
    arrayOfConstraintWidget = this.mVerticalChainsArray;
    i = this.mVerticalChainsSize;
    arrayOfConstraintWidget[i] = paramConstraintWidget;
    this.mVerticalChainsSize = (i + 1);
  }
  
  private void applyHorizontalChain(LinearSystem paramLinearSystem)
  {
    Object localObject1 = paramLinearSystem;
    int i = 0;
    for (;;)
    {
      Object localObject4 = this;
      if (i >= ((ConstraintWidgetContainer)localObject4).mHorizontalChainsSize) {
        break;
      }
      Object localObject2 = ((ConstraintWidgetContainer)localObject4).mHorizontalChainsArray;
      ConstraintWidget localConstraintWidget = localObject2[i];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, ((ConstraintWidgetContainer)localObject4).mChainEnds, localObject2[i], 0, ((ConstraintWidgetContainer)localObject4).flags);
      localObject2 = localObject4.mChainEnds[2];
      if (localObject2 == null) {}
      int m;
      int i1;
      float f;
      for (;;)
      {
        localObject3 = localObject1;
        j = i;
        break label2585;
        if (localObject4.flags[1] != 0)
        {
          j = localConstraintWidget.getDrawX();
          while (localObject2 != null)
          {
            ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject2).mLeft.mSolverVariable, j);
            localObject3 = ((ConstraintWidget)localObject2).mHorizontalNextWidget;
            j += ((ConstraintWidget)localObject2).mLeft.getMargin() + ((ConstraintWidget)localObject2).getWidth() + ((ConstraintWidget)localObject2).mRight.getMargin();
            localObject2 = localObject3;
          }
        }
        else
        {
          if (localConstraintWidget.mHorizontalChainStyle == 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (localConstraintWidget.mHorizontalChainStyle == 2) {
            m = 1;
          } else {
            m = 0;
          }
          if (((ConstraintWidgetContainer)localObject4).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            k = 1;
          } else {
            k = 0;
          }
          i1 = ((ConstraintWidgetContainer)localObject4).mOptimizationLevel;
          if (((i1 == 2) || (i1 == 8)) && (localObject4.flags[0] != 0) && (localConstraintWidget.mHorizontalChainFixedPosition) && (m == 0) && (k == 0) && (localConstraintWidget.mHorizontalChainStyle == 0))
          {
            Optimizer.applyDirectResolutionHorizontalChain((ConstraintWidgetContainer)localObject4, (LinearSystem)localObject1, n, localConstraintWidget);
          }
          else
          {
            if ((n == 0) || (m != 0)) {
              break label1674;
            }
            f = 0.0F;
            localObject3 = null;
            while (localObject2 != null)
            {
              if (((ConstraintWidget)localObject2).mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                k = ((ConstraintWidget)localObject2).mLeft.getMargin();
                j = k;
                if (localObject3 != null) {
                  j = k + ((ConstraintWidget)localObject3).mRight.getMargin();
                }
                if (((ConstraintWidget)localObject2).mLeft.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                } else {
                  k = 3;
                }
                ((LinearSystem)localObject1).addGreaterThan(((ConstraintWidget)localObject2).mLeft.mSolverVariable, ((ConstraintWidget)localObject2).mLeft.mTarget.mSolverVariable, j, k);
                k = ((ConstraintWidget)localObject2).mRight.getMargin();
                j = k;
                if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.mTarget != null)
                {
                  j = k;
                  if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.mTarget.mOwner == localObject2) {
                    j = k + ((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.getMargin();
                  }
                }
                if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                } else {
                  k = 3;
                }
                ((LinearSystem)localObject1).addLowerThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mRight.mTarget.mSolverVariable, -j, k);
              }
              else
              {
                f += ((ConstraintWidget)localObject2).mHorizontalWeight;
                if (((ConstraintWidget)localObject2).mRight.mTarget != null)
                {
                  k = ((ConstraintWidget)localObject2).mRight.getMargin();
                  j = k;
                  if (localObject2 != localObject4.mChainEnds[3]) {
                    j = k + ((ConstraintWidget)localObject2).mRight.mTarget.mOwner.mLeft.getMargin();
                  }
                }
                else
                {
                  j = 0;
                }
                ((LinearSystem)localObject1).addGreaterThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mLeft.mSolverVariable, 0, 1);
                ((LinearSystem)localObject1).addLowerThan(((ConstraintWidget)localObject2).mRight.mSolverVariable, ((ConstraintWidget)localObject2).mRight.mTarget.mSolverVariable, -j, 1);
              }
              localObject5 = ((ConstraintWidget)localObject2).mHorizontalNextWidget;
              localObject3 = localObject2;
              localObject2 = localObject5;
            }
            if (n != 1) {
              break;
            }
            localObject3 = localObject4.mMatchConstraintsChainedWidgets[0];
            k = ((ConstraintWidget)localObject3).mLeft.getMargin();
            j = k;
            if (((ConstraintWidget)localObject3).mLeft.mTarget != null) {
              j = k + ((ConstraintWidget)localObject3).mLeft.mTarget.getMargin();
            }
            m = ((ConstraintWidget)localObject3).mRight.getMargin();
            k = m;
            if (((ConstraintWidget)localObject3).mRight.mTarget != null) {
              k = m + ((ConstraintWidget)localObject3).mRight.mTarget.getMargin();
            }
            localObject2 = localConstraintWidget.mRight.mTarget.mSolverVariable;
            localObject4 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
            if (localObject3 == localObject4[3]) {
              localObject2 = localObject4[1].mRight.mTarget.mSolverVariable;
            }
            if (((ConstraintWidget)localObject3).mMatchConstraintDefaultWidth == 1)
            {
              ((LinearSystem)localObject1).addGreaterThan(localConstraintWidget.mLeft.mSolverVariable, localConstraintWidget.mLeft.mTarget.mSolverVariable, j, 1);
              ((LinearSystem)localObject1).addLowerThan(localConstraintWidget.mRight.mSolverVariable, (SolverVariable)localObject2, -k, 1);
              ((LinearSystem)localObject1).addEquality(localConstraintWidget.mRight.mSolverVariable, localConstraintWidget.mLeft.mSolverVariable, localConstraintWidget.getWidth(), 2);
            }
            else
            {
              ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject3).mLeft.mSolverVariable, ((ConstraintWidget)localObject3).mLeft.mTarget.mSolverVariable, j, 1);
              ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject3).mRight.mSolverVariable, (SolverVariable)localObject2, -k, 1);
            }
          }
        }
      }
      int k = 0;
      int j = n;
      Object localObject6;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      for (;;)
      {
        i1 = j - 1;
        if (k >= i1) {
          break;
        }
        localObject2 = ((ConstraintWidgetContainer)localObject4).mMatchConstraintsChainedWidgets;
        localObject5 = localObject2[k];
        m = k + 1;
        localObject6 = localObject2[m];
        localObject7 = ((ConstraintWidget)localObject5).mLeft.mSolverVariable;
        localObject8 = ((ConstraintWidget)localObject5).mRight.mSolverVariable;
        localObject9 = ((ConstraintWidget)localObject6).mLeft.mSolverVariable;
        localObject2 = ((ConstraintWidget)localObject6).mRight.mSolverVariable;
        localObject3 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
        if (localObject6 == localObject3[3]) {
          localObject2 = localObject3[1].mRight.mSolverVariable;
        }
        n = ((ConstraintWidget)localObject5).mLeft.getMargin();
        k = n;
        if (((ConstraintWidget)localObject5).mLeft.mTarget != null)
        {
          k = n;
          if (((ConstraintWidget)localObject5).mLeft.mTarget.mOwner.mRight.mTarget != null)
          {
            k = n;
            if (((ConstraintWidget)localObject5).mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localObject5) {
              k = n + ((ConstraintWidget)localObject5).mLeft.mTarget.mOwner.mRight.getMargin();
            }
          }
        }
        ((LinearSystem)localObject1).addGreaterThan((SolverVariable)localObject7, ((ConstraintWidget)localObject5).mLeft.mTarget.mSolverVariable, k, 2);
        n = ((ConstraintWidget)localObject5).mRight.getMargin();
        k = n;
        if (((ConstraintWidget)localObject5).mRight.mTarget != null)
        {
          k = n;
          if (((ConstraintWidget)localObject5).mHorizontalNextWidget != null)
          {
            if (((ConstraintWidget)localObject5).mHorizontalNextWidget.mLeft.mTarget != null) {
              k = ((ConstraintWidget)localObject5).mHorizontalNextWidget.mLeft.getMargin();
            } else {
              k = 0;
            }
            k = n + k;
          }
        }
        ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject8, ((ConstraintWidget)localObject5).mRight.mTarget.mSolverVariable, -k, 2);
        if (m == i1)
        {
          n = ((ConstraintWidget)localObject6).mLeft.getMargin();
          k = n;
          if (((ConstraintWidget)localObject6).mLeft.mTarget != null)
          {
            k = n;
            if (((ConstraintWidget)localObject6).mLeft.mTarget.mOwner.mRight.mTarget != null)
            {
              k = n;
              if (((ConstraintWidget)localObject6).mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localObject6) {
                k = n + ((ConstraintWidget)localObject6).mLeft.mTarget.mOwner.mRight.getMargin();
              }
            }
          }
          ((LinearSystem)localObject1).addGreaterThan((SolverVariable)localObject9, ((ConstraintWidget)localObject6).mLeft.mTarget.mSolverVariable, k, 2);
          localObject3 = ((ConstraintWidget)localObject6).mRight;
          localObject10 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
          if (localObject6 == localObject10[3]) {
            localObject3 = localObject10[1].mRight;
          }
          n = ((ConstraintAnchor)localObject3).getMargin();
          k = n;
          if (((ConstraintAnchor)localObject3).mTarget != null)
          {
            k = n;
            if (((ConstraintAnchor)localObject3).mTarget.mOwner.mLeft.mTarget != null)
            {
              k = n;
              if (((ConstraintAnchor)localObject3).mTarget.mOwner.mLeft.mTarget.mOwner == localObject6) {
                k = n + ((ConstraintAnchor)localObject3).mTarget.mOwner.mLeft.getMargin();
              }
            }
          }
          ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject2, ((ConstraintAnchor)localObject3).mTarget.mSolverVariable, -k, 2);
        }
        if (localConstraintWidget.mMatchConstraintMaxWidth > 0) {
          ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject8, (SolverVariable)localObject7, localConstraintWidget.mMatchConstraintMaxWidth, 2);
        }
        localObject3 = paramLinearSystem.createRow();
        ((ArrayRow)localObject3).createRowEqualDimension(((ConstraintWidget)localObject5).mHorizontalWeight, f, ((ConstraintWidget)localObject6).mHorizontalWeight, (SolverVariable)localObject7, ((ConstraintWidget)localObject5).mLeft.getMargin(), (SolverVariable)localObject8, ((ConstraintWidget)localObject5).mRight.getMargin(), (SolverVariable)localObject9, ((ConstraintWidget)localObject6).mLeft.getMargin(), (SolverVariable)localObject2, ((ConstraintWidget)localObject6).mRight.getMargin());
        ((LinearSystem)localObject1).addConstraint((ArrayRow)localObject3);
        k = m;
      }
      label1674:
      localObject4 = localObject2;
      Object localObject5 = null;
      Object localObject7 = localObject5;
      k = 0;
      Object localObject3 = localObject1;
      n = j;
      localObject1 = localObject5;
      while (localObject4 != null)
      {
        localObject8 = ((ConstraintWidget)localObject4).mHorizontalNextWidget;
        if (localObject8 == null)
        {
          localObject5 = this.mChainEnds[1];
          j = 1;
        }
        else
        {
          j = k;
          localObject5 = localObject1;
        }
        if (m != 0)
        {
          localObject1 = ((ConstraintWidget)localObject4).mLeft;
          i1 = ((ConstraintAnchor)localObject1).getMargin();
          k = i1;
          if (localObject7 != null) {
            k = i1 + ((ConstraintWidget)localObject7).mRight.getMargin();
          }
          if (localObject2 != localObject4) {
            i1 = 3;
          } else {
            i1 = 1;
          }
          ((LinearSystem)localObject3).addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, k, i1);
          if (((ConstraintWidget)localObject4).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            localObject6 = ((ConstraintWidget)localObject4).mRight;
            if (((ConstraintWidget)localObject4).mMatchConstraintDefaultWidth == 1)
            {
              k = Math.max(((ConstraintWidget)localObject4).mMatchConstraintMinWidth, ((ConstraintWidget)localObject4).getWidth());
              ((LinearSystem)localObject3).addEquality(((ConstraintAnchor)localObject6).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, k, 3);
            }
            else
            {
              ((LinearSystem)localObject3).addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, ((ConstraintAnchor)localObject1).mMargin, 3);
              ((LinearSystem)localObject3).addLowerThan(((ConstraintAnchor)localObject6).mSolverVariable, ((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintWidget)localObject4).mMatchConstraintMinWidth, 3);
            }
          }
        }
        else if ((n == 0) && (j != 0) && (localObject7 != null))
        {
          if (((ConstraintWidget)localObject4).mRight.mTarget == null)
          {
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mRight.mSolverVariable, ((ConstraintWidget)localObject4).getDrawRight());
          }
          else
          {
            k = ((ConstraintWidget)localObject4).mRight.getMargin();
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mRight.mSolverVariable, ((ConstraintWidget)localObject5).mRight.mTarget.mSolverVariable, -k, 5);
          }
        }
        else
        {
          if ((n != 0) || (j != 0) || (localObject7 != null)) {
            break label2114;
          }
          if (((ConstraintWidget)localObject4).mLeft.mTarget == null)
          {
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mLeft.mSolverVariable, ((ConstraintWidget)localObject4).getDrawX());
          }
          else
          {
            k = ((ConstraintWidget)localObject4).mLeft.getMargin();
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mLeft.mSolverVariable, localConstraintWidget.mLeft.mTarget.mSolverVariable, k, 5);
          }
        }
        localObject1 = localObject8;
        break label2379;
        label2114:
        localObject10 = ((ConstraintWidget)localObject4).mLeft;
        localObject9 = ((ConstraintWidget)localObject4).mRight;
        k = ((ConstraintAnchor)localObject10).getMargin();
        i1 = ((ConstraintAnchor)localObject9).getMargin();
        ((LinearSystem)localObject3).addGreaterThan(((ConstraintAnchor)localObject10).mSolverVariable, ((ConstraintAnchor)localObject10).mTarget.mSolverVariable, k, 1);
        ((LinearSystem)localObject3).addLowerThan(((ConstraintAnchor)localObject9).mSolverVariable, ((ConstraintAnchor)localObject9).mTarget.mSolverVariable, -i1, 1);
        if (((ConstraintAnchor)localObject10).mTarget != null) {
          localObject6 = ((ConstraintAnchor)localObject10).mTarget.mSolverVariable;
        } else {
          localObject6 = null;
        }
        if (localObject7 == null) {
          if (localConstraintWidget.mLeft.mTarget != null) {
            localObject6 = localConstraintWidget.mLeft.mTarget.mSolverVariable;
          } else {
            localObject6 = null;
          }
        }
        localObject1 = localObject8;
        if (localObject8 == null) {
          if (((ConstraintWidget)localObject5).mRight.mTarget != null) {
            localObject1 = ((ConstraintWidget)localObject5).mRight.mTarget.mOwner;
          } else {
            localObject1 = null;
          }
        }
        if (localObject1 != null)
        {
          localObject7 = ((ConstraintWidget)localObject1).mLeft.mSolverVariable;
          if (j != 0) {
            if (((ConstraintWidget)localObject5).mRight.mTarget != null) {
              localObject7 = ((ConstraintWidget)localObject5).mRight.mTarget.mSolverVariable;
            } else {
              localObject7 = null;
            }
          }
          if ((localObject6 != null) && (localObject7 != null))
          {
            localObject8 = ((ConstraintAnchor)localObject10).mSolverVariable;
            localObject9 = ((ConstraintAnchor)localObject9).mSolverVariable;
            paramLinearSystem.addCentering((SolverVariable)localObject8, (SolverVariable)localObject6, k, 0.5F, (SolverVariable)localObject7, (SolverVariable)localObject9, i1, 4);
          }
        }
        label2379:
        if (j != 0) {
          localObject1 = null;
        }
        localObject7 = localObject4;
        localObject4 = localObject1;
        localObject1 = localObject5;
        k = j;
      }
      localObject4 = localObject3;
      localObject3 = localObject4;
      j = i;
      if (m != 0)
      {
        localObject5 = ((ConstraintWidget)localObject2).mLeft;
        localObject6 = ((ConstraintWidget)localObject1).mRight;
        k = ((ConstraintAnchor)localObject5).getMargin();
        m = ((ConstraintAnchor)localObject6).getMargin();
        if (localConstraintWidget.mLeft.mTarget != null) {
          localObject2 = localConstraintWidget.mLeft.mTarget.mSolverVariable;
        } else {
          localObject2 = null;
        }
        if (((ConstraintWidget)localObject1).mRight.mTarget != null) {
          localObject1 = ((ConstraintWidget)localObject1).mRight.mTarget.mSolverVariable;
        } else {
          localObject1 = null;
        }
        localObject3 = localObject4;
        j = i;
        if (localObject2 != null)
        {
          localObject3 = localObject4;
          j = i;
          if (localObject1 != null)
          {
            ((LinearSystem)localObject4).addLowerThan(((ConstraintAnchor)localObject6).mSolverVariable, (SolverVariable)localObject1, -m, 1);
            paramLinearSystem.addCentering(((ConstraintAnchor)localObject5).mSolverVariable, (SolverVariable)localObject2, k, localConstraintWidget.mHorizontalBiasPercent, (SolverVariable)localObject1, ((ConstraintAnchor)localObject6).mSolverVariable, m, 4);
            j = i;
            localObject3 = localObject4;
          }
        }
      }
      label2585:
      i = j + 1;
      localObject1 = localObject3;
    }
  }
  
  private void applyVerticalChain(LinearSystem paramLinearSystem)
  {
    Object localObject1 = paramLinearSystem;
    int i = 0;
    for (;;)
    {
      Object localObject4 = this;
      if (i >= ((ConstraintWidgetContainer)localObject4).mVerticalChainsSize) {
        break;
      }
      Object localObject2 = ((ConstraintWidgetContainer)localObject4).mVerticalChainsArray;
      ConstraintWidget localConstraintWidget = localObject2[i];
      int n = countMatchConstraintsChainedWidgets(paramLinearSystem, ((ConstraintWidgetContainer)localObject4).mChainEnds, localObject2[i], 1, ((ConstraintWidgetContainer)localObject4).flags);
      localObject2 = localObject4.mChainEnds[2];
      if (localObject2 == null) {}
      int m;
      int i1;
      float f;
      for (;;)
      {
        localObject3 = localObject1;
        j = i;
        break label2668;
        if (localObject4.flags[1] != 0)
        {
          j = localConstraintWidget.getDrawY();
          while (localObject2 != null)
          {
            ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject2).mTop.mSolverVariable, j);
            localObject3 = ((ConstraintWidget)localObject2).mVerticalNextWidget;
            j += ((ConstraintWidget)localObject2).mTop.getMargin() + ((ConstraintWidget)localObject2).getHeight() + ((ConstraintWidget)localObject2).mBottom.getMargin();
            localObject2 = localObject3;
          }
        }
        else
        {
          if (localConstraintWidget.mVerticalChainStyle == 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (localConstraintWidget.mVerticalChainStyle == 2) {
            m = 1;
          } else {
            m = 0;
          }
          if (((ConstraintWidgetContainer)localObject4).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            k = 1;
          } else {
            k = 0;
          }
          i1 = ((ConstraintWidgetContainer)localObject4).mOptimizationLevel;
          if (((i1 == 2) || (i1 == 8)) && (localObject4.flags[0] != 0) && (localConstraintWidget.mVerticalChainFixedPosition) && (m == 0) && (k == 0) && (localConstraintWidget.mVerticalChainStyle == 0))
          {
            Optimizer.applyDirectResolutionVerticalChain((ConstraintWidgetContainer)localObject4, (LinearSystem)localObject1, n, localConstraintWidget);
          }
          else
          {
            if ((n == 0) || (m != 0)) {
              break label1674;
            }
            f = 0.0F;
            localObject3 = null;
            while (localObject2 != null)
            {
              if (((ConstraintWidget)localObject2).mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
              {
                k = ((ConstraintWidget)localObject2).mTop.getMargin();
                j = k;
                if (localObject3 != null) {
                  j = k + ((ConstraintWidget)localObject3).mBottom.getMargin();
                }
                if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                } else {
                  k = 3;
                }
                ((LinearSystem)localObject1).addGreaterThan(((ConstraintWidget)localObject2).mTop.mSolverVariable, ((ConstraintWidget)localObject2).mTop.mTarget.mSolverVariable, j, k);
                k = ((ConstraintWidget)localObject2).mBottom.getMargin();
                j = k;
                if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.mTarget != null)
                {
                  j = k;
                  if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.mTarget.mOwner == localObject2) {
                    j = k + ((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.getMargin();
                  }
                }
                if (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                  k = 2;
                } else {
                  k = 3;
                }
                ((LinearSystem)localObject1).addLowerThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mBottom.mTarget.mSolverVariable, -j, k);
              }
              else
              {
                f += ((ConstraintWidget)localObject2).mVerticalWeight;
                if (((ConstraintWidget)localObject2).mBottom.mTarget != null)
                {
                  k = ((ConstraintWidget)localObject2).mBottom.getMargin();
                  j = k;
                  if (localObject2 != localObject4.mChainEnds[3]) {
                    j = k + ((ConstraintWidget)localObject2).mBottom.mTarget.mOwner.mTop.getMargin();
                  }
                }
                else
                {
                  j = 0;
                }
                ((LinearSystem)localObject1).addGreaterThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mTop.mSolverVariable, 0, 1);
                ((LinearSystem)localObject1).addLowerThan(((ConstraintWidget)localObject2).mBottom.mSolverVariable, ((ConstraintWidget)localObject2).mBottom.mTarget.mSolverVariable, -j, 1);
              }
              localObject5 = ((ConstraintWidget)localObject2).mVerticalNextWidget;
              localObject3 = localObject2;
              localObject2 = localObject5;
            }
            if (n != 1) {
              break;
            }
            localObject3 = localObject4.mMatchConstraintsChainedWidgets[0];
            k = ((ConstraintWidget)localObject3).mTop.getMargin();
            j = k;
            if (((ConstraintWidget)localObject3).mTop.mTarget != null) {
              j = k + ((ConstraintWidget)localObject3).mTop.mTarget.getMargin();
            }
            m = ((ConstraintWidget)localObject3).mBottom.getMargin();
            k = m;
            if (((ConstraintWidget)localObject3).mBottom.mTarget != null) {
              k = m + ((ConstraintWidget)localObject3).mBottom.mTarget.getMargin();
            }
            localObject2 = localConstraintWidget.mBottom.mTarget.mSolverVariable;
            localObject4 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
            if (localObject3 == localObject4[3]) {
              localObject2 = localObject4[1].mBottom.mTarget.mSolverVariable;
            }
            if (((ConstraintWidget)localObject3).mMatchConstraintDefaultHeight == 1)
            {
              ((LinearSystem)localObject1).addGreaterThan(localConstraintWidget.mTop.mSolverVariable, localConstraintWidget.mTop.mTarget.mSolverVariable, j, 1);
              ((LinearSystem)localObject1).addLowerThan(localConstraintWidget.mBottom.mSolverVariable, (SolverVariable)localObject2, -k, 1);
              ((LinearSystem)localObject1).addEquality(localConstraintWidget.mBottom.mSolverVariable, localConstraintWidget.mTop.mSolverVariable, localConstraintWidget.getHeight(), 2);
            }
            else
            {
              ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject3).mTop.mSolverVariable, ((ConstraintWidget)localObject3).mTop.mTarget.mSolverVariable, j, 1);
              ((LinearSystem)localObject1).addEquality(((ConstraintWidget)localObject3).mBottom.mSolverVariable, (SolverVariable)localObject2, -k, 1);
            }
          }
        }
      }
      int k = 0;
      int j = n;
      Object localObject6;
      Object localObject7;
      Object localObject9;
      Object localObject10;
      for (;;)
      {
        i1 = j - 1;
        if (k >= i1) {
          break;
        }
        localObject2 = ((ConstraintWidgetContainer)localObject4).mMatchConstraintsChainedWidgets;
        localObject5 = localObject2[k];
        m = k + 1;
        localObject6 = localObject2[m];
        localObject7 = ((ConstraintWidget)localObject5).mTop.mSolverVariable;
        localObject8 = ((ConstraintWidget)localObject5).mBottom.mSolverVariable;
        localObject9 = ((ConstraintWidget)localObject6).mTop.mSolverVariable;
        localObject2 = ((ConstraintWidget)localObject6).mBottom.mSolverVariable;
        localObject3 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
        if (localObject6 == localObject3[3]) {
          localObject2 = localObject3[1].mBottom.mSolverVariable;
        }
        n = ((ConstraintWidget)localObject5).mTop.getMargin();
        k = n;
        if (((ConstraintWidget)localObject5).mTop.mTarget != null)
        {
          k = n;
          if (((ConstraintWidget)localObject5).mTop.mTarget.mOwner.mBottom.mTarget != null)
          {
            k = n;
            if (((ConstraintWidget)localObject5).mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localObject5) {
              k = n + ((ConstraintWidget)localObject5).mTop.mTarget.mOwner.mBottom.getMargin();
            }
          }
        }
        ((LinearSystem)localObject1).addGreaterThan((SolverVariable)localObject7, ((ConstraintWidget)localObject5).mTop.mTarget.mSolverVariable, k, 2);
        n = ((ConstraintWidget)localObject5).mBottom.getMargin();
        k = n;
        if (((ConstraintWidget)localObject5).mBottom.mTarget != null)
        {
          k = n;
          if (((ConstraintWidget)localObject5).mVerticalNextWidget != null)
          {
            if (((ConstraintWidget)localObject5).mVerticalNextWidget.mTop.mTarget != null) {
              k = ((ConstraintWidget)localObject5).mVerticalNextWidget.mTop.getMargin();
            } else {
              k = 0;
            }
            k = n + k;
          }
        }
        ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject8, ((ConstraintWidget)localObject5).mBottom.mTarget.mSolverVariable, -k, 2);
        if (m == i1)
        {
          n = ((ConstraintWidget)localObject6).mTop.getMargin();
          k = n;
          if (((ConstraintWidget)localObject6).mTop.mTarget != null)
          {
            k = n;
            if (((ConstraintWidget)localObject6).mTop.mTarget.mOwner.mBottom.mTarget != null)
            {
              k = n;
              if (((ConstraintWidget)localObject6).mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localObject6) {
                k = n + ((ConstraintWidget)localObject6).mTop.mTarget.mOwner.mBottom.getMargin();
              }
            }
          }
          ((LinearSystem)localObject1).addGreaterThan((SolverVariable)localObject9, ((ConstraintWidget)localObject6).mTop.mTarget.mSolverVariable, k, 2);
          localObject3 = ((ConstraintWidget)localObject6).mBottom;
          localObject10 = ((ConstraintWidgetContainer)localObject4).mChainEnds;
          if (localObject6 == localObject10[3]) {
            localObject3 = localObject10[1].mBottom;
          }
          n = ((ConstraintAnchor)localObject3).getMargin();
          k = n;
          if (((ConstraintAnchor)localObject3).mTarget != null)
          {
            k = n;
            if (((ConstraintAnchor)localObject3).mTarget.mOwner.mTop.mTarget != null)
            {
              k = n;
              if (((ConstraintAnchor)localObject3).mTarget.mOwner.mTop.mTarget.mOwner == localObject6) {
                k = n + ((ConstraintAnchor)localObject3).mTarget.mOwner.mTop.getMargin();
              }
            }
          }
          ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject2, ((ConstraintAnchor)localObject3).mTarget.mSolverVariable, -k, 2);
        }
        if (localConstraintWidget.mMatchConstraintMaxHeight > 0) {
          ((LinearSystem)localObject1).addLowerThan((SolverVariable)localObject8, (SolverVariable)localObject7, localConstraintWidget.mMatchConstraintMaxHeight, 2);
        }
        localObject3 = paramLinearSystem.createRow();
        ((ArrayRow)localObject3).createRowEqualDimension(((ConstraintWidget)localObject5).mVerticalWeight, f, ((ConstraintWidget)localObject6).mVerticalWeight, (SolverVariable)localObject7, ((ConstraintWidget)localObject5).mTop.getMargin(), (SolverVariable)localObject8, ((ConstraintWidget)localObject5).mBottom.getMargin(), (SolverVariable)localObject9, ((ConstraintWidget)localObject6).mTop.getMargin(), (SolverVariable)localObject2, ((ConstraintWidget)localObject6).mBottom.getMargin());
        ((LinearSystem)localObject1).addConstraint((ArrayRow)localObject3);
        k = m;
      }
      label1674:
      localObject4 = localObject2;
      Object localObject5 = null;
      Object localObject8 = localObject5;
      k = 0;
      Object localObject3 = localObject1;
      n = j;
      localObject1 = localObject5;
      while (localObject4 != null)
      {
        localObject7 = ((ConstraintWidget)localObject4).mVerticalNextWidget;
        if (localObject7 == null)
        {
          localObject5 = this.mChainEnds[1];
          j = 1;
        }
        else
        {
          j = k;
          localObject5 = localObject1;
        }
        if (m != 0)
        {
          localObject9 = ((ConstraintWidget)localObject4).mTop;
          i1 = ((ConstraintAnchor)localObject9).getMargin();
          k = i1;
          if (localObject8 != null) {
            k = i1 + ((ConstraintWidget)localObject8).mBottom.getMargin();
          }
          if (localObject2 != localObject4) {
            i1 = 3;
          } else {
            i1 = 1;
          }
          if (((ConstraintAnchor)localObject9).mTarget != null)
          {
            localObject1 = ((ConstraintAnchor)localObject9).mSolverVariable;
            localObject6 = ((ConstraintAnchor)localObject9).mTarget.mSolverVariable;
          }
          else if (((ConstraintWidget)localObject4).mBaseline.mTarget != null)
          {
            localObject1 = ((ConstraintWidget)localObject4).mBaseline.mSolverVariable;
            localObject6 = ((ConstraintWidget)localObject4).mBaseline.mTarget.mSolverVariable;
            k -= ((ConstraintAnchor)localObject9).getMargin();
          }
          else
          {
            localObject1 = null;
            localObject6 = localObject1;
          }
          if ((localObject1 != null) && (localObject6 != null)) {
            ((LinearSystem)localObject3).addGreaterThan((SolverVariable)localObject1, (SolverVariable)localObject6, k, i1);
          }
          if (((ConstraintWidget)localObject4).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            localObject1 = ((ConstraintWidget)localObject4).mBottom;
            if (((ConstraintWidget)localObject4).mMatchConstraintDefaultHeight == 1)
            {
              k = Math.max(((ConstraintWidget)localObject4).mMatchConstraintMinHeight, ((ConstraintWidget)localObject4).getHeight());
              ((LinearSystem)localObject3).addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject9).mSolverVariable, k, 3);
            }
            else
            {
              ((LinearSystem)localObject3).addGreaterThan(((ConstraintAnchor)localObject9).mSolverVariable, ((ConstraintAnchor)localObject9).mTarget.mSolverVariable, ((ConstraintAnchor)localObject9).mMargin, 3);
              ((LinearSystem)localObject3).addLowerThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject9).mSolverVariable, ((ConstraintWidget)localObject4).mMatchConstraintMinHeight, 3);
            }
          }
        }
        else if ((n == 0) && (j != 0) && (localObject8 != null))
        {
          if (((ConstraintWidget)localObject4).mBottom.mTarget == null)
          {
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mBottom.mSolverVariable, ((ConstraintWidget)localObject4).getDrawBottom());
          }
          else
          {
            k = ((ConstraintWidget)localObject4).mBottom.getMargin();
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mBottom.mSolverVariable, ((ConstraintWidget)localObject5).mBottom.mTarget.mSolverVariable, -k, 5);
          }
        }
        else
        {
          if ((n != 0) || (j != 0) || (localObject8 != null)) {
            break label2197;
          }
          if (((ConstraintWidget)localObject4).mTop.mTarget == null)
          {
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mTop.mSolverVariable, ((ConstraintWidget)localObject4).getDrawY());
          }
          else
          {
            k = ((ConstraintWidget)localObject4).mTop.getMargin();
            ((LinearSystem)localObject3).addEquality(((ConstraintWidget)localObject4).mTop.mSolverVariable, localConstraintWidget.mTop.mTarget.mSolverVariable, k, 5);
          }
        }
        localObject1 = localObject7;
        break label2462;
        label2197:
        localObject10 = ((ConstraintWidget)localObject4).mTop;
        localObject9 = ((ConstraintWidget)localObject4).mBottom;
        k = ((ConstraintAnchor)localObject10).getMargin();
        i1 = ((ConstraintAnchor)localObject9).getMargin();
        ((LinearSystem)localObject3).addGreaterThan(((ConstraintAnchor)localObject10).mSolverVariable, ((ConstraintAnchor)localObject10).mTarget.mSolverVariable, k, 1);
        ((LinearSystem)localObject3).addLowerThan(((ConstraintAnchor)localObject9).mSolverVariable, ((ConstraintAnchor)localObject9).mTarget.mSolverVariable, -i1, 1);
        if (((ConstraintAnchor)localObject10).mTarget != null) {
          localObject6 = ((ConstraintAnchor)localObject10).mTarget.mSolverVariable;
        } else {
          localObject6 = null;
        }
        if (localObject8 == null) {
          if (localConstraintWidget.mTop.mTarget != null) {
            localObject6 = localConstraintWidget.mTop.mTarget.mSolverVariable;
          } else {
            localObject6 = null;
          }
        }
        localObject1 = localObject7;
        if (localObject7 == null) {
          if (((ConstraintWidget)localObject5).mBottom.mTarget != null) {
            localObject1 = ((ConstraintWidget)localObject5).mBottom.mTarget.mOwner;
          } else {
            localObject1 = null;
          }
        }
        if (localObject1 != null)
        {
          localObject7 = ((ConstraintWidget)localObject1).mTop.mSolverVariable;
          if (j != 0) {
            if (((ConstraintWidget)localObject5).mBottom.mTarget != null) {
              localObject7 = ((ConstraintWidget)localObject5).mBottom.mTarget.mSolverVariable;
            } else {
              localObject7 = null;
            }
          }
          if ((localObject6 != null) && (localObject7 != null))
          {
            localObject8 = ((ConstraintAnchor)localObject10).mSolverVariable;
            localObject9 = ((ConstraintAnchor)localObject9).mSolverVariable;
            paramLinearSystem.addCentering((SolverVariable)localObject8, (SolverVariable)localObject6, k, 0.5F, (SolverVariable)localObject7, (SolverVariable)localObject9, i1, 4);
          }
        }
        label2462:
        if (j != 0) {
          localObject1 = null;
        }
        localObject8 = localObject4;
        localObject4 = localObject1;
        localObject1 = localObject5;
        k = j;
      }
      localObject4 = localObject3;
      localObject3 = localObject4;
      j = i;
      if (m != 0)
      {
        localObject5 = ((ConstraintWidget)localObject2).mTop;
        localObject6 = ((ConstraintWidget)localObject1).mBottom;
        k = ((ConstraintAnchor)localObject5).getMargin();
        m = ((ConstraintAnchor)localObject6).getMargin();
        if (localConstraintWidget.mTop.mTarget != null) {
          localObject2 = localConstraintWidget.mTop.mTarget.mSolverVariable;
        } else {
          localObject2 = null;
        }
        if (((ConstraintWidget)localObject1).mBottom.mTarget != null) {
          localObject1 = ((ConstraintWidget)localObject1).mBottom.mTarget.mSolverVariable;
        } else {
          localObject1 = null;
        }
        localObject3 = localObject4;
        j = i;
        if (localObject2 != null)
        {
          localObject3 = localObject4;
          j = i;
          if (localObject1 != null)
          {
            ((LinearSystem)localObject4).addLowerThan(((ConstraintAnchor)localObject6).mSolverVariable, (SolverVariable)localObject1, -m, 1);
            paramLinearSystem.addCentering(((ConstraintAnchor)localObject5).mSolverVariable, (SolverVariable)localObject2, k, localConstraintWidget.mVerticalBiasPercent, (SolverVariable)localObject1, ((ConstraintAnchor)localObject6).mSolverVariable, m, 4);
            j = i;
            localObject3 = localObject4;
          }
        }
      }
      label2668:
      i = j + 1;
      localObject1 = localObject3;
    }
  }
  
  private int countMatchConstraintsChainedWidgets(LinearSystem paramLinearSystem, ConstraintWidget[] paramArrayOfConstraintWidget, ConstraintWidget paramConstraintWidget, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = true;
    paramArrayOfBoolean[1] = false;
    paramArrayOfConstraintWidget[0] = null;
    paramArrayOfConstraintWidget[2] = null;
    paramArrayOfConstraintWidget[1] = null;
    paramArrayOfConstraintWidget[3] = null;
    boolean bool1;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int i;
    if (paramInt == 0)
    {
      if ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner != this)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramConstraintWidget.mHorizontalNextWidget = null;
      if (paramConstraintWidget.getVisibility() != 8) {
        localObject1 = paramConstraintWidget;
      } else {
        localObject1 = null;
      }
      localConstraintWidget2 = null;
      localObject2 = localObject1;
      paramInt = 0;
      localConstraintWidget1 = paramConstraintWidget;
      for (;;)
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        i = paramInt;
        if (localConstraintWidget1.mRight.mTarget == null) {
          break;
        }
        localConstraintWidget1.mHorizontalNextWidget = null;
        if (localConstraintWidget1.getVisibility() != 8)
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = localConstraintWidget1;
          }
          if ((localObject2 != null) && (localObject2 != localConstraintWidget1)) {
            localObject2.mHorizontalNextWidget = localConstraintWidget1;
          }
          localObject2 = localConstraintWidget1;
          localObject1 = localObject3;
        }
        else
        {
          paramLinearSystem.addEquality(localConstraintWidget1.mLeft.mSolverVariable, localConstraintWidget1.mLeft.mTarget.mSolverVariable, 0, 5);
          paramLinearSystem.addEquality(localConstraintWidget1.mRight.mSolverVariable, localConstraintWidget1.mLeft.mSolverVariable, 0, 5);
        }
        i = paramInt;
        if (localConstraintWidget1.getVisibility() != 8)
        {
          i = paramInt;
          if (localConstraintWidget1.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            if (localConstraintWidget1.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
              paramArrayOfBoolean[0] = false;
            }
            i = paramInt;
            if (localConstraintWidget1.mDimensionRatio <= 0.0F)
            {
              paramArrayOfBoolean[0] = false;
              i = paramInt + 1;
              localObject3 = this.mMatchConstraintsChainedWidgets;
              if (i >= localObject3.length) {
                this.mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf((Object[])localObject3, localObject3.length * 2));
              }
              this.mMatchConstraintsChainedWidgets[paramInt] = localConstraintWidget1;
            }
          }
        }
        if (localConstraintWidget1.mRight.mTarget.mOwner.mLeft.mTarget == null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          break;
        }
        if (localConstraintWidget1.mRight.mTarget.mOwner.mLeft.mTarget.mOwner != localConstraintWidget1)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          break;
        }
        if (localConstraintWidget1.mRight.mTarget.mOwner == localConstraintWidget1)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          break;
        }
        localConstraintWidget2 = localConstraintWidget1.mRight.mTarget.mOwner;
        localConstraintWidget1 = localConstraintWidget2;
        paramInt = i;
      }
      bool2 = bool1;
      if (localConstraintWidget1.mRight.mTarget != null)
      {
        bool2 = bool1;
        if (localConstraintWidget1.mRight.mTarget.mOwner != this) {
          bool2 = false;
        }
      }
      if ((paramConstraintWidget.mLeft.mTarget != null) && (localConstraintWidget2.mRight.mTarget != null)) {
        break label528;
      }
      paramArrayOfBoolean[1] = true;
      label528:
      paramConstraintWidget.mHorizontalChainFixedPosition = bool2;
      localConstraintWidget2.mHorizontalNextWidget = null;
      paramArrayOfConstraintWidget[0] = paramConstraintWidget;
      paramArrayOfConstraintWidget[2] = localObject3;
      paramArrayOfConstraintWidget[1] = localConstraintWidget2;
      paramArrayOfConstraintWidget[3] = localObject4;
      return i;
    }
    if ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner != this)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    paramConstraintWidget.mVerticalNextWidget = null;
    if (paramConstraintWidget.getVisibility() != 8) {
      localObject1 = paramConstraintWidget;
    } else {
      localObject1 = null;
    }
    ConstraintWidget localConstraintWidget2 = null;
    Object localObject2 = localObject1;
    paramInt = 0;
    ConstraintWidget localConstraintWidget1 = paramConstraintWidget;
    for (;;)
    {
      localObject3 = localObject1;
      localObject4 = localObject2;
      i = paramInt;
      if (localConstraintWidget1.mBottom.mTarget == null) {
        break;
      }
      localConstraintWidget1.mVerticalNextWidget = null;
      if (localConstraintWidget1.getVisibility() != 8)
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = localConstraintWidget1;
        }
        if ((localObject2 != null) && (localObject2 != localConstraintWidget1)) {
          localObject2.mVerticalNextWidget = localConstraintWidget1;
        }
        localObject2 = localConstraintWidget1;
        localObject1 = localObject3;
      }
      else
      {
        paramLinearSystem.addEquality(localConstraintWidget1.mTop.mSolverVariable, localConstraintWidget1.mTop.mTarget.mSolverVariable, 0, 5);
        paramLinearSystem.addEquality(localConstraintWidget1.mBottom.mSolverVariable, localConstraintWidget1.mTop.mSolverVariable, 0, 5);
      }
      if ((localConstraintWidget1.getVisibility() != 8) && (localConstraintWidget1.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        if (localConstraintWidget1.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          paramArrayOfBoolean[0] = false;
        }
        i = paramInt;
        if (localConstraintWidget1.mDimensionRatio <= 0.0F)
        {
          paramArrayOfBoolean[0] = false;
          i = paramInt + 1;
          localObject3 = this.mMatchConstraintsChainedWidgets;
          if (i >= localObject3.length) {
            this.mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf((Object[])localObject3, localObject3.length * 2));
          }
          this.mMatchConstraintsChainedWidgets[paramInt] = localConstraintWidget1;
        }
      }
      else
      {
        i = paramInt;
      }
      if ((localConstraintWidget1.mBottom.mTarget.mOwner.mTop.mTarget == null) || (localConstraintWidget1.mBottom.mTarget.mOwner.mTop.mTarget.mOwner != localConstraintWidget1) || (localConstraintWidget1.mBottom.mTarget.mOwner == localConstraintWidget1))
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        break;
      }
      localConstraintWidget2 = localConstraintWidget1.mBottom.mTarget.mOwner;
      localConstraintWidget1 = localConstraintWidget2;
      paramInt = i;
    }
    boolean bool2 = bool1;
    if (localConstraintWidget1.mBottom.mTarget != null)
    {
      bool2 = bool1;
      if (localConstraintWidget1.mBottom.mTarget.mOwner != this) {
        bool2 = false;
      }
    }
    if ((paramConstraintWidget.mTop.mTarget != null) && (localConstraintWidget2.mBottom.mTarget != null)) {
      break label1042;
    }
    paramArrayOfBoolean[1] = true;
    label1042:
    paramConstraintWidget.mVerticalChainFixedPosition = bool2;
    localConstraintWidget2.mVerticalNextWidget = null;
    paramArrayOfConstraintWidget[0] = paramConstraintWidget;
    paramArrayOfConstraintWidget[2] = localObject3;
    paramArrayOfConstraintWidget[1] = localConstraintWidget2;
    paramArrayOfConstraintWidget[3] = localObject4;
    return i;
  }
  
  public static ConstraintWidgetContainer createContainer(ConstraintWidgetContainer paramConstraintWidgetContainer, String paramString, ArrayList<ConstraintWidget> paramArrayList, int paramInt)
  {
    Rectangle localRectangle = getBounds(paramArrayList);
    if ((localRectangle.width != 0) && (localRectangle.height != 0))
    {
      if (paramInt > 0)
      {
        int j = Math.min(localRectangle.x, localRectangle.y);
        i = paramInt;
        if (paramInt > j) {
          i = j;
        }
        localRectangle.grow(i, i);
      }
      paramConstraintWidgetContainer.setOrigin(localRectangle.x, localRectangle.y);
      paramConstraintWidgetContainer.setDimension(localRectangle.width, localRectangle.height);
      paramConstraintWidgetContainer.setDebugName(paramString);
      paramInt = 0;
      paramString = ((ConstraintWidget)paramArrayList.get(0)).getParent();
      int i = paramArrayList.size();
      while (paramInt < i)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(paramInt);
        if (localConstraintWidget.getParent() == paramString)
        {
          paramConstraintWidgetContainer.add(localConstraintWidget);
          localConstraintWidget.setX(localConstraintWidget.getX() - localRectangle.x);
          localConstraintWidget.setY(localConstraintWidget.getY() - localRectangle.y);
        }
        paramInt += 1;
      }
      return paramConstraintWidgetContainer;
    }
    return null;
  }
  
  private boolean optimize(LinearSystem paramLinearSystem)
  {
    int i4 = this.mChildren.size();
    int i = 0;
    ConstraintWidget localConstraintWidget;
    while (i < i4)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.mHorizontalResolution = -1;
      localConstraintWidget.mVerticalResolution = -1;
      if ((localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
      {
        localConstraintWidget.mHorizontalResolution = 1;
        localConstraintWidget.mVerticalResolution = 1;
      }
      i += 1;
    }
    int k = 0;
    int m = 0;
    for (int n = 0; k == 0; n = i)
    {
      int i1 = 0;
      j = 0;
      int i3;
      for (i = 0; i1 < i4; i = i3)
      {
        localConstraintWidget = (ConstraintWidget)this.mChildren.get(i1);
        if (localConstraintWidget.mHorizontalResolution == -1) {
          if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            localConstraintWidget.mHorizontalResolution = 1;
          } else {
            Optimizer.checkHorizontalSimpleDependency(this, paramLinearSystem, localConstraintWidget);
          }
        }
        if (localConstraintWidget.mVerticalResolution == -1) {
          if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            localConstraintWidget.mVerticalResolution = 1;
          } else {
            Optimizer.checkVerticalSimpleDependency(this, paramLinearSystem, localConstraintWidget);
          }
        }
        int i2 = j;
        if (localConstraintWidget.mVerticalResolution == -1) {
          i2 = j + 1;
        }
        i3 = i;
        if (localConstraintWidget.mHorizontalResolution == -1) {
          i3 = i + 1;
        }
        i1 += 1;
        j = i2;
      }
      if ((j == 0) && (i == 0)) {}
      do
      {
        i1 = 1;
        break;
        i1 = k;
        if (m != j) {
          break;
        }
        i1 = k;
      } while (n == i);
      k = i1;
      m = j;
    }
    i = 0;
    m = 0;
    for (int j = 0; i < i4; j = n)
    {
      paramLinearSystem = (ConstraintWidget)this.mChildren.get(i);
      if (paramLinearSystem.mHorizontalResolution != 1)
      {
        k = m;
        if (paramLinearSystem.mHorizontalResolution != -1) {}
      }
      else
      {
        k = m + 1;
      }
      if (paramLinearSystem.mVerticalResolution != 1)
      {
        n = j;
        if (paramLinearSystem.mVerticalResolution != -1) {}
      }
      else
      {
        n = j + 1;
      }
      i += 1;
      m = k;
    }
    return (m == 0) && (j == 0);
  }
  
  private void resetChains()
  {
    this.mHorizontalChainsSize = 0;
    this.mVerticalChainsSize = 0;
  }
  
  static int setGroup(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    int i = paramConstraintAnchor.mGroup;
    if (paramConstraintAnchor.mOwner.getParent() == null) {
      return paramInt;
    }
    if (i <= paramInt) {
      return i;
    }
    paramConstraintAnchor.mGroup = paramInt;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintAnchor.getOpposite();
    ConstraintAnchor localConstraintAnchor2 = paramConstraintAnchor.mTarget;
    i = paramInt;
    if (localConstraintAnchor1 != null) {
      i = setGroup(localConstraintAnchor1, paramInt);
    }
    paramInt = i;
    if (localConstraintAnchor2 != null) {
      paramInt = setGroup(localConstraintAnchor2, i);
    }
    i = paramInt;
    if (localConstraintAnchor1 != null) {
      i = setGroup(localConstraintAnchor1, paramInt);
    }
    paramConstraintAnchor.mGroup = i;
    return i;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      while ((paramConstraintWidget.mLeft.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget != null) && (paramConstraintWidget.mLeft.mTarget.mOwner.mRight.mTarget == paramConstraintWidget.mLeft) && (paramConstraintWidget.mLeft.mTarget.mOwner != paramConstraintWidget)) {
        paramConstraintWidget = paramConstraintWidget.mLeft.mTarget.mOwner;
      }
      addHorizontalChain(paramConstraintWidget);
      return;
    }
    if (paramInt == 1)
    {
      while ((paramConstraintWidget.mTop.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget != null) && (paramConstraintWidget.mTop.mTarget.mOwner.mBottom.mTarget == paramConstraintWidget.mTop) && (paramConstraintWidget.mTop.mTarget.mOwner != paramConstraintWidget)) {
        paramConstraintWidget = paramConstraintWidget.mTop.mTarget.mOwner;
      }
      addVerticalChain(paramConstraintWidget);
    }
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    addToSolver(paramLinearSystem, paramInt);
    int k = this.mChildren.size();
    int i = this.mOptimizationLevel;
    int j = 0;
    if ((i != 2) && (i != 4))
    {
      i = 1;
    }
    else
    {
      if (optimize(paramLinearSystem)) {
        return false;
      }
      i = 0;
    }
    while (j < k)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(j);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = localConstraintWidget.mHorizontalDimensionBehaviour;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = localConstraintWidget.mVerticalDimensionBehaviour;
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      else
      {
        if (i != 0) {
          Optimizer.checkMatchParent(this, paramLinearSystem, localConstraintWidget);
        }
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
      }
      j += 1;
    }
    if (this.mHorizontalChainsSize > 0) {
      applyHorizontalChain(paramLinearSystem);
    }
    if (this.mVerticalChainsSize > 0) {
      applyVerticalChain(paramLinearSystem);
    }
    return true;
  }
  
  public void findHorizontalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfBoolean)
  {
    Object localObject1 = paramConstraintWidget.mHorizontalDimensionBehaviour;
    Object localObject2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    int k = 0;
    int i = 0;
    if ((localObject1 == localObject2) && (paramConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int j = paramConstraintWidget.getOptimizerWrapWidth();
    if ((paramConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    boolean bool2 = true;
    paramConstraintWidget.mHorizontalWrapVisited = true;
    if ((paramConstraintWidget instanceof Guideline))
    {
      paramArrayOfBoolean = (Guideline)paramConstraintWidget;
      if (paramArrayOfBoolean.getOrientation() == 1)
      {
        if (paramArrayOfBoolean.getRelativeBegin() != -1)
        {
          i = paramArrayOfBoolean.getRelativeBegin();
        }
        else if (paramArrayOfBoolean.getRelativeEnd() != -1)
        {
          j = paramArrayOfBoolean.getRelativeEnd();
          i = k;
          break label160;
        }
        j = 0;
      }
      else
      {
        i = j;
      }
    }
    for (;;)
    {
      label160:
      break;
      if ((!paramConstraintWidget.mRight.isConnected()) && (!paramConstraintWidget.mLeft.isConnected()))
      {
        i = j + paramConstraintWidget.getX();
      }
      else
      {
        if ((paramConstraintWidget.mRight.mTarget != null) && (paramConstraintWidget.mLeft.mTarget != null) && ((paramConstraintWidget.mRight.mTarget == paramConstraintWidget.mLeft.mTarget) || ((paramConstraintWidget.mRight.mTarget.mOwner == paramConstraintWidget.mLeft.mTarget.mOwner) && (paramConstraintWidget.mRight.mTarget.mOwner != paramConstraintWidget.mParent))))
        {
          paramArrayOfBoolean[0] = false;
          return;
        }
        localObject1 = paramConstraintWidget.mRight.mTarget;
        localObject2 = null;
        ConstraintWidget localConstraintWidget;
        if (localObject1 != null)
        {
          localConstraintWidget = paramConstraintWidget.mRight.mTarget.mOwner;
          i = paramConstraintWidget.mRight.getMargin() + j;
          localObject1 = localConstraintWidget;
          k = i;
          if (!localConstraintWidget.isRoot())
          {
            localObject1 = localConstraintWidget;
            k = i;
            if (!localConstraintWidget.mHorizontalWrapVisited)
            {
              findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
              localObject1 = localConstraintWidget;
              k = i;
            }
          }
        }
        else
        {
          k = j;
          localObject1 = null;
        }
        i = j;
        if (paramConstraintWidget.mLeft.mTarget != null)
        {
          localConstraintWidget = paramConstraintWidget.mLeft.mTarget.mOwner;
          j += paramConstraintWidget.mLeft.getMargin();
          i = j;
          localObject2 = localConstraintWidget;
          if (!localConstraintWidget.isRoot())
          {
            i = j;
            localObject2 = localConstraintWidget;
            if (!localConstraintWidget.mHorizontalWrapVisited)
            {
              findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
              localObject2 = localConstraintWidget;
              i = j;
            }
          }
        }
        j = k;
        boolean bool1;
        if (paramConstraintWidget.mRight.mTarget != null)
        {
          j = k;
          if (!((ConstraintWidget)localObject1).isRoot())
          {
            if (paramConstraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.RIGHT) {}
            for (j = ((ConstraintWidget)localObject1).mDistToRight - ((ConstraintWidget)localObject1).getOptimizerWrapWidth();; j = ((ConstraintWidget)localObject1).mDistToRight)
            {
              m = k + j;
              break;
              m = k;
              if (paramConstraintWidget.mRight.mTarget.getType() != ConstraintAnchor.Type.LEFT) {
                break;
              }
            }
            if ((!((ConstraintWidget)localObject1).mRightHasCentered) && ((((ConstraintWidget)localObject1).mLeft.mTarget == null) || (((ConstraintWidget)localObject1).mRight.mTarget == null) || (((ConstraintWidget)localObject1).mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            paramConstraintWidget.mRightHasCentered = bool1;
            j = m;
            if (paramConstraintWidget.mRightHasCentered) {
              if (((ConstraintWidget)localObject1).mLeft.mTarget != null)
              {
                j = m;
                if (((ConstraintWidget)localObject1).mLeft.mTarget.mOwner == paramConstraintWidget) {}
              }
              else
              {
                j = m + (m - ((ConstraintWidget)localObject1).mDistToRight);
              }
            }
          }
        }
        m = i;
        if (paramConstraintWidget.mLeft.mTarget != null)
        {
          m = i;
          if (!((ConstraintWidget)localObject2).isRoot())
          {
            if (paramConstraintWidget.mLeft.mTarget.getType() == ConstraintAnchor.Type.LEFT) {}
            for (k = ((ConstraintWidget)localObject2).mDistToLeft - ((ConstraintWidget)localObject2).getOptimizerWrapWidth();; k = ((ConstraintWidget)localObject2).mDistToLeft)
            {
              k = i + k;
              break;
              k = i;
              if (paramConstraintWidget.mLeft.mTarget.getType() != ConstraintAnchor.Type.RIGHT) {
                break;
              }
            }
            bool1 = bool2;
            if (!((ConstraintWidget)localObject2).mLeftHasCentered) {
              if ((((ConstraintWidget)localObject2).mLeft.mTarget != null) && (((ConstraintWidget)localObject2).mRight.mTarget != null) && (((ConstraintWidget)localObject2).mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            paramConstraintWidget.mLeftHasCentered = bool1;
            m = k;
            if (paramConstraintWidget.mLeftHasCentered) {
              if (((ConstraintWidget)localObject2).mRight.mTarget != null)
              {
                m = k;
                if (((ConstraintWidget)localObject2).mRight.mTarget.mOwner == paramConstraintWidget) {}
              }
              else
              {
                i = k + (k - ((ConstraintWidget)localObject2).mDistToLeft);
                break;
              }
            }
          }
        }
        i = m;
      }
    }
    int m = i;
    k = j;
    if (paramConstraintWidget.getVisibility() == 8)
    {
      m = i - paramConstraintWidget.mWidth;
      k = j - paramConstraintWidget.mWidth;
    }
    paramConstraintWidget.mDistToLeft = m;
    paramConstraintWidget.mDistToRight = k;
  }
  
  public void findVerticalWrapRecursive(ConstraintWidget paramConstraintWidget, boolean[] paramArrayOfBoolean)
  {
    Object localObject1 = paramConstraintWidget.mVerticalDimensionBehaviour;
    Object localObject2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    int j = 0;
    int i = 0;
    if ((localObject1 == localObject2) && (paramConstraintWidget.mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (paramConstraintWidget.mDimensionRatio > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int k = paramConstraintWidget.getOptimizerWrapHeight();
    boolean bool2 = true;
    paramConstraintWidget.mVerticalWrapVisited = true;
    if ((paramConstraintWidget instanceof Guideline))
    {
      paramArrayOfBoolean = (Guideline)paramConstraintWidget;
      if (paramArrayOfBoolean.getOrientation() == 0)
      {
        if (paramArrayOfBoolean.getRelativeBegin() != -1)
        {
          i = paramArrayOfBoolean.getRelativeBegin();
        }
        else if (paramArrayOfBoolean.getRelativeEnd() != -1)
        {
          k = paramArrayOfBoolean.getRelativeEnd();
          i = j;
          break label125;
        }
        k = 0;
      }
    }
    for (i = k;; i = k + paramConstraintWidget.getY())
    {
      label125:
      m = i;
      i = k;
      break label1052;
      if ((paramConstraintWidget.mBaseline.mTarget != null) || (paramConstraintWidget.mTop.mTarget != null) || (paramConstraintWidget.mBottom.mTarget != null)) {
        break;
      }
    }
    if ((paramConstraintWidget.mBottom.mTarget != null) && (paramConstraintWidget.mTop.mTarget != null) && ((paramConstraintWidget.mBottom.mTarget == paramConstraintWidget.mTop.mTarget) || ((paramConstraintWidget.mBottom.mTarget.mOwner == paramConstraintWidget.mTop.mTarget.mOwner) && (paramConstraintWidget.mBottom.mTarget.mOwner != paramConstraintWidget.mParent))))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    if (paramConstraintWidget.mBaseline.isConnected())
    {
      localObject1 = paramConstraintWidget.mBaseline.mTarget.getOwner();
      if (!((ConstraintWidget)localObject1).mVerticalWrapVisited) {
        findVerticalWrapRecursive((ConstraintWidget)localObject1, paramArrayOfBoolean);
      }
      m = Math.max(((ConstraintWidget)localObject1).mDistToTop - ((ConstraintWidget)localObject1).mHeight + k, k);
      k = Math.max(((ConstraintWidget)localObject1).mDistToBottom - ((ConstraintWidget)localObject1).mHeight + k, k);
      j = k;
      i = m;
      if (paramConstraintWidget.getVisibility() == 8)
      {
        i = m - paramConstraintWidget.mHeight;
        j = k - paramConstraintWidget.mHeight;
      }
      paramConstraintWidget.mDistToTop = i;
      paramConstraintWidget.mDistToBottom = j;
      return;
    }
    boolean bool1 = paramConstraintWidget.mTop.isConnected();
    localObject2 = null;
    ConstraintWidget localConstraintWidget;
    if (bool1)
    {
      localConstraintWidget = paramConstraintWidget.mTop.mTarget.getOwner();
      j = paramConstraintWidget.mTop.getMargin() + k;
      localObject1 = localConstraintWidget;
      i = j;
      if (!localConstraintWidget.isRoot())
      {
        localObject1 = localConstraintWidget;
        i = j;
        if (!localConstraintWidget.mVerticalWrapVisited)
        {
          findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
          localObject1 = localConstraintWidget;
          i = j;
        }
      }
    }
    else
    {
      i = k;
      localObject1 = null;
    }
    j = k;
    if (paramConstraintWidget.mBottom.isConnected())
    {
      localConstraintWidget = paramConstraintWidget.mBottom.mTarget.getOwner();
      k += paramConstraintWidget.mBottom.getMargin();
      j = k;
      localObject2 = localConstraintWidget;
      if (!localConstraintWidget.isRoot())
      {
        j = k;
        localObject2 = localConstraintWidget;
        if (!localConstraintWidget.mVerticalWrapVisited)
        {
          findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
          localObject2 = localConstraintWidget;
          j = k;
        }
      }
    }
    k = i;
    if (paramConstraintWidget.mTop.mTarget != null)
    {
      k = i;
      if (!((ConstraintWidget)localObject1).isRoot())
      {
        if (paramConstraintWidget.mTop.mTarget.getType() == ConstraintAnchor.Type.TOP) {}
        for (k = ((ConstraintWidget)localObject1).mDistToTop - ((ConstraintWidget)localObject1).getOptimizerWrapHeight();; k = ((ConstraintWidget)localObject1).mDistToTop)
        {
          m = i + k;
          break;
          m = i;
          if (paramConstraintWidget.mTop.mTarget.getType() != ConstraintAnchor.Type.BOTTOM) {
            break;
          }
        }
        if ((!((ConstraintWidget)localObject1).mTopHasCentered) && ((((ConstraintWidget)localObject1).mTop.mTarget == null) || (((ConstraintWidget)localObject1).mTop.mTarget.mOwner == paramConstraintWidget) || (((ConstraintWidget)localObject1).mBottom.mTarget == null) || (((ConstraintWidget)localObject1).mBottom.mTarget.mOwner == paramConstraintWidget) || (((ConstraintWidget)localObject1).mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        paramConstraintWidget.mTopHasCentered = bool1;
        k = m;
        if (paramConstraintWidget.mTopHasCentered) {
          if (((ConstraintWidget)localObject1).mBottom.mTarget != null)
          {
            k = m;
            if (((ConstraintWidget)localObject1).mBottom.mTarget.mOwner == paramConstraintWidget) {}
          }
          else
          {
            k = m + (m - ((ConstraintWidget)localObject1).mDistToTop);
          }
        }
      }
    }
    i = j;
    int m = k;
    if (paramConstraintWidget.mBottom.mTarget != null)
    {
      i = j;
      m = k;
      if (!((ConstraintWidget)localObject2).isRoot())
      {
        if (paramConstraintWidget.mBottom.mTarget.getType() == ConstraintAnchor.Type.BOTTOM) {}
        int n;
        for (i = ((ConstraintWidget)localObject2).mDistToBottom - ((ConstraintWidget)localObject2).getOptimizerWrapHeight();; i = ((ConstraintWidget)localObject2).mDistToBottom)
        {
          n = j + i;
          break;
          n = j;
          if (paramConstraintWidget.mBottom.mTarget.getType() != ConstraintAnchor.Type.TOP) {
            break;
          }
        }
        bool1 = bool2;
        if (!((ConstraintWidget)localObject2).mBottomHasCentered) {
          if ((((ConstraintWidget)localObject2).mTop.mTarget != null) && (((ConstraintWidget)localObject2).mTop.mTarget.mOwner != paramConstraintWidget) && (((ConstraintWidget)localObject2).mBottom.mTarget != null) && (((ConstraintWidget)localObject2).mBottom.mTarget.mOwner != paramConstraintWidget) && (((ConstraintWidget)localObject2).mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        paramConstraintWidget.mBottomHasCentered = bool1;
        i = n;
        m = k;
        if (paramConstraintWidget.mBottomHasCentered) {
          if (((ConstraintWidget)localObject2).mTop.mTarget != null)
          {
            i = n;
            m = k;
            if (((ConstraintWidget)localObject2).mTop.mTarget.mOwner == paramConstraintWidget) {}
          }
          else
          {
            i = n + (n - ((ConstraintWidget)localObject2).mDistToBottom);
            m = k;
          }
        }
      }
    }
    label1052:
    k = i;
    j = m;
    if (paramConstraintWidget.getVisibility() == 8)
    {
      j = m - paramConstraintWidget.mHeight;
      k = i - paramConstraintWidget.mHeight;
    }
    paramConstraintWidget.mDistToTop = j;
    paramConstraintWidget.mDistToBottom = k;
  }
  
  public void findWrapSize(ArrayList<ConstraintWidget> paramArrayList, boolean[] paramArrayOfBoolean)
  {
    int i5 = paramArrayList.size();
    paramArrayOfBoolean[0] = true;
    int m = 0;
    int i4 = 0;
    int i3 = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    while (m < i5)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(m);
      if (!localConstraintWidget.isRoot())
      {
        if (!localConstraintWidget.mHorizontalWrapVisited) {
          findHorizontalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
        }
        if (!localConstraintWidget.mVerticalWrapVisited) {
          findVerticalWrapRecursive(localConstraintWidget, paramArrayOfBoolean);
        }
        if (paramArrayOfBoolean[0] == 0) {
          return;
        }
        i = localConstraintWidget.mDistToLeft;
        int i8 = localConstraintWidget.mDistToRight;
        int i9 = localConstraintWidget.getWidth();
        int j = localConstraintWidget.mDistToTop;
        int i6 = localConstraintWidget.mDistToBottom;
        int i7 = localConstraintWidget.getHeight();
        if (localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
          i = localConstraintWidget.getWidth() + localConstraintWidget.mLeft.mMargin + localConstraintWidget.mRight.mMargin;
        } else {
          i = i + i8 - i9;
        }
        if (localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
          j = localConstraintWidget.getHeight() + localConstraintWidget.mTop.mMargin + localConstraintWidget.mBottom.mMargin;
        } else {
          j = j + i6 - i7;
        }
        if (localConstraintWidget.getVisibility() == 8)
        {
          i = 0;
          j = 0;
        }
        i4 = Math.max(i4, localConstraintWidget.mDistToLeft);
        i3 = Math.max(i3, localConstraintWidget.mDistToRight);
        i2 = Math.max(i2, localConstraintWidget.mDistToBottom);
        i1 = Math.max(i1, localConstraintWidget.mDistToTop);
        n = Math.max(n, i);
        k = Math.max(k, j);
      }
      m += 1;
    }
    int i = Math.max(i4, i3);
    this.mWrapWidth = Math.max(this.mMinWidth, Math.max(i, n));
    i = Math.max(i1, i2);
    this.mWrapHeight = Math.max(this.mMinHeight, Math.max(i, k));
    i = 0;
    while (i < i5)
    {
      paramArrayOfBoolean = (ConstraintWidget)paramArrayList.get(i);
      paramArrayOfBoolean.mHorizontalWrapVisited = false;
      paramArrayOfBoolean.mVerticalWrapVisited = false;
      paramArrayOfBoolean.mLeftHasCentered = false;
      paramArrayOfBoolean.mRightHasCentered = false;
      paramArrayOfBoolean.mTopHasCentered = false;
      paramArrayOfBoolean.mBottomHasCentered = false;
      i += 1;
    }
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 0) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public LinearSystem getSystem()
  {
    return this.mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ConstraintWidget)this.mChildren.get(i);
      if ((localObject instanceof Guideline))
      {
        localObject = (Guideline)localObject;
        if (((Guideline)localObject).getOrientation() == 1) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall()
  {
    return this.mHeightMeasuredTooSmall;
  }
  
  public boolean isWidthMeasuredTooSmall()
  {
    return this.mWidthMeasuredTooSmall;
  }
  
  public void layout()
  {
    int n = this.mX;
    int i1 = this.mY;
    int i2 = Math.max(0, getWidth());
    int i3 = Math.max(0, getHeight());
    this.mWidthMeasuredTooSmall = false;
    this.mHeightMeasuredTooSmall = false;
    if (this.mParent != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      setX(this.mPaddingLeft);
      setY(this.mPaddingTop);
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    }
    else
    {
      this.mX = 0;
      this.mY = 0;
    }
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = this.mVerticalDimensionBehaviour;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = this.mHorizontalDimensionBehaviour;
    if ((this.mOptimizationLevel == 2) && ((this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)))
    {
      findWrapSize(this.mChildren, this.flags);
      i6 = this.flags[0];
      i5 = i6;
      if (i2 > 0)
      {
        i5 = i6;
        if (i3 > 0) {
          if (this.mWrapWidth <= i2)
          {
            i5 = i6;
            if (this.mWrapHeight <= i3) {}
          }
          else
          {
            i5 = 0;
          }
        }
      }
      i6 = i5;
      if (i5 != 0)
      {
        if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
          if ((i2 > 0) && (i2 < this.mWrapWidth))
          {
            this.mWidthMeasuredTooSmall = true;
            setWidth(i2);
          }
          else
          {
            setWidth(Math.max(this.mMinWidth, this.mWrapWidth));
          }
        }
        i6 = i5;
        if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
          if ((i3 > 0) && (i3 < this.mWrapHeight))
          {
            this.mHeightMeasuredTooSmall = true;
            setHeight(i3);
            i6 = i5;
          }
          else
          {
            setHeight(Math.max(this.mMinHeight, this.mWrapHeight));
            i6 = i5;
          }
        }
      }
    }
    else
    {
      i6 = 0;
    }
    resetChains();
    int i4 = this.mChildren.size();
    int i = 0;
    while (i < i4)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget1 instanceof WidgetContainer)) {
        ((WidgetContainer)localConstraintWidget1).layout();
      }
      i += 1;
    }
    int i5 = i6;
    i = 0;
    int i6 = 1;
    int j;
    while (i6 != 0)
    {
      int m = i + 1;
      int i8 = i6;
      try
      {
        this.mSystem.reset();
        i8 = i6;
        i7 = addChildrenToSolver(this.mSystem, 2147483647);
        i8 = i7;
        if (i7 != 0)
        {
          i8 = i7;
          this.mSystem.minimize();
          i8 = i7;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ConstraintWidget localConstraintWidget2;
      if (i8 != 0)
      {
        updateChildrenFromSolver(this.mSystem, 2147483647, this.flags);
      }
      else
      {
        updateFromSolver(this.mSystem, 2147483647);
        i = 0;
        while (i < i4)
        {
          localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(i);
          if ((localConstraintWidget2.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getWidth() < localConstraintWidget2.getWrapWidth()))
          {
            this.flags[2] = true;
            break;
          }
          if ((localConstraintWidget2.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget2.getHeight() < localConstraintWidget2.getWrapHeight()))
          {
            this.flags[2] = true;
            break;
          }
          i += 1;
        }
      }
      if ((m < 8) && (this.flags[2] != 0))
      {
        j = 0;
        int k = 0;
        i = 0;
        while (j < i4)
        {
          localConstraintWidget2 = (ConstraintWidget)this.mChildren.get(j);
          k = Math.max(k, localConstraintWidget2.mX + localConstraintWidget2.getWidth());
          i = Math.max(i, localConstraintWidget2.mY + localConstraintWidget2.getHeight());
          j += 1;
        }
        j = Math.max(this.mMinWidth, k);
        i = Math.max(this.mMinHeight, i);
        if ((localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (getWidth() < j))
        {
          setWidth(j);
          this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
          i8 = 1;
          i9 = 1;
        }
        else
        {
          i8 = 0;
          i9 = i5;
        }
        i7 = i8;
        i5 = i9;
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          i7 = i8;
          i5 = i9;
          if (getHeight() < i)
          {
            setHeight(i);
            this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            i7 = 1;
            i5 = 1;
          }
        }
      }
      else
      {
        i7 = 0;
      }
      i = Math.max(this.mMinWidth, getWidth());
      i8 = i7;
      int i7 = i5;
      if (i > getWidth())
      {
        setWidth(i);
        this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        i8 = 1;
        i7 = 1;
      }
      i = Math.max(this.mMinHeight, getHeight());
      i5 = i8;
      if (i > getHeight())
      {
        setHeight(i);
        this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        i5 = 1;
        i7 = 1;
      }
      int i11 = i5;
      int i9 = i7;
      if (i7 == 0)
      {
        int i10 = i5;
        i8 = i7;
        if (this.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          i10 = i5;
          i8 = i7;
          if (i2 > 0)
          {
            i10 = i5;
            i8 = i7;
            if (getWidth() > i2)
            {
              this.mWidthMeasuredTooSmall = true;
              this.mHorizontalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              setWidth(i2);
              i10 = 1;
              i8 = 1;
            }
          }
        }
        i11 = i10;
        i9 = i8;
        if (this.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
        {
          i11 = i10;
          i9 = i8;
          if (i3 > 0)
          {
            i11 = i10;
            i9 = i8;
            if (getHeight() > i3)
            {
              this.mHeightMeasuredTooSmall = true;
              this.mVerticalDimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
              setHeight(i3);
              i7 = 1;
              i5 = 1;
              break label1092;
            }
          }
        }
      }
      i7 = i11;
      i5 = i9;
      label1092:
      i = m;
    }
    if (this.mParent != null)
    {
      i = Math.max(this.mMinWidth, getWidth());
      j = Math.max(this.mMinHeight, getHeight());
      this.mSnapshot.applyTo(this);
      setWidth(i + this.mPaddingLeft + this.mPaddingRight);
      setHeight(j + this.mPaddingTop + this.mPaddingBottom);
    }
    else
    {
      this.mX = n;
      this.mY = i1;
    }
    if (i5 != 0)
    {
      this.mHorizontalDimensionBehaviour = localDimensionBehaviour2;
      this.mVerticalDimensionBehaviour = localDimensionBehaviour1;
    }
    resetSolverVariables(this.mSystem.getCache());
    if (this == getRootConstraintContainer()) {
      updateDrawPosition();
    }
  }
  
  public int layoutFindGroups()
  {
    int m = 5;
    Object localObject2 = new ConstraintAnchor.Type[5];
    localObject2[0] = ConstraintAnchor.Type.LEFT;
    localObject2[1] = ConstraintAnchor.Type.RIGHT;
    localObject2[2] = ConstraintAnchor.Type.TOP;
    localObject2[3] = ConstraintAnchor.Type.BASELINE;
    localObject2[4] = ConstraintAnchor.Type.BOTTOM;
    int n = this.mChildren.size();
    int k = 0;
    Object localObject3;
    for (int i = 1; k < n; i = j)
    {
      localObject1 = (ConstraintWidget)this.mChildren.get(k);
      localObject3 = ((ConstraintWidget)localObject1).mLeft;
      if (((ConstraintAnchor)localObject3).mTarget != null)
      {
        j = i;
        if (setGroup((ConstraintAnchor)localObject3, i) == i) {
          j = i + 1;
        }
      }
      else
      {
        ((ConstraintAnchor)localObject3).mGroup = 2147483647;
        j = i;
      }
      localObject3 = ((ConstraintWidget)localObject1).mTop;
      if (((ConstraintAnchor)localObject3).mTarget != null)
      {
        i = j;
        if (setGroup((ConstraintAnchor)localObject3, j) == j) {
          i = j + 1;
        }
      }
      else
      {
        ((ConstraintAnchor)localObject3).mGroup = 2147483647;
        i = j;
      }
      localObject3 = ((ConstraintWidget)localObject1).mRight;
      if (((ConstraintAnchor)localObject3).mTarget != null)
      {
        j = i;
        if (setGroup((ConstraintAnchor)localObject3, i) == i) {
          j = i + 1;
        }
      }
      else
      {
        ((ConstraintAnchor)localObject3).mGroup = 2147483647;
        j = i;
      }
      localObject3 = ((ConstraintWidget)localObject1).mBottom;
      if (((ConstraintAnchor)localObject3).mTarget != null)
      {
        i = j;
        if (setGroup((ConstraintAnchor)localObject3, j) == j) {
          i = j + 1;
        }
      }
      else
      {
        ((ConstraintAnchor)localObject3).mGroup = 2147483647;
        i = j;
      }
      localObject1 = ((ConstraintWidget)localObject1).mBaseline;
      if (((ConstraintAnchor)localObject1).mTarget != null)
      {
        j = i;
        if (setGroup((ConstraintAnchor)localObject1, i) == i) {
          j = i + 1;
        }
      }
      else
      {
        ((ConstraintAnchor)localObject1).mGroup = 2147483647;
        j = i;
      }
      k += 1;
    }
    i = 1;
    int j = m;
    while (i != 0)
    {
      k = 0;
      i = 0;
      while (k < n)
      {
        localObject3 = (ConstraintWidget)this.mChildren.get(k);
        m = 0;
        while (m < localObject2.length)
        {
          ConstraintAnchor localConstraintAnchor = localObject2[m];
          localObject1 = null;
          int i1 = ConstraintWidgetContainer.2.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[localConstraintAnchor.ordinal()];
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3)
              {
                if (i1 != 4)
                {
                  if (i1 == j) {
                    localObject1 = ((ConstraintWidget)localObject3).mBaseline;
                  }
                }
                else {
                  localObject1 = ((ConstraintWidget)localObject3).mBottom;
                }
              }
              else {
                localObject1 = ((ConstraintWidget)localObject3).mRight;
              }
            }
            else {
              localObject1 = ((ConstraintWidget)localObject3).mTop;
            }
          }
          else {
            localObject1 = ((ConstraintWidget)localObject3).mLeft;
          }
          localConstraintAnchor = ((ConstraintAnchor)localObject1).mTarget;
          if (localConstraintAnchor != null)
          {
            j = i;
            if (localConstraintAnchor.mOwner.getParent() != null)
            {
              j = i;
              if (localConstraintAnchor.mGroup != ((ConstraintAnchor)localObject1).mGroup)
              {
                if (((ConstraintAnchor)localObject1).mGroup > localConstraintAnchor.mGroup) {
                  i = localConstraintAnchor.mGroup;
                } else {
                  i = ((ConstraintAnchor)localObject1).mGroup;
                }
                ((ConstraintAnchor)localObject1).mGroup = i;
                localConstraintAnchor.mGroup = i;
                j = 1;
              }
            }
            localConstraintAnchor = localConstraintAnchor.getOpposite();
            i = j;
            if (localConstraintAnchor != null)
            {
              i = j;
              if (localConstraintAnchor.mGroup != ((ConstraintAnchor)localObject1).mGroup)
              {
                if (((ConstraintAnchor)localObject1).mGroup > localConstraintAnchor.mGroup) {
                  i = localConstraintAnchor.mGroup;
                } else {
                  i = ((ConstraintAnchor)localObject1).mGroup;
                }
                ((ConstraintAnchor)localObject1).mGroup = i;
                localConstraintAnchor.mGroup = i;
                i = 1;
              }
            }
          }
          m += 1;
          j = 5;
        }
        k += 1;
        j = 5;
      }
    }
    Object localObject1 = new int[this.mChildren.size() * localObject2.length + 1];
    Arrays.fill((int[])localObject1, -1);
    k = 0;
    for (i = 0; k < n; i = j)
    {
      localObject2 = (ConstraintWidget)this.mChildren.get(k);
      localObject3 = ((ConstraintWidget)localObject2).mLeft;
      j = i;
      if (((ConstraintAnchor)localObject3).mGroup != 2147483647)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject3 = ((ConstraintWidget)localObject2).mTop;
      i = j;
      if (((ConstraintAnchor)localObject3).mGroup != 2147483647)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject3 = ((ConstraintWidget)localObject2).mRight;
      j = i;
      if (((ConstraintAnchor)localObject3).mGroup != 2147483647)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject3 = ((ConstraintWidget)localObject2).mBottom;
      i = j;
      if (((ConstraintAnchor)localObject3).mGroup != 2147483647)
      {
        m = ((ConstraintAnchor)localObject3).mGroup;
        i = j;
        if (localObject1[m] == -1)
        {
          localObject1[m] = j;
          i = j + 1;
        }
        ((ConstraintAnchor)localObject3).mGroup = localObject1[m];
      }
      localObject2 = ((ConstraintWidget)localObject2).mBaseline;
      j = i;
      if (((ConstraintAnchor)localObject2).mGroup != 2147483647)
      {
        m = ((ConstraintAnchor)localObject2).mGroup;
        j = i;
        if (localObject1[m] == -1)
        {
          localObject1[m] = i;
          j = i + 1;
        }
        ((ConstraintAnchor)localObject2).mGroup = localObject1[m];
      }
      k += 1;
    }
    return i;
  }
  
  public int layoutFindGroupsSimple()
  {
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.mLeft.mGroup = 0;
      localConstraintWidget.mRight.mGroup = 0;
      localConstraintWidget.mTop.mGroup = 1;
      localConstraintWidget.mBottom.mGroup = 1;
      localConstraintWidget.mBaseline.mGroup = 1;
      i += 1;
    }
    return 2;
  }
  
  public void layoutWithGroup(int paramInt)
  {
    int k = this.mX;
    int m = this.mY;
    ConstraintWidget localConstraintWidget = this.mParent;
    int j = 0;
    if (localConstraintWidget != null)
    {
      if (this.mSnapshot == null) {
        this.mSnapshot = new Snapshot(this);
      }
      this.mSnapshot.updateFrom(this);
      this.mX = 0;
      this.mY = 0;
      resetAnchors();
      resetSolverVariables(this.mSystem.getCache());
    }
    else
    {
      this.mX = 0;
      this.mY = 0;
    }
    int n = this.mChildren.size();
    int i = 0;
    while (i < n)
    {
      localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer)) {
        ((WidgetContainer)localConstraintWidget).layout();
      }
      i += 1;
    }
    this.mLeft.mGroup = 0;
    this.mRight.mGroup = 0;
    this.mTop.mGroup = 1;
    this.mBottom.mGroup = 1;
    this.mSystem.reset();
    i = j;
    while (i < paramInt)
    {
      try
      {
        addToSolver(this.mSystem, i);
        this.mSystem.minimize();
        updateFromSolver(this.mSystem, i);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      updateFromSolver(this.mSystem, -2);
      i += 1;
    }
    if (this.mParent != null)
    {
      paramInt = getWidth();
      i = getHeight();
      this.mSnapshot.applyTo(this);
      setWidth(paramInt);
      setHeight(i);
    }
    else
    {
      this.mX = k;
      this.mY = m;
    }
    if (this == getRootConstraintContainer()) {
      updateDrawPosition();
    }
  }
  
  public void reset()
  {
    this.mSystem.reset();
    this.mPaddingLeft = 0;
    this.mPaddingRight = 0;
    this.mPaddingTop = 0;
    this.mPaddingBottom = 0;
    super.reset();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mOptimizationLevel = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, int paramInt, boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    paramArrayOfBoolean[2] = false;
    updateFromSolver(paramLinearSystem, paramInt);
    int j = this.mChildren.size();
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.updateFromSolver(paramLinearSystem, paramInt);
      if ((localConstraintWidget.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getWidth() < localConstraintWidget.getWrapWidth())) {
        paramArrayOfBoolean[2] = true;
      }
      if ((localConstraintWidget.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget.getHeight() < localConstraintWidget.getWrapHeight())) {
        paramArrayOfBoolean[2] = true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.constraint.solver.widgets.ConstraintWidgetContainer
 * JD-Core Version:    0.7.0.1
 */