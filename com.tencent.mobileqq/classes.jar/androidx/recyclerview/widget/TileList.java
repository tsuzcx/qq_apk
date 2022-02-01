package androidx.recyclerview.widget;

import android.util.SparseArray;

class TileList<T>
{
  TileList.Tile<T> mLastAccessedTile;
  final int mTileSize;
  private final SparseArray<TileList.Tile<T>> mTiles = new SparseArray(10);
  
  public TileList(int paramInt)
  {
    this.mTileSize = paramInt;
  }
  
  public TileList.Tile<T> addOrReplace(TileList.Tile<T> paramTile)
  {
    int i = this.mTiles.indexOfKey(paramTile.mStartPosition);
    if (i < 0)
    {
      this.mTiles.put(paramTile.mStartPosition, paramTile);
      return null;
    }
    TileList.Tile localTile = (TileList.Tile)this.mTiles.valueAt(i);
    this.mTiles.setValueAt(i, paramTile);
    if (this.mLastAccessedTile == localTile) {
      this.mLastAccessedTile = paramTile;
    }
    return localTile;
  }
  
  public void clear()
  {
    this.mTiles.clear();
  }
  
  public TileList.Tile<T> getAtIndex(int paramInt)
  {
    return (TileList.Tile)this.mTiles.valueAt(paramInt);
  }
  
  public T getItemAt(int paramInt)
  {
    TileList.Tile localTile = this.mLastAccessedTile;
    if ((localTile == null) || (!localTile.containsPosition(paramInt)))
    {
      int i = this.mTileSize;
      i = this.mTiles.indexOfKey(paramInt - paramInt % i);
      if (i < 0) {
        return null;
      }
      this.mLastAccessedTile = ((TileList.Tile)this.mTiles.valueAt(i));
    }
    return this.mLastAccessedTile.getByPosition(paramInt);
  }
  
  public TileList.Tile<T> removeAtPos(int paramInt)
  {
    TileList.Tile localTile = (TileList.Tile)this.mTiles.get(paramInt);
    if (this.mLastAccessedTile == localTile) {
      this.mLastAccessedTile = null;
    }
    this.mTiles.delete(paramInt);
    return localTile;
  }
  
  public int size()
  {
    return this.mTiles.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.TileList
 * JD-Core Version:    0.7.0.1
 */