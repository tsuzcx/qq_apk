import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class biqw
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = biqw.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, biqn parambiqn, String paramString, biqy parambiqy)
  {
    if (parambiqn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambiqn, paramString, parambiqy);
  }
  
  private static void b(AppInterface paramAppInterface, biqn parambiqn, String paramString, biqy parambiqy)
  {
    if ((parambiqn == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambiqn.a = System.currentTimeMillis();
      parambiqn.e = true;
      ayrv localayrv = new ayrv();
      localayrv.jdField_a_of_type_Aysa = new biqx(parambiqn, paramString, parambiqy);
      localayrv.jdField_a_of_type_JavaLangString = parambiqn.d;
      localayrv.jdField_a_of_type_Int = 0;
      if (parambiqn.f == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + parambiqn.d);
        return;
      }
      localayrv.jdField_c_of_type_JavaLangString = new File(paramString, parambiqn.f).getPath();
      localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
      localayrv.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localayrv);
        localayrv.jdField_a_of_type_Aysa.onUpdateProgeress(localayrv, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + parambiqn.d);
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
 * Qualified Name:     biqw
 * JD-Core Version:    0.7.0.1
 */