package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.vip.manager.LoverRequestManager;

public class IntimateContentItemLoverEntranceView
  extends IntimateContentItemBaseView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LoverRequestManager jdField_a_of_type_CooperationVipManagerLoverRequestManager;
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559257, this, true);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370488);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370490));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131370488) {
      return;
    }
    LoverZoneUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 2064, "2");
    ReportController.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.c)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<font color=\"#878B99\">");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" </font> <font color=\"#FF7EAE\">");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("</font>");
      paramString1 = String.format(localStringBuilder.toString(), new Object[0]);
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
    if (this.jdField_a_of_type_CooperationVipManagerLoverRequestManager == null) {
      this.jdField_a_of_type_CooperationVipManagerLoverRequestManager = new LoverRequestManager();
    }
    try
    {
      this.jdField_a_of_type_CooperationVipManagerLoverRequestManager.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getCurrentAccountUin()));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("IntimateContentItemLoverEntranceView", 1, "getLoverIntimateValue", localNumberFormatException);
    }
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView
 * JD-Core Version:    0.7.0.1
 */