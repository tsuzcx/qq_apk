import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import java.util.HashMap;

class bdys
  implements ITransactionCallback
{
  bdys(bdyr parambdyr, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bdyr.a(paramInt, paramHashMap, this.jdField_a_of_type_Long);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bdyr.a(paramArrayOfByte, paramHashMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bdyr.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Bdyr.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bdyr.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bdyr.b.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bdyr.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bdyr localbdyr = this.jdField_a_of_type_Bdyr;
    bduk localbduk = this.jdField_a_of_type_Bdyr.jdField_a_of_type_Bduk;
    long l = paramInt;
    localbduk.e = l;
    localbdyr.s = l;
    if ((paramInt < this.jdField_a_of_type_Bdyr.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bdyr.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bdyr.m)) {
      this.jdField_a_of_type_Bdyr.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdys
 * JD-Core Version:    0.7.0.1
 */