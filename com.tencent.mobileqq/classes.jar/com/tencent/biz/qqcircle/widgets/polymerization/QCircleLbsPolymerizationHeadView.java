package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase.StGpsPageData;

public class QCircleLbsPolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQCircleFeedBase.StGpsPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StGpsPageData;
  private TextView b;
  
  public QCircleLbsPolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560743;
  }
  
  public String a()
  {
    return "QCircleLbsPolymerizationHeadView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.b = ((TextView)paramView.findViewById(2131379985));
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StGpsPageData)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StGpsPageData = ((QQCircleFeedBase.StGpsPageData)paramObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StGpsPageData.poiName.get());
    this.b.setText(a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StGpsPageData.subsidiaryFieldDesc.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleLbsPolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */