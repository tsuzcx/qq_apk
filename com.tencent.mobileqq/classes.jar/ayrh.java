import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import java.util.List;

class ayrh
  extends ayri
{
  ayrh(ayrg paramayrg) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList)
  {
    paramList = this.a.a(paramList);
    ayre localayre = (ayre)this.a.a.getBusinessHandler(BusinessHandlerFactory.OCR_HANDLER);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      localayre.notifyUI(3, paramBoolean, new Object[] { Integer.valueOf(i), paramString, paramList });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrh
 * JD-Core Version:    0.7.0.1
 */