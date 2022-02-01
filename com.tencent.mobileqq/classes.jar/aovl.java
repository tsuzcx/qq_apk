import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aovl
  extends biht
{
  aovl(String paramString) {}
  
  public void onCancel(bihu parambihu)
  {
    aovh.jdField_a_of_type_Bihu = null;
    QLog.d(aovh.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bihu parambihu)
  {
    aovh.jdField_a_of_type_Bihu = null;
    if (parambihu.a() == 3)
    {
      QLog.d(aovh.jdField_a_of_type_JavaLangString, 1, "download finished " + aovh.f);
      parambihu = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambihu.exists()) && (aovh.a(parambihu))) {
        QLog.d(aovh.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(aovh.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambihu.b, " code=", Integer.valueOf(parambihu.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovl
 * JD-Core Version:    0.7.0.1
 */