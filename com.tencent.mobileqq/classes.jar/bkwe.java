import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bkwe
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bkwe.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, bkvu parambkvu, String paramString, bkwg parambkwg)
  {
    if (parambkvu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambkvu, paramString, parambkwg);
  }
  
  private static void b(AppInterface paramAppInterface, bkvu parambkvu, String paramString, bkwg parambkwg)
  {
    if ((parambkvu == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambkvu.a = System.currentTimeMillis();
      parambkvu.e = true;
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new bkwf(parambkvu, paramString, parambkwg);
      localbaps.jdField_a_of_type_JavaLangString = parambkvu.d;
      localbaps.jdField_a_of_type_Int = 0;
      if (parambkvu.f == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + parambkvu.d);
        return;
      }
      localbaps.jdField_c_of_type_JavaLangString = new File(paramString, parambkvu.f).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      localbaps.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localbaps);
        localbaps.jdField_a_of_type_Bapx.onUpdateProgeress(localbaps, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + parambkvu.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwe
 * JD-Core Version:    0.7.0.1
 */