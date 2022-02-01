package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class ChainHead
{
  private boolean mDefined;
  protected ConstraintWidget mFirst;
  protected ConstraintWidget mFirstMatchConstraintWidget;
  protected ConstraintWidget mFirstVisibleWidget;
  protected boolean mHasComplexMatchWeights;
  protected boolean mHasDefinedWeights;
  protected boolean mHasRatio;
  protected boolean mHasUndefinedWeights;
  protected ConstraintWidget mHead;
  private boolean mIsRtl = false;
  protected ConstraintWidget mLast;
  protected ConstraintWidget mLastMatchConstraintWidget;
  protected ConstraintWidget mLastVisibleWidget;
  boolean mOptimizable;
  private int mOrientation;
  int mTotalMargins;
  int mTotalSize;
  protected float mTotalWeight = 0.0F;
  int mVisibleWidgets;
  protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
  protected int mWidgetsCount;
  protected int mWidgetsMatchCount;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean)
  {
    this.mFirst = paramConstraintWidget;
    this.mOrientation = paramInt;
    this.mIsRtl = paramBoolean;
  }
  
  private void defineChainProperties()
  {
    int j = this.mOrientation * 2;
    Object localObject1 = this.mFirst;
    boolean bool = true;
    this.mOptimizable = true;
    Object localObject2 = localObject1;
    int i = 0;
    while (i == 0)
    {
      this.mWidgetsCount += 1;
      Object localObject4 = ((ConstraintWidget)localObject1).mNextChainWidget;
      int k = this.mOrientation;
      Object localObject3 = null;
      localObject4[k] = null;
      ((ConstraintWidget)localObject1).mListNextMatchConstraintsWidget[this.mOrientation] = null;
      if (((ConstraintWidget)localObject1).getVisibility() != 8)
      {
        this.mVisibleWidgets += 1;
        if (((ConstraintWidget)localObject1).getDimensionBehaviour(this.mOrientation) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
          this.mTotalSize += ((ConstraintWidget)localObject1).getLength(this.mOrientation);
        }
        this.mTotalSize += localObject1.mListAnchors[j].getMargin();
        k = this.mTotalSize;
        localObject4 = ((ConstraintWidget)localObject1).mListAnchors;
        int m = j + 1;
        this.mTotalSize = (k + localObject4[m].getMargin());
        this.mTotalMargins += localObject1.mListAnchors[j].getMargin();
        this.mTotalMargins += localObject1.mListAnchors[m].getMargin();
        if (this.mFirstVisibleWidget == null) {
          this.mFirstVisibleWidget = ((ConstraintWidget)localObject1);
        }
        this.mLastVisibleWidget = ((ConstraintWidget)localObject1);
        if (localObject1.mListDimensionBehaviors[this.mOrientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if ((localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 0) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 3) || (localObject1.mResolvedMatchConstraintDefault[this.mOrientation] == 2))
          {
            this.mWidgetsMatchCount += 1;
            float f = localObject1.mWeight[this.mOrientation];
            if (f > 0.0F) {
              this.mTotalWeight += localObject1.mWeight[this.mOrientation];
            }
            if (isMatchConstraintEqualityCandidate((ConstraintWidget)localObject1, this.mOrientation))
            {
              if (f < 0.0F) {
                this.mHasUndefinedWeights = true;
              } else {
                this.mHasDefinedWeights = true;
              }
              if (this.mWeightedMatchConstraintsWidgets == null) {
                this.mWeightedMatchConstraintsWidgets = new ArrayList();
              }
              this.mWeightedMatchConstraintsWidgets.add(localObject1);
            }
            if (this.mFirstMatchConstraintWidget == null) {
              this.mFirstMatchConstraintWidget = ((ConstraintWidget)localObject1);
            }
            localObject4 = this.mLastMatchConstraintWidget;
            if (localObject4 != null) {
              ((ConstraintWidget)localObject4).mListNextMatchConstraintsWidget[this.mOrientation] = localObject1;
            }
            this.mLastMatchConstraintWidget = ((ConstraintWidget)localObject1);
          }
          if (this.mOrientation == 0)
          {
            if (((ConstraintWidget)localObject1).mMatchConstraintDefaultWidth != 0) {
              this.mOptimizable = false;
            } else if ((((ConstraintWidget)localObject1).mMatchConstraintMinWidth != 0) || (((ConstraintWidget)localObject1).mMatchConstraintMaxWidth != 0)) {
              this.mOptimizable = false;
            }
          }
          else if (((ConstraintWidget)localObject1).mMatchConstraintDefaultHeight != 0) {
            this.mOptimizable = false;
          } else if ((((ConstraintWidget)localObject1).mMatchConstraintMinHeight != 0) || (((ConstraintWidget)localObject1).mMatchConstraintMaxHeight != 0)) {
            this.mOptimizable = false;
          }
          if (((ConstraintWidget)localObject1).mDimensionRatio != 0.0F)
          {
            this.mOptimizable = false;
            this.mHasRatio = true;
          }
        }
      }
      if (localObject2 != localObject1) {
        ((ConstraintWidget)localObject2).mNextChainWidget[this.mOrientation] = localObject1;
      }
      localObject4 = localObject1.mListAnchors[(j + 1)].mTarget;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((ConstraintAnchor)localObject4).mOwner;
        localObject2 = localObject3;
        if (localObject4.mListAnchors[j].mTarget != null) {
          if (localObject4.mListAnchors[j].mTarget.mOwner != localObject1) {
            localObject2 = localObject3;
          } else {
            localObject2 = localObject4;
          }
        }
      }
      if (localObject2 == null)
      {
        localObject2 = localObject1;
        i = 1;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    localObject2 = this.mFirstVisibleWidget;
    if (localObject2 != null) {
      this.mTotalSize -= localObject2.mListAnchors[j].getMargin();
    }
    localObject2 = this.mLastVisibleWidget;
    if (localObject2 != null) {
      this.mTotalSize -= localObject2.mListAnchors[(j + 1)].getMargin();
    }
    this.mLast = ((ConstraintWidget)localObject1);
    if ((this.mOrientation == 0) && (this.mIsRtl)) {
      this.mHead = this.mLast;
    } else {
      this.mHead = this.mFirst;
    }
    if ((!this.mHasDefinedWeights) || (!this.mHasUndefinedWeights)) {
      bool = false;
    }
    this.mHasComplexMatchWeights = bool;
  }
  
  private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    return (paramConstraintWidget.getVisibility() != 8) && (paramConstraintWidget.mListDimensionBehaviors[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && ((paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 0) || (paramConstraintWidget.mResolvedMatchConstraintDefault[paramInt] == 3));
  }
  
  public void define()
  {
    if (!this.mDefined) {
      defineChainProperties();
    }
    this.mDefined = true;
  }
  
  public ConstraintWidget getFirst()
  {
    return this.mFirst;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget()
  {
    return this.mFirstMatchConstraintWidget;
  }
  
  public ConstraintWidget getFirstVisibleWidget()
  {
    return this.mFirstVisibleWidget;
  }
  
  public ConstraintWidget getHead()
  {
    return this.mHead;
  }
  
  public ConstraintWidget getLast()
  {
    return this.mLast;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget()
  {
    return this.mLastMatchConstraintWidget;
  }
  
  public ConstraintWidget getLastVisibleWidget()
  {
    return this.mLastVisibleWidget;
  }
  
  public float getTotalWeight()
  {
    return this.mTotalWeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.solver.widgets.ChainHead
 * JD-Core Version:    0.7.0.1
 */