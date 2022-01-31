import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class asuu
  implements ILoggerFactory
{
  private static asuu jdField_a_of_type_Asuu = new asuu();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_Asuu;
  }
  
  public Logger getLogger(String paramString)
  {
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localLogger != null) {
      paramString = localLogger;
    }
    asuv localasuv;
    do
    {
      return paramString;
      localasuv = new asuv(this, paramString);
      localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localasuv);
      paramString = localLogger;
    } while (localLogger != null);
    return localasuv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuu
 * JD-Core Version:    0.7.0.1
 */