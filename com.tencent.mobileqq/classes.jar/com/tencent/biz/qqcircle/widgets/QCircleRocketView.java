package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bggq;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import uwz;
import vyl;
import vym;
import vyn;
import vyo;
import zvh;
import zwk;
import zwm;
import zwn;
import zwp;
import zwr;

public class QCircleRocketView
  extends FrameLayout
  implements zwr
{
  private static Map<String, zwm> jdField_a_of_type_JavaUtilMap;
  private static zwk jdField_a_of_type_Zwk = new zwk();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private String jdField_a_of_type_JavaLangString;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AnimationSet c;
  
  static
  {
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/rocket1.zip", uwz.a()));
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/rocket2.zip", uwz.a()));
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/rocket3.zip", uwz.a()));
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/single_rocket.zip", uwz.a()));
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
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setGravity(1);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bggq.a(getContext(), 115.0F), -2);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = bggq.a(getContext(), 50.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    LayoutInflater.from(getContext()).inflate(2131560756, localLinearLayout);
    return localLinearLayout;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    bringToFront();
  }
  
  private void a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      zwp.a().a(new QCirclePushAnimationStateEvent(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int));
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    setVisibility(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    int i = paramInt1 % 3;
    Object localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/single_rocket.zip";
    if (paramInt2 == 1) {
      localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/single_rocket.zip";
    }
    for (;;)
    {
      if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(localObject1))) {}
      try
      {
        localObject1 = (zwm)jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 == null)
        {
          return;
          if (i == 0) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket1.zip";
          } else if (i == 1) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket2.zip";
          } else if (i == 2) {
            localObject1 = "https://downv6.qq.com/video_story/qcircle/animation/rocket3.zip";
          }
        }
        else
        {
          Object localObject2 = zvh.a(((zwm)localObject1).b);
          localObject1 = new QQAnimationDrawable();
          ((QQAnimationDrawable)localObject1).a((String[])localObject2);
          localObject2 = new FrameAnimationView(getContext());
          ((FrameAnimationView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(bggq.a(getContext(), 115.0F), bggq.a(getContext(), 210.0F)));
          ((FrameAnimationView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((QQAnimationDrawable)localObject1).b(true);
          ((QQAnimationDrawable)localObject1).a(1000L);
          QLog.i("QQAnimationDrawable", 1, "hashCode" + localObject1.hashCode() + " count" + paramInt1);
          ((QQAnimationDrawable)localObject1).a(new vyl(this, Double.valueOf(((QQAnimationDrawable)localObject1).a() * 0.6D).intValue(), paramInt1, paramInt2));
          ((FrameAnimationView)localObject2).setImageDrawable((Drawable)localObject1);
          addView((View)localObject2);
          ((QQAnimationDrawable)localObject1).start();
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QCircleRocketView.2(this, (FrameAnimationView)localObject2, (QQAnimationDrawable)localObject1, paramInt1), 1000L);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("QCircleRecommend_", 1, "startRockeyAnimation error" + localException.getMessage());
        a(paramInt1);
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = a();
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, -bggq.a(getContext(), 15.0F));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new vym(this, localLinearLayout));
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, bggq.a(getContext(), 15.0F));
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setStartOffset(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new vyn(this, localLinearLayout));
    this.c = new AnimationSet(true);
    this.c.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.c.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
    this.c.setFillAfter(true);
    localObject = (TextView)localLinearLayout.findViewById(2131379854);
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(paramInt1));
    }
    localLinearLayout.setVisibility(4);
    addView(localLinearLayout);
    localLinearLayout.startAnimation(this.c);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QCircleRocketView.5(this, localLinearLayout), 1500L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    QLog.i("QCircleRecommend_", 1, "setCount " + paramInt1);
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Zwk.a(new vyo(this, paramInt1, paramInt2));
      jdField_a_of_type_Zwk.a();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRocketView.7(this, paramInt1, paramInt2));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("QCircleRecommend_", 1, "playError " + localException.getMessage());
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
    zwp.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushAnimationEvent))
    {
      paramSimpleBaseEvent = (QCirclePushAnimationEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.mTargetFeedId.equals(this.jdField_a_of_type_JavaLangString)) && (paramSimpleBaseEvent.mPageType == this.jdField_a_of_type_Int))
      {
        QLog.d("QCircleRecommend_", 1, "onReceiveEvent QCirclePushAnimationEvent id:" + paramSimpleBaseEvent.mTargetFeedId + "pageType:" + this.jdField_a_of_type_Int);
        a(paramSimpleBaseEvent.mRecommendTimes, paramSimpleBaseEvent.mClickType);
      }
    }
  }
  
  public void setFeedId(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setPageType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView
 * JD-Core Version:    0.7.0.1
 */