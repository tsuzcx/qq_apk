import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aruq
  extends bhhe
{
  aruq(arup paramarup, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhhf parambhhf)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambhhf.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambhhf.a());
      }
      if (parambhhf.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = arve.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambhhf, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambhhf.d);
        return;
      }
    }
    catch (Exception parambhhf)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambhhf);
      return;
    }
    arup.jdField_a_of_type_Aruo.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambhhf.a);
    arup.jdField_a_of_type_Aruo.a(localEmoticonPackage, -1, localBundle);
    bhab.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambhhf.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruq
 * JD-Core Version:    0.7.0.1
 */