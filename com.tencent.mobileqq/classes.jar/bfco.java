public abstract class bfco
  extends bfau
  implements bfdc
{
  protected begz a;
  public bfav a;
  public bfaz a;
  public bfav b;
  public bfaz b;
  public bfav c;
  public bfaz c;
  public bfav d;
  public bfaz d;
  public bfaz e = new bfaz(this, Integer.valueOf(6));
  public bfaz f = new bfaz(this, Integer.valueOf(8));
  public bfaz g = new bfaz(this, Integer.valueOf(10));
  
  public bfco(begz parambegz)
  {
    this.jdField_a_of_type_Bfaz = new bfaz(this, Integer.valueOf(1));
    this.jdField_b_of_type_Bfaz = new bfaz(this, Integer.valueOf(2));
    this.jdField_c_of_type_Bfaz = new bfaz(this, Integer.valueOf(-1));
    this.jdField_d_of_type_Bfaz = new bfaz(this, Integer.valueOf(4));
    this.jdField_a_of_type_Bfav = new bfav(this, 3).a(this.jdField_d_of_type_Bfaz);
    this.jdField_b_of_type_Bfav = new bfav(this, 5).a(this.e);
    this.jdField_c_of_type_Bfav = new bfav(this, 7).a(this.f);
    this.jdField_d_of_type_Bfav = new bfav(this, 9).a(this.g);
    this.jdField_a_of_type_Begz = parambegz;
    a();
  }
  
  protected void a()
  {
    a(new bfba(this).a(this.jdField_a_of_type_Bfaz).b(this.jdField_b_of_type_Bfaz).a(Integer.valueOf(3)));
    a(new bfba(this).a(this.jdField_b_of_type_Bfaz).b(this.jdField_a_of_type_Bfav).a(Integer.valueOf(4)));
    a(new bfba(this).a(this.jdField_d_of_type_Bfaz).b(this.jdField_b_of_type_Bfav).a(Integer.valueOf(5)));
    a(new bfba(this).a(this.e).b(this.jdField_c_of_type_Bfav).a(Integer.valueOf(6)));
    a(new bfba(this).a(this.f).b(this.jdField_d_of_type_Bfav).a(Integer.valueOf(7)));
    a(this.jdField_a_of_type_Bfaz);
  }
  
  public void a(bfaz parambfaz)
  {
    bfaz localbfaz = a();
    if (localbfaz == this.jdField_b_of_type_Bfav) {
      beyr.a(this.jdField_a_of_type_Begz.a(), 14, "0");
    }
    for (;;)
    {
      super.a(parambfaz);
      return;
      if (this.e == localbfaz) {
        beyr.a(this.jdField_a_of_type_Begz.a(), 15, "0");
      } else if (localbfaz == this.jdField_d_of_type_Bfav) {
        beyr.a(this.jdField_a_of_type_Begz.a(), 104, "0");
      } else if (this.g == localbfaz) {
        beyr.a(this.jdField_a_of_type_Begz.a(), 105, "0");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfav.a(paramString);
    b(Integer.valueOf(4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Bfav.a(paramString1, paramString2);
    b(Integer.valueOf(5));
  }
  
  public boolean a()
  {
    return this.g == a();
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_Bfav.a(paramString);
    b(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_Bfav.a(paramString);
    b(Integer.valueOf(7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfco
 * JD-Core Version:    0.7.0.1
 */