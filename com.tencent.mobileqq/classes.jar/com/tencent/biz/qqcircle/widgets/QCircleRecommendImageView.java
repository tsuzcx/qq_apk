package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
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
import tqt;
import tra;
import tvo;
import tvq;
import tvr;
import ucg;
import uch;
import uci;
import ucj;
import ucl;
import yej;
import yel;
import ygq;
import yte;

public class QCircleRecommendImageView
  extends ImageView
  implements yel
{
  private static Map<String, tvq> jdField_a_of_type_JavaUtilMap;
  private static tvo jdField_a_of_type_Tvo = new tvo();
  private static boolean jdField_a_of_type_Boolean;
  private static int g = 300;
  private static final int h = QzoneConfig.getQQCircleMaxPushCount();
  private static final int i = QzoneConfig.getQQCirclePushNotEnoughValue();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QCircleRecommendImageView.LongPressTimerTask jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StPushList jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private ucl jdField_a_of_type_Ucl;
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
  
  static
  {
    jdField_a_of_type_Tvo.a(new tvr("https://down.qq.com/video_story/qcircle/animation/icon_start_recommend.zip"));
    jdField_a_of_type_Tvo.a(new tvr("https://down.qq.com/video_story/qcircle/animation/icon_end_recommend.zip"));
    jdField_a_of_type_Tvo.a(new tvr("https://down.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip"));
  }
  
  public QCircleRecommendImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    try
    {
      if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(paramString)))
      {
        paramString = (tvq)jdField_a_of_type_JavaUtilMap.get(paramString);
        if (paramString != null)
        {
          paramString = ygq.a(paramString.b);
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
      QLog.e("QCircleRecommend", 1, "getAnimationDrawable error" + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ucl != null) {
      this.jdField_a_of_type_Ucl.a(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      QLog.d("QCircleRecommend", 1, "fuel is use up: " + paramInt2);
      tqt.a().a(getContext(), getContext().getString(2131698284, new Object[] { Integer.valueOf(paramInt2) }));
      j();
      return;
    }
    if (paramInt1 <= i)
    {
      QLog.d("QCircleRecommend", 1, "fuel is not enough: " + paramInt2);
      tqt.a().a(getContext(), getContext().getString(2131698320, new Object[] { Integer.valueOf(paramInt2) }));
      return;
    }
    QLog.d("QCircleRecommend", 1, "fuel is enough: " + paramInt2);
    tqt.a().a(getContext(), getResources().getString(2131698362, new Object[] { Integer.valueOf(paramInt2) }));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Tvo.a(new uci(this, paramBoolean));
      jdField_a_of_type_Tvo.a();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.5(this, paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("QCircleRecommend", 1, "playError " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  private void b()
  {
    try
    {
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130843572));
        return;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130843557));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend", 1, "showRecommendView setBackgroundDrawable error");
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      return;
    }
    c();
  }
  
  private void c()
  {
    try
    {
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130843571));
        return;
      }
      if (this.jdField_d_of_type_Int == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130843556));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend", 1, "showUnRecommendView setBackgroundDrawable error");
    }
  }
  
  private void d()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label30;
      }
      setBackgroundDrawable(getResources().getDrawable(2130843548));
    }
    label30:
    while ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) {
      return;
    }
    setBackgroundDrawable(getResources().getDrawable(2130843565));
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://down.qq.com/video_story/qcircle/animation/icon_start_recommend.zip");
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(480L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new ucg(this));
    setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  private void f()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning())) {
      return;
    }
    if (this.jdField_d_of_type_Int == 2) {}
    for (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://down.qq.com/video_story/qcircle/animation/icon_end_recommend.zip");; this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://down.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip"))
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(true);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(250L);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new uch(this));
      postDelayed(new QCircleRecommendImageView.3(this), 250L);
      setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
      return;
      if ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3)) {
        break;
      }
    }
    QLog.e("QCircleRecommend", 1, "showEnd error pageType" + this.jdField_d_of_type_Int);
  }
  
  private void g()
  {
    yte.b(QCircleDoRecommendRequest.class.getSimpleName(), g, new ucj(this));
  }
  
  private void h()
  {
    tqt.a().a(getContext(), getContext().getResources().getString(2131698275));
  }
  
  private void i()
  {
    tqt.a().a(getContext(), getContext().getString(2131698332, new Object[] { Integer.valueOf(h) }));
  }
  
  private void j()
  {
    QCircleTaskCenterEvent localQCircleTaskCenterEvent = new QCircleTaskCenterEvent(getContext().hashCode(), true);
    yej.a().a(localQCircleTaskCenterEvent);
  }
  
  private void k()
  {
    l();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask = new QCircleRecommendImageView.LongPressTimerTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask, g, g);
  }
  
  private void l()
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationStateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  protected void a()
  {
    c();
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent.mHashCode == hashCode()) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)) {
      QLog.d("QCircleRecommend", 1, "receive event sent by self or feed is null");
    }
    for (;;)
    {
      return;
      Object localObject;
      if ((paramSimpleBaseEvent instanceof QCirclePushAnimationStateEvent))
      {
        localObject = (QCirclePushAnimationStateEvent)paramSimpleBaseEvent;
        QLog.d("QCircleRecommend", 1, "mTargetFeedId:" + ((QCirclePushAnimationStateEvent)localObject).mTargetFeedId + "mPage" + ((QCirclePushAnimationStateEvent)localObject).mSceneType);
        if ((((QCirclePushAnimationStateEvent)localObject).mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())) && (((QCirclePushAnimationStateEvent)localObject).mSceneType == this.jdField_d_of_type_Int)) {
          a(false);
        }
      }
      if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
      {
        paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
        if (paramSimpleBaseEvent.mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())) {
          localObject = new QQCircleFeedBase.StFeedBusiReqData();
        }
      }
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList != null)
        {
          if (paramSimpleBaseEvent.mAllPushTimes <= 0) {
            break label280;
          }
          bool = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramSimpleBaseEvent)
      {
        for (;;)
        {
          paramSimpleBaseEvent.printStackTrace();
          return;
          boolean bool = false;
        }
      }
      catch (Exception paramSimpleBaseEvent)
      {
        QLog.e("QCircleRecommend", 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
    }
    b(bool);
    this.jdField_a_of_type_Int = paramSimpleBaseEvent.mAllPushTimes;
    this.jdField_b_of_type_Int = paramSimpleBaseEvent.mAllPushTimes;
    QLog.d("QCircleRecommend", 1, "hasLikeCount" + this.jdField_a_of_type_Int);
    ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList.hasClickCount.set(paramSimpleBaseEvent.mAllPushTimes);
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StFeedBusiReqData)localObject).toByteArray()));
    return;
    label280:
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.jdField_e_of_type_Int = j;
        this.f = k;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_b_of_type_Int >= h)
        {
          i();
          return false;
        }
        if ((a() != null) && (tra.a((FeedCloudMeta.StUser)a().poster.get())))
        {
          h();
          return false;
        }
        k();
        continue;
        if ((!this.jdField_d_of_type_Boolean) && ((Math.abs(this.jdField_e_of_type_Int - j) > 20) || (Math.abs(this.f - k) > 20)))
        {
          this.jdField_d_of_type_Boolean = true;
          l();
        }
      }
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    l();
    if ((a() != null) && (!TextUtils.isEmpty(a().id.get())) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long < g) && (this.jdField_b_of_type_Int < h))
    {
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_b_of_type_Long - this.jdField_c_of_type_Long <= g) {
        break label328;
      }
      j = 1;
      label269:
      a(true);
      if (j == 0) {
        break label333;
      }
      this.jdField_c_of_type_Int = 1;
      yej.a().a(new QCirclePushAnimationEvent(a().id.get(), 1, 1, this.jdField_d_of_type_Int));
    }
    for (;;)
    {
      this.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_c_of_type_Boolean = true;
      break;
      label328:
      j = 0;
      break label269;
      label333:
      this.jdField_c_of_type_Int += 1;
      yej.a().a(new QCirclePushAnimationEvent(a().id.get(), this.jdField_c_of_type_Int, 2, this.jdField_d_of_type_Int));
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    boolean bool = true;
    this.jdField_d_of_type_Int = paramInt;
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList = localStFeedBusiReqData.pushList;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList != null) {
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.status.get() != 1) {
          break label170;
        }
      }
      for (;;)
      {
        b(bool);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.hasClickCount.get();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        QLog.d("QCircleRecommend", 1, "hashCode" + hashCode() + "feedId:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get() + "  hasClickCount" + this.jdField_a_of_type_Int);
        return;
        label170:
        bool = false;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setReportListener(ucl paramucl)
  {
    this.jdField_a_of_type_Ucl = paramucl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView
 * JD-Core Version:    0.7.0.1
 */