import com.tencent.qphone.base.util.QLog;

public class aojj
{
  private aojk jdField_a_of_type_Aojk;
  private aojl jdField_a_of_type_Aojl;
  private aojm jdField_a_of_type_Aojm;
  private aojn jdField_a_of_type_Aojn;
  
  public aojj(aoix paramaoix)
  {
    this.jdField_a_of_type_Aojn = new aojn(this, paramaoix);
    this.jdField_a_of_type_Aojm = new aojm(this, paramaoix);
    this.jdField_a_of_type_Aojl = new aojl(this, paramaoix);
    this.jdField_a_of_type_Aojk = this.jdField_a_of_type_Aojn;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aojk.a;
  }
  
  public aojk a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Aojl;
    case 0: 
      return this.jdField_a_of_type_Aojn;
    }
    return this.jdField_a_of_type_Aojm;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Aojk.a)
    {
      aojk localaojk = a(paramInt1);
      if (localaojk != null)
      {
        this.jdField_a_of_type_Aojk.a();
        this.jdField_a_of_type_Aojk = localaojk;
        this.jdField_a_of_type_Aojk.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Aojk.a;
    if ((!this.jdField_a_of_type_Aojk.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Aojk.a == 0);
    this.jdField_a_of_type_Aojk.b();
    this.jdField_a_of_type_Aojk = this.jdField_a_of_type_Aojn;
    this.jdField_a_of_type_Aojk.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojj
 * JD-Core Version:    0.7.0.1
 */