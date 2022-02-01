package android.arch.lifecycle;

class LiveData$1
  implements Runnable
{
  LiveData$1(LiveData paramLiveData) {}
  
  public void run()
  {
    synchronized (LiveData.access$000(this.this$0))
    {
      Object localObject2 = LiveData.access$100(this.this$0);
      LiveData.access$102(this.this$0, LiveData.access$200());
      this.this$0.setValue(localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.LiveData.1
 * JD-Core Version:    0.7.0.1
 */