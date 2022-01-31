import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amin
  extends bdvu
{
  amin(String paramString) {}
  
  public void onCancel(bdvv parambdvv)
  {
    amij.jdField_a_of_type_Bdvv = null;
    QLog.d(amij.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bdvv parambdvv)
  {
    amij.jdField_a_of_type_Bdvv = null;
    if (parambdvv.a() == 3)
    {
      QLog.d(amij.jdField_a_of_type_JavaLangString, 1, "download finished " + amij.f);
      parambdvv = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambdvv.exists()) && (amij.a(parambdvv))) {
        QLog.d(amij.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(amij.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambdvv.b, " code=", Integer.valueOf(parambdvv.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amin
 * JD-Core Version:    0.7.0.1
 */