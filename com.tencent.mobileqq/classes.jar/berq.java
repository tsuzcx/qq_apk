import java.util.HashMap;

final class berq
  implements beup
{
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
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
          } while (!(parambevl instanceof beum));
          parambevl = (beum)parambevl;
          parambevl.jdField_a_of_type_Long += parambevm.c;
          if (0L != parambevl.b) {
            break;
          }
          parambevm.c = 0L;
          parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-";
          parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
          parambevm = parambevl.jdField_a_of_type_JavaLangString;
        } while (!parambevm.contains("range="));
        parambevm = parambevm.substring(0, parambevm.lastIndexOf("range="));
        parambevl.jdField_a_of_type_JavaLangString = (parambevm + "range=" + parambevl.jdField_a_of_type_Long);
        return;
      } while ((parambevl.jdField_a_of_type_Long <= 0L) || (parambevl.b <= 0L) || (parambevl.jdField_a_of_type_Long >= parambevl.b));
      parambevm.c = 0L;
      parambevm = "bytes=" + parambevl.jdField_a_of_type_Long + "-" + parambevl.b;
      parambevl.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
      parambevm = parambevl.jdField_a_of_type_JavaLangString;
    } while (!parambevm.contains("range="));
    parambevm = parambevm.substring(0, parambevm.lastIndexOf("range="));
    parambevl.jdField_a_of_type_JavaLangString = (parambevm + "range=" + parambevl.jdField_a_of_type_Long + "-" + parambevl.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berq
 * JD-Core Version:    0.7.0.1
 */