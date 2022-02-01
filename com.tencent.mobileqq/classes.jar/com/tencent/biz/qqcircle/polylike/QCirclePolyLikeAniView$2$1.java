package com.tencent.biz.qqcircle.polylike;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

class QCirclePolyLikeAniView$2$1
  implements Runnable
{
  QCirclePolyLikeAniView$2$1(QCirclePolyLikeAniView.2 param2, QQAnimationDrawable paramQQAnimationDrawable) {}
  
  public void run()
  {
    Object localObject1 = QCirclePolyLikeAniView.a(this.b.h, this.b.a);
    int i = DisplayUtil.d();
    int j = DisplayUtil.e();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (FileUtils.a((String)localObject1)))
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
      i = ((BitmapFactory.Options)localObject2).outWidth;
      j = ((BitmapFactory.Options)localObject2).outHeight;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("create width: ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(j);
      QLog.d("QCirclePolymorphicAniView", 1, ((StringBuilder)localObject1).toString());
    }
    this.b.h.setVisibility(0);
    localObject1 = new ImageView(this.b.h.getContext());
    Object localObject2 = new FrameLayout.LayoutParams(i, j);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    ((ImageView)localObject1).setImageDrawable(this.a);
    this.a.a(new QCirclePolyLikeAniView.2.1.1(this, (ImageView)localObject1));
    this.b.h.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.a.b(true);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.2.1
 * JD-Core Version:    0.7.0.1
 */