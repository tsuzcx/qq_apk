import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;

public class aomn
  implements aolv
{
  public aomn(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResDownloadComplete ;" + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.a(this.a, 100);
    ARScanEntryView.a(this.a).removeMessages(324);
    ARScanEntryView.a(this.a).sendEmptyMessage(324);
    this.a.k();
  }
  
  public void a(int paramInt)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResUpdateProgress " + paramInt + ";" + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.a(this.a, paramInt);
    ARScanEntryView.a(this.a);
  }
  
  public void b()
  {
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomn
 * JD-Core Version:    0.7.0.1
 */