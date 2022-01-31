import java.util.HashMap;

final class axov
  implements axrs
{
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
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
          } while (!(paramaxsp instanceof axro));
          paramaxsp = (axro)paramaxsp;
          paramaxsp.jdField_a_of_type_Long += paramaxsq.c;
          if (0L != paramaxsp.b) {
            break;
          }
          paramaxsq.c = 0L;
          paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-";
          paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
          paramaxsq = paramaxsp.jdField_a_of_type_JavaLangString;
        } while (!paramaxsq.contains("range="));
        paramaxsq = paramaxsq.substring(0, paramaxsq.lastIndexOf("range="));
        paramaxsp.jdField_a_of_type_JavaLangString = (paramaxsq + "range=" + paramaxsp.jdField_a_of_type_Long);
        return;
      } while ((paramaxsp.jdField_a_of_type_Long <= 0L) || (paramaxsp.b <= 0L) || (paramaxsp.jdField_a_of_type_Long >= paramaxsp.b));
      paramaxsq.c = 0L;
      paramaxsq = "bytes=" + paramaxsp.jdField_a_of_type_Long + "-" + paramaxsp.b;
      paramaxsp.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsq);
      paramaxsq = paramaxsp.jdField_a_of_type_JavaLangString;
    } while (!paramaxsq.contains("range="));
    paramaxsq = paramaxsq.substring(0, paramaxsq.lastIndexOf("range="));
    paramaxsp.jdField_a_of_type_JavaLangString = (paramaxsq + "range=" + paramaxsp.jdField_a_of_type_Long + "-" + paramaxsp.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axov
 * JD-Core Version:    0.7.0.1
 */