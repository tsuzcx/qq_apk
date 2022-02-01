package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class RecentUserManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, AbstructRecentUserMsg> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public RecentUserManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private AbstructRecentUserMsg b(int paramInt)
  {
    Object localObject = RecentUserMsgFactory.a().a(paramInt);
    if (localObject != null)
    {
      localObject = ((RecentMsgProxy)localObject).a();
      if ((localObject instanceof AbstructRecentUserMsg)) {
        return (AbstructRecentUserMsg)localObject;
      }
    }
    return null;
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public AbstructRecentUserMsg a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mobileqq/activity/recent/msg/RecentUserManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 53 2 0
    //   15: ifeq +24 -> 39
    //   18: aload_0
    //   19: getfield 20	com/tencent/mobileqq/activity/recent/msg/RecentUserManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   22: iload_1
    //   23: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokeinterface 57 2 0
    //   31: checkcast 40	com/tencent/mobileqq/activity/recent/msg/AbstructRecentUserMsg
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: iload_1
    //   41: invokespecial 59	com/tencent/mobileqq/activity/recent/msg/RecentUserManager:b	(I)Lcom/tencent/mobileqq/activity/recent/msg/AbstructRecentUserMsg;
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 20	com/tencent/mobileqq/activity/recent/msg/RecentUserManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   49: iload_1
    //   50: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aload_2
    //   54: invokeinterface 63 3 0
    //   59: pop
    //   60: goto -25 -> 35
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	RecentUserManager
    //   0	68	1	paramInt	int
    //   34	20	2	localAbstructRecentUserMsg	AbstructRecentUserMsg
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	63	finally
    //   39	60	63	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserManager
 * JD-Core Version:    0.7.0.1
 */