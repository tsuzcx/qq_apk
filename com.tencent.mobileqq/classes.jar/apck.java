import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class apck
  implements bdvv
{
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    while (!(parambdws instanceof bdvs)) {
      return;
    }
    bdvs localbdvs = (bdvs)parambdws;
    localbdvs.jdField_a_of_type_Long += parambdwt.c;
    parambdwt.c = 0L;
    parambdwt = "bytes=" + localbdvs.jdField_a_of_type_Long + "-";
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
    parambdwt = localbdvs.jdField_a_of_type_JavaLangString;
    if (parambdwt.contains("range="))
    {
      parambdwt = parambdwt.substring(0, parambdwt.lastIndexOf("range="));
      localbdvs.jdField_a_of_type_JavaLangString = (parambdwt + "range=" + localbdvs.jdField_a_of_type_Long);
    }
    QLog.i("AREngine_ARResourceDownload", 1, "IBreakDownFix. url = " + ((bdvs)parambdws).jdField_a_of_type_JavaLangString + ", offset=" + localbdvs.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apck
 * JD-Core Version:    0.7.0.1
 */