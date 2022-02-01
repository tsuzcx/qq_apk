package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IPanelBizReporter;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class CmGamePanelBizReporter
  implements IPanelBizReporter
{
  public void a(IChatPanelBarData paramIChatPanelBarData, View paramView)
  {
    if (paramIChatPanelBarData.b())
    {
      if (QLog.isDebugVersion()) {
        QLog.d("CmGamePanelBizReporter", 4, "[onClickReport] cmgame_aio, cmgame_aio_qun, click, " + paramIChatPanelBarData.a());
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("cmgame_aio", "cmgame_aio_qun", "click", paramIChatPanelBarData.a());
    }
    while (!paramIChatPanelBarData.c()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("CmGamePanelBizReporter", 4, "[onClickReport] cmgame_aio, cmgame_aio_c2c, click");
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio", "cmgame_aio_c2c", "click", "", "", "", "");
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem)
  {
    if ((!paramIChatPanelBarData.a()) && (paramAIOPanelIconItem != null))
    {
      if (!paramIChatPanelBarData.b()) {
        break label84;
      }
      if (QLog.isDebugVersion()) {
        QLog.d("CmGamePanelBizReporter", 4, "[onExposureReport] cmgame_aio, cmgame_aio_qun, expo, " + paramIChatPanelBarData.a());
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("cmgame_aio", "cmgame_aio_qun", "expo", paramIChatPanelBarData.a());
    }
    label84:
    while (!paramIChatPanelBarData.c()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("CmGamePanelBizReporter", 4, "[onExposureReport] cmgame_aio, cmgame_aio_c2c, expo");
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio", "cmgame_aio_c2c", "expo", "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.CmGamePanelBizReporter
 * JD-Core Version:    0.7.0.1
 */