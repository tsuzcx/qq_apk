package com.tencent.biz.qqcircle.widgets;

import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import feedcloud.FeedCloudMeta.StAnimation;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastContent;

class QCirclePushToastView$1
  implements Runnable
{
  QCirclePushToastView$1(QCirclePushToastView paramQCirclePushToastView, FeedCloudToastshowsvr.StToast paramStToast) {}
  
  public void run()
  {
    Object localObject = this.a.toastContent.rightIconAnimation.animationUrl.get();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QCirclePushToastView.b(this.this$0).fromNetworkWithCacheBitmap(QCirclePushToastView.a(this.this$0), (String)localObject);
      QCirclePushToastView.a(this.this$0).addAnimatorListener(new QCirclePushToastView.1.1(this));
    }
    if (!TextUtils.isEmpty(this.a.toastContent.closeButtonImg.picUrl.get()))
    {
      localObject = AnimationUtils.loadAnimation(this.this$0.getContext(), 2130772339);
      QCirclePushToastView.c(this.this$0).startAnimation((Animation)localObject);
      QCirclePushToastView.c(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushToastView.1
 * JD-Core Version:    0.7.0.1
 */