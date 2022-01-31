package com.tencent.biz.pubaccount.serviceAccountFolder;

import ahpd;
import akdh;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import nnu;
import sat;
import sau;

public class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$8(sau paramsau, String paramString, sat paramsat) {}
  
  public void run()
  {
    nnu.a().a(sau.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (akdh)sau.a(this.this$0).getManager(56);
    if (localObject != null)
    {
      ((akdh)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((akdh)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((akdh)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((akdh)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = sau.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((aukp)localObject).b(localAccountDetail);
        ((aukp)localObject).a();
      }
    }
    sau.a(this.this$0).a().a(this.jdField_a_of_type_Sat.jdField_a_of_type_JavaLangString, 1008);
    ahpd.b(sau.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */