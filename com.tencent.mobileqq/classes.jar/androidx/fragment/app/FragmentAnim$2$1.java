package androidx.fragment.app;

class FragmentAnim$2$1
  implements Runnable
{
  FragmentAnim$2$1(FragmentAnim.2 param2) {}
  
  public void run()
  {
    if (this.this$0.val$fragment.getAnimatingAway() != null)
    {
      this.this$0.val$fragment.setAnimatingAway(null);
      this.this$0.val$callback.onComplete(this.this$0.val$fragment, this.this$0.val$signal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.2.1
 * JD-Core Version:    0.7.0.1
 */