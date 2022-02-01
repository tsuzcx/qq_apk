import android.view.MotionEvent;

public class bgum
{
  protected float a;
  protected bgun a;
  private bguo a;
  protected bgup a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bgum(bgun parambgun, bgup parambgup, boolean paramBoolean)
  {
    if ((parambgun != null) && (parambgup != null))
    {
      this.jdField_a_of_type_Bgun = parambgun;
      this.jdField_a_of_type_Bgup = parambgup;
      return;
    }
    throw new IllegalArgumentException("DragSource and DropTarget shouldn't be null!");
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if (this.jdField_a_of_type_Boolean)
    {
      f2 = paramMotionEvent.getRawX();
      f1 = paramMotionEvent.getRawY();
      f2 += this.jdField_a_of_type_Float;
      f1 += this.jdField_b_of_type_Float;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    label258:
    do
    {
      do
      {
        do
        {
          return false;
          f2 = paramMotionEvent.getX();
          f1 = paramMotionEvent.getY();
          break;
          this.jdField_a_of_type_Bguo = this.jdField_a_of_type_Bgun.a(f2, f1);
        } while (this.jdField_a_of_type_Bguo == null);
        if ((this.jdField_a_of_type_Bgun.a(this.jdField_a_of_type_Bguo, f2, f1)) && (this.jdField_a_of_type_Bguo.a(this.jdField_a_of_type_Bgun, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bgun.a(this.jdField_a_of_type_Bguo, f2, f1);
      this.jdField_a_of_type_Bguo.a(this.jdField_a_of_type_Bgun, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bgup.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bgup.b(this.jdField_a_of_type_Bgun, this.jdField_a_of_type_Bguo, f2, f1);
        }
        this.jdField_a_of_type_Bgup.b(this.jdField_a_of_type_Bgun, this.jdField_a_of_type_Bguo, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bgup.a(this.jdField_a_of_type_Bgun, this.jdField_a_of_type_Bguo, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bgup.a(f2, f1)) && (this.jdField_a_of_type_Bgup.a(this.jdField_a_of_type_Bgun, this.jdField_a_of_type_Bguo, f2, f1)))
    {
      this.jdField_a_of_type_Bgun.a(this.jdField_a_of_type_Bgup, this.jdField_a_of_type_Bguo, f2, f1);
      this.jdField_a_of_type_Bguo.a(this.jdField_a_of_type_Bgun, this.jdField_a_of_type_Bgup, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bgun.a(null, this.jdField_a_of_type_Bguo, f2, f1);
      this.jdField_a_of_type_Bguo.a(this.jdField_a_of_type_Bgun, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgum
 * JD-Core Version:    0.7.0.1
 */