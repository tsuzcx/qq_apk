package com.tencent.biz.qqcircle.polylike;

import aavl;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import bclx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;
import uwz;
import uxh;
import vpk;
import vpl;
import vpn;
import vpu;
import zvg;
import zvh;
import zwe;
import zwj;

public class QCirclePolyLikeAniView
  extends FrameLayout
{
  private static final String TAG = "QCirclePolymorphicAniView";
  
  public QCirclePolyLikeAniView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePolyLikeAniView(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePolyLikeAniView(@NonNull Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String fetchLocal(String paramString)
  {
    paramString = zvh.a(zwj.a(uwz.a()).b(paramString));
    if ((paramString != null) && (paramString.length > 0)) {
      return paramString[0];
    }
    return "";
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void startRewardAni(QQCircleFeedBase.StPolyLike paramStPolyLike, View paramView1, View paramView2, boolean paramBoolean1, aavl paramaavl, boolean paramBoolean2)
  {
    String str;
    if (paramStPolyLike != null)
    {
      str = paramStPolyLike.fullScreenURLAND.get();
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return;
    }
    zvg localzvg = new zvg(str);
    localzvg.b(40);
    localzvg.a(2147483647L);
    localzvg.a(true);
    localzvg.b(false);
    zvh.a().a(hashCode(), localzvg.a(), new vpl(this, str, paramBoolean2, paramStPolyLike, paramView1, paramView2, paramBoolean1, paramaavl));
  }
  
  public void startZanAni(QQCircleFeedBase.StPolyLike paramStPolyLike, View paramView1, View paramView2, View paramView3, int[] paramArrayOfInt, boolean paramBoolean, aavl paramaavl)
  {
    Object localObject2;
    int[] arrayOfInt;
    Object localObject1;
    PointF localPointF1;
    PointF localPointF2;
    if ((paramView1 != null) && (paramArrayOfInt != null) && (paramView2 != null) && (paramView3 != null))
    {
      setVisibility(0);
      localObject2 = new int[2];
      arrayOfInt = new int[2];
      paramView2.getLocationInWindow((int[])localObject2);
      getLocationOnScreen(arrayOfInt);
      paramArrayOfInt[1] -= vpu.a / 2;
      localObject1 = new PointF();
      localPointF1 = new PointF();
      localPointF2 = new PointF();
      ((PointF)localObject1).x = paramArrayOfInt[0];
      ((PointF)localObject1).y = paramArrayOfInt[1];
      localPointF1.x = (localObject2[0] + paramView2.getWidth() / 2);
      localPointF1.y = (localObject2[1] + paramView2.getHeight() / 2);
      localPointF2.x = ((localPointF1.x + ((PointF)localObject1).x) / 2.0F);
      if (((PointF)localObject1).y <= localPointF1.y) {
        break label601;
      }
    }
    label601:
    for (localPointF1.y -= bclx.a(150.0F);; localPointF2.y = (((PointF)localObject1).y - bclx.a(150.0F)))
    {
      QLog.d("QCirclePolymorphicAniView", 1, "start pos:" + ((PointF)localObject1).x + " " + ((PointF)localObject1).y + "  control pos:" + localPointF2.x + " " + localPointF2.y + " edn pos:" + localPointF1.x + " " + localPointF1.y + "aniPanel:" + getWidth() + " " + getHeight());
      paramView2 = new QCirclePolyLikeAniView.MovingImg(getContext());
      paramView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850664);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramView1.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramView1.getHeight();
      paramView2.setWidthAndHeight(paramView1.getWidth(), paramView1.getHeight());
      uxh.a(fetchLocal(paramStPolyLike.polySource.get()), paramView2, (URLDrawable.URLDrawableOptions)localObject2, true);
      paramView2.setTopShift(arrayOfInt[1]);
      paramView2.setX(paramArrayOfInt[0]);
      paramView2.setY(paramArrayOfInt[1] - arrayOfInt[1]);
      paramView1 = new FrameLayout.LayoutParams(paramView1.getWidth(), paramView1.getHeight());
      removeAllViews();
      addView(paramView2, paramView1);
      paramView1 = ObjectAnimator.ofObject(paramView2, "mPointF", new vpn(this, localPointF2), new Object[] { localObject1, localPointF1 });
      paramArrayOfInt = ObjectAnimator.ofObject(paramView2, "mScale", new vpn(this, new PointF(0.88F, 1.0F)), new Object[] { new PointF(1.0F, 1.0F), new PointF(0.0F, 0.0F) });
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { paramView1, paramArrayOfInt });
      ((AnimatorSet)localObject1).setDuration(300L);
      ((AnimatorSet)localObject1).start();
      ((AnimatorSet)localObject1).addListener(new vpk(this, paramaavl, paramView3, paramView2, paramStPolyLike));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView
 * JD-Core Version:    0.7.0.1
 */