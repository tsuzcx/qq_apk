import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class ayuu
  implements aysb
{
  ayuu(ayut paramayut) {}
  
  public void a(aysy paramaysy, aysz paramaysz)
  {
    if ((paramaysy == null) || (paramaysz == null)) {}
    label8:
    ayrx localayrx;
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
          localayrx = (ayrx)paramaysy;
          if (ayut.a(this.a))
          {
            File localFile = new File(paramaysy.d);
            if (paramaysz.c == localFile.length())
            {
              paramaysz.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + paramaysy.jdField_a_of_type_Long);
              }
            }
          }
          localayrx.jdField_a_of_type_Long += paramaysz.c;
          if (0L != localayrx.b) {
            break;
          }
          paramaysz.c = 0L;
          paramaysy = "bytes=" + localayrx.jdField_a_of_type_Long + "-";
          localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysy);
          paramaysy = localayrx.jdField_a_of_type_JavaLangString;
        } while (!paramaysy.contains("range="));
        paramaysy = paramaysy.substring(0, paramaysy.lastIndexOf("range="));
        localayrx.jdField_a_of_type_JavaLangString = (paramaysy + "range=" + localayrx.jdField_a_of_type_Long);
        return;
      } while ((localayrx.jdField_a_of_type_Long <= 0L) || (localayrx.b <= 0L) || (localayrx.jdField_a_of_type_Long >= localayrx.b));
      paramaysz.c = 0L;
      paramaysy = "bytes=" + localayrx.jdField_a_of_type_Long + "-" + localayrx.b;
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysy);
      paramaysy = localayrx.jdField_a_of_type_JavaLangString;
    } while (!paramaysy.contains("range="));
    paramaysy = paramaysy.substring(0, paramaysy.lastIndexOf("range="));
    localayrx.jdField_a_of_type_JavaLangString = (paramaysy + "range=" + localayrx.jdField_a_of_type_Long + "-" + localayrx.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayuu
 * JD-Core Version:    0.7.0.1
 */