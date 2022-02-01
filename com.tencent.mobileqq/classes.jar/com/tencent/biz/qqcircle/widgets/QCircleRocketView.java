package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadResult;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class QCircleRocketView
  extends FrameLayout
  implements SimpleEventReceiver
{
  private static RFWMultiDownloadHelper a = new RFWMultiDownloadHelper();
  private static boolean b;
  private static Map<String, RFWMultiDownloadHelper.DownloadResult> g;
  private AtomicInteger c;
  private AtomicInteger d;
  private String e;
  private int f;
  private String[] h;
  
  static
  {
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket1_new.zip", QCirclePluginConfig.e()));
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket2_new.zip", QCirclePluginConfig.e()));
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket3_new.zip", QCirclePluginConfig.e()));
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket_single_click_new.zip", QCirclePluginConfig.e()));
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket_end_new.zip", QCirclePluginConfig.e()));
    a.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/rocket_count.zip", QCirclePluginConfig.e()));
    a.start();
  }
  
  public QCircleRocketView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleRocketView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleRocketView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = new AtomicInteger(0);
    this.d = new AtomicInteger(0);
    bringToFront();
  }
  
  private void a(int paramInt)
  {
    if ((paramInt >= this.c.get()) && (!TextUtils.isEmpty(this.e))) {
      SimpleEventBus.getInstance().dispatchEvent(new QCirclePushAnimationStateEvent(this.e, 2, this.f));
    }
  }
  
  private LinearLayout b(int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(70.0F), ViewUtils.a(120.0F));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ViewUtils.a(24.0F);
    float f1;
    if (paramInt == 10) {
      f1 = 64.0F;
    } else {
      f1 = 68.0F;
    }
    localLayoutParams.leftMargin = ViewUtils.a(f1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    LayoutInflater.from(getContext()).inflate(2131626917, localLinearLayout);
    return localLinearLayout;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    setVisibility(0);
    this.d.set(paramInt1);
    int i = paramInt1 % 3;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(" count ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" rockeyType ");
    ((StringBuilder)localObject1).append(i);
    QLog.d("QCircleRocketView", 4, ((StringBuilder)localObject1).toString());
    localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket_single_click_new.zip";
    if (paramInt2 != 1) {
      if (paramInt1 == 10) {
        localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket_end_new.zip";
      } else if (i == 0) {
        localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket3_new.zip";
      } else if (i == 1) {
        localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket1_new.zip";
      } else if (i == 2) {
        localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket2_new.zip";
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" key = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("QCircleRocketView", 4, ((StringBuilder)localObject2).toString());
    localObject2 = g;
    if ((localObject2 != null) && (((Map)localObject2).containsKey(localObject1))) {
      try
      {
        localObject1 = (RFWMultiDownloadHelper.DownloadResult)g.get(localObject1);
        localObject2 = (RFWMultiDownloadHelper.DownloadResult)g.get("https://downv6.qq.com/video_story/qcircle/animation/rocket_count.zip");
        if (localObject1 != null)
        {
          if (localObject2 == null) {
            return;
          }
          localObject1 = AnimationDrawableFactory.a(((RFWMultiDownloadHelper.DownloadResult)localObject1).mFilePath);
          this.h = AnimationDrawableFactory.a(((RFWMultiDownloadHelper.DownloadResult)localObject2).mFilePath);
          if (localObject1 != null)
          {
            if (this.h == null) {
              return;
            }
            localObject2 = new QQAnimationDrawable();
            ((QQAnimationDrawable)localObject2).a((String[])localObject1);
            FrameAnimationView localFrameAnimationView = new FrameAnimationView(getContext());
            Object localObject3 = new FrameLayout.LayoutParams(ViewUtils.a(140.0F), ViewUtils.a(210.0F));
            ((FrameLayout.LayoutParams)localObject3).rightMargin = ViewUtils.a(1.0F);
            localFrameAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localFrameAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ((QQAnimationDrawable)localObject2).b(true);
            ((QQAnimationDrawable)localObject2).b(30L);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("hashCode");
            ((StringBuilder)localObject3).append(localObject2.hashCode());
            ((StringBuilder)localObject3).append(" count");
            ((StringBuilder)localObject3).append(paramInt1);
            QLog.i("QQAnimationDrawable", 1, ((StringBuilder)localObject3).toString());
            i = ((QQAnimationDrawable)localObject2).a();
            double d2 = i;
            double d1;
            if (paramInt1 == 10) {
              d1 = 0.65D;
            } else {
              d1 = 0.5D;
            }
            Double.isNaN(d2);
            ((QQAnimationDrawable)localObject2).a(new QCircleRocketView.1(this, Double.valueOf(d2 * d1).intValue(), paramInt1, paramInt2));
            localFrameAnimationView.setImageDrawable((Drawable)localObject2);
            addView(localFrameAnimationView);
            ((QQAnimationDrawable)localObject2).start();
            RFThreadManager.getUIHandler().postDelayed(new QCircleRocketView.2(this, localFrameAnimationView, (QQAnimationDrawable)localObject2, paramInt1), localObject1.length * 30);
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startRockeyAnimation error");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("QCircleRocketView", 1, ((StringBuilder)localObject2).toString());
        a(paramInt1);
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.h.length)
    {
      QLog.e("QCircleRocketView", 1, "Push count is out of bound");
      return;
    }
    Object localObject4 = b(paramInt1);
    Object localObject1 = (ImageView)((View)localObject4).findViewById(2131441701);
    if (this.h.length == 0) {
      return;
    }
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject3 = new ColorDrawable(getContext().getResources().getColor(2131168376));
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((ImageView)localObject1).getMeasuredWidth();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((ImageView)localObject1).getMeasuredHeight();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("options.mRequestWidth =");
      ((StringBuilder)localObject3).append(((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth);
      ((StringBuilder)localObject3).append("options.mRequestHeight =");
      ((StringBuilder)localObject3).append(((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight);
      QLog.d("QCircleRocketView", 1, ((StringBuilder)localObject3).toString());
      ((ImageView)localObject1).setImageDrawable(URLDrawable.getFileDrawable(this.h[(paramInt1 - 1)], (URLDrawable.URLDrawableOptions)localObject2));
    }
    addView((View)localObject4);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject4, "alpha", new float[] { 0.0F, 1.0F });
    if (paramInt1 == 10)
    {
      localObject1 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 0.4F, 1.1F });
      localObject2 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 0.4F, 1.1F });
      localObject3 = ObjectAnimator.ofFloat(localObject4, "translationY", new float[] { 0.0F, -36.0F });
    }
    else
    {
      localObject1 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 0.5F, 1.0F });
      localObject2 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 0.5F, 1.0F });
      localObject3 = ObjectAnimator.ofFloat(localObject4, "translationY", new float[] { 0.0F, -40.0F });
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, localObject1, localObject2, localObject3 });
    long l;
    if (paramInt1 == 10) {
      l = 280L;
    } else {
      l = 240L;
    }
    localAnimatorSet.setDuration(l);
    localAnimatorSet.start();
    localObjectAnimator = ObjectAnimator.ofFloat(localObject4, "alpha", new float[] { 1.0F, 0.0F });
    if (paramInt1 == 10)
    {
      localObject3 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 1.1F, 0.0F });
      localObject2 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 1.1F, 0.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject4, "translationY", new float[] { -36.0F, 0.0F });
    }
    else
    {
      localObject3 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 1.0F, 0.0F });
      localObject2 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 1.0F, 0.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject4, "translationY", new float[] { -40.0F, 0.0F });
    }
    localObject4 = new AnimatorSet();
    ((AnimatorSet)localObject4).playTogether(new Animator[] { localObjectAnimator, localObject3, localObject2, localObject1 });
    if (paramInt1 == 10) {
      l = 200L;
    } else {
      l = 160L;
    }
    ((AnimatorSet)localObject4).setDuration(l);
    if (paramInt1 == 9) {
      l = 350L;
    } else if (paramInt1 == 10) {
      l = 520L;
    } else {
      l = 500L;
    }
    ((AnimatorSet)localObject4).setStartDelay(l);
    ((AnimatorSet)localObject4).start();
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3)
    {
      RFThreadManager.getUIHandler().post(new QCircleRocketView.4(this, paramInt1, paramInt2));
      return;
    }
    RFThreadManager.getUIHandler().postDelayed(new QCircleRocketView.5(this, paramInt1, paramInt2), 320L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.set(paramInt1);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("setCount ");
    localStringBuilder1.append(paramInt1);
    QLog.i("QCircleRocketView", 1, localStringBuilder1.toString());
    if (!b)
    {
      a.setListener(new QCircleRocketView.3(this, paramInt1, paramInt2));
      a.start();
      return;
    }
    try
    {
      d(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("playError ");
      localStringBuilder2.append(localException.getMessage());
      QLog.i("QCircleRocketView", 1, localStringBuilder2.toString());
      localException.printStackTrace();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushAnimationEvent))
    {
      paramSimpleBaseEvent = (QCirclePushAnimationEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.mTargetFeedId.equals(this.e)) && (paramSimpleBaseEvent.mPageType == this.f))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveEvent QCirclePushAnimationEvent id:");
        localStringBuilder.append(paramSimpleBaseEvent.mTargetFeedId);
        localStringBuilder.append("pageType:");
        localStringBuilder.append(this.f);
        QLog.d("QCircleRocketView", 1, localStringBuilder.toString());
        a(paramSimpleBaseEvent.mRecommendTimes, paramSimpleBaseEvent.mClickType);
      }
    }
  }
  
  public void setFeedId(String paramString)
  {
    this.e = paramString;
  }
  
  public void setPageType(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView
 * JD-Core Version:    0.7.0.1
 */