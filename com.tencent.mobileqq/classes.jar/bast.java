import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class bast
  implements bapw
{
  bast(bass parambass) {}
  
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    label8:
    baps localbaps;
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
          } while (!(parambaqv instanceof baps));
          localbaps = (baps)parambaqv;
          if (bass.a(this.a))
          {
            File localFile = new File(parambaqv.d);
            if (parambaqw.c == localFile.length())
            {
              parambaqw.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + parambaqv.jdField_a_of_type_Long);
              }
            }
          }
          localbaps.jdField_a_of_type_Long += parambaqw.c;
          if (0L != localbaps.b) {
            break;
          }
          parambaqw.c = 0L;
          parambaqv = "bytes=" + localbaps.jdField_a_of_type_Long + "-";
          localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqv);
          parambaqv = localbaps.jdField_a_of_type_JavaLangString;
        } while (!parambaqv.contains("range="));
        parambaqv = parambaqv.substring(0, parambaqv.lastIndexOf("range="));
        localbaps.jdField_a_of_type_JavaLangString = (parambaqv + "range=" + localbaps.jdField_a_of_type_Long);
        return;
      } while ((localbaps.jdField_a_of_type_Long <= 0L) || (localbaps.b <= 0L) || (localbaps.jdField_a_of_type_Long >= localbaps.b));
      parambaqw.c = 0L;
      parambaqv = "bytes=" + localbaps.jdField_a_of_type_Long + "-" + localbaps.b;
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqv);
      parambaqv = localbaps.jdField_a_of_type_JavaLangString;
    } while (!parambaqv.contains("range="));
    parambaqv = parambaqv.substring(0, parambaqv.lastIndexOf("range="));
    localbaps.jdField_a_of_type_JavaLangString = (parambaqv + "range=" + localbaps.jdField_a_of_type_Long + "-" + localbaps.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bast
 * JD-Core Version:    0.7.0.1
 */