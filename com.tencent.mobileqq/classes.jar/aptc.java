import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class aptc
  implements bdvv
{
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambdws instanceof bdvs));
      parambdws = (bdvs)parambdws;
      parambdws.jdField_a_of_type_Long += parambdwt.c;
      parambdwt.c = 0L;
      parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
      parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
      parambdwt = parambdws.jdField_a_of_type_JavaLangString;
      if (parambdwt.contains("range="))
      {
        String str = parambdwt.substring(0, parambdwt.lastIndexOf("range="));
        parambdws.jdField_a_of_type_JavaLangString = (str + "range=" + parambdws.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ResDownloadManager", 2, "IBreakDownFix, " + parambdwt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptc
 * JD-Core Version:    0.7.0.1
 */