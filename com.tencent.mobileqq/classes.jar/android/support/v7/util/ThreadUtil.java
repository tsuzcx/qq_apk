package android.support.v7.util;

abstract interface ThreadUtil<T>
{
  public abstract ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> paramBackgroundCallback);
  
  public abstract ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> paramMainThreadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.util.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */