package com.tencent.mobileqq.app.upgrade;

import ajgd;
import ajnl;
import akgo;
import akgu;
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
  public UpgradeController$2(akgo paramakgo, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((akgo.a(this.this$0) == null) || (akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig == null) || (akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog == null)) {
      QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }
    Object localObject;
    Intent localIntent;
    boolean bool;
    do
    {
      return;
      localObject = akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog;
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((ajnl)localObject).jdField_b_of_type_JavaLangString);
      localIntent.putExtra("StrUpgradeDesc", ((ajnl)localObject).c);
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("strDesc", ((ajnl)localObject).d);
      }
      localIntent.putExtra("lBtnText", ((ajnl)localObject).i);
      localIntent.putExtra("rBtnText", ((ajnl)localObject).j);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", akgo.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("iTipsType", akgo.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType);
      localIntent.putExtra("strConfirmBtnText", akgo.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", akgo.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", akgo.a(this.this$0).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId);
      if ((akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig != null) && (akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog != null)) {
        localIntent.putExtra("rate", akgo.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppNewUpgradeConfig.dialog.jdField_b_of_type_Int);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = localIntent;
        return;
      }
      localObject = akgu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!((akgu)localObject).a()) {
        break;
      }
      bool = ((akgu)localObject).b(akgo.a(this.this$0));
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
      bool = ((akgu)localObject).a(akgo.a(this.this$0));
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