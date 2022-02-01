package androidx.lifecycle;

class ProcessLifecycleOwner$1
  implements Runnable
{
  ProcessLifecycleOwner$1(ProcessLifecycleOwner paramProcessLifecycleOwner) {}
  
  public void run()
  {
    this.this$0.dispatchPauseIfNeeded();
    this.this$0.dispatchStopIfNeeded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwner.1
 * JD-Core Version:    0.7.0.1
 */