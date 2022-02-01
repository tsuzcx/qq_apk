import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class atpt
  implements atng
{
  atpt(atpf paramatpf) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Atmn.a();
    bety localbety = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(atpf.a(this.a))) && (localbety.a != null)) {
      atpf.a(this.a, localbety.a.toString());
    }
    besy localbesy = new besy(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbety.b == 3) || (localbety.b == 2)) && (localbety.a != null)) {
      localbesy.a(localbety.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Atmn.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(atpf.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(atpf.a(this.a)));
      atpf.a(this.a, (bety)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpt
 * JD-Core Version:    0.7.0.1
 */