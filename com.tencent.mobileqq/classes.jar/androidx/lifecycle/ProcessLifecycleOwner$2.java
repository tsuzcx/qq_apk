package androidx.lifecycle;

class ProcessLifecycleOwner$2
  implements ReportFragment.ActivityInitializationListener
{
  ProcessLifecycleOwner$2(ProcessLifecycleOwner paramProcessLifecycleOwner) {}
  
  public void onCreate() {}
  
  public void onResume()
  {
    this.this$0.activityResumed();
  }
  
  public void onStart()
  {
    this.this$0.activityStarted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwner.2
 * JD-Core Version:    0.7.0.1
 */