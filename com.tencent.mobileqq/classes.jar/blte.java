import android.content.Context;

public class blte
{
  protected int a;
  Context a;
  protected bltd a;
  protected bltg a;
  protected boolean a;
  
  public blte(bltd parambltd, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bltd = parambltd;
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
  
  public void a(bltg parambltg)
  {
    this.jdField_a_of_type_Bltg = parambltg;
    if (parambltg != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_Bltd.setOnClickListener(new bltf(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bltd.a(3);
      return;
    }
    this.jdField_a_of_type_Bltd.a(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Bltd.a(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Bltd.a(i);
      if ((!this.jdField_a_of_type_Bltd.b(i)) || (this.jdField_a_of_type_Bltg == null)) {
        break;
      }
      this.jdField_a_of_type_Bltg.c();
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
      } while ((this.jdField_a_of_type_Bltd.a() == 0) || (!this.jdField_a_of_type_Bltd.b(2)));
      bool = true;
      if (this.jdField_a_of_type_Bltg != null) {
        bool = this.jdField_a_of_type_Bltg.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Bltd.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blte
 * JD-Core Version:    0.7.0.1
 */