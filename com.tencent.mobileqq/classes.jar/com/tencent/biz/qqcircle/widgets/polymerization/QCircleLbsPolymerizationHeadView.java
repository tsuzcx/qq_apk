package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase.StGpsPageData;

public class QCircleLbsPolymerizationHeadView
  extends QCircleBasePolymerizationHeadView
{
  private TextView a;
  private TextView b;
  private QQCircleFeedBase.StGpsPageData c;
  
  public QCircleLbsPolymerizationHeadView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof QQCircleFeedBase.StGpsPageData)) {
      return;
    }
    this.c = ((QQCircleFeedBase.StGpsPageData)paramObject);
    this.a.setText(this.c.poiName.get());
    this.b.setText(a(this.c.subsidiaryFieldDesc.get()));
  }
  
  public int getLayoutId()
  {
    return 2131626865;
  }
  
  protected String getLogTag()
  {
    return "QCircleLbsPolymerizationHeadView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    this.a = ((TextView)paramView.findViewById(2131448814));
    this.b = ((TextView)paramView.findViewById(2131448631));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCircleLbsPolymerizationHeadView
 * JD-Core Version:    0.7.0.1
 */