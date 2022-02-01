import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class azda
  implements beup
{
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambevl instanceof beum));
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.c;
      parambevm.c = 0L;
      parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
      parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
      parambevm = parambevl.jdField_a_of_type_JavaLangString;
      if (parambevm.contains("range="))
      {
        String str = parambevm.substring(0, parambevm.lastIndexOf("range="));
        parambevl.jdField_a_of_type_JavaLangString = (str + "range=" + parambevl.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("OlympicResources", 2, "IBreakDownFix, " + parambevm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azda
 * JD-Core Version:    0.7.0.1
 */