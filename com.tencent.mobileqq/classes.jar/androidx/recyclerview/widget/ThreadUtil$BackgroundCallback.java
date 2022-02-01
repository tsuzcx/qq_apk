package androidx.recyclerview.widget;

public abstract interface ThreadUtil$BackgroundCallback<T>
{
  public abstract void loadTile(int paramInt1, int paramInt2);
  
  public abstract void recycleTile(TileList.Tile<T> paramTile);
  
  public abstract void refresh(int paramInt);
  
  public abstract void updateRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
 * JD-Core Version:    0.7.0.1
 */