import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class avyz
  implements ILoggerFactory
{
  private static avyz jdField_a_of_type_Avyz = new avyz();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_Avyz;
  }
  
  public Logger getLogger(String paramString)
  {
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localLogger != null) {
      paramString = localLogger;
    }
    avza localavza;
    do
    {
      return paramString;
      localavza = new avza(this, paramString);
      localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localavza);
      paramString = localLogger;
    } while (localLogger != null);
    return localavza;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyz
 * JD-Core Version:    0.7.0.1
 */