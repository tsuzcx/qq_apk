package com.tencent.av.ui.redbag;

import com.tencent.av.business.handler.AVC2CDataHandler.C2CDataHandler;
import com.tencent.qphone.base.util.QLog;

class ListenPeerMsg$1
  implements AVC2CDataHandler.C2CDataHandler
{
  ListenPeerMsg$1(ListenPeerMsg paramListenPeerMsg) {}
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    if (11 != paramInt1) {}
    do
    {
      return false;
      QLog.w(this.a.i, 1, "onC2CDataCome, subType[" + paramInt2 + "], mPeerSupportRedBag[" + this.a.jdField_a_of_type_Int + "], mPeerSendMode[" + this.a.jdField_a_of_type_Boolean + "]");
      paramArrayOfByte = this.a.a();
    } while (paramArrayOfByte == null);
    boolean bool1;
    switch (paramInt2)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      this.a.jdField_a_of_type_Int = 2;
      paramArrayOfByte.b("AbilityResDownloading");
      bool1 = bool2;
      continue;
      this.a.jdField_a_of_type_Int = 1;
      paramArrayOfByte.b("AbilityEnable");
      bool1 = bool2;
      continue;
      this.a.jdField_a_of_type_Int = 0;
      paramArrayOfByte.b("AbilityDisable");
      bool1 = bool2;
      continue;
      this.a.jdField_a_of_type_Boolean = true;
      bool1 = bool2;
      if (this.a.jdField_a_of_type_Int != 1)
      {
        this.a.jdField_a_of_type_Int = 1;
        paramArrayOfByte.b("Enter_SendMode");
        bool1 = bool2;
        continue;
        this.a.jdField_a_of_type_Boolean = false;
        bool1 = bool2;
        continue;
        paramArrayOfByte.a(this.a.b);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ListenPeerMsg.1
 * JD-Core Version:    0.7.0.1
 */