import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apng
  extends bdvu
{
  apng(apnf paramapnf, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambdvv.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambdvv.a());
      }
      if (parambdvv.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = apnu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdvv, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambdvv.d);
        return;
      }
    }
    catch (Exception parambdvv)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambdvv);
      return;
    }
    apnf.jdField_a_of_type_Apne.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambdvv.a);
    apnf.jdField_a_of_type_Apne.a(localEmoticonPackage, -1, localBundle);
    bdqr.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambdvv.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apng
 * JD-Core Version:    0.7.0.1
 */