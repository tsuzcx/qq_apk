import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class axjz
  implements QzoneZipCacheHelperCallBack
{
  public axjz(QzoneGiftUtil.1 param1) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QzoneGiftUtil.1.a(this.a);
      QLog.i("QzoneGiftUtil", 1, "downloadGiftZip onResult mLoadSuccessTimes = " + QzoneGiftUtil.1.c(this.a) + " mLoadFailTimes = " + QzoneGiftUtil.1.d(this.a));
      if (this.a.jdField_a_of_type_Axkb != null)
      {
        if (QzoneGiftUtil.1.c(this.a) != this.a.jdField_a_of_type_Int) {
          break label109;
        }
        this.a.jdField_a_of_type_Axkb.a();
      }
    }
    label109:
    while (QzoneGiftUtil.1.c(this.a) + QzoneGiftUtil.1.d(this.a) != this.a.jdField_a_of_type_Int)
    {
      return;
      QzoneGiftUtil.1.b(this.a);
      break;
    }
    this.a.jdField_a_of_type_Axkb.b();
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjz
 * JD-Core Version:    0.7.0.1
 */