import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import cooperation.qzone.panorama.controller.TouchController.1;
import java.util.Timer;
import java.util.TimerTask;

public class bhgv
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new bhgw(this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private bhgr jdField_a_of_type_Bhgr;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k = 1.0F;
  
  public bhgv(View paramView, Context paramContext, bhgr parambhgr, bhhf parambhhf)
  {
    this.jdField_a_of_type_Bhgr = parambhgr;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = parambhhf.a();
    this.jdField_b_of_type_Int = parambhhf.b();
    this.jdField_c_of_type_Int = parambhhf.d();
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Float = 0.35F;
      this.jdField_b_of_type_Float = 0.057F;
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float / this.jdField_b_of_type_Float);
      this.d = 0.162F;
    }
    while (this.jdField_b_of_type_Int == 1) {
      if (this.jdField_a_of_type_Int == 0)
      {
        this.k = 0.4142652F;
        return;
        this.jdField_a_of_type_Float = 0.122F;
        this.jdField_b_of_type_Float = 0.01F;
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float / this.jdField_b_of_type_Float);
        this.d = 0.08F;
      }
      else
      {
        this.k = 0.5228754F;
        return;
      }
    }
    this.k = 1.0F;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bhgr != null) {
      this.jdField_a_of_type_Bhgr.a(paramFloat1, paramFloat2);
    }
    this.g += paramFloat1;
    this.h += paramFloat2;
    if (this.g > 90.0F) {
      this.g = 90.0F;
    }
    while (this.g >= -90.0F) {
      return;
    }
    this.g = -90.0F;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = 40;
    int n = 1;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 6) {
      this.jdField_a_of_type_Boolean = true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((!this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) && (paramMotionEvent.getPointerCount() == 1) && (!this.jdField_a_of_type_Boolean))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label341;
      }
      this.i = f1;
      this.j = f2;
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
      }
      if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      }
    }
    int i1;
    label278:
    label283:
    label341:
    while (paramMotionEvent.getAction() != 2)
    {
      this.e = f2;
      this.f = f1;
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_a_of_type_Boolean = false;
        m = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
        if ((Math.abs(f1 - this.i) <= m) && (Math.abs(f2 - this.j) <= m) && (this.jdField_a_of_type_Bhgr != null)) {
          this.jdField_a_of_type_Bhgr.a();
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(10);
        i1 = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
        int i2 = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
        if (i1 <= 0) {
          break;
        }
        m = 1;
        if (i2 <= 0) {
          break label499;
        }
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimerTask = new TouchController.1(this, m, new int[] { i1, i2 }, n);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 15L);
      }
      return bool;
    }
    float f3 = this.f;
    float f4 = this.e;
    float f5;
    float f6;
    if (this.jdField_c_of_type_Int != 4)
    {
      f5 = f2 - this.j;
      f6 = f1 - this.i;
      i1 = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop() * 2;
      if (i1 >= 40) {
        break label505;
      }
    }
    for (;;)
    {
      if (((f5 / f6 >= 1.0F) || (f5 / f6 <= -1.0F)) && (Math.abs(f5) <= m) && (Math.abs(f6) <= m))
      {
        this.jdField_a_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(false);
        return true;
      }
      a(this.d * (f2 - f4), this.d * (f1 - f3));
      break;
      m = 0;
      break label278;
      label499:
      n = 0;
      break label283;
      label505:
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhgv
 * JD-Core Version:    0.7.0.1
 */