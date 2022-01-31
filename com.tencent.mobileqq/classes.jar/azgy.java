import java.util.concurrent.atomic.AtomicInteger;

public class azgy
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public int a;
  public azgz a;
  private azha jdField_a_of_type_Azha;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private AtomicInteger b = new AtomicInteger(0);
  
  public azgy(int paramInt)
  {
    this.jdField_a_of_type_Azgz = new azgz();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azha != null)
    {
      this.jdField_a_of_type_Azha.a();
      return;
    }
    c();
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    azgz localazgz = this.jdField_a_of_type_Azgz;
    if (paramInt == 1) {}
    for (;;)
    {
      localazgz.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Azgz.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_a_of_type_Azgz.b = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public void a(azha paramazha)
  {
    this.jdField_a_of_type_Azha = paramazha;
  }
  
  public int b()
  {
    return this.b.getAndSet(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int c()
  {
    return this.b.getAndAdd(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgy
 * JD-Core Version:    0.7.0.1
 */