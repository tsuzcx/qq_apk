package com.tencent.mobileqq.activity.recent.msg;

import android.support.annotation.Nullable;
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
  
  @Nullable
  public AbstructRecentUserMsg a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
      {
        localAbstructRecentUserMsg = (AbstructRecentUserMsg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        return localAbstructRecentUserMsg;
      }
      AbstructRecentUserMsg localAbstructRecentUserMsg = b(paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localAbstructRecentUserMsg);
      return localAbstructRecentUserMsg;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserManager
 * JD-Core Version:    0.7.0.1
 */