import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class bgga
  implements bgfw
{
  bgga(bgfz parambgfz) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = bgfu.a().a();
      String str2 = bgfu.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("TroopGameCardResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        bgfz.a(this.a).b(110);
        return;
      }
      this.a.a(new bggc(str1, str2));
      return;
    }
    bgfz.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgga
 * JD-Core Version:    0.7.0.1
 */