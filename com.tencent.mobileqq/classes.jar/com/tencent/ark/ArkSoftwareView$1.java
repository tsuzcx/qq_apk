package com.tencent.ark;

import android.graphics.Rect;
import java.util.concurrent.locks.Lock;

class ArkSoftwareView$1
  implements Runnable
{
  ArkSoftwareView$1(ArkSoftwareView paramArkSoftwareView) {}
  
  public void run()
  {
    this.this$0.mUpdateLock.lock();
    if (!this.this$0.mRectUpdate.isEmpty())
    {
      Rect localRect = ArkViewModel.scaleRect(this.this$0.mRectUpdate, this.this$0.mViewImpl.mScale);
      this.this$0.invalidate(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.this$0.invalidate();
      this.this$0.mRectUpdate.setEmpty();
    }
    this.this$0.mUpdateLock.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkSoftwareView.1
 * JD-Core Version:    0.7.0.1
 */