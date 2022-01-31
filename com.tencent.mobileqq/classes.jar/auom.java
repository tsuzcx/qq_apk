import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class auom
  implements axxi
{
  auom(QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack) {}
  
  public void a(axxh paramaxxh)
  {
    QLog.i("QzoneGiftUtil", 1, "onPreDownloadStart");
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq != null)
    {
      if (paramaxsq.a == 0)
      {
        this.a.onResult(true);
        QLog.i("QzoneGiftUtil", 1, "onResp download res file, success.");
      }
      while (paramaxsq.a != 1) {
        return;
      }
      this.a.onResult(false);
      QLog.e("QzoneGiftUtil", 1, "onResp download res file, fail.");
      return;
    }
    QLog.e("QzoneGiftUtil", 1, "downloadFile onResp = null");
    this.a.onResult(false);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auom
 * JD-Core Version:    0.7.0.1
 */