import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anol
  implements anom
{
  public final String a = anok.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return anpm.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(anop paramanop)
  {
    return anpm.a() + File.separator + "_res/" + paramanop.b + File.separator;
  }
  
  public boolean a(anop paramanop)
  {
    String str = b(paramanop);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramanop + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramanop)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramanop.getMessage());
      }
      paramanop.printStackTrace();
    }
    return false;
  }
  
  public boolean a(anop paramanop, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(anop paramanop)
  {
    return a(paramanop.b, paramanop.c);
  }
  
  public boolean b(anop paramanop)
  {
    boolean bool = true;
    String str = awiz.a(b(paramanop));
    if (!paramanop.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramanop);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anol
 * JD-Core Version:    0.7.0.1
 */