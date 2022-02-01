package com.tencent.biz.qqcircle.polylike;

import android.animation.Animator;
import android.app.Application;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterPolyLikeCloseEvent;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikeAniView$1
  extends QCircleD8SafeAnimatorListener
{
  QCirclePolyLikeAniView$1(QCirclePolyLikeAniView paramQCirclePolyLikeAniView, AnimationListener.Stop paramStop, View paramView, QCirclePolyLikeAniView.MovingImg paramMovingImg, QQCircleFeedBase.StPolyLike paramStPolyLike) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.a();
    }
    if ((this.b instanceof URLImageView))
    {
      this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramAnimator = new Option().setLoadingDrawable(QCircleApplication.APP.getResources().getDrawable(2130845305)).setRequestHeight(this.b.getHeight()).setRequestWidth(this.b.getWidth()).setUrl(this.d.polyIconUrl.get()).setTargetView((ImageView)this.b);
      QCircleFeedPicLoader.g().loadImage(paramAnimator, null);
    }
    this.e.removeAllViews();
    this.e.setVisibility(8);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterPolyLikeCloseEvent(0));
    QLog.d("QCirclePolymorphicAniView", 1, "poly ani end");
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.1
 * JD-Core Version:    0.7.0.1
 */