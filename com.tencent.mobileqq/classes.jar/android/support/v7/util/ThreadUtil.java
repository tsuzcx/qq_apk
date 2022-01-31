package android.support.v7.util;

abstract interface ThreadUtil<T>
{
  public abstract BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> paramBackgroundCallback);
  
  public abstract MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> paramMainThreadCallback);
  
  public static abstract interface BackgroundCallback<T>
  {
    public abstract void loadTile(int paramInt1, int paramInt2);
    
    public abstract void recycleTile(TileList.Tile<T> paramTile);
    
    public abstract void refresh(int paramInt);
    
    public abstract void updateRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  public static abstract interface MainThreadCallback<T>
  {
    public abstract void addTile(int paramInt, TileList.Tile<T> paramTile);
    
    public abstract void removeTile(int paramInt1, int paramInt2);
    
    public abstract void updateItemCount(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.util.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */