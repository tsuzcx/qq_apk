package android.support.v7.widget;

import android.view.View;

class LayoutState
{
  static final int INVALID_LAYOUT = -2147483648;
  static final int ITEM_DIRECTION_HEAD = -1;
  static final int ITEM_DIRECTION_TAIL = 1;
  static final int LAYOUT_END = 1;
  static final int LAYOUT_START = -1;
  static final String TAG = "LayoutState";
  int mAvailable;
  int mCurrentPosition;
  int mEndLine = 0;
  boolean mInfinite;
  int mItemDirection;
  int mLayoutDirection;
  boolean mRecycle = true;
  int mStartLine = 0;
  boolean mStopInFocusable;
  
  boolean hasMore(RecyclerView.State paramState)
  {
    int i = this.mCurrentPosition;
    return (i >= 0) && (i < paramState.getItemCount());
  }
  
  View next(RecyclerView.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getViewForPosition(this.mCurrentPosition);
    this.mCurrentPosition += this.mItemDirection;
    return paramRecycler;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LayoutState{mAvailable=");
    localStringBuilder.append(this.mAvailable);
    localStringBuilder.append(", mCurrentPosition=");
    localStringBuilder.append(this.mCurrentPosition);
    localStringBuilder.append(", mItemDirection=");
    localStringBuilder.append(this.mItemDirection);
    localStringBuilder.append(", mLayoutDirection=");
    localStringBuilder.append(this.mLayoutDirection);
    localStringBuilder.append(", mStartLine=");
    localStringBuilder.append(this.mStartLine);
    localStringBuilder.append(", mEndLine=");
    localStringBuilder.append(this.mEndLine);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.LayoutState
 * JD-Core Version:    0.7.0.1
 */