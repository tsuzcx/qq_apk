package com.tencent.avcore.netchannel;

public abstract class AbstractNetChannel
  implements IDavNetCallback, IDavNetChannel, IMavNetCallback, IMavNetChannel
{
  public static final byte RCV_FAIL = 1;
  public static final byte RCV_OK = 0;
  public static final byte RCV_UN_IMPL = 3;
  public static final byte RCV_WRONG_PKG = 2;
  public static final byte VIDEO_MSG_SUB_TYPE_ACCEPT = 2;
  public static final byte VIDEO_MSG_SUB_TYPE_CANCEL = 3;
  public static final byte VIDEO_MSG_SUB_TYPE_INFO = 4;
  public static final byte VIDEO_MSG_SUB_TYPE_NOTIFY_ACCEPT = 5;
  public static final byte VIDEO_MSG_SUB_TYPE_NOTIFY_REJECT = 6;
  public static final byte VIDEO_MSG_SUB_TYPE_PAUSE_AV = 7;
  public static final byte VIDEO_MSG_SUB_TYPE_RECEIVE_REQ = 8;
  public static final byte VIDEO_MSG_SUB_TYPE_REMOTE_ADDR = 17;
  public static final byte VIDEO_MSG_SUB_TYPE_REQUEST = 1;
  private IDavNetCallback mDavNetCallback = null;
  private IMavNetCallback mMavNetCallback = null;
  
  public final void receiveGatewayMsg(String paramString, int paramInt)
  {
    if (this.mDavNetCallback != null) {
      this.mDavNetCallback.receiveGatewayMsg(paramString, paramInt);
    }
    if (this.mMavNetCallback != null) {
      this.mMavNetCallback.receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public final int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.mMavNetCallback == null) {
      return 3;
    }
    try
    {
      paramInt = this.mMavNetCallback.receiveMultiVideoMsg(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte) {}
    return 1;
  }
  
  public final byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.mDavNetCallback == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.mDavNetCallback.receiveSharpVideoAck(paramLong, paramArrayOfByte1, paramArrayOfByte2);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public final byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.mDavNetCallback == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.mDavNetCallback.receiveSharpVideoCall(paramLong, paramArrayOfByte1, paramArrayOfByte2);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public final void setNetCallback(IDavNetCallback paramIDavNetCallback)
  {
    this.mDavNetCallback = paramIDavNetCallback;
  }
  
  public final void setNetCallback(IMavNetCallback paramIMavNetCallback)
  {
    this.mMavNetCallback = paramIMavNetCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.netchannel.AbstractNetChannel
 * JD-Core Version:    0.7.0.1
 */