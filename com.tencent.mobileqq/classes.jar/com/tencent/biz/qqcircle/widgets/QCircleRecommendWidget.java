package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
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
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;
import ufh;
import ufi;
import ufj;
import yip;

public class QCircleRecommendWidget
  extends BaseWidgetView
{
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private ufj jdField_a_of_type_Ufj;
  
  public QCircleRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560545;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372551));
      ufh localufh = new ufh(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localufh);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372536));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localufh);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131372549));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new yip(paramContext, 0, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Ufj = new ufj(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ufj);
      this.jdField_a_of_type_Ufj.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Ufj.a(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new ufi(this));
    }
  }
  
  @Deprecated
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    FeedCloudMeta.StDittoFeed localStDittoFeed;
    if (((paramObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Ufj != null))
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
      if (this.jdField_a_of_type_Ufj != null) {
        this.jdField_a_of_type_Ufj.a(localStFeed, paramInt, this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.get());
      }
      QLog.d("QCircleRecommendWidget", 1, new Object[] { "bind dittoFeed pos:", Integer.valueOf(paramInt), ",item size:", Integer.valueOf(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.size()) });
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("QCircleRecommendWidget", 1, new Object[] { "bindData Exception:", paramObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget
 * JD-Core Version:    0.7.0.1
 */