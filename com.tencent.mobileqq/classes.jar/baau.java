import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureListener;

public class baau
  implements GLGestureListener
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  baav jdField_a_of_type_Baav;
  int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private final int c;
  private final int d;
  private final int e;
  
  public baau(Context paramContext, baav parambaav)
  {
    this.jdField_a_of_type_Baav = parambaav;
    paramContext = ViewConfiguration.get(paramContext);
    this.c = ViewConfiguration.getDoubleTapTimeout();
    this.d = 1000;
    this.jdField_a_of_type_Int = paramContext.getScaledDoubleTapSlop();
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * this.jdField_a_of_type_Int);
    this.e = paramContext.getScaledTouchSlop();
    this.jdField_a_of_type_Long = 0L;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)paramFloat3 - (int)paramFloat1;
    int j = (int)paramFloat4 - (int)paramFloat2;
    return i * i + j * j > this.e;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < this.d) || (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > this.c) || (a(paramMotionEvent1.getX(), paramMotionEvent1.getY(), paramMotionEvent2.getX(), paramMotionEvent2.getY())));
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.jdField_b_of_type_Int);
    return true;
  }
  
  public int onGetPriority()
  {
    return 0;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean)) {}
    switch (j & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if ((a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)) && (this.jdField_a_of_type_Baav != null))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Baav.a();
        xwa.a("camera_clkdouble", babc.jdField_a_of_type_Int, 0, new String[0]);
        babc.c();
        if (QLog.isColorLevel()) {
          QLog.d("GLGestureListener", 2, new Object[] { "", "CameraSwitchGesture" });
        }
      }
      if (this.jdField_a_of_type_AndroidViewMotionEvent != null) {
        this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      return false;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null) {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
    }
    this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baau
 * JD-Core Version:    0.7.0.1
 */