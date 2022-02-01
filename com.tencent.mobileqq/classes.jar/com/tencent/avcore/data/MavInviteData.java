package com.tencent.avcore.data;

import com.tencent.avcore.util.AVCoreLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MavInviteData
{
  private static final int SIZE = 48;
  private static final String TAG = "MavInviteData";
  public ArrayList<AVInviteAccount> inviteAccountList;
  public int retCode;
  public String tip;
  
  private static int getIntFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      int k = 3 - i;
      j |= (paramArrayOfByte[(k + paramInt)] & 0xFF) << k * 4;
      i += 1;
    }
    return j;
  }
  
  public static MavInviteData getInviteDataFromBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavInviteData", "getInviteDataFromBuffer detail is null");
      }
      return null;
    }
    if (paramInt == 0)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavInviteData", "getInviteDataFromBuffer buflen == 0");
      }
      return null;
    }
    MavInviteData localMavInviteData = new MavInviteData();
    int i = getIntFromByte(paramArrayOfByte, 0);
    localMavInviteData.inviteAccountList = new ArrayList();
    paramInt = 0;
    while (paramInt < i)
    {
      AVInviteAccount localAVInviteAccount = new AVInviteAccount();
      int j = 4 + paramInt * 48;
      localAVInviteAccount.accountType = getIntFromByte(paramArrayOfByte, j);
      localAVInviteAccount.account = getLongFromByte(paramArrayOfByte, j + 8);
      try
      {
        localAVInviteAccount.msgTelInfo.nation = new String(paramArrayOfByte, j + 16, 5, "UTF-8");
        localAVInviteAccount.msgTelInfo.prefix = new String(paramArrayOfByte, j + 21, 5, "UTF-8");
        localAVInviteAccount.msgTelInfo.mobile = new String(paramArrayOfByte, j + 26, 12, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e("MavInviteData", "getInviteDataFromBuffer", localUnsupportedEncodingException);
        }
      }
      localAVInviteAccount.result = getIntFromByte(paramArrayOfByte, j + 40);
      localAVInviteAccount.inviteType = getIntFromByte(paramArrayOfByte, j + 44);
      localMavInviteData.inviteAccountList.add(localAVInviteAccount);
      paramInt += 1;
    }
    paramInt = i * 48 + 4;
    localMavInviteData.retCode = getIntFromByte(paramArrayOfByte, paramInt);
    paramInt += 4;
    i = getIntFromByte(paramArrayOfByte, paramInt);
    try
    {
      localMavInviteData.tip = new String(paramArrayOfByte, paramInt + 4, i, "UTF-8");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    AVCoreLog.e("MavInviteData", String.format("getInviteDataFromBuffer retCode[%d], tips length[%d], tips[%s]", new Object[] { Integer.valueOf(localMavInviteData.retCode), Integer.valueOf(i), localMavInviteData.tip }));
    return localMavInviteData;
  }
  
  private static long getLongFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      int j = 7 - i;
      l |= (paramArrayOfByte[(j + paramInt)] & 0xFF) << j * 8;
      i += 1;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.data.MavInviteData
 * JD-Core Version:    0.7.0.1
 */