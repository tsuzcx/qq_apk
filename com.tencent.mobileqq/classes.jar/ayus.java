import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class ayus
  implements ayrz
{
  ayus(ayur paramayur) {}
  
  public void a(aysw paramaysw, aysx paramaysx)
  {
    if ((paramaysw == null) || (paramaysx == null)) {}
    label8:
    ayrv localayrv;
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
          localayrv = (ayrv)paramaysw;
          if (ayur.a(this.a))
          {
            File localFile = new File(paramaysw.d);
            if (paramaysx.c == localFile.length())
            {
              paramaysx.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + paramaysw.jdField_a_of_type_Long);
              }
            }
          }
          localayrv.jdField_a_of_type_Long += paramaysx.c;
          if (0L != localayrv.b) {
            break;
          }
          paramaysx.c = 0L;
          paramaysw = "bytes=" + localayrv.jdField_a_of_type_Long + "-";
          localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysw);
          paramaysw = localayrv.jdField_a_of_type_JavaLangString;
        } while (!paramaysw.contains("range="));
        paramaysw = paramaysw.substring(0, paramaysw.lastIndexOf("range="));
        localayrv.jdField_a_of_type_JavaLangString = (paramaysw + "range=" + localayrv.jdField_a_of_type_Long);
        return;
      } while ((localayrv.jdField_a_of_type_Long <= 0L) || (localayrv.b <= 0L) || (localayrv.jdField_a_of_type_Long >= localayrv.b));
      paramaysx.c = 0L;
      paramaysw = "bytes=" + localayrv.jdField_a_of_type_Long + "-" + localayrv.b;
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", paramaysw);
      paramaysw = localayrv.jdField_a_of_type_JavaLangString;
    } while (!paramaysw.contains("range="));
    paramaysw = paramaysw.substring(0, paramaysw.lastIndexOf("range="));
    localayrv.jdField_a_of_type_JavaLangString = (paramaysw + "range=" + localayrv.jdField_a_of_type_Long + "-" + localayrv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayus
 * JD-Core Version:    0.7.0.1
 */