import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class bhms
{
  public static String a()
  {
    return BaseApplication.getContext().getDir("qqprotect", 0).toString();
  }
  
  public static String b()
  {
    return a() + File.separator + "qseclibs";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhms
 * JD-Core Version:    0.7.0.1
 */