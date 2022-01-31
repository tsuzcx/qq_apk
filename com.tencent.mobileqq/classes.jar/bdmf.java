import dalvik.system.PathClassLoader;

public class bdmf
  extends PathClassLoader
{
  private ClassLoader a;
  
  public bdmf(String paramString1, String paramString2, ClassLoader paramClassLoader)
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
      bdnw.c("MiniAppClassloader", "ClassNotFoundException, load class from old loader: " + paramString);
      return this.a.loadClass(paramString);
    }
    catch (InternalError localInternalError)
    {
      bdnw.c("MiniAppClassloader", "InternalError, load class from old loader: " + paramString);
    }
    return this.a.loadClass(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdmf
 * JD-Core Version:    0.7.0.1
 */