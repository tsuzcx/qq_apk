import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aske
  extends biht
{
  aske(askd paramaskd, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambihu.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(askd.a(), 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambihu.a());
      }
      if (parambihu.a() != 3) {
        break label177;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = asks.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambihu, bool);
      if (str != null)
      {
        QLog.e(askd.a(), 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambihu.d);
        return;
      }
    }
    catch (Exception parambihu)
    {
      QLog.e(askd.a(), 1, "json download fail", parambihu);
      return;
    }
    askd.jdField_a_of_type_Askc.a(localEmoticonPackage, 0, localBundle);
    return;
    label177:
    QLog.e(askd.a(), 1, "jsonDownloadListener : ondone error , reportCode = " + parambihu.a);
    askd.jdField_a_of_type_Askc.a(localEmoticonPackage, -1, localBundle);
    biah.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambihu.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aske
 * JD-Core Version:    0.7.0.1
 */