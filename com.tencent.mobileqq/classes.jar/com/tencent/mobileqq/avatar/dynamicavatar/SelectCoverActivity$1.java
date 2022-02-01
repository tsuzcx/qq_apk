package com.tencent.mobileqq.avatar.dynamicavatar;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;

class SelectCoverActivity$1
  implements Runnable
{
  SelectCoverActivity$1(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = VideoDrawableHandler.b(this.this$0.n);
    if (this.this$0.F) {
      return;
    }
    if (localBitmap != null) {
      this.this$0.j.obtainMessage(4, localBitmap).sendToTarget();
    } else {
      this.this$0.j.sendEmptyMessage(6);
    }
    if ((this.this$0.x == 1) || (this.this$0.x == 3)) {
      SelectCoverActivity.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.1
 * JD-Core Version:    0.7.0.1
 */