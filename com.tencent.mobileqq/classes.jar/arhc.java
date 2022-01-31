import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class arhc
  implements arej
{
  arhc(argq paramargq) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Ardq.a();
    bbpe localbbpe = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(argq.a(this.a))) && (localbbpe.a != null)) {
      argq.a(this.a, localbbpe.a.toString());
    }
    bboe localbboe = new bboe(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localbbpe.b == 3) || (localbbpe.b == 2)) && (localbbpe.a != null)) {
      localbboe.a(localbbpe.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_Ardq.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(argq.a(this.a)))
    {
      localTroopFileTransferManager.a(UUID.fromString(argq.a(this.a)));
      argq.a(this.a, (bbpe)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhc
 * JD-Core Version:    0.7.0.1
 */