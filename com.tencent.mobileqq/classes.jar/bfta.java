import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Scroller;
import com.tencent.widget.MovingView;

public class bfta
  extends Handler
{
  public bfta(MovingView paramMovingView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if ((this.a.jdField_a_of_type_Boolean) && (!this.a.jdField_b_of_type_Boolean)) {}
    }
    while (paramMessage.what != 2)
    {
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        int i = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        int j = this.a.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        int k = this.a.c;
        int m = this.a.d;
        this.a.c = i;
        this.a.d = j;
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Int += i - k;
        paramMessage = this.a;
        paramMessage.jdField_b_of_type_Int += j - m;
        this.a.invalidate();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 40L);
        return;
      }
      this.a.a();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfta
 * JD-Core Version:    0.7.0.1
 */