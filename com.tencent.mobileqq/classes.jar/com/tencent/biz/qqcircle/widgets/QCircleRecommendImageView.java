package com.tencent.biz.qqcircle.widgets;

import aauw;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import uwz;
import uxp;
import uxx;
import vtm;
import vxz;
import vya;
import vyb;
import vyc;
import vye;
import zvh;
import zwk;
import zwm;
import zwn;
import zwp;
import zwr;

public class QCircleRecommendImageView
  extends FrameAnimationView
  implements zwr
{
  private static Map<String, zwm> jdField_a_of_type_JavaUtilMap;
  private static zwk jdField_a_of_type_Zwk = new zwk();
  private static boolean jdField_a_of_type_Boolean;
  private static int g = 300;
  private static final int h = QzoneConfig.getQQCircleMaxPushCount();
  private static final int i = QzoneConfig.getQQCirclePushNotEnoughValue();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private QCircleRecommendImageView.LongPressTimerTask jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StPushList jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private vye jdField_a_of_type_Vye;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int f;
  private int j;
  private int k;
  private int l;
  private int m;
  
  static
  {
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip", uwz.a()));
    jdField_a_of_type_Zwk.a(new zwn("https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip", uwz.a()));
  }
  
  public QCircleRecommendImageView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    try
    {
      if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
      {
        paramString = (zwm)jdField_a_of_type_JavaUtilMap.get(paramString);
        if (paramString != null)
        {
          paramString = zvh.a(paramString.b);
          if ((paramString != null) && (paramString.length > 0))
          {
            QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
            localQQAnimationDrawable.a(paramString);
            return localQQAnimationDrawable;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e(a(), 1, "getAnimationDrawable error" + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      return "QCircleRecommend_id:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get();
    }
    return "QCircleRecommend_";
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Vye != null) {
      this.jdField_a_of_type_Vye.a(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      QLog.d(a(), 1, "fuel is use up: " + paramInt2);
      uxp.a().a(getContext(), getContext().getString(2131697132, new Object[] { Integer.valueOf(paramInt2) }));
      k();
      return;
    }
    if (paramInt1 <= i)
    {
      QLog.d(a(), 1, "fuel is not enough: " + paramInt2);
      uxp.a().a(getContext(), getContext().getString(2131697173, new Object[] { Integer.valueOf(paramInt2) }));
      return;
    }
    QLog.d(a(), 1, "fuel is enough: " + paramInt2);
    uxp.a().a(getContext(), getResources().getString(2131697248, new Object[] { Integer.valueOf(paramInt2) }));
  }
  
  private void a(String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.7(this, paramString));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Zwk.a(new vyb(this, paramBoolean));
      jdField_a_of_type_Zwk.a();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.5(this, paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      QLog.i(a(), 1, "playError " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.status.get() == 1);
  }
  
  private void b(int paramInt)
  {
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      localStFeedBusiReqData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.get().toByteArray());
      if (localStFeedBusiReqData.pushList != null) {
        if (paramInt <= 0) {
          break label119;
        }
      }
      label119:
      for (boolean bool = true;; bool = false)
      {
        b(bool);
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_b_of_type_Int = paramInt;
        QLog.d(a(), 1, "hasLikeCount" + this.jdField_a_of_type_Int);
        vtm.a(localStFeedBusiReqData.pushList, paramInt);
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList = localStFeedBusiReqData.pushList;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(a(), 1, "receiveEvent error" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      return;
    }
    d();
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.status.get() == 1);
  }
  
  private void c()
  {
    setPadding(this.j, this.k, this.l, this.m);
    try
    {
      setImageResource(2130843963);
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130843993));
        return;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130843991));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(a(), 1, "showRecommendView setBackgroundDrawable error");
    }
  }
  
  private void d()
  {
    setPadding(this.j, this.k, this.l, this.m);
    try
    {
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130843992));
        setImageResource(2130843962);
        return;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130843991));
        setImageResource(2130843961);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(a(), 1, "showUnRecommendView setBackgroundDrawable error");
    }
  }
  
  private void e()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label30;
      }
      setBackgroundDrawable(getResources().getDrawable(2130843991));
    }
    label30:
    while ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) {
      return;
    }
    setBackgroundDrawable(getResources().getDrawable(2130843993));
    setWillNotDraw(true);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning()));
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip");
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null)
      {
        QLog.d(a(), 1, "mStartAnimationDrawable is null");
        h();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b(true);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(480L);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new vxz(this));
      setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    } while (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener == null);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationStart(null);
  }
  
  private void g()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning())) {
      return;
    }
    if ((this.jdField_d_of_type_Int == 2) || (this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip");
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null)
      {
        QLog.d(a(), 1, "mStartAnimationDrawable is null");
        h();
      }
    }
    else
    {
      QLog.e(a(), 1, "showEnd error pageType" + this.jdField_d_of_type_Int);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(250L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new vya(this));
    postDelayed(new QCircleRecommendImageView.3(this), 250L);
    setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  private void h()
  {
    aauw.b(QCircleDoRecommendRequest.class.getSimpleName(), g, new vyc(this));
  }
  
  private void i()
  {
    uxp.a().a(getContext(), getContext().getResources().getString(2131697121));
  }
  
  private void j()
  {
    uxp.a().a(getContext(), getContext().getString(2131697186, new Object[] { Integer.valueOf(h) }));
  }
  
  private void k()
  {
    QCircleTaskCenterEvent localQCircleTaskCenterEvent = new QCircleTaskCenterEvent(getContext().hashCode(), true);
    zwp.a().a(localQCircleTaskCenterEvent);
  }
  
  private void l()
  {
    m();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask = new QCircleRecommendImageView.LongPressTimerTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask, g, g);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_Boolean = false;
    b(a());
  }
  
  protected void b()
  {
    this.j = getPaddingLeft();
    this.k = getPaddingTop();
    this.l = getPaddingRight();
    this.m = getPaddingBottom();
    d();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 0;
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return true;
        this.jdField_e_of_type_Int = i1;
        this.f = i2;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_b_of_type_Int >= h)
        {
          j();
          return true;
        }
        if ((a() != null) && (uxx.a((FeedCloudMeta.StUser)a().poster.get())))
        {
          i();
          return true;
        }
        l();
        return true;
      } while ((this.jdField_d_of_type_Boolean) || ((Math.abs(this.jdField_e_of_type_Int - i1) <= 20) && (Math.abs(this.f - i2) <= 20)));
      this.jdField_d_of_type_Boolean = true;
      m();
      return true;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    m();
    if ((a() != null) && (!TextUtils.isEmpty(a().id.get())) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long < g) && (this.jdField_b_of_type_Int < h))
    {
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_b_of_type_Long - this.jdField_c_of_type_Long > g) {
        n = 1;
      }
      a(true);
      if (n == 0) {
        break label327;
      }
      this.jdField_c_of_type_Int = 1;
      zwp.a().a(new QCirclePushAnimationEvent(a().id.get(), 1, 1, this.jdField_d_of_type_Int));
    }
    for (;;)
    {
      this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
      return true;
      label327:
      this.jdField_c_of_type_Int += 1;
      zwp.a().a(new QCirclePushAnimationEvent(a().id.get(), this.jdField_c_of_type_Int, 2, this.jdField_d_of_type_Int));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationStateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
    zwp.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent.mHashCode == hashCode()) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)) {
      QLog.d(a(), 1, "receive event sent by self or feed is null");
    }
    do
    {
      do
      {
        return;
        if ((paramSimpleBaseEvent instanceof QCirclePushAnimationStateEvent))
        {
          QCirclePushAnimationStateEvent localQCirclePushAnimationStateEvent = (QCirclePushAnimationStateEvent)paramSimpleBaseEvent;
          if ((localQCirclePushAnimationStateEvent.mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())) && (localQCirclePushAnimationStateEvent.mSceneType == this.jdField_d_of_type_Int))
          {
            QLog.d(a(), 1, "mTargetFeedId:" + localQCirclePushAnimationStateEvent.mTargetFeedId + "mPage" + localQCirclePushAnimationStateEvent.mSceneType);
            a(false);
          }
        }
      } while (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent));
      paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
    } while (!paramSimpleBaseEvent.mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get()));
    QLog.d(a(), 1, "updateFeedPushInfo");
    b(paramSimpleBaseEvent.mAllPushTimes);
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    boolean bool = true;
    this.jdField_d_of_type_Int = paramInt;
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = uxx.b(paramStFeed);
      localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList = localStFeedBusiReqData.pushList;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.hasClickCount.get();
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.status.get() != 1) {
          break label175;
        }
      }
      for (;;)
      {
        b(bool);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        QLog.d(a(), 1, "hashCode" + hashCode() + "feedId:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get() + "  hasClickCount" + this.jdField_a_of_type_Int);
        return;
        label175:
        bool = false;
      }
      return;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setPushAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
  
  public void setReportListener(vye paramvye)
  {
    this.jdField_a_of_type_Vye = paramvye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView
 * JD-Core Version:    0.7.0.1
 */