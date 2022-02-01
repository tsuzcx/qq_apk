import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.ProcessorFactory.1;
import com.tencent.mobileqq.app.notification.struct.ProcessorFactory.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

public final class aoso
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = new ProcessorFactory.1();
  private static final Map<Integer, Class<? extends aosk>> jdField_a_of_type_JavaUtilMap = new ProcessorFactory.2();
  
  @Nullable
  public static aosk a(QQAppInterface paramQQAppInterface, int paramInt, aosm paramaosm)
  {
    Class localClass = (Class)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject = localClass;
    if (localClass == null) {
      localObject = aorw.class;
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { QQAppInterface.class, aosm.class });
      ((Constructor)localObject).setAccessible(true);
      paramQQAppInterface = (aosk)((Constructor)localObject).newInstance(new Object[] { paramQQAppInterface, paramaosm });
      QLog.d("[NotificationRebuild] ProcessorFactory", 1, new Object[] { "[processor] create: invoked. ", " processor: ", paramQQAppInterface });
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface) {}
    return a(paramQQAppInterface);
  }
  
  private static aosk a(Throwable paramThrowable)
  {
    QLog.e("[NotificationRebuild] ProcessorFactory", 1, "nullProcessorWithException: failed. ", paramThrowable);
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt));
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoso
 * JD-Core Version:    0.7.0.1
 */