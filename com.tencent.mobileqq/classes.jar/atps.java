import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atps
  extends anif
{
  atps(atpf paramatpf) {}
  
  protected void a(bety parambety, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Atmn.a().TroopUin != parambety.b) {}
    while ((parambety.a == null) || (atpf.a(this.a) == null) || (!atpf.a(this.a).equals(parambety.a.toString())) || (this.a.jdField_a_of_type_Ator == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Ator.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Atmn.a();
    paramObject = (bety)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(atpf.a(this.a)))
      {
        localObject = this.a.a((FileManagerEntity)localObject);
        if (((bety)localObject).a != null) {
          atpf.a(this.a, ((bety)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (atpf.a(this.a) == null) || (!atpf.a(this.a).equals(paramObject.a.toString())));
    atpf.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atps
 * JD-Core Version:    0.7.0.1
 */