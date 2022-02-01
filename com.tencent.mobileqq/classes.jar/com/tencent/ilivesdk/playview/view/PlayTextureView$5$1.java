package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$5$1
  implements Runnable
{
  PlayTextureView$5$1(PlayTextureView.5 param5) {}
  
  public void run()
  {
    LogUtils.i("Render|PlayTextureView", "==============PlayView set gone");
    this.this$1.this$0.setVisibility(8);
    if (PlayTextureView.access$500(this.this$1.this$0) != null) {
      PlayTextureView.access$500(this.this$1.this$0).onEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.5.1
 * JD-Core Version:    0.7.0.1
 */