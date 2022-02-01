package com.tencent.biz.pubaccount.serviceAccountFolder;

import bcef;
import com.tencent.qphone.base.util.QLog;
import uaq;
import uar;

public class ServiceAccountFolderFeedAdapter$3
  implements Runnable
{
  public ServiceAccountFolderFeedAdapter$3(uar paramuar, uaq paramuaq) {}
  
  public void run()
  {
    try
    {
      if (uar.a(this.this$0, this.a.jdField_a_of_type_JavaLangString))
      {
        String str2 = this.a.jdField_a_of_type_JavaLangString;
        String str3 = this.a.c;
        if (this.a.jdField_a_of_type_JavaLangCharSequence == null) {}
        for (String str1 = "";; str1 = this.a.jdField_a_of_type_JavaLangCharSequence.toString())
        {
          bcef.b(null, "dc00898", "", str2, "auth_page", "left_delete", 0, 0, "", "", str3, str1);
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
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.3
 * JD-Core Version:    0.7.0.1
 */