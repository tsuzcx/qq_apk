import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blal
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = blal.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, blab paramblab, String paramString, blan paramblan)
  {
    if (paramblab == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramblab, paramString, paramblan);
  }
  
  private static void b(AppInterface paramAppInterface, blab paramblab, String paramString, blan paramblan)
  {
    if ((paramblab == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramblab.a = System.currentTimeMillis();
      paramblab.e = true;
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new blam(paramblab, paramString, paramblan);
      localbaub.jdField_a_of_type_JavaLangString = paramblab.d;
      localbaub.jdField_a_of_type_Int = 0;
      if (paramblab.f == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + paramblab.d);
        return;
      }
      localbaub.jdField_c_of_type_JavaLangString = new File(paramString, paramblab.f).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      localbaub.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localbaub);
        localbaub.jdField_a_of_type_Baug.onUpdateProgeress(localbaub, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + paramblab.d);
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
 * Qualified Name:     blal
 * JD-Core Version:    0.7.0.1
 */