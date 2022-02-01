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

class bdxj
  implements ITransactionCallback
{
  bdxj(bdxi parambdxi, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms retCode=" + paramInt);
    }
    if ((bdxi.a(this.jdField_a_of_type_Bdxi) != null) && (bdxi.a(this.jdField_a_of_type_Bdxi).jdField_b_of_type_JavaLangString != null)) {
      new File(bdxi.a(this.jdField_a_of_type_Bdxi).jdField_b_of_type_JavaLangString).delete();
    }
    this.jdField_a_of_type_Bdxi.d(2005);
    this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bduk.a = paramArrayOfByte;
    this.jdField_a_of_type_Bdxi.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bdxi.b);
    this.jdField_a_of_type_Bdxi.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    boolean bool2 = true;
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onSuccess SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if ((bdxi.a(this.jdField_a_of_type_Bdxi) != null) && (bdxi.a(this.jdField_a_of_type_Bdxi).jdField_b_of_type_JavaLangString != null)) {
      new File(bdxi.a(this.jdField_a_of_type_Bdxi).jdField_b_of_type_JavaLangString).delete();
    }
    paramHashMap = new Smartptt.RspBody();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PttSliceUploadProcessor", 2, "onSuccess  text =" + paramHashMap.msg_ptttrans_rsp.str_text.get() + " id=" + paramHashMap.msg_ptttrans_rsp.str_voice_id.get() + " pos=" + this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bdzn.p + " uint32_is_final=" + paramHashMap.msg_ptttrans_rsp.uint32_is_final.get());
      }
      this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bduk.b = 327696;
      this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bduk.A = (bdxi.a(this.jdField_a_of_type_Bdxi) + paramHashMap.msg_ptttrans_rsp.str_text.get());
      this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bduk.c = 68;
      this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bduk.i = this.jdField_a_of_type_Bdxi.jdField_a_of_type_Bdzn.p;
      paramArrayOfByte = this.jdField_a_of_type_Bdxi;
      boolean bool1 = bool2;
      if (paramHashMap.msg_ptttrans_rsp.uint32_is_final.get() != 1) {
        if (!bdxi.a(this.jdField_a_of_type_Bdxi).jdField_b_of_type_Boolean) {
          break label355;
        }
      }
      label355:
      for (bool1 = bool2;; bool1 = false)
      {
        bdxi.a(paramArrayOfByte, bool1, true);
        this.jdField_a_of_type_Bdxi.b.b();
        this.jdField_a_of_type_Bdxi.b.a = 1;
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
    this.jdField_a_of_type_Bdxi.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onUpdateProgress transferedSize:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxj
 * JD-Core Version:    0.7.0.1
 */