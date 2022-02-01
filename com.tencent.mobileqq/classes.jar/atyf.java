import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class atyf
  implements atvs
{
  atyf(atxr paramatxr) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Atuz.a();
    bfjs localbfjs = this.a.a(localFileManagerEntity);
    if ((TextUtils.isEmpty(atxr.a(this.a))) && (localbfjs.a != null)) {
      atxr.a(this.a, localbfjs.a.toString());
    }
    bfis localbfis = new bfis(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbfjs.b == 3) || (localbfjs.b == 2)) && (localbfjs.a != null)) {
      localbfis.a(localbfjs.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Atuz.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = this.a.a((FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(atxr.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(atxr.a(this.a)));
      atxr.a(this.a, (bfjs)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyf
 * JD-Core Version:    0.7.0.1
 */