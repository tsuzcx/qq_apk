import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class bauq
  implements ITransactionCallback
{
  bauq(bauo parambauo, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bauo.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bauo.b);
    this.jdField_a_of_type_Bauo.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          this.jdField_a_of_type_Bauo.f = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. ,fileSize:" + this.jdField_a_of_type_Bauo.jdField_a_of_type_Bass.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Bauo.s = this.jdField_a_of_type_Bauo.q;
      this.jdField_a_of_type_Bauo.d(1007);
      this.jdField_a_of_type_Bauo.b(false);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bdhb.d(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("LightVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bauo.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Bauo.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt)
  {
    bauo localbauo = this.jdField_a_of_type_Bauo;
    bass localbass = this.jdField_a_of_type_Bauo.jdField_a_of_type_Bass;
    long l = paramInt;
    localbass.e = l;
    localbauo.s = l;
    if ((paramInt < this.jdField_a_of_type_Bauo.q) && (!this.jdField_a_of_type_Bauo.o) && (!this.jdField_a_of_type_Bauo.k)) {
      this.jdField_a_of_type_Bauo.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauq
 * JD-Core Version:    0.7.0.1
 */