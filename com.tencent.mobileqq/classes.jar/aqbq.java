import com.tencent.qphone.base.util.QLog;

public class aqbq
{
  private aqbr jdField_a_of_type_Aqbr;
  private aqbs jdField_a_of_type_Aqbs;
  private aqbt jdField_a_of_type_Aqbt;
  private aqbu jdField_a_of_type_Aqbu;
  
  public aqbq(aqbb paramaqbb)
  {
    this.jdField_a_of_type_Aqbu = new aqbu(this, paramaqbb);
    this.jdField_a_of_type_Aqbt = new aqbt(this, paramaqbb);
    this.jdField_a_of_type_Aqbs = new aqbs(this, paramaqbb);
    this.jdField_a_of_type_Aqbr = this.jdField_a_of_type_Aqbu;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aqbr.a;
  }
  
  public aqbr a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Aqbs;
    case 0: 
      return this.jdField_a_of_type_Aqbu;
    }
    return this.jdField_a_of_type_Aqbt;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Aqbr.a)
    {
      aqbr localaqbr = a(paramInt1);
      if (localaqbr != null)
      {
        this.jdField_a_of_type_Aqbr.a();
        this.jdField_a_of_type_Aqbr = localaqbr;
        this.jdField_a_of_type_Aqbr.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Aqbr.a;
    if ((!this.jdField_a_of_type_Aqbr.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Aqbr.a == 0);
    this.jdField_a_of_type_Aqbr.b();
    this.jdField_a_of_type_Aqbr = this.jdField_a_of_type_Aqbu;
    this.jdField_a_of_type_Aqbr.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbq
 * JD-Core Version:    0.7.0.1
 */