import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import java.util.HashMap;

class bdyl
  implements ITransactionCallback
{
  bdyl(bdyk parambdyk, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bdyk.a(paramInt, paramHashMap, this.jdField_a_of_type_Long);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bdyk.a(paramArrayOfByte, paramHashMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bdyk.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Bdyk.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bdyk.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bdyk.b.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bdyk.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bdyk localbdyk = this.jdField_a_of_type_Bdyk;
    bduk localbduk = this.jdField_a_of_type_Bdyk.jdField_a_of_type_Bduk;
    long l = paramInt;
    localbduk.e = l;
    localbdyk.s = l;
    if ((paramInt < this.jdField_a_of_type_Bdyk.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bdyk.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bdyk.m))
    {
      this.jdField_a_of_type_Bdyk.j();
      if (this.jdField_a_of_type_Bdyk.g) {
        bovt.a(this.jdField_a_of_type_Bdyk.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1002, this.jdField_a_of_type_Bdyk.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyl
 * JD-Core Version:    0.7.0.1
 */