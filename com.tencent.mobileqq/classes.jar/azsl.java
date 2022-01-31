import android.os.Bundle;

class azsl
{
  protected boolean a;
  protected String[][] a;
  protected boolean b = true;
  protected boolean c;
  protected boolean d;
  
  public azsl(azsk paramazsk, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    paramazsk = paramString.split(";");
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[paramazsk.length][];
    int i = 0;
    while (i < paramazsk.length)
    {
      this.jdField_a_of_type_Array2dOfJavaLangString[i] = paramazsk[i].split(",");
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void b()
  {
    this.c = true;
    if (!azsk.a(this.jdField_a_of_type_Azsk)) {
      this.d = true;
    }
  }
  
  public void c()
  {
    this.c = false;
    this.d = false;
  }
  
  public void d() {}
  
  public void e()
  {
    this.b = false;
  }
  
  public void f()
  {
    this.d = false;
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azsl
 * JD-Core Version:    0.7.0.1
 */