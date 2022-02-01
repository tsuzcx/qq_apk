package com.tencent.ilivesdk.playview.view;

class PlayView$6$1
  implements Runnable
{
  PlayView$6$1(PlayView.6 param6) {}
  
  public void run()
  {
    this.this$1.this$0.setVisibility(8);
    if (PlayView.access$500(this.this$1.this$0) != null) {
      PlayView.access$500(this.this$1.this$0).onError(this.this$1.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.6.1
 * JD-Core Version:    0.7.0.1
 */