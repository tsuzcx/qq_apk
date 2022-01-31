import java.util.HashMap;

class anom
  implements axrs
{
  anom(anok paramanok) {}
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp != null) && (paramaxsq != null) && ((paramaxsp instanceof axro)))
    {
      paramaxsp = (axro)paramaxsp;
      paramaxsp.jdField_a_of_type_Long += paramaxsq.c;
      paramaxsq.c = 0L;
      paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
      paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
      paramaxsq = paramaxsp.jdField_a_of_type_JavaLangString;
      if (paramaxsq.contains("range="))
      {
        paramaxsq = paramaxsq.substring(0, paramaxsq.lastIndexOf("range="));
        paramaxsp.jdField_a_of_type_JavaLangString = (paramaxsq + "range=" + paramaxsp.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anom
 * JD-Core Version:    0.7.0.1
 */