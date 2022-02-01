package com.tencent.device;

class DeviceHeadMgr$1
  implements Runnable
{
  DeviceHeadMgr$1(DeviceHeadMgr paramDeviceHeadMgr, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    this.this$0.downloadImage(DeviceHeadMgr.getDeviceHeadUrl(this.val$strPID), this.val$strDeviceHeadFilePath, this.val$productId, false);
    this.this$0.downloadImage("", "", this.val$productId, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceHeadMgr.1
 * JD-Core Version:    0.7.0.1
 */