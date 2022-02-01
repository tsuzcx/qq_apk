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
    if (!isRequestedGeneration(paramInt)) {
      this.this$0.mBackgroundProxy.recycleTile(paramTile);
    }
    for (;;)
    {
      return;
      TileList.Tile localTile = this.this$0.mTileList.addOrReplace(paramTile);
      if (localTile != null)
      {
        Log.e("AsyncListUtil", "duplicate tile @" + localTile.mStartPosition);
        this.this$0.mBackgroundProxy.recycleTile(localTile);
      }
      int i = paramTile.mStartPosition;
      int j = paramTile.mItemCount;
      paramInt = 0;
      while (paramInt < this.this$0.mMissingPositions.size())
      {
        int k = this.this$0.mMissingPositions.keyAt(paramInt);
        if ((paramTile.mStartPosition <= k) && (k < j + i))
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
  }
  
  public void removeTile(int paramInt1, int paramInt2)
  {
    if (!isRequestedGeneration(paramInt1)) {
      return;
    }
    TileList.Tile localTile = this.this$0.mTileList.removeAtPos(paramInt2);
    if (localTile == null)
    {
      Log.e("AsyncListUtil", "tile not found @" + paramInt2);
      return;
    }
    this.this$0.mBackgroundProxy.recycleTile(localTile);
  }
  
  public void updateItemCount(int paramInt1, int paramInt2)
  {
    if (!isRequestedGeneration(paramInt1)) {
      return;
    }
    this.this$0.mItemCount = paramInt2;
    this.this$0.mViewCallback.onDataRefresh();
    this.this$0.mDisplayedGeneration = this.this$0.mRequestedGeneration;
    recycleAllTiles();
    this.this$0.mAllowScrollHints = false;
    this.this$0.updateRange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListUtil.1
 * JD-Core Version:    0.7.0.1
 */