package com.tencent.av.core;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.WireFormatMicro;
import java.io.IOException;

public class AVMsgUtil
{
  public static byte a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 3)) {
      return paramArrayOfByte[2];
    }
    return -1;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = CodedInputStreamMicro.newInstance(paramArrayOfByte);
    try
    {
      for (;;)
      {
        int i = paramArrayOfByte.readTag();
        if (i == 0) {
          break;
        }
        if (WireFormatMicro.getTagFieldNumber(i) == 2) {
          return true;
        }
        paramArrayOfByte.skipField(i);
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("AbstractNetChannel", "", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.AVMsgUtil
 * JD-Core Version:    0.7.0.1
 */