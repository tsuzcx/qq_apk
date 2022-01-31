import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ansu
  implements ansv
{
  public final String a = anst.a + "." + getClass().getSimpleName();
  
  public static final String a(String paramString1, String paramString2)
  {
    return antv.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(ansy paramansy)
  {
    return antv.a() + File.separator + "_res/" + paramansy.b + File.separator;
  }
  
  public boolean a(ansy paramansy)
  {
    String str = b(paramansy);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramansy + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramansy)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramansy.getMessage());
      }
      paramansy.printStackTrace();
    }
    return false;
  }
  
  public boolean a(ansy paramansy, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(ansy paramansy)
  {
    return a(paramansy.b, paramansy.c);
  }
  
  public boolean b(ansy paramansy)
  {
    boolean bool = true;
    String str = awni.a(b(paramansy));
    if (!paramansy.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramansy);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansu
 * JD-Core Version:    0.7.0.1
 */