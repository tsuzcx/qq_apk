package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import java.util.HashMap;

class ApolloResManagerImpl$5$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResManagerImpl$5$1(ApolloResManagerImpl.5 param5, HashMap paramHashMap) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramBoolean) && (paramArrayOfInt != null))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramArrayOfInt[paramInt1]), "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + paramArrayOfInt[paramInt1]);
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$5.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$5.a.a(this.jdField_a_of_type_JavaUtilHashMap, "success", 0);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$5.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$5.a.a(null, "download error", -5003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.5.1
 * JD-Core Version:    0.7.0.1
 */