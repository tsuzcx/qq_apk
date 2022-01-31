import com.tencent.qphone.base.util.QLog;

public class aqfz
{
  private aqga jdField_a_of_type_Aqga;
  private aqgb jdField_a_of_type_Aqgb;
  private aqgc jdField_a_of_type_Aqgc;
  private aqgd jdField_a_of_type_Aqgd;
  
  public aqfz(aqfk paramaqfk)
  {
    this.jdField_a_of_type_Aqgd = new aqgd(this, paramaqfk);
    this.jdField_a_of_type_Aqgc = new aqgc(this, paramaqfk);
    this.jdField_a_of_type_Aqgb = new aqgb(this, paramaqfk);
    this.jdField_a_of_type_Aqga = this.jdField_a_of_type_Aqgd;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aqga.a;
  }
  
  public aqga a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Aqgb;
    case 0: 
      return this.jdField_a_of_type_Aqgd;
    }
    return this.jdField_a_of_type_Aqgc;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Aqga.a)
    {
      aqga localaqga = a(paramInt1);
      if (localaqga != null)
      {
        this.jdField_a_of_type_Aqga.a();
        this.jdField_a_of_type_Aqga = localaqga;
        this.jdField_a_of_type_Aqga.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Aqga.a;
    if ((!this.jdField_a_of_type_Aqga.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
      QLog.e("LimitChatUiStateMachine", 2, "state " + i + " not handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Aqga.a == 0);
    this.jdField_a_of_type_Aqga.b();
    this.jdField_a_of_type_Aqga = this.jdField_a_of_type_Aqgd;
    this.jdField_a_of_type_Aqga.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfz
 * JD-Core Version:    0.7.0.1
 */