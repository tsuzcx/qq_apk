import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aslr
  extends biht
{
  aslr(aslq paramaslq) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    askd localaskd = this.a.a();
    Bundle localBundle = parambihu.a();
    if (parambihu.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localaskd.a(localBundle, parambihu, bool, parambihu.a, parambihu.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bihu parambihu)
  {
    Object localObject = parambihu.a();
    int i = ((Bundle)localObject).getInt(parambihu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambihu);
    }
    if (parambihu.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambihu.a);
      if (askd.a(i)) {
        askd.a.a((EmoticonPackage)localObject, i, -1, parambihu.a);
      }
      biah.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambihu.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      askd localaskd = this.a.a();
      if (askd.a(i)) {
        askd.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localaskd.b(parambihu);
        return;
        if (i == 7) {
          localaskd.a(parambihu);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslr
 * JD-Core Version:    0.7.0.1
 */