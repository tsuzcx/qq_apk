import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class apoc
  extends ajsy
{
  apoc(apnq paramapnq) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Apkt.a();
    paramObject = (azqv)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(apnq.a(this.a)))
      {
        localObject = bakx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((azqv)localObject).a != null) {
          apnq.a(this.a, ((azqv)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (apnq.a(this.a) == null) || (!apnq.a(this.a).equals(paramObject.a.toString())));
    apnq.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoc
 * JD-Core Version:    0.7.0.1
 */