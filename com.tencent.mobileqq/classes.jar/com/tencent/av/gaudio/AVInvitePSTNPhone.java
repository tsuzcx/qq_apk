package com.tencent.av.gaudio;

import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AVInvitePSTNPhone
{
  private static int b = 28;
  public int a;
  public TelInfo a;
  
  public AVInvitePSTNPhone()
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
  
  public static ArrayList a(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = null;
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer detail is null");
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
    QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer buflen == 0");
    return null;
    int i = paramInt / b;
    QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer buflen == " + Long.toString(paramInt) + " count=" + Long.toString(i));
    localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = new AVInvitePSTNPhone();
      ((AVInvitePSTNPhone)localObject).jdField_a_of_type_Int = a(paramArrayOfByte, b * paramInt);
      try
      {
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.a = new String(paramArrayOfByte, b * paramInt + 4, 5, "UTF-8");
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.b = new String(paramArrayOfByte, b * paramInt + 9, 5, "UTF-8");
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.c = new String(paramArrayOfByte, b * paramInt + 14, 12, "UTF-8");
        QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer bytes_nation == " + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.a + " ,bytes_prefix=" + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.b + " ,bytes_mobile=" + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.c);
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
 * Qualified Name:     com.tencent.av.gaudio.AVInvitePSTNPhone
 * JD-Core Version:    0.7.0.1
 */