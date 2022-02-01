import android.content.Context;
import android.view.MotionEvent;

public class aywa
{
  private float jdField_a_of_type_Float;
  private final aywb jdField_a_of_type_Aywb;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float d;
  private float e;
  
  public aywa(Context paramContext, aywb paramaywb)
  {
    this.jdField_a_of_type_Aywb = paramaywb;
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(1) - paramMotionEvent.getY(0), paramMotionEvent.getX(1) - paramMotionEvent.getX(0)));
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Boolean) || (Math.abs(this.c - this.d) < 5.0F)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Aywb.b(this);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Aywb.a(this));
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Aywb.a(this);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = 0;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            b();
            return true;
          } while (paramMotionEvent.getPointerCount() != 2);
          float f = a(paramMotionEvent);
          this.d = f;
          this.e = f;
          this.c = f;
          return true;
        } while ((paramMotionEvent.getPointerCount() < 2) || ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)));
        this.d = a(paramMotionEvent);
        this.jdField_a_of_type_Float = ((paramMotionEvent.getX(1) + paramMotionEvent.getX(0)) * 0.5F);
        this.jdField_b_of_type_Float = ((paramMotionEvent.getY(1) + paramMotionEvent.getY(0)) * 0.5F);
        boolean bool = this.jdField_a_of_type_Boolean;
        a();
        if ((!bool) || (a())) {
          i = 1;
        }
      } while (i == 0);
      this.e = this.d;
      return true;
    } while (paramMotionEvent.getPointerCount() != 2);
    b();
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public float c()
  {
    return this.d - this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywa
 * JD-Core Version:    0.7.0.1
 */