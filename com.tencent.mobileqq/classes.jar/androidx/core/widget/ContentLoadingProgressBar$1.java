package androidx.core.widget;

class ContentLoadingProgressBar$1
  implements Runnable
{
  ContentLoadingProgressBar$1(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public void run()
  {
    ContentLoadingProgressBar localContentLoadingProgressBar = this.this$0;
    localContentLoadingProgressBar.mPostedHide = false;
    localContentLoadingProgressBar.mStartTime = -1L;
    localContentLoadingProgressBar.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar.1
 * JD-Core Version:    0.7.0.1
 */