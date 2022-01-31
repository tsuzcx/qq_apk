import java.util.HashMap;

final class barg
  implements bauf
{
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
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
          } while (!(parambave instanceof baub));
          parambave = (baub)parambave;
          parambave.jdField_a_of_type_Long += parambavf.c;
          if (0L != parambave.b) {
            break;
          }
          parambavf.c = 0L;
          parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-";
          parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
          parambavf = parambave.jdField_a_of_type_JavaLangString;
        } while (!parambavf.contains("range="));
        parambavf = parambavf.substring(0, parambavf.lastIndexOf("range="));
        parambave.jdField_a_of_type_JavaLangString = (parambavf + "range=" + parambave.jdField_a_of_type_Long);
        return;
      } while ((parambave.jdField_a_of_type_Long <= 0L) || (parambave.b <= 0L) || (parambave.jdField_a_of_type_Long >= parambave.b));
      parambavf.c = 0L;
      parambavf = "bytes=" + parambave.jdField_a_of_type_Long + "-" + parambave.b;
      parambave.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
      parambavf = parambave.jdField_a_of_type_JavaLangString;
    } while (!parambavf.contains("range="));
    parambavf = parambavf.substring(0, parambavf.lastIndexOf("range="));
    parambave.jdField_a_of_type_JavaLangString = (parambavf + "range=" + parambave.jdField_a_of_type_Long + "-" + parambave.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barg
 * JD-Core Version:    0.7.0.1
 */