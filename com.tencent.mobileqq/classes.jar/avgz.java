import java.util.HashMap;

class avgz
  implements beup
{
  avgz(avgx paramavgx) {}
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl != null) && (parambevm != null) && ((parambevl instanceof beum)))
    {
      parambevl = (beum)parambevl;
      parambevl.jdField_a_of_type_Long += parambevm.c;
      parambevm.c = 0L;
      parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
      parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
      parambevm = parambevl.jdField_a_of_type_JavaLangString;
      if (parambevm.contains("range="))
      {
        parambevm = parambevm.substring(0, parambevm.lastIndexOf("range="));
        parambevl.jdField_a_of_type_JavaLangString = (parambevm + "range=" + parambevl.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgz
 * JD-Core Version:    0.7.0.1
 */