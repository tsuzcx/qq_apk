package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import muy;
import muz;

public class ReadInJoyNotifyDialog
  extends Dialog
{
  protected View.OnClickListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected View.OnClickListener b;
  protected TextView b;
  
  public ReadInJoyNotifyDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new muy(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new muz(this);
    a();
  }
  
  private void a()
  {
    setContentView(2130970698);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363397));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364083));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365264));
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131363062));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363176));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNotifyDialog
 * JD-Core Version:    0.7.0.1
 */