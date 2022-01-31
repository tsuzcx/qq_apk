import android.view.MotionEvent;

public class bdle
{
  protected float a;
  protected bdlf a;
  private bdlg a;
  protected bdlh a;
  protected boolean a;
  protected float b;
  protected boolean b;
  protected boolean c;
  protected boolean d = true;
  
  public bdle(bdlf parambdlf, bdlh parambdlh, boolean paramBoolean)
  {
    if ((parambdlf != null) && (parambdlh != null))
    {
      this.jdField_a_of_type_Bdlf = parambdlf;
      this.jdField_a_of_type_Bdlh = parambdlh;
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
          this.jdField_a_of_type_Bdlg = this.jdField_a_of_type_Bdlf.a(f2, f1);
        } while (this.jdField_a_of_type_Bdlg == null);
        if ((this.jdField_a_of_type_Bdlf.a(this.jdField_a_of_type_Bdlg, f2, f1)) && (this.jdField_a_of_type_Bdlg.a(this.jdField_a_of_type_Bdlf, f2, f1))) {
          this.jdField_b_of_type_Boolean = true;
        }
        return true;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bdlf.a(this.jdField_a_of_type_Bdlg, f2, f1);
      this.jdField_a_of_type_Bdlg.a(this.jdField_a_of_type_Bdlf, f2, f1);
      if (this.d)
      {
        if (!this.jdField_a_of_type_Bdlh.a(f2, f1)) {
          break label258;
        }
        if (!this.c)
        {
          this.c = true;
          this.d = this.jdField_a_of_type_Bdlh.b(this.jdField_a_of_type_Bdlf, this.jdField_a_of_type_Bdlg, f2, f1);
        }
        this.jdField_a_of_type_Bdlh.b(this.jdField_a_of_type_Bdlf, this.jdField_a_of_type_Bdlg, f2, f1);
      }
      for (;;)
      {
        return true;
        if (this.c)
        {
          this.c = false;
          this.jdField_a_of_type_Bdlh.a(this.jdField_a_of_type_Bdlf, this.jdField_a_of_type_Bdlg, f2, f1);
        }
      }
    } while (!this.jdField_b_of_type_Boolean);
    if ((this.jdField_a_of_type_Bdlh.a(f2, f1)) && (this.jdField_a_of_type_Bdlh.a(this.jdField_a_of_type_Bdlf, this.jdField_a_of_type_Bdlg, f2, f1)))
    {
      this.jdField_a_of_type_Bdlf.a(this.jdField_a_of_type_Bdlh, this.jdField_a_of_type_Bdlg, f2, f1);
      this.jdField_a_of_type_Bdlg.a(this.jdField_a_of_type_Bdlf, this.jdField_a_of_type_Bdlh, f2, f1);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      this.d = true;
      return true;
      this.jdField_a_of_type_Bdlf.a(null, this.jdField_a_of_type_Bdlg, f2, f1);
      this.jdField_a_of_type_Bdlg.a(this.jdField_a_of_type_Bdlf, null, f2, f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdle
 * JD-Core Version:    0.7.0.1
 */