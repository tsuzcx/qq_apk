import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anxc
  extends bbwf
{
  anxc(anxb paramanxb) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    anvs localanvs = this.a.a();
    Bundle localBundle = parambbwg.a();
    if (parambbwg.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localanvs.a(localBundle, parambbwg, bool, parambbwg.a, parambbwg.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    Object localObject = parambbwg.a();
    int i = ((Bundle)localObject).getInt(parambbwg.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambbwg);
    }
    if (parambbwg.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambbwg.a);
      if (anvs.a(i)) {
        anvs.a.a((EmoticonPackage)localObject, i, -1, parambbwg.a);
      }
      bbrj.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambbwg.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      anvs localanvs = this.a.a();
      if (anvs.a(i)) {
        anvs.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localanvs.b(parambbwg);
        return;
        if (i == 7) {
          localanvs.a(parambbwg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxc
 * JD-Core Version:    0.7.0.1
 */