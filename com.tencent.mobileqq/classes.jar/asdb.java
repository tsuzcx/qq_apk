import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1;
import com.tencent.qphone.base.util.QLog;

public abstract class asdb
{
  public int a;
  asda a;
  public asdc a;
  public asdd a;
  public volatile boolean a;
  public int b = 1000 / this.jdField_a_of_type_Int;
  
  public asdb()
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
  
  public void a(asda paramasda)
  {
    this.jdField_a_of_type_Asda = paramasda;
  }
  
  public void a(asdc paramasdc)
  {
    this.jdField_a_of_type_Asdc = paramasdc;
  }
  
  public void a(asdd paramasdd)
  {
    this.jdField_a_of_type_Asdd = paramasdd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asdb
 * JD-Core Version:    0.7.0.1
 */