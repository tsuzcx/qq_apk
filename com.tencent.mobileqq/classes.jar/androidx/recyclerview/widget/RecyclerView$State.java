package androidx.recyclerview.widget;

import android.util.SparseArray;

public class RecyclerView$State
{
  static final int STEP_ANIMATIONS = 4;
  static final int STEP_LAYOUT = 2;
  static final int STEP_START = 1;
  private SparseArray<Object> mData;
  int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  long mFocusedItemId;
  int mFocusedItemPosition;
  int mFocusedSubChildId;
  boolean mInPreLayout = false;
  boolean mIsMeasuring = false;
  int mItemCount = 0;
  int mLayoutStep = 1;
  int mPreviousLayoutItemCount = 0;
  int mRemainingScrollHorizontal;
  int mRemainingScrollVertical;
  boolean mRunPredictiveAnimations = false;
  boolean mRunSimpleAnimations = false;
  boolean mStructureChanged = false;
  int mTargetPosition = -1;
  boolean mTrackOldChangeHolders = false;
  
  void assertLayoutStep(int paramInt)
  {
    if ((this.mLayoutStep & paramInt) != 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Layout state should be one of ");
    localStringBuilder.append(Integer.toBinaryString(paramInt));
    localStringBuilder.append(" but it is ");
    localStringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean didStructureChange()
  {
    return this.mStructureChanged;
  }
  
  public <T> T get(int paramInt)
  {
    SparseArray localSparseArray = this.mData;
    if (localSparseArray == null) {
      return null;
    }
    return localSparseArray.get(paramInt);
  }
  
  public int getItemCount()
  {
    if (this.mInPreLayout) {
      return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
    }
    return this.mItemCount;
  }
  
  public int getRemainingScrollHorizontal()
  {
    return this.mRemainingScrollHorizontal;
  }
  
  public int getRemainingScrollVertical()
  {
    return this.mRemainingScrollVertical;
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
  
  void prepareForNestedPrefetch(RecyclerView.Adapter paramAdapter)
  {
    this.mLayoutStep = 1;
    this.mItemCount = paramAdapter.getItemCount();
    this.mInPreLayout = false;
    this.mTrackOldChangeHolders = false;
    this.mIsMeasuring = false;
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
    SparseArray localSparseArray = this.mData;
    if (localSparseArray == null) {
      return;
    }
    localSparseArray.remove(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("State{mTargetPosition=");
    localStringBuilder.append(this.mTargetPosition);
    localStringBuilder.append(", mData=");
    localStringBuilder.append(this.mData);
    localStringBuilder.append(", mItemCount=");
    localStringBuilder.append(this.mItemCount);
    localStringBuilder.append(", mIsMeasuring=");
    localStringBuilder.append(this.mIsMeasuring);
    localStringBuilder.append(", mPreviousLayoutItemCount=");
    localStringBuilder.append(this.mPreviousLayoutItemCount);
    localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
    localStringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
    localStringBuilder.append(", mStructureChanged=");
    localStringBuilder.append(this.mStructureChanged);
    localStringBuilder.append(", mInPreLayout=");
    localStringBuilder.append(this.mInPreLayout);
    localStringBuilder.append(", mRunSimpleAnimations=");
    localStringBuilder.append(this.mRunSimpleAnimations);
    localStringBuilder.append(", mRunPredictiveAnimations=");
    localStringBuilder.append(this.mRunPredictiveAnimations);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.State
 * JD-Core Version:    0.7.0.1
 */