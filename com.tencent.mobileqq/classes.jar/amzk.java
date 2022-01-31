import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class amzk
  implements bapw
{
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    while (!(parambaqv instanceof baps)) {
      return;
    }
    baps localbaps = (baps)parambaqv;
    localbaps.jdField_a_of_type_Long += parambaqw.c;
    parambaqw.c = 0L;
    parambaqw = "bytes=" + localbaps.jdField_a_of_type_Long + "-";
    localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
    parambaqw = localbaps.jdField_a_of_type_JavaLangString;
    if (parambaqw.contains("range="))
    {
      parambaqw = parambaqw.substring(0, parambaqw.lastIndexOf("range="));
      localbaps.jdField_a_of_type_JavaLangString = (parambaqw + "range=" + localbaps.jdField_a_of_type_Long);
    }
    QLog.i("AREngine_ARResourceDownload", 1, "IBreakDownFix. url = " + ((baps)parambaqv).jdField_a_of_type_JavaLangString + ", offset=" + localbaps.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzk
 * JD-Core Version:    0.7.0.1
 */