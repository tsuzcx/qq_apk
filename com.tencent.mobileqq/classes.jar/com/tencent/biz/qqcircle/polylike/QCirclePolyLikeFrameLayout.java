package com.tencent.biz.qqcircle.polylike;

import aaak;
import aaam;
import aabg;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bdep;
import beyq;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import uys;
import vrx;
import vry;
import vsd;

public class QCirclePolyLikeFrameLayout
  extends FrameLayout
  implements aaam, aabg<QCircleReportBean>, View.OnClickListener
{
  private int jdField_a_of_type_Int = 2130844012;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private String jdField_a_of_type_JavaLangString;
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private QQCircleFeedBase.StPolyLike jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  private vrx jdField_a_of_type_Vrx;
  private vsd jdField_a_of_type_Vsd;
  private boolean jdField_a_of_type_Boolean;
  private int b = 2130844013;
  
  public QCirclePolyLikeFrameLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private String a()
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "commentlist_like")) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return "like";
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (paramStPolyLike != null) && (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get().equals(paramStPolyLike.polyLikeID.get())))
    {
      localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      localStLikeBusiData.curPolyLikeInfo.set(paramStPolyLike);
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.busiData.get().toByteArray());
      localStLikeBusiData.polyLikeInfo.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get());
      if ((paramStPolyLike.articleType.get() == 1) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.rewardstatus.get() == 1)) {
        localStLikeBusiData.rewardstatus.set(1);
      }
      if (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.likeIDs.get().contains(paramStPolyLike.polyLikeID.get())) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.likeIDs.get().add(paramStPolyLike.polyLikeID.get());
      }
      localStLikeBusiData.likeIDs.addAll(new ArrayList(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.likeIDs.get()));
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(localStLikeBusiData.toByteArray()));
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike = paramStPolyLike;
      if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get())))
      {
        paramStPolyLike = URLDrawable.URLDrawableOptions.obtain();
        paramStPolyLike.mLoadingDrawable = beyq.a;
        paramStPolyLike.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
        paramStPolyLike.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
        uys.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyIconUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, paramStPolyLike, false);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(this.b);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(this.jdField_a_of_type_Int);
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560772, this, true);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373997));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131374015));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131374023));
      setOnClickListener(this);
      this.jdField_a_of_type_Vsd = new vsd((Activity)getContext());
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCirclePolyLikeFrameLayout", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(a());
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean("QCirclePolyLikeFrameLayout", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean()).clone().setModuleIdStr(a());
    }
    return new QCircleReportBean();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = vry.a().a();
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Vsd.isShowing());
      this.jdField_a_of_type_Vsd.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      this.jdField_a_of_type_Vsd.a(a());
      this.jdField_a_of_type_Vsd.a();
    } while (this.jdField_a_of_type_Vrx == null);
    this.jdField_a_of_type_Vrx.a();
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    aaak.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePolyLikeFrameLayout.1(this, paramSimpleBaseEvent));
  }
  
  public void setAniView(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = paramQCirclePolyLikeAniView;
  }
  
  public void setExtraTypeInfo(ReportExtraTypeInfo paramReportExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.likeInfo.get() != null)) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    }
    try
    {
      paramStFeed = (FeedCloudMeta.StLike)paramStFeed.likeInfo.get();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(this.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.curPolyLikeInfo);
      return;
    }
    catch (Exception paramStFeed) {}
  }
  
  public void setIsContentDetail(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = bdep.a(46.0F);
      j = bdep.a(24.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843974);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(this.jdField_a_of_type_Int);
      return;
      i = bdep.a(46.0F);
      j = bdep.a(24.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
  }
  
  public void setModuleIdStr(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnClickHookListener(vrx paramvrx)
  {
    this.jdField_a_of_type_Vrx = paramvrx;
    if (this.jdField_a_of_type_Vsd != null) {
      this.jdField_a_of_type_Vsd.a(paramvrx);
    }
  }
  
  public void setPraisedDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean("QCirclePolyLikeFrameLayout", paramQCircleReportBean);
    if (this.jdField_a_of_type_Vsd != null) {
      this.jdField_a_of_type_Vsd.a(this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
  }
  
  public void setReportBeanAgent(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
    if (this.jdField_a_of_type_Vsd != null) {
      this.jdField_a_of_type_Vsd.a(paramaabg);
    }
  }
  
  public void setUnPraiseDrawable(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout
 * JD-Core Version:    0.7.0.1
 */