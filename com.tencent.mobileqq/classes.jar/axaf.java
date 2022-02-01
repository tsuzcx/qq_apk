import java.util.HashMap;

class axaf
  implements bdvv
{
  axaf(axad paramaxad) {}
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws != null) && (parambdwt != null) && ((parambdws instanceof bdvs)))
    {
      parambdws = (bdvs)parambdws;
      parambdws.jdField_a_of_type_Long += parambdwt.c;
      parambdwt.c = 0L;
      parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
      parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
      parambdwt = parambdws.jdField_a_of_type_JavaLangString;
      if (parambdwt.contains("range="))
      {
        parambdwt = parambdwt.substring(0, parambdwt.lastIndexOf("range="));
        parambdws.jdField_a_of_type_JavaLangString = (parambdwt + "range=" + parambdws.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axaf
 * JD-Core Version:    0.7.0.1
 */