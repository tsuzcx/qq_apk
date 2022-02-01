package com.tencent.biz.pubaccount.weishi_new.live;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;

public class WSLiveAnimationManager
{
  private static volatile WSLiveAnimationManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  public static WSLiveAnimationManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager == null) {
          jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager = new WSLiveAnimationManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager;
  }
  
  private void a(DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSLiveAnimationManager.java]:[startAnimation()]:");
    localStringBuilder.append(paramDiniFlyAnimationView);
    WSLog.a("WSLiveAnimation", localStringBuilder.toString());
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = WSLiveAnimation.a(paramDiniFlyAnimationView);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSLiveAnimationManager.java]:[startAnimation()]sBitmapLiveLogo:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    WSLog.a("WSLiveAnimation", localStringBuilder.toString());
    WSLiveAnimation.a(paramDiniFlyAnimationView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramWSLiveAnimationCallback);
  }
  
  private void b(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    paramString = WeishiUtils.a(paramString);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.a = paramString;
    ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, new WSLiveAnimationManager.1(this, paramDiniFlyAnimationView, paramWSLiveAnimationCallback));
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSLiveAnimationManager.java]:[stopAnimation()]");
    localStringBuilder.append(paramDiniFlyAnimationView);
    WSLog.a("WSLiveAnimation", localStringBuilder.toString());
    if (paramDiniFlyAnimationView != null) {
      paramDiniFlyAnimationView.cancelAnimation();
    }
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    b(paramDiniFlyAnimationView, paramString, paramWSLiveAnimationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager
 * JD-Core Version:    0.7.0.1
 */