package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;

class PlayView$5$2
  implements Runnable
{
  PlayView$5$2(PlayView.5 param5) {}
  
  public void run()
  {
    PlayView.access$2102(this.this$1.this$0, false);
    if (PlayView.access$2200(this.this$1.this$0) != null)
    {
      LogUtils.i("MediaPESdk|PlayView", "==============stopping need play file again");
      this.this$1.this$0.playFile(PlayView.access$2200(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.5.2
 * JD-Core Version:    0.7.0.1
 */