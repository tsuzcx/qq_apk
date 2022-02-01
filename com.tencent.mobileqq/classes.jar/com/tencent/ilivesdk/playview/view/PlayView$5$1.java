package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$5$1
  implements Runnable
{
  PlayView$5$1(PlayView.5 param5) {}
  
  public void run()
  {
    LogUtils.i("MediaPESdk|PlayView", "==============PlayView set gone");
    this.this$1.this$0.setVisibility(8);
    if (PlayView.access$500(this.this$1.this$0) != null) {
      PlayView.access$500(this.this$1.this$0).onEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.5.1
 * JD-Core Version:    0.7.0.1
 */