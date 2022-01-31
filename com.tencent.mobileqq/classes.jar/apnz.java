import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class apnz
  implements aplg
{
  apnz(apnm paramapnm) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkp.a();
    azqt localazqt = bakj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(apnm.a(this.a))) && (localazqt.a != null)) {
      apnm.a(this.a, localazqt.a.toString());
    }
    azpt localazpt = new azpt(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localazqt.b == 3) || (localazqt.b == 2)) && (localazqt.a != null)) {
      localazpt.a(localazqt.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Apkp.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bakj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(apnm.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(apnm.a(this.a)));
      apnm.a(this.a, (azqt)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnz
 * JD-Core Version:    0.7.0.1
 */