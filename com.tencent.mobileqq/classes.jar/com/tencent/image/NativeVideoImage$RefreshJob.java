package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
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
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.this$0.debug))
    {
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(NativeVideoImage.TAG);
      ((StringBuilder)localObject2).append(NativeVideoImage.access$000(this.this$0));
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RefreshJob.run(): refreshId:");
      localStringBuilder.append(this.refreshId);
      ((ILog)localObject1).d((String)localObject2, 2, localStringBuilder.toString());
    }
    Object localObject1 = new NativeVideoImage.WrappedRefreshImg();
    Object localObject2 = this.this$0;
    ((NativeVideoImage.WrappedRefreshImg)localObject1).img = ((AbstractVideoImage)localObject2);
    ((NativeVideoImage.WrappedRefreshImg)localObject1).refeshId = this.refreshId;
    ((NativeVideoImage)localObject2).mAccumulativeRunnable.add(new WeakReference[] { new WeakReference(localObject1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.RefreshJob
 * JD-Core Version:    0.7.0.1
 */