import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class aoyr
  implements ITransactionCallback
{
  aoyr(aoyp paramaoyp, apai paramapai, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (aoyp.a(this.jdField_a_of_type_Aoyp))
      {
        if (aoyp.a(this.jdField_a_of_type_Aoyp) != null)
        {
          int i = 0;
          if (i < aoyp.a(this.jdField_a_of_type_Aoyp).size())
          {
            if (((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Apai.a.equals(this.jdField_a_of_type_Apai.a))
            {
              paramArrayOfByte = ((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Aoys;
              str = ((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Apai.a;
              aoyp.a(this.jdField_a_of_type_Aoyp).remove(i);
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
    Object localObject3 = aoyp.a(this.jdField_a_of_type_Aoyp);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (aoyp.a(this.jdField_a_of_type_Aoyp) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < aoyp.a(this.jdField_a_of_type_Aoyp).size())
          {
            if (!((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Apai.a.equals(this.jdField_a_of_type_Apai.a)) {
              continue;
            }
            localObject1 = ((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Aoys;
            str1 = ((aoyu)aoyp.a(this.jdField_a_of_type_Aoyp).get(i)).jdField_a_of_type_Apai.a;
            aoyp.a(this.jdField_a_of_type_Aoyp).remove(i);
          }
        }
        paramArrayOfByte = aoyp.a(this.jdField_a_of_type_Aoyp, paramArrayOfByte, this.jdField_a_of_type_Apai);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((aoys)localObject1).a(i, str1, paramArrayOfByte);
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
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Apai.a);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Apai.a + ". total size = " + this.jdField_a_of_type_Long + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyr
 * JD-Core Version:    0.7.0.1
 */