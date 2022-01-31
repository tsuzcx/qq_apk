import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anvt
  extends bbwf
{
  anvt(anvs paramanvs, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambbwg.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambbwg.a());
      }
      if (parambbwg.a() != 3) {
        break label189;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = anwh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbwg, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambbwg.d);
        return;
      }
    }
    catch (Exception parambbwg)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "json download fail", parambbwg);
      return;
    }
    anvs.jdField_a_of_type_Anvr.a(localEmoticonPackage, 0, localBundle);
    return;
    label189:
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + parambbwg.a);
    anvs.jdField_a_of_type_Anvr.a(localEmoticonPackage, -1, localBundle);
    bbrj.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambbwg.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvt
 * JD-Core Version:    0.7.0.1
 */