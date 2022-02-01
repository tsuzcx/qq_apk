import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class beuy
  implements ITransactionCallback
{
  beuy(beuw parambeuw, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Beuw.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Beuw.b);
    this.jdField_a_of_type_Beuw.d();
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
          this.jdField_a_of_type_Beuw.f = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. ,fileSize:" + this.jdField_a_of_type_Beuw.jdField_a_of_type_Bete.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Beuw.s = this.jdField_a_of_type_Beuw.jdField_q_of_type_Long;
      this.jdField_a_of_type_Beuw.d(1007);
      this.jdField_a_of_type_Beuw.b(false);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bhmi.d(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Beuw.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Beuw.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt)
  {
    beuw localbeuw = this.jdField_a_of_type_Beuw;
    bete localbete = this.jdField_a_of_type_Beuw.jdField_a_of_type_Bete;
    long l = paramInt;
    localbete.e = l;
    localbeuw.s = l;
    if ((paramInt < this.jdField_a_of_type_Beuw.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Beuw.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Beuw.m)) {
      this.jdField_a_of_type_Beuw.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuy
 * JD-Core Version:    0.7.0.1
 */