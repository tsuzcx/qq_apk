import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqgp
  implements aqgq
{
  public final String a = aqgo.a + "." + getClass().getSimpleName();
  
  public static final String b(String paramString1, String paramString2)
  {
    return aqhq.a() + File.separator + "_res/" + paramString1;
  }
  
  public String a(aqgt paramaqgt)
  {
    return aqhq.a() + File.separator + "_res/" + paramaqgt.b + File.separator;
  }
  
  public boolean a(aqgt paramaqgt)
  {
    String str = b(paramaqgt);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "needDownload.file exist|" + bool + "|" + paramaqgt + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramaqgt)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "isNeedDownload.exception happen.e=" + paramaqgt.getMessage());
      }
      paramaqgt.printStackTrace();
    }
    return false;
  }
  
  public boolean a(aqgt paramaqgt, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(aqgt paramaqgt)
  {
    return b(paramaqgt.b, paramaqgt.c);
  }
  
  public boolean b(aqgt paramaqgt)
  {
    boolean bool = true;
    String str = azul.a(b(paramaqgt));
    if (!paramaqgt.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 1, "checkDownloadFile.verify failed|" + str + "|" + paramaqgt);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgp
 * JD-Core Version:    0.7.0.1
 */