package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import azkz;
import bayu;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import tqg;
import tql;
import uej;
import yiw;
import yiy;

public class QCirclePolyParseFrameLayout
  extends FrameLayout
  implements View.OnClickListener, yiy
{
  private int jdField_a_of_type_Int = 2130843582;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCirclePolymorphicLikePopWindow jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private QQCircleFeedBase.StPolyLike jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  private uej jdField_a_of_type_Uej;
  private boolean jdField_a_of_type_Boolean;
  private int b = 2130843591;
  
  public QCirclePolyParseFrameLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCirclePolyParseFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCirclePolyParseFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560574, this, true);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373207));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131373221));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373224));
      setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow = new QCirclePolymorphicLikePopWindow((Activity)getContext());
    }
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
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(localStLikeBusiData.toByteArray()));
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike = paramStPolyLike;
      if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get())))
      {
        paramStPolyLike = URLDrawable.URLDrawableOptions.obtain();
        paramStPolyLike.mLoadingDrawable = bayu.a;
        paramStPolyLike.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth();
        paramStPolyLike.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
        tql.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyIconUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, paramStPolyLike, false);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = tqg.a();
    if (!this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.isShowing())
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a();
      if (this.jdField_a_of_type_Uej != null) {
        this.jdField_a_of_type_Uej.a(paramBoolean);
      }
    }
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
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get())))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike);
      return;
    }
    a(true);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePolyParseFrameLayout.1(this, paramSimpleBaseEvent));
  }
  
  public void setAniView(QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(this.b));
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
      i = azkz.a(30.0F);
      j = azkz.a(19.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(this.b));
      return;
      i = azkz.a(45.0F);
      j = azkz.a(19.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().width = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
  }
  
  public void setOnClickHookListener(uej paramuej)
  {
    this.jdField_a_of_type_Uej = paramuej;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(paramuej);
    }
  }
  
  public void setPraisedDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setUnPraiseDrawable(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolyParseFrameLayout
 * JD-Core Version:    0.7.0.1
 */