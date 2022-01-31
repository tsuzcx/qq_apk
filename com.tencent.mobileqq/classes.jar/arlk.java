import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class arlk
  extends alpa
{
  arlk(arkz paramarkz) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Arhz.a();
    paramObject = (bbtn)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(arkz.a(this.a)))
      {
        localObject = bcnt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((bbtn)localObject).a != null) {
          arkz.a(this.a, ((bbtn)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (arkz.a(this.a) == null) || (!arkz.a(this.a).equals(paramObject.a.toString())));
    arkz.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlk
 * JD-Core Version:    0.7.0.1
 */