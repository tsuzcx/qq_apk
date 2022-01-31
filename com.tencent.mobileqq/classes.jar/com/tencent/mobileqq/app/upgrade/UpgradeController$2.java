package com.tencent.mobileqq.app.upgrade;

import ajuf;
import akbv;
import akva;
import akvg;
import android.content.Intent;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NewUpgradeConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

public class UpgradeController$2
  implements Runnable
{
  public UpgradeController$2(akva paramakva, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((akva.a(this.this$0) == null) || (akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Object localObject;
    Intent localIntent;
    boolean bool;
    do
    {
      return;
      localObject = akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((akbv)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((akbv)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((akbv)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((akbv)localObject).i);
      localIntent.putExtra("rBtnText", ((akbv)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", akva.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig != null) && (akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", akva.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ajuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = localIntent;
        return;
      }
      localObject = akvg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!((akvg)localObject).a()) {
        break;
      }
      bool = ((akvg)localObject).b(akva.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, new Object[] { "run: invoked. ", " needShowInstallDialog: ", Boolean.valueOf(bool) });
      }
    } while (!bool);
    do
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = null;
      if (BaseActivity.sTopActivity == null) {
        break;
      }
      BaseActivity.sTopActivity.startActivity(localIntent);
      return;
      bool = ((akvg)localObject).a(akva.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, new Object[] { "run: invoked. ", " needShowDownloadDialog: ", Boolean.valueOf(bool) });
      }
    } while (bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.upgrade.UpgradeController.2
 * JD-Core Version:    0.7.0.1
 */