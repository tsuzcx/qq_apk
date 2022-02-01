package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StDividingLine;

public class QCircleRecommendDividerView
  extends QCircleBaseWidgetView
{
  private TextView a;
  
  public QCircleRecommendDividerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (getLayoutParams() != null) {
      getLayoutParams().height = 0;
    }
    setVisibility(8);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(getData() instanceof FeedBlockData)) {
      return;
    }
    paramObject = ((FeedBlockData)getData()).b();
    try
    {
      paramObject = ((QQCircleDitto.StCircleDittoDataNew)new QQCircleDitto.StCircleDittoDataNew().mergeFrom(paramObject.dittoFeed.dittoDataNew.get().toByteArray())).dividingLine;
      if (paramObject == null)
      {
        a();
        return;
      }
      paramObject = paramObject.summary.get();
      if (!TextUtils.isEmpty(paramObject)) {
        this.a.setText(paramObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      a();
      paramObject.printStackTrace();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626953;
  }
  
  protected String getLogTag()
  {
    return "QCircleRecommendDividerView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131448395));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendDividerView
 * JD-Core Version:    0.7.0.1
 */