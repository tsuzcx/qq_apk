import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class axul
  implements axrs
{
  axul(axuk paramaxuk) {}
  
  public void a(axsp paramaxsp, axsq paramaxsq)
  {
    if ((paramaxsp == null) || (paramaxsq == null)) {}
    label8:
    axro localaxro;
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
          localaxro = (axro)paramaxsp;
          if (axuk.a(this.a))
          {
            File localFile = new File(paramaxsp.d);
            if (paramaxsq.c == localFile.length())
            {
              paramaxsq.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + paramaxsp.jdField_a_of_type_Long);
              }
            }
          }
          localaxro.jdField_a_of_type_Long += paramaxsq.c;
          if (0L != localaxro.b) {
            break;
          }
          paramaxsq.c = 0L;
          paramaxsp = "bytes=" + localaxro.jdField_a_of_type_Long + "-";
          localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsp);
          paramaxsp = localaxro.jdField_a_of_type_JavaLangString;
        } while (!paramaxsp.contains("range="));
        paramaxsp = paramaxsp.substring(0, paramaxsp.lastIndexOf("range="));
        localaxro.jdField_a_of_type_JavaLangString = (paramaxsp + "range=" + localaxro.jdField_a_of_type_Long);
        return;
      } while ((localaxro.jdField_a_of_type_Long <= 0L) || (localaxro.b <= 0L) || (localaxro.jdField_a_of_type_Long >= localaxro.b));
      paramaxsq.c = 0L;
      paramaxsp = "bytes=" + localaxro.jdField_a_of_type_Long + "-" + localaxro.b;
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaxsp);
      paramaxsp = localaxro.jdField_a_of_type_JavaLangString;
    } while (!paramaxsp.contains("range="));
    paramaxsp = paramaxsp.substring(0, paramaxsp.lastIndexOf("range="));
    localaxro.jdField_a_of_type_JavaLangString = (paramaxsp + "range=" + localaxro.jdField_a_of_type_Long + "-" + localaxro.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axul
 * JD-Core Version:    0.7.0.1
 */