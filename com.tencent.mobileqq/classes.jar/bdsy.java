import java.util.HashMap;

final class bdsy
  implements bdvv
{
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
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
          } while (!(parambdws instanceof bdvs));
          parambdws = (bdvs)parambdws;
          parambdws.jdField_a_of_type_Long += parambdwt.c;
          if (0L != parambdws.b) {
            break;
          }
          parambdwt.c = 0L;
          parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-";
          parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
          parambdwt = parambdws.jdField_a_of_type_JavaLangString;
        } while (!parambdwt.contains("range="));
        parambdwt = parambdwt.substring(0, parambdwt.lastIndexOf("range="));
        parambdws.jdField_a_of_type_JavaLangString = (parambdwt + "range=" + parambdws.jdField_a_of_type_Long);
        return;
      } while ((parambdws.jdField_a_of_type_Long <= 0L) || (parambdws.b <= 0L) || (parambdws.jdField_a_of_type_Long >= parambdws.b));
      parambdwt.c = 0L;
      parambdwt = "bytes=" + parambdws.jdField_a_of_type_Long + "-" + parambdws.b;
      parambdws.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
      parambdwt = parambdws.jdField_a_of_type_JavaLangString;
    } while (!parambdwt.contains("range="));
    parambdwt = parambdwt.substring(0, parambdwt.lastIndexOf("range="));
    parambdws.jdField_a_of_type_JavaLangString = (parambdwt + "range=" + parambdws.jdField_a_of_type_Long + "-" + parambdws.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsy
 * JD-Core Version:    0.7.0.1
 */