public abstract class bdwf
  extends bdum
  implements bdwp
{
  private bdcz a;
  public bdun a;
  public bdur a;
  public bdun b;
  public bdur b;
  public bdun c;
  public bdur c;
  public bdun d;
  public bdur d;
  public bdur e = new bdur(this, Integer.valueOf(8));
  public bdur f = new bdur(this, Integer.valueOf(10));
  
  public bdwf(bdcz parambdcz)
  {
    this.jdField_a_of_type_Bdur = new bdur(this, Integer.valueOf(1));
    this.jdField_b_of_type_Bdur = new bdur(this, Integer.valueOf(2));
    this.jdField_c_of_type_Bdur = new bdur(this, Integer.valueOf(4));
    this.jdField_a_of_type_Bdun = new bdun(this, 3).a(this.jdField_c_of_type_Bdur);
    this.jdField_d_of_type_Bdur = new bdur(this, Integer.valueOf(6));
    this.jdField_b_of_type_Bdun = new bdun(this, 5).a(this.jdField_d_of_type_Bdur);
    this.jdField_c_of_type_Bdun = new bdun(this, 7).a(this.e);
    this.jdField_d_of_type_Bdun = new bdun(this, 9).a(this.f);
    this.jdField_a_of_type_Bdcz = parambdcz;
    a();
  }
  
  protected void a()
  {
    a(new bdus(this).a(this.jdField_a_of_type_Bdur).b(this.jdField_b_of_type_Bdur).a(Integer.valueOf(3)));
    a(new bdus(this).a(this.jdField_b_of_type_Bdur).b(this.jdField_a_of_type_Bdun).a(Integer.valueOf(4)));
    a(new bdus(this).a(this.jdField_c_of_type_Bdur).b(this.jdField_b_of_type_Bdun).a(Integer.valueOf(5)));
    a(new bdus(this).a(this.jdField_d_of_type_Bdur).b(this.jdField_c_of_type_Bdun).a(Integer.valueOf(6)));
    a(new bdus(this).a(this.e).b(this.jdField_d_of_type_Bdun).a(Integer.valueOf(7)));
    a(this.jdField_a_of_type_Bdur);
  }
  
  public void a(bdur parambdur)
  {
    bdur localbdur = a();
    if (localbdur == this.jdField_b_of_type_Bdun) {
      bdsu.a(this.jdField_a_of_type_Bdcz.a(), 14, "0");
    }
    for (;;)
    {
      super.a(parambdur);
      return;
      if (this.jdField_d_of_type_Bdur == localbdur) {
        bdsu.a(this.jdField_a_of_type_Bdcz.a(), 15, "0");
      } else if (localbdur == this.jdField_d_of_type_Bdun) {
        bdsu.a(this.jdField_a_of_type_Bdcz.a(), 104, "0");
      } else if (this.f == localbdur) {
        bdsu.a(this.jdField_a_of_type_Bdcz.a(), 105, "0");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bdun.a(paramString);
    b(Integer.valueOf(4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Bdun.a(paramString1, paramString2);
    b(Integer.valueOf(5));
  }
  
  public boolean a()
  {
    return this.f == a();
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_Bdun.a(paramString);
    b(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_Bdun.a(paramString);
    b(Integer.valueOf(7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwf
 * JD-Core Version:    0.7.0.1
 */