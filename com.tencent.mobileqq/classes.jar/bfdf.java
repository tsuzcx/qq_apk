public abstract class bfdf
  extends bfbl
  implements bfdt
{
  protected behq a;
  public bfbm a;
  public bfbq a;
  public bfbm b;
  public bfbq b;
  public bfbm c;
  public bfbq c;
  public bfbm d;
  public bfbq d;
  public bfbq e = new bfbq(this, Integer.valueOf(6));
  public bfbq f = new bfbq(this, Integer.valueOf(8));
  public bfbq g = new bfbq(this, Integer.valueOf(10));
  
  public bfdf(behq parambehq)
  {
    this.jdField_a_of_type_Bfbq = new bfbq(this, Integer.valueOf(1));
    this.jdField_b_of_type_Bfbq = new bfbq(this, Integer.valueOf(2));
    this.jdField_c_of_type_Bfbq = new bfbq(this, Integer.valueOf(-1));
    this.jdField_d_of_type_Bfbq = new bfbq(this, Integer.valueOf(4));
    this.jdField_a_of_type_Bfbm = new bfbm(this, 3).a(this.jdField_d_of_type_Bfbq);
    this.jdField_b_of_type_Bfbm = new bfbm(this, 5).a(this.e);
    this.jdField_c_of_type_Bfbm = new bfbm(this, 7).a(this.f);
    this.jdField_d_of_type_Bfbm = new bfbm(this, 9).a(this.g);
    this.jdField_a_of_type_Behq = parambehq;
    a();
  }
  
  protected void a()
  {
    a(new bfbr(this).a(this.jdField_a_of_type_Bfbq).b(this.jdField_b_of_type_Bfbq).a(Integer.valueOf(3)));
    a(new bfbr(this).a(this.jdField_b_of_type_Bfbq).b(this.jdField_a_of_type_Bfbm).a(Integer.valueOf(4)));
    a(new bfbr(this).a(this.jdField_d_of_type_Bfbq).b(this.jdField_b_of_type_Bfbm).a(Integer.valueOf(5)));
    a(new bfbr(this).a(this.e).b(this.jdField_c_of_type_Bfbm).a(Integer.valueOf(6)));
    a(new bfbr(this).a(this.f).b(this.jdField_d_of_type_Bfbm).a(Integer.valueOf(7)));
    a(this.jdField_a_of_type_Bfbq);
  }
  
  public void a(bfbq parambfbq)
  {
    bfbq localbfbq = a();
    if (localbfbq == this.jdField_b_of_type_Bfbm) {
      bezi.a(this.jdField_a_of_type_Behq.a(), 14, "0");
    }
    for (;;)
    {
      super.a(parambfbq);
      return;
      if (this.e == localbfbq) {
        bezi.a(this.jdField_a_of_type_Behq.a(), 15, "0");
      } else if (localbfbq == this.jdField_d_of_type_Bfbm) {
        bezi.a(this.jdField_a_of_type_Behq.a(), 104, "0");
      } else if (this.g == localbfbq) {
        bezi.a(this.jdField_a_of_type_Behq.a(), 105, "0");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfbm.a(paramString);
    b(Integer.valueOf(4));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Bfbm.a(paramString1, paramString2);
    b(Integer.valueOf(5));
  }
  
  public boolean a()
  {
    return this.g == a();
  }
  
  public abstract void b();
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_Bfbm.a(paramString);
    b(Integer.valueOf(6));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_Bfbm.a(paramString);
    b(Integer.valueOf(7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdf
 * JD-Core Version:    0.7.0.1
 */