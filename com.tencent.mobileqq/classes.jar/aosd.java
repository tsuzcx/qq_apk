import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aosd
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, apkq paramapkq)
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
      aptt.a(paramActivity, paramActivity.getString(2131692883), 2131692870, new aose(str2, str1, paramFileManagerEntity, paramQQAppInterface, paramActivity, paramapkq));
      return;
    }
    if ((paramFileManagerEntity.nFileType == 5) && ((paramFileManagerEntity.isZipInnerFile) || (paramFileManagerEntity.nOpType == 190)))
    {
      aptt.a(paramActivity, paramActivity.getString(2131692883), 2131692851, new aosf(paramActivity, paramFileManagerEntity));
      return;
    }
    apug.a(paramActivity, paramFileManagerEntity.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosd
 * JD-Core Version:    0.7.0.1
 */