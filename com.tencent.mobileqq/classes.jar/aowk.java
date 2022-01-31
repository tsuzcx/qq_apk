import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aowk
  extends ajey
{
  aowk(aovz paramaovz) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Aotf.a();
    paramObject = (ayqd)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(aovz.a(this.a)))
      {
        localObject = azjg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((ayqd)localObject).a != null) {
          aovz.a(this.a, ((ayqd)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (aovz.a(this.a) == null) || (!aovz.a(this.a).equals(paramObject.a.toString())));
    aovz.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aowk
 * JD-Core Version:    0.7.0.1
 */