import android.os.Message;

public class balx
  extends bamd
{
  private baiy jdField_a_of_type_Baiy;
  private bamm jdField_a_of_type_Bamm;
  
  public balx(bamm parambamm)
  {
    this.jdField_a_of_type_Bamm = parambamm;
  }
  
  public baiy a()
  {
    return this.jdField_a_of_type_Baiy;
  }
  
  public String a()
  {
    return balx.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Baiy = new baiy();
    this.jdField_a_of_type_Baiy.b(1);
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    if (this.jdField_a_of_type_Bamm != null)
    {
      this.jdField_a_of_type_Bamm.c(5);
      this.jdField_a_of_type_Bamm.a(paramMessage);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Baiy != null)
    {
      this.jdField_a_of_type_Baiy.a();
      this.jdField_a_of_type_Baiy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balx
 * JD-Core Version:    0.7.0.1
 */