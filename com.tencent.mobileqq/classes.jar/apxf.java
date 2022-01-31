import java.util.HashMap;

class apxf
  implements bapw
{
  apxf(apxd paramapxd) {}
  
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv != null) && (parambaqw != null) && ((parambaqv instanceof baps)))
    {
      parambaqv = (baps)parambaqv;
      parambaqv.jdField_a_of_type_Long += parambaqw.c;
      parambaqw.c = 0L;
      parambaqw = "bytes=" + parambaqv.jdField_a_of_type_Long + "-";
      parambaqv.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
      parambaqw = parambaqv.jdField_a_of_type_JavaLangString;
      if (parambaqw.contains("range="))
      {
        parambaqw = parambaqw.substring(0, parambaqw.lastIndexOf("range="));
        parambaqv.jdField_a_of_type_JavaLangString = (parambaqw + "range=" + parambaqv.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxf
 * JD-Core Version:    0.7.0.1
 */