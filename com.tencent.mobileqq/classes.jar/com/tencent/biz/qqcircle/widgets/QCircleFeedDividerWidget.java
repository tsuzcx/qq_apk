package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StDividingLine;

public class QCircleFeedDividerWidget
  extends BaseWidgetView<FeedCloudMeta.StFeed>
{
  private TextView a;
  
  public QCircleFeedDividerWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560533;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null) {
      this.a = ((TextView)paramView.findViewById(2131378752));
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (paramStFeed == null) {
      return;
    }
    QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
    try
    {
      localStCircleDittoDataNew.mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
      this.a.setText(localStCircleDittoDataNew.dividingLine.summary.get());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedDividerWidget
 * JD-Core Version:    0.7.0.1
 */