import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blfb
{
  public static blfb a()
  {
    return blfe.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, blfc paramblfc)
  {
    blfg.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = bllv.a();
    if (localAppInterface == null)
    {
      if (paramblfc != null) {
        paramblfc.a(null);
      }
      blfg.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new blfd(paramString1, paramString2, paramblfc);
      localbaps.jdField_a_of_type_JavaLangString = paramString1;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(paramString2).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      localbaps.jdField_c_of_type_Long = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).a(localbaps);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        blfg.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (paramblfc == null);
    paramblfc.a(null);
  }
  
  public void a(String paramString1, String paramString2, blfc paramblfc)
  {
    b(paramString1, paramString2, paramblfc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfb
 * JD-Core Version:    0.7.0.1
 */