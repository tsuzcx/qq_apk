import com.tencent.qqmini.sdk.log.QMLog;
import dalvik.system.PathClassLoader;

public class bgqx
  extends PathClassLoader
{
  private ClassLoader a;
  
  public bgqx(String paramString1, String paramString2, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramClassLoader.getParent());
    this.a = paramClassLoader;
  }
  
  public Class<?> findClass(String paramString)
  {
    try
    {
      Class localClass = super.findClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QMLog.w("MiniAppClassloader", "ClassNotFoundException, load class from old loader: " + paramString);
      return this.a.loadClass(paramString);
    }
    catch (InternalError localInternalError)
    {
      QMLog.w("MiniAppClassloader", "InternalError, load class from old loader: " + paramString);
    }
    return this.a.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqx
 * JD-Core Version:    0.7.0.1
 */