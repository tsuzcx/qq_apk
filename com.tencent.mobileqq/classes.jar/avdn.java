import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class avdn
  extends nab
{
  avdn(avdj paramavdj, String paramString, avdq paramavdq) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Avdq != null) {
      this.jdField_a_of_type_Avdq.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdn
 * JD-Core Version:    0.7.0.1
 */