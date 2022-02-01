import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import java.util.List;

class axlc
  extends axld
{
  axlc(axlb paramaxlb) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    paramList = this.a.a(paramList);
    axkz localaxkz = (axkz)this.a.a.getBusinessHandler(113);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      localaxkz.notifyUI(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlc
 * JD-Core Version:    0.7.0.1
 */