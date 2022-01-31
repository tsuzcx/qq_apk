import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

final class aquf
  extends yuj
{
  aquf(String paramString, aqva paramaqva, long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return failed fileid " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqva.a(aque.a(this.jdField_a_of_type_Long, false), true);
      return;
    }
    paramBundle.putString("_m_ForwardBusType", String.valueOf(paramInt2));
    paramBundle.putString("_m_ForwardDeadTime", String.valueOf(paramInt3));
    if (paramInt1 == 0)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult success fileid " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqva.a(this.jdField_a_of_type_JavaLangString, paramBundle);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return[" + paramInt1 + "] fileid " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aqva.a(aque.a(this.jdField_a_of_type_Long, false), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquf
 * JD-Core Version:    0.7.0.1
 */