import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class apny
  extends ajta
{
  apny(apnm paramapnm) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Apkp.a();
    paramObject = (azqt)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(apnm.a(this.a)))
      {
        localObject = bakj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((azqt)localObject).a != null) {
          apnm.a(this.a, ((azqt)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (apnm.a(this.a) == null) || (!apnm.a(this.a).equals(paramObject.a.toString())));
    apnm.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apny
 * JD-Core Version:    0.7.0.1
 */