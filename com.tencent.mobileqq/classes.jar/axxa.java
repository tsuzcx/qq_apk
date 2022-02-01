import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class axxa
  extends nte
{
  axxa(axww paramaxww, String paramString, axxd paramaxxd) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Axxd != null) {
      this.jdField_a_of_type_Axxd.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxa
 * JD-Core Version:    0.7.0.1
 */