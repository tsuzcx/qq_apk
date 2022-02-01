import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bpag
{
  public static bpag a()
  {
    return bpaj.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, bpah parambpah)
  {
    bpam.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = bplg.a();
    if (localAppInterface == null)
    {
      if (parambpah != null) {
        parambpah.a(null);
      }
      bpam.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bpai(paramString1, paramString2, parambpah);
      localbeum.jdField_a_of_type_JavaLangString = paramString1;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.jdField_c_of_type_JavaLangString = new File(paramString2).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      localbeum.jdField_c_of_type_Long = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).a(localbeum);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        bpam.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (parambpah == null);
    parambpah.a(null);
  }
  
  public void a(String paramString1, String paramString2, bpah parambpah)
  {
    b(paramString1, paramString2, parambpah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpag
 * JD-Core Version:    0.7.0.1
 */