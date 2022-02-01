import com.tencent.qphone.base.util.QLog;

public class atba
{
  private atbb jdField_a_of_type_Atbb;
  private atbc jdField_a_of_type_Atbc;
  private atbd jdField_a_of_type_Atbd;
  private atbe jdField_a_of_type_Atbe;
  
  public atba(atag paramatag)
  {
    this.jdField_a_of_type_Atbe = new atbe(this, paramatag);
    this.jdField_a_of_type_Atbd = new atbd(this, paramatag);
    this.jdField_a_of_type_Atbc = new atbc(this, paramatag);
    this.jdField_a_of_type_Atbb = this.jdField_a_of_type_Atbe;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Atbb.a;
  }
  
  public atbb a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Atbc;
    case 0: 
      return this.jdField_a_of_type_Atbe;
    }
    return this.jdField_a_of_type_Atbd;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Atbb.a)
    {
      atbb localatbb = a(paramInt1);
      if (localatbb != null)
      {
        this.jdField_a_of_type_Atbb.a();
        this.jdField_a_of_type_Atbb = localatbb;
        this.jdField_a_of_type_Atbb.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Atbb.a;
    if ((!this.jdField_a_of_type_Atbb.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Atbb.a == 0);
    this.jdField_a_of_type_Atbb.b();
    this.jdField_a_of_type_Atbb = this.jdField_a_of_type_Atbe;
    this.jdField_a_of_type_Atbb.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atba
 * JD-Core Version:    0.7.0.1
 */