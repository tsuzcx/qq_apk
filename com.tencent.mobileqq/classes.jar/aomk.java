import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.qphone.base.util.QLog;

public class aomk
  implements MessageQueue.IdleHandler
{
  public aomk(ARScanEntryView paramARScanEntryView) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "queueIdle called ");
    }
    if ((ARScanEntryView.a(this.a) != null) && (this.a.m)) {
      ARScanEntryView.a(this.a).c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomk
 * JD-Core Version:    0.7.0.1
 */