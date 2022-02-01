import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class arwd
  extends bhhe
{
  arwd(arwc paramarwc) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    arup localarup = this.a.a();
    Bundle localBundle = parambhhf.a();
    if (parambhhf.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localarup.a(localBundle, parambhhf, bool, parambhhf.a, parambhhf.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    Object localObject = parambhhf.a();
    int i = ((Bundle)localObject).getInt(parambhhf.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambhhf);
    }
    if (parambhhf.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambhhf.a);
      if (arup.a(i)) {
        arup.a.a((EmoticonPackage)localObject, i, -1, parambhhf.a);
      }
      bhab.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambhhf.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      arup localarup = this.a.a();
      if (arup.a(i)) {
        arup.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localarup.b(parambhhf);
        return;
        if (i == 7) {
          localarup.a(parambhhf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwd
 * JD-Core Version:    0.7.0.1
 */