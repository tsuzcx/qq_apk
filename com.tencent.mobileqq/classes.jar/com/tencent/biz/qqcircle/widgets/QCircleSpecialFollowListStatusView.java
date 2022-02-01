package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QCircleSpecialFollowListStatusView
  extends QCircleStatusView
{
  private TextView a;
  private ImageView e;
  
  public QCircleSpecialFollowListStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleSpecialFollowListStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected String a()
  {
    return "QCircleSpecialFollowLis";
  }
  
  public void a(Context paramContext, View paramView)
  {
    super.a(paramContext, paramView);
    this.e = ((ImageView)findViewById(2131369218));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379811));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(this.e, "https://qzonestyle.gtimg.cn/aoi/sola/20190329164139_M5hX693Wjo.png");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    setVisibility(0);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowListStatusView
 * JD-Core Version:    0.7.0.1
 */