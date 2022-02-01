package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import awpu;
import bdla;
import bmnt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;

public class IntimateContentItemLoverEntranceView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmnt jdField_a_of_type_Bmnt;
  private boolean d = true;
  
  public IntimateContentItemLoverEntranceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemLoverEntranceView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemLoverEntranceView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559317, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370570);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370572));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    awpu.a(this.jdField_a_of_type_Agll.a(), this.jdField_a_of_type_Agll.a(), 2064, "2");
    bdla.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.c)
    {
      paramString1 = String.format("<font color=\"#878B99\">" + paramString1 + " </font> <font color=\"#FF7EAE\">" + paramString2 + "</font>", new Object[0]);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramString1));
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramString3);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void m()
  {
    if (this.c) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void n()
  {
    if (this.d) {
      o();
    }
  }
  
  public void o()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
      }
      return;
    }
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
    }
    if (this.jdField_a_of_type_Bmnt == null) {
      this.jdField_a_of_type_Bmnt = new bmnt();
    }
    try
    {
      this.jdField_a_of_type_Bmnt.a(Long.parseLong(this.jdField_a_of_type_Agll.a().getCurrentAccountUin()));
      LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.d("IntimateContentItemLoverEntranceView", 1, "getLoverIntimateValue", localNumberFormatException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView
 * JD-Core Version:    0.7.0.1
 */