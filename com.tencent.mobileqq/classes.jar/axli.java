import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class axli
  extends atvu
{
  public axli(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    this.a.a.sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(atvx paramatvx)
  {
    this.a.a.obtainMessage(102, paramatvx).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, atvx paramatvx)
  {
    if (!OCRPerformFragment.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "onPicOcrResult other!");
      }
      return;
    }
    this.a.a.removeMessages(101);
    OCRPerformFragment.a(this.a, false);
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramatvx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axli
 * JD-Core Version:    0.7.0.1
 */