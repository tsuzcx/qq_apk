package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StDividingLine;

public class QCircleFeedDividerWidget
  extends QCircleBaseWidgetView<FeedCloudMeta.StFeed>
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public QCircleFeedDividerWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560691;
  }
  
  protected String a()
  {
    return "QCircleFeedDividerWidget";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379618));
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (paramStFeed == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
    try
    {
      localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStCircleDittoDataNew.dividingLine.summary.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      for (;;)
      {
        paramStFeed.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedDividerWidget
 * JD-Core Version:    0.7.0.1
 */