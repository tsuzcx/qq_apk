package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import uyx;
import uzg;
import var;
import vrd;
import vtn;
import vtq;
import vvh;
import wed;
import zzk;

public class QCircleGridFeedItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener, zzk
{
  public static final int a;
  public static final int b = (int)(ImmersiveUtils.a() * 0.3D) * 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private Object jdField_a_of_type_JavaLangObject;
  private int e;
  
  static
  {
    jdField_a_of_type_Int = (int)(ImmersiveUtils.a() * 1.0F / 3.0F);
  }
  
  public QCircleGridFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void d()
  {
    FeedCloudMeta.StFeed localStFeed;
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      if (localStFeed.type.get() == 3)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if (localStFeed.type.get() == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (localStFeed.images.size() > 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localStFeed.images.size()));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public int a()
  {
    return 2131560723;
  }
  
  public String a()
  {
    return "QCircleGridFeedItemView";
  }
  
  public void a() {}
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369215));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369206));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379819));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.e = paramInt;
    if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null))
    {
      paramObject = (FeedCloudMeta.StFeed)paramObject;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).width = jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = paramObject.cover.picUrl.get();
      paramObject = URLDrawable.URLDrawableOptions.obtain();
      paramObject.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843943);
      paramObject.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844021);
      paramObject = "";
      if ((getTag(2131373990) instanceof String)) {
        paramObject = (String)getTag(2131373990);
      }
      setTag(2131373990, localObject);
      if (!paramObject.equals(localObject))
      {
        paramObject = new vrd().a((String)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView).b(false).a(true).c(b).b(b);
        QCircleFeedPicLoader.a().a(paramObject, new wed(this, paramInt));
      }
      d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    d();
  }
  
  public void c() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2 = uzg.a(getContext());
      if (uzg.a(getContext())) {}
      for (Object localObject1 = "1";; localObject1 = "2")
      {
        vtq.a((String)localObject2, 11, 19, 5, (String)localObject1, "", "", "", "");
        if ((a() == null) || (!(a() instanceof var)) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))) {
          break;
        }
        localObject1 = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
        if (!QCircleFakeAdapter.a(localObject1)) {
          break label155;
        }
        QQToast.a(getContext(), 0, 2131697318, 0).a();
        break;
      }
      label155:
      Object localObject3 = (var)a();
      localObject2 = new QQCircleFeedBase.StFeedListBusiReqData();
      ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tabAttachInfo.set(((var)localObject3).a());
      localObject3 = ((var)localObject3).a();
      if (localObject3 != null)
      {
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tagId.set(((QCircleInitBean)localObject3).getTagInfo().tagId.get());
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject2).tagName.set(((QCircleInitBean)localObject3).getTagInfo().tagName.get());
      }
      localObject3 = new QCircleLayerBean();
      ((QCircleLayerBean)localObject3).setFeed((FeedCloudMeta.StFeed)localObject1);
      ((QCircleLayerBean)localObject3).setSourceType(a().pageType);
      ((QCircleLayerBean)localObject3).setFeedListBusiReqData((QQCircleFeedBase.StFeedListBusiReqData)localObject2);
      ((QCircleLayerBean)localObject3).setDataPosInList(0);
      ((QCircleLayerBean)localObject3).setFromReportBean(a().clone().setElementIdStr("content"));
      vvh.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getHeight(), (QCircleLayerBean)localObject3);
      uyx.a(getContext(), (QCircleLayerBean)localObject3);
      localObject2 = new ReportExtraTypeInfo();
      ((ReportExtraTypeInfo)localObject2).mFeed = ((FeedCloudMeta.StFeed)localObject1);
      ((ReportExtraTypeInfo)localObject2).mPlayScene = 1;
      vtn.a(7, 2, (ExtraTypeInfo)localObject2, d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView
 * JD-Core Version:    0.7.0.1
 */