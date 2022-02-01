package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;

class AsyncListUtil$2
  implements ThreadUtil.BackgroundCallback<T>
{
  private int mFirstRequiredTileStart;
  private int mGeneration;
  private int mItemCount;
  private int mLastRequiredTileStart;
  final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
  private TileList.Tile<T> mRecycledRoot;
  
  AsyncListUtil$2(AsyncListUtil paramAsyncListUtil) {}
  
  private TileList.Tile<T> acquireTile()
  {
    if (this.mRecycledRoot != null)
    {
      TileList.Tile localTile = this.mRecycledRoot;
      this.mRecycledRoot = this.mRecycledRoot.mNext;
      return localTile;
    }
    return new TileList.Tile(this.this$0.mTClass, this.this$0.mTileSize);
  }
  
  private void addTile(TileList.Tile<T> paramTile)
  {
    this.mLoadedTiles.put(paramTile.mStartPosition, true);
    this.this$0.mMainThreadProxy.addTile(this.mGeneration, paramTile);
  }
  
  private void flushTileCache(int paramInt)
  {
    int i = this.this$0.mDataCallback.getMaxCachedTiles();
    while (this.mLoadedTiles.size() >= i)
    {
      int j = this.mLoadedTiles.keyAt(0);
      int k = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
      int m = this.mFirstRequiredTileStart - j;
      int n = k - this.mLastRequiredTileStart;
      if ((m > 0) && ((m >= n) || (paramInt == 2)))
      {
        removeTile(j);
      }
      else
      {
        if ((n <= 0) || ((m >= n) && (paramInt != 1))) {
          break;
        }
        removeTile(k);
      }
    }
  }
  
  private int getTileStart(int paramInt)
  {
    return paramInt - paramInt % this.this$0.mTileSize;
  }
  
  private boolean isTileLoaded(int paramInt)
  {
    return this.mLoadedTiles.get(paramInt);
  }
  
  private void log(String paramString, Object... paramVarArgs)
  {
    Log.d("AsyncListUtil", "[BKGR] " + String.format(paramString, paramVarArgs));
  }
  
  private void removeTile(int paramInt)
  {
    this.mLoadedTiles.delete(paramInt);
    this.this$0.mMainThreadProxy.removeTile(this.mGeneration, paramInt);
  }
  
  private void requestTiles(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramInt1;
    if (i <= paramInt2)
    {
      if (paramBoolean) {}
      for (int j = paramInt2 + paramInt1 - i;; j = i)
      {
        this.this$0.mBackgroundProxy.loadTile(j, paramInt3);
        i += this.this$0.mTileSize;
        break;
      }
    }
  }
  
  public void loadTile(int paramInt1, int paramInt2)
  {
    if (isTileLoaded(paramInt1)) {
      return;
    }
    TileList.Tile localTile = acquireTile();
    localTile.mStartPosition = paramInt1;
    localTile.mItemCount = Math.min(this.this$0.mTileSize, this.mItemCount - localTile.mStartPosition);
    this.this$0.mDataCallback.fillData(localTile.mItems, localTile.mStartPosition, localTile.mItemCount);
    flushTileCache(paramInt2);
    addTile(localTile);
  }
  
  public void recycleTile(TileList.Tile<T> paramTile)
  {
    this.this$0.mDataCallback.recycleData(paramTile.mItems, paramTile.mItemCount);
    paramTile.mNext = this.mRecycledRoot;
    this.mRecycledRoot = paramTile;
  }
  
  public void refresh(int paramInt)
  {
    this.mGeneration = paramInt;
    this.mLoadedTiles.clear();
    this.mItemCount = this.this$0.mDataCallback.refreshData();
    this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
  }
  
  public void updateRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 > paramInt2) {
      return;
    }
    paramInt1 = getTileStart(paramInt1);
    paramInt2 = getTileStart(paramInt2);
    this.mFirstRequiredTileStart = getTileStart(paramInt3);
    this.mLastRequiredTileStart = getTileStart(paramInt4);
    if (paramInt5 == 1)
    {
      requestTiles(this.mFirstRequiredTileStart, paramInt2, paramInt5, true);
      requestTiles(this.this$0.mTileSize + paramInt2, this.mLastRequiredTileStart, paramInt5, false);
      return;
    }
    requestTiles(paramInt1, this.mLastRequiredTileStart, paramInt5, false);
    requestTiles(this.mFirstRequiredTileStart, paramInt1 - this.this$0.mTileSize, paramInt5, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListUtil.2
 * JD-Core Version:    0.7.0.1
 */