import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity;

public class avvt
  implements bers
{
  public avvt(OCRResultActivity paramOCRResultActivity) {}
  
  public void a()
  {
    if (OCRResultActivity.a(this.a) == 0) {
      OCRResultActivity.a(this.a);
    }
    while (OCRResultActivity.a(this.a) != 1) {
      return;
    }
    OCRResultActivity.b(this.a);
  }
  
  public void a(String paramString)
  {
    banj.a(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    OCRResultActivity.a(this.a, paramString);
  }
  
  public void c(String paramString)
  {
    banj.a(this.a, this.a.app, paramString);
  }
  
  public void d(String paramString)
  {
    Intent localIntent = new Intent(this.a, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "OCR_RESULT");
    this.a.startActivityForResult(localIntent, 1);
    OCRResultActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvt
 * JD-Core Version:    0.7.0.1
 */