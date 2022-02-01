package com.tencent.biz.qqcircle.widgets;

import aace;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;
import vae;
import vtn;
import wcf;
import wcg;

public class QCircleTagRecommendWidget
  extends QCircleBaseWidgetView
{
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private vae jdField_a_of_type_Vae;
  
  public QCircleTagRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560814;
  }
  
  protected String a()
  {
    return "QCircleTagPageRecommendWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373291));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373292));
      wcf localwcf = new wcf(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localwcf);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localwcf);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373289));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new aace(paramContext, 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Vae = new wcg(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vae);
      this.jdField_a_of_type_Vae.a(this);
      this.jdField_a_of_type_Vae.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    }
  }
  
  @Deprecated
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    FeedCloudMeta.StDittoFeed localStDittoFeed;
    if (((paramObject instanceof FeedCloudMeta.StFeed)) && ((this.jdField_a_of_type_Vae instanceof wcg)))
    {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
      localStDittoFeed = (FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get();
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = paramInt;
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer = new QQCircleDitto.StItemContainer();
      paramObject = new wcg(this);
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.mergeFrom(localStDittoFeed.dittoData.get().toByteArray());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeAllViews();
      paramObject.a(this);
      paramObject.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      paramObject.a(localStFeed, paramInt, this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.get());
      paramObject.a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer);
      this.jdField_a_of_type_Vae = paramObject;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vae);
      vtn.a(localStFeed.id.get(), 3, 3, 97, 1, 1, localStFeed.id.get(), "", "", 0, localStFeed, null, d(), -1);
      QLog.d("QCircleTagPageRecommendWidget", 1, new Object[] { "bind dittoFeed pos:", Integer.valueOf(paramInt), ",item size:", Integer.valueOf(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.size()) });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("QCircleTagPageRecommendWidget", 1, new Object[] { "bindData Exception:", paramObject.toString() });
    }
  }
  
  protected String b()
  {
    return "tag_page_container";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget
 * JD-Core Version:    0.7.0.1
 */