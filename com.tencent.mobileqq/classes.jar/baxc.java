import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class baxc
  implements bauf
{
  baxc(baxb parambaxb) {}
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    label8:
    baub localbaub;
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
          localbaub = (baub)parambave;
          if (baxb.a(this.a))
          {
            File localFile = new File(parambave.d);
            if (parambavf.c == localFile.length())
            {
              parambavf.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + parambave.jdField_a_of_type_Long);
              }
            }
          }
          localbaub.jdField_a_of_type_Long += parambavf.c;
          if (0L != localbaub.b) {
            break;
          }
          parambavf.c = 0L;
          parambave = "bytes=" + localbaub.jdField_a_of_type_Long + "-";
          localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", parambave);
          parambave = localbaub.jdField_a_of_type_JavaLangString;
        } while (!parambave.contains("range="));
        parambave = parambave.substring(0, parambave.lastIndexOf("range="));
        localbaub.jdField_a_of_type_JavaLangString = (parambave + "range=" + localbaub.jdField_a_of_type_Long);
        return;
      } while ((localbaub.jdField_a_of_type_Long <= 0L) || (localbaub.b <= 0L) || (localbaub.jdField_a_of_type_Long >= localbaub.b));
      parambavf.c = 0L;
      parambave = "bytes=" + localbaub.jdField_a_of_type_Long + "-" + localbaub.b;
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", parambave);
      parambave = localbaub.jdField_a_of_type_JavaLangString;
    } while (!parambave.contains("range="));
    parambave = parambave.substring(0, parambave.lastIndexOf("range="));
    localbaub.jdField_a_of_type_JavaLangString = (parambave + "range=" + localbaub.jdField_a_of_type_Long + "-" + localbaub.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxc
 * JD-Core Version:    0.7.0.1
 */