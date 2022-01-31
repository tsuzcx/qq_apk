import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;

public class ancy
  implements anbt
{
  public ancy(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResDownLoadComplete " + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.b(this.a, 100);
    if ((ARScanEntryView.a(this.a).a != null) && (ARScanEntryView.a(this.a).a.a != null)) {
      ARScanEntryView.a(this.a).a.a.a();
    }
    if (ARScanEntryView.a(this.a) != null)
    {
      ARScanEntryView.a(this.a).removeMessages(324);
      ARScanEntryView.a(this.a).sendEmptyMessage(324);
    }
    if ((ARScanEntryView.b(this.a)) && (this.a.a.a().a()))
    {
      ARScanEntryView.b(this.a);
      QLog.d("AREngine_ARScanEntryView", 1, "everything is ready,so quit update resources");
      return;
    }
    this.a.k();
  }
  
  public void a(int paramInt)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResUpdateProgress " + paramInt + ";" + this.a.m);
    if (!this.a.m) {
      return;
    }
    ARScanEntryView.b(this.a, paramInt);
    ARScanEntryView.a(this.a);
  }
  
  public void b()
  {
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancy
 * JD-Core Version:    0.7.0.1
 */