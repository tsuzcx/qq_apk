import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class baqh
  implements ITransactionCallback
{
  baqh(baqf parambaqf, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Baqf.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Baqf.b);
    this.jdField_a_of_type_Baqf.d();
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
          this.jdField_a_of_type_Baqf.f = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. ,fileSize:" + this.jdField_a_of_type_Baqf.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Baqf.s = this.jdField_a_of_type_Baqf.q;
      this.jdField_a_of_type_Baqf.d(1007);
      this.jdField_a_of_type_Baqf.b(false);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bdcs.d(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Baqf.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Baqf.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt)
  {
    baqf localbaqf = this.jdField_a_of_type_Baqf;
    baoj localbaoj = this.jdField_a_of_type_Baqf.jdField_a_of_type_Baoj;
    long l = paramInt;
    localbaoj.e = l;
    localbaqf.s = l;
    if ((paramInt < this.jdField_a_of_type_Baqf.q) && (!this.jdField_a_of_type_Baqf.o) && (!this.jdField_a_of_type_Baqf.k)) {
      this.jdField_a_of_type_Baqf.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqh
 * JD-Core Version:    0.7.0.1
 */