import java.util.HashMap;

class aofc
  implements aysb
{
  aofc(aofa paramaofa) {}
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy != null) && (paramaysz != null) && ((paramaysy instanceof ayrx)))
    {
      paramaysy = (ayrx)paramaysy;
      paramaysy.jdField_a_of_type_Long += paramaysz.c;
      paramaysz.c = 0L;
      paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
      paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
      paramaysz = paramaysy.jdField_a_of_type_JavaLangString;
      if (paramaysz.contains("range="))
      {
        paramaysz = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
        paramaysy.jdField_a_of_type_JavaLangString = (paramaysz + "range=" + paramaysy.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofc
 * JD-Core Version:    0.7.0.1
 */