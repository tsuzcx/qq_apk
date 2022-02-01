import android.view.MotionEvent;

public class bhkb
{
  protected float a;
  protected bhkc a;
  private bhkd a;
  protected bhke a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bhkb(bhkc parambhkc, bhke parambhke, boolean paramBoolean)
  {
    if ((parambhkc != null) && (parambhke != null))
    {
      this.jdField_a_of_type_Bhkc = parambhkc;
      this.jdField_a_of_type_Bhke = parambhke;
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
          this.jdField_a_of_type_Bhkd = this.jdField_a_of_type_Bhkc.a(f2, f1);
        } while (this.jdField_a_of_type_Bhkd == null);
        if ((this.jdField_a_of_type_Bhkc.a(this.jdField_a_of_type_Bhkd, f2, f1)) && (this.jdField_a_of_type_Bhkd.a(this.jdField_a_of_type_Bhkc, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bhkc.a(this.jdField_a_of_type_Bhkd, f2, f1);
      this.jdField_a_of_type_Bhkd.a(this.jdField_a_of_type_Bhkc, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bhke.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bhke.b(this.jdField_a_of_type_Bhkc, this.jdField_a_of_type_Bhkd, f2, f1);
        }
        this.jdField_a_of_type_Bhke.b(this.jdField_a_of_type_Bhkc, this.jdField_a_of_type_Bhkd, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bhke.a(this.jdField_a_of_type_Bhkc, this.jdField_a_of_type_Bhkd, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bhke.a(f2, f1)) && (this.jdField_a_of_type_Bhke.a(this.jdField_a_of_type_Bhkc, this.jdField_a_of_type_Bhkd, f2, f1)))
    {
      this.jdField_a_of_type_Bhkc.a(this.jdField_a_of_type_Bhke, this.jdField_a_of_type_Bhkd, f2, f1);
      this.jdField_a_of_type_Bhkd.a(this.jdField_a_of_type_Bhkc, this.jdField_a_of_type_Bhke, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bhkc.a(null, this.jdField_a_of_type_Bhkd, f2, f1);
      this.jdField_a_of_type_Bhkd.a(this.jdField_a_of_type_Bhkc, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkb
 * JD-Core Version:    0.7.0.1
 */