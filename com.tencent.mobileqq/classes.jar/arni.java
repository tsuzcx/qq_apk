import com.tencent.qphone.base.util.QLog;

public class arni
{
  private arnj jdField_a_of_type_Arnj;
  private arnk jdField_a_of_type_Arnk;
  private arnl jdField_a_of_type_Arnl;
  private arnm jdField_a_of_type_Arnm;
  
  public arni(armn paramarmn)
  {
    this.jdField_a_of_type_Arnm = new arnm(this, paramarmn);
    this.jdField_a_of_type_Arnl = new arnl(this, paramarmn);
    this.jdField_a_of_type_Arnk = new arnk(this, paramarmn);
    this.jdField_a_of_type_Arnj = this.jdField_a_of_type_Arnm;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Arnj.a;
  }
  
  public arnj a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Arnk;
    case 0: 
      return this.jdField_a_of_type_Arnm;
    }
    return this.jdField_a_of_type_Arnl;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_Arnj.a)
    {
      arnj localarnj = a(paramInt1);
      if (localarnj != null)
      {
        this.jdField_a_of_type_Arnj.a();
        this.jdField_a_of_type_Arnj = localarnj;
        this.jdField_a_of_type_Arnj.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Arnj.a;
    if ((!this.jdField_a_of_type_Arnj.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
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
    } while (this.jdField_a_of_type_Arnj.a == 0);
    this.jdField_a_of_type_Arnj.b();
    this.jdField_a_of_type_Arnj = this.jdField_a_of_type_Arnm;
    this.jdField_a_of_type_Arnj.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arni
 * JD-Core Version:    0.7.0.1
 */