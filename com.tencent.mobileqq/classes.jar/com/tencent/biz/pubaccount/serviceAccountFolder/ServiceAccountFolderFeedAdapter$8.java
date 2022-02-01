package com.tencent.biz.pubaccount.serviceAccountFolder;

import alpb;
import aody;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import obj;
import tua;
import tub;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(tub paramtub, String paramString, tua paramtua) {}
  
  public void run()
  {
    obj.a().a(tub.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (aody)tub.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((aody)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((aody)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((aody)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((aody)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = tub.a(this.this$0).a().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    tub.a(this.this$0).a().a(this.jdField_a_of_type_Tua.jdField_a_of_type_JavaLangString, 1008);
    alpb.b(tub.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */