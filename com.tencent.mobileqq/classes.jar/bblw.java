import android.view.MotionEvent;

public class bblw
{
  protected float a;
  protected bblx a;
  private bbly a;
  protected bblz a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bblw(bblx parambblx, bblz parambblz, boolean paramBoolean)
  {
    if ((parambblx != null) && (parambblz != null))
    {
      this.jdField_a_of_type_Bblx = parambblx;
      this.jdField_a_of_type_Bblz = parambblz;
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
          this.jdField_a_of_type_Bbly = this.jdField_a_of_type_Bblx.a(f2, f1);
        } while (this.jdField_a_of_type_Bbly == null);
        if ((this.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_Bbly, f2, f1)) && (this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblx, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_Bbly, f2, f1);
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblx, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bblz.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bblz.b(this.jdField_a_of_type_Bblx, this.jdField_a_of_type_Bbly, f2, f1);
        }
        this.jdField_a_of_type_Bblz.b(this.jdField_a_of_type_Bblx, this.jdField_a_of_type_Bbly, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bblz.a(this.jdField_a_of_type_Bblx, this.jdField_a_of_type_Bbly, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bblz.a(f2, f1)) && (this.jdField_a_of_type_Bblz.a(this.jdField_a_of_type_Bblx, this.jdField_a_of_type_Bbly, f2, f1)))
    {
      this.jdField_a_of_type_Bblx.a(this.jdField_a_of_type_Bblz, this.jdField_a_of_type_Bbly, f2, f1);
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblx, this.jdField_a_of_type_Bblz, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bblx.a(null, this.jdField_a_of_type_Bbly, f2, f1);
      this.jdField_a_of_type_Bbly.a(this.jdField_a_of_type_Bblx, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblw
 * JD-Core Version:    0.7.0.1
 */