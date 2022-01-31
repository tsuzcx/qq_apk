package com.tencent.biz.pubaccount.serviceAccountFolder;

import ahpf;
import akdi;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import nnx;
import saw;
import sax;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(sax paramsax, String paramString, saw paramsaw) {}
  
  public void run()
  {
    nnx.a().a(sax.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (akdi)sax.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((akdi)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((akdi)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((akdi)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((akdi)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = sax.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((aukn)localObject).b(localAccountDetail);
        ((aukn)localObject).a();
      }
    }
    sax.a(this.this$0).a().a(this.jdField_a_of_type_Saw.jdField_a_of_type_JavaLangString, 1008);
    ahpf.b(sax.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */