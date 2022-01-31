public abstract class bhcv
  extends bhau
  implements bhdj
{
  protected bgho a;
  public bhav a;
  public bhaz a;
  public bhav b;
  public bhaz b;
  public bhav c;
  public bhaz c;
  public bhav d;
  public bhaz d;
  public bhaz e = new bhaz(this, Integer.valueOf(6));
  public bhaz f = new bhaz(this, Integer.valueOf(8));
  public bhaz g = new bhaz(this, Integer.valueOf(10));
  
  public bhcv(bgho parambgho)
  {
    this.jdField_a_of_type_Bhaz = new bhaz(this, Integer.valueOf(1));
    this.jdField_b_of_type_Bhaz = new bhaz(this, Integer.valueOf(2));
    this.jdField_c_of_type_Bhaz = new bhaz(this, Integer.valueOf(-1));
    this.jdField_d_of_type_Bhaz = new bhaz(this, Integer.valueOf(4));
    this.jdField_a_of_type_Bhav = new bhav(this, 3).a(this.jdField_d_of_type_Bhaz);
    this.jdField_b_of_type_Bhav = new bhav(this, 5).a(this.e);
    this.jdField_c_of_type_Bhav = new bhav(this, 7).a(this.f);
    this.jdField_d_of_type_Bhav = new bhav(this, 9).a(this.g);
    this.jdField_a_of_type_Bgho = parambgho;
    a();
  }
  
  protected void a()
  {
    addStateTransfer(new bhba(this).a(this.jdField_a_of_type_Bhaz).b(this.jdField_b_of_type_Bhaz).a(Integer.valueOf(3)));
    addStateTransfer(new bhba(this).a(this.jdField_b_of_type_Bhaz).b(this.jdField_a_of_type_Bhav).a(Integer.valueOf(4)));
    addStateTransfer(new bhba(this).a(this.jdField_d_of_type_Bhaz).b(this.jdField_b_of_type_Bhav).a(Integer.valueOf(5)));
    addStateTransfer(new bhba(this).a(this.e).b(this.jdField_c_of_type_Bhav).a(Integer.valueOf(6)));
    addStateTransfer(new bhba(this).a(this.f).b(this.jdField_d_of_type_Bhav).a(Integer.valueOf(7)));
    setCurrState(this.jdField_a_of_type_Bhaz);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bhav.a(paramString);
    appendEvent(Integer.valueOf(4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Bhav.a(paramString1, paramString2);
    appendEvent(Integer.valueOf(5));
  }
  
  public boolean a()
  {
    return this.g == getCurrState();
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_Bhav.a(paramString);
    appendEvent(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_Bhav.a(paramString);
    appendEvent(Integer.valueOf(7));
  }
  
  public void setCurrState(bhaz parambhaz)
  {
    bhaz localbhaz = getCurrState();
    if (localbhaz == this.jdField_b_of_type_Bhav) {
      bgyd.a(this.jdField_a_of_type_Bgho.a(), 14, "0");
    }
    for (;;)
    {
      super.setCurrState(parambhaz);
      return;
      if (this.e == localbhaz) {
        bgyd.a(this.jdField_a_of_type_Bgho.a(), 15, "0");
      } else if (localbhaz == this.jdField_d_of_type_Bhav) {
        bgyd.a(this.jdField_a_of_type_Bgho.a(), 104, "0");
      } else if (this.g == localbhaz) {
        bgyd.a(this.jdField_a_of_type_Bgho.a(), 105, "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhcv
 * JD-Core Version:    0.7.0.1
 */