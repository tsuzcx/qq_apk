package com.tencent.image;

import java.lang.ref.WeakReference;

class QQLiveImage$6
  implements Runnable
{
  QQLiveImage$6(QQLiveImage paramQQLiveImage, int paramInt, Object paramObject) {}
  
  public void run()
  {
    if ((this.this$0.mOnStateListener != null) && (this.this$0.mOnStateListener.get() != null)) {
      ((QQLiveDrawable.OnStateListener)this.this$0.mOnStateListener.get()).onStateChange(QQLiveImage.access$100(this.this$0), this.this$0.mParams, this.val$newState, this.val$extra);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.6
 * JD-Core Version:    0.7.0.1
 */