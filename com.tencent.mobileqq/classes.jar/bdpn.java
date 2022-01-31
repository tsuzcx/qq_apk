import android.view.MotionEvent;

public class bdpn
{
  protected float a;
  protected bdpo a;
  private bdpp a;
  protected bdpq a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bdpn(bdpo parambdpo, bdpq parambdpq, boolean paramBoolean)
  {
    if ((parambdpo != null) && (parambdpq != null))
    {
      this.jdField_a_of_type_Bdpo = parambdpo;
      this.jdField_a_of_type_Bdpq = parambdpq;
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
          this.jdField_a_of_type_Bdpp = this.jdField_a_of_type_Bdpo.a(f2, f1);
        } while (this.jdField_a_of_type_Bdpp == null);
        if ((this.jdField_a_of_type_Bdpo.a(this.jdField_a_of_type_Bdpp, f2, f1)) && (this.jdField_a_of_type_Bdpp.a(this.jdField_a_of_type_Bdpo, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bdpo.a(this.jdField_a_of_type_Bdpp, f2, f1);
      this.jdField_a_of_type_Bdpp.a(this.jdField_a_of_type_Bdpo, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bdpq.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bdpq.b(this.jdField_a_of_type_Bdpo, this.jdField_a_of_type_Bdpp, f2, f1);
        }
        this.jdField_a_of_type_Bdpq.b(this.jdField_a_of_type_Bdpo, this.jdField_a_of_type_Bdpp, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bdpq.a(this.jdField_a_of_type_Bdpo, this.jdField_a_of_type_Bdpp, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bdpq.a(f2, f1)) && (this.jdField_a_of_type_Bdpq.a(this.jdField_a_of_type_Bdpo, this.jdField_a_of_type_Bdpp, f2, f1)))
    {
      this.jdField_a_of_type_Bdpo.a(this.jdField_a_of_type_Bdpq, this.jdField_a_of_type_Bdpp, f2, f1);
      this.jdField_a_of_type_Bdpp.a(this.jdField_a_of_type_Bdpo, this.jdField_a_of_type_Bdpq, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bdpo.a(null, this.jdField_a_of_type_Bdpp, f2, f1);
      this.jdField_a_of_type_Bdpp.a(this.jdField_a_of_type_Bdpo, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpn
 * JD-Core Version:    0.7.0.1
 */