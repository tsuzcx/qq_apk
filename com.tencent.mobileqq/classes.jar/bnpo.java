import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bnpo
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnpo.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, bnpf parambnpf, String paramString, bnpq parambnpq)
  {
    if (parambnpf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambnpf, paramString, parambnpq);
  }
  
  private static void b(AppInterface paramAppInterface, bnpf parambnpf, String paramString, bnpq parambnpq)
  {
    if ((parambnpf == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambnpf.a = System.currentTimeMillis();
      parambnpf.jdField_f_of_type_Boolean = true;
      bdvs localbdvs = new bdvs();
      localbdvs.jdField_a_of_type_Bdvw = new bnpp(parambnpf, paramString, parambnpq);
      localbdvs.jdField_a_of_type_JavaLangString = parambnpf.d;
      localbdvs.jdField_a_of_type_Int = 0;
      if (parambnpf.jdField_f_of_type_JavaLangString == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + parambnpf.d);
        return;
      }
      localbdvs.jdField_c_of_type_JavaLangString = new File(paramString, parambnpf.jdField_f_of_type_JavaLangString).getPath();
      localbdvs.b = bgnt.a(bdwu.a().a());
      localbdvs.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localbdvs);
        localbdvs.jdField_a_of_type_Bdvw.onUpdateProgeress(localbdvs, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + parambnpf.d);
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
 * Qualified Name:     bnpo
 * JD-Core Version:    0.7.0.1
 */