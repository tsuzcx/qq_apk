package com.tencent.biz.qqcircle.widgets.polymerization;

import aaaf;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;

public class QCirclePatSamePolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private static aaaf jdField_a_of_type_Aaaf = new aaaf();
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQCircleFeedBase.StFashionCopyPageData jdField_a_of_type_QqcircleQQCircleFeedBase$StFashionCopyPageData;
  private TextView b;
  
  public QCirclePatSamePolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560762;
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
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StFashionCopyPageData)) {
      return;
    }
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFashionCopyPageData = ((QQCircleFeedBase.StFashionCopyPageData)paramObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFashionCopyPageData.pageDesc.get());
    this.b.setText(a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFashionCopyPageData.subTitleEntry.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePatSamePolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */