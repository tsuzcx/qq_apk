import java.util.HashMap;

class aqbo
  implements bauf
{
  aqbo(aqbm paramaqbm) {}
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave != null) && (parambavf != null) && ((parambave instanceof baub)))
    {
      parambave = (baub)parambave;
      parambave.jdField_a_of_type_Long += parambavf.c;
      parambavf.c = 0L;
      parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
      parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
      parambavf = parambave.jdField_a_of_type_JavaLangString;
      if (parambavf.contains("range="))
      {
        parambavf = parambavf.substring(0, parambavf.lastIndexOf("range="));
        parambave.jdField_a_of_type_JavaLangString = (parambavf + "range=" + parambave.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbo
 * JD-Core Version:    0.7.0.1
 */