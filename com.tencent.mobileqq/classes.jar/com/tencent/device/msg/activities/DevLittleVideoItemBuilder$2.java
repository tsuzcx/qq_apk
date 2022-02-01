package com.tencent.device.msg.activities;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.shortvideo.ResultListener;

class DevLittleVideoItemBuilder$2
  implements ResultListener
{
  DevLittleVideoItemBuilder$2(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (DevLittleVideoItemBuilder.b(this.a) != null)
    {
      DevLittleVideoItemBuilder.b(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.d, this.a.e, DevLittleVideoItemBuilder.b(this.a), paramString1, this.a).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */