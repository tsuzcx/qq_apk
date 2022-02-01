import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;

class bfvl
  implements atsg
{
  bfvl(bfvk parambfvk) {}
  
  public void a()
  {
    QLog.i("TroopFileTransferMgr", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName + "]");
    if (bhnv.a(BaseApplication.getContext()) == 0) {
      this.a.jdField_a_of_type_Bfvh.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
    }
    bfxt.a().a(bfvh.e(this.a.jdField_a_of_type_Bfvh), this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkPackageName = paramAppDetail.packageName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName = paramAppDetail.appName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvl
 * JD-Core Version:    0.7.0.1
 */