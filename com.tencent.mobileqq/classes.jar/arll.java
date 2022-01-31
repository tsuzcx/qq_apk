import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class arll
  implements aris
{
  arll(arkz paramarkz) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Arhz.a();
    bbtn localbbtn = bcnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(arkz.a(this.a))) && (localbbtn.a != null)) {
      arkz.a(this.a, localbbtn.a.toString());
    }
    bbsn localbbsn = new bbsn(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbbtn.b == 3) || (localbbtn.b == 2)) && (localbbtn.a != null)) {
      localbbsn.a(localbbtn.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Arhz.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bcnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(arkz.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(arkz.a(this.a)));
      arkz.a(this.a, (bbtn)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arll
 * JD-Core Version:    0.7.0.1
 */