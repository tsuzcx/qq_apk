import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class ayvh
  implements ITransCallbackForReport
{
  public ayvh(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    ShortVideoUploadProcessor localShortVideoUploadProcessor = this.a;
    paramInt = this.a.j;
    String str2 = this.a.d;
    if (this.a.f == null) {}
    for (String str1 = this.a.l;; str1 = this.a.f)
    {
      localShortVideoUploadProcessor.a("actRichMediaNetMonitor_videoUp", false, paramInt, paramString1, paramString2, str2, str1, this.a.x + "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvh
 * JD-Core Version:    0.7.0.1
 */