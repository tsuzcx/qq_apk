package com.tencent.biz.pubaccount.serviceAccountFolder;

import ajlb;
import alzl;
import awgf;
import awgg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import nrc;
import ssj;
import ssk;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(ssk paramssk, String paramString, ssj paramssj) {}
  
  public void run()
  {
    nrc.a().a(ssk.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (alzl)ssk.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((alzl)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((alzl)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((alzl)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((alzl)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = ssk.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((awgf)localObject).b(localAccountDetail);
        ((awgf)localObject).a();
      }
    }
    ssk.a(this.this$0).a().a(this.jdField_a_of_type_Ssj.jdField_a_of_type_JavaLangString, 1008);
    ajlb.b(ssk.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */