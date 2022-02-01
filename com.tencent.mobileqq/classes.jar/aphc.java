import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;
import com.tencent.qphone.base.util.QLog;

class aphc
  implements View.OnTouchListener
{
  aphc(aphb paramaphb) {}
  
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
        aphb.a(this.a).setAlpha(0.5F);
        return true;
        aphb.a(this.a).setAlpha(1.0F);
        if (!aphb.a(this.a))
        {
          apgs.a(true);
          aphb.a(this.a, true);
        }
        aphb.a(this.a).setVisibility(8);
        aphb.a(this.a).clearAnimation();
      } while (aphb.a(this.a) == null);
      aphb.a(this.a).g();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphc
 * JD-Core Version:    0.7.0.1
 */