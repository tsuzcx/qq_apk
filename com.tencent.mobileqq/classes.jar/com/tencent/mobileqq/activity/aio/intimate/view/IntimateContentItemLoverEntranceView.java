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
  private View i;
  private TextView j;
  private LoverRequestManager k;
  private boolean l = true;
  
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
  
  protected void a(View paramView)
  {
    if (paramView.getId() != 2131437760) {
      return;
    }
    LoverZoneUtils.a(this.h.n(), this.h.l(), 2064, "2");
    ReportController.b(null, "dc00898", "", "", "0X800A05E", "0X800A05E", 0, 0, "", "", "", "");
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.g)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<font color=\"#878B99\">");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" </font> <font color=\"#FF7EAE\">");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("</font>");
      paramString1 = String.format(localStringBuilder.toString(), new Object[0]);
      this.j.setText(Html.fromHtml(paramString1));
      this.j.setTag(paramString3);
      this.j.setVisibility(0);
    }
  }
  
  protected boolean a()
  {
    return this.e == 1;
  }
  
  protected void b()
  {
    View localView = LayoutInflater.from(this.a).inflate(2131625178, this, true);
    this.i = localView.findViewById(2131437760);
    this.j = ((TextView)localView.findViewById(2131437762));
    this.i.setOnClickListener(this);
    this.i.setOnTouchListener(this);
  }
  
  public void getLoverIntimateValue()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "showLoverValueText stop request");
      }
      return;
    }
    this.l = false;
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "getLoverIntimateValue sendRequest");
    }
    if (this.k == null) {
      this.k = new LoverRequestManager();
    }
    try
    {
      this.k.a(Long.parseLong(this.h.n().getCurrentAccountUin()));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d("IntimateContentItemLoverEntranceView", 1, "getLoverIntimateValue", localNumberFormatException);
    }
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "6", "1", "1"));
  }
  
  public void getLoverValueFailed()
  {
    if (this.g) {
      this.j.setVisibility(8);
    }
  }
  
  public void n()
  {
    if (this.l) {
      getLoverIntimateValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverEntranceView
 * JD-Core Version:    0.7.0.1
 */