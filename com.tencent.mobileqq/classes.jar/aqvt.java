import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqvt
  implements aqwb
{
  aqvt(aqvs paramaqvs, int paramInt, String paramString) {}
  
  public void a(Uri paramUri)
  {
    QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : onFaild= " + paramUri);
    this.jdField_a_of_type_Aqvs.a.finish();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    QLog.d("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : onFinish= " + paramString1);
    try
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_Aqvs.a(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_Aqvs.b(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq exception=", paramString1);
      return;
    }
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_a_of_type_Aqvs.a(paramString1, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqvt
 * JD-Core Version:    0.7.0.1
 */