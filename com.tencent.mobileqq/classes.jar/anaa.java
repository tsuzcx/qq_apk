import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class anaa
  implements ITransactionCallback
{
  anaa(amzy paramamzy, anbr paramanbr, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (amzy.a(this.jdField_a_of_type_Amzy))
      {
        if (amzy.a(this.jdField_a_of_type_Amzy) != null)
        {
          int i = 0;
          if (i < amzy.a(this.jdField_a_of_type_Amzy).size())
          {
            if (((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anbr.a.equals(this.jdField_a_of_type_Anbr.a))
            {
              paramArrayOfByte = ((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anab;
              str = ((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anbr.a;
              amzy.a(this.jdField_a_of_type_Amzy).remove(i);
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
    Object localObject3 = amzy.a(this.jdField_a_of_type_Amzy);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (amzy.a(this.jdField_a_of_type_Amzy) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < amzy.a(this.jdField_a_of_type_Amzy).size())
          {
            if (!((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anbr.a.equals(this.jdField_a_of_type_Anbr.a)) {
              continue;
            }
            localObject1 = ((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anab;
            str1 = ((anad)amzy.a(this.jdField_a_of_type_Amzy).get(i)).jdField_a_of_type_Anbr.a;
            amzy.a(this.jdField_a_of_type_Amzy).remove(i);
          }
        }
        paramArrayOfByte = amzy.a(this.jdField_a_of_type_Amzy, paramArrayOfByte, this.jdField_a_of_type_Anbr);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((anab)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Anbr.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Anbr.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaa
 * JD-Core Version:    0.7.0.1
 */