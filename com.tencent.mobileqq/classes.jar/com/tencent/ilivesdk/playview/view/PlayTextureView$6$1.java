package com.tencent.ilivesdk.playview.view;

class PlayTextureView$6$1
  implements Runnable
{
  PlayTextureView$6$1(PlayTextureView.6 param6) {}
  
  public void run()
  {
    this.this$1.this$0.setVisibility(8);
    if (PlayTextureView.access$500(this.this$1.this$0) != null) {
      PlayTextureView.access$500(this.this$1.this$0).onError(this.this$1.val$errorCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.6.1
 * JD-Core Version:    0.7.0.1
 */