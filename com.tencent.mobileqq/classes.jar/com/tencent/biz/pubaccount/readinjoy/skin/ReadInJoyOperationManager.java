package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import java.io.File;
import java.util.List;

public class ReadInJoyOperationManager
  extends ReadInJoyBaseResManager
{
  public ReadInJoyOperationManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public BaseResData a(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if ("operation_guide".equals(str1)) {}
    for (paramString = GuideData.class;; paramString = null)
    {
      if (paramString == null) {}
      do
      {
        return null;
        String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString, paramString.getSimpleName(), true, "uin=? and showTime!=0 and business=?", new String[] { str2, str1 }, null, null, "showTime desc", "1");
      } while ((paramString == null) || (paramString.size() <= 0));
      return (BaseResData)paramString.get(0);
    }
  }
  
  public List a(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if ("operation_guide".equals(str1)) {}
    for (paramString = GuideData.class;; paramString = null)
    {
      if (paramString == null) {
        return null;
      }
      int i = (int)(System.currentTimeMillis() / 1000L);
      String str2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString, paramString.getSimpleName(), true, "uin=? and showTime=? and business=? and endTime>?", new String[] { str2, "0", str1, String.valueOf(i) }, null, null, "seq desc", null);
    }
  }
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramBaseResData);
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.showTime = ((int)(System.currentTimeMillis() / 1000L));
    paramBaseResData.setStatus(1000);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramBaseResData);
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return true;
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return SceneBuilder.a(new File(a(paramString, paramBaseResData.id)));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager
 * JD-Core Version:    0.7.0.1
 */