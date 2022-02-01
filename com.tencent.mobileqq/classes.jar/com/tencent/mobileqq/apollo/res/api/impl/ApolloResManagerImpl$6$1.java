package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import java.util.HashMap;

class ApolloResManagerImpl$6$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResManagerImpl$6$1(ApolloResManagerImpl.6 param6, HashMap paramHashMap) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramBoolean) && (paramArrayOfInt != null))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramArrayOfInt[paramInt1]), CMGetResPathUtil.b(paramArrayOfInt[paramInt1]));
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl$6.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl$6.a.a(this.jdField_a_of_type_JavaUtilHashMap, "success", 0);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl$6.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl$6.a.a(null, "download error", -5003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.6.1
 * JD-Core Version:    0.7.0.1
 */