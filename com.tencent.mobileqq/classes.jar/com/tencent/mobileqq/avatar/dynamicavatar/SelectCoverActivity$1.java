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
    Bitmap localBitmap = VideoDrawableHandler.a(this.this$0.a);
    if (this.this$0.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (localBitmap != null) {
        this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(4, localBitmap).sendToTarget();
      }
      while ((this.this$0.d == 1) || (this.this$0.d == 3))
      {
        SelectCoverActivity.a(this.this$0);
        return;
        this.this$0.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.1
 * JD-Core Version:    0.7.0.1
 */