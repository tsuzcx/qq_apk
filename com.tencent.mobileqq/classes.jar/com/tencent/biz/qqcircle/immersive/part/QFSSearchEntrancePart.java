package com.tencent.biz.qqcircle.immersive.part;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.HashMap;
import javax.annotation.Nullable;

public class QFSSearchEntrancePart
  extends QFSBasePart
  implements View.OnClickListener
{
  private FrameLayout a;
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
  
  public String a()
  {
    return "QFSSearchEntrancePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    this.a = ((FrameLayout)paramView.findViewById(2131442027));
    if (this.a == null) {
      return;
    }
    this.b = ((ImageView)paramView.findViewById(2131442009));
    this.b.setOnClickListener(this);
    RFThreadManager.getSerialThreadHandler().postDelayed(new QFSSearchEntrancePart.1(this), 2000L);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(1));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442009)
    {
      if (QCircleFlutterUtils.a())
      {
        QCircleSchemeBean localQCircleSchemeBean = new QCircleSchemeBean();
        HashMap localHashMap = new HashMap();
        localHashMap.put("backbehavior", "0");
        localQCircleSchemeBean.setAttrs(localHashMap);
        localQCircleSchemeBean.setSchemeAction("opencirclesearch");
        QCircleSchemeLauncher.b(g(), localQCircleSchemeBean);
      }
      else
      {
        QCircleLauncher.a(c(), QCircleJsUrlConfig.a, null, -1);
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(4).setSubActionType(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSSearchEntrancePart
 * JD-Core Version:    0.7.0.1
 */