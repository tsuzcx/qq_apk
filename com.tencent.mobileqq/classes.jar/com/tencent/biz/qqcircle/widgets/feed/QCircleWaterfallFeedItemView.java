package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoot;
import bhtq;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import uyx;
import uzg;
import var;
import vrd;
import vtn;
import vvh;
import vwk;
import wen;

public class QCircleWaterfallFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private RoundCorneredRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private TextView b;
  private TextView c;
  
  public QCircleWaterfallFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560824;
  }
  
  public QCircleLayerBean a(int paramInt)
  {
    if ((a() == null) || (!(a() instanceof var)) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)) {
      return null;
    }
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    QCircleInitBean localQCircleInitBean = ((var)a()).a();
    QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
    if (localQCircleInitBean != null)
    {
      localStFeedListBusiReqData.tagId.set(localQCircleInitBean.getTagInfo().tagId.get());
      localStFeedListBusiReqData.tagName.set(localQCircleInitBean.getTagInfo().tagName.get());
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poiInfo.gps.has()) {
        localStFeedListBusiReqData.gpsInfo.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poiInfo.gps.get());
      }
      localStFeedListBusiReqData.simulateInfo.set(localQCircleInitBean.getSimulateData());
      localQCircleLayerBean.setSimulateData(localQCircleInitBean.getSimulateData());
    }
    localQCircleLayerBean.setFeed(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poiInfo.has()) && (a() != null) && (a().pageType == 12)) {
      localQCircleLayerBean.setPoiInfo((FeedCloudMeta.StPoiInfoV2)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poiInfo.get());
    }
    localQCircleLayerBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCircleLayerBean.setUseLoadingPic(true);
    localQCircleLayerBean.setSourceType(a().pageType);
    localQCircleLayerBean.setFromReportBean(a().clone().setElementIdStr("content"));
    return localQCircleLayerBean;
  }
  
  public Pair<Integer, Integer> a(FeedCloudMeta.StFeed paramStFeed)
  {
    float f1 = 1.333333F;
    if (paramStFeed == null) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    int i = ImmersiveUtils.a() / 2;
    if (paramStFeed.type.get() == 3)
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.width.get() >= this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.video.height.get()) {
        f1 = 0.75F;
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf((int)(f1 * i)));
    }
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 2)
    {
      float f2 = paramStFeed.cover.height.get() / paramStFeed.cover.width.get();
      if (f2 > 1.333333F) {}
      for (;;)
      {
        return new Pair(Integer.valueOf(i), Integer.valueOf((int)(f1 * i)));
        f1 = f2;
      }
    }
    return new Pair(Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public String a()
  {
    return "QCircleWaterfallFeedItemView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370185));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)paramView.findViewById(2131376962));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131380386));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379990));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131380141));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377770));
    this.b = ((TextView)paramView.findViewById(2131380177));
    this.c = ((TextView)paramView.findViewById(2131379859));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369228));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376895));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(this);
    int i = bhtq.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundCorneredRelativeLayout.setRadius(i, i, i, i);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)paramObject);
    label44:
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      String str = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.cover.picUrl.get();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846618);
      localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844021);
      paramObject = a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      Pair localPair = vwk.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.cover.width.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.cover.height.get());
      if ((((Integer)paramObject.first).intValue() == 0) || (((Integer)paramObject.second).intValue() == 0) || (((Integer)localPair.first).intValue() == 0) || (((Integer)localPair.second).intValue() == 0)) {
        break label706;
      }
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      localLayoutParams.width = ((Integer)paramObject.first).intValue();
      localLayoutParams.height = ((Integer)paramObject.second).intValue();
      this.jdField_a_of_type_ComTencentImageURLImageView.requestLayout();
      localURLDrawableOptions.mRequestWidth = ((Integer)localPair.first).intValue();
      localURLDrawableOptions.mRequestHeight = ((Integer)localPair.second).intValue();
      QLog.i("QCircleWaterfallFeedItemView", 1, "mCover  measureCoverWidthAndHeight  params.width : " + paramObject.first + " , params.height : " + paramObject.second + " , requestResult.width:" + localPair.first + " , requestResult.height:" + localPair.second);
      label344:
      paramObject = "";
      if ((this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131380386) instanceof String)) {
        paramObject = (String)this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131380386);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131380386, str);
      if (!paramObject.equals(str))
      {
        paramObject = new vrd().a(str).a(this.jdField_a_of_type_ComTencentImageURLImageView).b(false).a(true).c(localURLDrawableOptions.mRequestWidth).b(localURLDrawableOptions.mRequestHeight);
        QCircleFeedPicLoader.a().a(paramObject, new wen(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(aoot.a(((BaseActivity)getContext()).app, 1, 4, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()));
      if (TextUtils.isEmpty(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.content.get())) {
        break label803;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.content.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      label532:
      this.b.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.nick.get());
      paramObject = new QQCircleFeedBase.StFeedBusiReqData();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.busiData.get().toByteArray());
        if (!paramObject.pushList.has()) {
          break;
        }
        long l = paramObject.pushList.totalClickCount.get();
        this.c.setText(uzg.d(l));
        paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (l > 0L) {
          break label844;
        }
        paramInt = 8;
        paramObject.setVisibility(paramInt);
        paramObject = this.c;
        if (l > 0L) {
          break label849;
        }
        paramInt = 8;
        paramObject.setVisibility(paramInt);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get() != 2) {
        break label44;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.images.get().size()));
      break label44;
      label706:
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams() == null) {
        break label344;
      }
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      QLog.i("QCircleWaterfallFeedItemView", 1, "mCover width : " + this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width + " , height : " + this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height);
      break label344;
      label803:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(8);
      paramObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramObject.topMargin = ImmersiveUtils.a(10.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramObject);
      break label532;
      label844:
      paramInt = 0;
      continue;
      label849:
      paramInt = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
      {
        Object localObject = new QCircleInitBean();
        ((QCircleInitBean)localObject).setUin(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get());
        ((QCircleInitBean)localObject).setFromReportBean(a());
        uyx.b(getContext(), (QCircleInitBean)localObject);
        continue;
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
        {
          localObject = a(this.jdField_a_of_type_Int);
          vvh.a(this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentImageURLImageView.getWidth(), this.jdField_a_of_type_ComTencentImageURLImageView.getHeight(), (QCircleLayerBean)localObject);
          uyx.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), (QCircleLayerBean)localObject);
          vtn.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int, 97, d());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView
 * JD-Core Version:    0.7.0.1
 */