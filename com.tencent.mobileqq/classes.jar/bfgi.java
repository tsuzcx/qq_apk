import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

public class bfgi
{
  public static String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringWriter localStringWriter = new StringWriter();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringWriter.write(arrayOfStackTraceElement[i].toString());
      localStringWriter.write("\n");
      i += 1;
    }
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static String a(Throwable paramThrowable)
  {
    return a(paramThrowable, false);
  }
  
  private static String a(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {}
    for (paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();; paramThrowable = paramThrowable.getCause())
    {
      if (paramThrowable != null)
      {
        localStringBuilder.append("caused by: ");
        localStringBuilder.append(paramThrowable.toString());
        localStringBuilder.append("\n");
        localStringBuilder.append(a(paramThrowable, true));
      }
      return localStringBuilder.toString();
    }
  }
  
  public static boolean a()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgi
 * JD-Core Version:    0.7.0.1
 */