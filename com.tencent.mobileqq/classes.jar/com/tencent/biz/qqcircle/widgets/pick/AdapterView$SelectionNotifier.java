package com.tencent.biz.qqcircle.widgets.pick;

class AdapterView$SelectionNotifier
  implements Runnable
{
  private AdapterView$SelectionNotifier(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.this$0.w)
    {
      if (this.this$0.getAdapter() != null) {
        this.this$0.post(this);
      }
    }
    else {
      AdapterView.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AdapterView.SelectionNotifier
 * JD-Core Version:    0.7.0.1
 */