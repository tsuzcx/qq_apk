package com.tencent.biz.pubaccount.serviceAccountFolder;

import alik;
import aoan;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import okn;
import uon;
import uoo;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(uoo paramuoo, String paramString, uon paramuon) {}
  
  public void run()
  {
    okn.a().a(uoo.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (aoan)uoo.a(this.this$0).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      ((aoan)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((aoan)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((aoan)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((aoan)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = uoo.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    uoo.a(this.this$0).getMessageFacade().clearHistory(this.jdField_a_of_type_Uon.jdField_a_of_type_JavaLangString, 1008);
    alik.b(uoo.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */