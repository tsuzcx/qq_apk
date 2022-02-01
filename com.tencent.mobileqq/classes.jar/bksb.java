import android.content.Context;

public class bksb
{
  protected int a;
  Context a;
  protected bksa a;
  protected bksd a;
  protected boolean a;
  
  public bksb(bksa parambksa, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bksa = parambksa;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bksd parambksd)
  {
    this.jdField_a_of_type_Bksd = parambksd;
    if (parambksd != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_Bksa.setOnClickListener(new bksc(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bksa.a(3);
      return;
    }
    this.jdField_a_of_type_Bksa.a(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Bksa.a(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Bksa.a(i);
      if ((!this.jdField_a_of_type_Bksa.b(i)) || (this.jdField_a_of_type_Bksd == null)) {
        break;
      }
      this.jdField_a_of_type_Bksd.c();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Bksa.a() == 0) || (!this.jdField_a_of_type_Bksa.b(2)));
      bool = true;
      if (this.jdField_a_of_type_Bksd != null) {
        bool = this.jdField_a_of_type_Bksd.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Bksa.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksb
 * JD-Core Version:    0.7.0.1
 */