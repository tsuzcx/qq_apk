package androidx.recyclerview.widget;

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
    return (this.mStartPosition <= paramInt) && (paramInt < this.mStartPosition + this.mItemCount);
  }
  
  T getByPosition(int paramInt)
  {
    return this.mItems[(paramInt - this.mStartPosition)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.TileList.Tile
 * JD-Core Version:    0.7.0.1
 */