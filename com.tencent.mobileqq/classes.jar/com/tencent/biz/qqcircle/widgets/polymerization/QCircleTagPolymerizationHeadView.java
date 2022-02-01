package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleFeedBase.StTagPageData;
import wfi;

public class QCircleTagPolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQCircleFeedBase.StTagPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData;
  private wfi jdField_a_of_type_Wfi;
  private TextView b;
  private TextView c;
  
  public QCircleTagPolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560817;
  }
  
  public String a()
  {
    return "QCirclePatSamePolymerizationHeadView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.b = ((TextView)paramView.findViewById(2131379985));
    this.c = ((TextView)paramView.findViewById(2131379775));
    this.jdField_a_of_type_Wfi = new wfi();
    this.jdField_a_of_type_Wfi.a(paramView);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StTagPageData)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData = ((QQCircleFeedBase.StTagPageData)paramObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.tagInfo.tagName.get());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.tagInfo.tagDec.get()))
    {
      this.c.setVisibility(0);
      this.c.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.tagInfo.tagDec.get());
    }
    for (;;)
    {
      this.b.setText(a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData.subsidiaryFieldDesc.get()));
      this.jdField_a_of_type_Wfi.a(a());
      this.jdField_a_of_type_Wfi.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StTagPageData);
      return;
      this.c.setVisibility(8);
    }
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleTagPolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */