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
    Object localObject = this.mDavNetCallback;
    if (localObject != null) {
      ((IDavNetCallback)localObject).receiveGatewayMsg(paramString, paramInt);
    }
    localObject = this.mMavNetCallback;
    if (localObject != null) {
      ((IMavNetCallback)localObject).receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public final int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte)
  {
    IMavNetCallback localIMavNetCallback = this.mMavNetCallback;
    if (localIMavNetCallback == null) {
      return 3;
    }
    try
    {
      paramInt = localIMavNetCallback.receiveMultiVideoMsg(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte)
    {
      label22:
      break label22;
    }
    return 1;
  }
  
  public final byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    IDavNetCallback localIDavNetCallback = this.mDavNetCallback;
    if (localIDavNetCallback == null) {
      return 3;
    }
    byte b2 = 1;
    byte b1 = b2;
    if (paramArrayOfByte1 != null) {}
    try
    {
      int i = localIDavNetCallback.receiveSharpVideoAck(paramLong, paramArrayOfByte1, paramArrayOfByte2);
      b1 = b2;
      if (i >= 0) {
        b1 = 0;
      }
      return b1;
    }
    catch (Throwable paramArrayOfByte1) {}
    return 1;
  }
  
  public final byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    IDavNetCallback localIDavNetCallback = this.mDavNetCallback;
    if (localIDavNetCallback == null) {
      return 3;
    }
    if (paramArrayOfByte1 != null) {}
    try
    {
      int i = localIDavNetCallback.receiveSharpVideoCall(paramLong, paramArrayOfByte1, paramArrayOfByte2);
      if (i >= 0) {
        return 0;
      }
      return 1;
    }
    catch (Throwable paramArrayOfByte1) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.netchannel.AbstractNetChannel
 * JD-Core Version:    0.7.0.1
 */