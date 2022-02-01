package com.tencent.mobileqq.activity.springfestival.entry;

class SpringFestivalEntryManager$TaskCallbackNotNullWrapper
  implements Runnable
{
  Runnable a;
  
  public SpringFestivalEntryManager$TaskCallbackNotNullWrapper(SpringFestivalEntryManager paramSpringFestivalEntryManager, Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    if (SpringFestivalEntryManager.g(this.this$0) != null) {
      this.a.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.TaskCallbackNotNullWrapper
 * JD-Core Version:    0.7.0.1
 */