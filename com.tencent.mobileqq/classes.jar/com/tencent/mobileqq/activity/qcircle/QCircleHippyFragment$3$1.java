package com.tencent.mobileqq.activity.qcircle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

class QCircleHippyFragment$3$1
  implements DialogInterface.OnClickListener
{
  QCircleHippyFragment$3$1(QCircleHippyFragment.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new HippyMap();
      paramDialogInterface.pushString("result", "call refresh hippy from native");
      ((EventDispatcher)this.a.this$0.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramDialogInterface);
      RFLog.d("QCircleHippyFragment", RFLog.USR, "notify hippy refresh page data success");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      RFLog.e("QCircleHippyFragment", RFLog.USR, "refresh hippy page fail!exception: " + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.3.1
 * JD-Core Version:    0.7.0.1
 */