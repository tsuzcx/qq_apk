import android.os.Bundle;

class azoc
{
  protected boolean a;
  protected String[][] a;
  protected boolean b = true;
  protected boolean c;
  protected boolean d;
  
  public azoc(azob paramazob, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    paramazob = paramString.split(";");
    this.jdField_a_of_type_Array2dOfJavaLangString = new String[paramazob.length][];
    int i = 0;
    while (i < paramazob.length)
    {
      this.jdField_a_of_type_Array2dOfJavaLangString[i] = paramazob[i].split(",");
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void b()
  {
    this.c = true;
    if (!azob.a(this.jdField_a_of_type_Azob)) {
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
 * Qualified Name:     azoc
 * JD-Core Version:    0.7.0.1
 */