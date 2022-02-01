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
    WSLiveAnimationManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramICloseableBitmap.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager$WSLiveAnimationCallback);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramImageRequest = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager$WSLiveAnimationCallback;
    if (paramImageRequest != null) {
      paramImageRequest.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */