import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class aowl
  implements aotu
{
  aowl(aovz paramaovz) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Aotf.a();
    ayqd localayqd = azjg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(aovz.a(this.a))) && (localayqd.a != null)) {
      aovz.a(this.a, localayqd.a.toString());
    }
    aypd localaypd = new aypd(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localayqd.b == 3) || (localayqd.b == 2)) && (localayqd.a != null)) {
      localaypd.a(localayqd.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Aotf.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = azjg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(aovz.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(aovz.a(this.a)));
      aovz.a(this.a, (ayqd)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aowl
 * JD-Core Version:    0.7.0.1
 */