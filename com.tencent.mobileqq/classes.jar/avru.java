import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class avru
  implements ILoggerFactory
{
  private static avru jdField_a_of_type_Avru = new avru();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_Avru;
  }
  
  public Logger getLogger(String paramString)
  {
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localLogger != null) {
      paramString = localLogger;
    }
    avrv localavrv;
    do
    {
      return paramString;
      localavrv = new avrv(this, paramString);
      localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localavrv);
      paramString = localLogger;
    } while (localLogger != null);
    return localavrv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avru
 * JD-Core Version:    0.7.0.1
 */