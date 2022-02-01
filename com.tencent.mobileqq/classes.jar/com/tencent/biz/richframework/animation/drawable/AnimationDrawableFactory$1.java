package com.tencent.biz.richframework.animation.drawable;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.ConcurrentHashMap;

class AnimationDrawableFactory$1
  implements RFWDownloader.RFWDownloadListener
{
  AnimationDrawableFactory$1(AnimationDrawableFactory paramAnimationDrawableFactory, long paramLong, AnimationDrawableCreateOption paramAnimationDrawableCreateOption, String paramString, AnimationDrawableFactory.CreateResultListener paramCreateResultListener) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    RFLog.d("AnimationDrawableFactory", RFLog.USR, "cost time" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramBoolean) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a()))
    {
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "get drawable file list success:" + this.jdField_a_of_type_JavaLangString);
      paramString = AnimationDrawableFactory.a(paramString, this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.b());
      if ((paramString == null) || (paramString.length == 0))
      {
        this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener.a(false, null);
        return;
      }
      ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).getUIHandlerV2().post(new AnimationDrawableFactory.1.1(this, paramString));
    }
    for (;;)
    {
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "removeKey" + this.jdField_a_of_type_JavaLangString);
      AnimationDrawableFactory.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory).remove(this.jdField_a_of_type_JavaLangString);
      return;
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "create animationDrawable failed");
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1
 * JD-Core Version:    0.7.0.1
 */