import com.tencent.qphone.base.util.QLog;

public class asro
{
  private asrp jdField_a_of_type_Asrp;
  private asrq jdField_a_of_type_Asrq;
  private asrr jdField_a_of_type_Asrr;
  private asrs jdField_a_of_type_Asrs;
  
  public asro(asqt paramasqt)
  {
    this.jdField_a_of_type_Asrs = new asrs(this, paramasqt);
    this.jdField_a_of_type_Asrr = new asrr(this, paramasqt);
    this.jdField_a_of_type_Asrq = new asrq(this, paramasqt);
    this.jdField_a_of_type_Asrp = this.jdField_a_of_type_Asrs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Asrp.a;
  }
  
  public asrp a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Asrq;
    case 0: 
      return this.jdField_a_of_type_Asrs;
    }
    return this.jdField_a_of_type_Asrr;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Asrp.a)
    {
      asrp localasrp = a(paramInt1);
      if (localasrp != null)
      {
        this.jdField_a_of_type_Asrp.a();
        this.jdField_a_of_type_Asrp = localasrp;
        this.jdField_a_of_type_Asrp.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Asrp.a;
    if ((!this.jdField_a_of_type_Asrp.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Asrp.a == 0);
    this.jdField_a_of_type_Asrp.b();
    this.jdField_a_of_type_Asrp = this.jdField_a_of_type_Asrs;
    this.jdField_a_of_type_Asrp.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asro
 * JD-Core Version:    0.7.0.1
 */