import java.util.HashMap;

class asxr
  implements ayrz
{
  asxr(asxp paramasxp) {}
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw != null) && (paramaysx != null) && ((paramaysw instanceof ayrv)))
    {
      paramaysw = (ayrv)paramaysw;
      paramaysw.jdField_a_of_type_Long += paramaysx.c;
      paramaysx.c = 0L;
      paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
      paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
      paramaysx = paramaysw.jdField_a_of_type_JavaLangString;
      if (paramaysx.contains("range="))
      {
        paramaysx = paramaysx.substring(0, paramaysx.lastIndexOf("range="));
        paramaysw.jdField_a_of_type_JavaLangString = (paramaysx + "range=" + paramaysw.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxr
 * JD-Core Version:    0.7.0.1
 */