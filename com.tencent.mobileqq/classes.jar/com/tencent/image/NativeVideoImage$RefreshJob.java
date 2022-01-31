package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class NativeVideoImage$RefreshJob
  implements Runnable
{
  int refreshId;
  
  public NativeVideoImage$RefreshJob(NativeVideoImage paramNativeVideoImage, int paramInt)
  {
    this.refreshId = paramInt;
  }
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.this$0.debug)) {
      QLog.d(NativeVideoImage.TAG + NativeVideoImage.access$000(this.this$0), 2, "RefreshJob.run(): refreshId:" + this.refreshId);
    }
    NativeVideoImage.WrappedRefreshImg localWrappedRefreshImg = new NativeVideoImage.WrappedRefreshImg();
    localWrappedRefreshImg.img = this.this$0;
    localWrappedRefreshImg.refeshId = this.refreshId;
    this.this$0.mAccumulativeRunnable.add(new WeakReference[] { new WeakReference(localWrappedRefreshImg) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.RefreshJob
 * JD-Core Version:    0.7.0.1
 */