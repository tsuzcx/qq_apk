package com.tencent.mobileqq.armap.map;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$2$1
  implements Runnable
{
  MapEngineCallback$2$1(MapEngineCallback.2 param2, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    String str = this.this$1.this$0.generateHeadIcon("myPinHead.png", this.val$bitmap);
    if (QLog.isColorLevel()) {
      QLog.d("MapEngineCallback", 2, "onFaceUpdate uin:" + this.val$uin + ",mNativePOIMangerHandle:" + this.this$1.this$0.mNativePOIMangerHandle + ",headIconPath = " + str);
    }
    if ((this.this$1.this$0.mActivity != null) && (this.this$1.this$0.mActivity.a != null) && (str != null)) {
      this.this$1.this$0.mActivity.a.queueEvent(new MapEngineCallback.2.1.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.2.1
 * JD-Core Version:    0.7.0.1
 */