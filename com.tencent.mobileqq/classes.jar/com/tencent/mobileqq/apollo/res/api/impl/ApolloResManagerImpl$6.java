package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ApolloResManagerImpl$6
  implements Runnable
{
  ApolloResManagerImpl$6(ApolloResManagerImpl paramApolloResManagerImpl, ArrayList paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new HashMap();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getApolloDressInfo dressId : ");
      localStringBuilder.append(j);
      QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
      if (j < 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dressId illegal ");
          ((StringBuilder)localObject2).append(j);
          ((IApolloResManager.ApolloDressInfoListener)localObject1).a(null, ((StringBuilder)localObject2).toString(), -5002);
        }
        return;
      }
      if (!CMResUtil.a(j)) {
        ((ArrayList)localObject2).add(Integer.valueOf(j));
      } else {
        ((HashMap)localObject1).put(Integer.valueOf(j), CMGetResPathUtil.b(j));
      }
      i += 1;
    }
    if (((ArrayList)localObject2).size() == 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloDressInfoListener;
      if (localObject2 != null) {
        ((IApolloResManager.ApolloDressInfoListener)localObject2).a((HashMap)localObject1, "success", 0);
      }
    }
    else
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new ApolloResManagerImpl.6.1(this, (HashMap)localObject1), -1, ApolloResManagerImpl.access$800(this.this$0, (List)localObject2), -1, -1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */