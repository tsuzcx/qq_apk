import com.tencent.qphone.base.util.QLog;

public class ansx
{
  private ansy jdField_a_of_type_Ansy;
  private ansz jdField_a_of_type_Ansz;
  private anta jdField_a_of_type_Anta;
  private antb jdField_a_of_type_Antb;
  
  public ansx(ansl paramansl)
  {
    this.jdField_a_of_type_Antb = new antb(this, paramansl);
    this.jdField_a_of_type_Anta = new anta(this, paramansl);
    this.jdField_a_of_type_Ansz = new ansz(this, paramansl);
    this.jdField_a_of_type_Ansy = this.jdField_a_of_type_Antb;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ansy.a;
  }
  
  public ansy a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_Ansz;
    case 0: 
      return this.jdField_a_of_type_Antb;
    }
    return this.jdField_a_of_type_Anta;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Ansy.a)
    {
      ansy localansy = a(paramInt);
      if (localansy != null)
      {
        this.jdField_a_of_type_Ansy.b();
        this.jdField_a_of_type_Ansy = localansy;
        this.jdField_a_of_type_Ansy.a();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_Ansy.a;
    if ((!this.jdField_a_of_type_Ansy.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
      QLog.e("LimitChatUiStateMachine", 2, "state " + i + " not handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, -1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Ansy.a == 0);
    this.jdField_a_of_type_Ansy.c();
    this.jdField_a_of_type_Ansy = this.jdField_a_of_type_Antb;
    this.jdField_a_of_type_Ansy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansx
 * JD-Core Version:    0.7.0.1
 */