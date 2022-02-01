import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import java.util.HashMap;

class bexl
  implements ITransactionCallback
{
  bexl(bexk parambexk, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bexk.a(paramInt, paramHashMap, this.jdField_a_of_type_Long);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bexk.a(paramArrayOfByte, paramHashMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bexk.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Bexk.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bexk.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bexk.b.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bexk.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bexk localbexk = this.jdField_a_of_type_Bexk;
    bete localbete = this.jdField_a_of_type_Bexk.jdField_a_of_type_Bete;
    long l = paramInt;
    localbete.e = l;
    localbexk.s = l;
    if ((paramInt < this.jdField_a_of_type_Bexk.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bexk.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bexk.m)) {
      this.jdField_a_of_type_Bexk.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexl
 * JD-Core Version:    0.7.0.1
 */