import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aohx
  extends bhhe
{
  aohx(String paramString) {}
  
  public void onCancel(bhhf parambhhf)
  {
    aoht.jdField_a_of_type_Bhhf = null;
    QLog.d(aoht.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bhhf parambhhf)
  {
    aoht.jdField_a_of_type_Bhhf = null;
    if (parambhhf.a() == 3)
    {
      QLog.d(aoht.jdField_a_of_type_JavaLangString, 1, "download finished " + aoht.f);
      parambhhf = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambhhf.exists()) && (aoht.a(parambhhf))) {
        QLog.d(aoht.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(aoht.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambhhf.b, " code=", Integer.valueOf(parambhhf.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohx
 * JD-Core Version:    0.7.0.1
 */