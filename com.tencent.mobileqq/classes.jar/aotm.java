import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.qphone.base.util.QLog;

class aotm
  implements View.OnTouchListener
{
  aotm(aotl paramaotl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        aotl.a(this.a).setAlpha(0.5F);
        return true;
        aotl.a(this.a).setAlpha(1.0F);
        if (!aotl.a(this.a))
        {
          aotc.a(true);
          aotl.a(this.a, true);
        }
        aotl.a(this.a).setVisibility(8);
        aotl.a(this.a).clearAnimation();
      } while (aotl.a(this.a) == null);
      aotl.a(this.a).g();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */