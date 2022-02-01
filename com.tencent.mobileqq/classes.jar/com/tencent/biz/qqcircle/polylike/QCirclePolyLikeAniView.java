package com.tencent.biz.qqcircle.polylike;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeAniView
  extends FrameLayout
{
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
  
  private String a(String paramString)
  {
    paramString = AnimationDrawableFactory.a(RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getContentFilePath(paramString));
    if ((paramString != null) && (paramString.length > 0)) {
      return paramString[0];
    }
    return "";
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike, View paramView1, View paramView2, View paramView3, int[] paramArrayOfInt, boolean paramBoolean, AnimationListener.Stop paramStop)
  {
    if ((paramView1 != null) && (paramArrayOfInt != null) && (paramView2 != null) && (paramView3 != null))
    {
      setVisibility(0);
      Object localObject2 = new int[2];
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow((int[])localObject2);
      getLocationOnScreen(arrayOfInt);
      paramArrayOfInt[1] -= QCirclePolyLikePopWindow.a / 2;
      Object localObject1 = new PointF();
      PointF localPointF = new PointF();
      ((PointF)localObject1).x = paramArrayOfInt[0];
      ((PointF)localObject1).y = paramArrayOfInt[1];
      localPointF.x = (localObject2[0] + paramView2.getWidth() / 2);
      localPointF.y = (localObject2[1] + paramView2.getHeight() / 2);
      localObject2 = new PointF();
      ((PointF)localObject2).x = ((localPointF.x + ((PointF)localObject1).x) / 2.0F);
      if (((PointF)localObject1).y > localPointF.y) {
        ((PointF)localObject2).y = (localPointF.y - ViewUtils.a(150.0F));
      } else {
        ((PointF)localObject1).y -= ViewUtils.a(150.0F);
      }
      paramView2 = new StringBuilder();
      paramView2.append("start pos:");
      paramView2.append(((PointF)localObject1).x);
      paramView2.append(" ");
      paramView2.append(((PointF)localObject1).y);
      paramView2.append("  control pos:");
      paramView2.append(((PointF)localObject2).x);
      paramView2.append(" ");
      paramView2.append(((PointF)localObject2).y);
      paramView2.append(" edn pos:");
      paramView2.append(localPointF.x);
      paramView2.append(" ");
      paramView2.append(localPointF.y);
      paramView2.append("aniPanel:");
      paramView2.append(getWidth());
      paramView2.append(" ");
      paramView2.append(getHeight());
      QLog.d("QCirclePolymorphicAniView", 1, paramView2.toString());
      paramView2 = new QCirclePolyLikeAniView.MovingImg(getContext());
      paramView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramView2.a(paramView1.getWidth(), paramView1.getHeight());
      Object localObject3 = a(paramStPolyLike.polySource.get());
      localObject3 = new Option().setLoadingDrawable(QCircleApplication.APP.getResources().getDrawable(2130853309)).setRequestHeight(paramView1.getHeight()).setRequestWidth(paramView1.getWidth()).setTargetView(paramView2).setUrl((String)localObject3);
      QCircleFeedPicLoader.g().loadImage((Option)localObject3, null);
      paramView2.a(arrayOfInt[1]);
      paramView2.setX(paramArrayOfInt[0]);
      paramView2.setY(paramArrayOfInt[1] - arrayOfInt[1]);
      paramView1 = new FrameLayout.LayoutParams(paramView1.getWidth(), paramView1.getHeight());
      removeAllViews();
      addView(paramView2, paramView1);
      paramView1 = ObjectAnimator.ofObject(paramView2, "mPointF", new QCirclePolyLikeAniView.PointFTypeEvaluator((PointF)localObject2), new Object[] { localObject1, localPointF });
      paramArrayOfInt = ObjectAnimator.ofObject(paramView2, "mScale", new QCirclePolyLikeAniView.PointFTypeEvaluator(new PointF(0.88F, 1.0F)), new Object[] { new PointF(1.0F, 1.0F), new PointF(0.0F, 0.0F) });
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).playTogether(new Animator[] { paramView1, paramArrayOfInt });
      ((AnimatorSet)localObject1).setDuration(300L);
      ((AnimatorSet)localObject1).start();
      ((AnimatorSet)localObject1).addListener(new QCirclePolyLikeAniView.1(this, paramStop, paramView3, paramView2, paramStPolyLike));
    }
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike, View paramView1, View paramView2, boolean paramBoolean1, AnimationListener.Stop paramStop, boolean paramBoolean2)
  {
    if (paramStPolyLike != null)
    {
      String str = paramStPolyLike.fullScreenURLAND.get();
      if (TextUtils.isEmpty(str)) {
        return;
      }
      AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder(str);
      localBuilder.b(40);
      localBuilder.a(2147483647L);
      localBuilder.a(true);
      localBuilder.b(false);
      AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), new QCirclePolyLikeAniView.2(this, str, paramBoolean2, paramStPolyLike, paramView1, paramView2, paramBoolean1, paramStop));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView
 * JD-Core Version:    0.7.0.1
 */