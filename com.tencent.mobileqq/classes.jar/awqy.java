import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class awqy
  extends nme
{
  awqy(awqu paramawqu, String paramString, awrb paramawrb) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      QLog.i("getMediaDetailInfo", 1, "getMediaDetailInfo错误   errorCode=" + paramInt + ", data=" + paramArrayOfByte + ", mQueryString=" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Awrb != null) {
      this.jdField_a_of_type_Awrb.a(paramInt, paramArrayOfByte, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqy
 * JD-Core Version:    0.7.0.1
 */