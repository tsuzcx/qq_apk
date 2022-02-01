import java.util.concurrent.atomic.AtomicInteger;

public class brkr
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public int a;
  public brks a;
  private brkt jdField_a_of_type_Brkt;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicInteger b;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Brkt != null)
    {
      this.jdField_a_of_type_Brkt.a();
      return;
    }
    b();
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    brks localbrks = this.jdField_a_of_type_Brks;
    if (paramInt == 1) {}
    for (;;)
    {
      localbrks.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Brks.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_a_of_type_Brks.b = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public int b()
  {
    return this.b.getAndSet(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(0);
  }
  
  public int c()
  {
    return this.b.getAndAdd(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(1);
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brkr
 * JD-Core Version:    0.7.0.1
 */