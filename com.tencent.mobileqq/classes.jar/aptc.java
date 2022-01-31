import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aptc
  extends bead
{
  aptc(aptb paramaptb) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    apro localapro = this.a.a();
    Bundle localBundle = parambeae.a();
    if (parambeae.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localapro.a(localBundle, parambeae, bool, parambeae.a, parambeae.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(beae parambeae)
  {
    Object localObject = parambeae.a();
    int i = ((Bundle)localObject).getInt(parambeae.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambeae);
    }
    if (parambeae.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambeae.a);
      if (apro.a(i)) {
        apro.a.a((EmoticonPackage)localObject, i, -1, parambeae.a);
      }
      bdva.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambeae.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      apro localapro = this.a.a();
      if (apro.a(i)) {
        apro.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localapro.b(parambeae);
        return;
        if (i == 7) {
          localapro.a(parambeae);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptc
 * JD-Core Version:    0.7.0.1
 */