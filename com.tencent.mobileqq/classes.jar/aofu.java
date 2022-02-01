import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class aofu
  implements ITransactionCallback
{
  aofu(aofs paramaofs, aohl paramaohl, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (aofs.a(this.jdField_a_of_type_Aofs))
      {
        if (aofs.a(this.jdField_a_of_type_Aofs) != null)
        {
          int i = 0;
          if (i < aofs.a(this.jdField_a_of_type_Aofs).size())
          {
            if (((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aohl.a.equals(this.jdField_a_of_type_Aohl.a))
            {
              paramArrayOfByte = ((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aofv;
              str = ((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aohl.a;
              aofs.a(this.jdField_a_of_type_Aofs).remove(i);
              QLog.i("AREngine_ARCloudFileUpload", 1, "Upload failed. retCode = " + paramInt + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(paramInt, str, null);
              }
              return;
            }
            i += 1;
          }
        }
      }
      paramArrayOfByte = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    Object localObject2 = null;
    String str2 = "";
    Object localObject3 = aofs.a(this.jdField_a_of_type_Aofs);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (aofs.a(this.jdField_a_of_type_Aofs) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < aofs.a(this.jdField_a_of_type_Aofs).size())
          {
            if (!((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aohl.a.equals(this.jdField_a_of_type_Aohl.a)) {
              continue;
            }
            localObject1 = ((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aofv;
            str1 = ((aofx)aofs.a(this.jdField_a_of_type_Aofs).get(i)).jdField_a_of_type_Aohl.a;
            aofs.a(this.jdField_a_of_type_Aofs).remove(i);
          }
        }
        paramArrayOfByte = aofs.a(this.jdField_a_of_type_Aofs, paramArrayOfByte, this.jdField_a_of_type_Aohl);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((aofv)localObject1).a(i, str1, paramArrayOfByte);
          }
          return;
          i += 1;
          continue;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 0 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1);
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Aohl.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Aohl.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aofu
 * JD-Core Version:    0.7.0.1
 */