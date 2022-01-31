import android.content.Context;

public class bfzl
{
  protected int a;
  Context a;
  protected bfzk a;
  protected bfzn a;
  protected boolean a;
  
  public bfzl(bfzk parambfzk, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bfzk = parambfzk;
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
  
  public void a(bfzn parambfzn)
  {
    this.jdField_a_of_type_Bfzn = parambfzn;
    if (parambfzn != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_Bfzk.setOnClickListener(new bfzm(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bfzk.a(3);
      return;
    }
    this.jdField_a_of_type_Bfzk.a(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Bfzk.a(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Bfzk.a(i);
      if ((!this.jdField_a_of_type_Bfzk.b(i)) || (this.jdField_a_of_type_Bfzn == null)) {
        break;
      }
      this.jdField_a_of_type_Bfzn.c();
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
      } while ((this.jdField_a_of_type_Bfzk.a() == 0) || (!this.jdField_a_of_type_Bfzk.b(2)));
      bool = true;
      if (this.jdField_a_of_type_Bfzn != null) {
        bool = this.jdField_a_of_type_Bfzn.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Bfzk.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzl
 * JD-Core Version:    0.7.0.1
 */