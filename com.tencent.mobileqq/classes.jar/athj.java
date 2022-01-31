import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

class athj
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  
  athj(athi paramathi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    athy localathy;
    float f2;
    float f1;
    if (athi.a(this.jdField_a_of_type_Athi) != null)
    {
      paramView = (athx)athi.a(this.jdField_a_of_type_Athi).getTag(2131297205);
      localathy = (athy)athi.a(this.jdField_a_of_type_Athi).getTag();
      if ((paramView != null) && (localathy != null))
      {
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
      }
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return true;
            this.jdField_a_of_type_Float = f2;
            this.b = f1;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          } while ((paramView.jdField_a_of_type_Int != 1) || (paramView.b != 2));
          localathy.a.setPressed(true);
          return true;
        } while ((paramView.jdField_a_of_type_Int != 1) || (paramView.b != 2));
        f2 -= this.jdField_a_of_type_Float;
        f1 -= this.b;
      } while ((float)Math.sqrt(f2 * f2 + f1 * f1) < athi.a(this.jdField_a_of_type_Athi).getScaledTouchSlop());
      localathy.a.setPressed(false);
      return true;
    case 1: 
      f2 -= this.jdField_a_of_type_Float;
      f1 -= this.b;
      f2 = (float)Math.sqrt(f2 * f2 + f1 * f1);
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (f2 < athi.a(this.jdField_a_of_type_Athi).getScaledTouchSlop()) {
        if (paramView.b == 2)
        {
          athi.a(this.jdField_a_of_type_Athi).removeMessages(101);
          athi.a(this.jdField_a_of_type_Athi).obtainMessage(101).sendToTarget();
          if (paramView.jdField_a_of_type_Athu != null) {
            paramView.jdField_a_of_type_Athu.a();
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Float = 0.0F;
        this.b = 0.0F;
        this.jdField_a_of_type_Long = 0L;
        localathy.a.setPressed(false);
        return true;
        if ((f2 > athi.a(this.jdField_a_of_type_Athi).getScaledTouchSlop()) && (f1 > 50.0F) && ((float)(l1 - l2) < 300.0F) && (paramView.jdField_a_of_type_Int == 1))
        {
          athi.a(this.jdField_a_of_type_Athi).removeMessages(101);
          athi.a(this.jdField_a_of_type_Athi).obtainMessage(101).sendToTarget();
        }
      }
    }
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.jdField_a_of_type_Long = 0L;
    localathy.a.setPressed(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     athj
 * JD-Core Version:    0.7.0.1
 */