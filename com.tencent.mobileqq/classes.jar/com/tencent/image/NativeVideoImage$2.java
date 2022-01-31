package com.tencent.image;

import com.tencent.qphone.base.util.QLog;

class NativeVideoImage$2
  implements Runnable
{
  NativeVideoImage$2(NativeVideoImage paramNativeVideoImage) {}
  
  public void run()
  {
    if (this.this$0.mPlayOnceListener != null)
    {
      this.this$0.mPlayOnceListener.onFinish();
      this.this$0.mPlayOnceListener = null;
      if (QLog.isColorLevel()) {
        QLog.e(NativeVideoImage.TAG, 2, "getNextFrame(), mPlayOnceListener.onFinish()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.2
 * JD-Core Version:    0.7.0.1
 */