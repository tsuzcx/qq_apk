import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqbp
  implements aqbx
{
  aqbp(aqbo paramaqbo, int paramInt, String paramString) {}
  
  public void a(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CheckForward.Security", 2, "prepareFileInfoAndReq : onFaild= " + paramUri);
    }
    this.jdField_a_of_type_Aqbo.a.finish();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CheckForward.Security", 2, "prepareFileInfoAndReq : onFinish= " + paramString1);
    }
    try
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_Aqbo.a(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_Aqbo.b(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Int == 3) {
        this.jdField_a_of_type_Aqbo.a(paramString1, this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqbp
 * JD-Core Version:    0.7.0.1
 */