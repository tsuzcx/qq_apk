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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a) != -1L)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          LoginDevItem localLoginDevItem = (LoginDevItem)((Iterator)localObject).next();
          if (localLoginDevItem.a == QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a)) {
            localLoginDevItem.c = QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a);
          }
        }
      }
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a) != null) {
        QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a).a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity$6.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */