package com.tencent.biz.pubaccount.weishi_new.live;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class WSLiveAnimationManager$1
  implements IBitmapCallback
{
  WSLiveAnimationManager$1(WSLiveAnimationManager paramWSLiveAnimationManager, DiniFlyAnimationView paramDiniFlyAnimationView, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    WSLiveAnimationManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramCloseableBitmap.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager$WSLiveAnimationCallback);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager$WSLiveAnimationCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager$WSLiveAnimationCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */