package com.tencent.mobileqq.armap.map;

import com.qq.im.poi.LbsPackManager;
import com.tencent.mobileqq.armap.ArMapInterface;

class MapEngineCallback$1$2
  implements Runnable
{
  MapEngineCallback$1$2(MapEngineCallback.1 param1, boolean paramBoolean, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    LbsPackManager localLbsPackManager = (LbsPackManager)this.this$1.this$0.mApp.getManager(214);
    MapEngineCallback.updateC2CPOIList(this.val$isSuccess, this.val$bytes, this.val$byteLength, this.val$nativeHandle, localLbsPackManager.a(1), localLbsPackManager.a(2), localLbsPackManager.a(3), localLbsPackManager.a(5), "", localLbsPackManager.a(4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.1.2
 * JD-Core Version:    0.7.0.1
 */