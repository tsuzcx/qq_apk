import com.tencent.qphone.base.util.QLog;

public class asld
{
  private asle jdField_a_of_type_Asle;
  private aslf jdField_a_of_type_Aslf;
  private aslg jdField_a_of_type_Aslg;
  private aslh jdField_a_of_type_Aslh;
  
  public asld(askk paramaskk)
  {
    this.jdField_a_of_type_Aslh = new aslh(this, paramaskk);
    this.jdField_a_of_type_Aslg = new aslg(this, paramaskk);
    this.jdField_a_of_type_Aslf = new aslf(this, paramaskk);
    this.jdField_a_of_type_Asle = this.jdField_a_of_type_Aslh;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Asle.a;
  }
  
  public asle a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Aslf;
    case 0: 
      return this.jdField_a_of_type_Aslh;
    }
    return this.jdField_a_of_type_Aslg;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Asle.a)
    {
      asle localasle = a(paramInt1);
      if (localasle != null)
      {
        this.jdField_a_of_type_Asle.a();
        this.jdField_a_of_type_Asle = localasle;
        this.jdField_a_of_type_Asle.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Asle.a;
    if ((!this.jdField_a_of_type_Asle.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Asle.a == 0);
    this.jdField_a_of_type_Asle.b();
    this.jdField_a_of_type_Asle = this.jdField_a_of_type_Aslh;
    this.jdField_a_of_type_Asle.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asld
 * JD-Core Version:    0.7.0.1
 */