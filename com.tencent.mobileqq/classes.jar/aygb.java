import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1;

public class aygb
  extends auqo
{
  public aygb(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void a(boolean paramBoolean, auqr paramauqr)
  {
    if (!OCRResultFragmentNew.a(this.a)) {
      return;
    }
    OCRResultFragmentNew.b(this.a, false);
    OCRResultFragmentNew.a(this.a).runOnUiThread(new OCRResultFragmentNew.10.1(this, paramBoolean, paramauqr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygb
 * JD-Core Version:    0.7.0.1
 */