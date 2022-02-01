import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import java.util.HashMap;

class bexe
  implements ITransactionCallback
{
  bexe(bexd parambexd, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bexd.a(paramInt, paramHashMap, this.jdField_a_of_type_Long);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Bexd.a(paramArrayOfByte, paramHashMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bexd.d("<BDH_LOG> onSwitch2BackupChannel()");
    this.jdField_a_of_type_Bexd.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_Bexd.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_Bexd.b.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bexd.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bexd localbexd = this.jdField_a_of_type_Bexd;
    bete localbete = this.jdField_a_of_type_Bexd.jdField_a_of_type_Bete;
    long l = paramInt;
    localbete.e = l;
    localbexd.s = l;
    if ((paramInt < this.jdField_a_of_type_Bexd.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bexd.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bexd.m))
    {
      this.jdField_a_of_type_Bexd.j();
      if (this.jdField_a_of_type_Bexd.g) {
        bpxo.a(this.jdField_a_of_type_Bexd.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1002, this.jdField_a_of_type_Bexd.f());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexe
 * JD-Core Version:    0.7.0.1
 */