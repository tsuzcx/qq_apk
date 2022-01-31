import android.os.Bundle;

class axso
{
  protected boolean a;
  protected String[][] a;
  protected boolean b = true;
  protected boolean c;
  protected boolean d;
  
  public axso(axsn paramaxsn, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    paramaxsn = paramString.split(";");
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[paramaxsn.length][];
    int i = 0;
    while (i < paramaxsn.length)
    {
      this.jdField_a_of_type_Array2dOfJavaLangString[i] = paramaxsn[i].split(",");
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void b()
  {
    this.c = true;
    if (!axsn.a(this.jdField_a_of_type_Axsn)) {
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
 * Qualified Name:     axso
 * JD-Core Version:    0.7.0.1
 */