package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class QCirclePaiTongKuanIconView
  extends BaseWidgetView
{
  private TextView a;
  
  public QCirclePaiTongKuanIconView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePaiTongKuanIconView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCirclePaiTongKuanIconView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return 2131560760;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.setVisibility(8);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131373994));
  }
  
  public void a(Object paramObject) {}
  
  public void setTongKuanText(String paramString)
  {
    if (this.a != null)
    {
      this.a.setText(paramString);
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView
 * JD-Core Version:    0.7.0.1
 */