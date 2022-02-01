package com.tencent.image;

import java.lang.ref.WeakReference;

class QQLiveImage$5
  implements Runnable
{
  QQLiveImage$5(QQLiveImage paramQQLiveImage, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mOnStateListener != null) && (this.this$0.mOnStateListener.get() != null)) {
      ((QQLiveDrawable.OnStateListener)this.this$0.mOnStateListener.get()).onStateChange(QQLiveImage.access$100(this.this$0), this.this$0.mParams, this.val$state, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.5
 * JD-Core Version:    0.7.0.1
 */