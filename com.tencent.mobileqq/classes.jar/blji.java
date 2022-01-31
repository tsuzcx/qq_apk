import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blji
{
  public static blji a()
  {
    return bljl.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, bljj parambljj)
  {
    bljn.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = blqh.a();
    if (localAppInterface == null)
    {
      if (parambljj != null) {
        parambljj.a(null);
      }
      bljn.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new bljk(paramString1, paramString2, parambljj);
      localbaub.jdField_a_of_type_JavaLangString = paramString1;
      localbaub.jdField_a_of_type_Int = 0;
      localbaub.jdField_c_of_type_JavaLangString = new File(paramString2).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      localbaub.jdField_c_of_type_Long = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).a(localbaub);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        bljn.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (parambljj == null);
    parambljj.a(null);
  }
  
  public void a(String paramString1, String paramString2, bljj parambljj)
  {
    b(paramString1, paramString2, parambljj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blji
 * JD-Core Version:    0.7.0.1
 */