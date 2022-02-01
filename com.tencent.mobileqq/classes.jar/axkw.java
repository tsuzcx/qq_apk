import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class axkw
  extends niu
{
  axkw(axks paramaxks, String paramString, axkz paramaxkz) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Axkz != null) {
      this.jdField_a_of_type_Axkz.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkw
 * JD-Core Version:    0.7.0.1
 */