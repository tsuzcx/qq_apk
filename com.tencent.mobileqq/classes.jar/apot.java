import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apot
  extends bdvu
{
  apot(apos paramapos) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    apnf localapnf = this.a.a();
    Bundle localBundle = parambdvv.a();
    if (parambdvv.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localapnf.a(localBundle, parambdvv, bool, parambdvv.a, parambdvv.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    Object localObject = parambdvv.a();
    int i = ((Bundle)localObject).getInt(parambdvv.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambdvv);
    }
    if (parambdvv.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambdvv.a);
      if (apnf.a(i)) {
        apnf.a.a((EmoticonPackage)localObject, i, -1, parambdvv.a);
      }
      bdqr.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambdvv.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      apnf localapnf = this.a.a();
      if (apnf.a(i)) {
        apnf.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localapnf.b(parambdvv);
        return;
        if (i == 7) {
          localapnf.a(parambdvv);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apot
 * JD-Core Version:    0.7.0.1
 */