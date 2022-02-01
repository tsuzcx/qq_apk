import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bora
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bora.class.getSimpleName();
  }
  
  public static void a(AppInterface paramAppInterface, boqu paramboqu, String paramString, borc paramborc)
  {
    if (paramboqu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramboqu, paramString, paramborc);
  }
  
  private static void b(AppInterface paramAppInterface, boqu paramboqu, String paramString, borc paramborc)
  {
    if ((paramboqu == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramboqu.a = System.currentTimeMillis();
      paramboqu.jdField_f_of_type_Boolean = true;
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new borb(paramboqu, paramString, paramborc);
      localbeum.jdField_a_of_type_JavaLangString = paramboqu.d;
      localbeum.jdField_a_of_type_Int = 0;
      if (paramboqu.jdField_f_of_type_JavaLangString == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "startDownloadMaterial fail, info.name is null, url:" + paramboqu.d);
        return;
      }
      localbeum.jdField_c_of_type_JavaLangString = new File(paramString, paramboqu.jdField_f_of_type_JavaLangString).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      localbeum.jdField_c_of_type_Long = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).a(localbeum);
        localbeum.jdField_a_of_type_Beuq.onUpdateProgeress(localbeum, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadMaterial url: " + paramboqu.d);
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
 * Qualified Name:     bora
 * JD-Core Version:    0.7.0.1
 */