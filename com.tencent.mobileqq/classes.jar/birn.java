import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class birn
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = birn.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, bire parambire, String paramString, birp parambirp)
  {
    if (parambire == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambire, paramString, parambirp);
  }
  
  private static void b(AppInterface paramAppInterface, bire parambire, String paramString, birp parambirp)
  {
    if ((parambire == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambire.a = System.currentTimeMillis();
      parambire.e = true;
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = new biro(parambire, paramString, parambirp);
      localayrx.jdField_a_of_type_JavaLangString = parambire.d;
      localayrx.jdField_a_of_type_Int = 0;
      if (parambire.f == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + parambire.d);
        return;
      }
      localayrx.jdField_c_of_type_JavaLangString = new File(paramString, parambire.f).getPath();
      localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      localayrx.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localayrx);
        localayrx.jdField_a_of_type_Aysc.onUpdateProgeress(localayrx, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + parambire.d);
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
 * Qualified Name:     birn
 * JD-Core Version:    0.7.0.1
 */