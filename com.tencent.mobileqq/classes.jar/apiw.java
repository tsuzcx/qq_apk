import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class apiw
  implements ITransactionCallback
{
  apiw(apiu paramapiu, apkn paramapkn, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (apiu.a(this.jdField_a_of_type_Apiu))
      {
        if (apiu.a(this.jdField_a_of_type_Apiu) != null)
        {
          int i = 0;
          if (i < apiu.a(this.jdField_a_of_type_Apiu).size())
          {
            if (((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apkn.a.equals(this.jdField_a_of_type_Apkn.a))
            {
              paramArrayOfByte = ((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apix;
              str = ((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apkn.a;
              apiu.a(this.jdField_a_of_type_Apiu).remove(i);
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
    Object localObject3 = apiu.a(this.jdField_a_of_type_Apiu);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (apiu.a(this.jdField_a_of_type_Apiu) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < apiu.a(this.jdField_a_of_type_Apiu).size())
          {
            if (!((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apkn.a.equals(this.jdField_a_of_type_Apkn.a)) {
              continue;
            }
            localObject1 = ((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apix;
            str1 = ((apiz)apiu.a(this.jdField_a_of_type_Apiu).get(i)).jdField_a_of_type_Apkn.a;
            apiu.a(this.jdField_a_of_type_Apiu).remove(i);
          }
        }
        paramArrayOfByte = apiu.a(this.jdField_a_of_type_Apiu, paramArrayOfByte, this.jdField_a_of_type_Apkn);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((apix)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Apkn.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Apkn.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apiw
 * JD-Core Version:    0.7.0.1
 */