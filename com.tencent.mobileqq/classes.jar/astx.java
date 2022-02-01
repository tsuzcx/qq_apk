import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class astx
  extends amop
{
  astx(astk paramastk) {}
  
  protected void a(becp parambecp, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Asqs.a().TroopUin != parambecp.b) {}
    while ((parambecp.a == null) || (astk.a(this.a) == null) || (!astk.a(this.a).equals(parambecp.a.toString())) || (this.a.jdField_a_of_type_Assw == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Assw.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Asqs.a();
    paramObject = (becp)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(astk.a(this.a)))
      {
        localObject = this.a.a((FileManagerEntity)localObject);
        if (((becp)localObject).a != null) {
          astk.a(this.a, ((becp)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (astk.a(this.a) == null) || (!astk.a(this.a).equals(paramObject.a.toString())));
    astk.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astx
 * JD-Core Version:    0.7.0.1
 */