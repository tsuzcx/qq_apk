import android.view.MotionEvent;

public class bbmk
{
  protected float a;
  protected bbml a;
  private bbmm a;
  protected bbmn a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bbmk(bbml parambbml, bbmn parambbmn, boolean paramBoolean)
  {
    if ((parambbml != null) && (parambbmn != null))
    {
      this.jdField_a_of_type_Bbml = parambbml;
      this.jdField_a_of_type_Bbmn = parambbmn;
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
          this.jdField_a_of_type_Bbmm = this.jdField_a_of_type_Bbml.a(f2, f1);
        } while (this.jdField_a_of_type_Bbmm == null);
        if ((this.jdField_a_of_type_Bbml.a(this.jdField_a_of_type_Bbmm, f2, f1)) && (this.jdField_a_of_type_Bbmm.a(this.jdField_a_of_type_Bbml, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bbml.a(this.jdField_a_of_type_Bbmm, f2, f1);
      this.jdField_a_of_type_Bbmm.a(this.jdField_a_of_type_Bbml, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bbmn.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bbmn.b(this.jdField_a_of_type_Bbml, this.jdField_a_of_type_Bbmm, f2, f1);
        }
        this.jdField_a_of_type_Bbmn.b(this.jdField_a_of_type_Bbml, this.jdField_a_of_type_Bbmm, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bbmn.a(this.jdField_a_of_type_Bbml, this.jdField_a_of_type_Bbmm, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bbmn.a(f2, f1)) && (this.jdField_a_of_type_Bbmn.a(this.jdField_a_of_type_Bbml, this.jdField_a_of_type_Bbmm, f2, f1)))
    {
      this.jdField_a_of_type_Bbml.a(this.jdField_a_of_type_Bbmn, this.jdField_a_of_type_Bbmm, f2, f1);
      this.jdField_a_of_type_Bbmm.a(this.jdField_a_of_type_Bbml, this.jdField_a_of_type_Bbmn, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bbml.a(null, this.jdField_a_of_type_Bbmm, f2, f1);
      this.jdField_a_of_type_Bbmm.a(this.jdField_a_of_type_Bbml, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmk
 * JD-Core Version:    0.7.0.1
 */