package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class ApolloResManagerImpl$5
  implements Runnable
{
  ApolloResManagerImpl$5(ApolloResManagerImpl paramApolloResManagerImpl, ArrayList paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      j = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      QLog.d("cm_res", 1, " getApolloDressInfo dressId : " + j);
      if (j < 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener.a(null, "dressId illegal " + j, -5002);
        }
      }
    }
    do
    {
      return;
      if (!ApolloUtilImpl.checkDressRes(j)) {
        localArrayList.add(Integer.valueOf(j));
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(Integer.valueOf(j), "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + j);
      }
      if (localArrayList.size() != 0) {
        break label198;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResIApolloResManager$ApolloDressInfoListener.a(localHashMap, "success", 0);
    return;
    label198:
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new ApolloResManagerImpl.5.1(this, localHashMap), -1, ApolloResManagerImpl.access$500(this.this$0, localArrayList), -1, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */