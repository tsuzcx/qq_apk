package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderActivity$3$1
  implements Runnable
{
  ServiceAccountFolderActivity$3$1(ServiceAccountFolderActivity.3 param3, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity$3.a.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "updateUnreadNumOnTitleBar->unread num:" + this.jdField_a_of_type_Int);
      }
      return;
      if (this.jdField_a_of_type_Int > 99)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity$3.a.setText("99+");
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity$3.a.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity$3.a.setText(String.valueOf(this.jdField_a_of_type_Int));
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity$3.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity.3.1
 * JD-Core Version:    0.7.0.1
 */