import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1;
import com.tencent.qphone.base.util.QLog;

public abstract class avls
{
  public int a;
  avlr a;
  public avlt a;
  public avlu a;
  public volatile boolean a;
  public int b = 1000 / this.jdField_a_of_type_Int;
  
  public avls()
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
  
  public void a(avlr paramavlr)
  {
    this.jdField_a_of_type_Avlr = paramavlr;
  }
  
  public void a(avlt paramavlt)
  {
    this.jdField_a_of_type_Avlt = paramavlt;
  }
  
  public void a(avlu paramavlu)
  {
    this.jdField_a_of_type_Avlu = paramavlu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avls
 * JD-Core Version:    0.7.0.1
 */