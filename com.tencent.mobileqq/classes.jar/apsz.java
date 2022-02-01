import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class apsz
  implements apta
{
  public final String a = apsy.a + "." + getClass().getSimpleName();
  
  public static final String b(String paramString1, String paramString2)
  {
    return apua.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(aptd paramaptd)
  {
    return apua.a() + File.separator + "_res/" + paramaptd.b + File.separator;
  }
  
  public boolean a(aptd paramaptd)
  {
    String str = b(paramaptd);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramaptd + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramaptd)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramaptd.getMessage());
      }
      paramaptd.printStackTrace();
    }
    return false;
  }
  
  public boolean a(aptd paramaptd, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(aptd paramaptd)
  {
    return b(paramaptd.b, paramaptd.c);
  }
  
  public boolean b(aptd paramaptd)
  {
    boolean bool = true;
    String str = azby.a(b(paramaptd));
    if (!paramaptd.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramaptd);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsz
 * JD-Core Version:    0.7.0.1
 */