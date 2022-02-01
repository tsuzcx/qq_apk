import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.qphone.base.util.QLog;

public class apgm
  implements View.OnTouchListener
{
  public apgm(ScanEntryProviderContainerView paramScanEntryProviderContainerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, String.format("dispatchTouchEvent onTabClickListener", new Object[0]));
    }
    long l = System.currentTimeMillis();
    if (l - ScanEntryProviderContainerView.a(this.a) <= 1000L) {
      QLog.i("ScanEntryProviderContainerView", 1, "avoid user fast click");
    }
    do
    {
      return false;
      ScanEntryProviderContainerView.a(this.a, l);
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      }
      paramView = (Integer)paramView.getTag();
      ScanEntryProviderContainerView.a(this.a).a(paramView.intValue(), new apgn(this, paramView));
    } while (paramView.intValue() != 2);
    bcst.b(null, "dc00898", "", "", "0X800A9CE", "0X800A9CE", 0, 0, "", "0", "0", "");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgm
 * JD-Core Version:    0.7.0.1
 */