package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;

class PlayTextureView$5$2
  implements Runnable
{
  PlayTextureView$5$2(PlayTextureView.5 param5) {}
  
  public void run()
  {
    PlayTextureView.access$2102(this.this$1.this$0, false);
    if (PlayTextureView.access$2200(this.this$1.this$0) != null)
    {
      LogUtils.i("Render|PlayTextureView", "==============stopping need play file again");
      this.this$1.this$0.playFile(PlayTextureView.access$2200(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.5.2
 * JD-Core Version:    0.7.0.1
 */