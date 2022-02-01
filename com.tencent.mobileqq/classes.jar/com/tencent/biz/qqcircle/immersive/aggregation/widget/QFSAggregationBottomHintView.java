package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedHintView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;

public class QFSAggregationBottomHintView
  extends QCircleBaseWidgetView
{
  private QFSPersonalFeedHintView a;
  private FrameLayout b;
  private View c;
  private AlphaAnimation d;
  private String e = "no_product";
  
  public QFSAggregationBottomHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSAggregationBottomHintView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QFSAggregationBottomHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    if (this.d == null)
    {
      this.d = new AlphaAnimation(1.0F, 0.5F);
      this.d.setRepeatMode(2);
      this.d.setRepeatCount(2147483647);
      this.d.setDuration(1000L);
    }
    this.c.startAnimation(this.d);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
    this.b.setVisibility(8);
    this.e = "no_product";
  }
  
  public void b()
  {
    this.a.d();
    this.b.setVisibility(8);
    this.c.clearAnimation();
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.a.b(paramString1, paramString2);
    this.b.setVisibility(8);
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131627109;
  }
  
  protected String getLogTag()
  {
    return "QFSAggregationBottomHintView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QFSPersonalFeedHintView)findViewById(2131441958));
    this.b = ((FrameLayout)findViewById(2131441969));
    this.c = findViewById(2131441993);
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomHintView
 * JD-Core Version:    0.7.0.1
 */