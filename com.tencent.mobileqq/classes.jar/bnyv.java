import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bnyv
{
  public static bnyv a()
  {
    return bnyy.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, bnyw parambnyw)
  {
    bnzb.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = bojl.a();
    if (localAppInterface == null)
    {
      if (parambnyw != null) {
        parambnyw.a(null);
      }
      bnzb.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      bdvs localbdvs = new bdvs();
      localbdvs.jdField_a_of_type_Bdvw = new bnyx(paramString1, paramString2, parambnyw);
      localbdvs.jdField_a_of_type_JavaLangString = paramString1;
      localbdvs.jdField_a_of_type_Int = 0;
      localbdvs.jdField_c_of_type_JavaLangString = new File(paramString2).getPath();
      localbdvs.b = bgnt.a(bdwu.a().a());
      localbdvs.jdField_c_of_type_Long = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).a(localbdvs);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        bnzb.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (parambnyw == null);
    parambnyw.a(null);
  }
  
  public void a(String paramString1, String paramString2, bnyw parambnyw)
  {
    b(paramString1, paramString2, parambnyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyv
 * JD-Core Version:    0.7.0.1
 */