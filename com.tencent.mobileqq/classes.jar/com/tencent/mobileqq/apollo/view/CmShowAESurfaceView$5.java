package com.tencent.mobileqq.apollo.view;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.light.CameraController.CmShowCallback;

class CmShowAESurfaceView$5
  implements Runnable
{
  CmShowAESurfaceView$5(CmShowAESurfaceView paramCmShowAESurfaceView, HashMap paramHashMap, String paramString, CameraController.CmShowCallback paramCmShowCallback) {}
  
  public void run()
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cmshowFirstTime][cmShowSetKapuModel] kapuModel = ");
      localStringBuilder.append(this.a.toString());
      QLog.d("[cmshow]CmShowAESurfaceView", 2, localStringBuilder.toString());
    }
    else
    {
      QLog.d("[cmshow]CmShowAESurfaceView", 2, "[cmshowFirstTime][cmShowSetKapuModel] kapuModel is null ");
    }
    CmShowAESurfaceView.d(this.this$0).cmShowSetKapuModel(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.5
 * JD-Core Version:    0.7.0.1
 */