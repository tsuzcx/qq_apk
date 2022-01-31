import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class aure
  implements ayrz
{
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaysw instanceof ayrv));
      paramaysw = (ayrv)paramaysw;
      paramaysw.jdField_a_of_type_Long += paramaysx.c;
      paramaysx.c = 0L;
      paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
      paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
      paramaysx = paramaysw.jdField_a_of_type_JavaLangString;
      if (paramaysx.contains("range="))
      {
        String str = paramaysx.substring(0, paramaysx.lastIndexOf("range="));
        paramaysw.jdField_a_of_type_JavaLangString = (str + "range=" + paramaysw.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("PortalManager", 2, "IBreakDownFix, " + paramaysx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aure
 * JD-Core Version:    0.7.0.1
 */