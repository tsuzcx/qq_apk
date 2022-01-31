import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class angt
  extends batl
{
  angt(angs paramangs) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    anfj localanfj = this.a.a();
    Bundle localBundle = parambatm.a();
    if (parambatm.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localanfj.a(localBundle, parambatm, bool, parambatm.a, parambatm.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(batm parambatm)
  {
    Object localObject = parambatm.a();
    int i = ((Bundle)localObject).getInt(parambatm.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambatm);
    }
    if (parambatm.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambatm.a);
      if (anfj.a(i)) {
        anfj.a.a((EmoticonPackage)localObject, i, -1, parambatm.a);
      }
      bapm.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambatm.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      anfj localanfj = this.a.a();
      if (anfj.a(i)) {
        anfj.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localanfj.b(parambatm);
        return;
        if (i == 7) {
          localanfj.a(parambatm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     angt
 * JD-Core Version:    0.7.0.1
 */