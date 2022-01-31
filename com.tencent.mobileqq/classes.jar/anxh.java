import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anxh
  extends bbwt
{
  anxh(anxg paramanxg) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    anvx localanvx = this.a.a();
    Bundle localBundle = parambbwu.a();
    if (parambbwu.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localanvx.a(localBundle, parambbwu, bool, parambbwu.a, parambbwu.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    Object localObject = parambbwu.a();
    int i = ((Bundle)localObject).getInt(parambbwu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambbwu);
    }
    if (parambbwu.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambbwu.a);
      if (anvx.a(i)) {
        anvx.a.a((EmoticonPackage)localObject, i, -1, parambbwu.a);
      }
      bbrx.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambbwu.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      anvx localanvx = this.a.a();
      if (anvx.a(i)) {
        anvx.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localanvx.b(parambbwu);
        return;
        if (i == 7) {
          localanvx.a(parambbwu);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxh
 * JD-Core Version:    0.7.0.1
 */