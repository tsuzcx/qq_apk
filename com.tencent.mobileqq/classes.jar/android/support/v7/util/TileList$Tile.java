package android.support.v7.util;

import java.lang.reflect.Array;

public class TileList$Tile<T>
{
  public int mItemCount;
  public final T[] mItems;
  Tile<T> mNext;
  public int mStartPosition;
  
  public TileList$Tile(Class<T> paramClass, int paramInt)
  {
    this.mItems = ((Object[])Array.newInstance(paramClass, paramInt));
  }
  
  boolean containsPosition(int paramInt)
  {
    int i = this.mStartPosition;
    return (i <= paramInt) && (paramInt < i + this.mItemCount);
  }
  
  T getByPosition(int paramInt)
  {
    return this.mItems[(paramInt - this.mStartPosition)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.util.TileList.Tile
 * JD-Core Version:    0.7.0.1
 */