import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bgxu
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bgxu.class.getSimpleName();
  }
  
  static void a(AppInterface paramAppInterface, bgya parambgya, String paramString, bgxw parambgxw)
  {
    if (parambgya == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambgya, paramString, parambgxw);
  }
  
  private static void b(AppInterface paramAppInterface, bgya parambgya, String paramString, bgxw parambgxw)
  {
    if ((parambgya == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambgya.a = System.currentTimeMillis();
      parambgya.jdField_e_of_type_Boolean = true;
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = new bgxv(parambgya, paramString, parambgxw);
      localaxro.jdField_a_of_type_JavaLangString = parambgya.jdField_c_of_type_JavaLangString;
      localaxro.jdField_a_of_type_Int = 0;
      if (parambgya.jdField_e_of_type_JavaLangString == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + parambgya.jdField_c_of_type_JavaLangString);
        return;
      }
      localaxro.jdField_c_of_type_JavaLangString = new File(paramString, parambgya.jdField_e_of_type_JavaLangString).getPath();
      localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
      localaxro.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localaxro);
        localaxro.jdField_a_of_type_Axrt.onUpdateProgeress(localaxro, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + parambgya.jdField_c_of_type_JavaLangString);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxu
 * JD-Core Version:    0.7.0.1
 */