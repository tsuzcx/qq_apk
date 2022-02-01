import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aptx
  implements View.OnClickListener
{
  public aptx(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1;
    if (QRScanEntryView.a(this.a))
    {
      Object localObject = apsa.a();
      if (!QRScanEntryView.b(this.a))
      {
        bool1 = true;
        if (((apsa)localObject).a(bool1))
        {
          localObject = this.a;
          if (QRScanEntryView.b(this.a)) {
            break label131;
          }
          bool1 = true;
          label56:
          QRScanEntryView.a((QRScanEntryView)localObject, bool1);
          localObject = (apsf)this.a.a;
          bool1 = bool2;
          if (!QRScanEntryView.b(this.a)) {
            bool1 = true;
          }
          ((apsf)localObject).a(bool1, 0L);
          QRScanEntryView.a(this.a, true);
          QRScanEntryView.b(this.a, QRScanEntryView.b(this.a));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
      label131:
      bool1 = false;
      break label56;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptx
 * JD-Core Version:    0.7.0.1
 */