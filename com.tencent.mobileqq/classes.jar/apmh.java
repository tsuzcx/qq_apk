import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class apmh
  implements ITransactionCallback
{
  apmh(apmf paramapmf, apny paramapny, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (apmf.a(this.jdField_a_of_type_Apmf))
      {
        if (apmf.a(this.jdField_a_of_type_Apmf) != null)
        {
          int i = 0;
          if (i < apmf.a(this.jdField_a_of_type_Apmf).size())
          {
            if (((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apny.a.equals(this.jdField_a_of_type_Apny.a))
            {
              paramArrayOfByte = ((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apmi;
              str = ((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apny.a;
              apmf.a(this.jdField_a_of_type_Apmf).remove(i);
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
    Object localObject3 = apmf.a(this.jdField_a_of_type_Apmf);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (apmf.a(this.jdField_a_of_type_Apmf) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < apmf.a(this.jdField_a_of_type_Apmf).size())
          {
            if (!((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apny.a.equals(this.jdField_a_of_type_Apny.a)) {
              continue;
            }
            localObject1 = ((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apmi;
            str1 = ((apmk)apmf.a(this.jdField_a_of_type_Apmf).get(i)).jdField_a_of_type_Apny.a;
            apmf.a(this.jdField_a_of_type_Apmf).remove(i);
          }
        }
        paramArrayOfByte = apmf.a(this.jdField_a_of_type_Apmf, paramArrayOfByte, this.jdField_a_of_type_Apny);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((apmi)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Apny.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Apny.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmh
 * JD-Core Version:    0.7.0.1
 */