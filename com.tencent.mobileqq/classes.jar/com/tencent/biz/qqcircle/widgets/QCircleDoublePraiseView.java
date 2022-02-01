package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleDoublePraiseAnimationEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import uxx;
import vrc;
import vrg;
import vvy;
import zwp;
import zwr;
import zxl;

public class QCircleDoublePraiseView
  extends FrameLayout
  implements zwr, zxl<QCircleReportBean>
{
  private int jdField_a_of_type_Int;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public QCircleDoublePraiseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleDoublePraiseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131560794, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373789));
  }
  
  private boolean a()
  {
    return QCircleReportBean.isContentDetailPage(b());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("QCircleDoublePraiseView", 1, "mIsInAnimation");
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772212));
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new vvy(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    c();
    d();
  }
  
  private void c()
  {
    uxx.a(getContext(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, a());
  }
  
  private void d()
  {
    if (a()) {
      vrg.a(69, 2, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, 2, this.b, a());
    }
    while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) {
      return;
    }
    vrc.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), 69, 2, this.b, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, b());
  }
  
  protected int a()
  {
    return QCircleReportBean.getParentPageId("QCircleDoublePraiseView", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean("QCircleDoublePraiseView", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected int b()
  {
    return QCircleReportBean.getPageId("QCircleDoublePraiseView", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleDoublePraiseAnimationEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
    QLog.d("QCircleDoublePraiseView", 1, "registerReceiver");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
    QLog.d("QCircleDoublePraiseView", 1, "unRegisterReceiver");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleDoublePraiseAnimationEvent))
    {
      paramSimpleBaseEvent = (QCircleDoublePraiseAnimationEvent)paramSimpleBaseEvent;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (paramSimpleBaseEvent.mTargetFeedId.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())) && (paramSimpleBaseEvent.mPageType == this.jdField_a_of_type_Int))
      {
        this.b = paramSimpleBaseEvent.mFeedPos;
        b();
        QLog.d("QCircleDoublePraiseView", 1, "ReceiveEvent cur id:" + this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get() + " pageType:" + this.jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    QLog.d("QCircleDoublePraiseView", 1, "id or pagetype not right");
  }
  
  public void setFeed(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCircleDoublePraiseView", paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView
 * JD-Core Version:    0.7.0.1
 */