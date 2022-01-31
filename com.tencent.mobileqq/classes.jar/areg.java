import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class areg
  implements ILoggerFactory
{
  private static areg jdField_a_of_type_Areg = new areg();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_Areg;
  }
  
  public Logger getLogger(String paramString)
  {
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localLogger != null) {
      paramString = localLogger;
    }
    areh localareh;
    do
    {
      return paramString;
      localareh = new areh(this, paramString);
      localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localareh);
      paramString = localLogger;
    } while (localLogger != null);
    return localareh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     areg
 * JD-Core Version:    0.7.0.1
 */