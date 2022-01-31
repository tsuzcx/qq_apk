import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anfk
  extends batl
{
  anfk(anfj paramanfj, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(batm parambatm)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambatm.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambatm.a());
      }
      if (parambatm.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = anfy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambatm, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambatm.d);
        return;
      }
    }
    catch (Exception parambatm)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambatm);
      return;
    }
    anfj.jdField_a_of_type_Anfi.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambatm.a);
    anfj.jdField_a_of_type_Anfi.a(localEmoticonPackage, -1, localBundle);
    bapm.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambatm.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfk
 * JD-Core Version:    0.7.0.1
 */