import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class atpa
  implements bauf
{
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambave instanceof baub));
      parambave = (baub)parambave;
      parambave.jdField_a_of_type_Long += parambavf.c;
      parambavf.c = 0L;
      parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
      parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
      parambavf = parambave.jdField_a_of_type_JavaLangString;
      if (parambavf.contains("range="))
      {
        String str = parambavf.substring(0, parambavf.lastIndexOf("range="));
        parambave.jdField_a_of_type_JavaLangString = (str + "range=" + parambave.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ListenTogether.downloader", 2, "IBreakDownFix, " + parambavf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpa
 * JD-Core Version:    0.7.0.1
 */