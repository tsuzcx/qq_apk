package androidx.appcompat.widget;

class DropDownListView$ResolveHoverRunnable
  implements Runnable
{
  DropDownListView$ResolveHoverRunnable(DropDownListView paramDropDownListView) {}
  
  public void cancel()
  {
    DropDownListView localDropDownListView = this.this$0;
    localDropDownListView.mResolveHoverRunnable = null;
    localDropDownListView.removeCallbacks(this);
  }
  
  public void post()
  {
    this.this$0.post(this);
  }
  
  public void run()
  {
    DropDownListView localDropDownListView = this.this$0;
    localDropDownListView.mResolveHoverRunnable = null;
    localDropDownListView.drawableStateChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.DropDownListView.ResolveHoverRunnable
 * JD-Core Version:    0.7.0.1
 */