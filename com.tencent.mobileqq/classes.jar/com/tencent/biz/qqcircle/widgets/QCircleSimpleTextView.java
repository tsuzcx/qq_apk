package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

public class QCircleSimpleTextView
  extends QCircleBaseWidgetView
{
  TextView a;
  
  public QCircleSimpleTextView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560808;
  }
  
  protected String a()
  {
    return "QCircleSimpleTextView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131378603));
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      this.a.setText((String)paramObject);
      return;
    }
    this.a.setText(2131697249);
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSimpleTextView
 * JD-Core Version:    0.7.0.1
 */