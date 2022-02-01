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
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;
import vae;
import wax;
import way;

public class QCirclePYMKRecommendWidget
  extends QCircleBaseWidgetView
{
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private vae jdField_a_of_type_Vae;
  
  public QCirclePYMKRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560720;
  }
  
  protected String a()
  {
    return "QCircleRecommendWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373275));
      wax localwax = new wax(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localwax);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373260));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localwax);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373273));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new aace(paramContext, 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Vae = new way(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vae);
      this.jdField_a_of_type_Vae.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Vae.a(this);
    }
  }
  
  @Deprecated
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    FeedCloudMeta.StDittoFeed localStDittoFeed;
    if (((paramObject instanceof FeedCloudMeta.StFeed)) && ((this.jdField_a_of_type_Vae instanceof way)))
    {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
      localStDittoFeed = ((FeedCloudMeta.StFeed)localStFeed.get()).dittoFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = paramInt;
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer = new QQCircleDitto.StItemContainer();
      paramObject = new way(this);
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.mergeFrom(localStDittoFeed.dittoData.get().toByteArray());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeAllViews();
      paramObject.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      paramObject.a(this);
      paramObject.a(localStFeed, paramInt, this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.get(), this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.styleType.get());
      paramObject.a(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer);
      this.jdField_a_of_type_Vae = paramObject;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vae);
      QLog.d("QCircleRecommendWidget", 4, "style:" + this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.styleType.get());
      QLog.d("QCircleRecommendWidget", 1, new Object[] { "bind dittoFeed pos:", Integer.valueOf(paramInt), ",item size:", Integer.valueOf(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.size()) });
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("QCircleRecommendWidget", 1, new Object[] { "bindData Exception:", paramObject.toString() });
    }
  }
  
  protected String b()
  {
    return "pymk_container";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePYMKRecommendWidget
 * JD-Core Version:    0.7.0.1
 */