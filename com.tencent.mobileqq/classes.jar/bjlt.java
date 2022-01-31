import java.util.concurrent.atomic.AtomicInteger;

public class bjlt
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public int a;
  public bjlu a;
  private bjlv jdField_a_of_type_Bjlv;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicInteger b;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjlv != null)
    {
      this.jdField_a_of_type_Bjlv.a();
      return;
    }
    b();
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    bjlu localbjlu = this.jdField_a_of_type_Bjlu;
    if (paramInt == 1) {}
    for (;;)
    {
      localbjlu.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bjlu.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_a_of_type_Bjlu.b = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjlt
 * JD-Core Version:    0.7.0.1
 */