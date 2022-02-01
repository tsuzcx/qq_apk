import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class asjt
  extends bhyn
{
  asjt(asjs paramasjs) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    asih localasih = this.a.a();
    Bundle localBundle = parambhyo.a();
    if (parambhyo.a() != 3) {}
    for (boolean bool = true;; bool = false)
    {
      long l1 = System.currentTimeMillis();
      long l2 = localBundle.getLong("vas_download_start");
      localasih.a(localBundle, parambhyo, bool, parambhyo.a, parambhyo.d, l1 - l2, 0);
      return;
    }
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    Object localObject = parambhyo.a();
    int i = ((Bundle)localObject).getInt(parambhyo.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d("VasEmojiManager", 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + parambhyo);
    }
    if (parambhyo.a != 0)
    {
      QLog.e("VasEmojiManager", 1, "onDoneFile : ondone error , reportCode = " + parambhyo.a);
      if (asih.a(i)) {
        asih.a.a((EmoticonPackage)localObject, i, -1, parambhyo.a);
      }
      bhpl.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", parambhyo.a + "", "", "", "");
    }
    for (;;)
    {
      return;
      asih localasih = this.a.a();
      if (asih.a(i)) {
        asih.a.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        localasih.b(parambhyo);
        return;
        if (i == 7) {
          localasih.a(parambhyo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjt
 * JD-Core Version:    0.7.0.1
 */