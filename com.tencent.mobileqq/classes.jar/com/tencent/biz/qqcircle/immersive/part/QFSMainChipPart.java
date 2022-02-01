package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import javax.annotation.Nullable;

public class QFSMainChipPart
  extends QFSBasePart
  implements View.OnClickListener
{
  private View a;
  private ImageView b;
  
  private void b(@Nullable View paramView)
  {
    paramView = d(paramView);
    if (paramView != null) {
      paramView.inflate();
    }
  }
  
  private ViewStub d(@Nullable View paramView)
  {
    int i = QCircleHostGlobalInfo.getFolderUIType();
    if (i != 2)
    {
      if (i != 3) {
        return null;
      }
      return (ViewStub)paramView.findViewById(2131442011);
    }
    return (ViewStub)paramView.findViewById(2131442010);
  }
  
  private void d()
  {
    if (this.b == null)
    {
      QLog.d("QFSMainChipPart", 1, "[updateCloseButtonVisible] close button not is null.");
      return;
    }
    boolean bool = QCircleConfigHelper.a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    ImageView localImageView = this.b;
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    localImageView.setVisibility(i);
  }
  
  public String a()
  {
    return "QFSMainChipPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    this.a = paramView.findViewById(2131442013);
    View localView = this.a;
    if (localView != null)
    {
      localView.setOnClickListener(this);
      VideoReport.setElementId(this.a, "em_xsj_profile_button");
      VideoReport.setElementParams(this.a, new QCircleDTParamBuilder().buildElementParams());
    }
    this.b = ((ImageView)paramView.findViewById(2131442012));
    paramView = this.b;
    if (paramView != null)
    {
      paramView.setOnClickListener(this);
      VideoReport.setElementId(this.b, "em_xsj_back_button");
      VideoReport.setElementParams(this.b, new QCircleDTParamBuilder().buildElementParams());
    }
    if (QCircleHostGlobalInfo.getFolderUIType() == 3) {
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131442013)
    {
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUser(QCirclePluginGlobalInfo.c());
      localQCircleInitBean.setFromReportBean(l().clone());
      QCircleLauncher.b(g(), localQCircleInitBean);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setExt2(QFSMainMultiTabFragmentPart.d()).setSubActionType(2));
    }
    else if ((i == 2131442012) && (c() != null))
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(21).setExt2(QFSMainMultiTabFragmentPart.d()).setSubActionType(1));
      c().onBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainChipPart
 * JD-Core Version:    0.7.0.1
 */