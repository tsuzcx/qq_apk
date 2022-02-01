package com.tencent.biz.pubaccount.weishi_new.live;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class WSLiveAnimationManager
{
  private static volatile WSLiveAnimationManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager = null;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  public static WSLiveAnimationManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager = new WSLiveAnimationManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountWeishi_newLiveWSLiveAnimationManager;
    }
    finally {}
  }
  
  private void a(DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    WSLog.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]:" + paramDiniFlyAnimationView);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = WSLiveAnimation.a(paramDiniFlyAnimationView);
    }
    WSLog.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[startAnimation()]sBitmapLiveLogo:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    WSLiveAnimation.a(paramDiniFlyAnimationView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, paramWSLiveAnimationCallback);
  }
  
  private void b(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    paramString = WeishiUtils.a(paramString);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.a = paramString;
    ImageManager.a().a(localImageRequest, new WSLiveAnimationManager.1(this, paramDiniFlyAnimationView, paramWSLiveAnimationCallback));
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    WSLog.a("WSLiveAnimation", "[WSLiveAnimationManager.java]:[stopAnimation()]" + paramDiniFlyAnimationView);
    if (paramDiniFlyAnimationView != null) {
      paramDiniFlyAnimationView.cancelAnimation();
    }
  }
  
  public void a(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    b(paramDiniFlyAnimationView, paramString, paramWSLiveAnimationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager
 * JD-Core Version:    0.7.0.1
 */