import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqde
  implements aqdf
{
  public final String a = aqdd.a + "." + getClass().getSimpleName();
  
  public static final String b(String paramString1, String paramString2)
  {
    return aqef.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(aqdi paramaqdi)
  {
    return aqef.a() + File.separator + "_res/" + paramaqdi.b + File.separator;
  }
  
  public boolean a(aqdi paramaqdi)
  {
    String str = b(paramaqdi);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramaqdi + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramaqdi)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramaqdi.getMessage());
      }
      paramaqdi.printStackTrace();
    }
    return false;
  }
  
  public boolean a(aqdi paramaqdi, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(aqdi paramaqdi)
  {
    return b(paramaqdi.b, paramaqdi.c);
  }
  
  public boolean b(aqdi paramaqdi)
  {
    boolean bool = true;
    String str = aznv.a(b(paramaqdi));
    if (!paramaqdi.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramaqdi);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqde
 * JD-Core Version:    0.7.0.1
 */