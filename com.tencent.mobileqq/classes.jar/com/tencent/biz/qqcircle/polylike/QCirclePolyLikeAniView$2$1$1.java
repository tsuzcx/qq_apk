package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikeAniView$2$1$1
  implements QQAnimationDrawable.QQAnimationListener
{
  QCirclePolyLikeAniView$2$1$1(QCirclePolyLikeAniView.2.1 param1, ImageView paramImageView) {}
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create ain stop:");
    ((StringBuilder)localObject).append(this.a.getHeight());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.a.getWidth());
    QLog.d("QCirclePolymorphicAniView", 1, ((StringBuilder)localObject).toString());
    if (this.b.b.b)
    {
      int i = (DisplayUtil.d() - this.a.getWidth()) / 2;
      int j = (DisplayUtil.e() - this.a.getHeight()) / 2;
      this.b.a.a(null);
      localObject = this.b.b.h;
      QQCircleFeedBase.StPolyLike localStPolyLike = this.b.b.c;
      ImageView localImageView = this.a;
      View localView1 = this.b.b.d;
      View localView2 = this.b.b.e;
      boolean bool = this.b.b.f;
      AnimationListener.Stop localStop = this.b.b.g;
      ((QCirclePolyLikeAniView)localObject).a(localStPolyLike, localImageView, localView1, localView2, new int[] { i, j }, bool, localStop);
    }
    else
    {
      this.b.a.a(null);
      this.a.setAnimation(null);
      this.b.b.h.removeAllViews();
      this.b.b.h.setVisibility(8);
    }
    this.b.a.stop();
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCirclePolymorphicAniView", 1, "create ain onPlay:");
  }
  
  public void b()
  {
    QLog.d("QCirclePolymorphicAniView", 1, "create ain start:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.2.1.1
 * JD-Core Version:    0.7.0.1
 */