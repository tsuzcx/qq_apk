import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class asty
  implements asrl
{
  asty(astk paramastk) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Asqs.a();
    becp localbecp = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(astk.a(this.a))) && (localbecp.a != null)) {
      astk.a(this.a, localbecp.a.toString());
    }
    bebp localbebp = new bebp(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbecp.b == 3) || (localbecp.b == 2)) && (localbecp.a != null)) {
      localbebp.a(localbecp.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Asqs.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(astk.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(astk.a(this.a)));
      astk.a(this.a, (becp)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asty
 * JD-Core Version:    0.7.0.1
 */