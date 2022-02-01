package androidx.recyclerview.widget;

class MessageThreadUtil<T>
  implements ThreadUtil<T>
{
  public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> paramBackgroundCallback)
  {
    return new MessageThreadUtil.2(this, paramBackgroundCallback);
  }
  
  public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> paramMainThreadCallback)
  {
    return new MessageThreadUtil.1(this, paramMainThreadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.MessageThreadUtil
 * JD-Core Version:    0.7.0.1
 */