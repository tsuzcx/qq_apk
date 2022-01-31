package com.tencent.mobileqq.armap.map;

import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$4$1
  implements Runnable
{
  MapEngineCallback$4$1(MapEngineCallback.4 param4, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MapEngineCallback", 4, "CB_TYPE_GET_HEAD_ICON_PATH updateNativeHeadIcon,path = " + this.val$path + ",mNativePOIMangerHandle = " + this.this$1.this$0.mNativePOIMangerHandle);
    }
    this.this$1.this$0.updateNativeHeadIcon(this.val$path, this.this$1.this$0.mNativePOIMangerHandle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.4.1
 * JD-Core Version:    0.7.0.1
 */