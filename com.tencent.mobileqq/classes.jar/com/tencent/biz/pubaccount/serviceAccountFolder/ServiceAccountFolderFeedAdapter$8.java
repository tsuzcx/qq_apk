package com.tencent.biz.pubaccount.serviceAccountFolder;

import akms;
import amxz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import ocw;
import uaq;
import uar;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(uar paramuar, String paramString, uaq paramuaq) {}
  
  public void run()
  {
    ocw.a().a(uar.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (amxz)uar.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((amxz)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((amxz)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((amxz)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((amxz)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = uar.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    uar.a(this.this$0).getMessageFacade().clearHistory(this.jdField_a_of_type_Uaq.jdField_a_of_type_JavaLangString, 1008);
    akms.b(uar.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */