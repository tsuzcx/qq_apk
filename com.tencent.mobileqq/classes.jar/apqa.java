import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class apqa
  implements beup
{
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    while (!(parambevl instanceof beum)) {
      return;
    }
    beum localbeum = (beum)parambevl;
    localbeum.jdField_a_of_type_Long += parambevm.c;
    parambevm.c = 0L;
    parambevm = "bytes=" + localbeum.jdField_a_of_type_Long + "-";
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
    parambevm = localbeum.jdField_a_of_type_JavaLangString;
    if (parambevm.contains("range="))
    {
      parambevm = parambevm.substring(0, parambevm.lastIndexOf("range="));
      localbeum.jdField_a_of_type_JavaLangString = (parambevm + "range=" + localbeum.jdField_a_of_type_Long);
    }
    QLog.i("AREngine_ARResourceDownload", 1, "IBreakDownFix. url = " + ((beum)parambevl).jdField_a_of_type_JavaLangString + ", offset=" + localbeum.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqa
 * JD-Core Version:    0.7.0.1
 */