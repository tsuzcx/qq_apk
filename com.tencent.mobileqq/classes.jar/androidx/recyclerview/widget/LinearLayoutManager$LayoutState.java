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
    if (i < j)
    {
      View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(i)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isItemRemoved()) {}
      while (this.mCurrentPosition != localLayoutParams.getViewLayoutPosition())
      {
        i += 1;
        break;
      }
      assignPositionFromScrapList(localView);
      return localView;
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
    return (this.mCurrentPosition >= 0) && (this.mCurrentPosition < paramState.getItemCount());
  }
  
  void log()
  {
    Log.d("LLM#LayoutState", "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
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
    int m = this.mScrapList.size();
    Object localObject = null;
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(j)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if (localView != paramView) {
        if (!localLayoutParams.isItemRemoved()) {}
      }
      for (;;)
      {
        j += 1;
        break;
        int k = (localLayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
        if (k >= 0) {
          if (k < i)
          {
            if (k == 0) {
              return localView;
            }
            localObject = localView;
            i = k;
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.LayoutState
 * JD-Core Version:    0.7.0.1
 */