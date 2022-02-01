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
  private static volatile WSLiveAnimationManager b;
  private Bitmap a;
  
  public static WSLiveAnimationManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new WSLiveAnimationManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(DiniFlyAnimationView paramDiniFlyAnimationView, Bitmap paramBitmap, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSLiveAnimationManager.java]:[startAnimation()]:");
    localStringBuilder.append(paramDiniFlyAnimationView);
    WSLog.a("WSLiveAnimation", localStringBuilder.toString());
    if (this.a == null) {
      this.a = WSLiveAnimation.a(paramDiniFlyAnimationView);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSLiveAnimationManager.java]:[startAnimation()]sBitmapLiveLogo:");
    localStringBuilder.append(this.a);
    WSLog.a("WSLiveAnimation", localStringBuilder.toString());
    WSLiveAnimation.a(paramDiniFlyAnimationView, this.a, paramBitmap, paramWSLiveAnimationCallback);
  }
  
  private void b(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, WSLiveAnimationManager.WSLiveAnimationCallback paramWSLiveAnimationCallback)
  {
    paramString = WeishiUtils.c(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimationManager
 * JD-Core Version:    0.7.0.1
 */