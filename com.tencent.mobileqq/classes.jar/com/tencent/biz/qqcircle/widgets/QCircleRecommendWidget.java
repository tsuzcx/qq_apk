package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;
import ucm;
import ucn;
import uco;

public class QCircleRecommendWidget
  extends BaseWidgetView
{
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private uco jdField_a_of_type_Uco;
  
  public QCircleRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560543;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372526));
      ucm localucm = new ucm(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localucm);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372514));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localucm);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131372524));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new LinearLayoutManager(paramContext, 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Uco = new uco();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uco);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new ucn(this));
    }
  }
  
  @Deprecated
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    FeedCloudMeta.StDittoFeed localStDittoFeed;
    if (((paramObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Uco != null))
    {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
      localStDittoFeed = ((FeedCloudMeta.StFeed)localStFeed.get()).dittoFeed;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = paramInt;
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer = new QQCircleDitto.StItemContainer();
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.mergeFrom(localStDittoFeed.dittoData.get().toByteArray());
      if (this.jdField_a_of_type_Uco != null) {
        this.jdField_a_of_type_Uco.a(localStFeed, paramInt, this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.get());
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget
 * JD-Core Version:    0.7.0.1
 */