package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter;
import com.tencent.biz.qrcode.logindev.LoginDevItem;
import java.util.Iterator;
import java.util.List;

class QRLoginMgrActivity$6$1
  implements Runnable
{
  QRLoginMgrActivity$6$1(QRLoginMgrActivity.6 param6, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          LoginDevItem localLoginDevItem = (LoginDevItem)localIterator.next();
          if (localLoginDevItem.a == QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a)) {
            localLoginDevItem.c = QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a).a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */