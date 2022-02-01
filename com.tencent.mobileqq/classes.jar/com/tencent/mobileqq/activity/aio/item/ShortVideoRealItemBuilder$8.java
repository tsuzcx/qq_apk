package com.tencent.mobileqq.activity.aio.item;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.qphone.base.util.QLog;

class ShortVideoRealItemBuilder$8
  implements ResultListener
{
  ShortVideoRealItemBuilder$8(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(int paramInt)
  {
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder = this.a;
    long l;
    if (ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder) != null) {
      l = ShortVideoRealItemBuilder.a(this.a).uniseq;
    } else {
      l = -1L;
    }
    ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, l);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("onEncodeSuccess curMsg:");
      if (ShortVideoRealItemBuilder.a(this.a) != null) {
        paramString2 = Long.valueOf(ShortVideoRealItemBuilder.a(this.a).uniseq);
      } else {
        paramString2 = "";
      }
      paramArrayOfByte2.append(paramString2);
      QLog.i("ShortVideoRealItemBuilder", 2, paramArrayOfByte2.toString());
    }
    if (ShortVideoRealItemBuilder.a(this.a) != null)
    {
      ShortVideoRealItemBuilder.a(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ShortVideoRealItemBuilder.a(this.a), paramString1, this.a).run();
      return;
    }
    ShortVideoExceptionReporter.a(new RuntimeException("onMediaMessageSend failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */