package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean;
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
    if (paramIChatPanelBarData.c())
    {
      paramView = String.valueOf(BaseChatPanelBarConfProcessor.b().b);
      if (QLog.isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onClickReport] cmgame_aio, cmgame_aio_qun, click, ");
        localStringBuilder.append(paramIChatPanelBarData.b());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramView);
        QLog.d("CmGamePanelBizReporter", 4, localStringBuilder.toString());
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("cmgame_aio", "cmgame_aio_qun", "click", "", "", paramView, paramIChatPanelBarData.b());
      return;
    }
    if (paramIChatPanelBarData.d())
    {
      paramIChatPanelBarData = String.valueOf(BaseChatPanelBarConfProcessor.a().b);
      if (QLog.isDebugVersion())
      {
        paramView = new StringBuilder();
        paramView.append("[onClickReport] cmgame_aio, cmgame_aio_c2c, click, ");
        paramView.append(paramIChatPanelBarData);
        QLog.d("CmGamePanelBizReporter", 4, paramView.toString());
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio", "cmgame_aio_c2c", "click", "", "", paramIChatPanelBarData, "");
    }
  }
  
  public void a(IChatPanelBarData paramIChatPanelBarData, AIOPanelIconItem paramAIOPanelIconItem)
  {
    if ((!paramIChatPanelBarData.a()) && (paramAIOPanelIconItem != null))
    {
      if (paramIChatPanelBarData.c())
      {
        paramAIOPanelIconItem = String.valueOf(BaseChatPanelBarConfProcessor.b().b);
        if (QLog.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onExposureReport] cmgame_aio, cmgame_aio_qun, expo, ");
          localStringBuilder.append(paramIChatPanelBarData.b());
          localStringBuilder.append(", ");
          localStringBuilder.append(paramAIOPanelIconItem);
          QLog.d("CmGamePanelBizReporter", 4, localStringBuilder.toString());
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("cmgame_aio", "cmgame_aio_qun", "expo", "", "", paramAIOPanelIconItem, paramIChatPanelBarData.b());
        return;
      }
      if (paramIChatPanelBarData.d())
      {
        paramIChatPanelBarData = String.valueOf(BaseChatPanelBarConfProcessor.a().b);
        if (QLog.isDebugVersion())
        {
          paramAIOPanelIconItem = new StringBuilder();
          paramAIOPanelIconItem.append("[onExposureReport] cmgame_aio, cmgame_aio_c2c, expo, ");
          paramAIOPanelIconItem.append(paramIChatPanelBarData);
          QLog.d("CmGamePanelBizReporter", 4, paramAIOPanelIconItem.toString());
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQ("cmgame_aio", "cmgame_aio_c2c", "expo", "", "", paramIChatPanelBarData, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.CmGamePanelBizReporter
 * JD-Core Version:    0.7.0.1
 */