import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aobf
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, aotc paramaotc)
  {
    String str1 = paramFileManagerEntity.getFilePath();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "open[" + str1 + "]");
    }
    if ((str1 != null) && (str1.lastIndexOf(".rename") > 0))
    {
      String str3 = str1.replace(".rename", "");
      String str2 = str3.substring(0, str3.lastIndexOf("."));
      str3 = str3.substring(str3.lastIndexOf(".")).replaceAll("[0-9]*", "").replace("(", "").replace(")", "");
      str2 = str2 + str3;
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe renmaed,realName[" + str2 + "]");
      }
      apbx.a(paramActivity, paramActivity.getString(2131627244), 2131627231, new aobg(str2, str1, paramFileManagerEntity, paramQQAppInterface, paramActivity, paramaotc));
      return;
    }
    if ((paramFileManagerEntity.nFileType == 5) && ((paramFileManagerEntity.isZipInnerFile) || (paramFileManagerEntity.nOpType == 190)))
    {
      apbx.a(paramActivity, paramActivity.getString(2131627244), 2131627212, new aobh(paramActivity, paramFileManagerEntity));
      return;
    }
    apck.a(paramActivity, paramFileManagerEntity.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobf
 * JD-Core Version:    0.7.0.1
 */