package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;

class AsyncListUtil$1
  implements ThreadUtil.MainThreadCallback<T>
{
  AsyncListUtil$1(AsyncListUtil paramAsyncListUtil) {}
  
  private boolean isRequestedGeneration(int paramInt)
  {
    return paramInt == this.this$0.mRequestedGeneration;
  }
  
  private void recycleAllTiles()
  {
    int i = 0;
    while (i < this.this$0.mTileList.size())
    {
      this.this$0.mBackgroundProxy.recycleTile(this.this$0.mTileList.getAtIndex(i));
      i += 1;
    }
    this.this$0.mTileList.clear();
  }
  
  public void addTile(int paramInt, TileList.Tile<T> paramTile)
  {
    if (!isRequestedGeneration(paramInt))
    {
      this.this$0.mBackgroundProxy.recycleTile(paramTile);
      return;
    }
    TileList.Tile localTile = this.this$0.mTileList.addOrReplace(paramTile);
    if (localTile != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("duplicate tile @");
      localStringBuilder.append(localTile.mStartPosition);
      Log.e("AsyncListUtil", localStringBuilder.toString());
      this.this$0.mBackgroundProxy.recycleTile(localTile);
    }
    int i = paramTile.mStartPosition;
    int j = paramTile.mItemCount;
    paramInt = 0;
    while (paramInt < this.this$0.mMissingPositions.size())
    {
      int k = this.this$0.mMissingPositions.keyAt(paramInt);
      if ((paramTile.mStartPosition <= k) && (k < i + j))
      {
        this.this$0.mMissingPositions.removeAt(paramInt);
        this.this$0.mViewCallback.onItemLoaded(k);
      }
      else
      {
        paramInt += 1;
      }
    }
  }
  
  public void removeTile(int paramInt1, int paramInt2)
  {
    if (!isRequestedGeneration(paramInt1)) {
      return;
    }
    Object localObject = this.this$0.mTileList.removeAtPos(paramInt2);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tile not found @");
      ((StringBuilder)localObject).append(paramInt2);
      Log.e("AsyncListUtil", ((StringBuilder)localObject).toString());
      return;
    }
    this.this$0.mBackgroundProxy.recycleTile((TileList.Tile)localObject);
  }
  
  public void updateItemCount(int paramInt1, int paramInt2)
  {
    if (!isRequestedGeneration(paramInt1)) {
      return;
    }
    AsyncListUtil localAsyncListUtil = this.this$0;
    localAsyncListUtil.mItemCount = paramInt2;
    localAsyncListUtil.mViewCallback.onDataRefresh();
    localAsyncListUtil = this.this$0;
    localAsyncListUtil.mDisplayedGeneration = localAsyncListUtil.mRequestedGeneration;
    recycleAllTiles();
    localAsyncListUtil = this.this$0;
    localAsyncListUtil.mAllowScrollHints = false;
    localAsyncListUtil.updateRange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListUtil.1
 * JD-Core Version:    0.7.0.1
 */