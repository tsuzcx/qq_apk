import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import cooperation.qzone.share.QZoneShareActivity;

public class bjrl
  implements View.OnTouchListener
{
  public bjrl(QZoneShareActivity paramQZoneShareActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.a();
    if ((!this.a.c) && (this.a.a != null))
    {
      this.a.a.setHint("");
      this.a.c = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrl
 * JD-Core Version:    0.7.0.1
 */