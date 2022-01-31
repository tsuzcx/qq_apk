package com.tencent.biz.pubaccount.serviceAccountFolder;

import azqs;
import com.tencent.qphone.base.util.QLog;
import ssj;
import ssk;

public class ServiceAccountFolderFeedAdapter$1
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$1(ssk paramssk, ssj paramssj) {}
  
  public void run()
  {
    try
    {
      if (ssk.a(this.this$0, this.a.jdField_a_of_type_JavaLangString))
      {
        String str2 = this.a.jdField_a_of_type_JavaLangString;
        String str3 = this.a.c;
        if (this.a.jdField_a_of_type_JavaLangCharSequence == null) {}
        for (String str1 = "";; str1 = this.a.jdField_a_of_type_JavaLangCharSequence.toString())
        {
          azqs.b(null, "dc00898", "", str2, "auth_page", "left_unfollow", 0, 0, "", "", str3, str1);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ServiceAccountFolderFeedAdapter", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.1
 * JD-Core Version:    0.7.0.1
 */