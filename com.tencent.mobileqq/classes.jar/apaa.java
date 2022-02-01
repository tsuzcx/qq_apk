import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apaa
  implements apab
{
  public final String a = aozz.a + "." + getClass().getSimpleName();
  
  public static final String b(String paramString1, String paramString2)
  {
    return apbb.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(apae paramapae)
  {
    return apbb.a() + File.separator + "_res/" + paramapae.b + File.separator;
  }
  
  public boolean a(apae paramapae)
  {
    String str = b(paramapae);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramapae + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramapae)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramapae.getMessage());
      }
      paramapae.printStackTrace();
    }
    return false;
  }
  
  public boolean a(apae paramapae, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(apae paramapae)
  {
    return b(paramapae.b, paramapae.c);
  }
  
  public boolean b(apae paramapae)
  {
    boolean bool = true;
    String str = ayja.a(b(paramapae));
    if (!paramapae.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramapae);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apaa
 * JD-Core Version:    0.7.0.1
 */