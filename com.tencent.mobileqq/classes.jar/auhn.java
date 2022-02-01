import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class auhn
  extends anua
{
  auhn(auha paramauha) {}
  
  protected void a(bftf parambftf, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Auei.a().TroopUin != parambftf.b) {}
    while ((parambftf.a == null) || (auha.a(this.a) == null) || (!auha.a(this.a).equals(parambftf.a.toString())) || (this.a.jdField_a_of_type_Augm == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Augm.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Auei.a();
    paramObject = (bftf)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(auha.a(this.a)))
      {
        localObject = this.a.a((FileManagerEntity)localObject);
        if (((bftf)localObject).a != null) {
          auha.a(this.a, ((bftf)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (auha.a(this.a) == null) || (!auha.a(this.a).equals(paramObject.a.toString())));
    auha.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhn
 * JD-Core Version:    0.7.0.1
 */