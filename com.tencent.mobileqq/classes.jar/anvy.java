import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anvy
  extends bbwt
{
  anvy(anvx paramanvx, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambbwu.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambbwu.a());
      }
      if (parambbwu.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = anwm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbwu, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambbwu.d);
        return;
      }
    }
    catch (Exception parambbwu)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambbwu);
      return;
    }
    anvx.jdField_a_of_type_Anvw.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambbwu.a);
    anvx.jdField_a_of_type_Anvw.a(localEmoticonPackage, -1, localBundle);
    bbrx.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambbwu.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvy
 * JD-Core Version:    0.7.0.1
 */