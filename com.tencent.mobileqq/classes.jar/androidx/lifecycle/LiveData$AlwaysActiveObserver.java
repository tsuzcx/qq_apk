package androidx.lifecycle;

class LiveData$AlwaysActiveObserver
  extends LiveData<T>.ObserverWrapper
{
  LiveData$AlwaysActiveObserver(Observer<? super T> paramObserver)
  {
    super(paramObserver, localObserver);
  }
  
  boolean shouldBeActive()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.LiveData.AlwaysActiveObserver
 * JD-Core Version:    0.7.0.1
 */