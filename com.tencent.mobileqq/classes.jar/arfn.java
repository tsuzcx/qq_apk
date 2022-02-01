import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class arfn
  extends bgod
{
  arfn(arfm paramarfm) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    areb localareb = this.a.a();
    Bundle localBundle = parambgoe.a();
    if (parambgoe.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localareb.a(localBundle, parambgoe, bool, parambgoe.a, parambgoe.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    Object localObject = parambgoe.a();
    int i = ((Bundle)localObject).getInt(parambgoe.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambgoe);
    }
    if (parambgoe.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambgoe.a);
      if (areb.a(i)) {
        areb.a.a((EmoticonPackage)localObject, i, -1, parambgoe.a);
      }
      bggr.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambgoe.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      areb localareb = this.a.a();
      if (areb.a(i)) {
        areb.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localareb.b(parambgoe);
        return;
        if (i == 7) {
          localareb.a(parambgoe);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfn
 * JD-Core Version:    0.7.0.1
 */