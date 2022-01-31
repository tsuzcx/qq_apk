import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class avrg
  extends asfo
{
  public avrg(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    this.a.a.sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(asfr paramasfr)
  {
    this.a.a.obtainMessage(102, paramasfr).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, asfr paramasfr)
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
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramasfr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrg
 * JD-Core Version:    0.7.0.1
 */