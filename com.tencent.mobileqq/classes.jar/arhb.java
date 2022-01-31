import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class arhb
  extends alkl
{
  arhb(argq paramargq) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Ardq.a();
    paramObject = (bbpe)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(argq.a(this.a)))
      {
        localObject = bcjk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((bbpe)localObject).a != null) {
          argq.a(this.a, ((bbpe)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (argq.a(this.a) == null) || (!argq.a(this.a).equals(paramObject.a.toString())));
    argq.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhb
 * JD-Core Version:    0.7.0.1
 */