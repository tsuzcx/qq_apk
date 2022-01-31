import com.tencent.qphone.base.util.QLog;

public class aojo
{
  private aojp jdField_a_of_type_Aojp;
  private aojq jdField_a_of_type_Aojq;
  private aojr jdField_a_of_type_Aojr;
  private aojs jdField_a_of_type_Aojs;
  
  public aojo(aojc paramaojc)
  {
    this.jdField_a_of_type_Aojs = new aojs(this, paramaojc);
    this.jdField_a_of_type_Aojr = new aojr(this, paramaojc);
    this.jdField_a_of_type_Aojq = new aojq(this, paramaojc);
    this.jdField_a_of_type_Aojp = this.jdField_a_of_type_Aojs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aojp.a;
  }
  
  public aojp a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Aojq;
    case 0: 
      return this.jdField_a_of_type_Aojs;
    }
    return this.jdField_a_of_type_Aojr;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Aojp.a)
    {
      aojp localaojp = a(paramInt1);
      if (localaojp != null)
      {
        this.jdField_a_of_type_Aojp.a();
        this.jdField_a_of_type_Aojp = localaojp;
        this.jdField_a_of_type_Aojp.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Aojp.a;
    if ((!this.jdField_a_of_type_Aojp.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Aojp.a == 0);
    this.jdField_a_of_type_Aojp.b();
    this.jdField_a_of_type_Aojp = this.jdField_a_of_type_Aojs;
    this.jdField_a_of_type_Aojp.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojo
 * JD-Core Version:    0.7.0.1
 */