public abstract class bhhc
  extends bhfb
  implements bhhq
{
  protected bglv a;
  public bhfc a;
  public bhfg a;
  public bhfc b;
  public bhfg b;
  public bhfc c;
  public bhfg c;
  public bhfc d;
  public bhfg d;
  public bhfg e = new bhfg(this, Integer.valueOf(6));
  public bhfg f = new bhfg(this, Integer.valueOf(8));
  public bhfg g = new bhfg(this, Integer.valueOf(10));
  
  public bhhc(bglv parambglv)
  {
    this.jdField_a_of_type_Bhfg = new bhfg(this, Integer.valueOf(1));
    this.jdField_b_of_type_Bhfg = new bhfg(this, Integer.valueOf(2));
    this.jdField_c_of_type_Bhfg = new bhfg(this, Integer.valueOf(-1));
    this.jdField_d_of_type_Bhfg = new bhfg(this, Integer.valueOf(4));
    this.jdField_a_of_type_Bhfc = new bhfc(this, 3).a(this.jdField_d_of_type_Bhfg);
    this.jdField_b_of_type_Bhfc = new bhfc(this, 5).a(this.e);
    this.jdField_c_of_type_Bhfc = new bhfc(this, 7).a(this.f);
    this.jdField_d_of_type_Bhfc = new bhfc(this, 9).a(this.g);
    this.jdField_a_of_type_Bglv = parambglv;
    a();
  }
  
  protected void a()
  {
    addStateTransfer(new bhfh(this).a(this.jdField_a_of_type_Bhfg).b(this.jdField_b_of_type_Bhfg).a(Integer.valueOf(3)));
    addStateTransfer(new bhfh(this).a(this.jdField_b_of_type_Bhfg).b(this.jdField_a_of_type_Bhfc).a(Integer.valueOf(4)));
    addStateTransfer(new bhfh(this).a(this.jdField_d_of_type_Bhfg).b(this.jdField_b_of_type_Bhfc).a(Integer.valueOf(5)));
    addStateTransfer(new bhfh(this).a(this.e).b(this.jdField_c_of_type_Bhfc).a(Integer.valueOf(6)));
    addStateTransfer(new bhfh(this).a(this.f).b(this.jdField_d_of_type_Bhfc).a(Integer.valueOf(7)));
    setCurrState(this.jdField_a_of_type_Bhfg);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bhfc.a(paramString);
    appendEvent(Integer.valueOf(4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Bhfc.a(paramString1, paramString2);
    appendEvent(Integer.valueOf(5));
  }
  
  public boolean a()
  {
    return this.g == getCurrState();
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_Bhfc.a(paramString);
    appendEvent(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_Bhfc.a(paramString);
    appendEvent(Integer.valueOf(7));
  }
  
  public void setCurrState(bhfg parambhfg)
  {
    bhfg localbhfg = getCurrState();
    if (localbhfg == this.jdField_b_of_type_Bhfc) {
      bhck.a(this.jdField_a_of_type_Bglv.a(), 14, "0");
    }
    for (;;)
    {
      super.setCurrState(parambhfg);
      return;
      if (this.e == localbhfg) {
        bhck.a(this.jdField_a_of_type_Bglv.a(), 15, "0");
      } else if (localbhfg == this.jdField_d_of_type_Bhfc) {
        bhck.a(this.jdField_a_of_type_Bglv.a(), 104, "0");
      } else if (this.g == localbhfg) {
        bhck.a(this.jdField_a_of_type_Bglv.a(), 105, "0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhc
 * JD-Core Version:    0.7.0.1
 */