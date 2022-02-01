import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;

class bflz
  implements atiw
{
  bflz(bfly parambfly) {}
  
  public void a()
  {
    QLog.i("TroopFileTransferMgr", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName + "]");
    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 0) {
      this.a.jdField_a_of_type_Bflv.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, 106);
    }
    bfoh.a().a(bflv.e(this.a.jdField_a_of_type_Bflv), this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
  }
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkPackageName = paramAppDetail.packageName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkName = paramAppDetail.appName;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.yybApkIconUrl = paramAppDetail.iconUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflz
 * JD-Core Version:    0.7.0.1
 */