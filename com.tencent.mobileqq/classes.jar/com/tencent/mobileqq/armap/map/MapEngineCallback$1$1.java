package com.tencent.mobileqq.armap.map;

import com.tencent.qphone.base.util.QLog;

class MapEngineCallback$1$1
  implements Runnable
{
  MapEngineCallback$1$1(MapEngineCallback.1 param1, boolean paramBoolean, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    QLog.d("MapEngineCallback", 2, "onGetPOIList 219");
    MapEngineCallback.updatePOIList(this.val$isSuccess, this.val$bytes, this.val$byteLength, this.val$nativeHandle);
    QLog.d("MapEngineCallback", 2, "onGetPOIList 220");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.1.1
 * JD-Core Version:    0.7.0.1
 */