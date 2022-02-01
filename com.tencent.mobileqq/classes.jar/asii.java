import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class asii
  extends bhyn
{
  asii(asih paramasih, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambhyo.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(asih.a(), 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambhyo.a());
      }
      if (parambhyo.a() != 3) {
        break label177;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = asiw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambhyo, bool);
      if (str != null)
      {
        QLog.e(asih.a(), 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambhyo.d);
        return;
      }
    }
    catch (Exception parambhyo)
    {
      QLog.e(asih.a(), 1, "json download fail", parambhyo);
      return;
    }
    asih.jdField_a_of_type_Asig.a(localEmoticonPackage, 0, localBundle);
    return;
    label177:
    QLog.e(asih.a(), 1, "jsonDownloadListener : ondone error , reportCode = " + parambhyo.a);
    asih.jdField_a_of_type_Asig.a(localEmoticonPackage, -1, localBundle);
    bhpl.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambhyo.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asii
 * JD-Core Version:    0.7.0.1
 */