import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class auol
  implements QzoneZipCacheHelperCallBack
{
  public auol(QzoneGiftUtil.1 param1) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QzoneGiftUtil.1.a(this.a);
      QLog.i("QzoneGiftUtil", 1, "downloadGiftZip onResult mLoadSuccessTimes = " + QzoneGiftUtil.1.c(this.a) + " mLoadFailTimes = " + QzoneGiftUtil.1.d(this.a));
      if (this.a.a != null)
      {
        if (QzoneGiftUtil.1.c(this.a) != 3) {
          break label103;
        }
        this.a.a.a();
      }
    }
    label103:
    while (QzoneGiftUtil.1.c(this.a) + QzoneGiftUtil.1.d(this.a) != 3)
    {
      return;
      QzoneGiftUtil.1.b(this.a);
      break;
    }
    this.a.a.b();
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auol
 * JD-Core Version:    0.7.0.1
 */