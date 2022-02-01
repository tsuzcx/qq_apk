package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleAssociateTagWidget
  extends QCircleBaseWidgetView
{
  TextView a;
  TextView b;
  
  public QCircleAssociateTagWidget(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof FeedCloudMeta.StTagInfo)))
    {
      setVisibility(0);
      TextView localTextView = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      paramObject = (FeedCloudMeta.StTagInfo)paramObject;
      localStringBuilder.append(paramObject.tagName.get());
      localTextView.setText(localStringBuilder.toString());
      this.b.setText(paramObject.tagDec.get());
    }
    else
    {
      setVisibility(8);
    }
    setOnClickListener(new QCircleAssociateTagWidget.1(this));
  }
  
  public int getLayoutId()
  {
    return 2131626937;
  }
  
  protected String getLogTag()
  {
    return "QCircleAssociateTagWidget";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131446838));
    this.b = ((TextView)paramView.findViewById(2131446837));
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAssociateTagWidget
 * JD-Core Version:    0.7.0.1
 */