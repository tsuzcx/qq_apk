package com.tencent.biz.qqcircle.fragments.main.part;

import android.app.Activity;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSwitch.SetCirclePopupSwitchRsp;

class QCircleMainTabTipPart$3
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCirclePopupSwitchRsp>
{
  QCircleMainTabTipPart$3(QCircleMainTabTipPart paramQCircleMainTabTipPart, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCirclePopupSwitchRsp paramSetCirclePopupSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new StringBuilder();
      paramString.append("update dialog state success enable:");
      paramString.append(this.a);
      paramString.append(" traceId:");
      paramString.append(paramBaseRequest.getTraceId());
      QLog.i("QCircleMainTabTipPart", 1, paramString.toString());
      if ("1".equals(this.a))
      {
        QCircleConfigHelper.b("qqcircle", "qqcircle_show_bottom_tab_switch", "1");
        HostRouteUtils.openBottomTabSwitchActivity();
        QCircleMainTabTipPart.a(this.b, true);
      }
    }
    else
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("update dialog state error retcode= ");
      paramBaseRequest.append(paramLong);
      QLog.i("QCircleMainTabTipPart", 1, paramBaseRequest.toString());
      if ((this.b.c() != null) && (!this.b.c().isFinishing())) {
        QCircleToast.a(2131916339, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart.3
 * JD-Core Version:    0.7.0.1
 */