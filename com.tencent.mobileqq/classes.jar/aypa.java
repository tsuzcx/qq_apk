import java.util.HashMap;

final class aypa
  implements ayrz
{
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
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
          } while (!(paramaysw instanceof ayrv));
          paramaysw = (ayrv)paramaysw;
          paramaysw.jdField_a_of_type_Long += paramaysx.c;
          if (0L != paramaysw.b) {
            break;
          }
          paramaysx.c = 0L;
          paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-";
          paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
          paramaysx = paramaysw.jdField_a_of_type_JavaLangString;
        } while (!paramaysx.contains("range="));
        paramaysx = paramaysx.substring(0, paramaysx.lastIndexOf("range="));
        paramaysw.jdField_a_of_type_JavaLangString = (paramaysx + "range=" + paramaysw.jdField_a_of_type_Long);
        return;
      } while ((paramaysw.jdField_a_of_type_Long <= 0L) || (paramaysw.b <= 0L) || (paramaysw.jdField_a_of_type_Long >= paramaysw.b));
      paramaysx.c = 0L;
      paramaysx = "bytes=" + paramaysw.jdField_a_of_type_Long + "-" + paramaysw.b;
      paramaysw.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysx);
      paramaysx = paramaysw.jdField_a_of_type_JavaLangString;
    } while (!paramaysx.contains("range="));
    paramaysx = paramaysx.substring(0, paramaysx.lastIndexOf("range="));
    paramaysw.jdField_a_of_type_JavaLangString = (paramaysx + "range=" + paramaysw.jdField_a_of_type_Long + "-" + paramaysw.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypa
 * JD-Core Version:    0.7.0.1
 */