import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1;
import com.tencent.qphone.base.util.QLog;

public abstract class atyk
{
  public int a;
  atyj a;
  public atyl a;
  public atym a;
  public volatile boolean a;
  public int b = 1000 / this.jdField_a_of_type_Int;
  
  public atyk()
  {
    this.jdField_a_of_type_Int = 8;
    g();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = (1000 / paramInt);
  }
  
  public void a(atyj paramatyj)
  {
    this.jdField_a_of_type_Atyj = paramatyj;
  }
  
  public void a(atyl paramatyl)
  {
    this.jdField_a_of_type_Atyl = paramatyl;
  }
  
  public void a(atym paramatym)
  {
    this.jdField_a_of_type_Atym = paramatym;
  }
  
  public void c() {}
  
  public void d()
  {
    f();
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      new Thread(new MagicfaceDecoder.1(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagicfaceDecoder", 2, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atyk
 * JD-Core Version:    0.7.0.1
 */