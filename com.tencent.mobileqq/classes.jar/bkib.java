import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class bkib
{
  private static String a;
  private static String b;
  
  public static String a()
  {
    if (a != null) {
      return a;
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getExternalFilesDir(null);
    if (localObject1 == null) {}
    for (localObject1 = BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath();; localObject1 = ((File)localObject1).getAbsolutePath())
    {
      Object localObject2 = localObject1;
      if (!((String)localObject1).endsWith("/")) {
        localObject2 = (String)localObject1 + "/";
      }
      a = (String)localObject2;
      return localObject2;
    }
  }
  
  public static String a(long paramLong)
  {
    return b(paramLong) + "disk_file_cache" + "/";
  }
  
  public static String b()
  {
    if (b != null) {
      return b;
    }
    String str = a();
    str = str + "Tencent" + "/" + "weiyun" + "/";
    b = str;
    return str;
  }
  
  private static String b(long paramLong)
  {
    return b() + paramLong + "/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkib
 * JD-Core Version:    0.7.0.1
 */