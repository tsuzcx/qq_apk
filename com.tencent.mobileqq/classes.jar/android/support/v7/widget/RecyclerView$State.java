package android.support.v7.widget;

import android.util.SparseArray;

public class RecyclerView$State
{
  static final int STEP_ANIMATIONS = 4;
  static final int STEP_LAYOUT = 2;
  static final int STEP_START = 1;
  private SparseArray<Object> mData;
  private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  private boolean mInPreLayout = false;
  private boolean mIsMeasuring = false;
  int mItemCount = 0;
  private int mLayoutStep = 1;
  private int mPreviousLayoutItemCount = 0;
  private boolean mRunPredictiveAnimations = false;
  private boolean mRunSimpleAnimations = false;
  private boolean mStructureChanged = false;
  private int mTargetPosition = -1;
  private boolean mTrackOldChangeHolders = false;
  
  void assertLayoutStep(int paramInt)
  {
    if ((this.mLayoutStep & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
    }
  }
  
  public boolean didStructureChange()
  {
    return this.mStructureChanged;
  }
  
  public <T> T get(int paramInt)
  {
    if (this.mData == null) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public int getItemCount()
  {
    if (this.mInPreLayout) {
      return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
    }
    return this.mItemCount;
  }
  
  public int getTargetScrollPosition()
  {
    return this.mTargetPosition;
  }
  
  public boolean hasTargetScrollPosition()
  {
    return this.mTargetPosition != -1;
  }
  
  public boolean isMeasuring()
  {
    return this.mIsMeasuring;
  }
  
  public boolean isPreLayout()
  {
    return this.mInPreLayout;
  }
  
  public void put(int paramInt, Object paramObject)
  {
    if (this.mData == null) {
      this.mData = new SparseArray();
    }
    this.mData.put(paramInt, paramObject);
  }
  
  public void remove(int paramInt)
  {
    if (this.mData == null) {
      return;
    }
    this.mData.remove(paramInt);
  }
  
  State reset()
  {
    this.mTargetPosition = -1;
    if (this.mData != null) {
      this.mData.clear();
    }
    this.mItemCount = 0;
    this.mStructureChanged = false;
    this.mIsMeasuring = false;
    return this;
  }
  
  public String toString()
  {
    return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
  }
  
  public boolean willRunPredictiveAnimations()
  {
    return this.mRunPredictiveAnimations;
  }
  
  public boolean willRunSimpleAnimations()
  {
    return this.mRunSimpleAnimations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.State
 * JD-Core Version:    0.7.0.1
 */