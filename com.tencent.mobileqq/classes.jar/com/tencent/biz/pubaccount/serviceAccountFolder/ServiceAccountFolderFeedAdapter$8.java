package com.tencent.biz.pubaccount.serviceAccountFolder;

import ajgm;
import aluw;
import awbw;
import awbx;
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
    Object localObject = (aluw)ssk.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((aluw)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((aluw)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((aluw)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((aluw)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = ssk.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((awbw)localObject).b(localAccountDetail);
        ((awbw)localObject).a();
      }
    }
    ssk.a(this.this$0).a().a(this.jdField_a_of_type_Ssj.jdField_a_of_type_JavaLangString, 1008);
    ajgm.b(ssk.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */