import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class avvp
  extends asjx
{
  public avvp(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    this.a.a.sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(aska paramaska)
  {
    this.a.a.obtainMessage(102, paramaska).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, aska paramaska)
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
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramaska));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvp
 * JD-Core Version:    0.7.0.1
 */