package com.tencent.biz.pubaccount.serviceAccountFolder;

import ahcq;
import ajoy;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import ncw;
import rof;
import rog;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(rog paramrog, String paramString, rof paramrof) {}
  
  public void run()
  {
    ncw.a().a(rog.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (ajoy)rog.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((ajoy)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((ajoy)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((ajoy)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((ajoy)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = rog.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((atmp)localObject).b(localAccountDetail);
        ((atmp)localObject).a();
      }
    }
    rog.a(this.this$0).a().a(this.jdField_a_of_type_Rof.jdField_a_of_type_JavaLangString, 1008);
    ahcq.b(rog.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */