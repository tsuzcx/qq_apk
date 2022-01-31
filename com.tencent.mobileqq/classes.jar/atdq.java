import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import java.util.List;

class atdq
  extends atdr
{
  atdq(atdp paramatdp) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    paramList = this.a.a(paramList);
    atdn localatdn = (atdn)this.a.a.a(113);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      localatdn.notifyUI(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdq
 * JD-Core Version:    0.7.0.1
 */