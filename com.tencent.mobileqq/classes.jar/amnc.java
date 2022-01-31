import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amnc
  extends bead
{
  amnc(String paramString) {}
  
  public void onCancel(beae parambeae)
  {
    ammy.jdField_a_of_type_Beae = null;
    QLog.d(ammy.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(beae parambeae)
  {
    ammy.jdField_a_of_type_Beae = null;
    if (parambeae.a() == 3)
    {
      QLog.d(ammy.jdField_a_of_type_JavaLangString, 1, "download finished " + ammy.f);
      parambeae = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambeae.exists()) && (ammy.a(parambeae))) {
        QLog.d(ammy.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(ammy.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambeae.b, " code=", Integer.valueOf(parambeae.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnc
 * JD-Core Version:    0.7.0.1
 */