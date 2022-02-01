package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class QCircleSimpleTextView
  extends QCircleBaseWidgetView
{
  TextView a;
  
  public QCircleSimpleTextView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      this.a.setText((String)paramObject);
      return;
    }
    this.a.setText(2131895774);
  }
  
  public int getLayoutId()
  {
    return 2131626960;
  }
  
  protected String getLogTag()
  {
    return "QCircleSimpleTextView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131447062));
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSimpleTextView
 * JD-Core Version:    0.7.0.1
 */