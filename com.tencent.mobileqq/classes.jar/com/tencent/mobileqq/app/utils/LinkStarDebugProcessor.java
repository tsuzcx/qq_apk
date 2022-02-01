package com.tencent.mobileqq.app.utils;

import com.tencent.qphone.base.util.QLog;

public class LinkStarDebugProcessor
{
  public static boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LinkStarDebugProcessor.", 2, "handleLinkStarNotifyPush. linkStarMsgType=" + paramInt + " reservedData=" + paramArrayOfByte1 + " data=" + paramArrayOfByte2);
    }
    switch (paramInt)
    {
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.LinkStarDebugProcessor
 * JD-Core Version:    0.7.0.1
 */