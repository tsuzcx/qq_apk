package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class Chain
{
  private static final boolean DEBUG = false;
  public static final boolean USE_CHAIN_OPTIMIZATION = false;
  
  static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead)
  {
    ConstraintWidget localConstraintWidget4 = paramChainHead.mFirst;
    ConstraintWidget localConstraintWidget2 = paramChainHead.mLast;
    ConstraintWidget localConstraintWidget1 = paramChainHead.mFirstVisibleWidget;
    ConstraintWidget localConstraintWidget3 = paramChainHead.mLastVisibleWidget;
    Object localObject2 = paramChainHead.mHead;
    float f1 = paramChainHead.mTotalWeight;
    Object localObject1 = paramChainHead.mFirstMatchConstraintWidget;
    localObject1 = paramChainHead.mLastMatchConstraintWidget;
    int n;
    if (paramConstraintWidgetContainer.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      n = 1;
    } else {
      n = 0;
    }
    if (paramInt1 == 0)
    {
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (((ConstraintWidget)localObject2).mHorizontalChainStyle != 2) {
        break label198;
      }
    }
    else
    {
      if (((ConstraintWidget)localObject2).mVerticalChainStyle == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((ConstraintWidget)localObject2).mVerticalChainStyle == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (((ConstraintWidget)localObject2).mVerticalChainStyle != 2) {
        break label198;
      }
    }
    int i1 = 1;
    int m = j;
    break label205;
    label198:
    i1 = 0;
    int i = k;
    label205:
    Object localObject3 = localConstraintWidget4;
    int j = 0;
    int k = i;
    i = j;
    Object localObject4;
    int i2;
    Object localObject5;
    for (;;)
    {
      localObject4 = null;
      if (i != 0) {
        break;
      }
      localObject1 = localObject3.mListAnchors[paramInt2];
      if (i1 != 0) {
        j = 1;
      } else {
        j = 4;
      }
      int i4 = ((ConstraintAnchor)localObject1).getMargin();
      int i3;
      if ((localObject3.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localObject3.mResolvedMatchConstraintDefault[paramInt1] == 0)) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      i2 = i4;
      if (((ConstraintAnchor)localObject1).mTarget != null)
      {
        i2 = i4;
        if (localObject3 != localConstraintWidget4) {
          i2 = i4 + ((ConstraintAnchor)localObject1).mTarget.getMargin();
        }
      }
      if ((i1 != 0) && (localObject3 != localConstraintWidget4) && (localObject3 != localConstraintWidget1)) {
        j = 8;
      }
      if (((ConstraintAnchor)localObject1).mTarget != null)
      {
        if (localObject3 == localConstraintWidget1) {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, 6);
        } else {
          paramLinearSystem.addGreaterThan(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, 8);
        }
        if ((i3 != 0) && (i1 == 0)) {
          j = 5;
        }
        paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, i2, j);
      }
      if (n != 0)
      {
        if ((((ConstraintWidget)localObject3).getVisibility() != 8) && (localObject3.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) {
          paramLinearSystem.addGreaterThan(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 5);
        }
        paramLinearSystem.addGreaterThan(localObject3.mListAnchors[paramInt2].mSolverVariable, paramConstraintWidgetContainer.mListAnchors[paramInt2].mSolverVariable, 0, 8);
      }
      localObject5 = localObject3.mListAnchors[(paramInt2 + 1)].mTarget;
      localObject1 = localObject4;
      if (localObject5 != null)
      {
        localObject5 = ((ConstraintAnchor)localObject5).mOwner;
        localObject1 = localObject4;
        if (localObject5.mListAnchors[paramInt2].mTarget != null) {
          if (localObject5.mListAnchors[paramInt2].mTarget.mOwner != localObject3) {
            localObject1 = localObject4;
          } else {
            localObject1 = localObject5;
          }
        }
      }
      if (localObject1 != null) {
        localObject3 = localObject1;
      } else {
        i = 1;
      }
    }
    if (localConstraintWidget3 != null)
    {
      localObject1 = localConstraintWidget2.mListAnchors;
      j = paramInt2 + 1;
      if (localObject1[j].mTarget != null)
      {
        localObject1 = localConstraintWidget3.mListAnchors[j];
        if ((localConstraintWidget3.mListDimensionBehaviors[paramInt1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (localConstraintWidget3.mResolvedMatchConstraintDefault[paramInt1] == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (i1 == 0) && (((ConstraintAnchor)localObject1).mTarget.mOwner == paramConstraintWidgetContainer)) {
          paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, -((ConstraintAnchor)localObject1).getMargin(), 5);
        } else if ((i1 != 0) && (((ConstraintAnchor)localObject1).mTarget.mOwner == paramConstraintWidgetContainer)) {
          paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject1).mTarget.mSolverVariable, -((ConstraintAnchor)localObject1).getMargin(), 4);
        }
        paramLinearSystem.addLowerThan(((ConstraintAnchor)localObject1).mSolverVariable, localConstraintWidget2.mListAnchors[j].mTarget.mSolverVariable, -((ConstraintAnchor)localObject1).getMargin(), 6);
      }
    }
    if (n != 0)
    {
      paramConstraintWidgetContainer = paramConstraintWidgetContainer.mListAnchors;
      i = paramInt2 + 1;
      paramLinearSystem.addGreaterThan(paramConstraintWidgetContainer[i].mSolverVariable, localConstraintWidget2.mListAnchors[i].mSolverVariable, localConstraintWidget2.mListAnchors[i].getMargin(), 8);
    }
    paramConstraintWidgetContainer = paramChainHead.mWeightedMatchConstraintsWidgets;
    label1057:
    Object localObject6;
    Object localObject7;
    if (paramConstraintWidgetContainer != null)
    {
      i = paramConstraintWidgetContainer.size();
      if (i > 1)
      {
        float f2;
        if ((paramChainHead.mHasUndefinedWeights) && (!paramChainHead.mHasComplexMatchWeights)) {
          f2 = paramChainHead.mWidgetsMatchCount;
        } else {
          f2 = f1;
        }
        localObject1 = null;
        j = 0;
        for (float f3 = 0.0F; j < i; f3 = f1)
        {
          localObject3 = (ConstraintWidget)paramConstraintWidgetContainer.get(j);
          f1 = localObject3.mWeight[paramInt1];
          if (f1 < 0.0F)
          {
            if (paramChainHead.mHasComplexMatchWeights)
            {
              paramLinearSystem.addEquality(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 4);
              break label1057;
            }
            f1 = 1.0F;
          }
          if (f1 == 0.0F)
          {
            paramLinearSystem.addEquality(localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable, localObject3.mListAnchors[paramInt2].mSolverVariable, 0, 8);
            f1 = f3;
          }
          else
          {
            if (localObject1 != null)
            {
              localObject4 = localObject1.mListAnchors[paramInt2].mSolverVariable;
              localObject1 = ((ConstraintWidget)localObject1).mListAnchors;
              n = paramInt2 + 1;
              localObject1 = localObject1[n].mSolverVariable;
              localObject5 = localObject3.mListAnchors[paramInt2].mSolverVariable;
              localObject6 = localObject3.mListAnchors[n].mSolverVariable;
              localObject7 = paramLinearSystem.createRow();
              ((ArrayRow)localObject7).createRowEqualMatchDimensions(f3, f2, f1, (SolverVariable)localObject4, (SolverVariable)localObject1, (SolverVariable)localObject5, (SolverVariable)localObject6);
              paramLinearSystem.addConstraint((ArrayRow)localObject7);
            }
            localObject1 = localObject3;
          }
          j += 1;
        }
      }
    }
    if ((localConstraintWidget1 != null) && ((localConstraintWidget1 == localConstraintWidget3) || (i1 != 0)))
    {
      paramConstraintWidgetContainer = localConstraintWidget4.mListAnchors[paramInt2];
      paramChainHead = localConstraintWidget2.mListAnchors;
      i = paramInt2 + 1;
      paramChainHead = paramChainHead[i];
      if (paramConstraintWidgetContainer.mTarget != null) {
        paramConstraintWidgetContainer = paramConstraintWidgetContainer.mTarget.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (paramChainHead.mTarget != null) {
        paramChainHead = paramChainHead.mTarget.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
      localObject3 = localConstraintWidget3.mListAnchors[i];
      if ((paramConstraintWidgetContainer != null) && (paramChainHead != null))
      {
        if (paramInt1 == 0) {
          f1 = ((ConstraintWidget)localObject2).mHorizontalBiasPercent;
        } else {
          f1 = ((ConstraintWidget)localObject2).mVerticalBiasPercent;
        }
        paramInt1 = ((ConstraintAnchor)localObject1).getMargin();
        i = ((ConstraintAnchor)localObject3).getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramConstraintWidgetContainer, paramInt1, f1, paramChainHead, ((ConstraintAnchor)localObject3).mSolverVariable, i, 7);
      }
    }
    else
    {
      if ((k != 0) && (localConstraintWidget1 != null))
      {
        if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {
          n = 1;
        } else {
          n = 0;
        }
        paramChainHead = localConstraintWidget1;
        localObject3 = paramChainHead;
      }
      while (paramChainHead != null)
      {
        for (localObject1 = paramChainHead.mNextChainWidget[paramInt1]; (localObject1 != null) && (((ConstraintWidget)localObject1).getVisibility() == 8); localObject1 = localObject1.mNextChainWidget[paramInt1]) {}
        if ((localObject1 == null) && (paramChainHead != localConstraintWidget3)) {}
        for (;;)
        {
          break;
          localObject4 = paramChainHead.mListAnchors[paramInt2];
          localObject7 = ((ConstraintAnchor)localObject4).mSolverVariable;
          if (((ConstraintAnchor)localObject4).mTarget != null) {
            localObject2 = ((ConstraintAnchor)localObject4).mTarget.mSolverVariable;
          } else {
            localObject2 = null;
          }
          if (localObject3 != paramChainHead)
          {
            paramConstraintWidgetContainer = localObject3.mListAnchors[(paramInt2 + 1)].mSolverVariable;
          }
          else
          {
            paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject2;
            if (paramChainHead == localConstraintWidget1)
            {
              paramConstraintWidgetContainer = (ConstraintWidgetContainer)localObject2;
              if (localObject3 == paramChainHead) {
                if (localConstraintWidget4.mListAnchors[paramInt2].mTarget != null) {
                  paramConstraintWidgetContainer = localConstraintWidget4.mListAnchors[paramInt2].mTarget.mSolverVariable;
                } else {
                  paramConstraintWidgetContainer = null;
                }
              }
            }
          }
          i1 = ((ConstraintAnchor)localObject4).getMargin();
          localObject2 = paramChainHead.mListAnchors;
          i2 = paramInt2 + 1;
          j = localObject2[i2].getMargin();
          if (localObject1 != null)
          {
            localObject2 = localObject1.mListAnchors[paramInt2];
            localObject4 = ((ConstraintAnchor)localObject2).mSolverVariable;
            localObject5 = paramChainHead.mListAnchors[i2].mSolverVariable;
          }
          else
          {
            localObject6 = localConstraintWidget2.mListAnchors[i2].mTarget;
            if (localObject6 != null) {
              localObject2 = ((ConstraintAnchor)localObject6).mSolverVariable;
            } else {
              localObject2 = null;
            }
            localObject5 = paramChainHead.mListAnchors[i2].mSolverVariable;
            localObject4 = localObject2;
            localObject2 = localObject6;
          }
          i = j;
          if (localObject2 != null) {
            i = j + ((ConstraintAnchor)localObject2).getMargin();
          }
          j = i1;
          if (localObject3 != null) {
            j = i1 + localObject3.mListAnchors[i2].getMargin();
          }
          if ((localObject7 != null) && (paramConstraintWidgetContainer != null) && (localObject4 != null) && (localObject5 != null))
          {
            if (paramChainHead == localConstraintWidget1) {
              j = localConstraintWidget1.mListAnchors[paramInt2].getMargin();
            }
            if (paramChainHead == localConstraintWidget3) {
              i = localConstraintWidget3.mListAnchors[i2].getMargin();
            }
            if (n != 0) {
              i1 = 8;
            } else {
              i1 = 5;
            }
            paramLinearSystem.addCentering((SolverVariable)localObject7, paramConstraintWidgetContainer, j, 0.5F, (SolverVariable)localObject4, (SolverVariable)localObject5, i, i1);
          }
        }
        if (paramChainHead.getVisibility() != 8) {
          localObject3 = paramChainHead;
        }
        paramChainHead = (ChainHead)localObject1;
        continue;
        if ((m != 0) && (localConstraintWidget1 != null))
        {
          if ((paramChainHead.mWidgetsMatchCount > 0) && (paramChainHead.mWidgetsCount == paramChainHead.mWidgetsMatchCount)) {
            i = 1;
          } else {
            i = 0;
          }
          paramChainHead = localConstraintWidget1;
          localObject1 = paramChainHead;
          while (paramChainHead != null)
          {
            for (paramConstraintWidgetContainer = paramChainHead.mNextChainWidget[paramInt1]; (paramConstraintWidgetContainer != null) && (paramConstraintWidgetContainer.getVisibility() == 8); paramConstraintWidgetContainer = paramConstraintWidgetContainer.mNextChainWidget[paramInt1]) {}
            if ((paramChainHead != localConstraintWidget1) && (paramChainHead != localConstraintWidget3) && (paramConstraintWidgetContainer != null))
            {
              if (paramConstraintWidgetContainer == localConstraintWidget3) {
                paramConstraintWidgetContainer = null;
              }
              localObject2 = paramChainHead.mListAnchors[paramInt2];
              localObject6 = ((ConstraintAnchor)localObject2).mSolverVariable;
              if (((ConstraintAnchor)localObject2).mTarget != null) {
                localObject3 = ((ConstraintAnchor)localObject2).mTarget.mSolverVariable;
              }
              localObject3 = ((ConstraintWidget)localObject1).mListAnchors;
              i2 = paramInt2 + 1;
              localObject7 = localObject3[i2].mSolverVariable;
              i1 = ((ConstraintAnchor)localObject2).getMargin();
              n = paramChainHead.mListAnchors[i2].getMargin();
              if (paramConstraintWidgetContainer != null)
              {
                localObject3 = paramConstraintWidgetContainer.mListAnchors[paramInt2];
                localObject4 = ((ConstraintAnchor)localObject3).mSolverVariable;
                if (((ConstraintAnchor)localObject3).mTarget != null) {
                  localObject2 = ((ConstraintAnchor)localObject3).mTarget.mSolverVariable;
                } else {
                  localObject2 = null;
                }
              }
              else
              {
                localObject5 = localConstraintWidget3.mListAnchors[paramInt2];
                if (localObject5 != null) {
                  localObject3 = ((ConstraintAnchor)localObject5).mSolverVariable;
                } else {
                  localObject3 = null;
                }
                localObject2 = paramChainHead.mListAnchors[i2].mSolverVariable;
                localObject4 = localObject3;
                localObject3 = localObject5;
              }
              j = n;
              if (localObject3 != null) {
                j = n + ((ConstraintAnchor)localObject3).getMargin();
              }
              n = i1;
              if (localObject1 != null) {
                n = i1 + localObject1.mListAnchors[i2].getMargin();
              }
              if (i != 0) {
                i1 = 8;
              } else {
                i1 = 4;
              }
              if ((localObject6 != null) && (localObject7 != null) && (localObject4 != null) && (localObject2 != null)) {
                paramLinearSystem.addCentering((SolverVariable)localObject6, (SolverVariable)localObject7, n, 0.5F, (SolverVariable)localObject4, (SolverVariable)localObject2, j, i1);
              }
            }
            if (paramChainHead.getVisibility() == 8) {
              paramChainHead = (ChainHead)localObject1;
            }
            localObject1 = paramChainHead;
            paramChainHead = paramConstraintWidgetContainer;
          }
          paramConstraintWidgetContainer = localConstraintWidget1.mListAnchors[paramInt2];
          paramChainHead = localConstraintWidget4.mListAnchors[paramInt2].mTarget;
          localObject1 = localConstraintWidget3.mListAnchors;
          paramInt1 = paramInt2 + 1;
          localObject1 = localObject1[paramInt1];
          localObject2 = localConstraintWidget2.mListAnchors[paramInt1].mTarget;
          if (paramChainHead != null) {
            if (localConstraintWidget1 != localConstraintWidget3) {
              paramLinearSystem.addEquality(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 5);
            } else if (localObject2 != null) {
              paramLinearSystem.addCentering(paramConstraintWidgetContainer.mSolverVariable, paramChainHead.mSolverVariable, paramConstraintWidgetContainer.getMargin(), 0.5F, ((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject2).mSolverVariable, ((ConstraintAnchor)localObject1).getMargin(), 5);
            }
          }
          if ((localObject2 != null) && (localConstraintWidget1 != localConstraintWidget3)) {
            paramLinearSystem.addEquality(((ConstraintAnchor)localObject1).mSolverVariable, ((ConstraintAnchor)localObject2).mSolverVariable, -((ConstraintAnchor)localObject1).getMargin(), 5);
          }
        }
      }
    }
    if (((k != 0) || (m != 0)) && (localConstraintWidget1 != null) && (localConstraintWidget1 != localConstraintWidget3))
    {
      localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
      paramConstraintWidgetContainer = localConstraintWidget3.mListAnchors;
      paramInt1 = paramInt2 + 1;
      localObject2 = paramConstraintWidgetContainer[paramInt1];
      if (((ConstraintAnchor)localObject1).mTarget != null) {
        paramChainHead = ((ConstraintAnchor)localObject1).mTarget.mSolverVariable;
      } else {
        paramChainHead = null;
      }
      if (((ConstraintAnchor)localObject2).mTarget != null) {
        paramConstraintWidgetContainer = ((ConstraintAnchor)localObject2).mTarget.mSolverVariable;
      } else {
        paramConstraintWidgetContainer = null;
      }
      if (localConstraintWidget2 != localConstraintWidget3)
      {
        paramConstraintWidgetContainer = localConstraintWidget2.mListAnchors[paramInt1];
        if (paramConstraintWidgetContainer.mTarget != null) {
          paramConstraintWidgetContainer = paramConstraintWidgetContainer.mTarget.mSolverVariable;
        } else {
          paramConstraintWidgetContainer = null;
        }
      }
      if (localConstraintWidget1 == localConstraintWidget3)
      {
        localObject1 = localConstraintWidget1.mListAnchors[paramInt2];
        localObject2 = localConstraintWidget1.mListAnchors[paramInt1];
      }
      if ((paramChainHead != null) && (paramConstraintWidgetContainer != null))
      {
        paramInt2 = ((ConstraintAnchor)localObject1).getMargin();
        if (localConstraintWidget3 == null) {
          localObject3 = localConstraintWidget2;
        } else {
          localObject3 = localConstraintWidget3;
        }
        paramInt1 = localObject3.mListAnchors[paramInt1].getMargin();
        paramLinearSystem.addCentering(((ConstraintAnchor)localObject1).mSolverVariable, paramChainHead, paramInt2, 0.5F, paramConstraintWidgetContainer, ((ConstraintAnchor)localObject2).mSolverVariable, paramInt1, 5);
      }
    }
  }
  
  public static void applyChainConstraints(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ArrayList<ConstraintWidget> paramArrayList, int paramInt)
  {
    int k = 0;
    int i;
    ChainHead[] arrayOfChainHead;
    int j;
    if (paramInt == 0)
    {
      i = paramConstraintWidgetContainer.mHorizontalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mHorizontalChainsArray;
      j = 0;
    }
    else
    {
      i = paramConstraintWidgetContainer.mVerticalChainsSize;
      arrayOfChainHead = paramConstraintWidgetContainer.mVerticalChainsArray;
      j = 2;
    }
    while (k < i)
    {
      ChainHead localChainHead = arrayOfChainHead[k];
      localChainHead.define();
      if ((paramArrayList == null) || ((paramArrayList != null) && (paramArrayList.contains(localChainHead.mFirst)))) {
        applyChainConstraints(paramConstraintWidgetContainer, paramLinearSystem, paramInt, j, localChainHead);
      }
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.Chain
 * JD-Core Version:    0.7.0.1
 */