package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.BaseWidgetView;

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
    super(paramContext, Integer.valueOf(paramInt));
  }
  
  public QCirclePaiTongKuanIconView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131626887;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131441764));
  }
  
  public void setTongKuanText(String paramString)
  {
    TextView localTextView = this.a;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView
 * JD-Core Version:    0.7.0.1
 */