import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class atkr
  implements bapw
{
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    do
    {
      do
      {
        return;
      } while (!(parambaqv instanceof baps));
      parambaqv = (baps)parambaqv;
      parambaqv.jdField_a_of_type_Long += parambaqw.c;
      parambaqw.c = 0L;
      parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-";
      parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
      parambaqw = parambaqv.jdField_a_of_type_JavaLangString;
      if (parambaqw.contains("range="))
      {
        String str = parambaqw.substring(0, parambaqw.lastIndexOf("range="));
        parambaqv.jdField_a_of_type_JavaLangString = (str + "range=" + parambaqv.jdField_a_of_type_Long);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ListenTogether.downloader", 2, "IBreakDownFix, " + parambaqw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkr
 * JD-Core Version:    0.7.0.1
 */