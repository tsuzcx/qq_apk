package com.tencent.biz.pubaccount.weishi_new.live;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;

class WSLiveAnimationManager$1
  implements IBitmapCallback
{
  WSLiveAnimationManager$1(WSLiveAnimationManager paramWSLiveAnimationManager, DiniFlyAnimationView paramDiniFlyAnimationView, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    WSLiveAnimationManager.a(this.c, this.a, paramICloseableBitmap.b(), this.b);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramImageRequest = this.b;
    if (paramImageRequest != null) {
      paramImageRequest.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */