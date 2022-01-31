import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class apod
  implements aplk
{
  apod(apnq paramapnq) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkt.a();
    azqv localazqv = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(apnq.a(this.a))) && (localazqv.a != null)) {
      apnq.a(this.a, localazqv.a.toString());
    }
    azpv localazpv = new azpv(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localazqv.b == 3) || (localazqv.b == 2)) && (localazqv.a != null)) {
      localazpv.a(localazqv.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Apkt.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(apnq.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(apnq.a(this.a)));
      apnq.a(this.a, (azqv)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apod
 * JD-Core Version:    0.7.0.1
 */