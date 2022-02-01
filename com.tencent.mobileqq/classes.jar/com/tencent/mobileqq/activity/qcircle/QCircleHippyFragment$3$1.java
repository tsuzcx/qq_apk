package com.tencent.mobileqq.activity.qcircle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;

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
      ((EventDispatcher)QCircleHippyFragment.f(this.a.this$0).getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramDialogInterface);
      QLog.d("QCircleHippyFragment", 1, "notify hippy refresh page data success");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh hippy page fail!exception: ");
      localStringBuilder.append(paramDialogInterface.getMessage());
      QLog.e("QCircleHippyFragment", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.3.1
 * JD-Core Version:    0.7.0.1
 */