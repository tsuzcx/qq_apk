import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class atye
  extends anrc
{
  atye(atxr paramatxr) {}
  
  protected void a(bfjs parambfjs, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.a.jdField_a_of_type_Atuz.a().TroopUin != parambfjs.b) {}
    while ((parambfjs.a == null) || (atxr.a(this.a) == null) || (!atxr.a(this.a).equals(parambfjs.a.toString())) || (this.a.jdField_a_of_type_Atxd == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Atxd.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_Atuz.a();
    paramObject = (bfjs)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.b) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(atxr.a(this.a)))
      {
        localObject = this.a.a((FileManagerEntity)localObject);
        if (((bfjs)localObject).a != null) {
          atxr.a(this.a, ((bfjs)localObject).a.toString());
        }
      }
    } while ((paramObject.a == null) || (atxr.a(this.a) == null) || (!atxr.a(this.a).equals(paramObject.a.toString())));
    atxr.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atye
 * JD-Core Version:    0.7.0.1
 */