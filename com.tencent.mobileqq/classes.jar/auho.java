import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class auho
  implements aufb
{
  auho(auha paramauha) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Auei.a();
    bftf localbftf = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(auha.a(this.a))) && (localbftf.a != null)) {
      auha.a(this.a, localbftf.a.toString());
    }
    bfsf localbfsf = new bfsf(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbftf.b == 3) || (localbftf.b == 2)) && (localbftf.a != null)) {
      localbfsf.a(localbftf.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Auei.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(auha.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(auha.a(this.a)));
      auha.a(this.a, (bftf)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auho
 * JD-Core Version:    0.7.0.1
 */