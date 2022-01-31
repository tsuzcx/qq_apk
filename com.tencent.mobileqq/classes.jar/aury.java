import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class aury
  implements aysb
{
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysy instanceof ayrx));
      paramaysy = (ayrx)paramaysy;
      paramaysy.jdField_a_of_type_Long += paramaysz.c;
      paramaysz.c = 0L;
      paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
      paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
      paramaysz = paramaysy.jdField_a_of_type_JavaLangString;
      if (paramaysz.contains("range="))
      {
        String str = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
        paramaysy.jdField_a_of_type_JavaLangString = (str + "range=" + paramaysy.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("PrecoverResDownloader", 2, "IBreakDownFix, " + paramaysz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aury
 * JD-Core Version:    0.7.0.1
 */