package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import java.util.List;

class LinearLayoutManager$LayoutState
{
  static final int INVALID_LAYOUT = -2147483648;
  static final int ITEM_DIRECTION_HEAD = -1;
  static final int ITEM_DIRECTION_TAIL = 1;
  static final int LAYOUT_END = 1;
  static final int LAYOUT_START = -1;
  static final int SCROLLING_OFFSET_NaN = -2147483648;
  static final String TAG = "LLM#LayoutState";
  int mAvailable;
  int mCurrentPosition;
  int mExtraFillSpace = 0;
  boolean mInfinite;
  boolean mIsPreLayout = false;
  int mItemDirection;
  int mLastScrollDelta;
  int mLayoutDirection;
  int mNoRecycleSpace = 0;
  int mOffset;
  boolean mRecycle = true;
  List<RecyclerView.ViewHolder> mScrapList = null;
  int mScrollingOffset;
  
  private View nextViewFromScrapList()
  {
    int j = this.mScrapList.size();
    int i = 0;
    while (i < j)
    {
      View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(i)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((!localLayoutParams.isItemRemoved()) && (this.mCurrentPosition == localLayoutParams.getViewLayoutPosition()))
      {
        assignPositionFromScrapList(localView);
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void assignPositionFromScrapList()
  {
    assignPositionFromScrapList(null);
  }
  
  public void assignPositionFromScrapList(View paramView)
  {
    paramView = nextViewInLimitedList(paramView);
    if (paramView == null)
    {
      this.mCurrentPosition = -1;
      return;
    }
    this.mCurrentPosition = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
  }
  
  boolean hasMore(RecyclerView.State paramState)
  {
    int i = this.mCurrentPosition;
    return (i >= 0) && (i < paramState.getItemCount());
  }
  
  void log()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avail:");
    localStringBuilder.append(this.mAvailable);
    localStringBuilder.append(", ind:");
    localStringBuilder.append(this.mCurrentPosition);
    localStringBuilder.append(", dir:");
    localStringBuilder.append(this.mItemDirection);
    localStringBuilder.append(", offset:");
    localStringBuilder.append(this.mOffset);
    localStringBuilder.append(", layoutDir:");
    localStringBuilder.append(this.mLayoutDirection);
    Log.d("LLM#LayoutState", localStringBuilder.toString());
  }
  
  View next(RecyclerView.Recycler paramRecycler)
  {
    if (this.mScrapList != null) {
      return nextViewFromScrapList();
    }
    paramRecycler = paramRecycler.getViewForPosition(this.mCurrentPosition);
    this.mCurrentPosition += this.mItemDirection;
    return paramRecycler;
  }
  
  public View nextViewInLimitedList(View paramView)
  {
    int n = this.mScrapList.size();
    Object localObject1 = null;
    int j = 2147483647;
    int i = 0;
    while (i < n)
    {
      View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(i)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      Object localObject2 = localObject1;
      int k = j;
      if (localView != paramView) {
        if (localLayoutParams.isItemRemoved())
        {
          localObject2 = localObject1;
          k = j;
        }
        else
        {
          int m = (localLayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
          if (m < 0)
          {
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            localObject2 = localObject1;
            k = j;
            if (m < j)
            {
              if (m == 0) {
                return localView;
              }
              localObject2 = localView;
              k = m;
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
      j = k;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.LayoutState
 * JD-Core Version:    0.7.0.1
 */