package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.CheckPermission.SDCardPermissionCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DBFixMsgSendCallback$1
  implements CheckPermission.SDCardPermissionCallback
{
  DBFixMsgSendCallback$1(DBFixMsgSendCallback paramDBFixMsgSendCallback, QQAppInterface paramQQAppInterface, File paramFile) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputSendDBFixMsgSendCallback.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaIoFile);
  }
  
  public void b()
  {
    QLog.d("DBFixMsgSendCallback", 1, "no sdCard Permission");
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "拷贝失败，没有权限！", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback.1
 * JD-Core Version:    0.7.0.1
 */