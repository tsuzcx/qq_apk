import java.util.HashMap;

final class aypc
  implements aysb
{
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
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
          } while (!(paramaysy instanceof ayrx));
          paramaysy = (ayrx)paramaysy;
          paramaysy.jdField_a_of_type_Long += paramaysz.c;
          if (0L != paramaysy.b) {
            break;
          }
          paramaysz.c = 0L;
          paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-";
          paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
          paramaysz = paramaysy.jdField_a_of_type_JavaLangString;
        } while (!paramaysz.contains("range="));
        paramaysz = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
        paramaysy.jdField_a_of_type_JavaLangString = (paramaysz + "range=" + paramaysy.jdField_a_of_type_Long);
        return;
      } while ((paramaysy.jdField_a_of_type_Long <= 0L) || (paramaysy.b <= 0L) || (paramaysy.jdField_a_of_type_Long >= paramaysy.b));
      paramaysz.c = 0L;
      paramaysz = "bytes=" + paramaysy.jdField_a_of_type_Long + "-" + paramaysy.b;
      paramaysy.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysz);
      paramaysz = paramaysy.jdField_a_of_type_JavaLangString;
    } while (!paramaysz.contains("range="));
    paramaysz = paramaysz.substring(0, paramaysz.lastIndexOf("range="));
    paramaysy.jdField_a_of_type_JavaLangString = (paramaysz + "range=" + paramaysy.jdField_a_of_type_Long + "-" + paramaysy.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypc
 * JD-Core Version:    0.7.0.1
 */