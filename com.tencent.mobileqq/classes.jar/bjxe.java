import android.content.Context;

public class bjxe
{
  protected int a;
  Context a;
  protected bjxd a;
  protected bjxg a;
  protected boolean a;
  
  public bjxe(bjxd parambjxd, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Bjxd = parambjxd;
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
  
  public void a(bjxg parambjxg)
  {
    this.jdField_a_of_type_Bjxg = parambjxg;
    if (parambjxg != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_Bjxd.setOnClickListener(new bjxf(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bjxd.a(3);
      return;
    }
    this.jdField_a_of_type_Bjxd.a(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Bjxd.a(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Bjxd.a(i);
      if ((!this.jdField_a_of_type_Bjxd.b(i)) || (this.jdField_a_of_type_Bjxg == null)) {
        break;
      }
      this.jdField_a_of_type_Bjxg.c();
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
      } while ((this.jdField_a_of_type_Bjxd.a() == 0) || (!this.jdField_a_of_type_Bjxd.b(2)));
      bool = true;
      if (this.jdField_a_of_type_Bjxg != null) {
        bool = this.jdField_a_of_type_Bjxg.a(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Bjxd.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxe
 * JD-Core Version:    0.7.0.1
 */