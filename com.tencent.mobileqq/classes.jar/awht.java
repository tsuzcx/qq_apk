import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.atomic.AtomicReference;

public class awht
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public AtomicReference<SVHwEncoder> a;
  private long b;
  
  public awht()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramLong;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    if (((this.b - this.jdField_a_of_type_Long) / awhs.jdField_a_of_type_Int == this.jdField_a_of_type_Int + 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null))
    {
      float f = (float)(paramLong2 * 1000.0D / paramLong1);
      ((SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(f, -1);
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awht
 * JD-Core Version:    0.7.0.1
 */