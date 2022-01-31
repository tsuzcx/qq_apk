import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class auac
  extends aqna
{
  public auac(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    this.a.a.sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(aqnd paramaqnd)
  {
    this.a.a.obtainMessage(102, paramaqnd).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, aqnd paramaqnd)
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
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramaqnd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auac
 * JD-Core Version:    0.7.0.1
 */