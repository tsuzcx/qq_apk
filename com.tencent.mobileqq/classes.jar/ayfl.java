import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.OCRResultActivity;

public class ayfl
  implements bhyz
{
  public ayfl(OCRResultActivity paramOCRResultActivity) {}
  
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
    bdon.a(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    OCRResultActivity.a(this.a, paramString);
  }
  
  public void c(String paramString)
  {
    bdon.a(this.a, this.a.app, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfl
 * JD-Core Version:    0.7.0.1
 */