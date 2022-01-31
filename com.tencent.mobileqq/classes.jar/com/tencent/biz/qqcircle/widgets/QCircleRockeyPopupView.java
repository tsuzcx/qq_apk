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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdaq;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import tvz;
import twb;
import twc;
import ufo;
import ufp;
import ufq;
import ufr;
import yiw;
import yiy;
import yld;

public class QCircleRockeyPopupView
  extends FrameLayout
  implements yiy
{
  private static Map<String, twb> jdField_a_of_type_JavaUtilMap;
  private static tvz jdField_a_of_type_Tvz = new tvz();
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
    jdField_a_of_type_Tvz.a(new twc("https://down.qq.com/video_story/qcircle/animation/rockey1.zip"));
    jdField_a_of_type_Tvz.a(new twc("https://down.qq.com/video_story/qcircle/animation/rockey2.zip"));
    jdField_a_of_type_Tvz.a(new twc("https://down.qq.com/video_story/qcircle/animation/rockey3.zip"));
    jdField_a_of_type_Tvz.a(new twc("https://down.qq.com/video_story/qcircle/animation/rockey_single_click.zip"));
  }
  
  public QCircleRockeyPopupView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleRockeyPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleRockeyPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setGravity(1);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bdaq.a(getContext(), 115.0F), -2);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = bdaq.a(getContext(), 50.0F);
    localLinearLayout.setLayoutParams(localLayoutParams);
    LayoutInflater.from(getContext()).inflate(2131560579, localLinearLayout);
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
      yiw.a().a(new QCirclePushAnimationStateEvent(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Int));
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    setVisibility(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    int i = paramInt1 % 3;
    Object localObject1 = "https://down.qq.com/video_story/qcircle/animation/rockey_single_click.zip";
    if (paramInt2 == 1) {
      localObject1 = "https://down.qq.com/video_story/qcircle/animation/rockey_single_click.zip";
    }
    for (;;)
    {
      if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(localObject1))) {}
      try
      {
        localObject1 = (twb)jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 == null)
        {
          return;
          if (i == 0) {
            localObject1 = "https://down.qq.com/video_story/qcircle/animation/rockey1.zip";
          } else if (i == 1) {
            localObject1 = "https://down.qq.com/video_story/qcircle/animation/rockey2.zip";
          } else if (i == 2) {
            localObject1 = "https://down.qq.com/video_story/qcircle/animation/rockey3.zip";
          }
        }
        else
        {
          Object localObject2 = yld.a(((twb)localObject1).b);
          localObject1 = new QQAnimationDrawable();
          ((QQAnimationDrawable)localObject1).a((String[])localObject2);
          localObject2 = new ImageView(getContext());
          ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(bdaq.a(getContext(), 115.0F), bdaq.a(getContext(), 210.0F)));
          ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
          ((QQAnimationDrawable)localObject1).a(true);
          ((QQAnimationDrawable)localObject1).a(1000L);
          QLog.i("QQAnimationDrawable", 1, "hashCode" + localObject1.hashCode() + " count" + paramInt1);
          ((QQAnimationDrawable)localObject1).a(new ufo(this, paramInt1, Double.valueOf(((QQAnimationDrawable)localObject1).a() * 0.6D).intValue(), paramInt2));
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          addView((View)localObject2);
          ((QQAnimationDrawable)localObject1).start();
          ((ImageView)localObject2).postDelayed(new QCircleRockeyPopupView.2(this, (ImageView)localObject2, (QQAnimationDrawable)localObject1, paramInt1), 1000L);
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
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, -bdaq.a(getContext(), 15.0F));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new ufp(this, localLinearLayout));
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, bdaq.a(getContext(), 15.0F));
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setStartOffset(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new ufq(this, localLinearLayout));
    this.c = new AnimationSet(true);
    this.c.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    this.c.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
    this.c.setFillAfter(true);
    localObject = (TextView)localLinearLayout.findViewById(2131378960);
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(paramInt1));
    }
    localLinearLayout.setVisibility(4);
    addView(localLinearLayout);
    localLinearLayout.startAnimation(this.c);
    localLinearLayout.postDelayed(new QCircleRockeyPopupView.5(this, localLinearLayout), 1500L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    QLog.i("QCircleRecommend_", 1, "setCount " + paramInt1);
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Tvz.a(new ufr(this, paramInt1, paramInt2));
      jdField_a_of_type_Tvz.a();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRockeyPopupView.7(this, paramInt1, paramInt2));
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
    yiw.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView
 * JD-Core Version:    0.7.0.1
 */