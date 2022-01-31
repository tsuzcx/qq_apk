import java.util.HashMap;

final class bamx
  implements bapw
{
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(parambaqv instanceof baps));
          parambaqv = (baps)parambaqv;
          parambaqv.jdField_a_of_type_Long += parambaqw.c;
          if (0L != parambaqv.b) {
            break;
          }
          parambaqw.c = 0L;
          parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-";
          parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
          parambaqw = parambaqv.jdField_a_of_type_JavaLangString;
        } while (!parambaqw.contains("range="));
        parambaqw = parambaqw.substring(0, parambaqw.lastIndexOf("range="));
        parambaqv.jdField_a_of_type_JavaLangString = (parambaqw + "range=" + parambaqv.jdField_a_of_type_Long);
        return;
      } while ((parambaqv.jdField_a_of_type_Long <= 0L) || (parambaqv.b <= 0L) || (parambaqv.jdField_a_of_type_Long >= parambaqv.b));
      parambaqw.c = 0L;
      parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-" + parambaqv.b;
      parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
      parambaqw = parambaqv.jdField_a_of_type_JavaLangString;
    } while (!parambaqw.contains("range="));
    parambaqw = parambaqw.substring(0, parambaqw.lastIndexOf("range="));
    parambaqv.jdField_a_of_type_JavaLangString = (parambaqw + "range=" + parambaqv.jdField_a_of_type_Long + "-" + parambaqv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamx
 * JD-Core Version:    0.7.0.1
 */