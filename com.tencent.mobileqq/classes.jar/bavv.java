import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import tencent.im.cs.smartptt.Smartptt.PttTransRsp;
import tencent.im.cs.smartptt.Smartptt.RspBody;

class bavv
  implements ITransactionCallback
{
  bavv(bavu parambavu, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms retCode=" + paramInt);
    }
    if ((bavu.a(this.jdField_a_of_type_Bavu) != null) && (bavu.a(this.jdField_a_of_type_Bavu).jdField_b_of_type_JavaLangString != null)) {
      new File(bavu.a(this.jdField_a_of_type_Bavu).jdField_b_of_type_JavaLangString).delete();
    }
    this.jdField_a_of_type_Bavu.d(2005);
    this.jdField_a_of_type_Bavu.jdField_a_of_type_Bass.a = paramArrayOfByte;
    this.jdField_a_of_type_Bavu.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bavu.b);
    this.jdField_a_of_type_Bavu.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    boolean bool2 = true;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onSuccess SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if ((bavu.a(this.jdField_a_of_type_Bavu) != null) && (bavu.a(this.jdField_a_of_type_Bavu).jdField_b_of_type_JavaLangString != null)) {
      new File(bavu.a(this.jdField_a_of_type_Bavu).jdField_b_of_type_JavaLangString).delete();
    }
    paramHashMap = new Smartptt.RspBody();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "onSuccess  text =" + paramHashMap.msg_ptttrans_rsp.str_text.get() + " id=" + paramHashMap.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.jdField_a_of_type_Bavu.jdField_a_of_type_Bayk.p + " uint32_is_final=" + paramHashMap.msg_ptttrans_rsp.uint32_is_final.get());
      }
      this.jdField_a_of_type_Bavu.jdField_a_of_type_Bass.b = 327696;
      this.jdField_a_of_type_Bavu.jdField_a_of_type_Bass.A = (bavu.a(this.jdField_a_of_type_Bavu) + paramHashMap.msg_ptttrans_rsp.str_text.get());
      this.jdField_a_of_type_Bavu.jdField_a_of_type_Bass.c = 68;
      this.jdField_a_of_type_Bavu.jdField_a_of_type_Bass.i = this.jdField_a_of_type_Bavu.jdField_a_of_type_Bayk.p;
      paramArrayOfByte = this.jdField_a_of_type_Bavu;
      boolean bool1 = bool2;
      if (paramHashMap.msg_ptttrans_rsp.uint32_is_final.get() != 1) {
        if (!bavu.a(this.jdField_a_of_type_Bavu).jdField_b_of_type_Boolean) {
          break label355;
        }
      }
      label355:
      for (bool1 = bool2;; bool1 = false)
      {
        bavu.a(paramArrayOfByte, bool1, true);
        this.jdField_a_of_type_Bavu.b.b();
        this.jdField_a_of_type_Bavu.b.a = 1;
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bavu.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onUpdateProgress transferedSize:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavv
 * JD-Core Version:    0.7.0.1
 */