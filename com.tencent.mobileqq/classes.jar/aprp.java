import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aprp
  extends bead
{
  aprp(apro paramapro, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(beae parambeae)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambeae.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambeae.a());
      }
      if (parambeae.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = apsd.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambeae, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambeae.d);
        return;
      }
    }
    catch (Exception parambeae)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambeae);
      return;
    }
    apro.jdField_a_of_type_Aprn.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambeae.a);
    apro.jdField_a_of_type_Aprn.a(localEmoticonPackage, -1, localBundle);
    bdva.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambeae.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprp
 * JD-Core Version:    0.7.0.1
 */