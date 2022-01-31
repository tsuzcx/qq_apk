import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class auze
  extends nab
{
  auze(auza paramauza, String paramString, auzh paramauzh) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Auzh != null) {
      this.jdField_a_of_type_Auzh.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auze
 * JD-Core Version:    0.7.0.1
 */