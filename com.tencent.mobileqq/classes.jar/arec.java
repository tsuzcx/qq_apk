import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class arec
  extends bgod
{
  arec(areb paramareb, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bgoe parambgoe)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = parambgoe.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(areb.a(), 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + parambgoe.a());
      }
      if (parambgoe.a() != 3) {
        break label177;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = areq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambgoe, bool);
      if (str != null)
      {
        QLog.e(areb.a(), 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, parambgoe.d);
        return;
      }
    }
    catch (Exception parambgoe)
    {
      QLog.e(areb.a(), 1, "json download fail", parambgoe);
      return;
    }
    areb.jdField_a_of_type_Area.a(localEmoticonPackage, 0, localBundle);
    return;
    label177:
    QLog.e(areb.a(), 1, "jsonDownloadListener : ondone error , reportCode = " + parambgoe.a);
    areb.jdField_a_of_type_Area.a(localEmoticonPackage, -1, localBundle);
    bggr.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", parambgoe.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */