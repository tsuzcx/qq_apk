package com.tencent.mobileqq.app.notification.struct;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.processor.business.CaseDefaultNotificationProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

public final class ProcessorFactory
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = new ProcessorFactory.1();
  private static final Map<Integer, Class<? extends BaseUinTypeProcessor>> jdField_a_of_type_JavaUtilMap = new ProcessorFactory.2();
  
  @Nullable
  public static BaseUinTypeProcessor a(QQAppInterface paramQQAppInterface, int paramInt, NotificationElement paramNotificationElement)
  {
    Class localClass = (Class)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject = localClass;
    if (localClass == null) {
      localObject = CaseDefaultNotificationProcessor.class;
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { QQAppInterface.class, NotificationElement.class });
      ((Constructor)localObject).setAccessible(true);
      paramQQAppInterface = (BaseUinTypeProcessor)((Constructor)localObject).newInstance(new Object[] { paramQQAppInterface, paramNotificationElement });
      QLog.d("[NotificationRebuild] ProcessorFactory", 1, new Object[] { "[processor] create: invoked. ", " processor: ", paramQQAppInterface });
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface) {}
    return a(paramQQAppInterface);
  }
  
  private static BaseUinTypeProcessor a(Throwable paramThrowable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.ProcessorFactory
 * JD-Core Version:    0.7.0.1
 */