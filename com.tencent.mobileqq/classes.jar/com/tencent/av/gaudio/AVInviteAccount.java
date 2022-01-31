package com.tencent.av.gaudio;

import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AVInviteAccount
{
  private static int d = 48;
  public int a;
  public long a;
  public TelInfo a;
  public int b;
  public int c;
  
  public AVInviteAccount()
  {
    this.jdField_a_of_type_ComTencentAvGaudioTelInfo = new TelInfo();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i + paramInt)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i + paramInt)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public static ArrayList a(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = null;
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.e("AVInviteAccount", 2, "getListFromBuffer detail is null");
        localObject = localArrayList;
      }
    }
    do
    {
      return localObject;
      if (paramInt != 0) {
        break;
      }
      localObject = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.e("AVInviteAccount", 2, "getListFromBuffer buflen == 0");
    return null;
    int i = paramInt / d;
    localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = new AVInviteAccount();
      ((AVInviteAccount)localObject).jdField_a_of_type_Int = a(paramArrayOfByte, d * paramInt);
      ((AVInviteAccount)localObject).jdField_a_of_type_Long = a(paramArrayOfByte, d * paramInt + 8);
      try
      {
        ((AVInviteAccount)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.a = new String(paramArrayOfByte, d * paramInt + 16, 5, "UTF-8");
        ((AVInviteAccount)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.b = new String(paramArrayOfByte, d * paramInt + 21, 5, "UTF-8");
        ((AVInviteAccount)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.c = new String(paramArrayOfByte, d * paramInt + 26, 12, "UTF-8");
        ((AVInviteAccount)localObject).b = a(paramArrayOfByte, d * paramInt + 40);
        ((AVInviteAccount)localObject).c = a(paramArrayOfByte, d * paramInt + 44);
        localArrayList.add(localObject);
        paramInt += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.AVInviteAccount
 * JD-Core Version:    0.7.0.1
 */