package com.tencent.biz.pubaccount.serviceAccountFolder;

import aldk;
import anrs;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import nzz;
import tty;
import ttz;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(ttz paramttz, String paramString, tty paramtty) {}
  
  public void run()
  {
    nzz.a().a(ttz.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (anrs)ttz.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((anrs)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((anrs)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((anrs)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((anrs)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = ttz.a(this.this$0).a().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    ttz.a(this.this$0).a().a(this.jdField_a_of_type_Tty.jdField_a_of_type_JavaLangString, 1008);
    aldk.b(ttz.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */