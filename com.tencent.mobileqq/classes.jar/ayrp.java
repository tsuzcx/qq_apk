import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.OCRPerformFragment.6.1;
import com.tencent.qphone.base.util.QLog;

public class ayrp
  extends avau
{
  public ayrp(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a()
  {
    OCRPerformFragment.a(this.a).sendEmptyMessageDelayed(101, 60000L);
  }
  
  public void a(avaw paramavaw)
  {
    OCRPerformFragment.a(this.a).obtainMessage(102, paramavaw).sendToTarget();
  }
  
  protected void a(boolean paramBoolean, avaw paramavaw)
  {
    if ((!OCRPerformFragment.a(this.a)) || (OCRPerformFragment.a(this.a) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "onPicOcrResult other! or mActivity null");
      }
      return;
    }
    OCRPerformFragment.a(this.a).removeMessages(101);
    OCRPerformFragment.a(this.a, false);
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.6.1(this, paramBoolean, paramavaw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrp
 * JD-Core Version:    0.7.0.1
 */