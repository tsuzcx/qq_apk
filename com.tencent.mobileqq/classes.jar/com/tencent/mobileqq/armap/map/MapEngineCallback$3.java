package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.JNIPOIRequestParam;
import com.tencent.mobileqq.armap.utils.MapLog;
import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$3
  implements Runnable
{
  MapEngineCallback$3(MapEngineCallback paramMapEngineCallback, JNIPOIRequestParam paramJNIPOIRequestParam) {}
  
  public void run()
  {
    if (this.this$0.mApp == null) {}
    for (ArMapHandler localArMapHandler = null;; localArMapHandler = (ArMapHandler)this.this$0.mApp.a(2))
    {
      if (localArMapHandler != null)
      {
        if ((this.this$0.mActivity != null) && (this.this$0.mActivity.a != null)) {
          this.val$param.nativeGLSurfaceViewContext = this.this$0.mActivity.a.getEngineHandler();
        }
        localArMapHandler.a(this.val$param.longitude, this.val$param.latitude, this.val$param.busiID, this.val$param.cookie, this.val$param.nativeHandle, this.val$param);
      }
      if (QLog.isColorLevel()) {
        MapLog.i(2, "CB_TYPE_GET_POILIST arMapHandler: %s param: %s", new Object[] { localArMapHandler, this.val$param.toString() });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.3
 * JD-Core Version:    0.7.0.1
 */