import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1;
import com.tencent.qphone.base.util.QLog;

public abstract class awft
{
  public int a;
  awfs a;
  public awfu a;
  public awfv a;
  public volatile boolean a;
  public int b = 1000 / this.jdField_a_of_type_Int;
  
  public awft()
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
  
  public void a(awfs paramawfs)
  {
    this.jdField_a_of_type_Awfs = paramawfs;
  }
  
  public void a(awfu paramawfu)
  {
    this.jdField_a_of_type_Awfu = paramawfu;
  }
  
  public void a(awfv paramawfv)
  {
    this.jdField_a_of_type_Awfv = paramawfv;
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
 * Qualified Name:     awft
 * JD-Core Version:    0.7.0.1
 */