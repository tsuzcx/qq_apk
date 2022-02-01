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
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost time");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    RFLog.d("AnimationDrawableFactory", i, localStringBuilder.toString());
    if ((paramBoolean) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a()))
    {
      i = RFLog.USR;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("get drawable file list success:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      RFLog.d("AnimationDrawableFactory", i, localStringBuilder.toString());
      paramString = AnimationDrawableFactory.a(paramString, this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.b());
      if ((paramString != null) && (paramString.length != 0)) {
        ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).getUIHandlerV2().post(new AnimationDrawableFactory.1.1(this, paramString));
      } else {
        this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener.a(false, null);
      }
    }
    else
    {
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "create animationDrawable failed");
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener.a(false, null);
    }
    i = RFLog.USR;
    paramString = new StringBuilder();
    paramString.append("removeKey");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    RFLog.d("AnimationDrawableFactory", i, paramString.toString());
    AnimationDrawableFactory.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory).remove(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1
 * JD-Core Version:    0.7.0.1
 */